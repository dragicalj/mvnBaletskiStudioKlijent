package rs.ac.bg.fon.nprog.forme.baletskagrupa;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.BaletskaGrupa;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.kontroler.KontrolerKIKreirajBaletskuGrupu;

public class FormaKreirajBaletskuGrupu extends OpstaEkranskaForma {

    private BaletskaGrupa baletskaGrupa;
    private final KontrolerKIKreirajBaletskuGrupu kontroler;

    /**
     * Creates new form FormaKreirajBaletskuGrupu
     */
    public FormaKreirajBaletskuGrupu() {
        initComponents();
        kontroler = new KontrolerKIKreirajBaletskuGrupu(this);
        kontroler.popuniTipGrupe();
        kontroler.popuniKoreografe();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBaletskaGrupaId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNazivGrupe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbTipGrupe = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtKapacitet = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbKoreograf = new javax.swing.JComboBox();
        btnKreiraj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Baletska grupa"));

        jLabel1.setText("ID:");

        txtBaletskaGrupaId.setEditable(false);

        jLabel2.setText("Naziv grupe:");

        jLabel3.setText("Tip grupe:");

        jLabel4.setText("Kapacitet:");

        jLabel5.setText("Koreograf:");

        btnKreiraj.setText("Kreiraj baletsku grupu");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnKreiraj)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBaletskaGrupaId)
                            .addComponent(txtNazivGrupe, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(cmbTipGrupe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKapacitet)
                            .addComponent(cmbKoreograf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBaletskaGrupaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNazivGrupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipGrupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtKapacitet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbKoreograf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKreiraj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (txtNazivGrupe.getText().isEmpty() || txtKapacitet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sva polja su obavezna!");
            return;
        }
        kontroler.SOKreirajBaletskuGrupu();
    }                                          

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JComboBox cmbKoreograf;
    private javax.swing.JComboBox cmbTipGrupe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBaletskaGrupaId;
    private javax.swing.JTextField txtKapacitet;
    private javax.swing.JTextField txtNazivGrupe;
    // End of variables declaration                   

    @Override
    public ApstraktniDomenskiObjekat kreirajObjekat() {
        return new BaletskaGrupa();
    }

    public JButton getBtnKreiraj() {
        return btnKreiraj;
    }

    public JComboBox getCmbKoreograf() {
        return cmbKoreograf;
    }

    public JComboBox getCmbTipGrupe() {
        return cmbTipGrupe;
    }

    public JTextField getTxtBaletskaGrupaId() {
        return txtBaletskaGrupaId;
    }

    public JTextField getTxtKapacitet() {
        return txtKapacitet;
    }

    public JTextField getTxtNazivGrupe() {
        return txtNazivGrupe;
    }

}
