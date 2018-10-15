/*
 * Created by JFormDesigner on Fri Oct 05 22:28:42 BRT 2018
 */

package br.com.bookstore.swing.publisher;

import br.com.bookstore.domain.entity.Publisher;
import br.com.bookstore.service.BookService;
import br.com.bookstore.service.PublisherService;
import br.com.bookstore.swing.util.ButtonColumn;
import br.com.bookstore.util.MessageUtil;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author Leandro
 */
public class ListPublisher extends JFrame {

    List<Integer> publisherIds;

    public ListPublisher() {
        initComponents();
    }

    private void buttonAddActionPerformed(ActionEvent e) {
        AddPublisher addPublisher = new AddPublisher();
        addPublisher.setLocationRelativeTo(null);
        addPublisher.setVisible(true);
    }

    private void buttonRefreshActionPerformed(ActionEvent e) {
        getScrollPanelPublisher();
    }

    private void thisWindowOpened(WindowEvent e) {
        getScrollPanelPublisher();
    }

    private JScrollPane getScrollPanelPublisher() {
        publisherIds = new ArrayList<>();
        scrollPanelPublisher.setViewportView(getTablePublisher());
        return scrollPanelPublisher;
    }

    private JTable getTablePublisher() {
        PublisherService publisherService = new PublisherService();
        String[] header = {"Nome", "URL", "", ""};
        try {
            String[][] publishers = publisherService.getAll(publisherIds);
            TableModel tableModelPublisher = new DefaultTableModel(publishers, header);
            tablePublisher = new JTable();
            tablePublisher.setModel(tableModelPublisher);

            Action actionEdit = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = Integer.parseInt(e.getActionCommand());
                    try {
                        Publisher publisher = publisherService.getById(publisherIds.get(row));
                        editPublisher(publisher);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        MessageUtil.addMessage(ListPublisher.this, e1.getMessage());
                    }
                }
            };

            Action actionRemove = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int response = JOptionPane.showConfirmDialog(ListPublisher.this, "Deseja remover a editora?");
                    if (response == 0) {
                        JTable table = (JTable) e.getSource();
                        int row = Integer.parseInt(e.getActionCommand());
                        try {
                            if (!publisherService.hasBooks(publisherIds.get(row))) {
                                publisherService.delete(publisherIds.get(row));
                                ((DefaultTableModel) table.getModel()).removeRow(row);
                                MessageUtil.addMessage(ListPublisher.this, "Editora removida com sucesso!");
                            } else {
                                response = JOptionPane.showConfirmDialog(ListPublisher.this, "Editora com livros salvos, deseja remover os livros e a editora?");
                                if (response == 0) {
                                    BookService bookService = new BookService();
                                    bookService.deleteByPublisher(publisherIds.get(row));
                                    publisherService.delete(publisherIds.get(row));
                                    ((DefaultTableModel) table.getModel()).removeRow(row);
                                    MessageUtil.addMessage(ListPublisher.this, "Editora e livros removidos com sucesso!");
                                }
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                            MessageUtil.addMessage(ListPublisher.this, e1.getMessage());
                        }
                    }
                }
            };

            ButtonColumn buttonColumnEdit = new ButtonColumn(tablePublisher, actionEdit, 2);
            ButtonColumn buttonColumnRemove = new ButtonColumn(tablePublisher, actionRemove, 3);
            buttonColumnEdit.setMnemonic(KeyEvent.VK_D);    //Atalho D
            buttonColumnRemove.setMnemonic(KeyEvent.VK_E);  //Atalho E
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addMessage(ListPublisher.this, e.getMessage());
        }
        return tablePublisher;
    }

    private void editPublisher(Publisher publisher) {
        AddPublisher addPublisher = new AddPublisher(String.valueOf(publisher.getId()), publisher.getName(), publisher.getUrl());
        addPublisher.setLocationRelativeTo(null);
        addPublisher.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Leandro Costa
        panelPublisher = new JPanel();
        scrollPanelPublisher = new JScrollPane();
        tablePublisher = new JTable();
        buttonAdd = new JButton();
        buttonRefresh = new JButton();

        //======== this ========
        setTitle("Editoras");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
            }
        });
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
            buttonAdd.setIcon(new ImageIcon(getClass().getResource("/icons/Library32.png")));
            buttonAdd.addActionListener(e -> buttonAddActionPerformed(e));

            //---- buttonRefresh ----
            buttonRefresh.setIcon(new ImageIcon(getClass().getResource("/icons/Refresh32.png")));
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
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 595, Short.MAX_VALUE)
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
    // Generated using JFormDesigner Evaluation license - Leandro Costa
    private JPanel panelPublisher;
    private JScrollPane scrollPanelPublisher;
    private JTable tablePublisher;
    private JButton buttonAdd;
    private JButton buttonRefresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
