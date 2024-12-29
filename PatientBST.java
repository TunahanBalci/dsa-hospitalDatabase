//-----------------------------------------------------
// Title: CareTeamBST Class
// Author: Tunahan BALCI
// ID: 12865148094
// Section: 02
// Assignment: 3
// Description: Manages a binary search tree of patients ordered by visit date.
//-----------------------------------------------------

public class PatientBST {

    protected PatientNode root;

    /**
     * Prints all patients in ascending order based on their keys (visit dates).
     * Uses in-order traversal: Left, Root, Right.
     *
     * @param r The root node of the subtree to print.
     */
    public void printAll(PatientNode r) {
        if(r == null) return;

        printAll(r.left); // Traverse left subtree
        System.out.println(r.patient.getName() + ", " + r.patient.getVisitDate_year() + ", " + r.patient.getDoctorName() + " "); // Trailing space
        printAll(r.right); // Traverse right subtree
    }

    /**
     * Prints all patients who visited in a specific year in descending order.
     * Uses reverse in-order traversal: Right, Root, Left.
     *
     * @param r The root node of the subtree to print.
     * @param year The specific year to filter patients.
     */
    public void printYear(PatientNode r, int year) {
        if (r == null) {
            return; // Base case: the node is null
        }

        printYear(r.right, year); // Traverse right subtree first for descending order
        if (r.patient.getVisitDate_year() == year) {
            System.out.println(r.patient.getName() + ", " + r.patient.getVisitDate_day() + "/" + r.patient.getVisitDate_month() + " "); // Trailing space
        }
        printYear(r.left, year); // Traverse left subtree
    }

    /**
     * Retrieves a patient by name using recursive traversal.
     * Note: Since the BST is ordered by visit date, not name, this method performs a full traversal.
     *
     * @param r The root node of the subtree to search.
     * @param name The name of the patient to retrieve.
     * @return The Patient object if found; otherwise, null.
     */
    public Patient getPatient(PatientNode r, String name) {
        if (r == null) {
            return null; // Base case: the node is null
        }

        // Check if current node matches
        if (r.patient.getName().equals(name)) {
            return r.patient;
        }

        // Search in the left subtree
        Patient foundInLeft = getPatient(r.left, name);
        if (foundInLeft != null) {
            return foundInLeft;
        }

        // Search in the right subtree
        return getPatient(r.right, name);
    }

    /**
     * Displays all patients assigned to a specific doctor.
     *
     * @param r The root node of the subtree to search.
     * @param name The name of the doctor.
     * @param lc A LoopCounter to track the number of patients found.
     */
    public void showDoctorPatients(PatientNode r, String name, LoopCounter lc) { // r = root
        if (r == null) {
            return; // Base case: terminate recursion
        }

        if (r.patient.getDoctorName().equals(name)) { // Use .equals() for string comparison
            lc.count++;
            System.out.println(r.patient.getName() + ", " + r.patient.getVisitDate_day() + "/" + r.patient.getVisitDate_month() + "/" + r.patient.getVisitDate_year() + " "); // Trailing space
        }

        showDoctorPatients(r.left, name, lc);
        showDoctorPatients(r.right, name, lc);
    }

    /**
     * Inserts a patient into the BST based on their key (visit date).
     * Overwrites existing patient if key matches.
     *
     * @param r The root node of the subtree to insert into.
     * @param p The patient to insert.
     * @return The root node after insertion.
     */
    public PatientNode insert(PatientNode r, Patient p) { // r = root
        if (r == null) {
            if (this.root == null) {
                PatientNode inserted = new PatientNode(p);
                this.root = inserted;
                return this.root;
            }

            return new PatientNode(p);
        }

        int newKey = PatientNode.getKey(p);
        if (newKey < r.key) {
            r.left = insert(r.left, p);
        } else if (newKey > r.key) {
            r.right = insert(r.right, p);
        } else {
            // Handle duplicate keys by overwriting
            r.patient = p;
            System.out.println("ERROR: Patient " + p.getName() + " overwritten ");
        }

        return r;
    }

    /**
     * Removes a patient from the BST based on their name.
     *
     * @param r The root node of the subtree to remove from.
     * @param patientName The name of the patient to remove.
     * @return The root node after removal.
     */
    public PatientNode remove(PatientNode r, String patientName) {
        if (r == null) return null;

        Patient targetPatient = getPatient(r, patientName);
        if (targetPatient == null) {
            return r; // Patient not found
        }

        int targetKey = PatientNode.getKey(targetPatient);

        if (targetKey < r.key) {
            r.left = remove(r.left, patientName);
        } else if (targetKey > r.key) {
            r.right = remove(r.right, patientName);
        } else {
            // Node to be deleted found
            if (r.left == null && r.right == null) {
                return null;
            } else if (r.left == null) {
                return r.right;
            } else if (r.right == null) {
                return r.left;
            } else {
                PatientNode replacement = findMin(r.right);
                r.patient = replacement.patient;
                r.key = replacement.key;
                r.right = remove(r.right, replacement.patient.getName());
            }
        }

        return r;
    }

    /**
     * Finds the node with the minimum key (earliest visit date) in the subtree.
     *
     * @param node The root node of the subtree.
     * @return The node with the minimum key.
     */
    private PatientNode findMin(PatientNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}

//-----------------------------------------------------
// Title: PatientNode Class
// Author: Tunahan BALCI
// ID: 12865148094
// Section: 02
// Assignment: 3
// Description: Represents a node in the Patient Binary Search Tree (BST).
//              Each node contains a patient, a unique key based on the visit date,
//              and pointers to left and right child nodes.
//-----------------------------------------------------

class PatientNode {

    protected int key; // Unique key for the patient based on their visit date.
    protected Patient patient; // Patient information stored in the node.

    protected PatientNode left; // Pointer to the left child node.
    protected PatientNode right; // Pointer to the right child node.

    protected CareTeamBST careTeamBST; // BST for the patient's care team.

    /**
     * Constructor for PatientNode.
     *
     * @param p The patient whose information is to be stored in the node.
     */
    public PatientNode(Patient p) {
        this.patient = p;
        this.key = getKey(p); // Generate a unique key based on the patient's visit date.
        careTeamBST = new CareTeamBST(); // Initialize the care team BST for the patient.
    }

    /**
     * Generates a unique key for the patient based on their visit date.
     * The key is calculated as YYYYMMDD to ensure uniqueness and proper ordering.
     *
     * @param p The patient for whom to generate the key.
     * @return An integer key representing the patient's visit date.
     */
    public static int getKey(Patient p) {
        // Generate a unique key based on visit date: YYYYMMDD
        return (p.getVisitDate_year() * 10000) + (p.getVisitDate_month() * 100) + p.getVisitDate_day();
    }
}

