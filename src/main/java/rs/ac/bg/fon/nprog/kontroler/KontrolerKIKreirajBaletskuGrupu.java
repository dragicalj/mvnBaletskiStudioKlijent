package rs.ac.bg.fon.nprog.kontroler;

import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.BaletskaGrupa;
import rs.ac.bg.fon.nprog.domen.Koreograf;
import rs.ac.bg.fon.nprog.domen.TipGrupe;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.baletskagrupa.FormaKreirajBaletskuGrupu;

public class KontrolerKIKreirajBaletskuGrupu extends OpstiKontrolerKI{

    public KontrolerKIKreirajBaletskuGrupu(OpstaEkranskaForma oef) {
        this.oef=oef;
    }
    

    @Override
    public void pretvoriGrafickiUDomenski() {
        BaletskaGrupa baletskaGrupa = (BaletskaGrupa) ado;
        FormaKreirajBaletskuGrupu forma = (FormaKreirajBaletskuGrupu) oef;
        if ((forma.getTxtBaletskaGrupaId().getText()).length() > 0) {
        baletskaGrupa.setBaletskaGrupaId(Long.parseLong(forma.getTxtBaletskaGrupaId().getText()));
        }
        baletskaGrupa.setNazivGrupe(forma.getTxtNazivGrupe().getText());
        baletskaGrupa.setTipGrupe((TipGrupe) forma.getCmbTipGrupe().getSelectedItem());
        //baletskaGrupa.setDatumNastanka(new Date(0));
        baletskaGrupa.setKapacitet(Integer.parseInt(forma.getTxtKapacitet().getText()));
        baletskaGrupa.setKoreograf((Koreograf) forma.getCmbKoreograf().getSelectedItem());
        
    }

    @Override
    public void pretvoriDomenskiUGraficki() {
        BaletskaGrupa baletskaGrupa = (BaletskaGrupa) ado;
        FormaKreirajBaletskuGrupu forma = (FormaKreirajBaletskuGrupu) oef;
        forma.getTxtBaletskaGrupaId().setText(baletskaGrupa.getBaletskaGrupaId()+ "");
        forma.getCmbTipGrupe().setSelectedItem(baletskaGrupa.getTipGrupe());
        forma.getTxtKapacitet().setText(baletskaGrupa.getKapacitet()+"");
        forma.getCmbKoreograf().setSelectedItem(baletskaGrupa.getKoreograf());
    }

    @Override
    public void ocistiFormu() {
        FormaKreirajBaletskuGrupu forma = (FormaKreirajBaletskuGrupu) oef;
        forma.getTxtBaletskaGrupaId().setText("");
        forma.getTxtNazivGrupe().setText("");
        forma.getCmbTipGrupe().setSelectedIndex(0);
        forma.getTxtKapacitet().setText("");
        forma.getCmbKoreograf().setSelectedItem(0);
    }

    public void popuniTipGrupe() {
       FormaKreirajBaletskuGrupu forma = (FormaKreirajBaletskuGrupu) oef;
       forma.getCmbTipGrupe().removeAllItems();
       forma.getCmbTipGrupe().addItem(TipGrupe.Mini);
       forma.getCmbTipGrupe().addItem(TipGrupe.Junior);
       forma.getCmbTipGrupe().addItem(TipGrupe.Senior);

    }

    public void popuniKoreografe() {
        List<ApstraktniDomenskiObjekat> listaKoreografa;
        FormaKreirajBaletskuGrupu forma = (FormaKreirajBaletskuGrupu) oef;
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

    
    
}
