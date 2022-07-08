package rs.ac.bg.fon.nprog.modeli;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.nprog.domen.Nastup;

public class ModelTabeleNastupi extends AbstractTableModel{
    
    ArrayList<Nastup> listaNastupa;
    String[] naziviKolona={"Datum vreme nastupa", "Tip nastupa", "Naziv grada", "Naziv ustanove", "Sala"};

    public ModelTabeleNastupi() {
        listaNastupa=new ArrayList<>();
    }
    
    
    @Override
    public int getRowCount() {
        return listaNastupa.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Nastup nastup=listaNastupa.get(rowIndex);
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:
                return sdf.format(nastup.getDatumVremeNastupa());
            case 1:
                return nastup.getTipNastupa();
            case 2:
                return nastup.getLokacija().getNazivGrada();
            case 3:
                return nastup.getLokacija().getNazivUstanove();
            case 4:
               return nastup.getLokacija().getSala();
            
            default:
                return null;
        }
    }

    public ArrayList<Nastup> getListaNastupa() {
        return listaNastupa;
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column]; //To change body of generated methods, choose Tools | Templates.
    }

    public void dodaj(Nastup nastup) {
        listaNastupa.add(nastup);
        fireTableDataChanged();
    }
    
}

