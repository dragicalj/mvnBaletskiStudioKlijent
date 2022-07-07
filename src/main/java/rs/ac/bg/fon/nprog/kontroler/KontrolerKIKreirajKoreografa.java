package rs.ac.bg.fon.nprog.kontroler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import rs.ac.bg.fon.nprog.domen.Koreograf;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.koreograf.FormaKreirajKoreografa;

public class KontrolerKIKreirajKoreografa extends OpstiKontrolerKI{

    public KontrolerKIKreirajKoreografa(OpstaEkranskaForma oef) {
        this.oef=oef;
    }
    
    @Override
    public void pretvoriGrafickiUDomenski() {
        FormaKreirajKoreografa forma = (FormaKreirajKoreografa)oef;
        Koreograf koreograf = (Koreograf) ado;
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
        FormaKreirajKoreografa forma = (FormaKreirajKoreografa) oef;
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
        FormaKreirajKoreografa formaKK = (FormaKreirajKoreografa) oef;
        formaKK.getTxtId().setText("");
        formaKK.getTxtIme().setText("");
        formaKK.getTxtPrezime().setText("");
        formaKK.getTxtDatumRodjenja().setText("");
        formaKK.getTxtEmail().setText("");
        formaKK.getTxtBrTelefona().setText("");
        formaKK.getCmbSpecijalizovanost().setSelectedIndex(0);
    }


    
    
}
