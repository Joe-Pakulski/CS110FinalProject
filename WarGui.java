import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;


public class WarGui extends JFrame 
{
  private JPanel PlayerPanel1; private JPanel PlayerPanel2;
  private JPanel ComputerPanel1; private JPanel ComputerPanel2;
  private JPanel CounterPanel1; private JPanel CounterPanel2;
  private JPanel CounterPanel3; private JPanel CounterPanel4;
  private JPanel MessagePanel; private JPanel ButtonPanel; private JPanel blank;
  
  private ImageIcon back = new ImageIcon("back.jpg");//Back of the Card imageIcon
  private JLabel PlayerHand = new JLabel(back); //Player Hand Image
  private JLabel ComputerHand = new JLabel(back);//Computer Hand Image
  private JLabel PlayerCard = new JLabel(back);//Player Card Image
  private JLabel ComputerCard = new JLabel(back);//Computer Card Image
  private JLabel Counter1 = new JLabel("Cards in hand: 0"); private JLabel Counter2 = new JLabel("Cards in discard: 0");
  private JLabel Counter3 = new JLabel("Cards in hand: 0"); private JLabel Counter4 = new JLabel("Cards in discard: 0");
  private JLabel Message = new JLabel("Press Play to Start"); private JButton Play; private JButton NewGame;
  
  PlayerHand hand1; PlayerHand hand2;
  DiscardPile pile1; DiscardPile pile2; DiscardPile warPile;
  private boolean over = false; private boolean war = false;
  
  /*
  * A gui for the game of war
  * it has 9 panels and a button
  *
  */
  public WarGui()
  {
    setTitle("War Card Game");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new GridLayout(3,4));
    
    //Build the Panels
    buildCardPanels();
    buildCounterPanels();
    buildButton();
    
    add(PlayerPanel1);
    add(PlayerPanel2);
    add(ComputerPanel1);
    add(ComputerPanel2);
    
    add(CounterPanel1);
    add(CounterPanel2);
    add(CounterPanel3);
    add(CounterPanel4);
    
    add(blank);
    add(MessagePanel);
    add(ButtonPanel);
    
