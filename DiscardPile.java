import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

public class DiscardPile extends CardPile
{  
  public void addPile(Card c)
   {
     pile.add(c);
   }
   
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