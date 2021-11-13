import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLOutput;
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
        boolean confirm;
        Scanner bob = new Scanner(System.in);
        do{
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
//        System.out.println(input);
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
        System.out.print("Do you want to add another number: [Y/N]");

//        Input in = new Input(); //Use your Input class to get input from the user, and display information based on their choice. (Remember to import your Input class)
//        String userChoose = in.getString();
//        Scanner userChoose = new Scanner(System.in);


        Files.write(contactPath, Arrays.asList(contactName + " " + contactNum), StandardOpenOption.APPEND);
        List<String> contactList = Files.readAllLines(contactPath);

        contactList = Files.readAllLines(contactPath);

        System.out.println("contactList = " + contactList);


        //TODO///////////////////////// TODO SEARCH CONTACTS///////////////////////////

    } else if (input == 3){
        List<String> printList = Files.readAllLines(contactPath);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter your contact name that you would like to search for.");
        String userSearch = myScanner.nextLine();
        System.out.println(userSearch);
//        System.out.println(printList);

        String reply = "";
        for(int i = 0; i < printList.size(); i++) {

            if (printList.get(i).contains(userSearch)) {
                reply = "We found your contact in our list!";
//                break;
            } else {
                reply = "Unfortunately we did not find your contact in our list.";
            }
        }
            System.out.println(reply);




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
            System.out.println("");
//friendsList.removeIf(friend -> friend.getName().equals(name));
            System.out.println(" ");
            System.out.println("Choose name to delete: ");
            String name = userDelete.nextLine();

            for (String line : printList) {
                if (line.toLowerCase().contains(name.toLowerCase())) {
                    continue;
                }
                newList.add(line);
                Files.write(contactPath, newList);
                System.out.println("The contact " + name + " has been removed!");
            }
        //todo            System.out.print("Do you want to continue to talk Bob: [Y/N]");
//            confirm = bob.next().equalsIgnoreCase(("y"));
//            bob.nextLine();
//        } while(confirm);

//
//        }


    }


    ///////////////////////// EXIT PAGE///////////////////////////

    else if (input == 5) {
            System.out.println("You have exited the contacts app");
        }

            System.out.print("Do you want to continue: [Y/N]");
            confirm = bob.next().equalsIgnoreCase(("y"));
            bob.nextLine();
        } while(confirm);


    }
}

