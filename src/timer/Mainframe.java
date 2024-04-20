/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author koyrsos
 */
public class Mainframe extends JFrame {
    JLabel msg=new JLabel("         Πατήστε έναρξη για να αρχήσει ο χρόνος!");
    JButton startbut=new JButton("Έναρξη");
    JLabel msg1=new JLabel("");
  
    public Mainframe() {
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(420, 190);
       setTitle("Πρόγγραμμα Ενδυνάμωσης");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        this.setResizable(false);
        JPanel startpanel=new JPanel(new FlowLayout());
        startpanel.add(startbut);
          add(msg,BorderLayout.CENTER);
        add(startpanel,BorderLayout.SOUTH);
      msg1.setVisible(false);
       add(msg1,BorderLayout.NORTH);
        
        startbut.setForeground(Color.GREEN);

        startbut.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               startbut.setEnabled(false);
              
               hit(0,1);
           }
       });   
    }       
    private void  hit(int counter,int shots) {
         new Thread( new Runnable() {

           @Override
           public void run() {
               int sec=0,rnd=-1;
               boolean flag=false;
                long start = System.currentTimeMillis();
         
        while (true)
        {
                  
            if(counter==0 && shots<=10){
                rnd=1;
                sec=15;
                flag=false;
                msg1.setVisible(true);
                msg1.setText("<html><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspΑριθμός&nbspΓύρου : 1<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspΒολές&nbsp&nbsp&nbsp&nbsp&nbspΓύρου : "+shots+"/10</html>");
                if(shots==10){
                    flag=true;
                  rnd=2;
                }
            }
            else if(counter==2 && shots<=5){
                rnd=2;
                sec=20;
                flag=false;
                msg1.setVisible(true);
                msg1.setText("<html><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspΑριθμός&nbspΓύρου : 2<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspΒολές&nbsp&nbsp&nbsp&nbsp&nbspΓύρου : "+shots+"/5</html>");
                     if(shots==5){
                         flag=true;
                  rnd=3;
                }
            }
            else if(counter==4 && shots<=5){
                rnd=3;
                flag=false;
                sec=40;
                 msg1.setVisible(true);
                msg1.setText("<html><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspΑριθμός&nbspΓύρου : 3<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspΒολές&nbsp&nbsp&nbsp&nbsp&nbspΓύρου : "+shots+"/5</html>");
                 if(shots==5){
                         flag=true;
                  rnd=4;
                }
            }
            else if(counter==6 && shots==3){
                rnd=4;
                flag=false;
                sec=60;
                 msg1.setVisible(true);
                msg1.setText("<html><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspΑριθμός&nbspΓύρου : 4<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspΒολές&nbsp&nbsp&nbsp&nbsp&nbspΓύρου : "+shots+"/3</html>");
                     if(shots==3){
                         flag=true;
                  rnd=5;
                }
            }
            else if(counter==8 && shots==5){
                rnd=5;
                flag=false;
                sec=30;
                 msg1.setVisible(true);
                msg1.setText("<html><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspΑριθμός&nbspΓύρου : 5<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspΒολές&nbsp&nbsp&nbsp&nbsp&nbspΓύρου : "+shots+"/5</html>");
                     if(shots==5){
                         flag=true;
                  rnd=6;
                }
            }
            else if(counter==10 && shots==5){
                rnd=6;
                flag=false;
                sec=15;
                 msg1.setVisible(true);
                msg1.setText("<html><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspΑριθμός&nbspΓύρου : 6<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspΒολές&nbsp&nbsp&nbsp&nbsp&nbspΓύρου : "+shots+"/5</html>");
                     if(shots==5){
                         flag=true;
                  rnd=7;
                }
            }
            else if(counter==12 && rnd==7){
               
                break;
            }
            long time = System.currentTimeMillis() - start;
            int seconds=sec-((int) (time / 998));
           if(seconds<0){break; }
            SwingUtilities.invokeLater(new Runnable() {
                 public void run()
                 {
                       if(seconds>5){
                     msg.setText("<html>&nbsp&nbsp&nbsp&nbspΔευτερόλεπτα που απομένουν για την Σκόπευση : <font size='6'>"+seconds+"</font></html>" );
                       }
                     else{
                   msg.setText("<html>&nbsp&nbsp&nbsp&nbspΔευτερόλεπτα που απομένουν για την Σκόπευση : <font size='6' color='red'>"+seconds+"</font></html>" );
                     }
                 }
            });
            try { Thread.sleep(998); } catch(Exception e) {}
            
             if(seconds==0){
                 if(flag){rest(counter+1,0,rnd);
                 }
                 else{
                     rest(counter+1,shots,rnd);
                 }
         }
            
        }//end while 
             }
           
       }).start();
       }
    
    private void  rest(int counter,int shots,int rnd) {
     
         new Thread( new Runnable() {

           @Override
           public void run() {
               int sec=0;
                long start = System.currentTimeMillis();
              
        while (true)
        {   
            if(counter==1 && shots<=10){
                sec=15;
                msg1.setVisible(false);
            
            }
            else if(counter==3 && shots<=5){
                sec=20;
                msg1.setVisible(false);
            }
            else if(counter==5 && shots<=5){
                sec=40;
                msg1.setVisible(false);
            }
            else if(counter==7 &&shots<=3){
                sec=60;
                msg1.setVisible(false);
            }
            else if(counter==9 && shots<=5){
                sec=45;
                msg1.setVisible(false);
            }
            else if(counter==11 && shots<=5){
                sec=30;
                msg1.setVisible(false);
            }
            else if(counter==13){
               startbut.setEnabled(true);
                break;
            }
            
            long time = System.currentTimeMillis() - start;
            int seconds=sec-((int) (time / 998));
           if(seconds<0){break; }
            SwingUtilities.invokeLater(new Runnable() {
                 public void run()
                 {
                       if(seconds>5){
                     msg.setText("<html>&nbsp&nbsp&nbsp&nbspΔευτερόλεπτα που απομένουν για ξεκούραση : <font size='6'>"+seconds+"</font></html>" );
                       }
                     else{
                   msg.setText("<html>&nbsp&nbsp&nbsp&nbspΔευτερόλεπτα που απομένουν για ξεκούραση : <font size='6' color='red'>"+seconds+"</font></html>" );
                     }
                 }
            });
            try { Thread.sleep(998); } catch(Exception e) {}
            
             if(seconds==0){
                 System.out.println(rnd);
                 if(shots<=10 && rnd==1){
                      hit(0,shots+1);
                    }
                 else if(shots<=5 && rnd==2){
                     hit(2, shots+1);               
                 }
                 else if(shots<=5 && rnd==3){
                     hit(4, shots+1);               
                 }
                 else if(shots<=3 && rnd==4){
                     hit(6, shots+1);               
                 }
                 else if(shots<=5 && rnd==5){
                     hit(8, shots+1);               
                 }
                 else if(shots<=5 && rnd==6){
                     hit(10, shots+1);               
                 }   
         } 
        }
           }
       }).start();
    
    }
    
    
}
