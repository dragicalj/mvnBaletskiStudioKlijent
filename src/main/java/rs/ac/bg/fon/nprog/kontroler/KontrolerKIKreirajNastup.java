package rs.ac.bg.fon.nprog.kontroler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Lokacija;
import rs.ac.bg.fon.nprog.domen.Nastup;
import rs.ac.bg.fon.nprog.domen.TipNastupa;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.nastup.FormaKreirajNastup;

public class KontrolerKIKreirajNastup extends OpstiKontrolerKI {

    public KontrolerKIKreirajNastup(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void pretvoriGrafickiUDomenski() {
        Nastup nastup = (Nastup) ado;
        FormaKreirajNastup forma = (FormaKreirajNastup) oef;
        if ((forma.getTxtNastupId().getText()).length() > 0) {
            nastup.setNastupId(Long.parseLong(forma.getTxtNastupId().getText()));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            nastup.setDatumVremeNastupa(sdf.parse(forma.getTxtDatumNastupa().getText()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(forma, "Datum mora biti u formatu dd.MM.yyyy");
            ex.printStackTrace();
            Logger.getLogger(KontrolerKIKreirajKoreografa.class.getName()).log(Level.SEVERE, null, ex);
        }
        nastup.setLokacija((Lokacija) forma.getCmbLokacija().getSelectedItem());
        nastup.setTipNastupa((TipNastupa) forma.getCmbTipNastupa().getSelectedItem());
    }

    @Override
    public void pretvoriDomenskiUGraficki() {
        Nastup nastup = (Nastup) ado;
        FormaKreirajNastup forma = (FormaKreirajNastup) oef;
        forma.getTxtNastupId().setText(nastup.getNastupId() + "");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy");
        forma.getTxtDatumNastupa().setText(sdf1.format(nastup.getDatumVremeNastupa()));
        forma.getCmbTipNastupa().setSelectedItem(nastup.getTipNastupa());
        forma.getCmbLokacija().setSelectedItem(nastup.getLokacija());
    }

    @Override
    public void ocistiFormu() {
        FormaKreirajNastup forma = (FormaKreirajNastup) oef;
        forma.getTxtNastupId().setText("");
        forma.getTxtDatumNastupa().setText("");
        forma.getCmbTipNastupa().setSelectedIndex(0);
        forma.getCmbLokacija().setSelectedItem(0);
    }

    public void popuniLokacije() {
        List<ApstraktniDomenskiObjekat> listaLokacija;
        FormaKreirajNastup forma = (FormaKreirajNastup) oef;
        forma.getCmbLokacija().removeAllItems();
        try {
            SOUcitajListuLokacija();
            listaLokacija = lista;
            for (ApstraktniDomenskiObjekat lokacija : listaLokacija) {
                forma.getCmbLokacija().addItem((Lokacija) lokacija);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da vrati listu lokacija");
        }
    }

    public void popuniTipNastupa() {
        FormaKreirajNastup forma = (FormaKreirajNastup) oef;
        forma.getCmbTipNastupa().removeAllItems();
        forma.getCmbTipNastupa().addItem(TipNastupa.KONCERT);
        forma.getCmbTipNastupa().addItem(TipNastupa.TAKMICENJE);
        forma.getCmbTipNastupa().addItem(TipNastupa.KARNEVAL);

    }

}
