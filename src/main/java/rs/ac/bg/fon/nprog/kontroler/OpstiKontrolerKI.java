package rs.ac.bg.fon.nprog.kontroler;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.fon.nprog.domen.Administrator;
import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.BaletskiIgrac;
import rs.ac.bg.fon.nprog.domen.Koreograf;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.koreograf.FormaPrikaziSveKoreografe;
import rs.ac.bg.fon.nprog.komunikacija.Komunikacija;
import rs.ac.bg.fon.nprog.modeli.ModelTabeleKoreografi;
import rs.ac.bg.fon.nprog.transfer.Odgovor;
import rs.ac.bg.fon.nprog.transfer.Operacije;
import rs.ac.bg.fon.nprog.transfer.TipOdgovora;
import rs.ac.bg.fon.nprog.transfer.Zahtev;

public abstract class OpstiKontrolerKI {
	
	protected ApstraktniDomenskiObjekat ado;
    protected OpstaEkranskaForma oef;
    protected List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

    public OpstiKontrolerKI() {
    }

    abstract public void pretvoriGrafickiUDomenski();

    abstract public void pretvoriDomenskiUGraficki();
    
    public boolean SOLogin() {
        ado = oef.kreirajObjekat();
        pretvoriGrafickiUDomenski();
        Zahtev zahtev = new Zahtev(Operacije.LOGIN, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                ado = (Administrator) odgovor.getRezultat();
                System.out.println(ado);
                Komunikacija.getInstanca().setTrenutniAdministrator((Administrator) ado);
                oef.dispose();
                return true;
            } else {
                JOptionPane.showMessageDialog(oef, "Neuspesno prijavljivanje!", "Greska", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Neuspesno prijavljivanje!", "Greska", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public void SOKreirajKoreografa() {
        ado = oef.kreirajObjekat();
        pretvoriGrafickiUDomenski();
        Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_KOREOGRAFA, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                ado = (Koreograf) odgovor.getRezultat();
                pretvoriDomenskiUGraficki();
                JOptionPane.showMessageDialog(oef, "Sistem je kreirao koreografa");
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da kreira koreografa", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da kreira koreografa", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    public abstract void ocistiFormu();

    public void SOUcitajListuKoreografa() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_KOREOGRAFE, lista);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                lista = (List<ApstraktniDomenskiObjekat>) odgovor.getRezultat();
                if (lista.isEmpty()) {
                    throw new Exception();
                }
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu koreografa", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu koreografa", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOPronadjiKoreografe() {
        ocistiFormu();
        ado = oef.kreirajObjekat();
        pretvoriGrafickiUDomenski();
        Zahtev zahtev = new Zahtev(Operacije.PRONADJI_KOREOGRAFE, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                lista = (List<ApstraktniDomenskiObjekat>) odgovor.getRezultat();
                if (lista.isEmpty()) {
                    throw new Exception();
                }
                pretvoriDomenskiUGraficki();
                JOptionPane.showMessageDialog(oef, "Sistem je pronasao koreografe po zadatom kriterijumu");
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da nadje koreografe po zadataom kriterijumu", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da nadje koreografe po zadataom kriterijumu", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOUcitajKoreografa() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_KOREOGRAFA, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                ado = (Koreograf) odgovor.getRezultat();
                pretvoriDomenskiUGraficki();
                JOptionPane.showMessageDialog(oef, "Sistem je ucitao koreografa");
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita koreografa", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita koreografa", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOPromeniKoreografa() {
        ado = oef.kreirajObjekat();
        pretvoriGrafickiUDomenski();
        Zahtev zahtev = new Zahtev(Operacije.PROMENI_KOREOGRAFA, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                JOptionPane.showMessageDialog(oef, "Sistem je zapamtio koreografa");
                ocistiFormu();
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da zapamti koreografa", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da zapamti koreografa", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOObrisiKoreografa() {
        FormaPrikaziSveKoreografe forma = (FormaPrikaziSveKoreografe) oef;
          try {
              Koreograf koreograf = konvertujRedTabeleUObjekatKoreograf();
              Zahtev zahtev = new Zahtev(Operacije.OBRISI_KOREOGRAFA, koreograf);
              Odgovor odgovor;
              try {
                  odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
                  if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                      JOptionPane.showMessageDialog(oef, "Sistem je obrisao koreografa");
                      ModelTabeleKoreografi model = (ModelTabeleKoreografi) forma.getTblKoreografi().getModel();
                      model.obrisi(forma.getTblKoreografi().getSelectedRow());
                  } else {
                      JOptionPane.showMessageDialog(oef, "Sistem ne moze da obrise koreografa", "Greska", JOptionPane.ERROR_MESSAGE);
                  }
              } catch (Exception ex) {
                  ex.printStackTrace();
                  JOptionPane.showMessageDialog(oef, "Sistem ne moze da obrise koreografa", "Greska", JOptionPane.ERROR_MESSAGE);
              }
          } catch (Exception ex) {
              JOptionPane.showMessageDialog(oef, "Izaberite red u tabeli");
          }  
      }
    
    private Koreograf konvertujRedTabeleUObjekatKoreograf() throws Exception {
        FormaPrikaziSveKoreografe forma = (FormaPrikaziSveKoreografe) oef;
        ModelTabeleKoreografi model = (ModelTabeleKoreografi) forma.getTblKoreografi().getModel();
        if (forma.getTblKoreografi().getSelectedRow() != -1) {
            Koreograf koreograf = model.getListaKoreografa().get(forma.getTblKoreografi().getSelectedRow());
            return koreograf;
        } else {
            throw new Exception();
        }
    }
    
    public void SOUcitajListuBaletskihGrupa() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_BALETSKEGRUPE, lista);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                lista = (List<ApstraktniDomenskiObjekat>) odgovor.getRezultat();
                if (lista.isEmpty()) {
                    throw new Exception();
                }
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu baletskih grupa", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu baletskih grupa", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOKreirajBaletskogIgraca() {
        ado = oef.kreirajObjekat();
        pretvoriGrafickiUDomenski();
        Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_BALETSKOGIGRACA, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                ado = (BaletskiIgrac) odgovor.getRezultat();
                pretvoriDomenskiUGraficki();
                JOptionPane.showMessageDialog(oef, "Sistem je kreirao baletskog igraca");
            } else {

                JOptionPane.showMessageDialog(oef, "Sistem ne moze da kreira baletskog igraca", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da kreira baletskog igraca", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
}
