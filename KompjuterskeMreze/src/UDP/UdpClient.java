package UDP;
import java.io.*;
import java.net.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class UdpClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Unesite broj jedan!:");
		Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
 
        // loopuje dok se ne unese "bye"
        while (true) {
        	try {
             int inp = sc.nextInt();
            
            // convert the String input into the byte array.
            buf = Integer.toString(inp).getBytes();
        	
            // Konsturkor za slanje podataka
            DatagramPacket DpSend =new DatagramPacket(buf, buf.length, ip, 53);
  
            //Salje podatke
            ds.send(DpSend);
          //now receive reply
			//buffer to receive incoming data
			byte[] buffer2 = new byte[65536];
			DatagramPacket reply = new DatagramPacket(buffer2, buffer2.length);
			ds.receive(reply);
			
			byte[] data = reply.getData();
			String s = new String(data, 0, reply.getLength());
			
			System.out.println((s+" ( " +reply.getAddress().getHostAddress() + reply.getPort()+" ) " ));
           
        	}
        	 catch(InputMismatchException e){
         		System.out.println("Nijeste unijeli broj");
         		break;
         		
         	}
        }
	}

}
