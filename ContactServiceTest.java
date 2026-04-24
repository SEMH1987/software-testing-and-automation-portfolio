package contact_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact.Contact;

import contact.ContactService;

// tests for contact service operations such as add, delete, and updates
//it ensures the system behaves correctly when modifying stored contact data
public class ContactServiceTest {
	
	// these tests verify that update operations correctly locate a contact and change the right fields and does so correctly
    @Test
    void testAddContactSuccessfully() {

        ContactService service = new ContactService();

        Contact c = new Contact("B2001", "seraphina", "coleman", "5551234567", "15 north ridge road");

        assertTrue(service.addContact(c));
    }

    @Test
    void testDuplicateContactIdRejected() {
        ContactService service = new ContactService();

        Contact c1 = new Contact("B2002", "seraphina", "coleman", "5551234567", "15 north ridge road");
        Contact c2 = new Contact("B2002", "victor", "reynolds", "4449876543", "88 west avenue");

        service.addContact(c1);

        assertFalse(service.addContact(c2));
    }

    @Test
    void testDeleteContactSuccessfully() {

        ContactService service = new ContactService();

        Contact c = new Contact("B2003", "marcus", "ellington", "3332221111", "9 cedar lane");

        service.addContact(c);

        assertTrue(service.deleteContact("B2003"));
    }

    @Test
    void testUpdateFirstName() {

        ContactService service = new ContactService();

        Contact c = new Contact("B2004", "marcus", "ellington", "3332221111", "9 cedar lane");

        service.addContact(c);

        assertTrue(service.updateFirstName("B2004", "mason"));
    }

    @Test
    void testUpdateLastName() {

        ContactService service = new ContactService();

        Contact c = new Contact("B2005", "marcus", "ellington", "3332221111", "9 cedar lane");

        service.addContact(c);

        assertTrue(service.updateLastName("B2005", "reid"));
    }

    @Test
    void testUpdatePhone() {

        ContactService service = new ContactService();

        Contact c = new Contact("B2006", "marcus", "ellington", "3332221111", "9 cedar lane");

        service.addContact(c);

        assertTrue(service.updatePhone("B2006", "9998887777"));
    }

    @Test
    void testUpdateAddress() {

        ContactService service = new ContactService();

        Contact c = new Contact("B2007", "marcus", "ellington", "3332221111", "9 cedar lane");

        service.addContact(c);

        assertTrue(service.updateAddress("B2007", "1200 lakeview drive"));
    }
}