/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.aldrin.sms;

import com.aldrin.sms.config.HibernateConfig;
import com.aldrin.sms.gui.JFrameSIS;
import com.formdev.flatlaf.FlatLightLaf;
import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author ALDRIN B. C.
 */
public class Sms {




    public static void main(String[] args) throws URISyntaxException {
        FlatLightLaf.setup();
        UIManager.put("Button.arc", 8);//JButton
        UIManager.put("ProgressBar.arc", 999);//JProgressBar
        UIManager.put("TextComponent.arc", 8);//JTextField,JPasswordField,JFormattedTextField
        UIManager.put("CheckBox", 999);//JCheckBox
        UIManager.put("Component.arc", 8);//JComboBox,JSpinner

        UIManager.put("Component.innerFocusWidth", 2);//JComboBox, JTextField,JPasswordField,JFormattedTextField,JSpinner
        UIManager.put("Button.innerFocusWidth", 2);//JButton

        System.setProperty("flatlaf.menuBarEmbedded", "false");
        HibernateConfig config = new HibernateConfig();
        JFrameSIS sis = new JFrameSIS();
        sis.setVisible(true);


    }
}
