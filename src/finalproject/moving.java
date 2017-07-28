
package finalproject;

public class moving {
    
   private boolean lock_h = true;	//enforces two trains cannot be on track a
    private boolean lock_t = true;
    
    FinalProject frame;
    public moving(FinalProject fr){ frame = fr;}
    
    public void moving(int track, int x, int y){
//     //REQUIRES: track, x and y not be null
//     //EFFECTS: calls appropriate "engine" method to drive the train on track
//
     if(track == 1)
         moving_h(track,x,y); 
     if(track == 2)
         moving_t(track,x,y);
     
    }
    public void moving_h(int track, int x, int y){
     	//REQUIRES: track, x and y not be null
     	//EFFECTS: sets train moving on track a1
 
     	h_start();
      //these start/stop methods drive the thread
      //they control concurrent track requirements

     	go(track,x,y); //actual method that drives movement
     	h_stop();
     }
    public synchronized void h_start(){
     //EFFECTS: if the track is unlocked, it starts train moving on track a1
     //else it waits while the track is locked
     while ((!lock_h)&&(lock_t)){
        try{
              wait();
            }
        catch(InterruptedException e)
           {System.out.println("Interrupted Exception"); }
        }

        lock_h = false;
		    notifyAll();

   }

 public synchronized void h_stop(){
     //EFFECTS: notifies all waiting threads that track a1 is now available
        lock_h = true;
        notifyAll();

   }
 
 public void moving_t(int track, int x, int y){
      //REQUIRES: track, x and y not be null
     	//EFFECTS: sets train moving on track b1
     t_start();
     go(track,x,y);
     t_stop();
     }

  public synchronized void t_start(){
     //EFFECTS: if the track is unlocked, it starts train moving on track b1
     //else it waits while the track is locked
     while ((!lock_t)&&(lock_h)){

        try{
              wait();
            }
        catch(InterruptedException e)
           {System.out.println("Interrupted Exception"); }
        }

        lock_t = false;
        
		    notifyAll();

     }



   public synchronized void t_stop(){
      //EFFECTS: notifies all waiting threads that track b1 is now available
        lock_t = true;
   
        notifyAll();
   }
 
 
  public void go(int track, int x, int y){
   	  //REQUIRES: track, x and y not be null
      //MODIFIES: x and y
   	  //EFFECTS: drives the trains movements
//      double t=Math.random()*10;
//       while(t>1)
//          {
//              t=Math.random()*10;  
//          }
//       if(t==0)
//           track=1;
//       else
//           track=2;
      
        if(track == 1){
                        y=110;
                       while (x<= 1100){
                           double n=Math.random();
//                           while(n>4)
//                           {
//                              n=Math.random()*10;  
//                           }
                           if(n<=0.2)
                               x=x;
                           else if((n>0.2)&&(n<=0.4))
                               x=x+(7*18); 
                           else if((n>0.4)&&(n<=0.5))
                               x=x-(10*18);
                           else if((n>0.5)&&(n<=0.8))
                               x=x+18;
                           else if(n>0.8)
                             x = x-(2*18);
                           System.out.println(n);
                           if(x<140)
                               x=140;
                           if(x>1100)
                               x=1100;
                           
                         frame.move(x,y,track);
                         try{
                               Thread.sleep(200);
                             }
                         catch(Exception e)
                            {System.err.println("Exception");}
                         }
                       
                       

                } //end if

             if(track == 2){
                 y=210;
                 while(x<= 1100)
                 { 
                     double n=Math.random();
//                           while(n>2)
//                           {
//                              n=Math.random()*10;  
//                           }
                           if(n<=0.5)
                               x=x+(2*18);
                           else if((n>0.5)&&(n<=0.7))
                               x=x-(4*18);
                           else if((n>0.7))
                               x=x+18;
                           
                           if(x<120)
                               x=120;
                           if(x>1100)
                               x=1100;
                   
                         frame.move(x,y,track);
                         try{
                               Thread.sleep(200);
                             }
                         catch(Exception e)
                            {System.err.println("Exception");}
                         }
                  
                 }//end if

        
        }//end go
}

 


