/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryzen
 */
import java.util.Set;
import java.util.HashSet;

public class Person implements Comparable<Person>{

    private String name;
    private Set<String> phoneNumbers;
    private Set<String> address;

    public Person(String name) {
        this.address = new HashSet<String>();
        this.phoneNumbers = new HashSet<String>();
        this.name = name;
    }

    public void setAddress(String street, String city) {
        String newAddress = street + " " + city;
        address.add(newAddress);
    }

    public void newPhoneNumbe(String newNumber) {
        phoneNumbers.add(newNumber);
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public Set<String> getAddress() {
        return this.address;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public int compareTo(Person person) {
        return this.name.hashCode() - person.getName().hashCode();
    }
    
    
}
