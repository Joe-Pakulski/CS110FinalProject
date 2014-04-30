import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

public class CardPile
{ 
  final int CARDS_IN_DECK = 52;

   ArrayList<Card> pile;
   public CardPile()
   {
    pile = new ArrayList<Card>();
   }
        
   public Card dealCard()
   {
      Card c = pile.remove(0);  //  remove it (returns removed object)
      return c;
   }
   
   public int cardsRemaining()
   {  
      return pile.size();
   }

}
