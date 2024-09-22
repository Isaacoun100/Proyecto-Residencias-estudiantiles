import objects.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //It was not explicitly specified in the project requirements how the user was going to be able to interact
        //with the program so a CLI is being implemented.

        // Scanner to read the values
        Scanner scanner = new Scanner(System.in);

        // This is the list of residences that we will use in the program
        Residence[] residences = new Residence[0];

        // Main loop for the CLI
        while (true) {

            // Welcome message
            System.out.println("Welcome to the Residence administration software \n" +
                    "Press 1 to add a Residence \n" +
                    "Press 2 to add an Apartment \n" +
                    "Press 3 to add a Student \n" +
                    "Press 4 to list all Residences \n" +
                    "Press 5 to list all Apartments \n" +
                    "Press 6 to list all Students \n" +
                    "Press 7 to load example \n");

            String menu = scanner.nextLine();

            switch (menu){
                case "1":

                    System.out.println("Please input the residence name");
                    String residenceName = scanner.nextLine();

                    // If there is no other residence with the same name it add is, else it sends an alert
                    if(checkResidence(residenceName, residences)){

                        // Instances an object that will be added to the array
                        Residence residence = new Residence(residenceName);

                        // This is an old trick to manually relocate the array size, once again
                        // this would have been so much easier if I had used a List<>
                        residences = Arrays.copyOf(residences, residences.length+1);
                        residences[residences.length-1] = residence;
                    }
                    else
                        System.out.println("Residence already exists");

                    break;

                case "2":

                    System.out.println("Please input the apartment name");
                    String apartmentName = scanner.nextLine();

                    // Checks if there is no apartments with sane name, else it warns the user
                    if(checkApartment(apartmentName, residences)){

                        System.out.println("Please select the residence where it belongs");
                        listResidences(residences);
                        String selectedResidence = scanner.nextLine();

                        // Here au contraire we check that the residence name exists to be able to add it
                        if(!checkResidence(selectedResidence, residences)){

                            // The new apartment is instanced
                            Apartment newApartment = new Apartment(apartmentName);

                            // Goes through all the elements in residences and add the apartment to the
                            // one we specified earlier
                            for(Residence residence : residences){
                                if(residence.getResidenceName().equals(selectedResidence)){
                                    residence.addApartment(newApartment);
                                    break;
                                }
                            }
                        }
                        else{
                            System.out.println("Residence does not exist");
                        }
                        break;

                    }
                    else
                        System.out.println("Apartment already exists");
                    break;

                case "3":

                    System.out.println("Please input the student name");
                    String studentName = scanner.nextLine();

                    // Checks if the students is not in the list, else it prompt us
                    if(checkStudent(studentName, residences)){

                        System.out.println("Please select the residence where it belongs");
                        listApartments(residences);
                        String selectedApartment = scanner.nextLine();

                        // If the apartment matches then it continues, else it warns the user
                        if(!checkApartment(selectedApartment, residences)){

                            // We go through all the residences to find the one we need
                            for(Residence residence : residences)

                                // Now we go through all the apartments
                                for (Apartment apartment : residence.getApartments())

                                    // When we find the apartment we try to see if its the same we looked for
                                    if(apartment.getApartmentName().equals(selectedApartment)) {

                                        // If the apartment is valid then it adds it, else it sends an alert
                                        if (apartment.addAStudents(new Student(studentName)))
                                            System.out.println("Student added");
                                        else System.out.println("Student not added");

                                        break;
                                    }
                        }
                        else System.out.println("Apartment already exists");
                    }
                    else System.out.println("Student already exists");
                    break;

                case "4":
                    // Lists the residences we have in the system
                    listResidences(residences);
                    break;

                case "5":
                    // Lists the apartments we have in the Residences
                    listApartments(residences);
                    break;

                case "6":
                    //Lists the students in the apartments
                    listStudents(residences);
                    break;

                case "7":
                    // Loads an example of how the classes look when filed
                    residences = loadExample(residences);

                default:
                    System.out.println("Invalid option");
            }

        }


    }

    /**
     * Checks if the Residence exists in the list
     * @param residence The name to find
     * @param residences The residences list
     * @return a boolean value that indicates if we found the value or not
     */
    public static boolean checkResidence(String residence, Residence[] residences){

        // Just iterates on all values in residence and if finds it, it returns a boolean
        for(Residence thisResidence : residences)
            if(thisResidence.getResidenceName().equals(residence))
                return false;

        return true;
    }

    /**
     * Checks if the Residence exists in the list
     * @param apartment The name to find
     * @param residences The residences list
     * @return a boolean value that indicates if we found the value or not
     */
    public static boolean checkApartment(String apartment, Residence[] residences){

        // Just iterates on all values in residence and if finds it, it returns a boolean
        for(Residence thisResidence : residences)
            for(Apartment thisApartment : thisResidence.getApartments())
                if(thisApartment.getApartmentName().equals(apartment))
                    return false;
        return true;

    }

    /**
     * Checks if the student is in the list or not
     * @param student The name to find
     * @param residences The residences list
     * @return a boolean value that indicates if we found the value or not
     */
    public static boolean checkStudent(String student, Residence[] residences){

        // First we look through the residences
        for(Residence thisResidence : residences)

            // Then we look through the apartments
            for(Apartment thisApartment : thisResidence.getApartments())

                // Now we see if any of the students match the value, I had to use the conventional for
                // because there was some null values and plus it reduced the iterations
                for (int i = 0; i < thisApartment.getStudents().length; i++) {

                    // Using a try catch to evade the cases where there could be a NullPointerException
                    try{
                        if(thisApartment.getStudents()[i].getName().equals(student))
                            return true;
                    }

                    catch (Exception NullPointerException){
                        break;
                    }
                }
        return true;
    }

    /**
     * Prints all the Residences available
     * @param residences the list to print from
     */
    public static void listResidences( Residence[] residences ){
        for (Residence residence : residences) {
            System.out.println(residence.getResidenceName());
        }
    }


    /**
     * Lists all the apartments in the residences
     * @param residences list to print from
     */
    public static void listApartments( Residence[] residences ){
        for (Residence residence : residences)
            for(Apartment apartment : residence.getApartments())
                System.out.println(apartment.getApartmentName());
    }

    /**
     * Lists all the apartments in the residences
     * @param residences list to print from
     */
    public static void listStudents( Residence[] residences ){

        for (Residence residence : residences)
            for(Apartment thisApartment : residence.getApartments())
                for (int i = 0; i < thisApartment.getStudents().length; i++){
                    try{
                        System.out.println(thisApartment.getStudents()[i].getName());
                    }

                    catch(Exception NullPointerException){
                        break;
                    }
                }

    }

    /**
     * Method to load an example value to test the code
     * @param residences the list to add the values to
     * @return the new list with all the new values
     */
    public static Residence[] loadExample(Residence[] residences){

        Residence firstResidence = new Residence("Main entrance");
        Residence secondResidence = new Residence("Secondary entrance");
        Residence thirdResidence = new Residence("Third entrance");
        Residence fourthResidence = new Residence("Fourth entrance");

        firstResidence.addApartment( new Apartment( "aApartment" ));
        firstResidence.addApartment( new Apartment( "bApartment" ));
        firstResidence.addApartment( new Apartment( "cApartment" ));
        firstResidence.addApartment( new Apartment( "dApartment" ));

        secondResidence.addApartment( new Apartment( "eApartment" ));
        secondResidence.addApartment( new Apartment( "fApartment" ));
        secondResidence.addApartment( new Apartment( "gApartment" ));
        secondResidence.addApartment( new Apartment( "hApartment" ));

        thirdResidence.addApartment( new Apartment( "iApartment" ));
        thirdResidence.addApartment( new Apartment( "jApartment" ));
        thirdResidence.addApartment( new Apartment( "kApartment" ));
        thirdResidence.addApartment( new Apartment( "lApartment" ));

        fourthResidence.addApartment( new Apartment( "mApartment" ));
        fourthResidence.addApartment( new Apartment( "nApartment" ));
        fourthResidence.addApartment( new Apartment( "oApartment" ));
        fourthResidence.addApartment( new Apartment( "pApartment" ));

        firstResidence.getApartments()[0].addAStudents( new Student( "Student a" ) );
        firstResidence.getApartments()[1].addAStudents( new Student( "Student b" ) );
        firstResidence.getApartments()[2].addAStudents( new Student( "Student c" ) );
        firstResidence.getApartments()[3].addAStudents( new Student( "Student d" ) );

        secondResidence.getApartments()[0].addAStudents( new Student( "Student f" ) );
        secondResidence.getApartments()[1].addAStudents( new Student( "Student g" ) );
        secondResidence.getApartments()[2].addAStudents( new Student( "Student h" ) );
        secondResidence.getApartments()[3].addAStudents( new Student( "Student i" ) );

        thirdResidence.getApartments()[0].addAStudents( new Student( "Student k" ) );
        thirdResidence.getApartments()[1].addAStudents( new Student( "Student l" ) );
        thirdResidence.getApartments()[2].addAStudents( new Student( "Student m" ) );
        thirdResidence.getApartments()[3].addAStudents( new Student( "Student n" ) );

        fourthResidence.getApartments()[0].addAStudents( new Student( "Student p" ) );
        fourthResidence.getApartments()[1].addAStudents( new Student( "Student q" ) );
        fourthResidence.getApartments()[2].addAStudents( new Student( "Student r" ) );
        fourthResidence.getApartments()[3].addAStudents( new Student( "Student s" ) );

        residences = Arrays.copyOf(residences, 4);

        residences[0] = firstResidence;
        residences[1] = secondResidence;
        residences[2] = thirdResidence;
        residences[3] = fourthResidence;

        return residences;

    }

}
