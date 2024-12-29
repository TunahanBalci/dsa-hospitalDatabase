public class Tester {
    public static void main(String[] args) {
        HospitalDatabase hd = new HospitalDatabase();

        hd.showAllPatients();

        hd.addPatient("Michael Johnson", "Emma Thompson", 19, 12, 2022);
        hd.addPatient("Ethan Lee", "Olivia Sanchez", 8, 9, 2020);
        hd.addPatient("Noah Miller", "Olivia Sanchez", 27, 2, 2019);
        hd.addPatient("Liam Davis", "Isabella Martinez", 3, 4, 2022);
        hd.addPatient("Ava Taylor", "Isabella Martinez", 15, 5, 2024);
        hd.addPatient("Mason Moore", "William Anderson", 7, 6, 2021);
        hd.addPatient("Charlotte Garcia", "Lucas Lewis", 30, 10, 2023);
        hd.addPatient("Noah Miller", "Olivia Sanchez", 27, 2, 2019);

        hd.showAllPatients();
        hd.removePatient("Ava Taylor");
        hd.showAllPatients();
        hd.showPatient("Michael Johnson");
        hd.addMember("Mason Moore", "Daniel Roberts", "Nurse");
        hd.addMember ("Mason Moore", "Victoria Stewart", "Radiologist");
        hd.addMember ("Mason Moore", "Tyler Campbell", "Medical Assistant");
        hd.addMember ("Mason Moore", "Hannah Martin", "Paramedic");
        hd.addMember ("Michael Johnson", "Jack Allen", "Patient Care Technician");
        hd.addMember ("Michael Johnson", "Oliver Nelson", "Anesthesiologist");
        hd.addMember ("Michael Johnson", "Sophia Rivera", "Pathologist");
        hd.addMember ("Michael Johnson", "Evan Hall", "Laboratory Technician");
        hd.addMember ("Michael Johnson", "Megan Price", "Nurse");
        hd.addMember ("Ava Taylor", "Brianna Reed", "Dietitian");
        hd.addMember ("Charlotte Garcia", "Oliver Nelson", "Anesthesiologist");
        hd.addMember ("Charlotte Garcia", "Trevor Jenkins", "Medical Equipment Technician");
        hd.addMember ("Charlotte Garcia", "Justin Flores", "Speech-Language Pathologist");
        hd.showPatient("Mason Moore");
        hd.showPatient("Michael Johnson");
        hd.removeMember("Michael Johnson", "Evan Hall");
        hd.showPatient("Michael Johnson");
        hd.showDoctorPatients("Olivia Sanchez");
        hd.showDoctorPatients("Emma Thompson");
        hd.showPatients(2022);
    }
}
