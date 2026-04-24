package contact;

import java.util.HashMap;

import java.util.Map;

//this class handles all contact operations like adding, deleting, and updating contacts in memory
//it acts like a simple manager that keeps track of all stored contacts using a map
public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    // add a new contact if id is unique
    public boolean addContact(Contact contact) {

        if (contact == null) return false;

        String id = contact.getContactId();

        if (contacts.containsKey(id)) return false;

        contacts.put(id, contact);
        return true;
    }

    // delete contact by id
    public boolean deleteContact(String contactId) {

        if (contactId == null || !contacts.containsKey(contactId)) return false;

        contacts.remove(contactId);
        return true;
    }
    // update methods find a contact by id and then modify only the specific field requested
    // update first name
    public boolean updateFirstName(String contactId, String firstName) {

        Contact c = contacts.get(contactId);
        if (c == null) return false;

        c.setFirstName(firstName);
        return true;
    }

    // update last name
    public boolean updateLastName(String contactId, String lastName) {

        Contact c = contacts.get(contactId);
        if (c == null) return false;

        c.setLastName(lastName);
        return true;
    }
    

    // update phone
    public boolean updatePhone(String contactId, String phone) {

        Contact c = contacts.get(contactId);
        if (c == null) return false;

        c.setPhone(phone);
        return true;
    }

    // update address
    public boolean updateAddress(String contactId, String address) {

        Contact c = contacts.get(contactId);
        if (c == null) return false;

        c.setAddress(address);
        return true;
        
    }
}
