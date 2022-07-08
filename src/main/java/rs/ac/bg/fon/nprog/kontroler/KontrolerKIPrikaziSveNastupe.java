package rs.ac.bg.fon.nprog.kontroler;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Nastup;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.nastup.FormaPrikaziSveNastupe;
import rs.ac.bg.fon.nprog.modeli.ModelTabeleNastupi;

public class KontrolerKIPrikaziSveNastupe extends OpstiKontrolerKI{

    public KontrolerKIPrikaziSveNastupe(OpstaEkranskaForma oef) {
        this.oef=oef;
    }
    
    

    @Override
    public void pretvoriGrafickiUDomenski() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pretvoriDomenskiUGraficki() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ocistiFormu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void pripremiTabelu() {
        FormaPrikaziSveNastupe forma = (FormaPrikaziSveNastupe) oef;
        ModelTabeleNastupi model = new ModelTabeleNastupi();
        forma.getTblNastupi().setModel(model);
    }

    public void napuniTabelu() {
        FormaPrikaziSveNastupe forma = (FormaPrikaziSveNastupe) oef;
        ModelTabeleNastupi model = (ModelTabeleNastupi) forma.getTblNastupi().getModel();
        for (ApstraktniDomenskiObjekat ado : lista) {
            Nastup nastup = (Nastup) ado;
            model.dodaj(nastup);
        }
    }

    
    
}