    pack();
    setVisible(true);
    
  }
  
  /**
   * Builds the card panels of the gui
   * add each image to the panel
   */
  public void buildCardPanels()
  {
   PlayerPanel1 = new JPanel();
   PlayerPanel1.add(PlayerHand);
   PlayerPanel2 = new JPanel();
   PlayerPanel2.add(PlayerCard);
   ComputerPanel1 = new JPanel();
   ComputerPanel1.add(ComputerCard);
   ComputerPanel2 = new JPanel();
   ComputerPanel2.add(ComputerHand);
   //A blank panel to clean up the guis interface
   blank = new JPanel();
  }
  
   /**
   * Builds the counter panels of the gui
   * add each counter to the panel
   */
  public void buildCounterPanels()
  {
   CounterPanel1 = new JPanel();
   CounterPanel1.add(Counter1);
   CounterPanel2 = new JPanel();
   CounterPanel2.add(Counter2);
   CounterPanel3 = new JPanel();
   CounterPanel3.add(Counter3);
   CounterPanel4 = new JPanel();
   CounterPanel4.add(Counter4);
  }
  
  /**
   * Builds the button and message panels of the gui
   * add the message and button to the panels
   */
  public void buildButton()
  {
   MessagePanel = new JPanel();
   MessagePanel.add(Message);
   
   ButtonPanel = new JPanel();
   Play = new JButton("Play");
   NewGame = new JButton("New Game");
   NewGame.addActionListener(new ButtonListener1());
   Play.addActionListener(new ButtonListener2());
   ButtonPanel.add(NewGame);
  }

  /**
   * This is the button to create a new game
   * it creates a fresh deck and deals the cards to the two players
   * it sets the counters, adds the play button
   */
  class ButtonListener1 implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      //Start by creating a new game
      final int CARDS_IN_DECK = 52;
      //hand 1 is player hand2 is computer
      hand1 = new PlayerHand();
      hand2 = new PlayerHand();
      pile1 = new DiscardPile();
      pile2 = new DiscardPile();
      warPile = new DiscardPile();
      Deck d = new Deck(); 
      for (int i =0; i<CARDS_IN_DECK/2; i++)
      {
       hand1.addHand(d.dealCard());
       hand2.addHand(d.dealCard());
      }
      Counter1.setText("Cards in hand: " + hand1.cardsRemaining());
      Counter2.setText("Cards in hand: " + pile1.cardsRemaining());
      Counter3.setText("Cards in hand: " + pile2.cardsRemaining());
      Counter4.setText("Cards in hand: " + hand2.cardsRemaining());
      Message.setText("New Game Created");
      ButtonPanel.remove(NewGame);
      ButtonPanel.add(Play);
      pack();
     }
     
  }

  /**
   * This is the button to play the game
   * it simulates a game of war
   * and depending on game conditions plays out the game
   */
  class ButtonListener2 implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
     if(hand1.cardsRemaining() <= 1)
     {
      if(pile1.cardsRemaining() == 0 || war == true)
      {
        Message.setText("You Lose");
        ButtonPanel.remove(Play);
        over = true;
      }
      else
      {
        pile1.toHand(hand1);
      }
     }
     if(hand2.cardsRemaining() <= 1)
     {
      if(pile2.cardsRemaining() == 0 || war == true)
      {
        Message.setText("You Won");
        ButtonPanel.remove(Play);
        over = true;
      }
      else
      {
        pile2.toHand(hand2);
      }
     } 
    if(over == false)
    {
     if(war == false)
      {
       Card c1 = hand1.dealCard();
       Card c2 = hand2.dealCard();
       ImageIcon cardImage1 = new ImageIcon(c1.getImage());
       ImageIcon cardImage2 = new ImageIcon(c2.getImage());
       PlayerCard.setIcon(cardImage1);
       ComputerCard.setIcon(cardImage2);
       if(c1.getRank() > c2.getRank())
       {
        pile1.addPile(c1);
        pile1.addPile(c2);
        Message.setText("Player Takes");
       }
       else if(c1.getRank() < c2.getRank())
       {
        pile2.addPile(c1);
        pile2.addPile(c2);
        Message.setText("Computer Takes");
       }
       else
       {
        Message.setText("War Occuring");
        war = true;
        Card c3 = hand1.dealCard();
        Card c4 = hand2.dealCard();
        warPile.addPile(c1);
        warPile.addPile(c2);
        warPile.addPile(c3);
        warPile.addPile(c4);
       }
      }
     else
      {
       Card c1 = hand1.dealCard();
       Card c2 = hand2.dealCard();
       ImageIcon cardImage1 = new ImageIcon(c1.getImage());
       ImageIcon cardImage2 = new ImageIcon(c2.getImage());
       PlayerCard.setIcon(cardImage1);
       ComputerCard.setIcon(cardImage2);
       if(c1.getRank() > c2.getRank())
       {
        pile1.addPile(c1);
        pile1.addPile(c2);
        warPile.toHand(hand1);
        war = false;
        Message.setText("Player Takes");
       }
       else if(c1.getRank() < c2.getRank())
       {
        pile2.addPile(c1);
        pile2.addPile(c2);
        warPile.toHand(hand2);
        war = false;
        Message.setText("Computer Takes");
       }
       else
       {
        Message.setText("War Occuring");
        war = true;
        Card c3 = hand1.dealCard();
        Card c4 = hand2.dealCard();
        warPile.addPile(c1);
        warPile.addPile(c2);
        warPile.addPile(c3);
        warPile.addPile(c4);
       }
     }
       Counter1.setText("Cards in hand: " + hand1.cardsRemaining());
       Counter2.setText("Cards in discard: " + pile1.cardsRemaining());
       Counter3.setText("Cards in discard: " + pile2.cardsRemaining());
       Counter4.setText("Cards in hand: " + hand2.cardsRemaining());
    }
      pack();
     }
    }
     
 /**
 * Main method
 * Runs the War Gui
 */
 public static void main(String [] args)
   {
    new WarGui();
   }
   
}