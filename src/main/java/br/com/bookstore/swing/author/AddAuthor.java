/*
 * Created by JFormDesigner on Tue Sep 18 12:52:41 BRT 2018
 */

package br.com.bookstore.swing.author;

import br.com.bookstore.domain.entity.Author;
import br.com.bookstore.service.AuthorService;
import br.com.bookstore.util.MessageUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class AddAuthor extends JFrame {

    public AddAuthor() {
        initComponents();
    }

    public AddAuthor(String id, String name, String surname) {
        initComponents();
        this.setTitle("Editar autor");
        txtId.setText(id);
        txtName.setText(name);
        txtSurname.setText(surname);
    }

    private void btnCancelActionPerformed(ActionEvent e) {
        dispose();
    }

    private void btnSaveActionPerformed(ActionEvent e) {
        if (!"".equals(txtName.getText()) && !"".equals(txtSurname.getText())) {
            Integer id = !"".equals(txtId.getText()) ? Integer.parseInt(txtId.getText()) : null;
            Author author = new Author(id, txtName.getText(), txtSurname.getText());
            AuthorService service = new AuthorService();
            try {
                service.save(author);
                MessageUtil.addMessage(AddAuthor.this, "Autor salvo com sucesso");
                dispose();
            } catch (Exception e1) {
                e1.printStackTrace();
                MessageUtil.addMessage(AddAuthor.this, e1.getMessage());
            }
        } else {
            if (!"".equals(txtSurname.getText())) {
                MessageUtil.addMessage(AddAuthor.this, "Campo NOME obrigatório");
            } else if (!"".equals(txtName.getText())) {
                MessageUtil.addMessage(AddAuthor.this, "Campo SOBRENOME obrigatório");
            } else {
                MessageUtil.addMessage(AddAuthor.this, "Campos NOME e SOBRENOME obrigatórios");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Leandro
        lblName = new JLabel();
        txtName = new JTextField();
        txtSurname = new JTextField();
        lblSurname = new JLabel();
        btnCancel = new JButton();
        btnSave = new JButton();
        txtId = new JLabel();

        //======== this ========
        setTitle("Adicionar autor");
        Container contentPane = getContentPane();

        //---- lblName ----
        lblName.setText("Nome");

        //---- lblSurname ----
        lblSurname.setText("Sobrenome");

        //---- btnCancel ----
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(e -> btnCancelActionPerformed(e));

        //---- btnSave ----
        btnSave.setText("Salvar");
        btnSave.addActionListener(e -> btnSaveActionPerformed(e));

        //---- txtId ----
        txtId.setVisible(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtName, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                        .addComponent(txtId)
                        .addComponent(lblSurname)
                        .addComponent(lblName)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancel))
                        .addComponent(txtSurname, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                    .addContainerGap(43, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblName)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblSurname)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancel)
                        .addComponent(btnSave))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtId)
                    .addContainerGap(48, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Leandro
    private JLabel lblName;
    private JTextField txtName;
    private JTextField txtSurname;
    private JLabel lblSurname;
    private JButton btnCancel;
    private JButton btnSave;
    private JLabel txtId;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
