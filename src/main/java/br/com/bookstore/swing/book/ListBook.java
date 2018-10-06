/*
 * Created by JFormDesigner on Fri Oct 05 22:32:21 BRT 2018
 */

package br.com.bookstore.swing.book;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Leandro
 */
public class ListBook extends JFrame {
    public ListBook() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Leandro
        panelBook = new JPanel();
        scrollPanelBook = new JScrollPane();
        tableBook = new JTable();
        buttonRemove = new JButton();
        buttonEdit = new JButton();
        buttonAdd = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== panelBook ========
        {

            // JFormDesigner evaluation mark
            panelBook.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panelBook.getBorder())); panelBook.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //======== scrollPanelBook ========
            {
                scrollPanelBook.setViewportView(tableBook);
            }

            //---- buttonRemove ----
            buttonRemove.setText("Remover");

            //---- buttonEdit ----
            buttonEdit.setText("Editar");

            //---- buttonAdd ----
            buttonAdd.setText("Adicionar");

            GroupLayout panelBookLayout = new GroupLayout(panelBook);
            panelBook.setLayout(panelBookLayout);
            panelBookLayout.setHorizontalGroup(
                panelBookLayout.createParallelGroup()
                    .addGroup(panelBookLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBookLayout.createParallelGroup()
                            .addComponent(scrollPanelBook, GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                            .addGroup(panelBookLayout.createSequentialGroup()
                                .addGap(0, 468, Short.MAX_VALUE)
                                .addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonEdit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonRemove, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addContainerGap())
            );
            panelBookLayout.setVerticalGroup(
                panelBookLayout.createParallelGroup()
                    .addGroup(panelBookLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPanelBook, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBookLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonRemove, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEdit)
                            .addComponent(buttonAdd))
                        .addContainerGap(9, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelBook, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelBook, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Leandro
    private JPanel panelBook;
    private JScrollPane scrollPanelBook;
    private JTable tableBook;
    private JButton buttonRemove;
    private JButton buttonEdit;
    private JButton buttonAdd;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
