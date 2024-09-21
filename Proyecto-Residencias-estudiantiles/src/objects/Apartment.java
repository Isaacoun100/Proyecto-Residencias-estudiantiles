package objects;
import objects.Student;

import java.util.Arrays;

/**
 * Object for the apartment
 * @apartmentName name of the apartment
 * @students list of the students associated to the apartment (Fixed size of 5)
 */
public class Apartment {

    private String apartmentName;
    private Student[] students = new Student[5];

    public Apartment(String apartmentName, Student[] students) {
        this.apartmentName = apartmentName;
        this.students = students;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

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
