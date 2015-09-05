/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.oeaceoa;

import cryptography.VigenereCipher;

/**
 *
 * @author Tato
 */
public class VigenereDecipherDialog extends javax.swing.JDialog {

    /**
     * Creates new form VigenereDecipherDialog
     */
    private String plainText;
    private String cipherText;
    
    public VigenereDecipherDialog(Principal parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Descifrado Vigenere");
        this.setLocationRelativeTo(null);
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

        jLabel1 = new javax.swing.JLabel();
        tfKeyword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnDescifar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Keyword");

        tfKeyword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfKeyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKeywordActionPerformed(evt);
            }
        });

        jLabel2.setText("Posible palabra clave para decifrar el texto");

        btnDescifar.setText("Descifrar");
        btnDescifar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescifarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(tfKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnDescifar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDescifar)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfKeywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKeywordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfKeywordActionPerformed

    private void btnDescifarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescifarActionPerformed
        // TODO add your handling code here:
        VigenereCipher encryptor = new VigenereCipher();
        encryptor.setCipherData(getCipherText());
        encryptor.setKeys(this.tfKeyword.getText());
        encryptor.decipher();
        this.setPlainText((String)encryptor.getClearData());           
        this.hide();
    }//GEN-LAST:event_btnDescifarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDescifar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfKeyword;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the plainText
     */
    public String getPlainText() {
        return plainText;
    }

    /**
     * @param plainText the plainText to set
     */
    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    /**
     * @return the cipherText
     */
    public String getCipherText() {
        return cipherText;
    }

    /**
     * @param cipherText the cipherText to set
     */
    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }
}
