package rs.ac.bg.fon.nprog.kontroler;

import java.math.BigDecimal;
import java.util.Date;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.nprog.domen.BaletskiIgrac;
import rs.ac.bg.fon.nprog.domen.Uplata;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.baletskiigrac.FormaPromeniUplateBaletskogIgraca;
import rs.ac.bg.fon.nprog.modeli.ModelTabeleUplate;

public class KontrolerKIPromeniUplateBaletskogIgraca extends OpstiKontrolerKI{

    public KontrolerKIPromeniUplateBaletskogIgraca(OpstaEkranskaForma oef, BaletskiIgrac baletskiIgrac) {
        this.oef=oef;
        ado=baletskiIgrac;
    }
    
    

    @Override
    public void pretvoriGrafickiUDomenski() {
        FormaPromeniUplateBaletskogIgraca forma = (FormaPromeniUplateBaletskogIgraca) oef;
        BaletskiIgrac baletskiIgrac=new BaletskiIgrac();
        if ((forma.getTxtId().getText()).length() > 0) {
        baletskiIgrac.setBaletskiIgracId(Long.parseLong(forma.getTxtId().getText()));
        }
        konvertujRedoveTabeleUNizStavki();
    }

    @Override
    public void pretvoriDomenskiUGraficki() {
        FormaPromeniUplateBaletskogIgraca forma = (FormaPromeniUplateBaletskogIgraca) oef;
        BaletskiIgrac baletskiIgrac = (BaletskiIgrac) ado;
        
        ((ModelTabeleUplate) forma.getTblUplate().getModel()).setBaletskiIgrac(baletskiIgrac);
    }

    @Override
    public void ocistiFormu() {
        FormaPromeniUplateBaletskogIgraca forma = (FormaPromeniUplateBaletskogIgraca) oef;
       
        ((ModelTabeleUplate) forma.getTblUplate().getModel()).setBaletskiIgrac(new BaletskiIgrac());
    }

    public void napuniTabelu() throws Exception {
        FormaPromeniUplateBaletskogIgraca forma = (FormaPromeniUplateBaletskogIgraca) oef;
        System.out.println(((BaletskiIgrac)ado).getListaUplata());
        ModelTabeleUplate model = (ModelTabeleUplate) forma.getTblUplate().getModel();
        model.setLista(((BaletskiIgrac)ado).getListaUplata());

        /*for (Uplata uplata : ((BaletskiIgrac)ado).getListaUplata()) {
            //Uplata uplata = (Uplata) ado;
            model.dodaj(uplata);
        }*/
    }

    public void pripremiTabelu() {
        FormaPromeniUplateBaletskogIgraca forma = (FormaPromeniUplateBaletskogIgraca) oef;
        ModelTabeleUplate model = new ModelTabeleUplate();
        forma.getTblUplate().setModel(model);
    }

    public void dodajUplatuUTabelu() {
        FormaPromeniUplateBaletskogIgraca forma = (FormaPromeniUplateBaletskogIgraca) oef;
        BaletskiIgrac baletskiIgrac = (BaletskiIgrac) ado;
        ModelTabeleUplate model = (ModelTabeleUplate) forma.getTblUplate().getModel();
        Uplata uplata=new Uplata();
        uplata.setBaletskiIgrac(baletskiIgrac);
        uplata.setRedniBrojUplate(model.getBaletskiIgrac().getListaUplata().size()+1);
        uplata.setRedniBrojUplate(0);

        uplata.setIznosUplate(new BigDecimal(forma.getTxtIznos().getText()));
        //SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        //Date datumUplate=sdf.parse()
       uplata.setDatumUplate(new Date());
       uplata.setMesec((String)forma.getCmbMesec().getSelectedItem());
       uplata.setGodina(forma.getTxtGodina().getText());
        try {
            for (Uplata u : baletskiIgrac.getListaUplata()) {
                if(u.getMesec().equals(uplata.getMesec()) && u.getGodina().equals(uplata.getGodina())){
                    JOptionPane.showMessageDialog(forma, "Članarina za mesec "+u.getMesec().toLowerCase()+" godine "+u.getGodina()+". je već uplaćena!");
                    return;
                }
            }
            model.dodaj(uplata);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void izbaciUplatuIzTabele() {
        FormaPromeniUplateBaletskogIgraca forma = (FormaPromeniUplateBaletskogIgraca) oef;
        ModelTabeleUplate model = (ModelTabeleUplate) forma.getTblUplate().getModel();
        if (forma.getTblUplate().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(forma, "Izaberite uplatu iz tabele");
        } else {
            model.obrisi(forma.getTblUplate().getSelectedRow());
        }
    }

    private void konvertujRedoveTabeleUNizStavki() {
        FormaPromeniUplateBaletskogIgraca forma = (FormaPromeniUplateBaletskogIgraca) oef;
        BaletskiIgrac baletskiIgrac = (BaletskiIgrac) ado;
        ModelTabeleUplate model = (ModelTabeleUplate) forma.getTblUplate().getModel();
       
        baletskiIgrac.setListaUplata(model.getBaletskiIgrac().getListaUplata());
    }

    public void obrisiUplatuIzTabele() {
        FormaPromeniUplateBaletskogIgraca forma = (FormaPromeniUplateBaletskogIgraca) oef;
        ModelTabeleUplate model = (ModelTabeleUplate) forma.getTblUplate().getModel();
        model.obrisi(forma.getTblUplate().getSelectedRow());
    }

   
    
}

