package br.com.ariane.fiora.app;

import br.com.ariane.fiora.modelo.Artista;
import br.com.ariane.fiora.tables.TableArtistas;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FrmSelecionarArtista extends javax.swing.JFrame {
    private TableArtistas tabelaArtistas;
    private FrmAddAlbum frmAlbum;
    private FrmGerenciarFaixas frmFaixa;
    private FrmAlterarAlbum frmAlterarAlbum;
    private int tipoForm;
        
    public FrmSelecionarArtista() {
        initComponents();
    }
    
    public FrmSelecionarArtista(javax.swing.JInternalFrame form, int tipoForm) {
        this();
        this.tipoForm = tipoForm;
        if (tipoForm == 0) {
            frmAlbum = (FrmAddAlbum) form;
        } else { //tipoForm == 1
            frmFaixa = (FrmGerenciarFaixas) form;
        }
        preencherTabelaArtista();
    }
    
    public FrmSelecionarArtista(javax.swing.JFrame form, int tipoForm) {
        this();
        this.tipoForm = tipoForm;
        //tipoForm == 2
        frmAlterarAlbum = (FrmAlterarAlbum) form;
        preencherTabelaArtista();
    }
    
    private void preencherTabelaArtista(){
        Artista dao = new Artista();
        tabelaArtistas = new TableArtistas(dao.listarArtistas());
        tbArtistas.setModel(tabelaArtistas);
        tbArtistas.setAutoCreateRowSorter(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbArtistas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnDesfazerBusca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecionar Artista");

        tbArtistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Artista", "Nome", "Gênero", "Ano de Criação", "Site", "Tipo do Artista"
            }
        ));
        tbArtistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbArtistasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbArtistas);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/dica.png"))); // NOI18N
        jLabel2.setText("Clique duas vezes sobre o artista para selecioná-lo.");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Busca de Artista"));

        jLabel3.setText("Nome:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/procurar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10)))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        btnDesfazerBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/limpar.png"))); // NOI18N
        btnDesfazerBusca.setText("Desfazer busca");
        btnDesfazerBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesfazerBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDesfazerBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnDesfazerBusca))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (tfNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite um nome para a busca", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            Artista dao = new Artista();
            ArrayList<Artista> artistas = dao.buscarArtista(tfNome.getText());

            if (artistas.isEmpty()){
                preencherTabelaArtista();
                JOptionPane.showMessageDialog(this, "Nenhum artista foi encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                tabelaArtistas = new TableArtistas(artistas);
                tbArtistas.setModel(tabelaArtistas);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnDesfazerBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesfazerBuscaActionPerformed
        preencherTabelaArtista();
        tfNome.setText("");
    }//GEN-LAST:event_btnDesfazerBuscaActionPerformed

    private void tbArtistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbArtistasMouseClicked
        if(evt.getClickCount() == 2){
            int linhaSelecionada = tbArtistas.getSelectedRow();
            tabelaArtistas = (TableArtistas)tbArtistas.getModel();           
            Artista artista = tabelaArtistas.retornarObjetoSelecionado(linhaSelecionada);
            
            if (tipoForm == 0) {
                frmAlbum.atualizarArtista(artista);
            } else {
                if (tipoForm == 1) {
                    frmFaixa.atualizarArtista(artista);
                    frmFaixa.preencherComboAlbum();
                } else {
                    frmAlterarAlbum.atualizarArtista(artista);
                }
            }
            
            this.dispose();
        }
    }//GEN-LAST:event_tbArtistasMouseClicked

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
            java.util.logging.Logger.getLogger(FrmSelecionarArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSelecionarArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSelecionarArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSelecionarArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSelecionarArtista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDesfazerBusca;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbArtistas;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
