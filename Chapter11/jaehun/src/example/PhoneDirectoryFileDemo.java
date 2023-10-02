package Chapter11.jaehun.src.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneDirectoryFileDemo {
    private static String DATA_FILE_NAME = ".phone_book_demo";

    public static void main(String[] args) {
        String name, number;

        TreeMap<String, String> phoneBook = new TreeMap<>();

        File userHomeDirectory = new File(System.getProperty("user.home"));
        File dataFile = new File(userHomeDirectory, DATA_FILE_NAME);

        if (!dataFile.exists()) {
            System.out.println("No phone book data file found. A new one");
            System.out.println("will be created, if you add any entries.");
            System.out.println("File name : " + dataFile.getAbsolutePath());
        } else {
            System.out.println("Reading phone book data...");
            try (Scanner scanner = new Scanner(dataFile)) {
                while (scanner.hasNextLine()) {
                    String phoneEntry = scanner.nextLine();
                    int separatorPosition = phoneEntry.indexOf('%');
                    if (separatorPosition == -1) {
                        throw new IOException("File is not a phonebook data file.");
                    }

                    name = phoneEntry.substring(0, separatorPosition);
                    number = phoneEntry.substring(separatorPosition + 1);
                    phoneBook.put(name, number);
                }
            } catch (IOException e) {
                System.out.println("Error in phone book data file.");
                System.out.println("File name : " + dataFile.getAbsolutePath());
                System.out.println("This program cannot continue");
                System.exit(1);
            }
        }

        Scanner in = new Scanner(System.in);
        boolean changed = false;

        mainLoop: while (true) {
            System.out.println("\nSelect the action that you want to perform");
            System.out.println("\t 1. Loot up a phone number.");
            System.out.println("\t 2. Add or change a phone number.");
            System.out.println("\t 3. Remove an entry from your phone directory.");
            System.out.println("\t 4. List the entire phone directory.");
            System.out.println("\t 5. Exit from the program.");
            System.out.print("Enter action number (1-5): ");

            int command;
            if (in.hasNextInt()) {
                command = in.nextInt();
                in.nextLine();
            } else {
                System.out.println("\nILLEGAL RESPONSE. YOU MUST ENTER A NUMBER.");
                in.nextLine();
                continue;
            }

            switch (command) {
                case 1:
                    System.out.print("\nEnter the name whose number you want to look up: ");
                    name = in.nextLine().trim().toLowerCase();
                    number = phoneBook.get(name);

                    if (number == null) {
                        System.out.println("\nSORRY, NO NUMBER FOUND FOR " + name);
                    } else {
                        System.out.println("\nNUBMER FOR " + name + ": " + number);
                    }
                    break;
                case 2:
                    System.out.print("\nEnter the name: ");
                    name = in.nextLine().trim().toLowerCase();

                    if(name.length() == 0) {
                        System.out.println("\nNAME CANNOT BE BLANK.");
                    } else if(name.indexOf('%') >= 0) {
                        System.out.println("\nNAME CANNOT CONTAIN THE CHARACTER \"%\".");
                    } else {
                        System.out.print("Enter phone number: ");
                        number = in.nextLine().trim();

                        if(number.length() == 0) {
                            System.out.println("\nPHONE NUMBER CANNOT BE BLANK.");
                        } else {
                            phoneBook.put(name, number);
                            changed = true;
                        }
                    }
                    break;
                case 3:
                    System.out.print("\nEnter the name whose entry you want to remove: ");
                    name = in.nextLine().trim().toLowerCase();
                    number = phoneBook.get(name);
                    if (number == null)
                        System.out.println("\nSORRY, THERE IS NO ENTRY FOR " + name);
                    else {
                        phoneBook.remove(name);
                        changed = true;
                        System.out.println("\nDIRECTORY ENTRY REMOVED FOR " + name);
                    }
                    break;
                case 4:
                    System.out.println("\nLIST OF ENTRIES IN YOUR PHONE BOOK:\n");
                    for ( Map.Entry<String,String> entry : phoneBook.entrySet() )
                        System.out.println("   " + entry.getKey() + ": " + entry.getValue() );
                    break;
                case 5:
                    System.out.println("\nExiting program.");
                    break mainLoop;
                default:
                    System.out.println("\nILLEGAL ACTION NUMBER.");
                }
            }

            if(changed) {
                System.out.println("Saving phone directory changes to file " + dataFile.getAbsolutePath() + " ...");
                
                PrintWriter out;
                try {
                    out = new PrintWriter(new FileWriter(dataFile));
                } catch(IOException e) {
                    System.out.println("ERROR : Can't open data file for output.");
                    return;
                }

                for(Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    out.println(entry.getKey() + "%" + entry.getValue());
                }

                out.flush();
                out.close();

                if(out.checkError()) {
                    System.out.println("ERROR: Some error occurred while writing data file.");
                } else {
                    System.out.println("Done.");
                }
            }
        }
}
