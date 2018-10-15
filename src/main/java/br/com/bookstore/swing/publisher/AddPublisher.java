/*
 * Created by JFormDesigner on Tue Sep 18 13:46:48 BRT 2018
 */

package br.com.bookstore.swing.publisher;

import br.com.bookstore.domain.entity.Publisher;
import br.com.bookstore.service.PublisherService;
import br.com.bookstore.util.MessageUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Leandro
 */
public class AddPublisher extends JFrame {

    public AddPublisher() {
        initComponents();
    }

    public AddPublisher(String id, String name, String url) {
        initComponents();
        this.setTitle("Editar editora");
        txtId.setText(id);
        txtName.setText(name);
        txtURL.setText(url);
    }

    private void btnCancelActionPerformed(ActionEvent e) {
        dispose();
    }

    private void btnSaveActionPerformed(ActionEvent e) {
        if (!"".equals(txtName.getText())) {
            Integer idPublisher = !"".equals(txtId.getText()) ? Integer.parseInt(txtId.getText()) : null;
            String urlPublisher = !"".equals(txtURL.getText()) ? txtURL.getText() : null;
            Publisher publisher = new Publisher(idPublisher, txtName.getText(), urlPublisher);
            PublisherService publisherService = new PublisherService();
            try {
                publisherService.save(publisher);
                MessageUtil.addMessage(AddPublisher.this, "Editora salva com sucesso");
                dispose();
            } catch (Exception e1) {
                e1.printStackTrace();
                MessageUtil.addMessage(AddPublisher.this, e1.getMessage());
            }
        } else {
            MessageUtil.addMessage(AddPublisher.this, "Campo NOME obrigatório");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Leandro
        txtName = new JTextField();
        lblURL = new JLabel();
        txtURL = new JTextField();
        btnCancel = new JButton();
        btnSave = new JButton();
        lblName = new JLabel();
        txtId = new JLabel();

        //======== this ========
        setTitle("Adicionar editora");
        Container contentPane = getContentPane();

        //---- lblURL ----
        lblURL.setText("URL");

        //---- btnCancel ----
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(e -> btnCancelActionPerformed(e));

        //---- btnSave ----
        btnSave.setText("Salvar");
        btnSave.addActionListener(e -> btnSaveActionPerformed(e));

        //---- lblName ----
        lblName.setText("Nome");

        //---- txtId ----
        txtId.setVisible(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(txtId)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancel))
                        .addComponent(lblName)
                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtURL, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblURL))
                    .addContainerGap(28, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(lblName)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(lblURL, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(47, 47, 47)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancel)
                        .addComponent(btnSave)
                        .addComponent(txtId))
                    .addContainerGap(41, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Leandro
    private JTextField txtName;
    private JLabel lblURL;
    private JTextField txtURL;
    private JButton btnCancel;
    private JButton btnSave;
    private JLabel lblName;
    private JLabel txtId;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
