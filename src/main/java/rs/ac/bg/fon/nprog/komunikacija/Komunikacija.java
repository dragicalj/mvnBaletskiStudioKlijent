package rs.ac.bg.fon.nprog.komunikacija;

import java.net.Socket;

import rs.ac.bg.fon.nprog.transfer.Odgovor;
import rs.ac.bg.fon.nprog.transfer.Posiljalac;
import rs.ac.bg.fon.nprog.transfer.Primalac;
import rs.ac.bg.fon.nprog.transfer.Zahtev;

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
 
    public Odgovor pozivSo(Zahtev zahtev) throws Exception {
        new Posiljalac(socket).posalji(zahtev);
        return (Odgovor) new Primalac(socket).primi();
    }
}
