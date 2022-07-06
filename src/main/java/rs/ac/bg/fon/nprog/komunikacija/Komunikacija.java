package rs.ac.bg.fon.nprog.komunikacija;

import java.net.Socket;

public class Komunikacija {
	
	static Komunikacija instanca;
    Socket socket;
    
    private Komunikacija() {

    }
    
    public static Komunikacija getInstanca() {
        if (instanca == null) {
            instanca = new Komunikacija();
        }
        return instanca;
    }



    public void setSocket(Socket socket) {
        this.socket = socket;
    }
 
    
}
