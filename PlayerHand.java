import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Representation of a player hand of cards
 * A player hand contains an ArrayList of Card objects
 * PlayerHand object extends a CardPile object
 * @Joe Pakulski
 */
public class PlayerHand extends CardPile
{ 
   /**
   * Adds a card to the hand
   * Adds a card object to the arraylist
   */
   public void addHand(Card c)
   {
     pile.add(c);
   }
}