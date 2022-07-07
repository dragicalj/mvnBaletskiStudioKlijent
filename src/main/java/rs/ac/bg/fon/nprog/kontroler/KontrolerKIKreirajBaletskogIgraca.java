package rs.ac.bg.fon.nprog.kontroler;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.BaletskaGrupa;
import rs.ac.bg.fon.nprog.domen.BaletskiIgrac;
import rs.ac.bg.fon.nprog.domen.Uplata;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.baletskiigrac.FormaKreirajBaletskogIgraca;
import rs.ac.bg.fon.nprog.modeli.ModelTabeleUplate;

public class KontrolerKIKreirajBaletskogIgraca extends OpstiKontrolerKI{

    public KontrolerKIKreirajBaletskogIgraca(OpstaEkranskaForma oef) {
        this.oef=oef;
    }
    
    
    @Override
    public void pretvoriGrafickiUDomenski() {
        FormaKreirajBaletskogIgraca forma = (FormaKreirajBaletskogIgraca) oef;
        BaletskiIgrac baletskiIgrac = (BaletskiIgrac) ado;
        if ((forma.getTxtIgracId().getText()).length() > 0) {
        baletskiIgrac.setBaletskiIgracId(Long.parseLong(forma.getTxtIgracId().getText()));
        }
        baletskiIgrac.setIme(forma.getTxtIme().getText());
       
        baletskiIgrac.setPrezime(forma.getTxtPrezime().getText());
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        try {
            baletskiIgrac.setDatumRodjenja(sdf.parse(forma.getTxtDatumRodjenja().getText()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(forma, "Datum mora biti u formatu dd.MM.yyyy");
            ex.printStackTrace();
            Logger.getLogger(KontrolerKIKreirajKoreografa.class.getName()).log(Level.SEVERE, null, ex);
        }
        baletskiIgrac.setEmail(forma.getTxtEmail().getText());
        baletskiIgrac.setBrojTelefona(forma.getTxtBrojTelefona().getText());
        baletskiIgrac.setBrojTelefonaRoditelja(forma.getTxtBrojTelefonaRoditelja().getText());
        baletskiIgrac.setDatumUpisa(new java.sql.Date(0));
        baletskiIgrac.setTrenutnaClanarina(new BigDecimal(forma.getTxtTrenutnaClanarina().getText()));
        baletskiIgrac.setBaletskaGrupa((BaletskaGrupa)forma.getCmbBaletskeGrupe().getSelectedItem());
        konvertujRedoveTabeleUListuUplata();
    }

    @Override
    public void pretvoriDomenskiUGraficki() {
        BaletskiIgrac baletskiIgrac = (BaletskiIgrac) ado;
        FormaKreirajBaletskogIgraca forma = (FormaKreirajBaletskogIgraca) oef;
        forma.getTxtIgracId().setText(baletskiIgrac.getBaletskiIgracId()+ "");
        forma.getTxtIme().setText(baletskiIgrac.getIme());
        forma.getTxtPrezime().setText(baletskiIgrac.getPrezime());
        SimpleDateFormat sdf1=new SimpleDateFormat("dd.MM.yyyy");
        forma.getTxtDatumRodjenja().setText(sdf1.format(baletskiIgrac.getDatumRodjenja()));
        forma.getTxtEmail().setText(baletskiIgrac.getEmail());
        forma.getTxtBrojTelefona().setText(baletskiIgrac.getBrojTelefona());
        forma.getTxtBrojTelefonaRoditelja().setText(baletskiIgrac.getBrojTelefonaRoditelja());
        forma.getTxtTrenutnaClanarina().setText(baletskiIgrac.getTrenutnaClanarina()+"");
        forma.getCmbBaletskeGrupe().setSelectedItem(baletskiIgrac.getBaletskaGrupa());
        ((ModelTabeleUplate) forma.getTblUplate().getModel()).setBaletskiIgrac(baletskiIgrac);

    }

    @Override
    public void ocistiFormu() {
        FormaKreirajBaletskogIgraca forma = (FormaKreirajBaletskogIgraca) oef;
        forma.getTxtIgracId().setText("");
        forma.getTxtIme().setText("");
        forma.getTxtPrezime().setText("");
        forma.getTxtDatumRodjenja().setText("");
        forma.getTxtEmail().setText("");
        forma.getTxtBrojTelefona().setText("");
        forma.getTxtBrojTelefonaRoditelja().setText("");
        forma.getTxtTrenutnaClanarina().setText("");
        forma.getCmbBaletskeGrupe().setSelectedIndex(0);
        ((ModelTabeleUplate) forma.getTblUplate().getModel()).setBaletskiIgrac(new BaletskiIgrac());

    }

    public void srediTabelu() {
        FormaKreirajBaletskogIgraca forma = (FormaKreirajBaletskogIgraca) oef;
        ModelTabeleUplate model = new ModelTabeleUplate();
        forma.getTblUplate().setModel(model);
    }

    public void popuniGrupe() {
        List<ApstraktniDomenskiObjekat> listaGrupa;
        FormaKreirajBaletskogIgraca forma = (FormaKreirajBaletskogIgraca) oef;

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

    public void dodajUplatuUTabelu() {
        FormaKreirajBaletskogIgraca forma = (FormaKreirajBaletskogIgraca) oef;
        BaletskiIgrac baletskiIgrac = (BaletskiIgrac) ado;
        ModelTabeleUplate model = (ModelTabeleUplate) forma.getTblUplate().getModel();
        Uplata uplata=new Uplata();
        uplata.setBaletskiIgrac(baletskiIgrac);
        uplata.setRedniBrojUplate(0);
        uplata.setIznosUplate(new BigDecimal(forma.getTxtIznos().getText()));
        //SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        //Date datumUplate=sdf.parse()
       uplata.setDatumUplate(new Date());
       uplata.setMesec((String)forma.getCmbMesec().getSelectedItem());
       uplata.setGodina(forma.getTxtGodina().getText());
        try {
           
            model.dodaj(uplata);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void izbaciUplatuIzTabele() {
        FormaKreirajBaletskogIgraca forma = (FormaKreirajBaletskogIgraca) oef;
        ModelTabeleUplate model = (ModelTabeleUplate) forma.getTblUplate().getModel();
        if (forma.getTblUplate().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(forma, "Izaberite uplatu iz tabele");
        } else {
            model.obrisi(forma.getTblUplate().getSelectedRow());
        }
    }
    
    private void konvertujRedoveTabeleUListuUplata() {
        FormaKreirajBaletskogIgraca forma = (FormaKreirajBaletskogIgraca) oef;
        BaletskiIgrac baletskiIgrac = (BaletskiIgrac) ado;
        ModelTabeleUplate model = (ModelTabeleUplate) forma.getTblUplate().getModel();
        baletskiIgrac.setListaUplata(model.getBaletskiIgrac().getListaUplata());

    }
    
    
    
}
