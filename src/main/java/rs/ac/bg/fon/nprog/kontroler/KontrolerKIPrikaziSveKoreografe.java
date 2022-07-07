package rs.ac.bg.fon.nprog.kontroler;

import java.util.ArrayList;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Koreograf;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.koreograf.FormaPrikaziSveKoreografe;
import rs.ac.bg.fon.nprog.modeli.ModelTabeleKoreografi;

public class KontrolerKIPrikaziSveKoreografe extends OpstiKontrolerKI{

    public KontrolerKIPrikaziSveKoreografe(OpstaEkranskaForma oef) {
        this.oef=oef;
    }
    

    @Override
    public void pretvoriGrafickiUDomenski() {
        FormaPrikaziSveKoreografe forma = (FormaPrikaziSveKoreografe) oef;
        Koreograf koreograf = (Koreograf) ado;
        koreograf.setIme(forma.getTxtIme().getText());
        koreograf.setPrezime(forma.getTxtPrezime().getText());
        if(forma.getCbKlasican().isSelected()){
            koreograf.setSpecijalizovanost("Klasican balet");
        }else if(forma.getCbModeran().isSelected()){
            koreograf.setSpecijalizovanost("Moderan balet");
        }else if(forma.getCbJazz().isSelected()){
            koreograf.setSpecijalizovanost("Jazz balet");
        }
    }

    @Override
    public void pretvoriDomenskiUGraficki() {
        FormaPrikaziSveKoreografe forma = (FormaPrikaziSveKoreografe) oef;
        ModelTabeleKoreografi model = (ModelTabeleKoreografi) forma.getTblKoreografi().getModel();
        for (ApstraktniDomenskiObjekat opstiDomenskiObjekat : lista) {
            Koreograf koreograf = (Koreograf) opstiDomenskiObjekat;
            model.dodaj(koreograf);
        }
    }

    @Override
    public void ocistiFormu() {
        FormaPrikaziSveKoreografe forma = (FormaPrikaziSveKoreografe) oef;
        ModelTabeleKoreografi model = (ModelTabeleKoreografi) forma.getTblKoreografi().getModel();
        model.setListaKoreografa(new ArrayList<Koreograf>());
    }

    public void pripremiTabelu() {
        FormaPrikaziSveKoreografe forma = (FormaPrikaziSveKoreografe) oef;
        ModelTabeleKoreografi model = new ModelTabeleKoreografi();
        forma.getTblKoreografi().setModel(model);
    }

    public void napuniTabelu() {
        FormaPrikaziSveKoreografe forma = (FormaPrikaziSveKoreografe) oef;
        ModelTabeleKoreografi model = (ModelTabeleKoreografi) forma.getTblKoreografi().getModel();
        for (ApstraktniDomenskiObjekat ado : lista) {
            Koreograf koreograf = (Koreograf) ado;
            model.dodaj(koreograf);
        }
    }

    public Koreograf vratiKoreografa() throws Exception {
        FormaPrikaziSveKoreografe forma = (FormaPrikaziSveKoreografe) oef;
        ModelTabeleKoreografi model = (ModelTabeleKoreografi) forma.getTblKoreografi().getModel();
        if (forma.getTblKoreografi().getSelectedRow() == -1) {
            throw new Exception("Niste izabrali red za promenu");
        }
        Koreograf koreograf=model.getListaKoreografa().get(forma.getTblKoreografi().getSelectedRow());
        return koreograf;
    }

    public void azuriraj(Koreograf koreograf) {
        FormaPrikaziSveKoreografe forma = (FormaPrikaziSveKoreografe) oef;
        ModelTabeleKoreografi model = (ModelTabeleKoreografi) forma.getTblKoreografi().getModel();
        model.azurirajKoreografa(koreograf);
    }

}

