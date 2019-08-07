package br.com.ariane.fiora.app;

import br.com.ariane.fiora.modelo.Album;
import br.com.ariane.fiora.modelo.Artista;
import br.com.ariane.fiora.modelo.Usuario;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FrmAddAlbum extends javax.swing.JInternalFrame {
    private int codigoArtista;
    private JFileChooser fc;
    private File f;
    private Usuario usuario;
    
    public FrmAddAlbum() {
        initComponents();
        preencherComboMidia();
    }
    
    //Parâmetro contém o usuário logado no momento
    public FrmAddAlbum(Usuario usuario) {
        this();
        this.usuario = usuario;
    }
    
    //Apaga todos os dados dos campos preenchidos
    private void limparTela() {
        tfTitulo.setText("");
        tfAnoLancamento.setText("");
        tfGravadora.setText("");
        lbCapa.setIcon(null);
        lbArtista.setText("");
    }
    
    //Configura a posição do Internal Frame para o meio do DesktopPane
    public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    } 
    
    //Atualiza o artista assim que o FrmSelecionarArtista o aciona
    public void atualizarArtista(Artista a) {
        codigoArtista = a.getCodArtista();
        lbArtista.setText(a.getNome());
    }
    
    private void preencherComboMidia() {
        cbMidia.removeAllItems();
        cbMidia.addItem("CD");
        cbMidia.addItem("CD Ao Vivo");
        cbMidia.addItem("CD Duplo");
        cbMidia.addItem("Vinil");
        cbMidia.addItem("Vinil Ao Vivo");
        cbMidia.addItem("Vinil Duplo");
        cbMidia.addItem("Coletânea");
        cbMidia.addItem("DVD");
        cbMidia.addItem("Fita Cassete");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfGravadora = new javax.swing.JTextField();
        tfAnoLancamento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbMidia = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        btnImagem = new javax.swing.JButton();
        lbCapa = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnArtista = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbArtista = new javax.swing.JLabel();
        btnLimparTela = new javax.swing.JButton();
        btnIncluir = new javax.swing.JButton();
        lbDica = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Incluir Álbum");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do Álbum"));

        jLabel1.setText("*Título do Álbum:");

        jLabel5.setText("*Mídia:");

        jLabel3.setText("Gravadora:");

        jLabel2.setText("*Ano de Lançamento:");

        cbMidia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTitulo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfAnoLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMidia, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfGravadora, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tfAnoLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(cbMidia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tfGravadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("*Capa do Álbum"));

        btnImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/adicionar.png"))); // NOI18N
        btnImagem.setText("Selecionar Imagem");
        btnImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagemActionPerformed(evt);
            }
        });

        lbCapa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel4.setText("Capa selecionada:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImagem)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lbCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnImagem)
                        .addComponent(jLabel4))
                    .addComponent(lbCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("*Artista do Álbum"));

        btnArtista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/adicionar.png"))); // NOI18N
        btnArtista.setText("Selecionar Artista");
        btnArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArtistaActionPerformed(evt);
            }
        });

        jLabel7.setText("Artista selecionado:");

        lbArtista.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbArtista.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnArtista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(lbArtista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnLimparTela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/limpar.png"))); // NOI18N
        btnLimparTela.setText("Limpar Tela");
        btnLimparTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparTelaActionPerformed(evt);
            }
        });

        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/confirmar.png"))); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        lbDica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/dica.png"))); // NOI18N
        lbDica.setText("Campos com * são obrigatórios");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbDica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimparTela)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparTela)
                    .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDica))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagemActionPerformed
        //Cria um arquivo JFileChooser e retorna ao objeto File o que foi selecionado
        try {
            fc = new JFileChooser();
            fc.setDialogTitle("Selecione o arquivo");
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                f = fc.getSelectedFile();
                
                //Transforma o arquivo em objeto File e o exibe no lbCapa
                Image capa = ImageIO.read(f);
                lbCapa.setIcon(new ImageIcon(capa.getScaledInstance(lbCapa.getWidth(), lbCapa.getHeight(), Image.SCALE_DEFAULT)));  
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);  
        }       
    }//GEN-LAST:event_btnImagemActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        try {
            //Valida campos obrigatórios
            if ((tfTitulo.getText().isEmpty()) || (tfAnoLancamento.getText().isEmpty()) || (lbArtista.getText().isEmpty()) || (f == null)) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                //Valida o ano
                if ((tfAnoLancamento.getComponentCount() > 4) || Calendar.getInstance().get(Calendar.YEAR) < Integer.parseInt(tfAnoLancamento.getText())) {
                    JOptionPane.showMessageDialog(this, "Ano de Lançamento incorreto!\nVerifique e tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    //Cria um objeto do tipo Album para incluir os dados na classe
                    Album album = new Album();
                    
                    album.setTitulo(tfTitulo.getText());
                    album.setAnoLancamento(Integer.parseInt(tfAnoLancamento.getText()));
                    album.setGravadora(tfGravadora.getText());
                    album.setCodArtista(codigoArtista);
                    album.setLoginUsuario(usuario.getLogin());
                    album.setMidia((String) cbMidia.getSelectedItem());

                    //Adiciona os dados no banco de dados
                    album.incluirAlbum(album, f);

                    JOptionPane.showMessageDialog(this, "Álbum cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    limparTela();
                    this.dispose();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite somente números no campo Ano de Lançamento", "Erro", JOptionPane.ERROR_MESSAGE);
            tfAnoLancamento.setText("");
        } 
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnLimparTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparTelaActionPerformed
        limparTela();
    }//GEN-LAST:event_btnLimparTelaActionPerformed

    private void btnArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArtistaActionPerformed
        //Cria novo formulário para alteração do artista
        FrmSelecionarArtista frm = new FrmSelecionarArtista(this, 0);
        
        frm.setVisible(true);
        frm.setAlwaysOnTop(true);
        frm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnArtistaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArtista;
    private javax.swing.JButton btnImagem;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLimparTela;
    private javax.swing.JComboBox cbMidia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbArtista;
    private javax.swing.JLabel lbCapa;
    private javax.swing.JLabel lbDica;
    private javax.swing.JTextField tfAnoLancamento;
    private javax.swing.JTextField tfGravadora;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
}
