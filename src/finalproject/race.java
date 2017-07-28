
package finalproject;


public class race extends Thread {
    private int x;
   private int y;
   private int track;
   moving m;
   public race(int tr, moving m1 ){
     //EFFECTS: initializes a train thread
           track = tr;
           m = m1;
           if(track == 1) {x = 140; y = 110;}
           if(track == 2) {x = 120; y = 210;}
          
            }


   public void  run(){
     //EFFECTS: runs a train thread

            m.moving(track,x,y);
            }


}

