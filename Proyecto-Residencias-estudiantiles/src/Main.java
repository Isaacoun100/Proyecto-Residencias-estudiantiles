import objects.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //It was not explicitly specified in the project requirements how the user was going to be able to interact
        //with the program so a CLI is being implemented.

        Scanner scanner = new Scanner(System.in);

        Residence[] residences = new Residence[0];

        while (true) {
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

                    if(checkResidence(residenceName, residences)){

                        Residence residence = new Residence(residenceName);
                        residences = Arrays.copyOf(residences, residences.length+1);

                        residences[residences.length-1] = residence;
                    }
                    else
                        System.out.println("Residence already exists");

                    break;

                case "2":

                    System.out.println("Please input the apartment name");
                    String apartmentName = scanner.nextLine();

                    if(checkApartment(apartmentName, residences)){

                        System.out.println("Please select the residence where it belongs");
                        listResidences(residences);
                        String selectedResidence = scanner.nextLine();

                        if(!checkResidence(selectedResidence, residences)){

                            Apartment newApartment = new Apartment(apartmentName);

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

                    if(checkStudent(studentName, residences)){
                        System.out.println("Please select the residence where it belongs");
                        listApartments(residences);
                        String selectedApartment = scanner.nextLine();

                        if(!checkApartment(selectedApartment, residences)){
                            for(Residence residence : residences)
                                for (Apartment apartment : residence.getApartments())
                                    if(apartment.getApartmentName().equals(selectedApartment)) {
                                        boolean addedStudent = apartment.addAStudents(new Student(studentName));

                                        if (addedStudent)
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
                    listResidences(residences);
                    break;

                case "5":
                    listApartments(residences);
                    break;

                case "6":
                    listStudents(residences);
                    break;

                case "7":
                    residences = loadExample(residences);

                default:
                    System.out.println("Invalid option");
            }

        }


    }


    public static boolean checkResidence(String residence, Residence[] residences){

        for(Residence thisResidence : residences)
            if(thisResidence.getResidenceName().equals(residence))
                return false;

        return true;
    }

    public static boolean checkApartment(String apartment, Residence[] residences){

        for(Residence thisResidence : residences)
            for(Apartment thisApartment : thisResidence.getApartments())
                if(thisApartment.getApartmentName().equals(apartment))
                    return false;
        return true;

    }

    public static boolean checkStudent(String student, Residence[] residences){

        for(Residence thisResidence : residences)
            for(Apartment thisApartment : thisResidence.getApartments())
                for (int i = 0; i < thisApartment.getStudents().length; i++) {
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

    public static void listResidences( Residence[] residences ){
        for (Residence residence : residences) {
            System.out.println(residence.getResidenceName());
        }
    }

    public static void listApartments( Residence[] residences ){
        for (Residence residence : residences)
            for(Apartment apartment : residence.getApartments())
                System.out.println(apartment.getApartmentName());
    }

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
