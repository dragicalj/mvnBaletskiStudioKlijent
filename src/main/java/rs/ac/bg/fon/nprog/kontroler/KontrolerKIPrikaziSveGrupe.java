package rs.ac.bg.fon.nprog.kontroler;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.BaletskaGrupa;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.baletskagrupa.FormaPrikaziSveBaletskeGrupe;
import rs.ac.bg.fon.nprog.modeli.ModelTabeleBaletskeGrupe;

public class KontrolerKIPrikaziSveGrupe extends OpstiKontrolerKI {

    public KontrolerKIPrikaziSveGrupe(OpstaEkranskaForma oef) {
        this.oef = oef;
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
        FormaPrikaziSveBaletskeGrupe forma = (FormaPrikaziSveBaletskeGrupe) oef;
        ModelTabeleBaletskeGrupe model = new ModelTabeleBaletskeGrupe();
        forma.getTblGrupe2().setModel(model);
    }

    public void napuniTabelu() {
        FormaPrikaziSveBaletskeGrupe forma = (FormaPrikaziSveBaletskeGrupe) oef;
        ModelTabeleBaletskeGrupe model = (ModelTabeleBaletskeGrupe) forma.getTblGrupe2().getModel();
        for (ApstraktniDomenskiObjekat ado : lista) {
            BaletskaGrupa baletskaGrupa = (BaletskaGrupa) ado;
            model.dodaj(baletskaGrupa);
        }
    }

    public BaletskaGrupa vratiBaletskuGrupu() throws Exception {
        FormaPrikaziSveBaletskeGrupe forma = (FormaPrikaziSveBaletskeGrupe) oef;
        ModelTabeleBaletskeGrupe model = (ModelTabeleBaletskeGrupe) forma.getTblGrupe2().getModel();
        if (forma.getTblGrupe2().getSelectedRow() == -1) {
            throw new Exception("Niste izabrali red za promenu");
        }
        BaletskaGrupa baletskaGrupa = model.getListaGrupa().get(forma.getTblGrupe2().getSelectedRow());
        return baletskaGrupa;
    }

    public void azuriraj(BaletskaGrupa baletskaGrupa) {
        FormaPrikaziSveBaletskeGrupe forma = (FormaPrikaziSveBaletskeGrupe) oef;
        ModelTabeleBaletskeGrupe model = (ModelTabeleBaletskeGrupe) forma.getTblGrupe2().getModel();
        model.azurirajBaletskuGrupu(baletskaGrupa);
    }

}
