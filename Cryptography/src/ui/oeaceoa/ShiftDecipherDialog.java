/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.oeaceoa;

import cryptography.ShiftCipher;

/**
 *
 * @author Tato
 */
public class ShiftDecipherDialog extends javax.swing.JDialog {

    /**
     * Creates new form ShiftDecipher
     */
    private String plainText;
    private String cipherText;
    
    public ShiftDecipherDialog(Principal parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Descifrado por desplazamiento");
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

        btnDescifrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnDescifrar.setText("Descifrar");
        btnDescifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescifrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Se aplicará el método de búsqueda exhaustiva para decifrar el texto ingresado");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDescifrar)
                        .addGap(225, 225, 225))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDescifrar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescifrarActionPerformed
        // TODO add your handling code here:
        ShiftCipher encryptor = new ShiftCipher();
        encryptor.setCipherData(getCipherText());
        encryptor.decipher();
        this.setPlainText((String)encryptor.getClearData());           
        this.hide();
    }//GEN-LAST:event_btnDescifrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDescifrar;
    private javax.swing.JLabel jLabel1;
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
