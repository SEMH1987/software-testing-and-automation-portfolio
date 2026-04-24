package contact_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact.Contact;

//this test class checks that the contact object properly enforces all validation rules
// tests for validating contact object rules and constraints
public class ContactTest {
	// each test checks a different rule such as length limits or null values
	// test contact id too long is rejected
	@Test
	void testContactIdTooLongRejected() {
	    assertThrows(IllegalArgumentException.class, () ->
	            new Contact("THISIDISTOOLONG123", "alexander", "harrington", "9876543210", "742 evergreen terrace"));
	}

	// test last name too long is rejected
	@Test
	void testLastNameTooLongRejected() {
	    assertThrows(IllegalArgumentException.class, () ->
	            new Contact("A1006", "alexander", "thislastnametoolong", "9876543210", "742 evergreen terrace"));
	}

	// test phone too long rejected
	@Test
	void testPhoneTooLongRejected() {
	    assertThrows(IllegalArgumentException.class, () ->
	            new Contact("A1007", "alexander", "harrington", "12345678901", "742 evergreen terrace"));
	}

	// test address too long rejected
	@Test
	void testAddressTooLongRejected() {
	    assertThrows(IllegalArgumentException.class, () ->
	            new Contact("A1008", "alexander", "harrington", "9876543210",
	                    "this address is way too long and should trigger validation failure immediately"));
	}
	
    @Test
    void testValidContactCreation() {

        Contact c = new Contact("A1001", "alexander", "harrington", "9876543210", "742 evergreen terrace");

        assertEquals("A1001", c.getContactId());
        assertEquals("alexander", c.getFirstName());
        assertEquals("harrington", c.getLastName());
        assertEquals("9876543210", c.getPhone());
        assertEquals("742 evergreen terrace", c.getAddress());
    }
    // these tests focus on input validation and make sure the constructor rejects bad or missing data
    @Test
    void testNullContactIdRejected() {

        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "alexander", "harrington", "9876543210", "742 evergreen terrace"));
    }

    @Test
    void testFirstNameTooLongRejected() {

        assertThrows(IllegalArgumentException.class, () ->
                new Contact("A1002", "thisfirstnameiswaytoolong", "harrington", "9876543210", "742 evergreen terrace"));
    }

    @Test
    void testNullLastNameRejected() {

        assertThrows(IllegalArgumentException.class, () ->
                new Contact("A1003", "alexander", null, "9876543210", "742 evergreen terrace"));
    }

    @Test
    void testInvalidPhoneRejected() {

        assertThrows(IllegalArgumentException.class, () ->
                new Contact("A1004", "alexander", "harrington", "123", "742 evergreen terrace"));
    }

    @Test
    void testNullAddressRejected() {

        assertThrows(IllegalArgumentException.class, () ->
                new Contact("A1005", "alexander", "harrington", "9876543210", null));
    }
}