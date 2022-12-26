import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;

public class Doctor {

    //states
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String profession;
    private static Doctor currentlyLoggedIn;

    //arraylist
    public static List<Doctor> DoctorUsernameArray = new ArrayList<Doctor>();

    //getters
    public static List<Doctor> getDoctorUsernameArray() {
        return DoctorUsernameArray;
    }
    public static String getDoctorFullName(List<Appointment> AppointmentsArray, int i){
        for (int j = 0; j < DoctorUsernameArray.size(); j++) {
            if(DoctorUsernameArray.get(j).get("username").equals(AppointmentsArray.get(i).get("doctorUsername"))){
                return "Dr. " + DoctorUsernameArray.get(j).get("firstName") + " " + DoctorUsernameArray.get(j).get("lastName");
            }
        }
        return "Error";
    }
    public static String getDoctorProfession(List<Appointment> AppointmentsArray, int i){
        for (int j = 0; j < DoctorUsernameArray.size(); j++) {
            if(DoctorUsernameArray.get(j).get("username").equals(AppointmentsArray.get(i).get("doctorUsername"))){
                return DoctorUsernameArray.get(j).get("profession");
            }
        }
        return "Error";
    }
    public String get(String field){
        if(field.equals("username")){
            return username;
        }
        if(field.equals("password")){
            return password;
        }
        if(field.equals("firstName")){
            return firstName;
        }
        if(field.equals("lastName")){
            return lastName;
        }
        if(field.equals("profession")){
            return profession;
        }
        else{
            return "Error in Get Method";
        }
    }

    //setter
    public void set(String field, String set){
        if(field.equals("firstName")){
            firstName = set;
        }
        if(field.equals("lastName")){
            lastName = set;
        }
        if(field.equals("profession")){
            profession = set;
        }
        if(field.equals("profession")){
            profession = set;
        }
    }

    //Doctor constructor
    public Doctor(String username, String password){
        this.username = username;
        this.password = password;
    }

    //initializing pre-defined doctors (called from Main)
    public static void initializeDoctors(List<Doctor> DoctorUsernameArray){
        //Pre-defined Doctor Username and Passwords
        String[] doctorUsernames = {"Pepe", "Jonah", "LeBron","Stephen", "Sharon", "Chris", "Mikasa", "Jimmy", "Lonahld"};
        String[] doctorPasswords = {"Smith","Wall", "James", "Curry", "Cuneta", "Paul", "Ackerman", "Neutron", "Blanilo"};

        for(int i = 0; i < doctorUsernames.length; i++){
            Doctor doctor = new Doctor(doctorUsernames[i], doctorPasswords[i]);
            DoctorUsernameArray.add(doctor);

            //Pre-defined Doctor Details
            if(DoctorUsernameArray.get(i).get("username").equals("Pepe")) {
                Doctor.setDoctorDetails(DoctorUsernameArray, "firstName", "Pepe");
                Doctor.setDoctorDetails(DoctorUsernameArray, "lastName", "Smith");
                Doctor.setDoctorDetails(DoctorUsernameArray, "profession", "Primary Care Doctor");
            }
            if(DoctorUsernameArray.get(i).get("username").equals("Jonah")) {
                Doctor.setDoctorDetails(DoctorUsernameArray, "firstName", "Jonah");
                Doctor.setDoctorDetails(DoctorUsernameArray, "lastName", "Wall");
                Doctor.setDoctorDetails(DoctorUsernameArray, "profession", "Gynecology");
            }
            if(DoctorUsernameArray.get(i).get("username").equals("LeBron")) {
                Doctor.setDoctorDetails(DoctorUsernameArray, "firstName", "LeBron");
                Doctor.setDoctorDetails(DoctorUsernameArray, "lastName", "James");
                Doctor.setDoctorDetails(DoctorUsernameArray, "profession", "Cardiology");
            }
            if(DoctorUsernameArray.get(i).get("username").equals("Stephen")) {
                Doctor.setDoctorDetails(DoctorUsernameArray, "firstName", "Stephen");
                Doctor.setDoctorDetails(DoctorUsernameArray, "lastName", "Curry");
                Doctor.setDoctorDetails(DoctorUsernameArray, "profession", "Dermatology");

            }
            if(DoctorUsernameArray.get(i).get("username").equals("Sharon")) {
                Doctor.setDoctorDetails(DoctorUsernameArray, "firstName", "Sharon");
                Doctor.setDoctorDetails(DoctorUsernameArray, "lastName", "Cuneta");
                Doctor.setDoctorDetails(DoctorUsernameArray, "profession", "Pediatrics");
            }
            if(DoctorUsernameArray.get(i).get("username").equals("Chris")) {
                Doctor.setDoctorDetails(DoctorUsernameArray, "firstName", "Chris");
                Doctor.setDoctorDetails(DoctorUsernameArray, "lastName", "Paul");
                Doctor.setDoctorDetails(DoctorUsernameArray, "profession", "Ophthalmologist");
            }
            if(DoctorUsernameArray.get(i).get("username").equals("Mikasa")) {
                Doctor.setDoctorDetails(DoctorUsernameArray, "firstName", "Mikasa");
                Doctor.setDoctorDetails(DoctorUsernameArray, "lastName", "Ackerman");
                Doctor.setDoctorDetails(DoctorUsernameArray, "profession", "Otorhinolaryngology");
            }
            if(DoctorUsernameArray.get(i).get("username").equals("Jimmy")) {
                Doctor.setDoctorDetails(DoctorUsernameArray, "firstName", "Jimmy");
                Doctor.setDoctorDetails(DoctorUsernameArray, "lastName", "Neutron");
                Doctor.setDoctorDetails(DoctorUsernameArray, "profession", "Neurology");
            }
            if(DoctorUsernameArray.get(i).get("username").equals("Lonahld")) {
                Doctor.setDoctorDetails(DoctorUsernameArray, "firstName", "Lonahld");
                Doctor.setDoctorDetails(DoctorUsernameArray, "lastName", "Blanilo");
                Doctor.setDoctorDetails(DoctorUsernameArray, "profession", "Urology");
                           }
        }
    }

