/*
 * Created by JFormDesigner on Fri Oct 05 21:34:09 BRT 2018
 */

package br.com.bookstore.swing.author;

import br.com.bookstore.domain.entity.Author;
import br.com.bookstore.service.AuthorService;
import br.com.bookstore.service.BookService;
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
public class ListAuthor extends JFrame {

    List<Integer> authorIds;

    public ListAuthor() {
        initComponents();
    }

    private void buttonAddActionPerformed(ActionEvent e) {
        AddAuthor addAuthor = new AddAuthor();
        addAuthor.setLocationRelativeTo(null);
        addAuthor.setVisible(true);
    }

    private void buttonRefreshActionPerformed(ActionEvent e) {
        getScrollPanelAuthor();
    }

    private void thisWindowOpened(WindowEvent e) {
        getScrollPanelAuthor();
    }

    private JScrollPane getScrollPanelAuthor() {
        authorIds = new ArrayList<>();
        scrollPanelAuthor.setViewportView(getTableAuthor());
        return scrollPanelAuthor;
    }

    private JTable getTableAuthor() {
        AuthorService authorService = new AuthorService();
        String[] header = {"Nome", "Sobrenome", "", ""};
        try {
            String[][] authors = authorService.getAll(authorIds);
            TableModel tableModelAuthor = new DefaultTableModel(authors, header);
            tableAuthor = new JTable();
            tableAuthor.setModel(tableModelAuthor);

            Action actionEdit = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = Integer.parseInt(e.getActionCommand());
                    try {
                        Author author = authorService.getById(authorIds.get(row));
                        editAuthor(author);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        MessageUtil.addMessage(ListAuthor.this, e1.getMessage());
                    }
                }
            };

            Action actionRemove = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int response = JOptionPane.showConfirmDialog(ListAuthor.this, "Deseja remover o autor?");
                    if (response == 0) {
                        JTable table = (JTable) e.getSource();
                        int row = Integer.parseInt(e.getActionCommand());
                        try {
                            if (!authorService.hasBooks(authorIds.get(row))) {
                                authorService.delete(authorIds.get(row));
                                ((DefaultTableModel) table.getModel()).removeRow(row);
                                MessageUtil.addMessage(ListAuthor.this, "Autor removido com sucesso!");
                            } else {
                                response = JOptionPane.showConfirmDialog(ListAuthor.this,
                                        "Autor ou coautor de ao menos um livro, deseja excluir todos os livros relacionados a esse autor?");
                                if (response == 0) {
                                    BookService bookService = new BookService();
                                    bookService.deleteByAuthor(authorIds.get(row));
                                    authorService.delete(authorIds.get(row));
                                    ((DefaultTableModel) table.getModel()).removeRow(row);
                                    MessageUtil.addMessage(ListAuthor.this, "Autor e livros removidos com sucesso!");
                                }
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                            MessageUtil.addMessage(ListAuthor.this, e1.getMessage());
                        }
                    }
                }
            };

            ButtonColumn buttonColumnEdit = new ButtonColumn(tableAuthor, actionEdit, 2);
            ButtonColumn buttonColumnRemove = new ButtonColumn(tableAuthor, actionRemove, 3);
            buttonColumnEdit.setMnemonic(KeyEvent.VK_D);    //Atalho D
            buttonColumnRemove.setMnemonic(KeyEvent.VK_E);  //Atalho E
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addMessage(ListAuthor.this, e.getMessage());
        }
        return tableAuthor;
    }

    private void editAuthor(Author author) {
        AddAuthor addAuthor = new AddAuthor(String.valueOf(author.getId()), author.getFirstName(), author.getName());
        addAuthor.setLocationRelativeTo(null);
        addAuthor.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Leandro Costa
        panelAuthor = new JPanel();
        scrollPanelAuthor = new JScrollPane();
        tableAuthor = new JTable();
        buttonAdd = new JButton();
        buttonRefresh = new JButton();

        //======== this ========
        setTitle("Autores");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
            }
        });
        Container contentPane = getContentPane();

        //======== panelAuthor ========
        {

            // JFormDesigner evaluation mark
            panelAuthor.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panelAuthor.getBorder())); panelAuthor.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //======== scrollPanelAuthor ========
            {
                scrollPanelAuthor.setViewportView(tableAuthor);
            }

            //---- buttonAdd ----
            buttonAdd.setText("Adicionar");
            buttonAdd.setIcon(new ImageIcon(getClass().getResource("/icons/AddUser32.png")));
            buttonAdd.addActionListener(e -> buttonAddActionPerformed(e));

            //---- buttonRefresh ----
            buttonRefresh.setIcon(new ImageIcon(getClass().getResource("/icons/Refresh32.png")));
            buttonRefresh.addActionListener(e -> buttonRefreshActionPerformed(e));

            GroupLayout panelAuthorLayout = new GroupLayout(panelAuthor);
            panelAuthor.setLayout(panelAuthorLayout);
            panelAuthorLayout.setHorizontalGroup(
                panelAuthorLayout.createParallelGroup()
                    .addGroup(panelAuthorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelAuthorLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollPanelAuthor, GroupLayout.PREFERRED_SIZE, 787, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelAuthorLayout.createSequentialGroup()
                                .addComponent(buttonAdd)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonRefresh)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panelAuthorLayout.setVerticalGroup(
                panelAuthorLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panelAuthorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelAuthorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRefresh, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPanelAuthor, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panelAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Leandro Costa
    private JPanel panelAuthor;
    private JScrollPane scrollPanelAuthor;
    private JTable tableAuthor;
    private JButton buttonAdd;
    private JButton buttonRefresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
