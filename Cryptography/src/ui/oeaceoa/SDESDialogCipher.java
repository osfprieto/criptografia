/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.oeaceoa;

import cryptograpy.S_DES.CipherSDES;
import cryptograpy.S_DES.SDESKey;

/**
 *
 * @author Tato
 */
public class SDESDialogCipher extends javax.swing.JDialog {

    /**
     * Creates new form SDESDialog
     */
     private String plainText;
    private String cipherText;
    private boolean cifrar;
    
    public SDESDialogCipher(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("S - DES");
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

        lblKey = new javax.swing.JLabel();
        tfKey = new javax.swing.JTextField();
        lblP10 = new javax.swing.JLabel();
        tfP10 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblP8 = new javax.swing.JLabel();
        tfP8 = new javax.swing.JTextField();
        btnCifrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblKey.setText("Clave (10 bits)");

        tfKey.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfKey.setText("1001001001");
        tfKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKeyActionPerformed(evt);
            }
        });
        tfKey.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfKeyKeyTyped(evt);
            }
        });

        lblP10.setText("P10-Permutación");

        tfP10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfP10.setText("2416390875");
        tfP10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfP10KeyTyped(evt);
            }
        });

        lblP8.setText("P8-Permutación");

        tfP8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfP8.setText("52637498");
        tfP8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfP8ActionPerformed(evt);
            }
        });
        tfP8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfP8KeyTyped(evt);
            }
        });

        btnCifrar.setText("Cifrar");
        btnCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCifrarActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("La clave debe ser un número binario de 10 cifras");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("P10 es una permutación entre números de 0-9 de tamaño 10");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("P8 es una permutación entre números de 0-9 de tamaño 8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblKey, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblP8)
                                            .addComponent(lblP10))
                                        .addGap(26, 26, 26)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfP10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfKey, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(tfP8))))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(btnCifrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKey)
                    .addComponent(tfKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblP10)
                    .addComponent(tfP10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfP8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblP8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(btnCifrar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfKeyActionPerformed

    private void tfKeyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKeyKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar(); 
          if( c != '0' || c != '1' || c != '\b') { 
              getToolkit().beep();  
              evt.consume();
          } 
    }//GEN-LAST:event_tfKeyKeyTyped

    private void tfP8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfP8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfP8ActionPerformed

    private void tfP10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfP10KeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();

              // Verificar si la tecla pulsada no es un digito
              if(((caracter < '0') || (caracter > '9')))
              {
                 getToolkit().beep();
                 evt.consume();  // ignorar el evento de teclado
              }
    }//GEN-LAST:event_tfP10KeyTyped

    private void tfP8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfP8KeyTyped
        // TODO add your handling code here:
         char caracter = evt.getKeyChar();

              // Verificar si la tecla pulsada no es un digito
              if(((caracter < '0') || (caracter > '9')))
              {
                 getToolkit().beep();
                 evt.consume();  // ignorar el evento de teclado
              }
    }//GEN-LAST:event_tfP8KeyTyped

    private void btnCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCifrarActionPerformed
        // TODO add your handling code here:
        CipherSDES encryptor = new CipherSDES();
        encryptor.setCifrar(this.cifrar);
        SDESKey key = new SDESKey();
        key.setP10(this.tfP10.getText());
        key.setP8(this.tfP8.getText());
        key.GenerateKeys(this.tfKey.getText());
        //encryptor.setPlainText(this.plainText);
        encryptor.setKey(key);
        
        //encryptor.setKeys((String) this.tfKeyWord.getText());
        if(this.cifrar == true)
        {
            encryptor.encrypt(plainText, key.getK1(), key.getK2());
        }
        else if(this.cifrar == false)
        {
             encryptor.encrypt(plainText, key.getK2(),  key.getK1() );
        }
        this.setCipherText((String) encryptor.getCipherText());        
        this.hide();
    }//GEN-LAST:event_btnCifrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCifrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblKey;
    private javax.swing.JLabel lblP10;
    private javax.swing.JLabel lblP8;
    private javax.swing.JTextField tfKey;
    private javax.swing.JTextField tfP10;
    private javax.swing.JTextField tfP8;
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

    /**
     * @return the cifrar
     */
    public boolean isCifrar() {
        return cifrar;
    }

    /**
     * @param cifrar the cifrar to set
     */
    public void setCifrar(boolean cifrar) {
        this.cifrar = cifrar;
    }
}
