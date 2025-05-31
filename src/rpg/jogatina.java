package rpg;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class jogatina extends javax.swing.JFrame {
   private int personagemId;
    private String nome;
    private String classe;
    private String genero;

    // Construtor principal, recebe personagemId e dados do personagem
    public jogatina(int personagemId, String nome, String classe, String genero) {
        this.personagemId = personagemId;
        this.nome = nome;
        this.classe = classe;
        this.genero = genero;

        initComponents();

        // Ajusta o label para mostrar dados do personagem
        jLabel5.setText("<html>Nome: " + nome + "<br>Classe: " + classe + "<br>Gênero: " + genero + "</html>");
        jLabel5.setBounds(400, 60, 200, 80);  // Ajuste para o tamanho e posição corretos

        carregarInventario();
    }

    private void carregarInventario() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpa tabela

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "root", "");
            String sql = "SELECT nome_item, quantidade FROM inventario WHERE personagem_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, personagemId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nomeItem = rs.getString("nome_item");
                int quantidade = rs.getInt("quantidade");
                model.addRow(new Object[]{nomeItem, quantidade});
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar inventário: " + e.getMessage());
        }
    }
    public jogatina() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Inventário");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(180, 10, 230, 70);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 240, 600, 130);

        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(480, 180, 130, 40);

        jButton2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton2.setText("Inserir Item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 180, 130, 40);

        jButton3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton3.setText("Deletar Item");
        jPanel1.add(jButton3);
        jButton3.setBounds(170, 180, 130, 40);

        jButton4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton4.setText("Salvar Jogo");
        jPanel1.add(jButton4);
        jButton4.setBounds(320, 180, 130, 40);

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Crie seus itens!!!");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(200, 70, 180, 40);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(520, 60, 0, 0);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rpg/fundopreto2.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 625, 400);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                String nomeItem = JOptionPane.showInputDialog(this, "Nome do item:");
        if (nomeItem == null || nomeItem.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome do item inválido.");
            return;
        }

        String qtdStr = JOptionPane.showInputDialog(this, "Quantidade:");
        int quantidade = 0;
        try {
            quantidade = Integer.parseInt(qtdStr);
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "Quantidade deve ser maior que zero.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida.");
            return;
        }

        // Inserir no banco
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "root", "");

            // Criar tabela se não existir
            Statement stmt = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS inventario (" +
                               "id INT AUTO_INCREMENT PRIMARY KEY, " +
                               "personagem_id INT, " +
                               "nome_item VARCHAR(100), " +
                               "quantidade INT, " +
                               "FOREIGN KEY (personagem_id) REFERENCES personagem(id))";
            stmt.execute(sqlCreate);
            stmt.close();

            // Inserir o item
            String sqlInsert = "INSERT INTO inventario (personagem_id, nome_item, quantidade) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsert);
            ps.setInt(1, personagemId);
            ps.setString(2, nomeItem);
            ps.setInt(3, quantidade);
            ps.executeUpdate();

            ps.close();
            conn.close();

            JOptionPane.showMessageDialog(this, "Item inserido com sucesso!");
            carregarInventario();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao inserir item: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Sair", javax.swing.JOptionPane.YES_NO_OPTION);
    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        System.exit(0);
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
            java.util.logging.Logger.getLogger(jogatina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jogatina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jogatina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jogatina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jogatina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
