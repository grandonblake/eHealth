import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main {

    public static void startInCenter(JFrame frame){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
    }

    //mainMenu GUI
    public static class MainJFrame {
        private JLabel labelHeader, labelHeader2, labelPatientIcon, labelDoctorIcon;
        private JButton patientButton,doctorButton;
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        public MainJFrame() {

            //Frame Border
            Border MainJFrameBorder = BorderFactory.createLineBorder(Color.white,3);
            panel.setBorder(MainJFrameBorder);

            //Frame
            frame.setSize(520, 350);
            frame.setTitle("Main Menu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            panel.setLayout(null);
            panel.setBackground(new Color(0x1261A0));
            frame.setResizable(false);

            //Header Label
            labelHeader = new JLabel("e-Health Appointment System");
            labelHeader.setBounds(110, 20, 300, 30);
            labelHeader.setFont(new Font("Century Gothic",Font.BOLD,20));
            labelHeader.setForeground(Color.WHITE);
            panel.add(labelHeader);

            labelHeader2 = new JLabel("Login as?");
            labelHeader2.setBounds(210, 50, 80, 25);
            labelHeader2.setFont(new Font("Arial",Font.PLAIN,14));
            labelHeader2.setForeground(Color.WHITE);
            panel.add(labelHeader2);

            ImageIcon patientIcon = new ImageIcon(getClass().getResource("images/patientIcon.png"));
            labelPatientIcon = new JLabel(patientIcon);
            labelPatientIcon.setBounds(183, 110, 50, 50);
            panel.add(labelPatientIcon);

            //Patient Button
            patientButton = new JButton("Patient");
            patientButton.setBounds(240, 130, 70, 25);
            patientButton.addActionListener(new PatientOption());
            patientButton.setFont(new Font("Gulim",Font.BOLD,11));
            patientButton.setForeground(Color.WHITE);
            patientButton.setOpaque(false);
            patientButton.setContentAreaFilled(false);
            patientButton.setFocusable(false);
            Border borderPatientButton = BorderFactory.createLineBorder(Color.WHITE ,1);
            patientButton.setBorder(borderPatientButton);
            panel.add(patientButton);

            ImageIcon doctorIcon = new ImageIcon(getClass().getResource("/images/doctorIcon.png"));
            labelDoctorIcon = new JLabel(doctorIcon);
            labelDoctorIcon.setBounds(188, 185, 45, 45);
            panel.add(labelDoctorIcon);

            //Doctors Button
            doctorButton = new JButton("Doctor");
            doctorButton.setFont(new Font("Gulim",Font.BOLD,11));
            doctorButton.setBounds(240, 200, 70, 25);
            doctorButton.addActionListener(new DoctorsOption());
            doctorButton.setOpaque(false);
            doctorButton.setContentAreaFilled(false);
            doctorButton.setForeground(Color.WHITE);
            doctorButton.setFocusable(false);
            Border borderDoctorButton = BorderFactory.createLineBorder(Color.WHITE ,1);
            doctorButton.setBorder(borderDoctorButton);
            panel.add(doctorButton);

            frame.setVisible(true);
            startInCenter(frame);
        }

        //Function Implementation
        class PatientOption implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e){
                new Patient.LoginPanel();
                frame.dispose();
            }
        }
        class DoctorsOption implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                new Doctor.DoctorLogin();
                frame.dispose();
            }
        }

    }

    //main method
    public static void main (String[] args) {
        Doctor.initializeDoctors(Doctor.getDoctorUsernameArray());

        new Main.MainJFrame();
    }
}