    //method for doctorLogin
    public static boolean doctorLogin(List<Doctor> DoctorUsernameArray, String doctorUsernameLogin, String doctorPasswordLogin){
        if (DoctorUsernameArray.size() != 0) {
            for (int i = 0; i < DoctorUsernameArray.size(); i++) {
                if (DoctorUsernameArray.get(i).get("username").equals(doctorUsernameLogin) && DoctorUsernameArray.get(i).get("password").equals(doctorPasswordLogin)) {
                    currentlyLoggedIn = DoctorUsernameArray.get(i);
                    return true;
                }
            }
        }
        return false;
    }

    //method to set doctor details
    public static void setDoctorDetails(List<Doctor> DoctorUsernameArray, String field, String input) {
        DoctorUsernameArray.get(DoctorUsernameArray.size()-1).set(field, input);
    }

    // --------- DOCTOR GUI ----------

    public static class DoctorLogin {
        private JLabel labelUsername, labelPassword,labelFrame;
        private JTextField textUsername;
        private JPasswordField textPassword;
        private JButton buttonLogin, buttonBack;
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        public DoctorLogin() {
            Border MainJFrameBorder = BorderFactory.createLineBorder(Color.white,3);
            panel.setBorder(MainJFrameBorder);
            frame.setResizable(false);
            frame.setSize(450,250);
            frame.setTitle("Doctor's Login");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            panel.setBackground(new Color(0x1261A0));
            panel.setLayout(null);

            labelFrame = new JLabel("Doctor's Login");
            labelFrame.setForeground(Color.WHITE);
            labelFrame.setFont(new Font("Gulim",Font.BOLD,18));
            labelFrame.setBounds(150,25,220,25);
            panel.add(labelFrame);

            labelUsername = new JLabel("Username");
            labelUsername.setBounds(85,65,80,25);
            labelUsername.setFont(new Font("Gulim",Font.PLAIN,15));
            labelUsername.setForeground(Color.WHITE);
            panel.add(labelUsername);

            textUsername = new JTextField();
            textUsername.setBounds(180,65,165,25);
            textUsername.setFont(new Font("Gulim",Font.PLAIN,12));
            panel.add(textUsername);

            labelPassword = new JLabel("Password");
            labelPassword.setBounds(85,95,80,25);
            labelPassword.setFont(new Font("Gulim",Font.PLAIN,15));
            labelPassword.setForeground(Color.WHITE);
            panel.add(labelPassword);

            textPassword = new JPasswordField();
            textPassword.setBounds(180,95,165,25);
            textPassword.setFont(new Font("Gulim",Font.PLAIN,12));
            panel.add(textPassword);

            buttonBack = new JButton("Back");
            buttonBack.setBounds(95,140,120,25);
            buttonBack.setFont(new Font("Gulim",Font.BOLD,12));
            buttonBack.setForeground(Color.WHITE);
            buttonBack.setBackground(new Color(0x072F5F));
            buttonBack.addActionListener(new buttonBack());
            panel.add(buttonBack);

            buttonLogin = new JButton("Login");
            buttonLogin.setBounds(220,140,120,25);
            buttonLogin.setFont(new Font("Gulim",Font.BOLD,12));
            buttonLogin.setForeground(Color.WHITE);
            buttonLogin.setBackground(new Color(0x072F5F));
            buttonLogin.addActionListener(new buttonLogin());
            panel.add(buttonLogin);

            frame.setVisible(true);
            Main.startInCenter(frame);
        }

