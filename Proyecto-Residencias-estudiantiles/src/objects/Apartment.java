package objects;
import objects.Student;

import java.util.Arrays;

/**
 * Object for the apartment
 * @apartmentName name of the apartment
 * @students list of the students associated to the apartment (Fixed size of 5)
 */
public class Apartment {

    //For future reference, a list would've made things much easier specially in this scenarios
    private String apartmentName;
    private Student[] students = new Student[5];

    /**
     * Constructor for the Apartment object
     * @param apartmentName
     */
    public Apartment(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    /**
     * Getter for the apartment name
     * @return
     */
    public String getApartmentName() {
        return apartmentName;
    }

    /**
     * Setter for the apartment name
     * @param apartmentName
     */
    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    /**
     * Getter for the student array
     * @return
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * Setter for the student array
     * @param students
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     * This method is to be able to add a new student without needing to use the setter every time
     * @param student
     * @return
     */
    public boolean addAStudents(Student student) {

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return true;
            }
        }
        return false;
    }
}
