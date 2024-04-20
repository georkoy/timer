/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import java.io.IOException;

/**
 *
 * @author koyrsos
 */
public class Timer {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException  {
          
    new Mainframe().setVisible(true);
       /*      
     new Thread(new Runnable() {
  // The wrapper thread is unnecessary, unless it blocks on the
  // Clip finishing; see comments.
    public void run() {
      try {
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
        this.getClass().getResourceAsStream("beep10.wav"));
        clip.open(inputStream);
        clip.start(); 
      } catch (Exception e) {
        System.err.println(e.getMessage()+"  "+e);
      }
    }
  }).start();*/
        
        
    }
    }
