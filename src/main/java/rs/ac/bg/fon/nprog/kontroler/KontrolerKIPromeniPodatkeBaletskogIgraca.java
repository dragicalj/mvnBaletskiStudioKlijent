package rs.ac.bg.fon.nprog.kontroler;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.BaletskaGrupa;
import rs.ac.bg.fon.nprog.domen.BaletskiIgrac;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.baletskiigrac.FormaPromeniPodatkeBaletskogIgraca;

public class KontrolerKIPromeniPodatkeBaletskogIgraca extends OpstiKontrolerKI{

    public KontrolerKIPromeniPodatkeBaletskogIgraca(OpstaEkranskaForma oef, BaletskiIgrac baletskiIgrac) {
        this.oef=oef;
        ado=baletskiIgrac;
    }
    
    

    @Override
    public void pretvoriGrafickiUDomenski() {
        BaletskiIgrac baletskiIgrac = (BaletskiIgrac) ado;
        FormaPromeniPodatkeBaletskogIgraca forma = (FormaPromeniPodatkeBaletskogIgraca) oef;
        if (!"".equals(forma.getTxtIgracId().getText())) {
            baletskiIgrac.setBaletskiIgracId(Long.parseLong(forma.getTxtIgracId().getText()));
        }
        baletskiIgrac.setIme(forma.getTxtIme().getText());
        baletskiIgrac.setPrezime(forma.getTxtPrezime().getText());
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        try {
            baletskiIgrac.setDatumRodjenja(sdf.parse(forma.getTxtDatumRodjenja().getText()));
        } catch (ParseException ex) {
            ex.printStackTrace();
            Logger.getLogger(KontrolerKIKreirajKoreografa.class.getName()).log(Level.SEVERE, null, ex);
        }
        baletskiIgrac.setEmail(forma.getTxtEmail().getText());
        baletskiIgrac.setBrojTelefona(forma.getTxtBrojTelefona().getText());
        baletskiIgrac.setBrojTelefonaRoditelja(forma.getTxtBrojTelefonaRoditelja().getText());
        baletskiIgrac.setTrenutnaClanarina(new  BigDecimal(forma.getTxtTrenutnaClanarina().getText()));
        //baletskiIgrac.setDatumUpisa(baletskiIgrac.getDatumUpisa());
        SimpleDateFormat sdf1=new SimpleDateFormat("dd.MM.yyyy");
        try {
            baletskiIgrac.setDatumUpisa(sdf1.parse(forma.getTxtDatumUpisa().getText()));
        } catch (ParseException ex) {
            ex.printStackTrace();
            Logger.getLogger(KontrolerKIKreirajKoreografa.class.getName()).log(Level.SEVERE, null, ex);
        }
        baletskiIgrac.setBaletskaGrupa((BaletskaGrupa)forma.getCmbBaletskeGrupe().getSelectedItem());
    }

    @Override
    public void pretvoriDomenskiUGraficki() {
        BaletskiIgrac baletskiIgrac = (BaletskiIgrac) ado;
        FormaPromeniPodatkeBaletskogIgraca forma = (FormaPromeniPodatkeBaletskogIgraca) oef;
        forma.getTxtIgracId().setText(baletskiIgrac.getBaletskiIgracId()+ "");
        forma.getTxtIme().setText(baletskiIgrac.getIme());
        forma.getTxtPrezime().setText(baletskiIgrac.getPrezime());
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        forma.getTxtDatumRodjenja().setText(sdf.format(baletskiIgrac.getDatumRodjenja()));
        forma.getTxtEmail().setText(baletskiIgrac.getEmail());
        forma.getTxtBrojTelefona().setText(baletskiIgrac.getBrojTelefona());
        forma.getTxtBrojTelefonaRoditelja().setText(baletskiIgrac.getBrojTelefonaRoditelja());
        forma.getTxtTrenutnaClanarina().setText(String.valueOf(baletskiIgrac.getTrenutnaClanarina()));
        SimpleDateFormat sdf1=new SimpleDateFormat("dd.MM.yyyy");
        forma.getTxtDatumUpisa().setText(sdf1.format(baletskiIgrac.getDatumUpisa()));
        forma.getCmbBaletskeGrupe().setSelectedItem(baletskiIgrac.getBaletskaGrupa());
    }

    @Override
    public void ocistiFormu() {
        FormaPromeniPodatkeBaletskogIgraca forma = (FormaPromeniPodatkeBaletskogIgraca) oef;
        forma.getTxtIgracId().setText("");
        forma.getTxtIme().setText("");
        forma.getTxtPrezime().setText("");
        forma.getTxtDatumRodjenja().setText("");
        forma.getTxtEmail().setText("");
        forma.getTxtBrojTelefona().setText("");
        forma.getTxtBrojTelefonaRoditelja().setText("");
        forma.getTxtTrenutnaClanarina().setText("");
        forma.getTxtDatumUpisa().setText("");
        forma.getCmbBaletskeGrupe().setSelectedIndex(0);
    }

    public ApstraktniDomenskiObjekat getAdo() {
        return ado;
    }

    public void popuniGrupe() {
        List<ApstraktniDomenskiObjekat> listaGrupa;
        FormaPromeniPodatkeBaletskogIgraca forma = (FormaPromeniPodatkeBaletskogIgraca) oef;
        forma.getCmbBaletskeGrupe().removeAllItems();
        try {
            SOUcitajListuBaletskihGrupa();
            listaGrupa = lista;
            for (ApstraktniDomenskiObjekat grupa : listaGrupa) {
                forma.getCmbBaletskeGrupe().addItem((BaletskaGrupa) grupa);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da vrati listu baletskih grupa");
        }
    }

    

   
    
}

