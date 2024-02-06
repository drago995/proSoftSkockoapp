/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientskocko;

import commonskocko.CommonSkocko;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ljubomir
 */
public class Controller {
    private static Controller instance;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    
    private Controller() throws Exception {
        socket = new Socket("localhost", 9000);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    
    }
    
    public static Controller getInstance() throws Exception {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public CommonSkocko posalji(CommonSkocko skocko) throws ClassNotFoundException {
       try {
            out.writeObject(skocko);
            CommonSkocko receivedSkocko = (CommonSkocko) in.readObject();
            return receivedSkocko;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return null; // Handle the exception accordingly
        }
    }

}
