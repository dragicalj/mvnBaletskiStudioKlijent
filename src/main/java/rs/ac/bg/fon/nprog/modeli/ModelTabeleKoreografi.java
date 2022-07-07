package rs.ac.bg.fon.nprog.modeli;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.nprog.domen.Koreograf;

public class ModelTabeleKoreografi extends AbstractTableModel{
    
    ArrayList<Koreograf> listaKoreografa;
    String[] naziviKolona=new String[]{"KoreografID", "Ime i prezime", "Datum rodjenja", "Email", "Broj telefona", "Specijalizovanost"};

    public ModelTabeleKoreografi() {
        listaKoreografa=new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return listaKoreografa.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Koreograf koreograf = listaKoreografa.get(rowIndex);
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:
                return koreograf.getKoreografId();
            case 1:
                return koreograf.getIme()+" "+koreograf.getPrezime();
            case 2:
                return sdf.format(koreograf.getDatumRodjenja());
            case 3:
                return koreograf.getEmail();
            case 4:
                return koreograf.getBrojTelefona();
            case 5:
                return koreograf.getSpecijalizovanost();
            default:
                return null;
        }
    }

    public ArrayList<Koreograf> getListaKoreografa() {
        return listaKoreografa;
    }

    public void setListaKoreografa(ArrayList<Koreograf> listaKoreografa) {
        this.listaKoreografa = listaKoreografa;
    }

    public String[] getNaziviKolona() {
        return naziviKolona;
    }

    public void setNaziviKolona(String[] naziviKolona) {
        this.naziviKolona = naziviKolona;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column]; //To change body of generated methods, choose Tools | Templates.
    }

    public void dodaj(Koreograf koreograf) {
        listaKoreografa.add(koreograf);
        fireTableDataChanged();
    }

    public void azurirajKoreografa(Koreograf koreograf) {
        for (int i = 0; i < listaKoreografa.size(); i++) {
            if (listaKoreografa.get(i).equals(koreograf)) {
                listaKoreografa.add(i, koreograf);
                listaKoreografa.remove(i + 1);
                fireTableDataChanged();
            }
        }
    }

    public void obrisi(int selectedRow) {
        this.listaKoreografa.remove(selectedRow);
        fireTableDataChanged();
    }
    
    
}
