package rs.ac.bg.fon.nprog.kontroler;

import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.BaletskaGrupa;
import rs.ac.bg.fon.nprog.domen.BaletskaGrupaNastup;
import rs.ac.bg.fon.nprog.domen.Nastup;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.baletskagrupa.FormaZakaziNastupeBaletskojGrupi;
import rs.ac.bg.fon.nprog.modeli.ModelTabeleGrupaNastup;

public class KontrolerKIZakaziNastupeBaletskojGrupi extends OpstiKontrolerKI{

    public KontrolerKIZakaziNastupeBaletskojGrupi(OpstaEkranskaForma oef, BaletskaGrupa baletskaGrupa) {
        this.oef=oef;
        ado=baletskaGrupa;
    }

    @Override
    public void pretvoriGrafickiUDomenski() {
        FormaZakaziNastupeBaletskojGrupi forma = (FormaZakaziNastupeBaletskojGrupi) oef;
        BaletskaGrupa baletskaGrupa=new BaletskaGrupa();
        if ((forma.getTxtId().getText()).length() > 0) {
        baletskaGrupa.setBaletskaGrupaId(Long.parseLong(forma.getTxtId().getText()));
        }
        konvertujNastupeUListu();
    }

    @Override
    public void pretvoriDomenskiUGraficki() {
        FormaZakaziNastupeBaletskojGrupi forma = (FormaZakaziNastupeBaletskojGrupi) oef;
        BaletskaGrupa baletskaGrupa = (BaletskaGrupa) ado;
        
        ((ModelTabeleGrupaNastup) forma.getTblNastupi().getModel()).setBaletskaGrupa(baletskaGrupa);
    }

    @Override
    public void ocistiFormu() {
         FormaZakaziNastupeBaletskojGrupi forma = (FormaZakaziNastupeBaletskojGrupi) oef;
       
        ((ModelTabeleGrupaNastup) forma.getTblNastupi().getModel()).setBaletskaGrupa(new BaletskaGrupa());
    }

    public void pripremiTabelu() {
        FormaZakaziNastupeBaletskojGrupi forma = (FormaZakaziNastupeBaletskojGrupi) oef;
        ModelTabeleGrupaNastup model = new ModelTabeleGrupaNastup();
        forma.getTblNastupi().setModel(model);
    }

    public void napuniTabelu() {
        FormaZakaziNastupeBaletskojGrupi forma = (FormaZakaziNastupeBaletskojGrupi) oef;
        System.out.println(((BaletskaGrupa)ado).getListaNastupa()+"to care");
        ModelTabeleGrupaNastup model = (ModelTabeleGrupaNastup) forma.getTblNastupi().getModel();
        model.setLista(((BaletskaGrupa)ado).getListaNastupa());
        /*for (BaletskaGrupaNastup grupaNastup : ((BaletskaGrupa)ado).getListaNastupa()) {
            //Uplata uplata = (Uplata) ado;
            System.out.println("dodat");
            model.dodaj(grupaNastup);
        }*/
    }

    public void popuniNastupe() {
        List<ApstraktniDomenskiObjekat> listaNastupa;
        FormaZakaziNastupeBaletskojGrupi forma = (FormaZakaziNastupeBaletskojGrupi) oef;
        forma.getCmbNastupi().removeAllItems();
        try {
            SOUcitajListuNastupa();
            listaNastupa = lista;
            for (ApstraktniDomenskiObjekat grupa : listaNastupa) {
                forma.getCmbNastupi().addItem((Nastup) grupa);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da vrati listu baletskih grupa");
        }
    }

    public void dodajNastup() {
        FormaZakaziNastupeBaletskojGrupi forma = (FormaZakaziNastupeBaletskojGrupi) oef;
        BaletskaGrupa baletskaGrupa = (BaletskaGrupa) ado;
        ModelTabeleGrupaNastup model = (ModelTabeleGrupaNastup) forma.getTblNastupi().getModel();
        
        Nastup nastup=(Nastup) forma.getCmbNastupi().getSelectedItem();
        BaletskaGrupaNastup baletskaGrupaNastup=new BaletskaGrupaNastup();
        baletskaGrupaNastup.setBaletskaGrupaId(baletskaGrupa);
        baletskaGrupaNastup.setNastupId(nastup);
     
        try {
            for (BaletskaGrupaNastup grupaNastup : baletskaGrupa.getListaNastupa()) {
                if(grupaNastup.equals(baletskaGrupaNastup)){
                    JOptionPane.showMessageDialog(forma, "Izabrani nastup je već zakazan!");
                    return;
                }
            }
            model.dodaj(baletskaGrupaNastup);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void konvertujNastupeUListu() {
        FormaZakaziNastupeBaletskojGrupi forma = (FormaZakaziNastupeBaletskojGrupi) oef;
        BaletskaGrupa baletskaGrupa = (BaletskaGrupa) ado;
        ModelTabeleGrupaNastup model = (ModelTabeleGrupaNastup) forma.getTblNastupi().getModel();
       
        baletskaGrupa.setListaNastupa(model.getBaletskaGrupa().getListaNastupa());
    }

    public void obrisiNastup() {
        FormaZakaziNastupeBaletskojGrupi forma = (FormaZakaziNastupeBaletskojGrupi) oef;
        ModelTabeleGrupaNastup model = (ModelTabeleGrupaNastup) forma.getTblNastupi().getModel();
        model.obrisi(forma.getTblNastupi().getSelectedRow());
    }

    
    
}

