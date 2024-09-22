package objects;

/**
 * Object for the students
 * @name Is the name given to the new students
 * @apartment Name of the apartment that will be assigned to
 */
public class Student {

    // The apartment string is not necessary at all, is added just to complete the idea
    private String name;
    private String apartment;

    /**
     * Constructor for the student object
     * @param name
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * Getter for the apartment
     * @return
     */
    public String getApartment() {
        return apartment;
    }

    /**
     * Setter for the apartment
     * @param apartment
     */
    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getName() {
        return name;
    }

    /**
     * Setter for the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
