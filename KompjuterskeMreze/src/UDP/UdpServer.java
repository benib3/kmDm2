package UDP;

import java.io.IOException;
import java.net.*;
import java.io.*;
public class UdpServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        DatagramSocket ds = new DatagramSocket(53);
        byte[] receive = new byte[65535];
        DatagramPacket DpReceive = null;
     
        while (true){
          DpReceive = new DatagramPacket(receive, receive.length);
          
          System.out.println("Server je pokrenut...");
            // Prima podatke
            ds.receive(DpReceive);
            String dataReceived=data(receive);
            if(Integer.parseInt(dataReceived)%2==0) {
            	//System.out.println("Broj je paran: "+dataReceived);
            	dataReceived = "Broj je paran:  " + dataReceived;
				DatagramPacket dp = new DatagramPacket(dataReceived.getBytes() ,dataReceived.getBytes().length , DpReceive.getAddress() , DpReceive.getPort());
				ds.send(dp);
            	
            }else if(Integer.parseInt(dataReceived)%2!=0){
            	//System.out.println("Broj nijeparan: "+dataReceived);
            	dataReceived = "Broj nije paran:  " + dataReceived;
				DatagramPacket dp = new DatagramPacket(dataReceived.getBytes() , dataReceived.getBytes().length ,DpReceive.getAddress() , DpReceive.getPort());
				ds.send(dp);
            }
  
            receive = new byte[65535];
        }
       
       
    }
  
    public static String data(byte[] a){
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret.toString();
    
		
	}

}
