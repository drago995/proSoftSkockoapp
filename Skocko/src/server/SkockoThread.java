/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import javax.swing.JLabel;

/**
 *
 * @author Ljubomir
 */
public class SkockoThread extends Thread {
    
    private  JLabel labelNumber1;
    private  JLabel labelNumber2;
    private  JLabel labelNumber3;
     private  JLabel labelNumber4;

    public SkockoThread(JLabel labelNumber1, JLabel labelNumber2, JLabel labelNumber3, JLabel labelNumber4) {
        this.labelNumber1 = labelNumber1;
        this.labelNumber2 = labelNumber2;
        this.labelNumber3 = labelNumber3;
        this.labelNumber4 = labelNumber4;
    }
    
    
    
    @Override
    public void run() {
        try {
            while (!isInterrupted()) {

                long prvi = Math.round(Math.random() * 9);
                long drugi = Math.round(Math.random() * 9);
                long treci = Math.round(Math.random() * 9);
                long cetvrti = Math.round(Math.random() * 9);
                labelNumber1.setText(String.valueOf(prvi));
                labelNumber2.setText(String.valueOf(drugi));
                labelNumber3.setText(String.valueOf(treci));
                labelNumber4.setText(String.valueOf(cetvrti));
                sleep(100);
            }

        } catch (InterruptedException ie) {
            System.out.println("Interrupted");
        }

    }

    public void stopThread() {
        interrupt();

    }

}
