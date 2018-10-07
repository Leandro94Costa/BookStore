/*
 * Created by JFormDesigner on Fri Oct 05 21:34:09 BRT 2018
 */

package br.com.bookstore.swing.author;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Leandro
 */
public class ListAuthor extends JFrame {
    public ListAuthor() {
        initComponents();
    }

    private void buttonAddActionPerformed(ActionEvent e) {
        AddAuthor addAuthor = new AddAuthor();
        addAuthor.setLocationRelativeTo(null);
        addAuthor.setVisible(true);
    }

    private void buttonEditActionPerformed(ActionEvent e) {
        AddAuthor addAuthor = new AddAuthor();
        addAuthor.setLocationRelativeTo(null);
        addAuthor.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Leandro
        panelAuthor = new JPanel();
        scrollPanelAuthor = new JScrollPane();
        tableAuthor = new JTable();
        buttonRemove = new JButton();
        buttonEdit = new JButton();
        buttonAdd = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== panelAuthor ========
        {

            // JFormDesigner evaluation mark
//            panelAuthor.setBorder(new javax.swing.border.CompoundBorder(
//                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
//                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
//                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
//                    java.awt.Color.red), panelAuthor.getBorder())); panelAuthor.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //======== scrollPanelAuthor ========
            {
                scrollPanelAuthor.setViewportView(tableAuthor);
            }

            //---- buttonRemove ----
            buttonRemove.setText("Remover");

            //---- buttonEdit ----
            buttonEdit.setText("Editar");
            buttonEdit.addActionListener(e -> buttonEditActionPerformed(e));

            //---- buttonAdd ----
            buttonAdd.setText("Adicionar");
            buttonAdd.addActionListener(e -> buttonAddActionPerformed(e));

            GroupLayout panelAuthorLayout = new GroupLayout(panelAuthor);
            panelAuthor.setLayout(panelAuthorLayout);
            panelAuthorLayout.setHorizontalGroup(
                panelAuthorLayout.createParallelGroup()
                    .addGroup(panelAuthorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelAuthorLayout.createParallelGroup()
                            .addComponent(scrollPanelAuthor, GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                            .addGroup(panelAuthorLayout.createSequentialGroup()
                                .addGap(0, 468, Short.MAX_VALUE)
                                .addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonEdit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonRemove, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addContainerGap())
            );
            panelAuthorLayout.setVerticalGroup(
                panelAuthorLayout.createParallelGroup()
                    .addGroup(panelAuthorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPanelAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelAuthorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonRemove, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonEdit)
                            .addComponent(buttonAdd))
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelAuthor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelAuthor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Leandro
    private JPanel panelAuthor;
    private JScrollPane scrollPanelAuthor;
    private JTable tableAuthor;
    private JButton buttonRemove;
    private JButton buttonEdit;
    private JButton buttonAdd;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
