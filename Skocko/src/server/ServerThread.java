/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import commonskocko.CommonSkocko;
import java.awt.List;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import repository.DataBaseBroker;

/**
 *
 * @author Ljubomir
 */
public class ServerThread extends Thread {
    int nest;
    ArrayList<CommonSkocko> igra;
    ObjectInputStream in;
    ObjectOutputStream out;
    int brojac;
    CommonSkocko resenje;
    DataBaseBroker dbb;
    
    
    public ServerThread(CommonSkocko skocko) {
        
        igra = new ArrayList<>();
        resenje = skocko;
    }

    

    

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("awaiting connection");
            Socket clientSocket = ss.accept();
            System.out.println("Client connected !");
            in = new ObjectInputStream(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());

            while (!isInterrupted()) {
                CommonSkocko cm = (CommonSkocko) in.readObject();
                cm.setPogodjeniNaMestu(cm.getPogodjeniNaMestu(resenje));
                cm.setPogodjeniNisuNaMestu(cm.getPogodjeniNisuNaMestu(resenje));
                if(cm.pobedioJe()){
                    cm.setTacanNiz(true);
                    
                    
                }
                if(brojac == 5){
                    cm.setPoslednja(true);
                    
                
                }
                
                out.writeObject(cm);
                igra.add(cm);
                
                brojac++;
                

            }
            in.close();
            out.close();
            clientSocket.close();
            ss.close();
           

        } catch (Exception e) {
        }

    }

    public ArrayList<CommonSkocko> getIgra() {
        return igra;
    }

}
