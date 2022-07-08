package rs.ac.bg.fon.nprog.kontroler;

import rs.ac.bg.fon.nprog.domen.Lokacija;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.forme.lokacija.FormaKreirajLokaciju;

public class KontrolerKIKreirajLokaciju extends OpstiKontrolerKI{

    public KontrolerKIKreirajLokaciju(OpstaEkranskaForma oef) {
        this.oef=oef;
    }
       
    @Override
    public void pretvoriGrafickiUDomenski() {
        FormaKreirajLokaciju forma = (FormaKreirajLokaciju) oef;
        Lokacija lokacija = (Lokacija) ado;
        if ((forma.getTxtLokacijaId().getText()).length() > 0) {
        lokacija.setLokacijaId(Long.parseLong(forma.getTxtLokacijaId().getText()));
        }
        lokacija.setNazivGrada(forma.getTxtNazivGrada().getText());
        lokacija.setNazivUstanove(forma.getTxtNazivUstanove().getText());
        lokacija.setSala(forma.getTxtSala().getText());
    }

    @Override
    public void pretvoriDomenskiUGraficki() {
        Lokacija lokacija = (Lokacija) ado;
        FormaKreirajLokaciju forma = (FormaKreirajLokaciju) oef;
        forma.getTxtLokacijaId().setText(lokacija.getLokacijaId()+ "");
        forma.getTxtNazivGrada().setText(lokacija.getNazivGrada());
        forma.getTxtNazivUstanove().setText(lokacija.getNazivUstanove());
        forma.getTxtSala().setText(lokacija.getSala());
    }

    @Override
    public void ocistiFormu() {
        FormaKreirajLokaciju forma = (FormaKreirajLokaciju) oef;
        forma.getTxtLokacijaId().setText("");
        forma.getTxtNazivGrada().setText("");
        forma.getTxtNazivUstanove().setText("");
        forma.getTxtSala().setText("");
    }

    
}
