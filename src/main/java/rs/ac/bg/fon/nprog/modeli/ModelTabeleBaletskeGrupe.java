package rs.ac.bg.fon.nprog.modeli;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.nprog.domen.BaletskaGrupa;

public class ModelTabeleBaletskeGrupe extends AbstractTableModel{
    
    ArrayList<BaletskaGrupa> listaGrupa;
    String[] naziviKolona=new String[]{"BaletskaGrupaID", "Naziv grupe", "Tip grupe", "Datum nastanka", "Kapacitet","KoreografID"};

    public ModelTabeleBaletskeGrupe() {
        listaGrupa=new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return listaGrupa.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BaletskaGrupa baletskaGrupa = listaGrupa.get(rowIndex);
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:
                return baletskaGrupa.getBaletskaGrupaId();
            case 1:
                return baletskaGrupa.getNazivGrupe();
            case 2:
                return baletskaGrupa.getTipGrupe().toString();
            case 3:
                return sdf.format(baletskaGrupa.getDatumNastanka());
            case 4:
                return baletskaGrupa.getKapacitet();
            case 5:
                return baletskaGrupa.getKoreograf().getIme()+" "+baletskaGrupa.getKoreograf().getPrezime();
            default:
                return null;
        }
    }

    public ArrayList<BaletskaGrupa> getListaGrupa() {
        return listaGrupa;
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }
    public void dodaj(BaletskaGrupa baletskaGrupa) {
        listaGrupa.add(baletskaGrupa);
        fireTableDataChanged();
    }

    public void azurirajBaletskuGrupu(BaletskaGrupa baletskaGrupa) {
        for (int i = 0; i < listaGrupa.size(); i++) {
            if (listaGrupa.get(i).equals(baletskaGrupa)) {
                listaGrupa.add(i, baletskaGrupa);
                listaGrupa.remove(i + 1);
                fireTableDataChanged();
            }
        }
    }
}
