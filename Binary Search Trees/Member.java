//Creates a member object with a member ID, first name, last name, address, and city.

public class Member {
    int memberId;
    String firstName, lastName, address, city;
    
    //Constructor to initialize the member object
    public Member(int memberId, String firstName, String lastName, String address, String city) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
    }
    
    //Returns information about the member object in the form of a string
    public String toString() {
        return "ID: " + memberId + ", Name: " + firstName + " " + lastName + ", Address: " + address + ", City: " + city;
    }
}
