import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Representation of a discard pile of cards
 * A discard pile contains an ArrayList of Card objects
 * DiscardPile object extends a CardPile object
 * @Joe Pakulski
 */
public class DiscardPile extends CardPile
{  
  public void addPile(Card c)
   {
     pile.add(c);
   }
  
  /**
   * Shuffles the pile and deal to a hand
   * Removes card objects from the DiscardPile object
   * and adds them to a PlayerHand object
   */  
  public void toHand(PlayerHand h)
  {
   shuffle();
   int s = pile.size();
   for (int i =0; i<s; i++)
   {
    Card c = pile.remove(0);
    h.addHand(c);
   }
  }
  
  /**
   * shuffles the deck
   * randomizes the order of the cards in deck
   */
  public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < pile.size(); i++)
      {
         randNum = r.nextInt(pile.size());
         temp = pile.get(i);
         pile.set(i,pile.get(randNum));
        pile.set(randNum,temp);
      }
    }
}