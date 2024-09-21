package objects;

import java.util.Arrays;

/**
 * Object for the residences
 * @residenceName name of the new added residence
 * @apartment list of all the apartments in the residence
 */
public class Residence {

    private String residenceName;
    private Apartment[] apartments;

    public Residence(Apartment[] apartments, String residenceName) {
        this.apartments = apartments;
        this.residenceName = residenceName;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public void setResidenceName(String residenceName) {
        this.residenceName = residenceName;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }

    public void addApartment(Apartment apartment) {

        for (int i = 0; i < this.apartments.length; i++) {
            if (this.apartments[i] == null){
                this.apartments[i] = apartment;
                return;
            }
        }

        this.apartments = Arrays.copyOf(this.apartments, this.apartments.length+1);
        this.apartments[this.apartments.length - 1] = apartment;
    }


}
