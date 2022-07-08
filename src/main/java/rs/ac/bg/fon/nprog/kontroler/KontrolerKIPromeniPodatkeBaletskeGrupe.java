package rs.ac.bg.fon.nprog.kontroler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.BaletskaGrupa;
import rs.ac.bg.fon.nprog.domen.Koreograf;
import rs.ac.bg.fon.nprog.domen.TipGrupe;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.baletskagrupa.FormaPromeniPodatkeBaletskeGrupe;

public class KontrolerKIPromeniPodatkeBaletskeGrupe extends OpstiKontrolerKI{

    public KontrolerKIPromeniPodatkeBaletskeGrupe(OpstaEkranskaForma oef, BaletskaGrupa baletskaGrupa) {
        this.oef=oef;
        this.ado=baletskaGrupa;
    }
    
    
    @Override
    public void pretvoriGrafickiUDomenski() {
        BaletskaGrupa baletskaGrupa = (BaletskaGrupa) ado;
        FormaPromeniPodatkeBaletskeGrupe forma = (FormaPromeniPodatkeBaletskeGrupe) oef;
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        if ((forma.getTxtBaletskaGrupaId().getText()).length() > 0) {
        baletskaGrupa.setBaletskaGrupaId(Long.parseLong(forma.getTxtBaletskaGrupaId().getText()));
        }
        baletskaGrupa.setNazivGrupe(forma.getTxtNazivGrupe().getText());
        baletskaGrupa.setTipGrupe((TipGrupe) forma.getCmbTipGrupe().getSelectedItem());
        //baletskaGrupa.setDatumNastanka(new Date(0));
        baletskaGrupa.setKapacitet(Integer.parseInt(forma.getTxtKapacitet().getText()));
        baletskaGrupa.setKoreograf((Koreograf) forma.getCmbKoreograf().getSelectedItem());
        try {
            baletskaGrupa.setDatumNastanka(sdf.parse(forma.getTxtDatumNastanka().getText()));
        } catch (ParseException ex) {
            Logger.getLogger(KontrolerKIPromeniPodatkeBaletskeGrupe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void pretvoriDomenskiUGraficki() {
        BaletskaGrupa baletskaGrupa = (BaletskaGrupa) ado;
        FormaPromeniPodatkeBaletskeGrupe forma = (FormaPromeniPodatkeBaletskeGrupe) oef;
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        forma.getTxtBaletskaGrupaId().setText(baletskaGrupa.getBaletskaGrupaId()+ "");
        forma.getCmbTipGrupe().setSelectedItem(baletskaGrupa.getTipGrupe());
        forma.getTxtKapacitet().setText(baletskaGrupa.getKapacitet()+"");
        forma.getCmbKoreograf().setSelectedItem(baletskaGrupa.getKoreograf());
        forma.getTxtNazivGrupe().setText(baletskaGrupa.getNazivGrupe()+"");
        forma.getTxtDatumNastanka().setText(sdf.format(baletskaGrupa.getDatumNastanka()));
    }

    @Override
    public void ocistiFormu() {
        FormaPromeniPodatkeBaletskeGrupe forma = (FormaPromeniPodatkeBaletskeGrupe) oef;
        forma.getTxtBaletskaGrupaId().setText("");
        forma.getTxtNazivGrupe().setText("");
        forma.getCmbTipGrupe().setSelectedIndex(0);
        forma.getTxtKapacitet().setText("");
        forma.getCmbKoreograf().setSelectedItem(0);
    }

    public void popuniTipGrupe() {
       FormaPromeniPodatkeBaletskeGrupe forma = (FormaPromeniPodatkeBaletskeGrupe) oef;
       forma.getCmbTipGrupe().removeAllItems();
       forma.getCmbTipGrupe().addItem(TipGrupe.Mini);
       forma.getCmbTipGrupe().addItem(TipGrupe.Junior);
       forma.getCmbTipGrupe().addItem(TipGrupe.Senior);
    }

    public void popuniKoreografe() {
        List<ApstraktniDomenskiObjekat> listaKoreografa;
        FormaPromeniPodatkeBaletskeGrupe forma = (FormaPromeniPodatkeBaletskeGrupe) oef;
        forma.getCmbKoreograf().removeAllItems();
        try {
            SOUcitajListuKoreografa();
            listaKoreografa = lista;
            for (ApstraktniDomenskiObjekat koreograf : listaKoreografa) {
                forma.getCmbKoreograf().addItem((Koreograf) koreograf);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da vrati listu koreografa");
        }
    }

    public ApstraktniDomenskiObjekat getAdo() {
        return ado;
    }

    
}
