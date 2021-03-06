package rs.ac.bg.fon.nprog.forme.lokacija;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import rs.ac.bg.fon.nprog.domen.ApstraktniDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Lokacija;
import rs.ac.bg.fon.nprog.forme.OpstaEkranskaForma;
import rs.ac.bg.fon.nprog.kontroler.KontrolerKIKreirajLokaciju;

public class FormaKreirajLokaciju extends OpstaEkranskaForma {
    
    private Lokacija lokacija;
    private final KontrolerKIKreirajLokaciju kontroler;
    

    /**
     * Creates new form FormaKreirajLokaciju
     */
    public FormaKreirajLokaciju() {
        initComponents();
        kontroler=new KontrolerKIKreirajLokaciju(this);
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
        txtLokacijaId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNazivGrada = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNazivUstanove = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSala = new javax.swing.JTextField();
        btnKreiraj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lokacija za održavanje nastupa"));

        jLabel1.setText("ID:");

        txtLokacijaId.setEditable(false);

        jLabel2.setText("Naziv grada:");

        jLabel3.setText("Naziv ustanove:");

        jLabel4.setText("Sala:");

        btnKreiraj.setText("Kreiraj");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLokacijaId)
                            .addComponent(txtSala)
                            .addComponent(txtNazivGrada)
                            .addComponent(txtNazivUstanove, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnKreiraj)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLokacijaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNazivGrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNazivUstanove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnKreiraj)
                .addGap(23, 23, 23))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(txtNazivGrada.getText().isEmpty()|| txtNazivUstanove.getText().isEmpty() || txtSala.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "Sva polja su obavezna!");
            return;
        }
        kontroler.SOKreirajLokaciju(); 
    }                                          

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtLokacijaId;
    private javax.swing.JTextField txtNazivGrada;
    private javax.swing.JTextField txtNazivUstanove;
    private javax.swing.JTextField txtSala;
    // End of variables declaration                   

    @Override
    public ApstraktniDomenskiObjekat kreirajObjekat() {
        return new Lokacija();
    }

    public JTextField getTxtLokacijaId() {
        return txtLokacijaId;
    }

    public JTextField getTxtNazivGrada() {
        return txtNazivGrada;
    }

    public JTextField getTxtNazivUstanove() {
        return txtNazivUstanove;
    }

    public JTextField getTxtSala() {
        return txtSala;
    }
    
    
}

