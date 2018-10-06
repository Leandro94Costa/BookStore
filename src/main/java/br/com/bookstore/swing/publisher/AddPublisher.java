/*
 * Created by JFormDesigner on Tue Sep 18 13:46:48 BRT 2018
 */

package br.com.bookstore.swing.publisher;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Leandro
 */
public class AddPublisher extends JFrame {
    public AddPublisher() {
        initComponents();
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

        //======== this ========
        setTitle("Editora");
        Container contentPane = getContentPane();

        //---- lblURL ----
        lblURL.setText("URL");

        //---- btnCancel ----
        btnCancel.setText("Cancelar");

        //---- btnSave ----
        btnSave.setText("Salvar");

        //---- lblName ----
        lblName.setText("Nome");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(btnCancel)
                            .addGap(18, 18, 18)
                            .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(lblURL)
                            .addComponent(txtURL, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName)))
                    .addContainerGap(34, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(lblName)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(lblURL)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(47, 47, 47)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(btnCancel)
                        .addComponent(btnSave))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
