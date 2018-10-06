/*
 * Created by JFormDesigner on Tue Sep 18 13:51:27 BRT 2018
 */

package br.com.bookstore.swing.book;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Leandro
 */
public class AddBook extends JFrame {
    public AddBook() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Leandro
        btnSave = new JButton();
        btnCancel = new JButton();
        txtTitle = new JTextField();
        lblTitle = new JLabel();
        txtISBN = new JTextField();
        lblISBN = new JLabel();
        txtPrice = new JFormattedTextField();
        lblPrice = new JLabel();
        lblPublisher = new JLabel();
        cbxPublisher = new JComboBox();
        lblAuthor = new JLabel();
        cbxAuthor = new JComboBox();

        //======== this ========
        Container contentPane = getContentPane();

        //---- btnSave ----
        btnSave.setText("Salvar");

        //---- btnCancel ----
        btnCancel.setText("Cancelar");

        //---- lblTitle ----
        lblTitle.setText("T\u00edtulo");

        //---- lblISBN ----
        lblISBN.setText("ISBN");

        //---- lblPrice ----
        lblPrice.setText("Pre\u00e7o");

        //---- lblPublisher ----
        lblPublisher.setText("Editora");

        //---- lblAuthor ----
        lblAuthor.setText("Autor");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(btnCancel)
                            .addGap(18, 18, 18)
                            .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblAuthor)
                            .addComponent(lblISBN)
                            .addComponent(txtISBN)
                            .addComponent(lblTitle)
                            .addComponent(txtTitle)
                            .addComponent(lblPrice)
                            .addComponent(lblPublisher)
                            .addComponent(cbxPublisher)
                            .addComponent(cbxAuthor, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(52, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(lblISBN)
                    .addGap(6, 6, 6)
                    .addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblTitle)
                    .addGap(6, 6, 6)
                    .addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblPrice)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblPublisher)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cbxPublisher, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblAuthor)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cbxAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnCancel))
                    .addContainerGap(38, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Leandro
    private JButton btnSave;
    private JButton btnCancel;
    private JTextField txtTitle;
    private JLabel lblTitle;
    private JTextField txtISBN;
    private JLabel lblISBN;
    private JFormattedTextField txtPrice;
    private JLabel lblPrice;
    private JLabel lblPublisher;
    private JComboBox cbxPublisher;
    private JLabel lblAuthor;
    private JComboBox cbxAuthor;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
