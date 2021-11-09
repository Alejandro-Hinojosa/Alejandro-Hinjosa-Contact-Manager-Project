package util;

import java.util.Scanner;

public class Input {
    private Scanner scanner; // STEP 1 - from curriculum 'has private property named scanner'
    //adding the above 'Scanner' class will require you to 'import java.util.Scanner' which can be done by clicking 'Scanner'

    //below is a constructor
    // STEP 3
    //from the curriculum 'When an instance of this object is created, the scanner field should be set to a new instance of the Scanner class.'
    //that just means we need to make a constructor, which we make to create an INSTANCE
    public Input() {
        scanner = new Scanner(System.in); //THIS is a new instance. Curriculum says 'the scanner field should be set to a new instance of the Scanner class'
    }

    public String getString() { //this is a method
        System.out.printf("Enter a string:"); // this could also be asked in the InputTest Java class
        return this.scanner.nextLine(); // I DONT KNOW WHY SHAN DID THIS BUT SHE SAID AT LEAST THE ERROR GOES AWAY
    }

    public boolean yesNo() { //this is a method
        //from curriculum 'The yesNo method should return true if the user enters y, yes, or variants thereof, and false otherwise.'
        String userInput = scanner.nextLine(); //This stores the userInput into the variable cuz it compares with y/yes
        return userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes");
    }

    public int getInt(int min, int max) { //this is a method. THIS getINT and the one below are considers method overloading cuz they have different amounts of parameters, and usually the ones with the most parameters are below the one with the least
        //FROM CURRICULUM - The getInt(int min, int max) method should keep prompting the user for input until they give an integer within the min and max.
        int userInt; // STEP 3**
        do { // STEP 5**
            System.out.printf("Enter a number between %d and %d: %n", min, max); // for this method this was STEP 1**
            userInt = scanner.nextInt(); // STEP 2**
        } while (userInt > max || userInt < min);// STEP 6**
        return userInt;  // STEP 4**
    }


//   public int getInt() { //this is a method
//       System.out.println("Enter a integer:");
//        return this.scanner.nextInt();
//       //Integer.valueOf(String s);
//   }

    public int getInt() { //this is a method
        String userInput = getString(); //
        try {
            Integer.valueOf(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Enter a NUMBER");
            return getInt();
        }
        return Integer.valueOf(userInput);
//        return Integer.parseInt(userInput); THIS IS RECOMMENDED BY IntelliJ
    }

//public static void main(String[] args) {
//    String indentationPreference;
//    try {
//        indentationPreference = getIndentationPreference();
//        System.out.println("Okay, " + indentationPreference + " is a great choice.");
//    } catch (Exception e) {
//        System.out.println("Uh oh, something went wrong: " + e.getMessage());
//        System.out.println("Here is some more detail:");
//        e.printStackTrace();
//    }
//}
    //Your getInt and getDouble methods should make sure that the value returned from the method is actually an int or a double. You can do this by replacing the use of the Scanner nextInt() and nextDouble() methods with the existing getString() method you created in a previous exercise using the following methods to convert the returned String into the desired datatype:
    //Integer.valueOf(String s);
    //Double.valueOf(String s);

    double getDouble(double min, double max) { //this is a method
        Double userDouble;
        do {
            System.out.printf("Enter a decimal number between %f and %f: %n", min, max); //we use %f for DOUBLES!!!!!!
            userDouble = scanner.nextDouble();
        } while (userDouble > max || userDouble < min);
        return userDouble;
    }

    public double getDouble() { //this is a method
//        return scanner.nextDouble();

        String userDouble = getString();
        try {
            Double.valueOf(userDouble);
        } catch (NumberFormatException e) {
            System.out.println("Enter a NUMBER");
            return getInt();
        }
        return Double.valueOf(userDouble);
    }

    public double getDouble(String prompt) {
        double number;
        try {
            number = Double.valueOf(getString());
            return number;
        } catch (NumberFormatException nfe) {
            System.out.println("Wrong type of number input");
            return getDouble(prompt);
        }
    }

}
