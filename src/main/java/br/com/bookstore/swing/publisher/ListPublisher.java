/*
 * Created by JFormDesigner on Fri Oct 05 22:28:42 BRT 2018
 */

package br.com.bookstore.swing.publisher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Leandro
 */
public class ListPublisher extends JFrame {
    public ListPublisher() {
        initComponents();
    }

    private void buttonRefreshActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonAddActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Leandro
        panelPublisher = new JPanel();
        scrollPanelPublisher = new JScrollPane();
        tablePublisher = new JTable();
        buttonAdd = new JButton();
        buttonRefresh = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== panelPublisher ========
        {

            // JFormDesigner evaluation mark
            panelPublisher.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panelPublisher.getBorder())); panelPublisher.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //======== scrollPanelPublisher ========
            {
                scrollPanelPublisher.setViewportView(tablePublisher);
            }

            //---- buttonAdd ----
            buttonAdd.setText("Adicionar");
            buttonAdd.setIcon(new ImageIcon("D:\\Documents\\Java\\Projects\\BookStore\\src\\main\\resources\\icons\\Library32.png"));
            buttonAdd.addActionListener(e -> buttonAddActionPerformed(e));

            //---- buttonRefresh ----
            buttonRefresh.setIcon(new ImageIcon("D:\\Documents\\Java\\Projects\\BookStore\\src\\main\\resources\\icons\\Refresh32.png"));
            buttonRefresh.addActionListener(e -> {
			buttonRefreshActionPerformed(e);
			buttonRefreshActionPerformed(e);
		});

            GroupLayout panelPublisherLayout = new GroupLayout(panelPublisher);
            panelPublisher.setLayout(panelPublisherLayout);
            panelPublisherLayout.setHorizontalGroup(
                panelPublisherLayout.createParallelGroup()
                    .addGroup(panelPublisherLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelPublisherLayout.createParallelGroup()
                            .addComponent(scrollPanelPublisher, GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                            .addGroup(panelPublisherLayout.createSequentialGroup()
                                .addComponent(buttonAdd)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 599, Short.MAX_VALUE)
                                .addComponent(buttonRefresh)))
                        .addContainerGap())
            );
            panelPublisherLayout.setVerticalGroup(
                panelPublisherLayout.createParallelGroup()
                    .addGroup(panelPublisherLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelPublisherLayout.createParallelGroup()
                            .addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRefresh, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPanelPublisher, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelPublisher, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelPublisher, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Leandro
    private JPanel panelPublisher;
    private JScrollPane scrollPanelPublisher;
    private JTable tablePublisher;
    private JButton buttonAdd;
    private JButton buttonRefresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
