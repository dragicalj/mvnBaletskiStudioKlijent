package rs.ac.bg.fon.nprog.forme.baletskagrupa;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.BaletskaGrupa;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.kontroler.KontrolerKIPrikaziSveGrupe;

public class FormaPrikaziSveBaletskeGrupe extends OpstaEkranskaForma {

    BaletskaGrupa baletskaGrupa;
    private final KontrolerKIPrikaziSveGrupe kontroler;

    /**
     * Creates new form FormaPrikaziSveBaletskeGrupe
     */
    public FormaPrikaziSveBaletskeGrupe() {
        initComponents();
        kontroler = new KontrolerKIPrikaziSveGrupe(this);
        kontroler.pripremiTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGrupe2 = new javax.swing.JTable();
        btnIzmeni2 = new javax.swing.JButton();
        btnZakazi2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Prikaz svih baletskih grupa"));

        tblGrupe2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblGrupe2);

        btnIzmeni2.setText("Izmeni podatke");
        btnIzmeni2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnZakazi2.setText("Zakazi nastup");
        btnZakazi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZakaziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIzmeni2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnZakazi2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni2)
                    .addComponent(btnZakazi2))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        kontroler.SOUcitajListuBaletskihGrupa();
        kontroler.napuniTabelu();
    }                                 

    private void btnZakaziActionPerformed(java.awt.event.ActionEvent evt) {                                          
        /*try {
            // TODO add your handling code here:
            BaletskaGrupa baletskaGrupa=kontroler.vratiBaletskuGrupu();
            System.out.println(baletskaGrupa.getListaNastupa());
            new FormaZakaziNastupeBaletskojGrupi(this, baletskaGrupa).setVisible(true);
            //.out.println(baletskiIgrac.getBaletskiIgracId());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }*/
    }                                         

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            // TODO add your handling code here:
            BaletskaGrupa baletskaGrupa=kontroler.vratiBaletskuGrupu();
            new FormaPromeniPodatkeBaletskeGrupe(this, baletskaGrupa).setVisible(true);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }                                         

/**
 * @param args the command line arguments
 */

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnIzmeni2;
    private javax.swing.JButton btnZakazi2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblGrupe2;
    // End of variables declaration                   

   
 
    void azurirajTabelu(BaletskaGrupa baletskaGrupa) {
        kontroler.azuriraj(baletskaGrupa);
    }

    @Override
    public ApstraktniDomenskiObjekat kreirajObjekat() {
        return new BaletskaGrupa();
    }

    public JTable getTblGrupe2() {
        return tblGrupe2;
    }

    public void setTblGrupe2(JTable tblGrupe2) {
        this.tblGrupe2 = tblGrupe2;
    }
    
}
