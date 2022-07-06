package rs.ac.bg.fon.nprog.komunikacija;

import java.net.Socket;

import rs.ac.bg.fon.nprog.domen.Administrator;
import rs.ac.bg.fon.nprog.transfer.Odgovor;
import rs.ac.bg.fon.nprog.transfer.Posiljalac;
import rs.ac.bg.fon.nprog.transfer.Primalac;
import rs.ac.bg.fon.nprog.transfer.Zahtev;

public class Komunikacija {
	
	static Komunikacija instanca;
    Socket socket;
    
    Administrator trenutniAdministrator;

    private Komunikacija() {

    }
    
    public static Komunikacija getInstanca() {
        if (instanca == null) {
            instanca = new Komunikacija();
        }
        return instanca;
    }


    public Administrator getTrenutniAdministrator() {
		return trenutniAdministrator;
	}

	public void setTrenutniAdministrator(Administrator trenutniAdministrator) {
		this.trenutniAdministrator = trenutniAdministrator;
	}

	public void setSocket(Socket socket) {
        this.socket = socket;
    }
 
    public Odgovor pozivSo(Zahtev zahtev) throws Exception {
        new Posiljalac(socket).posalji(zahtev);
        return (Odgovor) new Primalac(socket).primi();
    }
}
