package theInternet;

public class Person {
    public Person(String lastName, String firstName, String email, float due, String website) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.due = due;
        this.website = website;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public float getDue() {
        return due;
    }

    public String getWebsite() {
        return website;
    }

    private final String lastName;
    private final String firstName;
    private final String email;
    private final float due;
    private final String website;

}
