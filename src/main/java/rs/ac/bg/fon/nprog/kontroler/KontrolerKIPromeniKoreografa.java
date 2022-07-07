package rs.ac.bg.fon.nprog.kontroler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Koreograf;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.koreograf.FormaPromeniKoreografa;

public class KontrolerKIPromeniKoreografa extends OpstiKontrolerKI{

    public KontrolerKIPromeniKoreografa(OpstaEkranskaForma oef, Koreograf koreograf) {
        this.oef=oef;
        ado=koreograf;
    }

    
    @Override
    public void pretvoriGrafickiUDomenski() {
        Koreograf koreograf = (Koreograf) ado;
        FormaPromeniKoreografa forma = (FormaPromeniKoreografa) oef;
        if ((forma.getTxtId().getText()).length() > 0) {
            koreograf.setKoreografId(Long.parseLong(forma.getTxtId().getText()));
        }
        koreograf.setIme(forma.getTxtIme().getText());
        koreograf.setPrezime(forma.getTxtPrezime().getText());
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        try {
            koreograf.setDatumRodjenja(sdf.parse(forma.getTxtDatumRodjenja().getText()));
        } catch (ParseException ex) {
            ex.printStackTrace();
            Logger.getLogger(KontrolerKIKreirajKoreografa.class.getName()).log(Level.SEVERE, null, ex);
        }
        koreograf.setEmail(forma.getTxtEmail().getText());
        koreograf.setBrojTelefona(forma.getTxtBrTelefona().getText());
        koreograf.setSpecijalizovanost((String)forma.getCmbSpecijalizovanost().getSelectedItem());

    }

    @Override
    public void pretvoriDomenskiUGraficki() {
        Koreograf koreograf = (Koreograf) ado;
        FormaPromeniKoreografa forma = (FormaPromeniKoreografa) oef;
        forma.getTxtId().setText(koreograf.getKoreografId()+ "");
        forma.getTxtIme().setText(koreograf.getIme());
        forma.getTxtPrezime().setText(koreograf.getPrezime());
        SimpleDateFormat sdf1=new SimpleDateFormat("dd.MM.yyyy");
        forma.getTxtDatumRodjenja().setText(sdf1.format(koreograf.getDatumRodjenja()));
        forma.getTxtEmail().setText(koreograf.getEmail());
        forma.getTxtBrTelefona().setText(koreograf.getBrojTelefona());
        forma.getCmbSpecijalizovanost().setSelectedItem(koreograf.getSpecijalizovanost());
    }

    @Override
    public void ocistiFormu() {
        FormaPromeniKoreografa forma = (FormaPromeniKoreografa) oef;
        forma.getTxtId().setText("");
        forma.getTxtIme().setText("");
        forma.getTxtPrezime().setText("");
        forma.getTxtDatumRodjenja().setText("");
        forma.getTxtEmail().setText("");
        forma.getTxtBrTelefona().setText("");
        forma.getCmbSpecijalizovanost().setSelectedIndex(0);
    }

    

    public ApstraktniDomenskiObjekat getAdo() {
        return ado;
    }
    
    
}

