/*
 * Created by JFormDesigner on Tue Sep 18 13:51:27 BRT 2018
 */

package br.com.bookstore.view.book;

import br.com.bookstore.model.entity.Author;
import br.com.bookstore.model.entity.Book;
import br.com.bookstore.controller.AuthorController;
import br.com.bookstore.controller.BookController;
import br.com.bookstore.controller.PublisherController;
import br.com.bookstore.util.MessageUtil;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 * @author Leandro Costa
 */
public class AddBook extends JFrame {

    Map<Integer, Integer> publisherIds = new HashMap<>();
    Map<Integer, Integer> authorIds = new HashMap<>();
    ResourceBundle currency = ResourceBundle.getBundle("currency");

    public AddBook() {
        initComponents();
        getCbxPublisher();
        getScrollPaneAuthor();
        setUpFormat();
        txtPrice.setText("0.00");
    }

    public AddBook(String ISBN, String title, String price, Integer publisherId, List<Author> authors) {
        initComponents();
        getCbxPublisher();
        getScrollPaneAuthor();
        setUpFormat();
        this.setTitle("Editar livro");
        txtISBN.setText(ISBN);
        txtTitle.setText(title);
        txtPrice.setText(price.replace(".", ","));
        cbxPublisher.setSelectedIndex(getIndexPublisherComboBox(publisherId));
        listAuthor.setSelectedIndices(getIndexAuthorList(authors));
    }

    private int[] getIndexAuthorList(List<Author> authors) {
        List<Integer> listIndex = new ArrayList<>();

        for (Author author : authors) {
            for (int i = 0; i < authorIds.size(); i++) {
                if (authorIds.get(i) == author.getId()) {
                    listIndex.add(i);
                }
            }
        }
        int[] index = new int[listIndex.size()];
        int count = 0;

        for (Integer id : listIndex) {
            index[count] = id;
            count++;
        }
        return index;
    }

    private Integer getIndexPublisherComboBox(Integer id) {
        Integer index = 0;

        for (int i = 0; i < publisherIds.size(); i++) {
            if (publisherIds.get(i) == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void setUpFormat() {
        DecimalFormat decimal = new DecimalFormat(currency.getString("pattern"));
        NumberFormatter numberFormatter = new NumberFormatter(decimal);
        numberFormatter.setFormat(decimal);
        numberFormatter.setAllowsInvalid(false);
        DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numberFormatter);
        txtPrice.setFormatterFactory(dfFactory);
    }

    private void btnCancelActionPerformed(ActionEvent e) {
        dispose();
    }

    private void btnSaveActionPerformed(ActionEvent e) {
        if (!listAuthor.isSelectionEmpty()) {
            PublisherController publisherController = new PublisherController();
            AuthorController authorController = new AuthorController();
            BookController bookController = new BookController();
            try {
                Book book = new Book(txtISBN.getText(), txtTitle.getText(), formatPrice(txtPrice.getText()),
                        publisherController.getById(publisherIds.get(cbxPublisher.getSelectedIndex())),
                        authorController.getAuthorsById(getAuthorIds(listAuthor.getSelectedIndices())));

                String validation = bookController.validate(book);

                if (validation == null) {
                    bookController.save(book);
                    MessageUtil.addMessage(AddBook.this, "Livro salvo com sucesso");
                    dispose();
                } else {
                    MessageUtil.addMessage(AddBook.this, validation);
                }
            } catch (Exception e1) {
                MessageUtil.addMessage(AddBook.this, e1.getMessage());
            }
        } else {
            MessageUtil.addMessage(AddBook.this, "Favor selecione ao menos um autor");
        }
    }

    private float formatPrice(String price) throws NumberFormatException {
        return Float.valueOf(price.replace(".", "").replace(",", "."));
    }

    private List<Integer> getAuthorIds(int[] selectedIndices) {
        List<Integer> ids = new ArrayList<>();

        for (int index : selectedIndices) {
            ids.add(authorIds.get(index));
        }
        return ids;
    }

    private void getScrollPaneAuthor() {
        scrollPaneAuthor.setViewportView(getListAuthor());
    }

    private JList getListAuthor() {
        AuthorController authorController = new AuthorController();
        try {
            String[] names = authorController.getNames(authorIds);
            listAuthor = new JList(names);
        } catch (Exception e) {
            MessageUtil.addMessage(AddBook.this, e.getMessage());
        }
        return listAuthor;
    }

    private void getCbxPublisher() {
        PublisherController publisherController = new PublisherController();
        try {
            ComboBoxModel comboBoxModelPublisher = new DefaultComboBoxModel(publisherController.getNames(publisherIds));
            cbxPublisher.setModel(comboBoxModelPublisher);
        } catch (Exception e) {
            MessageUtil.addMessage(AddBook.this, e.getMessage());
        }
    }

    private void txtISBNKeyPressed(KeyEvent e) {
        if (txtISBN.getText().length() <= 12) {
            try {
                if (e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_RIGHT
                        && e.getKeyCode() != KeyEvent.VK_BACK_SPACE && e.getKeyCode() != KeyEvent.VK_DELETE) {

                        Double.parseDouble(txtISBN.getText() + e.getKeyChar());
                }
            } catch (NumberFormatException e1) {
                MessageUtil.addMessage(AddBook.this, "Válido apenas números");
                removeNonNumericChar();
            }
        } else {
            txtISBN.setText(txtISBN.getText().substring(0, txtISBN.getText().length() - 1));
            removeNonNumericChar();
        }
    }

    private void removeNonNumericChar() {
        String text = "";

        for (char c : txtISBN.getText().toCharArray()) {
            if (Character.isDigit(c)) {
                text += c;
            }
        }
        txtISBN.setText(text);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Leandro Costa
        panel1 = new JPanel();
        lblISBN = new JLabel();
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
        txtISBN = new JTextField();
        label1 = new JLabel();

        //======== this ========
        setTitle("Adicionar livro");
        setResizable(false);
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

            //---- txtPrice ----
            txtPrice.setHorizontalAlignment(SwingConstants.RIGHT);
            txtPrice.setText("0.00");

            //---- txtISBN ----
            txtISBN.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    txtISBNKeyPressed(e);
                }
            });

            //---- label1 ----
            label1.setText("R$");

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
                                    .addComponent(lblTitle)
                                    .addComponent(txtTitle, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(lblISBN)
                                            .addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(label1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblPrice))))
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
                            .addComponent(lblAuthor)
                            .addComponent(lblPrice))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
                        .addContainerGap(30, Short.MAX_VALUE))
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
    // Generated using JFormDesigner Evaluation license - Leandro Costa
    private JPanel panel1;
    private JLabel lblISBN;
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
    private JTextField txtISBN;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
