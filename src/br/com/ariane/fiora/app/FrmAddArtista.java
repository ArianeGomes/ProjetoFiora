package br.com.ariane.fiora.app;

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

public class FrmAddArtista extends javax.swing.JInternalFrame {
    private JFileChooser fc;
    private File f;
    private Usuario usuario;
    
    public FrmAddArtista() {
        initComponents();
        preencherComboTipoArtista();
    }
    
    //Parâmetro contém o usuário logado no momento
    public FrmAddArtista(Usuario usuario) {
        this();
        this.usuario = usuario;
    }

    //Apaga todos os dados dos campos preenchidos
    private void limparTela() {
        tfNome.setText("");
        tfSite.setText("");
        tfAnoCriacao.setText("");
        tfGenero.setText("");
        lbFoto.setIcon(null);
    }
    
    private void preencherComboTipoArtista() {
        cbTipoArtista.removeAllItems();
        cbTipoArtista.addItem("Banda");
        cbTipoArtista.addItem("Cantor(a) Solo");
        cbTipoArtista.addItem("Grupo");
        cbTipoArtista.addItem("Orquestra");
    }
    
    //Configura a posição do Internal Frame para o meio do DesktopPane
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnLimparTela = new javax.swing.JButton();
        btnIncluir = new javax.swing.JButton();
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
        lbDica = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Incluir Artista");
        setPreferredSize(new java.awt.Dimension(668, 600));

        jPanel1.setPreferredSize(new java.awt.Dimension(652, 500));

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
                        .addComponent(cbTipoArtista, 0, 130, Short.MAX_VALUE)))
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("*Foto do Artista"));

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
                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSelecionar)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbDica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/dica.png"))); // NOI18N
        lbDica.setText("Campos com * são obrigatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIncluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimparTela))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimparTela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIncluir))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );

        setBounds(0, 0, 668, 633);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        try {
            //Valida campos obrigatórios
            if ((tfNome.getText().isEmpty()) || (tfAnoCriacao.getText().isEmpty()) || (f == null)) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                //Valida o ano
                if ((tfAnoCriacao.getComponentCount() > 4) || Calendar.getInstance().get(Calendar.YEAR) < Integer.parseInt(tfAnoCriacao.getText())) {
                    tfAnoCriacao.setText("");
                    JOptionPane.showMessageDialog(this, "Ano de Criação incorreto!\nVerifique e tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    //Cria um objeto do tipo Artista para incluir os dados na classe
                    Artista artista = new Artista();


                    artista.setNome(tfNome.getText());
                    artista.setSite(tfSite.getText());
                    artista.setAnoCriacao(Integer.parseInt(tfAnoCriacao.getText()));
                    artista.setGenero(tfGenero.getText());
                    artista.setLoginUsuario(usuario.getLogin());
                    artista.setTipoArtista((String) cbTipoArtista.getSelectedItem());

                    //Adiciona os dados no banco de dados
                    artista.incluirArtista(artista, f);

                    JOptionPane.showMessageDialog(this, "Artista cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    limparTela();
                    this.dispose();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite somente números no campo Ano de Criação", "Erro", JOptionPane.ERROR_MESSAGE);
            tfAnoCriacao.setText("");
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnLimparTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparTelaActionPerformed
        limparTela();
    }//GEN-LAST:event_btnLimparTelaActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        //Cria um arquivo JFileChooser e retorna ao objeto File o que foi selecionado
        try {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLimparTela;
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
