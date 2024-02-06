/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientskocko;

import javax.swing.JLabel;

/**
 *
 * @author Ljubomir
 */
public class NumberThread extends Thread {

    JLabel label;
    public NumberThread(JLabel jLabel1) {
        label = jLabel1;
    }

    

    

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {

                long prvi = Math.round(Math.random() * 9);

                label.setText(String.valueOf(prvi));
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
