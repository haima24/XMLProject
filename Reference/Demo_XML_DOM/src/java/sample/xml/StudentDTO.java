/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.xml;

import java.io.Serializable;

/**
 *
 * @author Tu
 */
public class StudentDTO implements Serializable {
    private String studentID;
    private String fullName;
    private String status;

    public StudentDTO() {
    }

    public StudentDTO(String studentID, String fullName, String status) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.status = status;
    }

    /**
     * @return the studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
