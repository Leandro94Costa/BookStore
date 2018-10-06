/*
 * Created by JFormDesigner on Fri Oct 05 21:29:25 BRT 2018
 */

package br.com.bookstore.swing;

import br.com.bookstore.swing.author.ListAuthor;
import br.com.bookstore.swing.book.ListBook;
import br.com.bookstore.swing.publisher.ListPublisher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Leandro
 */
public class Main extends JFrame {

    public Main() {
        initComponents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            //@Override
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

    private void menuItemBookActionPerformed(ActionEvent e) {
        ListBook listBook = new ListBook();
        listBook.setLocationRelativeTo(null);
        listBook.setVisible(true);
    }

    private void menuItemPublisherActionPerformed(ActionEvent e) {
        ListPublisher listPublisher = new ListPublisher();
        listPublisher.setLocationRelativeTo(null);
        listPublisher.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Leandro
        menuBar = new JMenuBar();
        menuItemAuthor = new JMenuItem();
        menuItemBook = new JMenuItem();
        menuItemPublisher = new JMenuItem();
        panelMain = new JPanel();
        scrollPane = new JScrollPane();
        tableMain = new JTable();

        //======== this ========
        Container contentPane = getContentPane();

        //======== menuBar ========
        {

            //---- menuItemAuthor ----
            menuItemAuthor.setText("Autores");
            menuItemAuthor.addActionListener(e -> menuItemAuthorActionPerformed(e));
            menuBar.add(menuItemAuthor);

            //---- menuItemBook ----
            menuItemBook.setText("Livros");
            menuItemBook.addActionListener(e -> menuItemBookActionPerformed(e));
            menuBar.add(menuItemBook);

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


            //======== scrollPane ========
            {
                scrollPane.setViewportView(tableMain);
            }

            GroupLayout panelMainLayout = new GroupLayout(panelMain);
            panelMain.setLayout(panelMainLayout);
            panelMainLayout.setHorizontalGroup(
                panelMainLayout.createParallelGroup()
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                        .addContainerGap())
            );
            panelMainLayout.setVerticalGroup(
                panelMainLayout.createParallelGroup()
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
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
    private JMenuItem menuItemBook;
    private JMenuItem menuItemPublisher;
    private JPanel panelMain;
    private JScrollPane scrollPane;
    private JTable tableMain;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
