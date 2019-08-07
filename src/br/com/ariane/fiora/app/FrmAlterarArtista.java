package br.com.ariane.fiora.app;

import br.com.ariane.fiora.modelo.Album;
import br.com.ariane.fiora.modelo.Artista;
import br.com.ariane.fiora.modelo.Usuario;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FrmAlterarArtista extends javax.swing.JFrame {
    private FrmListagem frmListagem;
    private Artista a = new Artista();
    private int codigoArtista;
    private JFileChooser fc;
    private File f;
    private Usuario usuario;
    private boolean alterarImagem = false;
    
    public FrmAlterarArtista() {
        initComponents();
        preencherComboTipoArtista();
    }
    
    //Passa por parâmetro o frame Listagem, o artista atual e o usuário ativo
    public FrmAlterarArtista(javax.swing.JInternalFrame form, int codigo, Usuario usuario) {
        this();
        frmListagem = (FrmListagem) form;
        this.codigoArtista = codigo;
        preencherCamposTela(codigoArtista);
        this.usuario = usuario;
    }
    
    //Preenche os campos com os dados do artista selecionado
    private void preencherCamposTela(int codigoArtista){
        a = a.buscarArtista(codigoArtista);
        tfNome.setText(a.getNome());
        tfGenero.setText(a.getGenero());
        tfAnoCriacao.setText(Integer.toString(a.getAnoCriacao()));
        tfSite.setText(a.getSite());
        lbFoto.setIcon(new ImageIcon(a.abrirImagem(a.getCodArtista()).getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(), Image.SCALE_DEFAULT)));
    }
    
    private void preencherComboTipoArtista() {
        cbTipoArtista.removeAllItems();
        cbTipoArtista.addItem("Banda");
        cbTipoArtista.addItem("Cantor(a) Solo");
        cbTipoArtista.addItem("Grupo");
        cbTipoArtista.addItem("Orquestra");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfAnoCriacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfSite = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfGenero = new javax.swing.JTextField();
        cbTipoArtista = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        btnSelecionar = new javax.swing.JButton();
        lbFoto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        lbDica = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Artista");

        jPanel1.setPreferredSize(new java.awt.Dimension(652, 500));

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/atualizar.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do Artista"));

        jLabel2.setText("Gênero:");

        jLabel4.setText("Site Oficial:");

        jLabel1.setText("*Nome:");

        jLabel3.setText("*Ano da Criação:");

        jLabel5.setText("*Tipo do Artista:");

        cbTipoArtista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSite)
                    .addComponent(tfNome)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfAnoCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipoArtista, 0, 153, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfAnoCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbTipoArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto do Artista"));

        btnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/adicionar.png"))); // NOI18N
        btnSelecionar.setText("Selecionar Imagem");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        lbFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel6.setText("Foto selecionada:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSelecionar)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSelecionar)
                            .addComponent(jLabel6))
                        .addGap(0, 226, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        lbDica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/dica.png"))); // NOI18N
        lbDica.setText("Campos com * são obrigatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSair))
                            .addComponent(lbDica, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            //Valida campos obrigatórios
            if ((tfNome.getText().isEmpty()) || (tfAnoCriacao.getText().isEmpty())) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                //Valida o ano
                if ((tfAnoCriacao.getComponentCount() > 4) || Calendar.getInstance().get(Calendar.YEAR) < Integer.parseInt(tfAnoCriacao.getText())) {
                    tfAnoCriacao.setText("");
                    JOptionPane.showMessageDialog(this, "Ano de Criação incorreto!\nVerifique e tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    //Cria um objeto do tipo Artista para alterar os dados na classe
                    Artista artista = new Artista();

                    artista.setNome(tfNome.getText());
                    artista.setSite(tfSite.getText());
                    artista.setAnoCriacao(Integer.parseInt(tfAnoCriacao.getText()));
                    artista.setGenero(tfGenero.getText());
                    artista.setCodArtista(codigoArtista);
                    artista.setLoginUsuario(usuario.getLogin());
                    artista.setTipoArtista((String) cbTipoArtista.getSelectedItem());
                    
                    if (alterarImagem) {
                        //Altera os dados no banco de dados caso seja selecionada uma nova imagem
                        artista.alterarArtista(artista, f);
                    } else {
                        //Altera os dados no banco de dados sem uma nova imagem
                        artista.alterarArtista(artista);
                    }
                    
                    //Atualiza o frame Listagem e finaliza o frame de alteração
                    frmListagem.preencherTabelaAlbum(codigoArtista);
                    frmListagem.preencherTabelaArtista();
                    frmListagem.atualizarDetalhesArtista();
                    frmListagem.limparTela();
                    JOptionPane.showMessageDialog(this, "Artista alterado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    
                    this.dispose();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite somente números no campo Ano de Criação", "Erro", JOptionPane.ERROR_MESSAGE);
            tfAnoCriacao.setText("");
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, "Nulo", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja excluir esse artista?", "Confirmação", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcao == 0) {
            //Excluir todos os álbuns pertencentes ao artista
            FrmAlterarAlbum frm = new FrmAlterarAlbum();
            Album album = new Album();
            ArrayList<Album> albuns = album.listarAlbuns(codigoArtista);
            for (Album al: albuns) {
                frm.excluirAlbuns(al.getCodAlbum());
            }
            
            //Excluir o artista
            a.excluirArtista(a);
            
            //Atualiza o frame Listagem e finaliza o frame de alteração
            frmListagem.preencherTabelaAlbum(codigoArtista);
            frmListagem.preencherTabelaArtista();
            frmListagem.atualizarDetalhesArtista();
            frmListagem.limparTela();
            JOptionPane.showMessageDialog(this, "Artista excluído com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        //Cria um arquivo JFileChooser e retorna ao objeto File o que foi selecionado
        try {
            alterarImagem = true;
            fc = new JFileChooser();
            fc.setDialogTitle("Selecione o arquivo");
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                f = fc.getSelectedFile();
                
                //Transforma o arquivo em objeto File e o exibe no lbCapa
                Image capa = ImageIO.read(f);
                lbFoto.setIcon(new ImageIcon(capa.getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(), Image.SCALE_DEFAULT)));  
            }
        } catch (IOException ex) {  
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAlterarArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAlterarArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAlterarArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAlterarArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAlterarArtista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox cbTipoArtista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbDica;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JTextField tfAnoCriacao;
    private javax.swing.JTextField tfGenero;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfSite;
    // End of variables declaration//GEN-END:variables
}
