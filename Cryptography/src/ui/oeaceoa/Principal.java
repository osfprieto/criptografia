package ui.oeaceoa;


import java.awt.Color;
import cryptography.*;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tato
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        inicioDefault();
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taPlainText = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taCipherText = new javax.swing.JTextArea();
        lblPlainText = new javax.swing.JLabel();
        lblCipherText = new javax.swing.JLabel();
        cbCifrar = new javax.swing.JCheckBox();
        cbDescifrar = new javax.swing.JCheckBox();
        jpShift = new javax.swing.JPanel();
        lblKey = new javax.swing.JLabel();
        tfKey = new javax.swing.JTextField();
        jpOptions = new javax.swing.JPanel();
        cboxOptions = new javax.swing.JComboBox();
        btnRun = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taPlainText.setColumns(20);
        taPlainText.setRows(5);
        jScrollPane1.setViewportView(taPlainText);

        taCipherText.setColumns(20);
        taCipherText.setRows(5);
        jScrollPane2.setViewportView(taCipherText);

        lblPlainText.setText("Texto Plano");

        lblCipherText.setText("Texto Cifrado");

        cbCifrar.setText("Cifrar");
        cbCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCifrarActionPerformed(evt);
            }
        });

        cbDescifrar.setText("Descifrar");
        cbDescifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDescifrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(lblPlainText, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCipherText, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCifrar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbDescifrar)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCifrar)
                    .addComponent(cbDescifrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlainText)
                    .addComponent(lblCipherText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        lblKey.setText("Key = ");

        javax.swing.GroupLayout jpShiftLayout = new javax.swing.GroupLayout(jpShift);
        jpShift.setLayout(jpShiftLayout);
        jpShiftLayout.setHorizontalGroup(
            jpShiftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpShiftLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblKey)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfKey, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpShiftLayout.setVerticalGroup(
            jpShiftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpShiftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpShiftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfKey))
                .addContainerGap())
        );

        jpOptions.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));
        jpOptions.setName("Opciones"); // NOI18N

        cboxOptions.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Desplazamiento", "Vigenere" }));
        cboxOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxOptionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpOptionsLayout = new javax.swing.GroupLayout(jpOptions);
        jpOptions.setLayout(jpOptionsLayout);
        jpOptionsLayout.setHorizontalGroup(
            jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOptionsLayout.createSequentialGroup()
                .addComponent(cboxOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 432, Short.MAX_VALUE))
        );
        jpOptionsLayout.setVerticalGroup(
            jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboxOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRun.setText("Run");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpShift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRun))
                    .addComponent(jpOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpShift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnRun)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCifrarActionPerformed
        // TODO add your handling code here:
        cbDescifrar.setSelected(false);
        taCipherText.setEnabled(false);
        taCipherText.setText("");
        taPlainText.setEnabled(true);
        jpOptions.setVisible(true);
        cboxOptions.setSelectedIndex(0);
        
    }//GEN-LAST:event_cbCifrarActionPerformed

    private void cbDescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDescifrarActionPerformed
        // TODO add your handling code here:
        cbCifrar.setSelected(false);
        taCipherText.setEnabled(true);
        taPlainText.setEnabled(false);
        taPlainText.setText("");
        jpOptions.setVisible(true);
        cboxOptions.setSelectedIndex(0);
        jpShift.setVisible(false);
        taPlainText.setText(""); 
       
    }//GEN-LAST:event_cbDescifrarActionPerformed

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        // TODO add your handling code here:
        ShiftCipher encryptor = new ShiftCipher();
        
        if(cboxOptions.getSelectedItem() == "Desplazamiento")
        {            
            if(cbCifrar.isSelected() == true)
            {
                encryptor.setClearData(taPlainText.getText());
                encryptor.setKeys(tfKey.getText());
                
                //taCipherText.setText(encryptor.shiftEncryptor());
                encryptor.cipher();
                taCipherText.setText((String)encryptor.getCipherData());  
            }
            else if(cbDescifrar.isSelected() == true)
            {
                encryptor.setCipherData(taCipherText.getText());
                encryptor.decipher();
                taPlainText.setText((String) encryptor.getClearData());
            }
        }
    }//GEN-LAST:event_btnRunActionPerformed

    private void cboxOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxOptionsActionPerformed
        // TODO add your handling code here:
        if(cboxOptions.getSelectedItem() == "Desplazamiento")
        {  
           if(cbCifrar.isSelected() == true)
           {
               jpShift.setVisible(true);
           }
           else if(cbDescifrar.isSelected() == true)
           {
               jpShift.setVisible(false);
           }
        }
        else if(cboxOptions.getSelectedItem() == "Vigenere")
        {
           if(cbCifrar.isSelected() == true)
           {
           
           }
           else if(cbDescifrar.isSelected() == true)
           {
           
           }
        }
    }//GEN-LAST:event_cboxOptionsActionPerformed

    private void inicioDefault()
    {
      taCipherText.setEnabled(false);
      taPlainText.setEnabled(false);
      jpOptions.setVisible(false);
      jpShift.setVisible(false);     
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRun;
    private javax.swing.JCheckBox cbCifrar;
    private javax.swing.JCheckBox cbDescifrar;
    private javax.swing.JComboBox cboxOptions;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpOptions;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JPanel jpShift;
    private javax.swing.JLabel lblCipherText;
    private javax.swing.JLabel lblKey;
    private javax.swing.JLabel lblPlainText;
    private javax.swing.JTextArea taCipherText;
    private javax.swing.JTextArea taPlainText;
    private javax.swing.JTextField tfKey;
    // End of variables declaration//GEN-END:variables
}
