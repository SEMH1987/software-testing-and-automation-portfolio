package contact;

//this class represents a single contact and stores all the basic info like name, phone, and address
//it also makes sure nothing invalid ever gets saved by enforcing rules through validation

public class Contact {

    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        validate(contactId, firstName, lastName, phone, address);
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // validate all rules for contact fields
    // this method is the main safety check for the whole class
    private void validate(String contactId, String firstName, String lastName, String phone, String address) {

        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException();
        }

        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException();
        }

        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException();
        }

        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException();
        }

        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException();
        }
    }
    // getters
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // setters with validation
    public void setFirstName(String firstName) {
        validate(contactId, firstName, lastName, phone, address);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validate(contactId, firstName, lastName, phone, address);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validate(contactId, firstName, lastName, phone, address);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validate(contactId, firstName, lastName, phone, address);
        this.address = address;
    }
}