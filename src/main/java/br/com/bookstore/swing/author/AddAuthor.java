/*
 * Created by JFormDesigner on Tue Sep 18 12:52:41 BRT 2018
 */

package br.com.bookstore.swing.author;

import br.com.bookstore.domain.entity.Author;
import br.com.bookstore.service.AuthorService;

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
        txtId.setText(id);
        txtName.setText(name);
        txtSurname.setText(surname);
    }

    private void btnCancelActionPerformed(ActionEvent e) {
        dispose();
    }

    private void btnSaveActionPerformed(ActionEvent e) {
        if (!"".equals(txtName.getText()) && !"".equals(txtSurname.getText())) {
            Author author = new Author(txtName.getText(), txtSurname.getText());
            AuthorService service = new AuthorService();
            try {
                service.save(author);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {

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
        setTitle("Autor");
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
        txtId.setText("text");
        txtId.setVisible(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(txtId)
                        .addComponent(lblSurname)
                        .addComponent(lblName)
                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel))
                            .addComponent(txtSurname, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(53, Short.MAX_VALUE))
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
                    .addGap(0, 0, 0)
                    .addComponent(txtSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancel)
                        .addComponent(btnSave))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtId)
                    .addContainerGap(52, Short.MAX_VALUE))
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
