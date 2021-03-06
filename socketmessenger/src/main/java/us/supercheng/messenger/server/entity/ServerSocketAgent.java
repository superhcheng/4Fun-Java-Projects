package us.supercheng.messenger.server.entity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Vector;

/**
 * Created by hongyu on 6/29/17.
 */
public class ServerSocketAgent implements Runnable {
    DataOutputStream dataOut;
    DataInputStream dataIn;
    Socket clientSocket;
    Vector<Socket> otherClients;

    public ServerSocketAgent(Socket inClientSocketAgent, Vector<Socket> inOtherClients) throws Exception{
        this.clientSocket = inClientSocketAgent;
        this.dataOut = new DataOutputStream(this.clientSocket.getOutputStream());
        this.dataIn = new DataInputStream(this.clientSocket.getInputStream());
        this.otherClients = inOtherClients;
    }

    public void run() {
        while(true){
            try{
                String eachNewMsg = this.dataIn.readUTF();
                System.out.println("Server Received: " + eachNewMsg);
                for(Socket eachSocket : this.otherClients){
                    this.dataOut = new DataOutputStream(eachSocket.getOutputStream());
                    this.dataOut.writeUTF(eachNewMsg);
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

    }
}