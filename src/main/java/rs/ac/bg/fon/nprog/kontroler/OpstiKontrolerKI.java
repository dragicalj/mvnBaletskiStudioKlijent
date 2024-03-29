package rs.ac.bg.fon.nprog.kontroler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rs.ac.bg.fon.nprog.domen.Administrator;
import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.BaletskaGrupa;
import rs.ac.bg.fon.nprog.domen.BaletskiIgrac;
import rs.ac.bg.fon.nprog.domen.Koreograf;
import rs.ac.bg.fon.nprog.domen.Lokacija;
import rs.ac.bg.fon.nprog.domen.Nastup;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.baletskagrupa.FormaZakaziNastupeBaletskojGrupi;
import rs.ac.bg.fon.nprog.forme.baletskiigrac.FormaPromeniUplateBaletskogIgraca;
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
    public void SOUcitajListuKoreografaJSON() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_KOREOGRAFE, lista);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                lista = (List<ApstraktniDomenskiObjekat>) odgovor.getRezultat();
                if (lista.isEmpty()) {
                    throw new Exception();
                }
                ArrayList<Koreograf> koreografi=new ArrayList<Koreograf>();
                for (ApstraktniDomenskiObjekat ado : lista) {
                    Koreograf koreograf = (Koreograf) ado;
                    koreografi.add(koreograf);
                }
                try(PrintWriter out = new PrintWriter(new FileWriter("koreografi.json"))){
        			Gson gson = new GsonBuilder().setPrettyPrinting().create();
        			
        			out.print(gson.toJson(koreografi));
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
                JOptionPane.showMessageDialog(oef, "Sistem je preuzeo koreografe u fajlu koreografi.json!");

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
    public void SOUcitajListuBaletskihGrupaJSON() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_BALETSKEGRUPE, lista);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                lista = (List<ApstraktniDomenskiObjekat>) odgovor.getRezultat();
                if (lista.isEmpty()) {
                    throw new Exception();
                }
                ArrayList<BaletskaGrupa> baletskeGrupe=new ArrayList<BaletskaGrupa>();
                for (ApstraktniDomenskiObjekat ado : lista) {
                    BaletskaGrupa baletskaGrupa = (BaletskaGrupa) ado;
                    baletskeGrupe.add(baletskaGrupa);
                }
                try(PrintWriter out = new PrintWriter(new FileWriter("baletskeGrupe.json"))){
        			Gson gson = new GsonBuilder().setPrettyPrinting().create();
        			
        			out.print(gson.toJson(baletskeGrupe));
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
                JOptionPane.showMessageDialog(oef, "Sistem je preuzeo baletske grupe u fajlu baletskeGrupe.json!");
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
    
    public void SOUcitajListuBaletskihIgracaJSON() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_BALETSKEIGRACE, lista);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                lista = (List<ApstraktniDomenskiObjekat>) odgovor.getRezultat();
                if (lista.isEmpty()) {
                    throw new Exception();
                }
                ArrayList<BaletskiIgrac> baletskiIgraci=new ArrayList<BaletskiIgrac>();
                for (ApstraktniDomenskiObjekat ado : lista) {
                    BaletskiIgrac baletskiIgrac = (BaletskiIgrac) ado;
                    baletskiIgraci.add(baletskiIgrac);
                }
                try(PrintWriter out = new PrintWriter(new FileWriter("baletskiIgraci.json"))){
        			Gson gson = new GsonBuilder().setPrettyPrinting().create();
        			
        			out.print(gson.toJson(baletskiIgraci));
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
                JOptionPane.showMessageDialog(oef, "Sistem je preuzeo baletske igrace u fajlu baletskiIgraci.json!");
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu baletskih igraca", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu baletskih igraca", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOUcitajListuBaletskihIgraca() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_BALETSKEIGRACE, lista);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                lista = (List<ApstraktniDomenskiObjekat>) odgovor.getRezultat();
                if (lista.isEmpty()) {
                    throw new Exception();
                }
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu baletskih igraca", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu baletskih igraca", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOPronadjiBaletskeIgrace() {
        ocistiFormu();
        ado = oef.kreirajObjekat();
        pretvoriGrafickiUDomenski();
        Zahtev zahtev = new Zahtev(Operacije.PRONADJI_BALETSKEIGRACE, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                lista = (List<ApstraktniDomenskiObjekat>) odgovor.getRezultat();
                if (lista.isEmpty()) {
                    throw new Exception();
                }
                pretvoriDomenskiUGraficki();
                JOptionPane.showMessageDialog(oef, "Sistem je pronasao baletske igrace po zadatom kriterijumu");
            } else {
                System.out.println("greska");
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da nadje baletske igrace po zadataom kriterijumu", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da nadje baletske igrace po zadataom kriterijumu", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOUcitajBaletskogIgraca() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_BALETSKOGIGRACA, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                ado = (BaletskiIgrac) odgovor.getRezultat();

                pretvoriDomenskiUGraficki();
                JOptionPane.showMessageDialog(oef, "Sistem je ucitao baletskog igraca");
                System.out.println(((BaletskiIgrac) ado).getListaUplata());
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita baletskog igraca", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita baletskog igraca", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOPromeniBaletskogIgraca() {
        ado = oef.kreirajObjekat();
        pretvoriGrafickiUDomenski();
        Zahtev zahtev = new Zahtev(Operacije.PROMENI_PODATKEBALETSKOGIGRACA, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                JOptionPane.showMessageDialog(oef, "Sistem je zapamtio baletskog igraca");
                ocistiFormu();
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da zapamti baletskog igraca", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da zapamti baletskog igraca", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOSacuvajUplateBaletskogIgraca() {
        ado = oef.kreirajObjekat();
        //System.out.println(((BaletskiIgrac)ado).getBaletskiIgracId());
        pretvoriGrafickiUDomenski();
        ((BaletskiIgrac) ado).setBaletskiIgracId(Long.parseLong(((FormaPromeniUplateBaletskogIgraca) oef).getTxtId().getText()));
        Zahtev zahtev = new Zahtev(Operacije.ZAPAMTI_UPLATEBALETSKOGIGRACA, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                JOptionPane.showMessageDialog(oef, "Sistem je zapamtio uplate baletskog igraca");
                ocistiFormu();
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da zapamti uplate baletskog igraca", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da zapamti uplate baletskog igraca", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOKreirajBaletskuGrupu() {
        ado = oef.kreirajObjekat();
        pretvoriGrafickiUDomenski();

        Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_BALETSKUGRUPU, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                ado = (BaletskaGrupa) odgovor.getRezultat();
                pretvoriDomenskiUGraficki();
                JOptionPane.showMessageDialog(oef, "Sistem je kreirao baletsku grupu");
            } else {

                JOptionPane.showMessageDialog(oef, "Sistem ne moze da kreira baletsku grupu", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da kreira baletsku grupu", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOUcitajBaletskuGrupu() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_BALETSKUGRUPU, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                ado = (BaletskaGrupa) odgovor.getRezultat();
                System.out.println(((BaletskaGrupa) ado).getListaNastupa());
                pretvoriDomenskiUGraficki();
                JOptionPane.showMessageDialog(oef, "Sistem je ucitao baletsku grupu");
                System.out.println(((BaletskaGrupa) ado).getListaNastupa());
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita baletsku grupu", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita baletsku grupu", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void SOPromeniBaletskuGrupu() {
        ado = oef.kreirajObjekat();
        pretvoriGrafickiUDomenski();
        Zahtev zahtev = new Zahtev(Operacije.PROMENI_PODATKEBALETSKEGRUPE, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                JOptionPane.showMessageDialog(oef, "Sistem je zapamtio baletsku grupu");
                ocistiFormu();
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da zapamti baletsku grupu", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da zapamti baletsku grupu", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOUcitajListuNastupa() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_NASTUPE, lista);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                lista = (List<ApstraktniDomenskiObjekat>) odgovor.getRezultat();
                if (lista.isEmpty()) {
                    throw new Exception();
                }
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu nastupa", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu nastupa", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void SOSacuvajNastupeBaletskeGrupe() {
        ado = oef.kreirajObjekat();
        //System.out.println(((BaletskiIgrac)ado).getBaletskiIgracId());
        pretvoriGrafickiUDomenski();
        ((BaletskaGrupa) ado).setBaletskaGrupaId(Long.parseLong(((FormaZakaziNastupeBaletskojGrupi) oef).getTxtId().getText()));
        Zahtev zahtev = new Zahtev(Operacije.ZAPAMTI_NASTUPEBALETSKEGRUPE, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                JOptionPane.showMessageDialog(oef, "Sistem je zapamtio nastupe baletske grupe");
                ocistiFormu();
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da zapamti nastupe baletske grupe", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da zapamti nastupe baletske grupe", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOKreirajLokaciju() {
        ado = oef.kreirajObjekat();
        pretvoriGrafickiUDomenski();
        Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_LOKACIJU, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                ado = (Lokacija) odgovor.getRezultat();
                pretvoriDomenskiUGraficki();
                JOptionPane.showMessageDialog(oef, "Sistem je kreirao lokaciju");
            } else {

                JOptionPane.showMessageDialog(oef, "Sistem ne moze da kreira lokaciju", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da kreira lokaciju", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOUcitajListuLokacija() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_LOKACIJE, lista);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                lista = (List<ApstraktniDomenskiObjekat>) odgovor.getRezultat();
                if (lista.isEmpty()) {
                    throw new Exception();
                }
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu lokacija", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da ucita listu lokacija", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void SOKreirajNastup() {
        ado = oef.kreirajObjekat();
        pretvoriGrafickiUDomenski();
        Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_NASTUP, ado);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora() == TipOdgovora.USPESNO) {
                ado = (Nastup) odgovor.getRezultat();
                pretvoriDomenskiUGraficki();
                JOptionPane.showMessageDialog(oef, "Sistem je kreirao nastp");
            } else {

                JOptionPane.showMessageDialog(oef, "Sistem ne moze da kreira nastup", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne moze da kreira nastup", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
}
