/*
 * MainframeJF: Finestra principale in jFrame GUI.
 */

package view;

/**
 *
 * @author Sandro
 */
public class MainframeGUI extends javax.swing.JFrame {

    private control.ControlloGUI ctrl = null;
    
    public MainframeGUI() {
        initComponents();
    }

    public void initControl(control.ControlloGUI ctrl, String cclist) {
        this.setTitle("Bank GUI");
        this.ctrl = ctrl;
        String[] v = cclist.split(",");
        for (String cc : v) cmbConto.addItem(cc);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConto = new javax.swing.JLabel();
        lblOperazione = new javax.swing.JLabel();
        lblImporto = new javax.swing.JLabel();
        cmbConto = new javax.swing.JComboBox();
        cmbOperazione = new javax.swing.JComboBox();
        txtImporto = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel();
        btnExec = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblConto.setLabelFor(cmbConto);
        lblConto.setText("Codice conto corrente:");

        lblOperazione.setLabelFor(cmbOperazione);
        lblOperazione.setText("Operazione:");

        lblImporto.setLabelFor(txtImporto);
        lblImporto.setText("Importo:");

        cmbOperazione.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Saldo", "Deposito", "Prelievo", "Estratto conto" }));

        lblMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                erase(evt);
            }
        });

        btnExec.setText("Esegui");
        btnExec.setFocusPainted(false);
        btnExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExec))
                            .addComponent(lblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblImporto)
                            .addComponent(lblOperazione)
                            .addComponent(lblConto))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbConto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtImporto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbOperazione, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConto)
                    .addComponent(cmbConto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOperazione)
                    .addComponent(cmbOperazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImporto)
                    .addComponent(txtImporto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnExec)
                .addGap(18, 18, 18)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void erase(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_erase
        lblMessage.setText("");
    }//GEN-LAST:event_erase

    private void btnExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecActionPerformed
        double imp = 0;
        try { imp = Double.parseDouble(txtImporto.getText()); } catch (Exception ex) {}
        int op = cmbOperazione.getSelectedIndex();
        String res = ctrl.exec(cmbConto.getSelectedIndex(), op, imp);
        if (op!=3) lblMessage.setText(res);
        else javax.swing.JOptionPane.showMessageDialog(this, res);
    }//GEN-LAST:event_btnExecActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExec;
    private javax.swing.JComboBox cmbConto;
    private javax.swing.JComboBox cmbOperazione;
    private javax.swing.JLabel lblConto;
    private javax.swing.JLabel lblImporto;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblOperazione;
    private javax.swing.JTextField txtImporto;
    // End of variables declaration//GEN-END:variables
}
