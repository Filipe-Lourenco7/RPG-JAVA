package rpg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import rpg.jogatina;

public class NovoJogoFrame extends javax.swing.JFrame {
    public NovoJogoFrame() {
        initComponents();
            //colocando botão para selecionar apenas um.
            buttonGroup1.add(jRadioButton1);
            buttonGroup1.add(jRadioButton2);
            jRadioButton1.setSelected(true);
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rpg/Masculino.png")));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        jTextField1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setText("Nome:");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(16, 33, 239, 25);

        jComboBox1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(102, 102, 102));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerreiro", "Mago", "Curandeiro" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(16, 76, 107, 25);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Status:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 110, 140, 110);

        jRadioButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Masculino");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton1);
        jRadioButton1.setBounds(20, 220, 89, 24);

        jRadioButton2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Feminino");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton2);
        jRadioButton2.setBounds(130, 220, 100, 24);

        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton1.setText("Criar Personagem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(20, 280, 170, 26);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rpg/Feminino.png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(300, -10, 320, 420);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rpg/FundoPreto.jpg"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, -20, 612, 440);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
        String classe = jComboBox1.getSelectedItem().toString();
        // Neste código muda o status dependendo da escolha do usuário.
    switch (classe) {
        case "Guerreiro":
            jLabel1.setText("<html>Status:<br>Nível: 1<br>Força: Alta<br>Magia: Baixa</html>");
            break;
        case "Mago":
            jLabel1.setText("<html>Status:<br>Nível: 1<br>Força: Baixa<br>Magia: Alta</html>");
            break;
        case "Curandeiro":
            jLabel1.setText("<html>Status:<br>Nível: 1<br>Força: Média<br>Magia: Média<br>Suporte: Alto</html>");
            break;
        default:
            jLabel1.setText("Status:<br>Nível: 1<br>Força: Alta<br>Magia: Baixa</html>");
    }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        //Comando para trocar imagem quando clica no radio button
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rpg/Masculino.png")));
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        //Comando para trocar imagem quando clica no radio button
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rpg/Feminino.png")));
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:        
    String nome = jTextField1.getText();
    String classe = jComboBox1.getSelectedItem().toString();
    String genero = jRadioButton1.isSelected() ? "Masculino" : "Feminino";

    // Verificação simples
    if (nome.isEmpty() || nome.equals("Nome:")) {
        JOptionPane.showMessageDialog(this, "Digite um nome válido.");
        return;
    }

    try {
        // Conexão com SQLite
        Connection conn = DriverManager.getConnection("jdbc:sqlite:jogo.db");
        Statement stmt = conn.createStatement();

        // Criação da tabela se não existir (uma vez só)
        String sqlCreate = "CREATE TABLE IF NOT EXISTS personagem (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, classe TEXT, genero TEXT)";
        stmt.execute(sqlCreate);

        // Inserção dos dados
        String sqlInsert = String.format("INSERT INTO personagem (nome, classe, genero) VALUES ('%s', '%s', '%s')",
                                         nome, classe, genero);
        stmt.executeUpdate(sqlInsert);

        // Fechar conexão
        stmt.close();
        conn.close();

        JOptionPane.showMessageDialog(this, "Personagem criado com sucesso!");

        // Iniciar o jogo
        jogatina novo = new jogatina();
        novo.setVisible(true);
        this.dispose();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao salvar personagem: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NovoJogoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoJogoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoJogoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoJogoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoJogoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
