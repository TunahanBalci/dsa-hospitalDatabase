//-----------------------------------------------------
// Title: HospitalDatabase Class
// Author: Tunahan BALCI
// ID: 12865148094
// Section: 02
// Assignment: 3
// Description: Manages the hospital database, including the patients and their care teams.
//-----------------------------------------------------
public class HospitalDatabase {
    private PatientBST patients;

    /**
     * Initializes the HospitalDatabase with an empty PatientBST.
     */
    public HospitalDatabase() {
        this.patients = new PatientBST();
    }

    /**
     * Adds a patient to the hospital database.
     * Overwrites existing patient information if the patient already exists.
     *
     * @param patientName The name of the patient.
     * @param doctorName The name of the doctor.
     * @param visitDay The day of the visit.
     * @param visitMonth The month of the visit.
     * @param visitYear The year of the visit.
     */
    public void addPatient(String patientName, String doctorName, int visitDay, int visitMonth, int visitYear) {
        // Create a new patient instance
        Patient newPatient = new Patient(patientName, visitYear, visitMonth, visitDay, doctorName);

        // Check if the patient already exists
        Patient existingPatient = patients.getPatient(patients.root, patientName);
        if (existingPatient != null) {
            // Overwrite existing patient
            patients.remove(patients.root, existingPatient.getName());
            patients.root = patients.insert(patients.root, newPatient);
            System.out.println("ERROR: Patient " + patientName + " overwritten ");
        } else {
            // Insert the new patient into the BST
            patients.root = patients.insert(patients.root, newPatient);
            System.out.println("INFO: Patient " + patientName + " has been added ");
        }
    }

    /**
     * Removes a patient from the hospital database.
     *
     * @param patientName The name of the patient to remove.
     */
    public void removePatient(String patientName) {
        boolean exists = patients.remove(patients.root, patientName) != null;

        if (exists) {
            System.out.println("INFO: Patient " + patientName + " has been removed ");
        } else {
            System.out.println();
            System.out.println("ERROR: Patient " + patientName + " does not exist ");
        }
    }

    /**
     * Adds a medical staff member to a patient's care team.
     *
     * @param patientName The name of the patient.
     * @param memberName The name of the medical staff member.
     * @param memberRole The professional role of the member.
     */
    public void addMember(String patientName, String memberName, String memberRole) {
        // Retrieve the patient
        Patient patient = patients.getPatient(patients.root, patientName);

        // Check if the patient exists
        if (patient == null) {
            System.out.println("ERROR: Patient " + patientName + " does not exist ");
            return;
        }

        // Initialize the CareTeamBST if it's null
        if (patient.careTeam == null) {
            patient.careTeam = new CareTeamBST();
        }

        // Check if the member already exists in the care team
        boolean exists = patient.careTeam.getMember(patient.careTeam.root, memberName) != null;
        if (exists) {
            System.out.println("ERROR: Member " + memberName + " is already in " + patientName + "'s care team ");
        } else {
            // Add the new care team member
            CareTeamMember member = new CareTeamMember(memberName, memberRole);
            patient.careTeam.root = patient.careTeam.insert(patient.careTeam.root, member);
            System.out.println("INFO: " + memberName + " has been added to the patient " + patientName + " ");
        }
    }

    /**
     * Removes a medical staff member from a patient's care team.
     *
     * @param patientName The name of the patient.
     * @param memberName The name of the medical staff member to remove.
     */
    public void removeMember(String patientName, String memberName) {
        System.out.println();
        Patient patient = patients.getPatient(patients.root, patientName);
        if (patient == null) {
            System.out.println("ERROR: Patient " + patientName + " does not exist ");
        } else {
            boolean exists = patient.careTeam.getMember(patient.careTeam.root, memberName) != null;
            if (exists) {
                patient.careTeam.root = patient.careTeam.remove(patient.careTeam.root, memberName);
                System.out.println("INFO: " + memberName + " has been removed from the patient " + patientName + " ");
            } else {
                System.out.println("ERROR: Member " + memberName + " does not exist in patient " + patientName + "'s care team ");
            }
        }
    }

    /**
     * Displays all patients in the hospital database.
     * Prints '---none---' if no patients exist.
     */
    public void showAllPatients() {
        if (patients.root == null) {
            System.out.println("---none---\n");
            return;
        }
        System.out.println();
        patients.printAll(patients.root);
        System.out.println();
    }

    /**
     * Displays detailed information about a specific patient.
     *
     * @param patientName The name of the patient to display.
     */
    public void showPatient(String patientName) {

        Patient patient = patients.getPatient(patients.root, patientName);
        if (patient == null) {
            System.out.println("---none--- ");
        } else {
            System.out.println(patient.getName() + " "); // Trailing space
            System.out.println(patient.getVisitDate_day() + "/" + patient.getVisitDate_month() + "/" + patient.getVisitDate_year() + " "); // Trailing space
            System.out.println(patient.getDoctorName() + " "); // Trailing space
            patient.careTeam.printAll(patient.careTeam.root);
        }
        System.out.println();
    }

    /**
     * Displays all patients seen by a specific doctor.
     *
     * @param doctorName The name of the doctor.
     */
    public void showDoctorPatients(String doctorName) {
        System.out.println(doctorName + " "); // Trailing space

        LoopCounter lc = new LoopCounter(0);

        patients.showDoctorPatients(patients.root, doctorName, lc);
        if (lc.count == 0) {
            System.out.println("---none--- ");
        }
        System.out.println();
    }

    /**
     * Displays all patients who visited in a specific year.
     *
     * @param visitYear The year to query.
     */
    public void showPatients(int visitYear) {
        if (patients.root == null){
            System.out.println("---none---\n");
        } else {
            System.out.println(visitYear + " "); // Trailing space
            patients.printYear(patients.root, visitYear);
        }
    }
}
