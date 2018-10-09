/*
 * Created by JFormDesigner on Fri Oct 05 21:29:25 BRT 2018
 */

package br.com.bookstore.swing;

import br.com.bookstore.domain.entity.Book;
import br.com.bookstore.service.BookService;
import br.com.bookstore.swing.author.ListAuthor;
import br.com.bookstore.swing.book.AddBook;
import br.com.bookstore.swing.publisher.ListPublisher;
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
public class Main extends JFrame {

    private List<Long> bookIds = new ArrayList<>();

    public Main() {
        initComponents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
                main.setLocationRelativeTo(null);
                main.setVisible(true);
            }
        });
    }

    private void menuItemAuthorActionPerformed(ActionEvent e) {
        ListAuthor listAuthor = new ListAuthor();
        listAuthor.setLocationRelativeTo(null);
        listAuthor.setVisible(true);
    }

    private void buttonAddActionPerformed(ActionEvent e) {
        AddBook addBook = new AddBook();
        addBook.setLocationRelativeTo(null);
        addBook.setVisible(true);
    }

    private void menuItemPublisherActionPerformed(ActionEvent e) {
        ListPublisher listPublisher = new ListPublisher();
        listPublisher.setLocationRelativeTo(null);
        listPublisher.setVisible(true);
    }

    private void buttonRefreshActionPerformed(ActionEvent e) {
        getScrollPane();
    }

    private void thisWindowOpened(WindowEvent e) {
        getScrollPane();
    }

    private JScrollPane getScrollPane() {
        scrollPanelMain.setViewportView(getTableMain());
        return scrollPanelMain;
    }

    private JTable getTableMain() {
        BookService bookService = new BookService();
        String[] header = {"ISBN", "Título", "Preço", "Autores", "Editora", "", ""};
        try {
            String[][] books = bookService.getAll(bookIds);
            TableModel tableModelMain = new DefaultTableModel(books, header);
            tableMain = new JTable();
            tableMain.setModel(tableModelMain);

            Action actionEdit = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = Integer.parseInt(e.getActionCommand());
                    try {
                        Book book = bookService.getById(bookIds.get(row));
                        editBook(book);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        MessageUtil.addMessage(Main.this, e1.getMessage());
                    }
                }
            };

            Action actionDelete = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int response = JOptionPane.showConfirmDialog(Main.this, "Deseja remover o registro?");
                    if (response == 0) {
                        JTable table = (JTable) e.getSource();
                        int row = Integer.parseInt(e.getActionCommand());
                        ((DefaultTableModel) table.getModel()).removeRow(row);
                        try {
                            bookService.delete(bookIds.get(row));
                            MessageUtil.addMessage(Main.this, "Registro removido com sucesso!");
                        } catch (Exception e1) {
                            e1.printStackTrace();
                            MessageUtil.addMessage(Main.this, e1.getMessage());
                        }
                    }
                }
            };

            ButtonColumn buttonColumnEdit = new ButtonColumn(tableMain, actionEdit, 5);
            ButtonColumn buttonColumnRemove = new ButtonColumn(tableMain, actionDelete, 6);
            buttonColumnEdit.setMnemonic(KeyEvent.VK_D);    //Atalho D
            buttonColumnRemove.setMnemonic(KeyEvent.VK_E);  //Atalho E
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addMessage(Main.this, e.getMessage());
        }
        return tableMain;
    }

    private void editBook(Book book) {
        AddBook addBook = new AddBook(book.getIsbn().toString(), book.getTitle().toString(), book.getPrice().toString());
        addBook.setLocationRelativeTo(null);
        addBook.setVisible(true);
    }

    private void menuItemBookActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Leandro
        menuBar = new JMenuBar();
        menuItemAuthor = new JMenuItem();
        menuItemPublisher = new JMenuItem();
        panelMain = new JPanel();
        scrollPanelMain = new JScrollPane();
        tableMain = new JTable();
        buttonAdd = new JButton();
        buttonRefresh = new JButton();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
            }
        });
        Container contentPane = getContentPane();

        //======== menuBar ========
        {

            //---- menuItemAuthor ----
            menuItemAuthor.setText("Autores");
            menuItemAuthor.addActionListener(e -> menuItemAuthorActionPerformed(e));
            menuBar.add(menuItemAuthor);

            //---- menuItemPublisher ----
            menuItemPublisher.setText("Editoras");
            menuItemPublisher.addActionListener(e -> menuItemPublisherActionPerformed(e));
            menuBar.add(menuItemPublisher);
        }
        setJMenuBar(menuBar);

        //======== panelMain ========
        {

            // JFormDesigner evaluation mark
            panelMain.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panelMain.getBorder())); panelMain.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //======== scrollPanelMain ========
            {
                scrollPanelMain.setViewportView(tableMain);
            }

            //---- buttonAdd ----
            buttonAdd.setText("Adicionar");
            buttonAdd.setIcon(new ImageIcon("D:\\Documents\\Java\\Projects\\BookStore\\src\\main\\resources\\icons\\Books32.png"));
            buttonAdd.addActionListener(e -> buttonAddActionPerformed(e));

            //---- buttonRefresh ----
            buttonRefresh.setIcon(new ImageIcon("D:\\Documents\\Java\\Projects\\BookStore\\src\\main\\resources\\icons\\Refresh32.png"));
            buttonRefresh.addActionListener(e -> {
			buttonRefreshActionPerformed(e);
			buttonRefreshActionPerformed(e);
		});

            GroupLayout panelMainLayout = new GroupLayout(panelMain);
            panelMain.setLayout(panelMainLayout);
            panelMainLayout.setHorizontalGroup(
                panelMainLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPanelMain, GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(buttonAdd)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 599, Short.MAX_VALUE)
                                .addComponent(buttonRefresh)))
                        .addContainerGap())
            );
            panelMainLayout.setVerticalGroup(
                panelMainLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonRefresh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPanelMain, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Leandro
    private JMenuBar menuBar;
    private JMenuItem menuItemAuthor;
    private JMenuItem menuItemPublisher;
    private JPanel panelMain;
    private JScrollPane scrollPanelMain;
    private JTable tableMain;
    private JButton buttonAdd;
    private JButton buttonRefresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
