/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author lpotte
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        int port = 3000;
        InetAddress ip = InetAddress.getByName("localhost");
        
        // Establecer la conexion con el servidor
        Socket ciente = new Socket (ip, port);
        System.out.println("Cliente en linea");
        
        BufferedReader line = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("Digite: ");
        String msm;
        
        DataInputStream h = new DataInputStream (ciente.getInputStream());
        do{
            msm = line.readLine();
            DataOutputStream out = new DataOutputStream(ciente.getOutputStream());
            out.writeUTF (msm);
            System.out.println(""+h.readUTF());
        }while(!msm.equals("fin"));
        
       
        System.out.println("Mensaje enviado");
        
        ciente.close();
    }
    
}
