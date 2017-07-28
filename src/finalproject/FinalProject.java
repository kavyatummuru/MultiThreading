
package finalproject;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class FinalProject extends JFrame{
    public JPanel p,q;
    public JButton s;    
    public Display d; 
     String s_h = "";  
    String s_t = ""; 
    int h_x = 120;
    int h_y = 110;
    int t_x = 120;
    int t_y = 210;
    int wh;
    int wt;
    
    moving mo;
    
    ImageIcon hare=new ImageIcon("Hare.gif");
    ImageIcon tortise =new ImageIcon("Turtle.gif");
    ImageIcon carrot =new ImageIcon("carrot.gif");
    public FinalProject() {
		  setTitle("Hare and Tortise");
		  setSize(1300, 700);
                  mo = new moving(this);
		  addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e)
		  { System.exit(0); }
	      });
                  getContentPane().setLayout(new BorderLayout());
                   d = new Display();
                  getContentPane().add(BorderLayout.CENTER, d);
                  JPanel q = new JPanel();
                  getContentPane().add(BorderLayout.NORTH, q);
                 s = new JButton("start");
                 q.add(s);
                   Handler handler = new Handler();
   		s.addActionListener(handler);
    }
    
    public class Display extends Canvas{

	public void paint(Graphics g)
   	{
   		g.setColor(Color.RED);
                g.drawLine(200, 100, 1100, 100);
                g.drawLine(200, 200, 1100, 200); 
                g.drawLine(200, 300, 1100, 300);
                for(int i=200;i<1101;i=i+18)
                {
                    g.drawLine(i, 100, i, 300);
                }
                 g.drawString(s_h, 20,20);
                 g.drawString(s_t, 20, 40);
                 if(wt==1&&wh==0)
                  {
                      
                      g.setColor(Color.RED);
                      g.drawString("Tortoise won the race!!! ",300,400);
                      tortise.paintIcon(this,g,700, 500);
                      carrot.paintIcon(this,g,800, 500);
                       Thread.currentThread().stop();
                      
                 }
                  if(wh==1&&wt==0)
                  {
                      
                      g.setColor(Color.RED);
                      g.drawString("Hare won the race!!!!",300,600);
                       hare.paintIcon(this,g,700, 500);
                      carrot.paintIcon(this,g,800, 500);
                      Thread.currentThread().stop();
                   }
                 
               hare.paintIcon(this, g, h_x, h_y);
		tortise.paintIcon(this, g, t_x, t_y);
        }
}
   public void move(int x, int y, int track)
       	
           {
            if(track == 1){
             	h_x = x;
             	h_y = y;               
               s_h = "hare is at "+h_x;

		}

            if(track == 2){
             	t_x = x;
             	t_y = y;

               s_t = "Tortise is at "+t_x;

                 }
            if((t_x==1100)&&(h_x!=1100))
            {
                wt=1;
                 s_t="tortise won";
                 Thread.currentThread().interrupt();
               //  tortise.paintIcon(this, g, 800, 500);
                 
                 
            }
            if((h_x==1100)&&(t_x!=1100))
            {
                wh=1;
                s_h="hare won";
                 Thread.currentThread().interrupt();
               // hare.paintIcon(this, g, 800, 500);
            }
          d.repaint();
          
           }
   
 public static void main(String[] args) {
       FinalProject theFrame = new FinalProject();
	theFrame.show();
    }
   
 
class Handler implements ActionListener{


	public void actionPerformed(ActionEvent e)
         {

         	  if (e.getSource() == s)
                {
                    
                  race r1 = new race(1,mo);
                  r1.start();
                  race r2 = new race(2,mo);
                  r2.start();
                }
           
         }
    } //end  handler
 
}  

