package rs.ac.bg.fon.nprog.modeli;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.nprog.domen.BaletskaGrupa;
import rs.ac.bg.fon.nprog.domen.BaletskaGrupaNastup;

public class ModelTabeleGrupaNastup extends AbstractTableModel{
    
    private BaletskaGrupa baletskaGrupa=new BaletskaGrupa();
    String[] naziviKolona=new String[]{"Datum i vreme nastupa","Tip nastupa", "Lokacija", "Broj sale"};
    
    @Override
    public int getRowCount() {
        if (baletskaGrupa == null || baletskaGrupa.getListaNastupa() == null) {
            return 0;
        }
        
        return baletskaGrupa.getListaNastupa().size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BaletskaGrupaNastup nastup = baletskaGrupa.getListaNastupa().get(rowIndex);
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:
                return sdf.format(nastup.getNastupId().getDatumVremeNastupa());
            case 1:
                return nastup.getNastupId().getTipNastupa();
            case 2:
                return nastup.getNastupId().getLokacija().getNazivUstanove()+" "+nastup.getNastupId().getLokacija().getNazivGrada();
            case 3:
               return nastup.getNastupId().getLokacija().getSala();
            
            default:
                return null;
        }
    }

    public BaletskaGrupa getBaletskaGrupa() {
        return baletskaGrupa;
    }

    public void setBaletskaGrupa(BaletskaGrupa baletskaGrupa) {
        this.baletskaGrupa = baletskaGrupa;
    }

    public void dodaj(BaletskaGrupaNastup grupaNastup) {
        System.out.println(grupaNastup);
        baletskaGrupa.getListaNastupa().add(grupaNastup);
        fireTableDataChanged();
    }
    public void setLista(List<BaletskaGrupaNastup> lista){
        this.baletskaGrupa.setListaNastupa(lista);
        fireTableDataChanged();
    }

    public void obrisi(int selectedRow) {
        this.baletskaGrupa.getListaNastupa().remove(selectedRow);
        fireTableDataChanged();            
    }
   
}

