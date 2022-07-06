package rs.ac.bg.fon.nprog.start;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import rs.ac.bg.fon.nprog.komunikacija.Komunikacija;

public class Start {
	
	 public static void main(String[] args) {
	        try {
	            Socket socket = new Socket("localhost", 8000);
	            
	            Komunikacija.getInstanca().setSocket(socket);

	        } catch (IOException ex) {
	            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
}
