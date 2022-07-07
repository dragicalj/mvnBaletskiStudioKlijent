package rs.ac.bg.fon.nprog.modeli;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.nprog.domen.BaletskiIgrac;
import rs.ac.bg.fon.nprog.domen.Uplata;

public class ModelTabeleUplate extends AbstractTableModel{
    
    private BaletskiIgrac baletskiIgrac=new BaletskiIgrac();
    String[] naziviKolona=new String[]{"RB", "Iznos", "Mesec", "Godina"};


    @Override
    public int getRowCount() {
        if (baletskiIgrac == null) {
            return 0;
        }
        return baletskiIgrac.getListaUplata().size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Uplata uplata = baletskiIgrac.getListaUplata().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return uplata.getRedniBrojUplate();
            case 1:
                return uplata.getIznosUplate();
            case 2:
                return uplata.getMesec();
            case 3:
               return uplata.getGodina();
            
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }
    public void dodaj(Uplata uplata) throws Exception {
        if (baletskiIgrac.getListaUplata().size() > 0) {
            uplata.setRedniBrojUplate(baletskiIgrac.getListaUplata().get(baletskiIgrac.getListaUplata().size() - 1).getRedniBrojUplate() + 1);
        } else {
            uplata.setRedniBrojUplate(1);
        }
        System.out.println(uplata);
        baletskiIgrac.getListaUplata().add(uplata);
        fireTableDataChanged();
    }

    public void obrisi(int selectedRow) {
        this.baletskiIgrac.getListaUplata().remove(selectedRow);
        fireTableDataChanged();
    }

    public BaletskiIgrac getBaletskiIgrac() {
        return baletskiIgrac;
    }

    public void setBaletskiIgrac(BaletskiIgrac baletskiIgrac) {
        this.baletskiIgrac = baletskiIgrac;
    }
    public void setLista(List<Uplata> lista){
        this.baletskiIgrac.setListaUplata(lista);
        fireTableDataChanged();
    }
}

