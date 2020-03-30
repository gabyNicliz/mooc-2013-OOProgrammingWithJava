/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryzen
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class ContactBook {

    private Map<String, Person> personContact;
    private List<Person> personsList;

    public ContactBook() {
        this.personContact = new HashMap<String, Person>();
        this.personsList = new ArrayList<Person>();
    }

    public void addPerson(String name) {
        if (personContact.get(name) == null) {
            Person newPerson = new Person(name);
            this.personContact.put(name, newPerson);
            this.personsList.add(newPerson);
        }
    }

    public void addPersonsPhoneNumber(String name, String phoneNumber) {
        if (findPerson(name)) {
            personContact.get(name).newPhoneNumbe(phoneNumber);
            for (Person person : personsList) {
                if (person.getName().equals(name)) {
                    person.newPhoneNumbe(phoneNumber);
                }
            }
        }

    }

    public void addPersonsAddress(String name, String street, String city) {
        if (findPerson(name)) {
            personContact.get(name).setAddress(street, city);
            for (Person person : personsList) {
                if (person.getName().equals(name)) {
                    person.setAddress(street, city);
                }
            }
        }
    }

    public Set<String> getPersonsPhoneNumber(String name) {
        return personContact.get(name).getPhoneNumbers();
    }

    public Set<String> getPersonAddress(String name) {
        return personContact.get(name).getAddress();
    }

    public boolean findPerson(String name) {
        if (personContact.get(name) == null) {
            return false;
        }
        return true;
    }

    public List<Person> getPersonsList() {
        return personsList;
    }
    
    public Map<String, Person> getPersonsMap(){
        return personContact;
    }
    
    public List<Person> keywordSearch(String keyword){
        List<Person> personsFound = new ArrayList<Person>();
        
        for(Person person : this.personsList){
            if(person.getName().contains(keyword)){
                personsFound.add(person);
            } else {
                for(String address : person.getAddress()){
                    if(address.contains(keyword)){
                        personsFound.add(person);
                    }
                }
            }
        }
        Collections.sort(personsFound);
        return personsFound;
    }

}