        private class buttonBack implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main.MainJFrame();
                frame.dispose();
            }
        }

        private class buttonLogin implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String doctorUsernameLogin = textUsername.getText();
                String doctorPasswordLogin = new String(textPassword.getPassword());
                if(doctorLogin(Doctor.getDoctorUsernameArray(), doctorUsernameLogin, doctorPasswordLogin)){
                    new DoctorMainMenu();
                    frame.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Account doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static class DoctorMainMenu {
        private JButton buttonPastApp, buttonSeeApp, buttonLogout;
        private JLabel labelHeader, labelDoctorName, labelQuestion, labelSeeAppointmentIcon, labelSeePastAppointmentsIcon;

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        public DoctorMainMenu(){
            Border MainJFrameBorder = BorderFactory.createLineBorder(Color.white,3);
            panel.setBorder(MainJFrameBorder);

            frame.setResizable(false);
            frame.setSize(520,350);
            frame.setTitle("Doctor's Main Menu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            panel.setBackground(new Color(0x1261A0));
            panel.setLayout(null);

            labelHeader = new JLabel("Hello ");
            labelHeader.setBounds(10,30,180,30);
            labelHeader.setFont(new Font("Lucida Calligraphy",Font.PLAIN, 27));
            labelHeader.setForeground(Color.WHITE);
            panel.add(labelHeader);

            labelDoctorName = new JLabel("Dr. " + currentlyLoggedIn.get("lastName") + ",");
            labelDoctorName.setBounds(95,36,1000,25);
            labelDoctorName.setFont(new Font("Garamond",Font.PLAIN, 22));
            labelDoctorName.setForeground(Color.WHITE);
            panel.add(labelDoctorName);

            labelQuestion = new JLabel("How can I help you?");
            labelQuestion.setBounds(180,80,165,25);
            labelQuestion.setFont(new Font("Lucida Calligraphy",Font.PLAIN,15));
            labelQuestion.setForeground(Color.WHITE);
            panel.add(labelQuestion);

            ImageIcon seeAppointmentIcon = new ImageIcon(getClass().getResource("images\\seeCurrentAppointment.png"));
            labelSeeAppointmentIcon = new JLabel(seeAppointmentIcon);
            labelSeeAppointmentIcon.setBounds(160, 140, 45, 45);
            panel.add(labelSeeAppointmentIcon);

            buttonSeeApp = new JButton("See Appointment");
            buttonSeeApp.setBounds(210,150,140,25);
            buttonSeeApp.setFont(new Font("Arial",Font.PLAIN,12));
            buttonSeeApp.setOpaque(false);
            buttonSeeApp.setContentAreaFilled(false);
            buttonSeeApp.setForeground(Color.WHITE);
            buttonSeeApp.setFocusable(false);
            Border borderSeeAppointmentButton = BorderFactory.createLineBorder(Color.white ,1);
            buttonSeeApp.setBorder(borderSeeAppointmentButton);
            buttonSeeApp.setBackground(new Color(0x072F5F));
            buttonSeeApp.addActionListener(new seeAppointments());
            panel.add(buttonSeeApp);

            ImageIcon seePastAppointmentsIcon = new ImageIcon(getClass().getResource("images\\seePatientRecords.png"));
            labelSeePastAppointmentsIcon = new JLabel(seePastAppointmentsIcon);
            labelSeePastAppointmentsIcon.setBounds(160, 210, 45, 45);
            panel.add(labelSeePastAppointmentsIcon);

            buttonPastApp = new JButton("See Past Appointments");
            buttonPastApp.setBounds(210,220,165,25);
            buttonPastApp.setFont(new Font("Arial",Font.PLAIN,12));
            buttonPastApp.setOpaque(false);
            buttonPastApp.setContentAreaFilled(false);
            buttonPastApp.setForeground(Color.WHITE);
            buttonPastApp.setFocusable(false);
            Border borderSeePastAppointmentsButton = BorderFactory.createLineBorder(Color.white ,1);
            buttonPastApp.setBorder(borderSeePastAppointmentsButton);
            buttonPastApp.setBackground(new Color(0x072F5F));
            buttonPastApp.addActionListener(new seePastAppointments());
            panel.add(buttonPastApp);

            buttonLogout = new JButton("LOGOUT");
            buttonLogout.setBounds(400,10,90,20);
            buttonLogout.setFont(new Font("Arial",Font.PLAIN,15));
            buttonLogout.setForeground(Color.WHITE);
            buttonLogout.setFocusable(false);
            Border borderLogoutButton = BorderFactory.createLineBorder(Color.white ,1);
            buttonLogout.setBorder(borderLogoutButton);
            buttonLogout.setBackground(new Color(0x072F5F));
            buttonLogout.addActionListener(new buttonLogout());
            panel.add(buttonLogout);

            frame.setVisible(true);
            Main.startInCenter(frame);
        }

        private class seeAppointments implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                new SeeAppointments(Appointment.getAppointmentArray(), currentlyLoggedIn);
                frame.dispose();
            }
        }

        private class seePastAppointments implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                new SeePastAppointments(Appointment.getAppointmentArray(), currentlyLoggedIn);
                frame.dispose();
            }
        }

        private class buttonLogout implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main.MainJFrame();
                frame.dispose();
            }
        }
    }

    public static class SeeAppointments {
        private JLabel labelMainBackground, labelContainer;
        private JButton buttonBack;
        private JScrollPane scrollPane;

        JFrame frame = new JFrame();
        JPanel ContainerPanel = new JPanel();

        public SeeAppointments(List<Appointment> AppointmentsArray, Doctor currentlyLoggedIn) {
            frame.setResizable(false);
            frame.setSize(1350,830);
            frame.setTitle("Doctor's See Appointments");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ImageIcon labelMainBackgroundImage = new ImageIcon(getClass().getResource("/images/SeePastAppointments/seeAppointmentsMainBackground.png"));
            labelMainBackground = new JLabel(labelMainBackgroundImage);
            labelMainBackground.setBounds(0,0,1350,830);

            ImageIcon buttonBackImage = new ImageIcon(getClass().getResource("/images/SeePastAppointments/backButton.png"));
            buttonBack = new JButton(buttonBackImage);
            buttonBack.setBounds(15,10,79,51);
            buttonBack.setFocusable(false);
            buttonBack.setBackground(new Color(0x3895d3));

            boolean noAppointment = true;
            for (int i = 0; i < AppointmentsArray.size(); i++) {
                if(AppointmentsArray.get(i).get("doctorUsername").equals(currentlyLoggedIn.get("username")) && !AppointmentsArray.get(i).isDone()){
                    ContainerPanel.setBounds(90,100,1150,650);
                    ContainerPanel.setBackground(new Color(0x3896cf));
                    ContainerPanel.setLayout(new BoxLayout(ContainerPanel, BoxLayout.PAGE_AXIS));
                    ContainerPanel.add(Box.createRigidArea(new Dimension(0,30)));
                    ImageIcon container = new ImageIcon(getClass().getResource("/images/SeePastAppointments/panel.png"));
                    labelContainer = new JLabel(container);
                    labelMainBackground.add(ContainerPanel);
                    ContainerPanel.add(labelContainer);

                    JLabel DateNTime = new JLabel(AppointmentsArray.get(i).get("dateAndTime"));
                    DateNTime.setFont(new Font("Gulim",Font.PLAIN, 20));
                    DateNTime.setForeground(Color.WHITE);
                    DateNTime.setBounds(15,30,500,40);
                    JLabel PatientName = new JLabel(Patient.getPatientFullName(Appointment.getAppointmentArray(), i));
                    PatientName.setFont(new Font("Gulim",Font.PLAIN, 20));
                    PatientName.setForeground(Color.WHITE);
                    PatientName.setBounds(15,65,500,40);
                    labelContainer.add(DateNTime);
                    labelContainer.add(PatientName);

                    ImageIcon appointButtonIcon = new ImageIcon(getClass().getResource("/images/SeePastAppointments/seeAppointmentButton.png"));
                    JButton AppointmentButton = new JButton(appointButtonIcon);
                    AppointmentButton.setBounds(830,35,283,63);
                    AppointmentButton.setFocusable(false);
                    labelContainer.add(AppointmentButton);

                    int j = i;
                    AppointmentButton.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            new SeeAppointmentDetails(AppointmentsArray, j);
                            frame.dispose();
                        }
                    });

                    scrollPane = new JScrollPane(ContainerPanel);
                    scrollPane.setBounds(55,100,1230,660);
                    scrollPane.setBackground(new Color(0x3896cf));

                    noAppointment = false;
                }
            }
            if(noAppointment){
                ImageIcon labelMainBackgroundIconNone = new ImageIcon(getClass().getResource("/images/SeePastAppointments/seeAppointmentsMainBackgroundNone.png"));
                labelMainBackground.setIcon(labelMainBackgroundIconNone);
            }
            else{
                frame.add(scrollPane);
            }
            frame.add(buttonBack);
            frame.add(labelMainBackground);
            frame.setVisible(true);

            buttonBack.addActionListener(new buttonBack());
            Main.startInCenter(frame);
        }
        private class buttonBack implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoctorMainMenu();
                frame.dispose();
            }
        }
    }

    public static class SeePastAppointments {
        private JLabel labelMainBackground, labelContainer;
        private JButton buttonBack;
        private JScrollPane scrollPane;

        JFrame frame = new JFrame();
        JPanel ContainerPanel = new JPanel();

        public SeePastAppointments(List<Appointment> AppointmentsArray, Doctor currentlyLoggedIn) {
            frame.setResizable(false);
            frame.setSize(1350,830);
            frame.setTitle("Doctor's See Past Appointments");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ImageIcon labelMainBackgroundImage = new ImageIcon(getClass().getResource("/images/SeePastAppointments/seeAppointmentsMainBackground.png"));
            labelMainBackground = new JLabel(labelMainBackgroundImage);
            labelMainBackground.setBounds(0,0,1350,830);

            ImageIcon buttonBackImage = new ImageIcon(getClass().getResource("/images/SeePastAppointments/backButton.png"));
            buttonBack = new JButton(buttonBackImage);
            buttonBack.setBounds(15,10,79,51);
            buttonBack.setFocusable(false);
            buttonBack.setBackground(new Color(0x3895d3));

            boolean noAppointment = true;
            for (int i = 0; i < AppointmentsArray.size(); i++) {
                if(AppointmentsArray.get(i).get("doctorUsername").equals(currentlyLoggedIn.get("username")) && AppointmentsArray.get(i).isDone()){
                    ContainerPanel.setBounds(90,100,1150,650);
                    ContainerPanel.setBackground(new Color(0x3896cf));
                    ContainerPanel.setLayout(new BoxLayout(ContainerPanel, BoxLayout.PAGE_AXIS));
                    ContainerPanel.add(Box.createRigidArea(new Dimension(0,30)));
                    ImageIcon container = new ImageIcon(getClass().getResource("/images/SeePastAppointments/panel.png"));
                    labelContainer = new JLabel(container);
                    labelMainBackground.add(ContainerPanel);
                    ContainerPanel.add(labelContainer);

                    JLabel DateNTime = new JLabel(AppointmentsArray.get(i).get("dateAndTime"));
                    DateNTime.setFont(new Font("Gulim",Font.PLAIN, 20));
                    DateNTime.setForeground(Color.WHITE);
                    DateNTime.setBounds(15,30,500,40);
                    JLabel PatientName = new JLabel(Patient.getPatientFullName(Appointment.getAppointmentArray(), i));
                    PatientName.setFont(new Font("Gulim",Font.PLAIN, 20));
                    PatientName.setForeground(Color.WHITE);
                    PatientName.setBounds(15,65,500,40);
                    labelContainer.add(DateNTime);
                    labelContainer.add(PatientName);

                    ImageIcon appointButtonIcon = new ImageIcon(getClass().getResource("/images/SeePastAppointments/seeAppointmentButton.png"));
                    JButton AppointmentButton = new JButton(appointButtonIcon);
                    AppointmentButton.setBounds(830,35,283,63);
                    AppointmentButton.setFocusable(false);
                    labelContainer.add(AppointmentButton);

                    int j = i;
                    AppointmentButton.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            new SeeAppointmentDetails(AppointmentsArray, j);
                            frame.dispose();
                        }
                    });

                    scrollPane = new JScrollPane(ContainerPanel);
                    scrollPane.setBounds(55,100,1230,660);
                    scrollPane.setBackground(new Color(0x3896cf));

                    noAppointment = false;
                }
            }
            if(noAppointment){
                ImageIcon labelMainBackgroundIconNone = new ImageIcon(getClass().getResource("/images/SeePastAppointments/seeAppointmentsMainBackgroundNone.png"));
                labelMainBackground.setIcon(labelMainBackgroundIconNone);
            }
            else{
                frame.add(scrollPane);
            }
            frame.add(buttonBack);
            frame.add(labelMainBackground);
            frame.setVisible(true);

            buttonBack.addActionListener(new buttonBack());
            Main.startInCenter(frame);
        }
        private class buttonBack implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoctorMainMenu();
                frame.dispose();
            }
        }
    }

    public static class SeeAppointmentDetails {

        JFrame frame = new JFrame();

        private JLabel labelMainBackground;
        private JLabel labelPatientName, labelHeight, labelWeight, labelDoctorName, labelAge, labelSex, labelDateAndTime, labelContactNumber;
        private JTextArea textAreaDoctorsComments;
        private JButton buttonBack, buttonSubmit;
        private JScrollPane scrollPane;

        public SeeAppointmentDetails(List<Appointment> AppointmentArray, int j) {
            frame.setResizable(false);
            frame.setSize(1350,830);
            frame.setTitle("Doctor's See Appointment Details");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);

            ImageIcon MainBackground = new ImageIcon(getClass().getResource("/images/SeeAppointmentDetails/seeAppointmentDetailsBackground.png"));
            labelMainBackground = new JLabel(MainBackground);
            labelMainBackground.setBounds(0,0,1350,830);
            frame.add(labelMainBackground);

            ImageIcon BackIcon = new ImageIcon(getClass().getResource("/images/seePastAppointments/backButton.png"));
            buttonBack = new JButton(BackIcon);
            buttonBack.setBounds(15,10,79,51);
            buttonBack.setBackground(new Color(0x3895d3));
            buttonBack.addActionListener(new backButton());
            labelMainBackground.add(buttonBack);

            labelPatientName = new JLabel("");
            labelPatientName.setFont(new Font("Gulim",Font.PLAIN,25));
            labelPatientName.setBounds(320,167,300,50);
            labelPatientName.setForeground(Color.WHITE);
            labelPatientName.setText(Patient.getPatientFullName(AppointmentArray, j));
            labelMainBackground.add(labelPatientName);

            labelHeight = new JLabel("");
            labelHeight.setFont(new Font("Gulim",Font.PLAIN,25));
            labelHeight.setBounds(320,227,300,50);
            labelHeight.setForeground(Color.WHITE);
            labelHeight.setText(Patient.getPatientDetails(Appointment.getAppointmentArray(), j, "height") + " cm");
            labelMainBackground.add(labelHeight);

            labelWeight = new JLabel("");
            labelWeight.setFont(new Font("Gulim",Font.PLAIN,25));
            labelWeight.setBounds(320,282,300,50);
            labelWeight.setForeground(Color.WHITE);
            labelWeight.setText(Patient.getPatientDetails(Appointment.getAppointmentArray(), j, "weight") + " kg");
            labelMainBackground.add(labelWeight);

            labelDoctorName = new JLabel("");
            labelDoctorName.setFont(new Font("Gulim",Font.PLAIN,25));
            labelDoctorName.setBounds(320,342,300,50);
            labelDoctorName.setForeground(Color.WHITE);
            labelDoctorName.setText(getDoctorFullName(AppointmentArray, j));
            labelMainBackground.add(labelDoctorName);

            labelAge = new JLabel("");
            labelAge.setFont(new Font("Gulim",Font.PLAIN,25));
            labelAge.setBounds(910,167,300,50);
            labelAge.setForeground(Color.WHITE);
            labelAge.setText(Patient.getPatientDetails(Appointment.getAppointmentArray(), j, "age"));
            labelMainBackground.add(labelAge);

            labelSex = new JLabel("");
            labelSex.setFont(new Font("Gulim",Font.PLAIN,25));
            labelSex.setBounds(910,223,300,50);
            labelSex.setForeground(Color.WHITE);
            labelSex.setText(Patient.getPatientDetails(Appointment.getAppointmentArray(), j, "sex"));
            labelMainBackground.add(labelSex);

            labelDateAndTime = new JLabel("");
            labelDateAndTime.setFont(new Font("Gulim",Font.PLAIN,25));
            labelDateAndTime.setBounds(910,342,500,50);
            labelDateAndTime.setForeground(Color.WHITE);
            labelDateAndTime.setText(AppointmentArray.get(j).get("dateAndTime"));
            labelMainBackground.add(labelDateAndTime);

            labelContactNumber = new JLabel("");
            labelContactNumber.setFont(new Font("Gulim",Font.PLAIN,25));
            labelContactNumber.setBounds(910,282,500,50);
            labelContactNumber.setForeground(Color.WHITE);
            labelContactNumber.setText(Patient.getPatientDetails(Appointment.getAppointmentArray(), j, "contactNumber"));
            labelMainBackground.add(labelContactNumber);

            textAreaDoctorsComments = new JTextArea();
            textAreaDoctorsComments.setEditable(false);
            textAreaDoctorsComments.setLineWrap(true);
            textAreaDoctorsComments.setWrapStyleWord(true);

            if(!AppointmentArray.get(j).isDone()){
                buttonSubmit = new JButton("Submit");
                buttonSubmit.setBounds(1175,750,80,35);
                buttonSubmit.setBackground(new Color(0x1b7ab9));
                buttonSubmit.setForeground(Color.WHITE);
                Border MainJFrameBorder = BorderFactory.createLineBorder(Color.white,1);
                buttonSubmit.setBorder(MainJFrameBorder);
                buttonSubmit.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Are you sure to submit comment?", "Confirm Comment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            AppointmentArray.get(j).set("doctorComments", textAreaDoctorsComments.getText());
                            AppointmentArray.get(j).setIsDone();

                            new DoctorMainMenu();
                            frame.dispose();
                        }
                    }
                });
                labelMainBackground.add(buttonSubmit);
                textAreaDoctorsComments.setEditable(true);
            }

            textAreaDoctorsComments.setFont(new Font("Gulim",Font.PLAIN,18));
            textAreaDoctorsComments.setBackground(new Color(0xd7d7d7));
            textAreaDoctorsComments.setText(AppointmentArray.get(j).get("doctorComments"));
            scrollPane = new JScrollPane(textAreaDoctorsComments, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setBounds(110,470,1130,265);
            labelMainBackground.add(scrollPane);

            frame.setVisible(true);
            Main.startInCenter(frame);
        }

        private class backButton implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoctorMainMenu();
                frame.dispose();
            }
        }
    }
}