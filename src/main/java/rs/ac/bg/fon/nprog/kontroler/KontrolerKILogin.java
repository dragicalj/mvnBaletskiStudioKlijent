package rs.ac.bg.fon.nprog.kontroler;

import rs.ac.bg.fon.nprog.domen.Administrator;
import rs.ac.bg.fon.nprog.forme.FormaLogin;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;

public class KontrolerKILogin extends OpstiKontrolerKI{
	
	public KontrolerKILogin(OpstaEkranskaForma oef) {
        this.oef=oef;
    }

    @Override
    public void pretvoriGrafickiUDomenski() {
        Administrator administrator = (Administrator) ado;
        FormaLogin frmLogin = (FormaLogin) oef;
        administrator.setKorisnickoIme(frmLogin.getTxtKorisnickoIme().getText());
        administrator.setLozinka(String.valueOf(frmLogin.getTxtLozinka().getPassword()));
    }

    @Override
    public void pretvoriDomenskiUGraficki() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
