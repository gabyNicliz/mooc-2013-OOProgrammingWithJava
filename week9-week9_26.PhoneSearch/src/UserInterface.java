/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryzen
 */
import java.util.Scanner;
import java.util.Set;
import java.util.Collections;
import java.util.List;

public class UserInterface {

    private Scanner reader;
    private ContactBook contactBook;

    public UserInterface() {
        this.reader = new Scanner(System.in);
        this.contactBook = new ContactBook();
    }

    public void start() {
        this.phoneSearchInstructions();

        while (true) {
            System.out.print("command: ");
            String command = reader.nextLine();
            if (command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                addPhoneNumberCommand();
            } else if (command.equals("2")) {
                searchPhoneByNameCommand();
            } else if (command.equals("3")) {
                System.out.println(searchPersonByPhoneNumberCommand());
            } else if (command.equals("4")) {
                addPersonsAddressCommand();
            } else if (command.equals("5")) {
                searchForPersonalInformationCommand();
            } else if (command.equals("6")) {
                deletePersonalInformationCommand();
            } else if (command.equals("7")) {
                filteredListingCommand();
            }
            System.out.println();
        }
    }

    public void phoneSearchInstructions() {
        System.out.println("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit\n");
    }

    // command 1
    public void addPhoneNumberCommand() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();
        contactBook.addPerson(name);
        contactBook.addPersonsPhoneNumber(name, number);
    }

    // command 2
    public void searchPhoneByNameCommand() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        if (contactBook.findPerson(name)) {
            Set<String> personPhoneNumbers = contactBook.getPersonsPhoneNumber(name);
            for (String phoneNumber : personPhoneNumbers) {
                System.out.println(" " + phoneNumber);
            }
        } else {
            System.out.println("  not found");
        }
    }

    // command 3
    public String searchPersonByPhoneNumberCommand() {
        System.out.print("number: ");
        String number = reader.nextLine();
        for (Person person : contactBook.getPersonsList()) {
            for (String personPhoneNumber : person.getPhoneNumbers()) {
                if (number.equals(personPhoneNumber)) {
                    return " " + person.getName();
                }
            }
        }
        return " not found";
    }

    // command 4
    public void addPersonsAddressCommand() {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        if (contactBook.findPerson(name)) {
            System.out.print("street: ");
            String street = reader.nextLine();
            System.out.print("city: ");
            String city = reader.nextLine();
            contactBook.addPersonsAddress(name, street, city);
        } else {
            contactBook.addPerson(name);
            System.out.print("street: ");
            String street = reader.nextLine();
            System.out.print("city: ");
            String city = reader.nextLine();
            contactBook.addPersonsAddress(name, street, city);
        }

    }

    // command 5
    public void searchForPersonalInformationCommand() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        if (contactBook.findPerson(name)) {
            for (Person person : contactBook.getPersonsList()) {
                if (person.getName().equals(name)) {
                    if (!person.getAddress().isEmpty()) {
                        for (String address : person.getAddress()) {
                            System.out.println("  address: " + address);
                        }
                    } else {
                        System.out.println("  address unknown");
                    }
                    if (!person.getPhoneNumbers().isEmpty()) {
                        System.out.println("  phone numbers:");
                        for (String number : person.getPhoneNumbers()) {
                            System.out.println("   " + number);
                        }
                    } else {
                        System.out.println("  phone number not found");
                    }
                } else {
                    System.out.println("  not found");
                }
            }
        } else {
            System.out.println("  not found");
        }
    }

    // command 6
    public void deletePersonalInformationCommand() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        if (contactBook.findPerson(name)) {
            contactBook.getPersonsMap().remove(name);
            for (int i = 0; i < contactBook.getPersonsList().size(); i++) {
                if (contactBook.getPersonsList().get(i).getName().equals(name)) {
                    contactBook.getPersonsList().remove(i);
                }
            }
        } else {
            System.out.println("  not found");
        }
    }

    // command 7
    public void filteredListingCommand() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        List<Person> filteredPersonsList = contactBook.keywordSearch(keyword);
        if (!filteredPersonsList.isEmpty()) {
            for (Person person : filteredPersonsList) {
                System.out.println(" " + person.getName());
                if (!person.getAddress().isEmpty()) {
                    System.out.print("  address: ");
                    for (String address : person.getAddress()) {
                        System.out.println(address);
                    }
                } else {
                    System.out.println("  address unknown");
                }
                if (!person.getPhoneNumbers().isEmpty()) {
                    System.out.println("  phone numbers:");
                    for (String number : person.getPhoneNumbers()) {
                        System.out.println("   " + number);
                    }
                } else {
                    System.out.println("  phone number not found");
                }
            }
        } else {
            System.out.println(" keyword not found");
        }
    }
}
