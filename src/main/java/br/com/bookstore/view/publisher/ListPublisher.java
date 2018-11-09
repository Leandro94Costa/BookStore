/*
 * Created by JFormDesigner on Fri Oct 05 22:28:42 BRT 2018
 */

package br.com.bookstore.view.publisher;

import br.com.bookstore.model.entity.Publisher;
import br.com.bookstore.controller.BookController;
import br.com.bookstore.controller.PublisherController;
import br.com.bookstore.view.util.ButtonColumn;
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
 * @author Leandro Costa
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

    private void getScrollPanelPublisher() {
        publisherIds = new ArrayList<>();
        scrollPanelPublisher.setViewportView(getTablePublisher(null));
    }

    private void getScrollPanelPublisher(String[][] publishers) {
        publisherIds = new ArrayList<>();
        scrollPanelPublisher.setViewportView(getTablePublisher(publishers));
    }

    private JTable getTablePublisher(String[][] publishers) {
        PublisherController publisherController = new PublisherController();
        String[] header = {"Nome", "URL", "", ""};
        try {
            if (publishers == null) {
                publishers = publisherController.getAll(publisherIds);
            }
            TableModel tableModelPublisher = new DefaultTableModel(publishers, header);
            tablePublisher = new JTable();
            tablePublisher.setModel(tableModelPublisher);

            Action actionEdit = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = Integer.parseInt(e.getActionCommand());
                    try {
                        Publisher publisher = publisherController.getById(publisherIds.get(row));
                        editPublisher(publisher);
                    } catch (Exception e1) {
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
                            if (!publisherController.hasBooks(publisherIds.get(row))) {
                                publisherController.delete(publisherIds.get(row));
                                ((DefaultTableModel) table.getModel()).removeRow(row);
                                publisherIds.remove(row);
                                MessageUtil.addMessage(ListPublisher.this, "Editora removida com sucesso!");
                            } else {
                                response = JOptionPane.showConfirmDialog(ListPublisher.this,
                                        "Editora com livros salvos, deseja remover os livros e a editora?");
                                if (response == 0) {
                                    BookController bookController = new BookController();
                                    bookController.deleteByPublisher(publisherIds.get(row));
                                    publisherController.delete(publisherIds.get(row));
                                    ((DefaultTableModel) table.getModel()).removeRow(row);
                                    publisherIds.remove(row);
                                    MessageUtil.addMessage(ListPublisher.this, "Editora e livros removidos com sucesso!");
                                }
                            }
                        } catch (Exception e1) {
                            MessageUtil.addMessage(ListPublisher.this, e1.getMessage());
                        }
                    }
                }
            };

            ButtonColumn buttonColumnEdit = new ButtonColumn(tablePublisher, actionEdit, 2);
            ButtonColumn buttonColumnRemove = new ButtonColumn(tablePublisher, actionRemove, 3);
            buttonColumnEdit.setMnemonic(KeyEvent.VK_D);
            buttonColumnRemove.setMnemonic(KeyEvent.VK_E);
        } catch (Exception e) {
            MessageUtil.addMessage(ListPublisher.this, e.getMessage());
        }
        return tablePublisher;
    }

    private void editPublisher(Publisher publisher) {
        AddPublisher addPublisher = new AddPublisher(String.valueOf(publisher.getId()), publisher.getName(), publisher.getUrl());
        addPublisher.setLocationRelativeTo(null);
        addPublisher.setVisible(true);
    }

    private void buttonSearchActionPerformed(ActionEvent e) {
        if (!"".equals(txtSearch.getText())) {
            PublisherController publisherController = new PublisherController();
            try {
                getScrollPanelPublisher(publisherController.search(txtSearch.getText(), publisherIds));
            } catch (Exception e1) {
                MessageUtil.addMessage(ListPublisher.this, e1.getMessage());
            }
        } else {
            MessageUtil.addMessage(ListPublisher.this, "Favor digitar o nome da editora");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Leandro
        panelPublisher = new JPanel();
        scrollPanelPublisher = new JScrollPane();
        tablePublisher = new JTable();
        buttonAdd = new JButton();
        buttonRefresh = new JButton();
        txtSearch = new JTextField();
        buttonSearch = new JButton();

        //======== this ========
        setTitle("Editoras");
        setResizable(false);
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

            //---- buttonSearch ----
            buttonSearch.setText("Pesquisar");
            buttonSearch.addActionListener(e -> buttonSearchActionPerformed(e));

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
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSearch)
                                .addGap(18, 18, 18)
                                .addComponent(buttonRefresh)))
                        .addContainerGap())
            );
            panelPublisherLayout.setVerticalGroup(
                panelPublisherLayout.createParallelGroup()
                    .addGroup(panelPublisherLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelPublisherLayout.createParallelGroup()
                            .addGroup(panelPublisherLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonSearch)
                                .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
    private JTextField txtSearch;
    private JButton buttonSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
