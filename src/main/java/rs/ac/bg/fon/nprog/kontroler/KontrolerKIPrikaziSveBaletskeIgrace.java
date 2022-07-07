package rs.ac.bg.fon.nprog.kontroler;

import java.util.ArrayList;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.BaletskiIgrac;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.baletskiigrac.FormaPrikaziSveBaletskeIgrace;
import rs.ac.bg.fon.nprog.modeli.ModelTabeleBaletskiIgraci;

public class KontrolerKIPrikaziSveBaletskeIgrace extends OpstiKontrolerKI {

    public KontrolerKIPrikaziSveBaletskeIgrace(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void pretvoriGrafickiUDomenski() {
        FormaPrikaziSveBaletskeIgrace forma = (FormaPrikaziSveBaletskeIgrace) oef;
        BaletskiIgrac baletskiIgrac = (BaletskiIgrac) ado;
        baletskiIgrac.setIme(forma.getTxtIme().getText());
        baletskiIgrac.setPrezime(forma.getTxtPrezime().getText());
    }

    @Override
    public void pretvoriDomenskiUGraficki() {
        FormaPrikaziSveBaletskeIgrace forma = (FormaPrikaziSveBaletskeIgrace) oef;
        ModelTabeleBaletskiIgraci model = (ModelTabeleBaletskiIgraci) forma.getTblIgraci().getModel();
        for (ApstraktniDomenskiObjekat opstiDomenskiObjekat : lista) {
            BaletskiIgrac baletskiIgrac = (BaletskiIgrac) opstiDomenskiObjekat;
            model.dodaj(baletskiIgrac);
        }
    }

    @Override
    public void ocistiFormu() {
        FormaPrikaziSveBaletskeIgrace forma = (FormaPrikaziSveBaletskeIgrace) oef;
        ModelTabeleBaletskiIgraci model = (ModelTabeleBaletskiIgraci) forma.getTblIgraci().getModel();
        model.setListaIgraca(new ArrayList<BaletskiIgrac>());
    }

    public void pripremiTabelu() {
        FormaPrikaziSveBaletskeIgrace forma = (FormaPrikaziSveBaletskeIgrace) oef;
        ModelTabeleBaletskiIgraci model = new ModelTabeleBaletskiIgraci();
        forma.getTblIgraci().setModel(model);
    }

    public void napuniTabelu() {
        FormaPrikaziSveBaletskeIgrace forma = (FormaPrikaziSveBaletskeIgrace) oef;
        ModelTabeleBaletskiIgraci model = (ModelTabeleBaletskiIgraci) forma.getTblIgraci().getModel();
        for (ApstraktniDomenskiObjekat ado : lista) {
            BaletskiIgrac baletskiIgrac = (BaletskiIgrac) ado;
            model.dodaj(baletskiIgrac);
        }
    }

    public void azuriraj(BaletskiIgrac baletskiIgrac) {
        FormaPrikaziSveBaletskeIgrace forma = (FormaPrikaziSveBaletskeIgrace) oef;
        ModelTabeleBaletskiIgraci model = (ModelTabeleBaletskiIgraci) forma.getTblIgraci().getModel();
        model.azurirajBaletskogIgraca(baletskiIgrac);
    }

    public BaletskiIgrac vratiBaletskogIgraca() throws Exception {
        FormaPrikaziSveBaletskeIgrace forma = (FormaPrikaziSveBaletskeIgrace) oef;
        ModelTabeleBaletskiIgraci model = (ModelTabeleBaletskiIgraci) forma.getTblIgraci().getModel();
        if (forma.getTblIgraci().getSelectedRow() == -1) {
            throw new Exception("Niste izabrali red za promenu");
        }
        BaletskiIgrac baletskiIgrac = model.getListaIgraca().get(forma.getTblIgraci().getSelectedRow());
        return baletskiIgrac;
    }

}

