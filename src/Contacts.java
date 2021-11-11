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
        Scanner userChoose = new Scanner(System.in);
        System.out.println("Enter ");
        //Let's make some new stuff - CREATING files and directories in JAVA
        String directory = "./src/data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        Path contactPath = Paths.get(directory, filename);

        //building the whole shebang! A path combining: the directory's path + the desired filename at the end :D

        if (Files.notExists(dataFile)) {
            Files.createFile(dataFile);
        }
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4, or 5):");
// Add scanner to give menu functionality
    int input = userChoose.nextInt();
        System.out.println(input);
    if (input == 1) {
        List<String> printList = Files.readAllLines(contactPath);
        for (int i = 0; i < printList.size(); i++) {
            System.out.println(printList.get(i));
        }
    } else if (input == 2) {
        userChoose.nextLine();
        System.out.println("Hey - what name would you like to add in?");
        String contactName = userChoose.nextLine();
        System.out.println("Thank you - what number is associated with that contact?");
        String contactNum = userChoose.nextLine();
        System.out.printf("Let's see what we got = %s %s", contactName, contactNum);

        Files.write(contactPath, Arrays.asList(contactName + " " + contactNum), StandardOpenOption.APPEND);
        List<String> contactList = Files.readAllLines(contactPath);

        contactList = Files.readAllLines(contactPath);

        System.out.println("contactList = " + contactList);
    } else if (input == 3){

    }
        //We got our tokens - a name and a num
//        System.out.println(dataFile);



//        System.out.println("contactPath = " + contactPath);
//        System.out.println("Files.exists(contactPath) = " + Files.exists(contactPath));

//        List<String> contactList = Arrays.asList("Name     |   Phone number", "-------------------------", "John A. | 210-212-1212", "Matthias H. | 909-022-7474", "Bernie S. | 310-333-8888", "Bosch L. | 444-444-44444");
//        System.out.println("contactList = " + contactList);
// commented out code to not have it overriding new contact
//        Files.write(contactPath, contactList);
        System.out.println();
        //Reading from the file
//        System.out.println("printList = " + printList);



//        Files.write(contactPath, Arrays.asList("Jose - 555-555-5555"), StandardOpenOption.APPEND);
//        System.out.println(contactList);


        List<String> newList = new ArrayList<>();

//
        System.out.println();

        //How to add scanner and add someone dynamically?  A mini application demo
        Scanner myScanner = new Scanner(System.in);




    }
}
