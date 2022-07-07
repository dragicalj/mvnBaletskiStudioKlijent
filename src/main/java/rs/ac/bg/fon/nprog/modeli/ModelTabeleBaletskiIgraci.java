package rs.ac.bg.fon.nprog.modeli;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.nprog.domen.BaletskiIgrac;

public class ModelTabeleBaletskiIgraci extends AbstractTableModel{

    ArrayList<BaletskiIgrac> listaIgraca;
    String[] naziviKolona=new String[]{"BaletskiIgracID", "Ime i prezime", "Datum rodjenja", "Email", "Broj telefona", "Broj telefona roditelja","Datum upisa","Trenutna clanarina","Baletska grupa"};

    public ModelTabeleBaletskiIgraci() {
        listaIgraca=new ArrayList<>();
    }
    
    
    @Override
    public int getRowCount() {
        return listaIgraca.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       BaletskiIgrac baletskiIgrac = listaIgraca.get(rowIndex);
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat sdf1=new SimpleDateFormat("dd.MM.yyyy");

        switch (columnIndex) {
            case 0:
                return baletskiIgrac.getBaletskiIgracId();
            case 1:
                return baletskiIgrac.getIme()+" "+baletskiIgrac.getPrezime();
            case 2:
                return sdf.format(baletskiIgrac.getDatumRodjenja());
            case 3:
                return baletskiIgrac.getEmail();
            case 4:
                return baletskiIgrac.getBrojTelefona();
            case 5:
                return baletskiIgrac.getBrojTelefonaRoditelja();
            case 6:
                return baletskiIgrac.getDatumUpisa().getTime();
            case 7:
                return baletskiIgrac.getTrenutnaClanarina()+"";
            case 8:
                return baletskiIgrac.getBaletskaGrupa().getNazivGrupe();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public ArrayList<BaletskiIgrac> getListaIgraca() {
        return listaIgraca;
    }

    public void dodaj(BaletskiIgrac baletskiIgrac) {
        listaIgraca.add(baletskiIgrac);
        fireTableDataChanged();
    }

    public void azurirajBaletskogIgraca(BaletskiIgrac baletskiIgrac) {
        for (int i = 0; i < listaIgraca.size(); i++) {
            if (listaIgraca.get(i).equals(baletskiIgrac)) {
                listaIgraca.add(i, baletskiIgrac);
                listaIgraca.remove(i + 1);
                fireTableDataChanged();
            }
        }
    }

    public void setListaIgraca(ArrayList<BaletskiIgrac> listaIgraca) {
        this.listaIgraca = listaIgraca;
    }
    
    
}
