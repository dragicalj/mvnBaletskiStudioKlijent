package rs.ac.bg.fon.nprog.forme;

import rs.ac.bg.fon.nprog.forme.koreograf.FormaKreirajKoreografa;

public class FormaGlavna extends javax.swing.JFrame {

    /**
     * Creates new form FormaGlavna
     */
    public FormaGlavna() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jmbMain = new javax.swing.JMenuBar();
        jmiKreiraj = new javax.swing.JMenu();
        jmiKreirajKoreografa = new javax.swing.JMenuItem();
        jmiPrikaziKoreografe = new javax.swing.JMenuItem();
        jmIgrac = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmGrupa = new javax.swing.JMenu();
        jmiKreirajGrupu = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jmNastup = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jmLokacija = new javax.swing.JMenu();
        jmiDodajLokaciju = new javax.swing.JMenuItem();
        jmLogout = new javax.swing.JMenu();
        jmiLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jmiKreiraj.setText("Koreograf");

        jmiKreirajKoreografa.setText("Kreiraj novog");
        jmiKreirajKoreografa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiKreirajKoreografaActionPerformed(evt);
            }
        });
        jmiKreiraj.add(jmiKreirajKoreografa);

        jmiPrikaziKoreografe.setText("Prikazi sve");
        jmiPrikaziKoreografe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPrikaziKoreografeActionPerformed(evt);
            }
        });
        jmiKreiraj.add(jmiPrikaziKoreografe);

        jmbMain.add(jmiKreiraj);

        jmIgrac.setText("Baletski igrac");

        jMenuItem2.setText("Kreiraj novog");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmIgrac.add(jMenuItem2);

        jMenuItem4.setText("Prikazi sve");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmIgrac.add(jMenuItem4);

        jmbMain.add(jmIgrac);

        jmGrupa.setText("Baletska grupa");

        jmiKreirajGrupu.setText("Kreiraj novu");
        jmiKreirajGrupu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiKreirajGrupuActionPerformed(evt);
            }
        });
        jmGrupa.add(jmiKreirajGrupu);

        jMenuItem6.setText("Prikazi sve");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jmGrupa.add(jMenuItem6);

        jmbMain.add(jmGrupa);

        jmNastup.setText("Nastup");

        jMenuItem7.setText("Zakazi novi");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jmNastup.add(jMenuItem7);

        jMenuItem8.setText("Prikazi zakazane");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jmNastup.add(jMenuItem8);

        jmbMain.add(jmNastup);

        jmLokacija.setText("Lokacija");

        jmiDodajLokaciju.setText("Dodaj novu");
        jmiDodajLokaciju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDodajLokacijuActionPerformed(evt);
            }
        });
        jmLokacija.add(jmiDodajLokaciju);

        jmbMain.add(jmLokacija);

        jmLogout.setText("Izloguj se");

        jmiLogout.setText("Izloguj se");
        jmiLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLogoutActionPerformed(evt);
            }
        });
        jmLogout.add(jmiLogout);

        jmbMain.add(jmLogout);

        setJMenuBar(jmbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jmiKreirajKoreografaActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        new FormaKreirajKoreografa().setVisible(true);
    }                                                    

    private void jmiPrikaziKoreografeActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        //new FormaPrikaziSveKoreografe().setVisible(true);
    }                                                    

    private void jmiDodajLokacijuActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        //new FormaKreirajLokaciju().setVisible(true);
    }                                                

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //new FormaKreirajNastup().setVisible(true);
    }                                          

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //new FormaKreirajBaletskogIgraca().setVisible(true);
    }                                          

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //new FormaPrikaziSveBaletskeIgrace().setVisible(true);
    }                                          

    private void jmiKreirajGrupuActionPerformed(java.awt.event.ActionEvent evt) {                                                
        //new FormaKreirajBaletskuGrupu().setVisible(true);
    }                                               

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
       // new FormaPrikaziSveBaletskeGrupe().setVisible(true);
    }                                          

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //new FormaPrikaziSveNastupe().setVisible(true);
    }                                          

    private void jmiLogoutActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify                     
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenu jmGrupa;
    private javax.swing.JMenu jmIgrac;
    private javax.swing.JMenu jmLogout;
    private javax.swing.JMenu jmLokacija;
    private javax.swing.JMenu jmNastup;
    private javax.swing.JMenuBar jmbMain;
    private javax.swing.JMenuItem jmiDodajLokaciju;
    private javax.swing.JMenu jmiKreiraj;
    private javax.swing.JMenuItem jmiKreirajGrupu;
    private javax.swing.JMenuItem jmiKreirajKoreografa;
    private javax.swing.JMenuItem jmiLogout;
    private javax.swing.JMenuItem jmiPrikaziKoreografe;
    // End of variables declaration                   
}
