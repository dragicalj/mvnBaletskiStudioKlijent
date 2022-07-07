package rs.ac.bg.fon.nprog.kontroler;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.nprog.domen.Administrator;
import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Koreograf;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.komunikacija.Komunikacija;
import rs.ac.bg.fon.nprog.transfer.Odgovor;
import rs.ac.bg.fon.nprog.transfer.Operacije;
import rs.ac.bg.fon.nprog.transfer.TipOdgovora;
import rs.ac.bg.fon.nprog.transfer.Zahtev;

public abstract class OpstiKontrolerKI {
	
	protected ApstraktniDomenskiObjekat ado;
    protected OpstaEkranskaForma oef;
    protected List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

    public OpstiKontrolerKI() {
    }

    abstract public void pretvoriGrafickiUDomenski();

    abstract public void pretvoriDomenskiUGraficki();
    
    public boolean SOLogin() {
        ado = oef.kreirajObjekat();
        pretvoriGrafickiUDomenski();
        Zahtev zahtev = new Zahtev(Operacije.LOGIN, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                ado = (Administrator) odgovor.getRezultat();
                System.out.println(ado);
                Komunikacija.getInstanca().setTrenutniAdministrator((Administrator) ado);
                oef.dispose();
                return true;
            } else {
                JOptionPane.showMessageDialog(oef, "Neuspesno prijavljivanje!", "Greska", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Neuspesno prijavljivanje!", "Greska", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public void SOKreirajKoreografa() {
        ado = oef.kreirajObjekat();
        pretvoriGrafickiUDomenski();
        Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_KOREOGRAFA, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                ado = (Koreograf) odgovor.getRezultat();
                pretvoriDomenskiUGraficki();
                JOptionPane.showMessageDialog(oef, "Sistem je kreirao koreografa");
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da kreira koreografa", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da kreira koreografa", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    public abstract void ocistiFormu();

   
}