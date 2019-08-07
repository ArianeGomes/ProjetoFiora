package br.com.ariane.fiora.app;

import br.com.ariane.fiora.modelo.Album;
import br.com.ariane.fiora.modelo.Artista;
import br.com.ariane.fiora.modelo.Faixa;
import br.com.ariane.fiora.tables.TableFaixas;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FrmGerenciarFaixas extends javax.swing.JInternalFrame {
    private TableFaixas tabelaFaixas;
    private int codigoArtista, numeroFaixa;
    private Album a;
    private Faixa f;
    
    public FrmGerenciarFaixas() {
        initComponents();
        desativarBotoes();
    }
    
    //Desativa botões até que a procura seja finalizada
    private void desativarBotoes() {
        btnIncluir.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        tfNomeFaixa.setEnabled(false);
        spnFaixas.setEnabled(false);
    }
    
    public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    } 
    
    private void preencherTabelaFaixas(Album a){
        Faixa dao = new Faixa();
        tabelaFaixas = new TableFaixas(dao.listarFaixas(a.getCodAlbum()));
        tbFaixas.setModel(tabelaFaixas);
    }
    
    public void atualizarArtista(Artista a) {
        codigoArtista = a.getCodArtista();
        lbArtista.setText(a.getNome());
    }
    
    public void preencherComboAlbum() {
        Album dao = new Album();
        ArrayList<Album> albuns = dao.listarAlbuns(codigoArtista);
        cbAlbum.removeAllItems();
        for (Album a: albuns) {
            cbAlbum.addItem(a);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFaixas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfNomeFaixa = new javax.swing.JTextField();
        btnIncluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbAlbum = new javax.swing.JComboBox();
        btnSelecionarArtista = new javax.swing.JButton();
        lbArtista = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAtualizarTabela = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        spnFaixas = new javax.swing.JSpinner();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gerenciar Faixas");

        tbFaixas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número da Faixa", "Nome da Faixa"
            }
        ));
        tbFaixas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFaixasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFaixas);

        jLabel4.setText("Número da Faixa:");

        jLabel6.setText("Nome da Faixa:");

        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/adicionar.png"))); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pré-requisitos"));

        jLabel1.setText("Selecione o álbum:");

        cbAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlbumActionPerformed(evt);
            }
        });

        btnSelecionarArtista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/confirmar.png"))); // NOI18N
        btnSelecionarArtista.setText("Selecionar Artista");
        btnSelecionarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarArtistaActionPerformed(evt);
            }
        });

        lbArtista.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbArtista.setForeground(new java.awt.Color(51, 51, 51));

        jLabel7.setText("Artista selecionado:");

        btnAtualizarTabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/atualizar.png"))); // NOI18N
        btnAtualizarTabela.setText("Ok");
        btnAtualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSelecionarArtista)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAlbum, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizarTabela)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSelecionarArtista)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizarTabela))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ariane/fiora/images/dica.png"))); // NOI18N
        jLabel2.setText("Selecione a faixa que deseja alterar, digite o novo nome da faixa e clique em Editar.");

        spnFaixas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnFaixas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNomeFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(173, 173, 173)
                        .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(tfNomeFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnFaixas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addGap(170, 170, 170)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnSair))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        if ((tfNomeFaixa.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            //Cria um objeto do tipo Faixa para incluir os dados na classe
            try {
                Faixa faixa = new Faixa();
                
                faixa.setNumeroFaixa(Integer.parseInt(spnFaixas.getValue().toString()));
                faixa.setNomeFaixa(tfNomeFaixa.getText());
                faixa.setCodAlbum(a.getCodAlbum());

                //Adiciona os dados no banco de dados
                faixa.incluirFaixa(faixa);   
                preencherTabelaFaixas(a);
                
                if (tbFaixas.getRowCount() == 0) {
                    numeroFaixa = 1;
                } else {
                    numeroFaixa = tbFaixas.getRowCount() + 1;
                }
                
                spnFaixas.setValue(numeroFaixa);
                tfNomeFaixa.setText("");
            } catch (IllegalArgumentException ie) {
                JOptionPane.showMessageDialog(this, ie.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnSelecionarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarArtistaActionPerformed
        desativarBotoes();
        FrmSelecionarArtista frm = new FrmSelecionarArtista(this, 1);
        
        frm.setVisible(true);
        frm.setAlwaysOnTop(true);
        frm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnSelecionarArtistaActionPerformed

    private void cbAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlbumActionPerformed

    }//GEN-LAST:event_cbAlbumActionPerformed

    private void btnAtualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarTabelaActionPerformed
        a = (Album) cbAlbum.getSelectedItem();
        preencherTabelaFaixas(a);
        
        if (tbFaixas.getRowCount() == 0) {
            numeroFaixa = 1;
        } else {
            numeroFaixa = tbFaixas.getRowCount() + 1;
        }
        spnFaixas.setValue(numeroFaixa);
        
        btnIncluir.setEnabled(true);
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        tfNomeFaixa.setEnabled(true);
        spnFaixas.setEnabled(true);
    }//GEN-LAST:event_btnAtualizarTabelaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (f == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma faixa", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            f.setNomeFaixa(tfNomeFaixa.getText());
            f.alterarFaixa(f);
            preencherTabelaFaixas(a);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (f == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma faixa", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            tfNomeFaixa.setText("");
            f.excluirFaixa(f);
            preencherTabelaFaixas(a);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tbFaixasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFaixasMouseClicked
        int linhaSelecionada = tbFaixas.getSelectedRow();
        tabelaFaixas = (TableFaixas)tbFaixas.getModel();           
        Faixa f = tabelaFaixas.retornarObjetoSelecionado(linhaSelecionada);
        this.f = f;
        tfNomeFaixa.setText(f.getNomeFaixa());
        spnFaixas.setValue(f.getNumeroFaixa());
    }//GEN-LAST:event_tbFaixasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarTabela;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecionarArtista;
    private javax.swing.JComboBox cbAlbum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbArtista;
    private javax.swing.JSpinner spnFaixas;
    private javax.swing.JTable tbFaixas;
    private javax.swing.JTextField tfNomeFaixa;
    // End of variables declaration//GEN-END:variables
}
