//----------------------------------------------------- 
// Title: CareTeamMember Class
// Author: Tunahan BALCI
// ID: 12865148094
// Section: 02
// Assignment: 3 
// Description: Represents a medical staff member with a name and role.
//----------------------------------------------------- 

public class CareTeamMember {
    private String name;
    private String role;

    /**
     * Constructs a CareTeamMember with the specified name and role.
     *
     * @param name The first and last name of the medical staff member.
     * @param role The professional role of the medical staff member (e.g., Nurse, Anesthesiologist).
     */
    public CareTeamMember(String name, String role) {
        this.name = name;
        this.role = role;
    }

    /**
     * Retrieves the name of the medical staff member.
     *
     * @return The name of the member.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the professional role of the medical staff member.
     *
     * @return The role of the member.
     */
    public String getRole() {
        return role;
    }
}
