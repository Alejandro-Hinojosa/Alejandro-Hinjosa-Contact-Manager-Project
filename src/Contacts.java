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
        Scanner userChoose = new Scanner(System.in);
        Scanner userDelete = new Scanner(System.in);
        System.out.println("Enter ");
        //Let's make some new stuff - CREATING files and directories in JAVA
        String directory = "./src/data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        Path contactPath = Paths.get(directory, filename);
        Path contactPathRemove = Paths.get(directory, filename);



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

        ///////////////////////// VIEW CONTACTS///////////////////////////

        int input = userChoose.nextInt();
        System.out.println(input);
    if (input == 1) {
        List<String> printList = Files.readAllLines(contactPath);
        for (int i = 0; i < printList.size(); i++) {
            System.out.println(printList.get(i));
        }

        ///////////////////////// ADD CONTACTS///////////////////////////

    } else if (input == 2) {
        userChoose.nextLine();
        System.out.println("Hey - what name would you like to add in?");
        String contactName = userChoose.nextLine();
        System.out.println("Thank you - what number is associated with that contact?");
        String contactNum = userChoose.nextLine();
        System.out.printf("Let's see what we got = %s %s", contactName, contactNum);

//        Input in = new Input(); //Use your Input class to get input from the user, and display information based on their choice. (Remember to import your Input class)
//        String userChoose = in.getString();
//        Scanner userChoose = new Scanner(System.in);


        Files.write(contactPath, Arrays.asList(contactName + " " + contactNum), StandardOpenOption.APPEND);
        List<String> contactList = Files.readAllLines(contactPath);

        contactList = Files.readAllLines(contactPath);

        System.out.println("contactList = " + contactList);




        //TODO///////////////////////// TODO SEARCH CONTACTS///////////////////////////

//    } else if (input == 3){
//
//    }
//        We got our tokens - a name and a num
//        System.out.println(dataFile);

        ///////////////////////// DELETE CONTACTS///////////////////////////

    } else if (input == 4) {
        List<String> printList = Files.readAllLines(contactPath);
//        for (int i = 0; i < printList.size(); i++) {
            for (String showList : printList) {
            System.out.println(showList);

        }
            ArrayList<String> newList = new ArrayList<>();
//friendsList.removeIf(friend -> friend.getName().equals(name));
            System.out.println("");
            System.out.println("Choose name to delete: ");

//        userDelete.nextLine();
            String name = userDelete.nextLine();

            for (String line : printList) {
                if (line.toLowerCase().contains(name.toLowerCase())) {
                    continue;
                }
                newList.add(line);
                Files.write(contactPath, newList);
                System.out.println("The contact " + name + " has been removed!");
            }
        }


//        if(name.equals(printList))
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



        ///////////////////////// EXIT PAGE///////////////////////////

        String userNumbers = userChoose.nextLine();
        if (userNumbers.equals("5")) {
            System.out.println("You have exited the contacts app");
        }


    }
}

