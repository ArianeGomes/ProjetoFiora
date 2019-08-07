package br.com.ariane.fiora.app;

import br.com.ariane.fiora.modelo.Album;
import br.com.ariane.fiora.modelo.Artista;
import br.com.ariane.fiora.modelo.Faixa;
import br.com.ariane.fiora.modelo.Usuario;
import br.com.ariane.fiora.tables.TableAlbunsListagem;
import br.com.ariane.fiora.tables.TableArtistasListagem;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmListagem extends javax.swing.JInternalFrame {
    private TableArtistasListagem tabelaArtistas;
    private TableAlbunsListagem tabelaAlbuns;
    private Artista artista;
    private Album album;
    private Usuario usuario;
    
    public FrmListagem() {
        initComponents();
        preencherTabelaArtista();
        taFaixas.setEditable(false);
    }
    
    public FrmListagem(Usuario usuario) {
        this();
        this.usuario = usuario;
    }
    
    public void preencherTabelaArtista() {
        Artista dao = new Artista();
        tabelaArtistas = new TableArtistasListagem(dao.listarArtistas());
        tbArtistas.setModel(tabelaArtistas);
        tbArtistas.setAutoCreateRowSorter(true);
        
        tabAbas.setSelectedIndex(0);
    }
    
    public void preencherTabelaAlbum(int codigoArtista) {
        Album dao = new Album();
        tabelaAlbuns = new TableAlbunsListagem(dao.listarAlbuns(codigoArtista));
        tbAlbuns.setModel(tabelaAlbuns);
        tbAlbuns.setAutoCreateRowSorter(true);
    }
    
    public void atualizarDetalhesArtista() {
        if (artista != null) {
            if ("".equals(artista.getSite())) {
                btnSite.setEnabled(false);
            } else {
                btnSite.setEnabled(true);
            }
            
            lbNome.setText(artista.getNome());
            lbCodigo.setText(Integer.toString(artista.getCodArtista()));
            lbAnoCriacao.setText(Integer.toString(artista.getAnoCriacao()));
            lbGenero.setText(artista.getGenero());
            lbTipo.setText(artista.getTipoArtista());
            lbFoto.setIcon(new ImageIcon(artista.abrirImagem(artista.getCodArtista()).getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(), Image.SCALE_DEFAULT)));
            Usuario u = new Usuario();
            u = u.buscarUsuario(artista.getLoginUsuario());
            lbUsuario.setText(u.getNome());
        } else {
            limparTela();
        }
    }
    
    public void limparTela() {
        lbNome.setText("");
        lbCodigo.setText("");
        lbAnoCriacao.setText("");
        lbGenero.setText("");
        lbTipo.setText("");
        lbFoto.setIcon(null);
        lbUsuario.setText("");
    }
    
    public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAtualizar = new javax.swing.JButton();
        tabAbas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbArtistas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pnDetalhes = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbAnoCriacao = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbGenero = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbTipo = new javax.swing.JLabel();
        btnAlterarArtista = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbFoto = new javax.swing.JLabel();
        btnSite = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        pnAlbuns = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAlbuns = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnAlterarAlbum = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbCapa = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taFaixas = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listagem de Artistas");

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/atualizar.png"))); // NOI18N
        btnAtualizar.setText("Atualizar Listagem");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        tbArtistas.setModel(new javax.swing.table.DefaultTableModel(
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
        tbArtistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbArtistasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbArtistas);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/dica.png"))); // NOI18N
        jLabel7.setText("Clique duas vezes em um artista na tabela acima para atualizar seus dados.");

        jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Artista"));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/procurar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do Artista:");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        tabAbas.addTab("Listagem", jPanel1);

        jLabel2.setText("Nome:");

        jLabel3.setText("Código:");

        jLabel4.setText("Ano de Criação:");

        jLabel5.setText("Gênero:");

        jLabel6.setText("Tipo do Artista:");

        btnAlterarArtista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/editar.png"))); // NOI18N
        btnAlterarArtista.setText("Alterar Artista");
        btnAlterarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarArtistaActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto do Artista"));

        lbFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/world.png"))); // NOI18N
        btnSite.setText("Ir ao site");
        btnSite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiteActionPerformed(evt);
            }
        });

        jLabel8.setText("Responsável pelo Cadastro:");

        javax.swing.GroupLayout pnDetalhesLayout = new javax.swing.GroupLayout(pnDetalhes);
        pnDetalhes.setLayout(pnDetalhesLayout);
        pnDetalhesLayout.setHorizontalGroup(
            pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbAnoCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSite)
                            .addGroup(pnDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnAlterarArtista))
                .addContainerGap(378, Short.MAX_VALUE))
        );
        pnDetalhesLayout.setVerticalGroup(
            pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetalhesLayout.createSequentialGroup()
                        .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbAnoCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSite))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnAlterarArtista)
                .addContainerGap())
        );

        tabAbas.addTab("Detalhes", pnDetalhes);

        tbAlbuns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título"
            }
        ));
        tbAlbuns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAlbunsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbAlbuns);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/dica.png"))); // NOI18N
        jLabel9.setText("Clique duas vezes em um álbum na tabela ao lado para atualizar seus dados.");

        btnAlterarAlbum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/editar.png"))); // NOI18N
        btnAlterarAlbum.setText("Alterar Álbum");
        btnAlterarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarAlbumActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Capa do Álbum"));

        lbCapa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Faixas do Álbum"));

        taFaixas.setColumns(20);
        taFaixas.setRows(5);
        jScrollPane3.setViewportView(taFaixas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnAlbunsLayout = new javax.swing.GroupLayout(pnAlbuns);
        pnAlbuns.setLayout(pnAlbunsLayout);
        pnAlbunsLayout.setHorizontalGroup(
            pnAlbunsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlbunsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAlbunsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAlbunsLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(pnAlbunsLayout.createSequentialGroup()
                        .addComponent(btnAlterarAlbum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)))
                .addContainerGap())
        );
        pnAlbunsLayout.setVerticalGroup(
            pnAlbunsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlbunsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAlbunsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnAlbunsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterarAlbum)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabAbas.addTab("Álbuns", pnAlbuns);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabAbas)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAtualizar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabAbas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnAlterarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarArtistaActionPerformed
        FrmAlterarArtista frm = new FrmAlterarArtista(this, artista.getCodArtista(), usuario);
        
        frm.setVisible(true);
        frm.setAlwaysOnTop(true);
        frm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAlterarArtistaActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        preencherTabelaArtista();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void tbAlbunsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAlbunsMouseClicked
        int linhaSelecionada = tbAlbuns.getSelectedRow();
        tabelaAlbuns = (TableAlbunsListagem)tbAlbuns.getModel();           
        album = tabelaAlbuns.retornarObjetoSelecionado(linhaSelecionada);
        
        Faixa fDao = new Faixa();            
        ArrayList<Faixa> faixas = fDao.listarFaixas(album.getCodAlbum());
        
        taFaixas.setText("");
        faixas.stream().forEach((f) -> {
            taFaixas.append(f.getNumeroFaixa() + " - " + f.getNomeFaixa() + "\n");
        });
        
        lbCapa.setIcon(new ImageIcon(album.abrirImagem(album.getCodAlbum()).getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(), Image.SCALE_DEFAULT)));
        
        if(evt.getClickCount() == 2){
            Artista aDao = new Artista();
            FrmAlterarAlbum frm = new FrmAlterarAlbum(this, album.getCodAlbum(), aDao.buscarArtista(album.getCodArtista()), usuario);
            frm.setVisible(true);
            frm.setAlwaysOnTop(true);
            frm.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_tbAlbunsMouseClicked

    private void tbArtistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbArtistasMouseClicked
        taFaixas.setText("");
        int linhaSelecionada = tbArtistas.getSelectedRow();
        tabelaArtistas = (TableArtistasListagem)tbArtistas.getModel();           
        artista = tabelaArtistas.retornarObjetoSelecionado(linhaSelecionada);
        
        atualizarDetalhesArtista();
        taFaixas.setText("");
        lbCapa.setIcon(null);
        
        preencherTabelaAlbum(artista.getCodArtista());
        if(evt.getClickCount() == 2){
            FrmAlterarArtista frm = new FrmAlterarArtista(this, artista.getCodArtista(), usuario);
            frm.setVisible(true);
            frm.setAlwaysOnTop(true);
            frm.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_tbArtistasMouseClicked

    private void btnAlterarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarAlbumActionPerformed
        Artista dao = new Artista();
        FrmAlterarAlbum f = new FrmAlterarAlbum(this, album.getCodAlbum(), dao.buscarArtista(album.getCodArtista()), usuario);
        
        f.setAlwaysOnTop(true);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAlterarAlbumActionPerformed

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
                tabelaArtistas = new TableArtistasListagem(artistas);
                tbArtistas.setModel(tabelaArtistas);
            }
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiteActionPerformed
        try {  
            Runtime.getRuntime().exec("cmd.exe /C start "  
                    + "http://" + artista.getSite());  
        } catch (IOException ex) {  
           System.out.println(ex.getMessage());  
        }
    }//GEN-LAST:event_btnSiteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarAlbum;
    private javax.swing.JButton btnAlterarArtista;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbAnoCriacao;
    private javax.swing.JLabel lbCapa;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel pnAlbuns;
    private javax.swing.JPanel pnDetalhes;
    private javax.swing.JTextArea taFaixas;
    private javax.swing.JTabbedPane tabAbas;
    private javax.swing.JTable tbAlbuns;
    private javax.swing.JTable tbArtistas;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
