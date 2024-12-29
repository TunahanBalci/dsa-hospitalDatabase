//----------------------------------------------------- 
// Title: Patient Class
// Author: Tunahan BALCI
// ID: 12865148094
// Section: 02
// Assignment: 3
// Description: Represents a patient with personal details and a care team.
//----------------------------------------------------- 

public class Patient {

    private int visitDate_year;
    private int visitDate_month;
    private int visitDate_day;
    private String name;
    private String doctorName;

    protected CareTeamBST careTeam;

    /**
     * Retrieves the name of the patient.
     *
     * @return The patient's name.
     */
    public String getName(){
        return name;
    }

    /**
     * Retrieves the year the patient visited the hospital.
     *
     * @return The visit year.
     */
    public int getVisitDate_year(){
        return visitDate_year;
    }

    /**
     * Retrieves the month the patient visited the hospital.
     *
     * @return The visit month.
     */
    public int getVisitDate_month(){
        return visitDate_month;
    }

    /**
     * Retrieves the day the patient visited the hospital.
     *
     * @return The visit day.
     */
    public int getVisitDate_day(){
        return visitDate_day;
    }

    /**
     * Retrieves the doctor's name associated with the patient.
     *
     * @return The doctor's name.
     */
    public String getDoctorName(){
        return doctorName;
    }

    /**
     * Constructs a Patient with the specified details.
     *
     * @param name The first and last name of the patient.
     * @param visitDate_year The year the patient visited the hospital.
     * @param visitDate_month The month the patient visited the hospital.
     * @param visitDate_day The day the patient visited the hospital.
     * @param doctorName The first and last name of the doctor.
     */
    public Patient(String name, int visitDate_year, int visitDate_month, int visitDate_day, String doctorName) {
        this.visitDate_year = visitDate_year;
        this.visitDate_month = visitDate_month;
        this.visitDate_day = visitDate_day;
        this.name = name;
        this.doctorName = doctorName;
        this.careTeam = new CareTeamBST();
    }

    // Additional methods can be added here as needed.
}
