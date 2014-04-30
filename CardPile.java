import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Representation of a pile of cards
 * A card pile contains an ArrayList of Card objects
 * @Joe Pakulski
 */
public class CardPile
{ 

   ArrayList<Card> pile;
   public CardPile()
   {
    pile = new ArrayList<Card>();
   }
   
   /**
   * Deals a card from the deck
   * Removes a card from the deck and returns it
   * @return c a card object
   */     
   public Card dealCard()
   {
      Card c = pile.remove(0);  //  remove it (returns removed object)
      return c;
   }
   
   /**
   * Counts the cards in the deck
   * @return size of the deck
   */
   public int cardsRemaining()
   {  
      return pile.size();
   }

}
