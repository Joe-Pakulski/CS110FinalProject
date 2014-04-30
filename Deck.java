import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Representation of a deck of 52 standard playing card. 
 * A deck consists of 52 card objects.
 * @Joe Pakulski
 */

public class Deck
{
   final int CARDS_IN_DECK = 52;

   ArrayList<Card> deck;
   public Deck()
   {
            freshDeck();
   }
    /**
   * Creates a new deck.
   * @param deck to a new deck
   */
   public void freshDeck()
   {
      deck = new ArrayList<Card>();
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
           String str = "c" + r + s + ".jpg";
           deck.add(new Card(r,s,str));
         }
      }
     shuffle();
   
   }
   public Card dealCard()
   {
      Card c = deck.remove(0);  //  remove it (returns removed object)
      return c;
   }
   public int cardsRemaining()
   {  
      return deck.size();
   }
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }
    }

}