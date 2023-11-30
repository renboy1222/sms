/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.sms.gui.dialog.au;


import com.aldrin.sms.config.HibernateConfig;
import com.aldrin.sms.dao.imp.CourseDAOImpl;
import com.aldrin.sms.entity.Course;
import com.aldrin.sms.gui.JFrameSIS;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;

/**
 *
 * @author ALDRIN B. C.
 */
public class JDialogCourseAU extends javax.swing.JDialog {

    /**
     * Creates new form JDialogCourseAU
     */
    private JFrameSIS jFrameSIS;
    private Course course = new Course();
    static String title;
    private CourseDAOImpl courseDAOImpl = new CourseDAOImpl();
    private HibernateConfig hibernateConfig = new HibernateConfig();

    public JDialogCourseAU(JFrameSIS jFrameSIS, boolean modal) {
        super(jFrameSIS, modal);
        initComponents();
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(0, 102, 153));
        setTitle("New");
        this.title ="New";
        jButton1.setIcon(new FlatSVGIcon("svg/save.svg"));
        jTextFieldCourse.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Course");
        jTextFieldDescription.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Description");
    }

    public JDialogCourseAU(JFrameSIS jFrameSIS, boolean modal, Course course, String title) {
        super(jFrameSIS, modal);
        initComponents();
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(0, 102, 153));
        setTitle(title);
        this.title =title;
        this.course = course;
        jButton1.setIcon(new FlatSVGIcon("svg/edit.svg"));
        jButton1.setText(title);
        jTextFieldCourse.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Course");
        jTextFieldDescription.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Description");
        jTextFieldCourse.setText(course.getCourse());
        jTextFieldDescription.setText(course.getDescription());
    }

    public JDialogCourseAU(JFrameSIS jFrameSIS, boolean modal, String title, Course course) {
        super(jFrameSIS, modal);
        initComponents();
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(0, 102, 153));
        setTitle(title);
        this.course = course;
        this.title =title;
        jButton1.setIcon(new FlatSVGIcon("svg/delete.svg"));
        jButton1.setText(title);
        jTextFieldCourse.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Course");
        jTextFieldDescription.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Description");
        jTextFieldCourse.setText(course.getCourse());
        jTextFieldDescription.setText(course.getDescription());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldDescription = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCourse = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("DESCRIPTION");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 330, 30));
        getContentPane().add(jTextFieldDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 112, 330, 30));

        jLabel2.setText("COURSE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 330, 30));
        getContentPane().add(jTextFieldCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 42, 330, 30));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 140, 30));

        setSize(new java.awt.Dimension(366, 264));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.title.equals("New")) {
            this.course.setId(null);
            this.course.setCourse(jTextFieldCourse.getText());
            this.course.setDescription(jTextFieldDescription.getText());
            courseDAOImpl.addCourse(course, hibernateConfig.getEntityManager());
            this.dispose();
        } else if (this.title.equals("Update")) {
            this.course.setCourse(jTextFieldCourse.getText());
            this.course.setDescription(jTextFieldDescription.getText());
            courseDAOImpl.updateCourse(course, hibernateConfig.getEntityManager());
            this.dispose();
        } else if (this.title.equals("Delete")) {
            courseDAOImpl.deleteCourse(course, hibernateConfig.getEntityManager());
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldCourse;
    private javax.swing.JTextField jTextFieldDescription;
    // End of variables declaration//GEN-END:variables
}