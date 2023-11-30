/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.sms.gui.dialog.au;

import com.aldrin.sms.Sms;
import com.aldrin.sms.config.HibernateConfig;
import com.aldrin.sms.dao.imp.CourseDAOImpl;
import com.aldrin.sms.dao.imp.StudentDAOImpl;
import com.aldrin.sms.entity.Course;
import com.aldrin.sms.entity.Gender;
import com.aldrin.sms.entity.Student;
import com.aldrin.sms.gui.JFrameSIS;
import com.aldrin.sms.uti.ComboBoxList;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ALDRIN B. C.
 */
public class JDialogStudentAU extends javax.swing.JDialog {

    private CourseDAOImpl courseDAOImpl = new CourseDAOImpl();
    private HibernateConfig hibernateConfig = new HibernateConfig();
    private StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
    private JFrameSIS jFrameSIS;

    /**
     * Creates new form JDialogStudent
     */
    private Student student = new Student();
    static String title = "";

    public JDialogStudentAU(JFrameSIS jFrameSIS, boolean modal) {
        super(jFrameSIS, modal);
        initComponents();
        this.title = "New";
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(0, 102, 153));
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "First name");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Surname");
        jTextFieldMobile.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Mobile");
        jTextFieldEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Email");
        jTextFieldAddress.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Address");
        jComboBoxCourse.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Gender");
        jDateChooserDateOfBirth.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Date of birth");
        for (Gender gender : Gender.values()) {
            jComboBoxGender.addItem(gender.toString());
        }
        comboBoxRCourse();

    }

    public JDialogStudentAU(JFrameSIS jFrameSIS, boolean modal, Student student, String title) {
        super(jFrameSIS, modal);
        initComponents();
        this.student = student;
        this.title = title;
        //update
        for (Gender gender : Gender.values()) {
            jComboBoxGender.addItem(gender.toString());
        }
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(0, 102, 153));
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "First name");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Surname");
        jTextFieldMobile.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Mobile");
        jTextFieldEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Email");
        jTextFieldAddress.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Address");
        jComboBoxCourse.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Gender");
        jDateChooserDateOfBirth.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Date of birth");
        if (student.getGender().toString().equals("MALE")) {
            jComboBoxGender.setSelectedIndex(0);
            System.out.println("MALE");
        } else if (student.getGender().toString().equals("FEMALE")) {
            jComboBoxGender.setSelectedIndex(1);
            System.out.println("FEMALE");
        } else if (student.getGender().toString().equals("OTHER")) {
            jComboBoxGender.setSelectedIndex(2);
            System.out.println("OTHER");
        }
        comboBoxRCourse();
        jTextFieldFirstname.setText(student.getFirstname());
        jTextFieldSurname.setText(student.getSurname());
        jTextFieldMobile.setText(student.getMobileNo());
        jTextFieldEmail.setText(student.getEmail());
        jTextFieldAddress.setText(student.getAddress());
        for (ComboBoxList a : this.courseDAOImpl.getList()) {
            a.setSelectedId(courseDAOImpl.getList(), String.valueOf(student.getCourse().getId()), jComboBoxCourse);
        }
        jDateChooserDateOfBirth.setDate(student.getDate_of_birth());
        displayPicture(student);

    }

    public JDialogStudentAU(JFrameSIS jFrameSIS, boolean modal, String title, Student student) {
        super(jFrameSIS, modal);
        initComponents();
        this.student = student;
        this.title = title;
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(0, 102, 153));
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "First name");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Surname");
        jTextFieldMobile.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Mobile");
        jTextFieldEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Email");
        jTextFieldAddress.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Address");
        jComboBoxCourse.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Gender");
        jDateChooserDateOfBirth.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Date of birth");
        if (student.getGender().toString().equals("MALE")) {
            jComboBoxGender.setSelectedIndex(0);
            System.out.println("MALE");
        } else if (student.getGender().toString().equals("FEMALE")) {
            jComboBoxGender.setSelectedIndex(1);
            System.out.println("FEMALE");
        } else if (student.getGender().toString().equals("OTHER")) {
            jComboBoxGender.setSelectedIndex(2);
            System.out.println("OTHER");
        }
        comboBoxRCourse();
        jTextFieldFirstname.setText(student.getFirstname());
        jTextFieldSurname.setText(student.getSurname());
        jTextFieldMobile.setText(student.getMobileNo());
        jTextFieldEmail.setText(student.getEmail());
        jTextFieldAddress.setText(student.getAddress());
        for (ComboBoxList a : this.courseDAOImpl.getList()) {
            a.setSelectedId(courseDAOImpl.getList(), String.valueOf(student.getCourse().getId()), jComboBoxCourse);
        }
        jDateChooserDateOfBirth.setDate(student.getDate_of_birth());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFirstname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSurname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelPicture = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldMobile = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldAddress = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jDateChooserDateOfBirth = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxCourse = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxGender = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("FIRST NAME");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 208, -1));

        jTextFieldFirstname.setPreferredSize(new java.awt.Dimension(64, 30));
        getContentPane().add(jTextFieldFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, 208, -1));

        jLabel2.setText("SURNAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 208, -1));

        jTextFieldSurname.setPreferredSize(new java.awt.Dimension(64, 30));
        getContentPane().add(jTextFieldSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, 208, -1));

        jLabel3.setText("MOBILE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 208, -1));

        jLabel4.setText("EMAIL");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 208, -1));

        jLabel5.setText("DATE OF BIRTH");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 208, -1));

        jLabel6.setText("ADDRESS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 208, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "PHOTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 102, 153))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabelPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/no photo.jpg"))); // NOI18N
        jLabelPicture.setPreferredSize(new java.awt.Dimension(200, 200));
        jLabelPicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPictureMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelPicture, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(210, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 15, 200, 230));

        jTextFieldMobile.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldMobile.setPreferredSize(new java.awt.Dimension(64, 32));
        getContentPane().add(jTextFieldMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 225, 208, -1));

        jTextFieldEmail.setPreferredSize(new java.awt.Dimension(64, 32));
        getContentPane().add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 275, 208, -1));

        jTextFieldAddress.setPreferredSize(new java.awt.Dimension(64, 32));
        getContentPane().add(jTextFieldAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 375, 425, -1));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 168, 32));

        jDateChooserDateOfBirth.setDate(new Date());
        jDateChooserDateOfBirth.setPreferredSize(new java.awt.Dimension(85, 32));
        getContentPane().add(jDateChooserDateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 325, 208, -1));

        jLabel7.setText("COURSE");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 208, -1));

        jComboBoxCourse.setPreferredSize(new java.awt.Dimension(72, 32));
        getContentPane().add(jComboBoxCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 125, 210, 30));

        jLabel8.setText("GENDER");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 208, -1));

        jComboBoxGender.setPreferredSize(new java.awt.Dimension(72, 32));
        getContentPane().add(jComboBoxGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 175, 210, 30));

        setSize(new java.awt.Dimension(467, 514));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.title.equals("New")) {
            this.student.setFirstname(jTextFieldFirstname.getText());
            this.student.setSurname(jTextFieldSurname.getText());
            this.student.setMobileNo(jTextFieldMobile.getText());
            this.student.setEmail(jTextFieldEmail.getText());
            this.student.setAddress(jTextFieldAddress.getText());
            if (Gender.MALE.toString() == jComboBoxGender.getSelectedItem().toString()) {
                this.student.setGender(Gender.MALE);
            } else if (Gender.FEMALE.toString() == jComboBoxGender.getSelectedItem().toString()) {
                this.student.setGender(Gender.FEMALE);
            } else if (Gender.OTHER.toString() == jComboBoxGender.getSelectedItem().toString()) {
                this.student.setGender(Gender.OTHER);
            }
            this.student.setDate_of_birth(new java.sql.Date(jDateChooserDateOfBirth.getDate().getTime()));

            ComboBoxList courseId = (ComboBoxList) this.jComboBoxCourse.getSelectedItem();
            Course course = new Course();
            course.setId(courseId.getId());
            this.student.setCourse(course);
            try {
                validatePhoto();
            } catch (URISyntaxException ex) {
                Logger.getLogger(JDialogStudentAU.class.getName()).log(Level.SEVERE, null, ex);
            }
            studentDAOImpl.addStudent(student, hibernateConfig.getEntityManager());
            this.dispose();
        } else if (this.title.equals("Update")) {
            this.student.setFirstname(jTextFieldFirstname.getText());
            this.student.setSurname(jTextFieldSurname.getText());
            this.student.setMobileNo(jTextFieldMobile.getText());
            this.student.setEmail(jTextFieldEmail.getText());
            this.student.setAddress(jTextFieldAddress.getText());
            if (Gender.MALE.toString() == jComboBoxGender.getSelectedItem().toString()) {
                this.student.setGender(Gender.MALE);
            } else if (Gender.FEMALE.toString() == jComboBoxGender.getSelectedItem().toString()) {
                this.student.setGender(Gender.FEMALE);
            } else if (Gender.OTHER.toString() == jComboBoxGender.getSelectedItem().toString()) {
                this.student.setGender(Gender.OTHER);
            }
            this.student.setDate_of_birth(new java.sql.Date(jDateChooserDateOfBirth.getDate().getTime()));

            ComboBoxList courseId = (ComboBoxList) this.jComboBoxCourse.getSelectedItem();
            Course course = new Course();
            course.setId(courseId.getId());
            this.student.setCourse(course);
            try {
                validatePhoto();
            } catch (URISyntaxException ex) {
                Logger.getLogger(JDialogStudentAU.class.getName()).log(Level.SEVERE, null, ex);
            }
            studentDAOImpl.updateStudent(student, hibernateConfig.getEntityManager());
            this.dispose();
        } else if (this.title.equals("Delete")) {
            studentDAOImpl.deleteStudent(student, hibernateConfig.getEntityManager());
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabelPictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPictureMouseClicked

        browse();
    }//GEN-LAST:event_jLabelPictureMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Object> jComboBoxCourse;
    private javax.swing.JComboBox<String> jComboBoxGender;
    private com.toedter.calendar.JDateChooser jDateChooserDateOfBirth;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelPicture;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFirstname;
    private javax.swing.JTextField jTextFieldMobile;
    private javax.swing.JTextField jTextFieldSurname;
    // End of variables declaration//GEN-END:variables

    private void comboBoxRCourse() {
        courseDAOImpl.comboBoxCourse(hibernateConfig.getEntityManager());
        jComboBoxCourse.removeAllItems();
        for (ComboBoxList a : courseDAOImpl.getList()) {
            this.jComboBoxCourse.addItem(a);
        }
    }

    private File pictureFile = null;

    private void browse() {
        try {
            int returnVal = jFileChooser1.showOpenDialog(this);
            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                pictureFile = jFileChooser1.getSelectedFile();
                uploadPhoto(pictureFile);
                int IMG_WIDTH = jLabelPicture.getWidth();
                int IMG_HEIGHT = jLabelPicture.getHeight();

                try {
                    BufferedImage originalImage = ImageIO.read(pictureFile);
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
                    Graphics2D g = resizedImage.createGraphics();
                    g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
                    g.dispose();
                    g.setComposite(AlphaComposite.Src);

                    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g.setRenderingHint(RenderingHints.KEY_RENDERING,
                            RenderingHints.VALUE_RENDER_QUALITY);
                    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    jLabelPicture.setIcon(new ImageIcon(resizedImage)); //to eliminate .jpeg from picture filename
                    ImageIO.write(resizedImage, "png", new File(Sms.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "\\images\\model.jpg"));

                } catch (final IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                File defaultDirectory = new File(System.getProperty("user.home"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void uploadPhoto(File file) {
        if (file != null) {
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] imageData = new byte[(int) file.length()];
                fis.read(imageData);
                student.setPhoto(imageData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    int IMG_WIDTH = 200;
    int IMG_HEIGHT = 200;

    private void displayPicture(Student student) {
        try {
            byte[] imageData = student.getPhoto();
            ImageIcon imageIcon = new ImageIcon(imageData);

            Image image = imageIcon.getImage();
            int type = BufferedImage.TYPE_INT_ARGB;

            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(image, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
            g.dispose();
            g.setComposite(AlphaComposite.Src);

            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            jLabelPicture.setIcon(new ImageIcon(resizedImage));//image to label

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validatePhoto() throws URISyntaxException {
        if (student.getPhoto() == null) {
            File targetClassesDir = new File(Sms.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "\\images\\no photo.jpg");
            try {
                FileInputStream fis = new FileInputStream(targetClassesDir);
                byte[] imageData = new byte[(int) targetClassesDir.length()];
                fis.read(imageData);
                student.setPhoto(imageData);
            } catch (Exception e) {
                System.out.println("default of no photo is error");
            }
        }
    }

}
