package br.com.bookstore.util;

import javax.swing.*;
import java.awt.*;

public class MessageUtil {

    public static void addMessage(Component component, String message) {
        JOptionPane.showMessageDialog(component, message);
    }
}
