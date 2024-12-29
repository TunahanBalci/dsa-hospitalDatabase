//-----------------------------------------------------
// Title: CareTeamBST Class
// Author: Tunahan BALCI
// ID: 12865148094
// Section: 02
// Assignment: 3
// Description: Manages a binary search tree of care team members by their names in alphabetical order.
//-----------------------------------------------------
public class CareTeamBST {

    protected CareTeamNode root;

    /**
     * Inserts a CareTeamMember into the BST based on their name.
     * Overwrites existing member if the name matches.
     *
     * @param r The root node of the subtree to insert into.
     * @param m The care team member to insert.
     * @return The root node after insertion.
     */
    public CareTeamNode insert(CareTeamNode r, CareTeamMember m) {

        if (r == null){
            if (this.root == null){
                CareTeamNode inserted = new CareTeamNode(m);
                this.root = inserted;
                return this.root;
            }

            return new CareTeamNode(m);
        }

        int comparison = m.getName().compareTo(r.member.getName());
        if (comparison < 0) {
            r.left = insert(r.left, m);
        } else if (comparison > 0) {
            r.right = insert(r.right, m);
        } else {
            // Overwrite existing member
            r.member = m;
            System.out.println("ERROR: Member " + m.getName() + " overwritten ");
        }
        return r;
    }

    /**
     * Removes a CareTeamMember from the BST based on their name.
     *
     * @param r The root node of the subtree to remove from.
     * @param name The name of the member to remove.
     * @return The root node after removal.
     */
    public CareTeamNode remove(CareTeamNode r, String name) {
        if (r == null) return null;

        int comparison = name.compareTo(r.member.getName());
        if (comparison < 0) {
            r.left = remove(r.left, name);
        } else if (comparison > 0) {
            r.right = remove(r.right, name);
        } else {
            if (r.left == null && r.right == null) {
                return null;
            } else if (r.left == null) {
                return r.right;
            } else if (r.right == null) {
                return r.left;
            } else {
                CareTeamNode replacement = findMin(r.right);
                r.member = replacement.member;
                r.right = remove(r.right, replacement.member.getName());
            }
        }

        return r;
    }

    /**
     * Retrieves a CareTeamMember by name using recursive traversal.
     *
     * @param r The root node of the subtree to search.
     * @param name The name of the member to retrieve.
     * @return The CareTeamMember object if found; otherwise, null.
     */
    public CareTeamMember getMember(CareTeamNode r, String name) {
        if (r == null) {
            return null;
        }
        if (r.member.getName().equals(name)) {
            return r.member;
        }
        CareTeamMember found = getMember(r.left, name);
        if (found != null) {
            return found;
        }
        return getMember(r.right, name);
    }

    /**
     * Finds the node with the minimum name in the subtree.
     *
     * @param node The root node of the subtree.
     * @return The node with the minimum name.
     */
    private CareTeamNode findMin(CareTeamNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * Prints all care team members in ascending order by name.
     *
     * @param r The root node of the subtree to print.
     */
    public void printAll(CareTeamNode r) {
        if (r == null) return;

        printAll(r.left);
        System.out.println(r.member.getName() + ", " + r.member.getRole() + " "); // Trailing space
        printAll(r.right);
    }

}

//-----------------------------------------------------
// Title: CareTeamNode Class
// Author: Tunahan BALCI
// ID: 12865148094
// Section: 02
// Assignment: 3
// Description: Represents a node in the Care Team Binary Search Tree (BST).
//              Each node contains information about a care team member
//              and pointers to left and right child nodes.
//-----------------------------------------------------

class CareTeamNode {

    protected CareTeamNode left; // Pointer to the left child node.
    protected CareTeamNode right; // Pointer to the right child node.

    protected CareTeamMember member; // Care team member information stored in the node.

    /**
     * Constructor for CareTeamNode.
     *
     * @param m The care team member whose information is to be stored in the node.
     */
    public CareTeamNode(CareTeamMember m) {
        this.member = m;
    }
}
