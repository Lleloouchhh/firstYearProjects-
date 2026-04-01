import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhonebookDirectory {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact c){
        contacts.add(c);
        contacts.sort((a,b)-> a.getLastName().compareToIgnoreCase(b.getLastName()));
    }

    public void deleteContact(int index){
        contacts.remove(index);
    }

    public ArrayList<Contact> getAllContacts() {
        return contacts;
    }

    public String getFullDetails(int idx){
        return contacts.get(idx).getFirstName() + " " + contacts.get(idx).getLastName() +
                "\nAddress : "+ contacts.get(idx).getAddress() +
                "\nPhone number: "+ contacts.get(idx).getPhoneNumber() +
                "\nSex: " +contacts.get(idx).getSex() +
                "\nAge: " +contacts.get(idx).getAge();
    }
}
