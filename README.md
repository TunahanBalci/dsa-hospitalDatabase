# Hospital Database System

---

## Overview
This project implements a **Hospital Database System** in Java using **Binary Search Trees (BST)**. The system efficiently manages patients and their associated care teams, providing functionalities to add, remove, and query data while maintaining sorted order. This implementation is modular, adhering to clean coding practices and assignment requirements.

---

## Features
1. **Patient Management**:
   - Add or remove patients based on a unique visit date (`YYYYMMDD`).
   - Overwrite existing patient records with duplicate names.

2. **Care Team Management**:
   - Maintain a care team for each patient in a separate BST.
   - Add or remove medical staff members sorted by their names.

3. **Queries**:
   - Retrieve patients by doctor.
   - Retrieve patients by year of visit.
   - Display detailed patient information and care team data.

4. **Sorting and Display**:
   - Patients are displayed in ascending order of their visit dates.
   - Care team members are listed alphabetically.

---

## Modules
The system is divided into modular components, each with a specific responsibility:

1. **HospitalDatabase**:
   - The main class managing patients and care teams.
   - User-facing functionalities:
     - `addPatient()`, `removePatient()`
     - `addMember()`, `removeMember()`
     - `showAllPatients()`, `showPatient()`
     - `showDoctorPatients()`, `showPatients()`

2. **PatientBST**:
   - Implements the patient BST with methods for insertion, deletion, and querying.

3. **CareTeamBST**:
   - Handles care team data as a separate BST for each patient.

4. **Utility Classes**:
   - `PatientNode`: Represents nodes in the patient BST.
   - `CareTeamNode`: Represents nodes in the care team BST.
   - `LoopCounter`: A utility for tracking loop iterations during queries.

---

## Usage
1. **Adding a Patient**:
   ```java
   HospitalDatabase hd = new HospitalDatabase();
   hd.addPatient("Michael Johnson", "Emma Thompson", 19, 12, 2022);
   ```

2. **Adding a Care Team Member**:
   ``` java
    hd.addMember("Michael Johnson", "Jack Allen", "Patient Care Technician");
   ```

3. **Querying Patients by Doctor**:
   ``` java
   hd.showDoctorPatients("Emma Thompson");
   ```

4. **Querying Patients by Visit Year**:
   ```java
   hd.showDoctorPatients("Emma Thompson");
   ```

## Sample Output
   ```text
    INFO: Patient Michael Johnson has been added
    INFO: Patient Ethan Lee has been added
    INFO: Patient Noah Miller has been added
    
    Michael Johnson, 2022, Emma Thompson
    Ethan Lee, 2020, Olivia Sanchez
    Noah Miller, 2019, Olivia Sanchez
    
    Emma Thompson
    Michael Johnson, 19/12/2022
   ```

---

## Design Rationale

**Binary Search Tree (BST):** Enables efficient insertion, deletion, and retrieval of patients and care team members.
**Modular Design:** Ensures clean separation of concerns, making the code easy to maintain and extend.
**Unique Keys:** Patients are identified by a unique key based on their visit date (YYYYMMDD), ensuring proper sorting and ordering.

---

## How to Run

1. **Clone this repository:**
   ``` git
   git clone https://github.com/your-repo/hospital-database-system.git
   ```
2. **Compile all Java files**
3. **Run The Tester Class**




   

