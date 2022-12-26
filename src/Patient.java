import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient {

    //states
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String age;
    private String sex;
    private String address;
    private String contactNumber;
    private String height;
    private String weight;
    private static Patient currentlyLoggedIn;

    //arraylist
    private static List<Patient> PatientUsernameArray = new ArrayList<Patient>();
    public static List<Patient> getPatientUsernameArray() {
        return PatientUsernameArray;
    }

    //getters
    public static String getPatientFullName(List<Appointment> AppointmentsArray, int i){
        for (int j = 0; j < PatientUsernameArray.size(); j++) {
            if(PatientUsernameArray.get(j).get("username").equals(AppointmentsArray.get(i).get("patientUsername"))){
                return PatientUsernameArray.get(j).get("firstName") + " " + PatientUsernameArray.get(j).get("lastName");
            }
        }
        return "Error";
    }
    public static String getPatientDetails(List<Appointment> AppointmentsArray, int i, String field){
        for (int j = 0; j < PatientUsernameArray.size(); j++) {
            if(PatientUsernameArray.get(j).get("username").equals(AppointmentsArray.get(i).get("patientUsername"))){
                if(field.equals("username")){
                    return PatientUsernameArray.get(j).get("username");
                }
                if(field.equals("password")){
                    return PatientUsernameArray.get(j).get("password");
                }
                if(field.equals("firstName")){
                    return PatientUsernameArray.get(j).get("firstName");
                }
                if(field.equals("lastName")){
                    return PatientUsernameArray.get(j).get("lastName");
                }
                if(field.equals("age")){
                    return PatientUsernameArray.get(j).get("age");
                }
                if(field.equals("sex")){
                    return PatientUsernameArray.get(j).get("sex");
                }
                if(field.equals("address")){
                    return PatientUsernameArray.get(j).get("address");
                }
                if(field.equals("contactNumber")){
                    return PatientUsernameArray.get(j).get("contactNumber");
                }
                if(field.equals("height")){
                    return PatientUsernameArray.get(j).get("height");
                }
                if(field.equals("weight")){
                    return PatientUsernameArray.get(j).get("weight");
                }
                else{
                    return "Error in Get Method";
                }
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
        if(field.equals("age")){
            return age;
        }
        if(field.equals("sex")){
            return sex;
        }
        if(field.equals("address")){
            return address;
        }
        if(field.equals("contactNumber")){
            return contactNumber;
        }
        if(field.equals("height")){
            return height;
        }
        if(field.equals("weight")){
            return weight;
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
        if(field.equals("age")){
            age = set;
        }
        if(field.equals("sex")){
            sex = set;
        }
        if(field.equals("address")){
            address = set;
        }
        if(field.equals("contactNumber")){
            contactNumber = set;
        }
        if(field.equals("height")){
            height = set;
        }
        if(field.equals("weight")){
            weight = set;
        }
    }

    //Patient constructor
    public Patient (String username, String password){
        this.username = username;
        this.password = password;
    }

    //method for registration
    public static boolean patientRegister(List<Patient> PatientUsernameArray, String patientUsernameRegister, String patientPasswordRegister){
        if(PatientUsernameArray.size() == 0){
            Patient patient = new Patient(patientUsernameRegister, patientPasswordRegister);
            PatientUsernameArray.add(patient);
            return true;
        }
        else {
            boolean noSimilarAccount = true;
            for(int i = 0; i < PatientUsernameArray.size(); i++){
                if (PatientUsernameArray.get(i).get("username").equals(patientUsernameRegister)){
                    noSimilarAccount = false;
                }
            }
            while(noSimilarAccount){
                Patient patient = new Patient(patientUsernameRegister, patientPasswordRegister);
                PatientUsernameArray.add(patient);
                noSimilarAccount = false;
                return true;
            }
        }
        return false;
    }

    //method for log-in
    public static boolean patientLogin(List<Patient> PatientUsernameArray, String patientUsernameLogin, String patientPasswordLogin){
        if (PatientUsernameArray.size() != 0) {
            for (int i = 0; i < PatientUsernameArray.size(); i++) {
                if (PatientUsernameArray.get(i).get("username").equals(patientUsernameLogin) && PatientUsernameArray.get(i).get("password").equals(patientPasswordLogin)) {
                    currentlyLoggedIn = PatientUsernameArray.get(i);
                    return true;
                }
            }
        }
        return false;
    }


    // ------------- PATIENT GUI -------------

    public static class RegisterPanel {
        private JLabel labelUsername, labelPassword, labelFrame;
        private JTextField textUsername;
        private JPasswordField textPassword;
        private JButton buttonBack, nextButton;
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        public RegisterPanel(){
            Border MainJFrameBorder = BorderFactory.createLineBorder(Color.white,3);
            frame.setResizable(false);
            frame.setSize(450,250);
            frame.setTitle("Register Patient's Account");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            panel.setBorder(MainJFrameBorder);
            panel.setBackground(new Color(0x1261A0));
            panel.setLayout(null);

            labelFrame = new JLabel("Register Patient");
            labelFrame.setForeground(Color.WHITE);
            labelFrame.setFont(new Font("Gulim", Font.BOLD,18));
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
            textUsername.getDocument().addDocumentListener(new NextButton());
            panel.add(textUsername);

            labelPassword = new JLabel("Password");
            labelPassword.setBounds(85,95,80,25);
            labelPassword.setFont(new Font("Gulim",Font.PLAIN,15));
            labelPassword.setForeground(Color.WHITE);
            panel.add(labelPassword);

            textPassword = new JPasswordField(20);
            textPassword.setBounds(180,95,165,25);
            textPassword.setFont(new Font("Gulim",Font.PLAIN,12));
            textPassword.getDocument().addDocumentListener(new NextButton());
            panel.add(textPassword);

            buttonBack = new JButton("Back");
            buttonBack.setBounds(95,140,120,25);
            buttonBack.setFont(new Font("Gulim",Font.BOLD,12));
            buttonBack.setForeground(Color.white);
            buttonBack.setBackground(new Color(0x072F5F));
            buttonBack.addActionListener(new buttonBack());
            panel.add(buttonBack);

            nextButton = new JButton("Next");
            nextButton.setBounds(220,140,120,25);
            nextButton.setFont(new Font("Gulim",Font.BOLD,12));
            nextButton.setForeground(Color.white);
            nextButton.setBackground(new Color(0x072F5F));
            nextButton.addActionListener(new NextButton());
            nextButton.setEnabled(false);
            panel.add(nextButton);

            frame.setVisible(true);
            Main.startInCenter(frame);
        }

        private class buttonBack implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e){
                new LoginPanel();
                frame.dispose();
            }
        }

        private class NextButton implements ActionListener, DocumentListener {

            @Override
            public void actionPerformed(ActionEvent e){

                String patientUsernameRegister = textUsername.getText();
                String patientPasswordRegister = new String(textPassword.getPassword());

                if ((patientUsernameRegister.length() >= 4 && patientUsernameRegister.length() <= 16) &&
                        (patientPasswordRegister.length() >= 4 && patientPasswordRegister.length() <= 16)) {

                    if(patientRegister(Patient.getPatientUsernameArray(), patientUsernameRegister, patientPasswordRegister)){
                        new PersonalInfo();
                        frame.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "Username is already taken", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {

                    if(patientUsernameRegister.length() < 4 && patientPasswordRegister.length() < 4){
                        JOptionPane.showMessageDialog(frame, "Username and Password is too short", "Username and Password Length Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(patientUsernameRegister.length() > 16  && patientPasswordRegister.length() > 16){
                        JOptionPane.showMessageDialog(frame, "Maximum Length of Username and Password is reached [max: 16]", "Username Length Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(patientUsernameRegister.length() < 4  && patientPasswordRegister.length() > 16){
                        JOptionPane.showMessageDialog(frame, "Username is too short.\nMaximum Length of Password is reached [max: 16]", "Username Length Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(patientUsernameRegister.length() > 16  && patientPasswordRegister.length() < 4){
                        JOptionPane.showMessageDialog(frame, "Maximum Length of Username is reached [max: 16]\nPassword is too short", "Username Length Error", JOptionPane.ERROR_MESSAGE);
                    }

                    else {
                        if (patientUsernameRegister.length() < 4) {
                            JOptionPane.showMessageDialog(frame, "Username is too short", "Username Length Error", JOptionPane.ERROR_MESSAGE);
                        }
                        if (patientPasswordRegister.length() < 4) {
                            JOptionPane.showMessageDialog(frame, "Password is too short", "Password Length Error", JOptionPane.ERROR_MESSAGE);
                        }
                        if (patientUsernameRegister.length() > 16) {
                            JOptionPane.showMessageDialog(frame, "Maximum Length of Username is reached [max: 16]", "Username Length Error", JOptionPane.ERROR_MESSAGE);
                        }
                        if (patientPasswordRegister.length() > 16) {
                            JOptionPane.showMessageDialog(frame, "Maximum Length of Password is reached [max: 16]", "Password Length Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                nextButton.setEnabled(!textUsername.getText().isEmpty() && !textPassword.getText().isEmpty());
            }
            public void changedUpdate(DocumentEvent e) {
                nextButton.setEnabled(!textUsername.getText().isEmpty() && !textPassword.getText().isEmpty());
            }
            public void removeUpdate(DocumentEvent e) {
                nextButton.setEnabled(!textUsername.getText().isEmpty() && !textPassword.getText().isEmpty());
            }
        }
    }

    public static class PersonalInfo{
        private JLabel firstNameLabel,lastNameLabel,labelSex,labelAge,labelWeight,labelHeight,homeAddressLabel,labelContactNumber;
        private JTextField firstNameText,lastNameText,weightText,heightText,homeAddressText,contactNumberText;
        private JButton buttonBack, submitButton;
        JComboBox Age;
        JComboBox Sex;
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        public PersonalInfo(){
            Border MainJFrameBorder = BorderFactory.createLineBorder(Color.white,3);
            panel.setBorder(MainJFrameBorder);

            frame.setResizable(false);
            frame.setSize(700,250);
            frame.setTitle("Patient's Personal Information");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(panel);
            panel.setBackground(new Color(0x1261A0));
            panel.setLayout(null);

            firstNameLabel = new JLabel("First Name");
            firstNameLabel.setBounds(10,20,100,25);
            firstNameLabel.setFont(new Font("Gulim",Font.BOLD,15));
            firstNameLabel.setForeground(Color.white);
            panel.add(firstNameLabel);

            firstNameText = new JTextField(20);
            firstNameText.setBounds(130,20,165,25);
            firstNameText.setFont(new Font("Gulim",Font.BOLD,12));
            firstNameText.getDocument().addDocumentListener(new SubmitButton());
            panel.add(firstNameText);

            lastNameLabel = new JLabel("Last Name");
            lastNameLabel.setBounds(325,20,100,25);
            lastNameLabel.setFont(new Font("Gulim",Font.BOLD,15));
            lastNameLabel.setForeground(Color.white);
            panel.add(lastNameLabel);

            lastNameText = new JTextField(20);
            lastNameText.setBounds(455,20,165,25);
            lastNameText.setFont(new Font("Gulim",Font.BOLD,12));
            lastNameText.getDocument().addDocumentListener(new SubmitButton());
            panel.add(lastNameText);

            labelSex = new JLabel("Sex");
            labelSex.setBounds(10,50,100,25);
            labelSex.setFont(new Font("Gulim",Font.BOLD,15));
            labelSex.setForeground(Color.white);
            panel.add(labelSex);

            String[] Sexes = {"","Male", "Female"};
            Sex = new JComboBox(Sexes);
            Sex.setBounds(130,50,165,25);
            Sex.setFont(new Font("Gulim",Font.BOLD,12));
            ((JTextField)Sex.getEditor().getEditorComponent()).getDocument().addDocumentListener(new SubmitButton());
            panel.add(Sex);

            labelAge = new JLabel("Age");
            labelAge.setBounds(325,50,100,25);
            labelAge.setFont(new Font("Gulim",Font.BOLD,15));
            labelAge.setForeground(Color.white);
            panel.add(labelAge);

            String[] Ages = {"","17 Below","18", "19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","41", "42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68", "69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","91","92","93","94","95","96","97","98","99","100"};
            Age = new JComboBox(Ages);
            Age.setBounds(455,50,165,25);
            Age.setFont(new Font("Gulim",Font.BOLD,12));
            ((JTextField)Age.getEditor().getEditorComponent()).getDocument().addDocumentListener(new SubmitButton());
            panel.add(Age);

            labelWeight = new JLabel("Weight (kg)");
            labelWeight.setBounds(10,80,100,25);
            labelWeight.setFont(new Font("Gulim",Font.BOLD,15));
            labelWeight.setForeground(Color.white);
            panel.add(labelWeight);

            weightText = new JTextField(20);
            weightText.setBounds(130,80,165,25);
            weightText.setFont(new Font("Gulim",Font.BOLD,12));
            weightText.getDocument().addDocumentListener(new SubmitButton());
            panel.add(weightText);

            labelHeight = new JLabel("Height (cm)");
            labelHeight.setBounds(325,80,100,25);
            labelHeight.setFont(new Font("Gulim",Font.BOLD,15));
            labelHeight.setForeground(Color.white);
            panel.add(labelHeight);

            heightText = new JTextField(20);
            heightText.setBounds(455, 80, 165, 25);
            heightText.setFont(new Font("Gulim",Font.BOLD,12));
            heightText.getDocument().addDocumentListener(new SubmitButton());
            panel.add(heightText);

            homeAddressLabel = new JLabel("Home Address");
            homeAddressLabel.setBounds(10,140,100,25);
            homeAddressLabel.setFont(new Font("Gulim",Font.BOLD,13));
            homeAddressLabel.setForeground(Color.white);
            panel.add(homeAddressLabel);

            homeAddressText = new JTextField(20);
            homeAddressText.setBounds(130, 140, 490, 25);
            homeAddressText.setFont(new Font("Gulim",Font.BOLD,12));
            homeAddressText.getDocument().addDocumentListener(new SubmitButton());
            panel.add(homeAddressText);

            labelContactNumber = new JLabel("Contact Number");
            labelContactNumber.setBounds(10,110,150,25);
            labelContactNumber.setFont(new Font("Gulim",Font.BOLD,13));
            labelContactNumber.setForeground(Color.white);
            panel.add(labelContactNumber);

            contactNumberText = new JTextField(20);
            contactNumberText.setBounds(130, 110, 165, 25);
            contactNumberText.setFont(new Font("Gulim",Font.BOLD,12));
            contactNumberText.getDocument().addDocumentListener(new SubmitButton());
            panel.add(contactNumberText);

            buttonBack = new JButton("Back");
            buttonBack.setBounds(250,180,80,25);
            buttonBack.addActionListener(new buttonBack());
            buttonBack.setFont(new Font("Gulim",Font.BOLD,12));
            buttonBack.setBackground(new Color(0x072F5F));
            buttonBack.setForeground(Color.WHITE);
            panel.add(buttonBack);

            submitButton = new JButton("Submit");
            submitButton.setBounds(350,180,80,25);
            submitButton.addActionListener(new SubmitButton());
            submitButton.setFont(new Font("Gulim",Font.BOLD,12));
            submitButton.setBackground(new Color(0x072F5F));
            submitButton.setForeground(Color.WHITE);
            submitButton.setEnabled(false);
            panel.add(submitButton);

            frame.setVisible(true);
            Main.startInCenter(frame);
        }

        private class buttonBack implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                PatientUsernameArray.remove(PatientUsernameArray.size() - 1);
                new RegisterPanel();
                frame.dispose();
            }
        }

        private class SubmitButton implements ActionListener, DocumentListener {

            @Override
            public void actionPerformed(ActionEvent e){

                try {
                    String patientContactNumber = contactNumberText.getText();
                    float patientHeight = Float.parseFloat(heightText.getText());
                    float patientWeight = Float.parseFloat(weightText.getText());

                    if (patientContactNumber.length() != 11 && !(patientWeight >= 0 && patientWeight <= 750) && !(patientHeight >= 0 && patientHeight <= 300)) {
                        JOptionPane.showMessageDialog(frame, "Contact Number should contain 11 characters\nInvalid Weight: *[0 - 750]kg\nInvalid Height: *[0 - 300]cm", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } else if (patientContactNumber.length() != 11 && !(patientWeight >= 0 && patientWeight <= 750)) {
                        JOptionPane.showMessageDialog(frame, "Contact Number should contain 11 characters\nInvalid Weight: *[0 - 750]kg", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } else if (patientContactNumber.length() != 11 && !(patientHeight >= 0 && patientHeight <= 300)) {
                        JOptionPane.showMessageDialog(frame, "Contact Number should contain 11 characters\nInvalid Height: *[0 - 300]cm", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!(patientWeight >= 0 && patientWeight <= 750) && !(patientHeight >= 0 && patientHeight <= 300)) {
                        JOptionPane.showMessageDialog(frame, "Invalid Height: *[0 - 300]cm\nInvalid Weight: *[0 - 750]kg", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } else if (patientContactNumber.length() != 11) {
                        JOptionPane.showMessageDialog(frame, "Contact Number should contain 11 characters", "Contact Number is Invalid", JOptionPane.ERROR_MESSAGE);
                    } else if (!(patientWeight >= 0 && patientWeight <= 750)) {
                        JOptionPane.showMessageDialog(frame, "Invalid Weight: *[0 - 750]kg", "Invalid Weight Entered", JOptionPane.ERROR_MESSAGE);
                    } else if (!(patientHeight >= 0 && patientHeight <= 300)) {
                        JOptionPane.showMessageDialog(frame, "Invalid Height: *[0 - 300]cm", "Invalid Height Entered", JOptionPane.ERROR_MESSAGE);
                    } else {
                        PatientUsernameArray.get(PatientUsernameArray.size() - 1).set("firstName", firstNameText.getText().trim());
                        PatientUsernameArray.get(PatientUsernameArray.size() - 1).set("lastName", lastNameText.getText().trim());
                        PatientUsernameArray.get(PatientUsernameArray.size() - 1).set("age", (String) Age.getSelectedItem());
                        PatientUsernameArray.get(PatientUsernameArray.size() - 1).set("sex", (String) Sex.getSelectedItem());
                        PatientUsernameArray.get(PatientUsernameArray.size() - 1).set("weight", weightText.getText().trim());
                        PatientUsernameArray.get(PatientUsernameArray.size() - 1).set("height", heightText.getText().trim());
                        PatientUsernameArray.get(PatientUsernameArray.size() - 1).set("contactNumber", contactNumberText.getText().trim());
                        PatientUsernameArray.get(PatientUsernameArray.size() - 1).set("address", homeAddressText.getText().trim());
                        new LoginPanel();
                        frame.dispose();
                    }
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Height or Weight should be in Digits", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                submitButton.setEnabled(!firstNameText.getText().isEmpty() && !lastNameText.getText().isEmpty() && !Objects.equals(Age.getSelectedItem(), "") && !Objects.equals(Sex.getSelectedItem(), "") && !weightText.getText().isEmpty() && !heightText.getText().isEmpty() && !contactNumberText.getText().isEmpty() && !homeAddressText.getText().isEmpty());
            }
            public void changedUpdate(DocumentEvent e) {
                submitButton.setEnabled(!firstNameText.getText().isEmpty() && !lastNameText.getText().isEmpty() && !Objects.equals(Age.getSelectedItem(), "") && !Objects.equals(Sex.getSelectedItem(), "") && !weightText.getText().isEmpty() && !heightText.getText().isEmpty() && !contactNumberText.getText().isEmpty() && !homeAddressText.getText().isEmpty());
            }
            public void removeUpdate(DocumentEvent e) {
                submitButton.setEnabled(!firstNameText.getText().isEmpty() && !lastNameText.getText().isEmpty() && !Objects.equals(Age.getSelectedItem(), "") && !Objects.equals(Sex.getSelectedItem(), "") && !weightText.getText().isEmpty() && !heightText.getText().isEmpty() && !contactNumberText.getText().isEmpty() && !homeAddressText.getText().isEmpty());
            }
        }
    }

    public static class LoginPanel extends JFrame {
        private JLabel labelUsername, labelPassword, labelFrame;
        private JTextField textUsername;
        private JPasswordField textPassword;
        private JButton buttonLogin, buttonRegister, buttonBack;
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        public LoginPanel(){
            Border MainJFrameBorder = BorderFactory.createLineBorder(Color.white,3);
            panel.setBorder(MainJFrameBorder);
            frame.setResizable(false);
            frame.setSize(450,250);
            frame.setTitle("Patient's Login");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            panel.setBackground(new Color(0x1261A0));
            panel.setLayout(null);

            labelFrame = new JLabel("Patient's Login");
            labelFrame.setForeground(Color.WHITE);
            labelFrame.setFont(new Font("Gulim", Font.BOLD,18));
            labelFrame.setBounds(150,25,220,25);
            panel.add(labelFrame);

            labelUsername = new JLabel("Username");
            labelUsername.setBounds(85,65,80,25);
            labelUsername.setFont(new Font("Gulim", Font.PLAIN,15));
            labelUsername.setForeground(Color.WHITE);
            panel.add(labelUsername);

            textUsername = new JTextField();
            textUsername.setBounds(180,65,165,25);
            textUsername.setFont(new Font("Gulim", Font.PLAIN,12));
            textUsername.getDocument().addDocumentListener(new ButtonLogin());
            panel.add(textUsername);

            labelPassword = new JLabel("Password");
            labelPassword.setBounds(85,95,80,25);
            labelPassword.setFont(new Font("Gulim", Font.PLAIN,15));
            labelPassword.setForeground(Color.WHITE);
            panel.add(labelPassword);

            textPassword = new JPasswordField();
            textPassword.setBounds(180,95,165,25);
            textPassword.setFont(new Font("Gulim",Font.PLAIN,12));
            textPassword.getDocument().addDocumentListener(new ButtonLogin());
            panel.add(textPassword);

            buttonBack = new JButton("Back");
            buttonBack.setBounds(95,140,120,25);
            buttonBack.setFont(new Font("Gulim",Font.BOLD,12));
            buttonBack.setBackground(new Color(0x072F5F));
            buttonBack.setForeground(Color.WHITE);
            buttonBack.addActionListener(new buttonBack());
            panel.add(buttonBack);

            buttonRegister = new JButton("Register");
            buttonRegister.setBounds(155,170,120,25);
            buttonRegister.setFont(new Font("Gulim",Font.BOLD,12));
            buttonRegister.setBackground(new Color(0x072F5F));
            buttonRegister.setForeground(Color.WHITE);
            buttonRegister.addActionListener(new buttonRegister());
            panel.add(buttonRegister);

            buttonLogin = new JButton("Login");
            buttonLogin.setBounds(220,140,120,25);
            buttonLogin.setFont(new Font("Gulim",Font.BOLD,12));
            buttonLogin.setForeground(Color.WHITE);
            buttonLogin.setBackground(new Color(0x072F5F));
            buttonLogin.addActionListener(new ButtonLogin());
            buttonLogin.setEnabled(false);
            panel.add(buttonLogin);

            frame.setVisible(true);
            Main.startInCenter(frame);
        }

        private class buttonBack implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e){
                new Main.MainJFrame();
                frame.dispose();
            }
        }

        private class buttonRegister implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                new RegisterPanel();
                frame.dispose();
            }
        }

        private class ButtonLogin implements ActionListener, DocumentListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientUsernameLogin = textUsername.getText();
                String patientPasswordLogin = new String(textPassword.getPassword());

                if(patientLogin(Patient.getPatientUsernameArray(), patientUsernameLogin, patientPasswordLogin)){
                    new PatientMainMenu();
                    frame.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Account doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override

            public void insertUpdate(DocumentEvent e) {
                buttonLogin.setEnabled(!textUsername.getText().isEmpty() && !textPassword.getText().isEmpty());
            }
            public void changedUpdate(DocumentEvent e) {
                buttonLogin.setEnabled(!textUsername.getText().isEmpty() && !textPassword.getText().isEmpty());
            }
            public void removeUpdate(DocumentEvent e) {
                buttonLogin.setEnabled(!textUsername.getText().isEmpty() && !textPassword.getText().isEmpty());
            }
        }
    }

    public static class PatientMainMenu {
        private JButton buttonSetApp, buttonPastApp, buttonSeeApp, buttonLogout;
        private JLabel labelHeader, labelPatientName, labelQuestion, labelSetAppointmentIcon, labelSeeAppointmentIcon, labelSeePastAppointmentsIcon;

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        public PatientMainMenu() {
            Border MainJFrameBorder = BorderFactory.createLineBorder(Color.white, 3);
            panel.setBorder(MainJFrameBorder);
            frame.setResizable(false);
            frame.setSize(520, 350);
            frame.setTitle("Patient's Main Menu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            panel.setBackground(new Color(0x1261A0));
            panel.setLayout(null);

            labelHeader = new JLabel("Hello ");
            labelHeader.setBounds(10, 30, 180, 30);
            labelHeader.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 27));
            labelHeader.setForeground(Color.WHITE);
            panel.add(labelHeader);

            labelPatientName = new JLabel(currentlyLoggedIn.get("firstName") + ",");
            labelPatientName.setBounds(95, 36, 1000, 25);
            labelPatientName.setFont(new Font("Garamond", Font.PLAIN, 22));
            labelPatientName.setForeground(Color.WHITE);
            panel.add(labelPatientName);

            labelQuestion = new JLabel("How can I help you?");
            labelQuestion.setBounds(180, 80, 180, 25);
            labelQuestion.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
            labelQuestion.setForeground(Color.WHITE);
            panel.add(labelQuestion);

            ImageIcon setAppointmentIcon = new ImageIcon(getClass().getResource("/images/setAppointmentIcon.png"));
            labelSetAppointmentIcon = new JLabel(setAppointmentIcon);
            labelSetAppointmentIcon.setBounds(135, 120, 45, 45);
            panel.add(labelSetAppointmentIcon);

            buttonSetApp = new JButton("Set Appointment");
            buttonSetApp.setBounds(90, 170, 140, 25);
            buttonSetApp.setFont(new Font("Arial", Font.PLAIN, 12));
            buttonSetApp.setOpaque(false);
            buttonSetApp.setContentAreaFilled(false);
            buttonSetApp.setForeground(Color.WHITE);
            buttonSetApp.setFocusable(false);
            Border borderSetAppointmentButton = BorderFactory.createLineBorder(Color.white, 1);
            buttonSetApp.setBorder(borderSetAppointmentButton);
            buttonSetApp.setBackground(new Color(0x072F5F));
            buttonSetApp.addActionListener(new SetApp());
            panel.add(buttonSetApp);

            ImageIcon seeAppointmentIcon = new ImageIcon(getClass().getResource("/images/seeCurrentAppointment.png"));
            labelSeeAppointmentIcon = new JLabel(seeAppointmentIcon);
            labelSeeAppointmentIcon.setBounds(335, 122, 45, 45);
            panel.add(labelSeeAppointmentIcon);

            buttonSeeApp = new JButton("See Appointment");
            buttonSeeApp.setBounds(280, 170, 140, 25);
            buttonSeeApp.setFont(new Font("Arial", Font.PLAIN, 12));
            buttonSeeApp.setOpaque(false);
            buttonSeeApp.setContentAreaFilled(false);
            buttonSeeApp.setForeground(Color.WHITE);
            buttonSeeApp.setFocusable(false);
            Border borderSeeAppointmentButton = BorderFactory.createLineBorder(Color.white, 1);
            buttonSeeApp.setBorder(borderSeeAppointmentButton);
            buttonSeeApp.setBackground(new Color(0x072F5F));
            buttonSeeApp.addActionListener(new SeeApp());
            panel.add(buttonSeeApp);

            ImageIcon seePastAppointmentsIcon = new ImageIcon(getClass().getResource("/images/seePastAppointments.png"));
            labelSeePastAppointmentsIcon = new JLabel(seePastAppointmentsIcon);
            labelSeePastAppointmentsIcon.setBounds(238, 200, 45, 45);
            panel.add(labelSeePastAppointmentsIcon);

            buttonPastApp = new JButton("See Past Appointments");
            buttonPastApp.setBounds(170, 250, 165, 25);
            buttonPastApp.setFont(new Font("Arial", Font.PLAIN, 12));
            buttonPastApp.setOpaque(false);
            buttonPastApp.setContentAreaFilled(false);
            buttonPastApp.setForeground(Color.WHITE);
            buttonPastApp.setFocusable(false);
            Border borderSeePastAppointmentsButton = BorderFactory.createLineBorder(Color.white, 1);
            buttonPastApp.setBorder(borderSeePastAppointmentsButton);
            buttonPastApp.setBackground(new Color(0x072F5F));
            buttonPastApp.addActionListener(new SeePastApp());
            panel.add(buttonPastApp);

            buttonLogout = new JButton("LOGOUT");
            buttonLogout.setBounds(400, 10, 90, 20);
            buttonLogout.setFont(new Font("Arial", Font.PLAIN, 15));
            buttonLogout.setForeground(Color.WHITE);
            buttonLogout.setFocusable(false);
            Border borderLogoutButton = BorderFactory.createLineBorder(Color.white, 1);
            buttonLogout.setBorder(borderLogoutButton);
            buttonLogout.setBackground(new Color(0x072F5F));
            buttonLogout.addActionListener(new buttonLogout());
            panel.add(buttonLogout);

            frame.setVisible(true);
            Main.startInCenter(frame);
        }

        private class SetApp implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SetAppointment();
                frame.dispose();
            }
        }

        private class SeeApp implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SeeAppointments(Appointment.getAppointmentArray(), currentlyLoggedIn);
                frame.dispose();
            }
        }

        private class SeePastApp implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SeePastAppointments(Appointment.getAppointmentArray(), currentlyLoggedIn);
                frame.dispose();
            }
        }

        private class buttonLogout implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main.MainJFrame();
                frame.dispose();
            }
        }
    }

    public static class SetAppointment {
        private JLabel labelMainBackground, mondayPrimaryCare,mondayCardiology, tuesdayNeurology, tuesdayGynecology,mondayUrology,tuesdayOphthalmology,wednesdayPediatrician,mondayDermatology,
                wednesdayENT ,wednesdayPrimaryCare,wednesdayNeurology,thursdayGynecology,thursdayDermatology,thursdayOphthalmology, thursdayUrology,fridayPediatrician,
                fridayCardiology,fridayENT, labelDoctorDescription;
        private JButton buttonBack;
        private JPanel panel;

        public SetAppointment(){
            JFrame frame = new JFrame();
            frame.setResizable(false);
            frame.setSize(1350, 830);
            frame.setTitle("Doctor's Schedules");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);

            //panel
            panel = new JPanel();
            panel.setLayout(null);
            panel.setBounds(0, -10, 1350, 825);

            ImageIcon MainBackground = new ImageIcon(getClass().getResource("images/SetAppointment/setAppointmentBackground.png"));
            labelMainBackground = new JLabel(MainBackground);
            labelMainBackground.setBounds(0, 0, 1350, 825);
            panel.add(labelMainBackground);

            labelDoctorDescription = new JLabel();
            labelDoctorDescription.setVisible(false);
            labelMainBackground.add(labelDoctorDescription);

            // --------------- IMAGES ---------------

            //DOCTOR PANELS
            //Monday

            int a = 0;
            boolean PrimaryCareMondayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Pepe")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Monday, 8:00am - 10:00am")) {
                    a++;
                }
            }
            if (a < 4) {
                ImageIcon PrimaryCareMonday = new ImageIcon(getClass().getResource("images/SetAppointment/PrimaryCare.png"));
                mondayPrimaryCare = new JLabel(PrimaryCareMonday);
                PrimaryCareMondayFull = false;
            } else {
                ImageIcon PrimaryCareMonday = new ImageIcon(getClass().getResource("images/AppointmentFull/PrimaryCareFull.png"));
                mondayPrimaryCare = new JLabel(PrimaryCareMonday);
                PrimaryCareMondayFull = true;
            }

            mondayPrimaryCare.setBounds(140, 135, 230, 115);

            int b = 0;
            boolean CardiologyMondayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("LeBron")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Monday, 10:00am - 12:00pm")) {
                    b++;
                }
            }
            if (b < 4) {
                ImageIcon CardiologyMonday = new ImageIcon(getClass().getResource("images/SetAppointment/Cardiology.png"));
                mondayCardiology = new JLabel(CardiologyMonday);
                CardiologyMondayFull = false;
            } else {
                ImageIcon CardiologyMonday = new ImageIcon(getClass().getResource("images/AppointmentFull/CardiologyFull.png"));
                mondayCardiology = new JLabel(CardiologyMonday);
                CardiologyMondayFull = true;
            }
            mondayCardiology.setBounds(140, 255, 230, 115);

            int c = 0;
            boolean DermatologyMondayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Stephen")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Monday, 1:00pm - 3:00pm")) {
                    c++;
                }
            }
            if (c < 4) {
                ImageIcon DermatologyMonday = new ImageIcon(getClass().getResource("images/SetAppointment/Dermatology.png"));
                mondayDermatology = new JLabel(DermatologyMonday);
                DermatologyMondayFull = false;
            } else {
                ImageIcon DermatologyMonday = new ImageIcon(getClass().getResource("images/AppointmentFull/DermatologyFull.png"));
                mondayDermatology = new JLabel(DermatologyMonday);
                DermatologyMondayFull = true;
            }

            mondayDermatology.setBounds(140, 430, 230, 115);

            int d = 0;
            boolean UrologyMondayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Lonahld")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Monday, 4:00pm - 6:00pm")) {
                    d++;
                }
            }
            if (d < 4) {
                ImageIcon UrologyMonday = new ImageIcon(getClass().getResource("images/SetAppointment/Urology.png"));
                mondayUrology = new JLabel(UrologyMonday);
                UrologyMondayFull = false;
            } else {
                ImageIcon UrologyMonday = new ImageIcon(getClass().getResource("images/AppointmentFull/UrologyFull.png"));
                mondayUrology = new JLabel(UrologyMonday);
                UrologyMondayFull = true;
            }
            mondayUrology.setBounds(140, 605, 230, 115);

            //Tuesday

            int e = 0;
            boolean OphthalmologyTuesdayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Chris")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Tuesday, 9:00am - 11:00am")) {
                    e++;
                }
            }
            if (e < 4) {
                ImageIcon OphthalmologyTuesday = new ImageIcon(getClass().getResource("images/SetAppointment/Ophthalmology.png"));
                tuesdayOphthalmology = new JLabel(OphthalmologyTuesday);
                OphthalmologyTuesdayFull = false;
            } else {
                ImageIcon OphthalmologyTuesday = new ImageIcon(getClass().getResource("images/AppointmentFull/OphthalmologyFull.png"));
                tuesdayOphthalmology = new JLabel(OphthalmologyTuesday);
                OphthalmologyTuesdayFull = true;
            }
            tuesdayOphthalmology.setBounds(375, 185, 230, 115);

            int f = 0;
            boolean NeurologyTuesdayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Jimmy")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Tuesday, 11:00am - 1:00pm")) {
                    f++;
                }
            }
            if (f < 4) {
                ImageIcon NeurologyTuesday = new ImageIcon(getClass().getResource("images/SetAppointment/Neurology.png"));
                tuesdayNeurology = new JLabel(NeurologyTuesday);
                NeurologyTuesdayFull = false;
            } else {
                ImageIcon NeurologyTuesday = new ImageIcon(getClass().getResource("images/AppointmentFull/NeurologyFull.png"));
                tuesdayNeurology = new JLabel(NeurologyTuesday);
                NeurologyTuesdayFull = true;
            }
            tuesdayNeurology.setBounds(375, 325, 230, 115);

            int g = 0;
            boolean GynecologyTuesdayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Jonah")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Tuesday, 2:00pm - 4:00pm")) {
                    g++;
                }
            }
            if (g < 4) {
                ImageIcon GynecologyTuesday = new ImageIcon(getClass().getResource("images/SetAppointment/Gynecology.png"));
                tuesdayGynecology = new JLabel(GynecologyTuesday);
                GynecologyTuesdayFull = false;
            } else {
                ImageIcon GynecologyTuesday = new ImageIcon(getClass().getResource("images/AppointmentFull/GynecologyFull.png"));
                tuesdayGynecology = new JLabel(GynecologyTuesday);
                GynecologyTuesdayFull = true;
            }
            tuesdayGynecology.setBounds(375, 500, 230, 115);

            //Wednesday

            int h = 0;
            boolean PediatricsWednesdayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Sharon")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Wednesday, 8:00am - 10:00am")) {
                    h++;
                }
            }
            if (h < 4) {
                ImageIcon PediatricsWednesday = new ImageIcon(getClass().getResource("images/SetAppointment/Pediatrics.png"));
                wednesdayPediatrician = new JLabel(PediatricsWednesday);
                PediatricsWednesdayFull = false;
            } else {
                ImageIcon PediatricsWednesday = new ImageIcon(getClass().getResource("images/AppointmentFull/PediatricsFull.png"));
                wednesdayPediatrician = new JLabel(PediatricsWednesday);
                PediatricsWednesdayFull = true;
            }
            wednesdayPediatrician.setBounds(610, 135, 230, 115);

            int j = 0;
            boolean ENTWednesdayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Mikasa")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Wednesday, 10:00am - 12:00pm")) {
                    j++;
                }
            }
            if(j < 4) {
                ImageIcon ENTWednesday = new ImageIcon(getClass().getResource("images/SetAppointment/ENT.png"));
                wednesdayENT = new JLabel(ENTWednesday);
                ENTWednesdayFull = false;
            }
            else{
                ImageIcon ENTWednesday = new ImageIcon(getClass().getResource("images/AppointmentFull/ENTFull.png"));
                wednesdayENT = new JLabel(ENTWednesday);
                ENTWednesdayFull = true;
            }
            wednesdayENT.setBounds(610, 255, 230, 125);

            int k = 0;
            boolean PrimaryCareWednesdayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Pepe")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Wednesday, 12:00pm - 2:00pm")) {
                    k++;
                }
            }
            if (k < 4) {
                ImageIcon PrimaryCareWednesday = new ImageIcon(getClass().getResource("images/SetAppointment/PrimaryCare.png"));
                wednesdayPrimaryCare = new JLabel(PrimaryCareWednesday);
                PrimaryCareWednesdayFull = false;
            } else {
                ImageIcon PrimaryCareWednesday = new ImageIcon(getClass().getResource("images/AppointmentFull/PrimaryCareFull.png"));
                wednesdayPrimaryCare = new JLabel(PrimaryCareWednesday);
                PrimaryCareWednesdayFull = true;
            }
            wednesdayPrimaryCare.setBounds(610, 390, 230, 115);
            labelMainBackground.add(wednesdayPrimaryCare);

            int l = 0;
            boolean NeurologyWednesdayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Jimmy")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Wednesday, 3:00pm - 5:00pm")) {
                    l++;
                }
            }
            if (l < 4) {
                ImageIcon NeurologyWednesday = new ImageIcon(getClass().getResource("images/SetAppointment/Neurology.png"));
                wednesdayNeurology = new JLabel(NeurologyWednesday);
                NeurologyWednesdayFull = false;
            } else {
                ImageIcon NeurologyWednesday = new ImageIcon(getClass().getResource("images/AppointmentFull/NeurologyFull.png"));
                wednesdayNeurology = new JLabel(NeurologyWednesday);
                NeurologyWednesdayFull = true;
            }
            wednesdayNeurology.setBounds(610, 550, 230, 115);

            //Thursday

            int m = 0;
            boolean GynecologyThursdayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Jonah")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Thursday, 9:00am - 11:00am")) {
                    m++;
                }
            }
            if (m < 4) {
                ImageIcon GynecologyThursday = new ImageIcon(getClass().getResource("images/SetAppointment/Gynecology.png"));
                thursdayGynecology = new JLabel(GynecologyThursday);
                GynecologyThursdayFull = false;
            } else {
                ImageIcon GynecologyThursday = new ImageIcon(getClass().getResource("images/AppointmentFull/GynecologyFull.png"));
                thursdayGynecology = new JLabel(GynecologyThursday);
                GynecologyThursdayFull = true;
            }
            thursdayGynecology.setBounds(845, 185, 230, 115);

            int n = 0;
            boolean DermatologyThursdayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Stephen")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Thursday, 11:00am - 1:00pm")) {
                    n++;
                }
            }
            if (n < 4) {
                ImageIcon DermatologyThursday = new ImageIcon(getClass().getResource("images/SetAppointment/Dermatology.png"));
                thursdayDermatology = new JLabel(DermatologyThursday);
                DermatologyThursdayFull = false;
            } else {
                ImageIcon DermatologyThursday = new ImageIcon(getClass().getResource("images/AppointmentFull/DermatologyFull.png"));
                thursdayDermatology = new JLabel(DermatologyThursday);
                DermatologyThursdayFull = true;
            }
            thursdayDermatology.setBounds(845, 310, 230, 115);

            int o = 0;
            boolean OphthalmologyThursdayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Chris")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Thursday, 1:00pm - 3:00pm")) {
                    o++;
                }
            }
            if (o < 4) {
                ImageIcon OphthalmologyThursday = new ImageIcon(getClass().getResource("images/SetAppointment/Ophthalmology.png"));
                thursdayOphthalmology = new JLabel(OphthalmologyThursday);
                OphthalmologyThursdayFull = false;
            } else {
                ImageIcon OphthalmologyThursday = new ImageIcon(getClass().getResource("images/AppointmentFull/OphthalmologyFull.png"));
                thursdayOphthalmology = new JLabel(OphthalmologyThursday);
                OphthalmologyThursdayFull = true;
            }
            thursdayOphthalmology.setBounds(845, 440, 230, 115);

            int p = 0;
            boolean UrologyThursdayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Lonahld")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Thursday, 5:00pm - 7:00pm")) {
                    p++;
                }
            }
            if (p < 4) {
                ImageIcon UrologyThursday = new ImageIcon(getClass().getResource("images/SetAppointment/Urology.png"));
                thursdayUrology = new JLabel(UrologyThursday);
                UrologyThursdayFull = false;
            } else {
                ImageIcon UrologyThursday = new ImageIcon(getClass().getResource("images/AppointmentFull/UrologyFull.png"));
                thursdayUrology = new JLabel(UrologyThursday);
                UrologyThursdayFull = true;
            }
            thursdayUrology.setBounds(845, 660, 230, 115);

            //Friday

            int q = 0;
            boolean PediatricianFridayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Sharon")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Friday, 8:00am - 10:00am")) {
                    q++;
                }
            }
            if (q < 4) {
                ImageIcon PediatricianFriday = new ImageIcon(getClass().getResource("images/SetAppointment/Pediatrics.png"));
                fridayPediatrician = new JLabel(PediatricianFriday);
                PediatricianFridayFull = false;
            } else {
                ImageIcon PediatricianFriday = new ImageIcon(getClass().getResource("images/AppointmentFull/PediatricsFull.png"));
                fridayPediatrician = new JLabel(PediatricianFriday);
                PediatricianFridayFull = true;
            }
            fridayPediatrician.setBounds(1085, 135, 230, 115);

            int r = 0;
            boolean CardiologyFridayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("LeBron")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Friday, 12:00pm - 2:00pm")) {
                    r++;
                }
            }
            if (r < 4) {
                ImageIcon CardiologyFriday = new ImageIcon(getClass().getResource("images/SetAppointment/Cardiology.png"));
                fridayCardiology = new JLabel(CardiologyFriday);
                CardiologyFridayFull = false;
            } else {
                ImageIcon CardiologyFriday = new ImageIcon(getClass().getResource("images/AppointmentFull/CardiologyFull.png"));
                fridayCardiology = new JLabel(CardiologyFriday);
                CardiologyFridayFull = true;
            }
            fridayCardiology.setBounds(1085, 370, 230, 115);

            int s = 0;
            boolean ENTFridayFull = false;

            for(int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                if ((Appointment.getAppointmentArray().get(i).get("doctorUsername").equals("Mikasa")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Friday, 2:00pm - 4:00pm")) {
                    s++;
                }
            }
            if (s < 4) {
                ImageIcon ENTFriday = new ImageIcon(getClass().getResource("images/SetAppointment/ENT.png"));
                fridayENT = new JLabel(ENTFriday);
                ENTFridayFull = false;
            } else {
                ImageIcon ENTFriday = new ImageIcon(getClass().getResource("images/AppointmentFull/ENTFull.png"));
                fridayENT = new JLabel(ENTFriday);
                ENTFridayFull = true;
            }
            fridayENT.setBounds(1085, 490, 230, 125);

            //backButton
            ImageIcon buttonBackImage = new ImageIcon(getClass().getResource("/images/SeePastAppointments/backButton.png"));
            buttonBack = new JButton(buttonBackImage);
            buttonBack.setBounds(15,10,79,51);
            buttonBack.setFocusable(false);
            buttonBack.setBackground(new Color(0x3895d3));
            buttonBack.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    new PatientMainMenu();
                    frame.dispose();
                }
            });

            // --------------- MOUSE LISTENER ---------------
            // Monday
            boolean finalPrimaryCareMondayFull = PrimaryCareMondayFull;
            mondayPrimaryCare.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!finalPrimaryCareMondayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Monday, 8:00am - 10:00am")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Pepe", "Monday, 8:00am - 10:00am");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalPrimaryCareMondayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/PrimaryCare2.png"));
                        mondayPrimaryCare.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionPrimaryCare.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(240, 235, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalPrimaryCareMondayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/PrimaryCare.png"));
                        mondayPrimaryCare.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/PrimaryCareFull.png"));
                        mondayPrimaryCare.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });
            boolean finalCardiologyMondayFull = CardiologyMondayFull;
            mondayCardiology.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!finalCardiologyMondayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Monday, 10:00am - 12:00pm")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "LeBron", "Monday, 10:00am - 12:00pm");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!finalCardiologyMondayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Cardiology2.png"));
                        mondayCardiology.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionCardiology.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(240, 355, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if (!finalCardiologyMondayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Cardiology.png"));
                        mondayCardiology.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/CardiologyFull.png"));
                        mondayCardiology.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });
            boolean finalDermatologyMondayFull = DermatologyMondayFull;
            mondayDermatology.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!finalDermatologyMondayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Monday, 1:00pm - 3:00pm")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Stephen", "Monday, 1:00pm - 3:00pm");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!finalDermatologyMondayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Dermatology2.png"));
                        mondayDermatology.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionDermatology.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(240, 530, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if (!finalDermatologyMondayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Dermatology.png"));
                        mondayDermatology.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/DermatologyFull.png"));
                        mondayDermatology.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });
            boolean finalUrologyMondayFull = UrologyMondayFull;
            mondayUrology.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalUrologyMondayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Monday, 4:00pm - 6:00pm")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Lonahld", "Monday, 4:00pm - 6:00pm");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!finalUrologyMondayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Urology2.png"));
                        mondayUrology.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionUrology.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(240, 475, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalUrologyMondayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Urology.png"));
                        mondayUrology.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/UrologyFull.png"));
                        mondayUrology.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });

            //Tuesday
            boolean finalOphthalmologyTuesdayFull = OphthalmologyTuesdayFull;
            tuesdayOphthalmology.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalOphthalmologyTuesdayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Tuesday, 9:00am - 11:00am")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Chris", "Tuesday, 9:00am - 11:00am");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalOphthalmologyTuesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Ophthalmology2.png"));
                        tuesdayOphthalmology.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionOphthalmology.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(475, 285, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!finalOphthalmologyTuesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Ophthalmology.png"));
                        tuesdayOphthalmology.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/OphthalmologyFull.png"));
                        tuesdayOphthalmology.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });
            boolean finalNeurologyTuesdayFull = NeurologyTuesdayFull;
            tuesdayNeurology.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalNeurologyTuesdayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Tuesday, 11:00am - 1:00pm")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Jimmy", "Tuesday, 11:00am - 1:00pm");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalNeurologyTuesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Neurology2.png"));
                        tuesdayNeurology.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionNeurology.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(475, 425, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalNeurologyTuesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Neurology.png"));
                        tuesdayNeurology.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/NeurologyFull.png"));
                        tuesdayNeurology.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });
            boolean finalGynecologyTuesdayFull = GynecologyTuesdayFull;
            tuesdayGynecology.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalGynecologyTuesdayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Tuesday, 2:00pm - 4:00pm")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Jonah", "Tuesday, 2:00pm - 4:00pm");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalGynecologyTuesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Gynecology2.png"));
                        tuesdayGynecology.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionGynecology.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(475, 600, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalGynecologyTuesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Gynecology.png"));
                        tuesdayGynecology.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/GynecologyFull.png"));
                        tuesdayGynecology.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });

            //Wednesday
            boolean finalPediatricsWednesdayFull = PediatricsWednesdayFull;
            wednesdayPediatrician.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalPediatricsWednesdayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Wednesday, 8:00am - 10:00am")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Sharon", "Wednesday, 8:00am - 10:00am");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalPediatricsWednesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Pediatrics2.png"));
                        wednesdayPediatrician.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionPediatrician.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(715, 235, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalPediatricsWednesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Pediatrics.png"));
                        wednesdayPediatrician.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/PediatricsFull.png"));
                        wednesdayPediatrician.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });
            boolean finalENTWednesdayFull = ENTWednesdayFull;
            wednesdayENT.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalENTWednesdayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Wednesday, 10:00am - 12:00pm")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Mikasa", "Wednesday, 10:00am - 12:00pm");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalENTWednesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/ENT2.png"));
                        wednesdayENT.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionENT.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(710, 355, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalENTWednesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/ENT.png"));
                        wednesdayENT.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/ENTFull.png"));
                        wednesdayENT.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });
            boolean finalPrimaryCareWednesdayFull = PrimaryCareWednesdayFull;
            wednesdayPrimaryCare.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalPrimaryCareWednesdayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Wednesday, 12:00pm - 2:00pm")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Pepe", "Wednesday, 12:00pm - 2:00pm");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalPrimaryCareWednesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/PrimaryCare2.png"));
                        wednesdayPrimaryCare.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionPrimaryCare.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(710, 490, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalPrimaryCareWednesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/PrimaryCare.png"));
                        wednesdayPrimaryCare.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/PrimaryCareFull.png"));
                        wednesdayPrimaryCare.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });
            boolean finalNeurologyWednesdayFull = NeurologyWednesdayFull;
            wednesdayNeurology.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalNeurologyWednesdayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Wednesday, 3:00pm - 5:00pm")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Jimmy", "Wednesday, 3:00pm - 5:00pm");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalNeurologyWednesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Neurology2.png"));
                        wednesdayNeurology.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionNeurology.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(710, 650, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalNeurologyWednesdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Neurology.png"));
                        wednesdayNeurology.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/NeurologyFull.png"));
                        wednesdayNeurology.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });

            //Thursday
            boolean finalGynecologyThursdayFull = GynecologyThursdayFull;
            thursdayGynecology.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalGynecologyThursdayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Thursday, 9:00am - 11:00am")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Jonah", "Thursday, 9:00am - 11:00am");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalGynecologyThursdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Gynecology2.png"));
                        thursdayGynecology.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionGynecology.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(415, 285, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalGynecologyThursdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Gynecology.png"));
                        thursdayGynecology.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/GynecologyFull.png"));
                        thursdayGynecology.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });
            boolean finalDermatologyThursdayFull = DermatologyThursdayFull;
            thursdayDermatology.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalDermatologyThursdayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Thursday, 11:00am - 1:00pm")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Stephen", "Thursday, 11:00am - 1:00pm");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalDermatologyThursdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Dermatology2.png"));
                        thursdayDermatology.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionDermatology.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(415, 410, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalDermatologyThursdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Dermatology.png"));
                        thursdayDermatology.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/DermatologyFull.png"));
                        thursdayDermatology.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });
            boolean finalOphthalmologyThursdayFull = OphthalmologyThursdayFull;
            thursdayOphthalmology.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalOphthalmologyThursdayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Thursday, 1:00pm - 3:00pm")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Chris", "Thursday, 1:00pm - 3:00pm");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalOphthalmologyThursdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Ophthalmology2.png"));
                        thursdayOphthalmology.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionOphthalmology.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(415, 540, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalOphthalmologyThursdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Ophthalmology.png"));
                        thursdayOphthalmology.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/OphthalmologyFull.png"));
                        thursdayOphthalmology.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });
            boolean finalUrologyThursdayFull = UrologyThursdayFull;
            thursdayUrology.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalUrologyThursdayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Thursday, 5:00pm - 7:00pm")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Lonahld", "Thursday, 5:00pm - 7:00pm");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalUrologyThursdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Urology2.png"));
                        thursdayUrology.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionUrology.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(415, 560, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalUrologyThursdayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Urology.png"));
                        thursdayUrology.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/UrologyFull.png"));
                        thursdayUrology.setIcon(image);
                    }
                    labelDoctorDescription.setVisible(false);
                }
            });

            //Friday
            boolean finalPediatricianFridayFull = PediatricianFridayFull;
            fridayPediatrician.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalPediatricianFridayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Friday, 8:00am - 10:00am")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Sharon", "Friday, 8:00am - 10:00am");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalPediatricianFridayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Pediatrics2.png"));
                        fridayPediatrician.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionPediatrician.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(655, 235, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalPediatricianFridayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Pediatrics.png"));
                        fridayPediatrician.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/PediatricsFull.png"));
                        fridayPediatrician.setIcon(image);
                    }

                    labelDoctorDescription.setVisible(false);
                }
            });
            boolean finalCardiologyFridayFull = CardiologyFridayFull;
            fridayCardiology.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalCardiologyFridayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Friday, 12:00pm - 2:00pm")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "LeBron", "Friday, 12:00pm - 2:00pm");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalCardiologyFridayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Cardiology2.png"));
                        fridayCardiology.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionCardiology.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(655, 475, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalCardiologyFridayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/Cardiology.png"));
                        fridayCardiology.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/CardiologyFull.png"));
                        fridayCardiology.setIcon(image);
                    }

                    labelDoctorDescription.setVisible(false);
                }
            });
            boolean finalENTFridayFull = ENTFridayFull;
            fridayENT.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!finalENTFridayFull) {
                        int reply = JOptionPane.showConfirmDialog(frame, "Do you want to set this appointment?", "Confirm Appointment", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            boolean noAppointment = true;
                            for (int i = 0; i < Appointment.getAppointmentArray().size(); i++) {
                                if (Appointment.getAppointmentArray().get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && Appointment.getAppointmentArray().get(i).get("dateAndTime").equals("Friday, 2:00pm - 4:00pm")) {
                                    noAppointment = false;
                                    JOptionPane.showMessageDialog(frame, "You already have this appointment", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (noAppointment) {
                                Appointment appointment = new Appointment(currentlyLoggedIn.get("username"), "Mikasa", "Friday, 2:00pm - 4:00pm");
                                Appointment.getAppointmentArray().add(appointment);
                            }
                        }
                    }
                    else{}
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!finalENTFridayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/ENT2.png"));
                        fridayENT.setIcon(image);

                        ImageIcon descriptionImage = new ImageIcon(getClass().getResource("images/SetAppointment/descriptions/descriptionENT.png"));
                        labelDoctorDescription.setIcon(descriptionImage);
                        labelDoctorDescription.setBounds(655, 590, 600, 150);
                        labelDoctorDescription.setVisible(true);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if(!finalENTFridayFull) {
                        ImageIcon image = new ImageIcon(getClass().getResource("images/SetAppointment/ENT.png"));
                        fridayENT.setIcon(image);
                    }
                    else{
                        ImageIcon image = new ImageIcon(getClass().getResource("images/AppointmentFull/ENTFull.png"));
                        fridayENT.setIcon(image);
                    }

                    labelDoctorDescription.setVisible(false);
                }
            });
            labelMainBackground.add(mondayPrimaryCare);
            labelMainBackground.add(mondayCardiology);
            labelMainBackground.add(mondayDermatology);
            labelMainBackground.add(mondayUrology);
            labelMainBackground.add(tuesdayOphthalmology);
            labelMainBackground.add(tuesdayNeurology);
            labelMainBackground.add(tuesdayGynecology);
            labelMainBackground.add(wednesdayPediatrician);
            labelMainBackground.add(wednesdayENT);
            labelMainBackground.add(wednesdayPrimaryCare);
            labelMainBackground.add(wednesdayNeurology);
            labelMainBackground.add(thursdayGynecology);
            labelMainBackground.add(thursdayDermatology);
            labelMainBackground.add(thursdayOphthalmology);
            labelMainBackground.add(thursdayUrology);
            labelMainBackground.add(fridayPediatrician);
            labelMainBackground.add(fridayCardiology);
            labelMainBackground.add(fridayENT);
            labelMainBackground.add(buttonBack);

            frame.add(panel);
            frame.setVisible(true);
            Main.startInCenter(frame);
        }
    }

    public static class SeeAppointments {
        private JLabel labelMainBackground, labelContainer;
        private JButton buttonBack;
        private JScrollPane scrollPane;

        JFrame frame = new JFrame();
        JPanel ContainerPanel = new JPanel();

        public SeeAppointments(List<Appointment> AppointmentsArray, Patient currentlyLoggedIn) {
            frame.setResizable(false);
            frame.setSize(1350,830);
            frame.setTitle("Patient's See Appointments");
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
                if(AppointmentsArray.get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && !AppointmentsArray.get(i).isDone()){
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
                    JLabel DoctorsName = new JLabel(Doctor.getDoctorFullName(Appointment.getAppointmentArray(), i) + " - " + Doctor.getDoctorProfession(Appointment.getAppointmentArray(), i));
                    DoctorsName.setFont(new Font("Gulim",Font.PLAIN, 20));
                    DoctorsName.setForeground(Color.WHITE);
                    DoctorsName.setBounds(15,65,500,40);
                    labelContainer.add(DateNTime);
                    labelContainer.add(DoctorsName);

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
                new PatientMainMenu();
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

        public SeePastAppointments(List<Appointment> AppointmentsArray, Patient currentlyLoggedIn) {
            frame.setResizable(false);
            frame.setSize(1350,830);
            frame.setTitle("Patient's See Past Appointments");
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
                if(AppointmentsArray.get(i).get("patientUsername").equals(currentlyLoggedIn.get("username")) && AppointmentsArray.get(i).isDone()){
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
                    JLabel DoctorsName = new JLabel(Doctor.getDoctorFullName(Appointment.getAppointmentArray(), i) + " - " + Doctor.getDoctorProfession(Appointment.getAppointmentArray(), i));
                    DoctorsName.setFont(new Font("Gulim",Font.PLAIN, 20));
                    DoctorsName.setForeground(Color.WHITE);
                    DoctorsName.setBounds(15,65,500,40);
                    labelContainer.add(DateNTime);
                    labelContainer.add(DoctorsName);

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
                new PatientMainMenu();
                frame.dispose();
            }
        }
    }

    public static class SeeAppointmentDetails {

        JFrame frame = new JFrame();

        private JLabel labelMainBackground;
        private JLabel labelPatientName, labelHeight, labelWeight, labelDoctorName, labelAge, labelSex, labelDateAndTime, labelContactNumber;
        private JTextArea textAreaDoctorsComments;
        private JButton buttonBack;
        private JScrollPane scrollPane;

        public SeeAppointmentDetails(List<Appointment> AppointmentArray, int j) {
            frame.setResizable(false);
            frame.setSize(1350,830);
            frame.setTitle("Patient's See Appointment Details");
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
            labelPatientName.setText(currentlyLoggedIn.get("firstName") + " " + currentlyLoggedIn.get("lastName"));
            labelMainBackground.add(labelPatientName);

            labelHeight = new JLabel("");
            labelHeight.setFont(new Font("Gulim",Font.PLAIN,25));
            labelHeight.setBounds(320,227,300,50);
            labelHeight.setForeground(Color.WHITE);
            labelHeight.setText(currentlyLoggedIn.get("height") + " cm");
            labelMainBackground.add(labelHeight);

            labelWeight = new JLabel("");
            labelWeight.setFont(new Font("Gulim",Font.PLAIN,25));
            labelWeight.setBounds(320,282,300,50);
            labelWeight.setForeground(Color.WHITE);
            labelWeight.setText(currentlyLoggedIn.get("weight") + " kg");
            labelMainBackground.add(labelWeight);

            labelDoctorName = new JLabel("");
            labelDoctorName.setFont(new Font("Gulim",Font.PLAIN,25));
            labelDoctorName.setBounds(320,342,300,50);
            labelDoctorName.setForeground(Color.WHITE);
            labelDoctorName.setText(Doctor.getDoctorFullName(AppointmentArray, j));
            labelMainBackground.add(labelDoctorName);

            labelAge = new JLabel("");
            labelAge.setFont(new Font("Gulim",Font.PLAIN,25));
            labelAge.setBounds(910,167,300,50);
            labelAge.setForeground(Color.WHITE);
            labelAge.setText(currentlyLoggedIn.get("age"));
            labelMainBackground.add(labelAge);

            labelSex = new JLabel("");
            labelSex.setFont(new Font("Gulim",Font.PLAIN,25));
            labelSex.setBounds(910,223,300,50);
            labelSex.setForeground(Color.WHITE);
            labelSex.setText(currentlyLoggedIn.get("sex"));
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
            labelContactNumber.setText(currentlyLoggedIn.get("contactNumber"));
            labelMainBackground.add(labelContactNumber);

            textAreaDoctorsComments = new JTextArea();
            textAreaDoctorsComments.setEditable(false);
            textAreaDoctorsComments.setLineWrap(true);
            textAreaDoctorsComments.setWrapStyleWord(true);
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
                new PatientMainMenu();
                frame.dispose();
            }
        }
    }
}