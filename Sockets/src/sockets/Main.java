/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lpotte
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int port = 3000;
        int backlog = 0;
        InetAddress ip = InetAddress.getByName("localhost");
        ServerSocket server = new ServerSocket (port, backlog,ip);
        
        Socket cliente = server.accept();
        System.out.println("Cliente dentro");
        
        DataInputStream dis = new DataInputStream (cliente.getInputStream());
        String mensaje;
        
        DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
        do{
            mensaje = dis.readUTF();
            System.out.println("EL cliente dijo: "+ mensaje);
            out.writeUTF ("Mensaje recibido");
        }while(!mensaje.equals("fin"));
        
        cliente.close();
        server.close();
        System.out.println("Servidor finalizado");
    }
    
}
