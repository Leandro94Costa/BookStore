/*
 * Created by JFormDesigner on Tue Sep 18 13:51:27 BRT 2018
 */

package br.com.bookstore.swing.book;

import br.com.bookstore.domain.entity.Book;
import br.com.bookstore.service.AuthorService;
import br.com.bookstore.service.BookService;
import br.com.bookstore.service.PublisherService;
import br.com.bookstore.util.MessageUtil;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Leandro
 */
public class AddBook extends JFrame {

    Map<Integer, Integer> publisherIds = new HashMap<>();
    Map<Integer, Integer> authorIds = new HashMap<>();

    public AddBook() {
        initComponents();
        getCbxPublisher();
    }

    public AddBook(String ISBN, String title, String price, Integer publisherId) {
        initComponents();
        getCbxPublisher();
        this.setTitle("Editar livro");
        txtISBN.setText(ISBN);
        txtTitle.setText(title);
        txtPrice.setText(price);
        cbxPublisher.setSelectedIndex(setPublisherComboBox(publisherId));
    }

    private Integer setPublisherComboBox(Integer id) {
        Integer index = 0;
        for (int i = 0; i < publisherIds.size(); i++) {
            if (publisherIds.get(i) == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void btnCancelActionPerformed(ActionEvent e) {
        dispose();
    }

    private void btnSaveActionPerformed(ActionEvent e) {
        if (!"".equals(txtISBN.getText()) && !"".equals(txtTitle.getText()) && !"".equals(txtPrice.getText())) {
            Book book = new Book();
            BookService bookService = new BookService();
            try {
                bookService.save(book);
            } catch (Exception e1) {
                e1.printStackTrace();
                MessageUtil.addMessage(AddBook.this, e1.getMessage());
            }
        } else {

        }
    }

    private void thisWindowOpened(WindowEvent e) {
        getScrollPaneAuthor();
    }

    private JScrollPane getScrollPaneAuthor() {
        scrollPaneAuthor.setViewportView(getListAuthor());
        return scrollPaneAuthor;
    }

    private JList getListAuthor() {
        AuthorService authorService = new AuthorService();
        try {
            String[] names = authorService.getNames(authorIds);
            listAuthor = new JList(names);
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addMessage(AddBook.this, e.getMessage());
        }
        return listAuthor;
    }

    private JComboBox getCbxPublisher() {
        PublisherService publisherService = new PublisherService();
        try {
            ComboBoxModel comboBoxModelPublisher = new DefaultComboBoxModel(publisherService.getNames(publisherIds));
            cbxPublisher.setModel(comboBoxModelPublisher);
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addMessage(AddBook.this, e.getMessage());
        }
        return cbxPublisher;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Leandro
        panel1 = new JPanel();
        lblISBN = new JLabel();
        txtISBN = new JTextField();
        lblTitle = new JLabel();
        txtTitle = new JTextField();
        lblPrice = new JLabel();
        lblPublisher = new JLabel();
        cbxPublisher = new JComboBox();
        lblAuthor = new JLabel();
        scrollPaneAuthor = new JScrollPane();
        listAuthor = new JList();
        btnCancel = new JButton();
        btnSave = new JButton();
        txtPrice = new JFormattedTextField();

        //======== this ========
        setTitle("Adicionar livro");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
            }
        });
        Container contentPane = getContentPane();

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //---- lblISBN ----
            lblISBN.setText("ISBN");

            //---- lblTitle ----
            lblTitle.setText("T\u00edtulo");

            //---- lblPrice ----
            lblPrice.setText("Pre\u00e7o");

            //---- lblPublisher ----
            lblPublisher.setText("Editora");

            //---- lblAuthor ----
            lblAuthor.setText("Autor");

            //======== scrollPaneAuthor ========
            {
                scrollPaneAuthor.setViewportView(listAuthor);
            }

            //---- btnCancel ----
            btnCancel.setText("Cancelar");
            btnCancel.addActionListener(e -> btnCancelActionPerformed(e));

            //---- btnSave ----
            btnSave.setText("Salvar");
            btnSave.addActionListener(e -> btnSaveActionPerformed(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPublisher)
                                    .addComponent(cbxPublisher, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblISBN))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(lblPrice)
                                            .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lblTitle)
                                    .addComponent(txtTitle, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                                .addGap(51, 51, 51)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(lblAuthor)
                                        .addGap(0, 316, Short.MAX_VALUE))
                                    .addComponent(scrollPaneAuthor, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel)))
                        .addContainerGap(28, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblISBN)
                            .addComponent(lblPrice)
                            .addComponent(lblAuthor))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblPublisher)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxPublisher, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTitle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollPaneAuthor))
                        .addGap(31, 31, 31)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel)
                            .addComponent(btnSave))
                        .addContainerGap(32, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Leandro
    private JPanel panel1;
    private JLabel lblISBN;
    private JTextField txtISBN;
    private JLabel lblTitle;
    private JTextField txtTitle;
    private JLabel lblPrice;
    private JLabel lblPublisher;
    private JComboBox cbxPublisher;
    private JLabel lblAuthor;
    private JScrollPane scrollPaneAuthor;
    private JList listAuthor;
    private JButton btnCancel;
    private JButton btnSave;
    private JFormattedTextField txtPrice;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
