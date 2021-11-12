import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Contacts {

    public static void main(String[] args) throws IOException {
//        Scanner userChoose = new Scanner(System.in);
        System.out.println("Select an option from below:");

        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4, or 5):");

//        Input in = new Input(); //Use your Input class to get input from the user, and display information based on their choice. (Remember to import your Input class)
//        String userChoose = in.getString();
        Scanner userChoose = new Scanner(System.in);
        String userNumbers = userChoose.nextLine();
        if (userNumbers.equals("5")) {
            System.out.println("You have exited the contacts app");


//        } else if (userChoice.equals("1")) {
//            Movie[] movieList = findAll(); //THIS grabs from the 'MovieArray.java' and assigns it to a variable. 'findAll' was immediately available so we had to import it. 'findAll' returns the MoviesArray of all the movies. We store it in a variable for the first option "1".
//            for (Movie allMovie : movieList) {
//                System.out.println(allMovie.getName() + " -- " + allMovie.getCategory());
            }

        //Let's make some new stuff - CREATING files and directories in JAVA
        String directory = "./src/data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        //building the whole shebang! A path combining: the directory's path + the desired filename at the end :D

//        System.out.println(dataFile);

        if (Files.notExists(dataFile)) {
            Files.createFile(dataFile);
        }

        Path contactPath = Paths.get(directory, filename);

//        System.out.println("contactPath = " + contactPath);
//        System.out.println("Files.exists(contactPath) = " + Files.exists(contactPath));

        List<String> contactList = Arrays.asList("John - 210-212-12122", "Matthias - 909-022-7474");
//        System.out.println("contactList = " + contactList);

        Files.write(contactPath, contactList);
        System.out.println();
        //Reading from the file
        List<String> printList = Files.readAllLines(contactPath);
//        System.out.println("printList = " + printList);

        for (int i = 0; i < printList.size(); i++) {
            System.out.println("this = " + (i + 1) + ": " + printList.get(i));
        }

        Files.write(contactPath, Arrays.asList("Jose - 555-555-5555"), StandardOpenOption.APPEND);
//        System.out.println(contactList);


        contactList = Files.readAllLines(contactPath);
        List<String> newList = new ArrayList<>();

//        for (String line : contactList) {
//            if (line.equalsIgnoreCase("John")) {
//                newList.add("Joe");
//                continue;
//            }
//            newList.add(line);
//        }
//        System.out.println("newList = " +newList);


//        System.out.println("contactList" + contactList);

        System.out.println();

        //How to add scanner and add someone dynamically?  A mini application demo
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Hey - what name would you like to add in?");
        String contactName = myScanner.nextLine();
        System.out.println("Thank you - what number is associated with that contact?");
        String contactNum = myScanner.nextLine();
        System.out.printf("Let's see what we got = %s %s", contactName, contactNum);

        Files.write(contactPath, Arrays.asList(contactName + " " + contactNum), StandardOpenOption.APPEND);
        contactList = Files.readAllLines(contactPath);

        System.out.println("contactList = " + contactList);

        //We got our tokens - a name and a num


    }
}
