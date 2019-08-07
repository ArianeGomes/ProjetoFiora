package br.com.ariane.fiora.app;

import br.com.ariane.fiora.modelo.Usuario;

public class FrmPrincipal extends javax.swing.JFrame {
    //Declaração de variáveis globais
    FrmAddArtista InternalArtista;
    FrmAddAlbum InternalAlbum;
    FrmAddUsuario InternalUsuario;
    FrmListagem InternalListagem;
    FrmGerenciarFaixas InternalFaixa;
    Usuario usuario = new Usuario();
    
    public FrmPrincipal() {
        initComponents();
        nomearBotoes();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); //Inicia o programa maximizado
    }
    
    public FrmPrincipal(Usuario u) {
        this();
        this.usuario = u;
        lbUsuario.setText(usuario.getNome());
    }

    private void nomearBotoes() { //Nomeia botões para fácil acesso do usuário
        btnAddUsuario.setToolTipText("Adicionar Usuário");
        btnAddArtista.setToolTipText("Adicionar Artista");
        btnAddAlbum.setToolTipText("Adicionar Álbum");
        btnListagem.setToolTipText("Listar Artistas");
    }
    
    private void addArtista() { //Adiciona um Internal Frame de Adicionar Artista
        InternalArtista = new FrmAddArtista(usuario);
        desktopPane.add(InternalArtista);
        InternalArtista.setVisible(true);
        InternalArtista.setPosicao();
    }
    
    private void addAlbum() { //Adiciona um Internal Frame de Adicionar Álbum
        InternalAlbum = new FrmAddAlbum(usuario);
        desktopPane.add(InternalAlbum);
        InternalAlbum.setVisible(true);
        InternalAlbum.setPosicao();
    }
    
    private void addUsuario() { //Adiciona um Internal Frame de Adicionar Usuário
        InternalUsuario = new FrmAddUsuario();
        desktopPane.add(InternalUsuario);
        InternalUsuario.setVisible(true);
        InternalUsuario.setPosicao();
    }
    
    private void gerenciarFaixa() { //Adiciona um Internal Frame de Gerenciar Faixas
        InternalFaixa = new FrmGerenciarFaixas();
        desktopPane.add(InternalFaixa);
        InternalFaixa.setVisible(true);
        InternalFaixa.setPosicao();
    }
    
    private void listagem() { //Adiciona um Internal Frame contendo a listagem dos Artistas
        InternalListagem = new FrmListagem(usuario);
        desktopPane.add(InternalListagem);
        InternalListagem.setVisible(true);
        InternalListagem.setPosicao();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        btnListagem = new javax.swing.JButton();
        btnAddAlbum = new javax.swing.JButton();
        btnAddArtista = new javax.swing.JButton();
        btnAddUsuario = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAddFaixas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();
        menuFerramentas = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        menuAddArtista = new javax.swing.JMenuItem();
        menuAddAlbum = new javax.swing.JMenuItem();
        menuListagem = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuAddUsuario = new javax.swing.JMenuItem();
        menuAlterarUsuario = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fiora System");

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));
        desktopPane.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/fiora.png"))); // NOI18N

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );
        desktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnListagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/lista.png"))); // NOI18N
        btnListagem.setText("Listar Artistas");
        btnListagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListagemActionPerformed(evt);
            }
        });

        btnAddAlbum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/disco.png"))); // NOI18N
        btnAddAlbum.setText("Adicionar Álbum");
        btnAddAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAlbumActionPerformed(evt);
            }
        });

        btnAddArtista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/artistas.png"))); // NOI18N
        btnAddArtista.setText("Adicionar Artista");
        btnAddArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddArtistaActionPerformed(evt);
            }
        });

        btnAddUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/usuario.png"))); // NOI18N
        btnAddUsuario.setText("Adicionar Usuário");
        btnAddUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUsuarioActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnAddFaixas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/faixa.png"))); // NOI18N
        btnAddFaixas.setText("Gerenciar Faixas");
        btnAddFaixas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFaixasActionPerformed(evt);
            }
        });

        jLabel2.setText("Usuário:");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desktopPane)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(btnAddUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddArtista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddAlbum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddFaixas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddArtista)
                        .addComponent(btnAddAlbum)
                        .addComponent(btnAddFaixas)
                        .addComponent(btnSair)
                        .addComponent(btnListagem))
                    .addComponent(btnAddUsuario, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jDesktopPane1.setLayer(desktopPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnListagem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAddAlbum, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAddArtista, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAddUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnSair, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAddFaixas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        menuArquivo.setText("Arquivo");

        menuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuArquivo.add(menuSair);

        jMenuBar1.add(menuArquivo);

        menuFerramentas.setText("Ferramentas");

        jMenu4.setText("Cadastrar...");

        menuAddArtista.setText("Artista");
        menuAddArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddArtistaActionPerformed(evt);
            }
        });
        jMenu4.add(menuAddArtista);

        menuAddAlbum.setText("Álbum");
        menuAddAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddAlbumActionPerformed(evt);
            }
        });
        jMenu4.add(menuAddAlbum);

        menuFerramentas.add(jMenu4);

        menuListagem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menuListagem.setText("Listar Artistas");
        menuListagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListagemActionPerformed(evt);
            }
        });
        menuFerramentas.add(menuListagem);

        jMenuBar1.add(menuFerramentas);

        jMenu6.setText("Usuário");

        menuAddUsuario.setText("Cadastrar");
        menuAddUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddUsuarioActionPerformed(evt);
            }
        });
        jMenu6.add(menuAddUsuario);

        menuAlterarUsuario.setText("Alterar");
        menuAlterarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlterarUsuarioActionPerformed(evt);
            }
        });
        jMenu6.add(menuAlterarUsuario);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        setSize(new java.awt.Dimension(988, 581));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    private void btnAddUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUsuarioActionPerformed
        addUsuario();
    }//GEN-LAST:event_btnAddUsuarioActionPerformed

    private void btnAddArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddArtistaActionPerformed
        addArtista();
    }//GEN-LAST:event_btnAddArtistaActionPerformed

    private void btnAddAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAlbumActionPerformed
        addAlbum();
    }//GEN-LAST:event_btnAddAlbumActionPerformed

    private void btnListagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListagemActionPerformed
        listagem();
    }//GEN-LAST:event_btnListagemActionPerformed

    private void menuAddArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddArtistaActionPerformed
        addArtista();
    }//GEN-LAST:event_menuAddArtistaActionPerformed

    private void menuListagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListagemActionPerformed
        listagem();
    }//GEN-LAST:event_menuListagemActionPerformed

    private void menuAddAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddAlbumActionPerformed
        addAlbum();
    }//GEN-LAST:event_menuAddAlbumActionPerformed

    private void menuAddUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddUsuarioActionPerformed
        addUsuario();
    }//GEN-LAST:event_menuAddUsuarioActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        FrmLogin frm = new FrmLogin();
        
        frm.setAlwaysOnTop(true);
        frm.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAddFaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFaixasActionPerformed
        gerenciarFaixa();
    }//GEN-LAST:event_btnAddFaixasActionPerformed

    private void menuAlterarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlterarUsuarioActionPerformed
        FrmAlterarUsuario frm = new FrmAlterarUsuario();
        
        frm.setAlwaysOnTop(true);
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }//GEN-LAST:event_menuAlterarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAlbum;
    private javax.swing.JButton btnAddArtista;
    private javax.swing.JButton btnAddFaixas;
    private javax.swing.JButton btnAddUsuario;
    private javax.swing.JButton btnListagem;
    private javax.swing.JButton btnSair;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JMenuItem menuAddAlbum;
    private javax.swing.JMenuItem menuAddArtista;
    private javax.swing.JMenuItem menuAddUsuario;
    private javax.swing.JMenuItem menuAlterarUsuario;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuFerramentas;
    private javax.swing.JMenuItem menuListagem;
    private javax.swing.JMenuItem menuSair;
    // End of variables declaration//GEN-END:variables

}
