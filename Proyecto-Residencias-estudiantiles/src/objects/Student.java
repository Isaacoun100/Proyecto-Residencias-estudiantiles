package objects;

/**
 * Object for the students
 * @name Is the name given to the new students
 * @apartment Name of the apartment that will be assigned to
 */
public class Student {

    public Student(String name, String apartment) {
        this.name = name;
        this.apartment = apartment;
    }

    private String name;
    private String apartment;

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
