package objects;

import java.util.Arrays;

/**
 * Object for the residences
 * @residenceName name of the new added residence
 * @apartment list of all the apartments in the residence
 */
public class Residence {

    private String residenceName;
    private Apartment[] apartments = new Apartment[0];

    /**
     * Constructor for the Residence object
     * @param residenceName
     */
    public Residence(String residenceName) {
        this.residenceName = residenceName;
    }

    /**
     * Getter for the Residence name
     * @return
     */
    public String getResidenceName() {
        return residenceName;
    }

    /**
     * Setter for the residence name
     * @param residenceName
     */
    public void setResidenceName(String residenceName) {
        this.residenceName = residenceName;
    }

    /**
     * Getter for the apartment array
     * @return
     */
    public Apartment[] getApartments() {
        return apartments;
    }

    /**
     * Setter for the apartment
     * @param apartments
     */
    public void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }

    /**
     * Method to add a new apartment to the list
     * @param apartment
     */
    public void addApartment(Apartment apartment) {

        for (int i = 0; i < this.apartments.length-1; i++) {
            if (this.apartments[i] == null){
                this.apartments[i] = apartment;
                return;
            }
        }

        this.apartments = Arrays.copyOf(this.apartments, this.apartments.length+1);
        this.apartments[this.apartments.length - 1] = apartment;
    }


}
