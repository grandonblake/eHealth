import java.util.ArrayList;
import java.util.List;

public class Appointment {

    //states
    private String patientUsername;
    private String doctorUsername;
    private String dateAndTime;
    private String doctorComments;
    private boolean isDone;

    //arrayList
    private static List<Appointment> AppointmentArray = new ArrayList<Appointment>();
    public static List<Appointment> getAppointmentArray() {
        return AppointmentArray;
    }

    //getters
    public boolean isDone(){
        return isDone;
    }
    public String get(String field){
        if(field.equals("patientUsername")){
            return patientUsername;
        }
        else if(field.equals("doctorUsername")){
            return doctorUsername;
        }
        else if(field.equals("dateAndTime")){
            return dateAndTime;
        }
        else if(field.equals("doctorComments")){
            return doctorComments;
        }
        else{
            return "Error in Get Method";
        }
    }

    //setters
    public void setIsDone(){
        isDone = true;
    }
    public void set(String field, String set){
        if(field.equals("patientUsername")){
            patientUsername = set;
        }
        else if(field.equals("doctorUsername")){
            doctorUsername = set;
        }
        else if(field.equals("dateAndTime")){
            dateAndTime = set;
        }
        else if(field.equals("doctorComments")){
            doctorComments = set;
        }
    }

    public Appointment(String patientUsername, String doctorUsername, String dateAndTime){
        this.patientUsername = patientUsername;
        this.doctorUsername = doctorUsername;
        this.dateAndTime = dateAndTime;
        isDone = false;
    }
}