package simulating.a.post.office.system;

//importing the LocalDate class from the java.time library
//It allows us to work with dates
import java.time.LocalDate;

//importing the ChronoUnit class from the java.time.temporal library
//used to work with spans of time between dates
import java.time.temporal.ChronoUnit; 

//this line defines a public class named Person.
//Public means it can be accessed by other classes.
public class Person {

    //The following lines define private variables.
    //Private means that only methods within the Person class can access them.
    private String name;

    private String id;

    private LocalDate birthday;

    private LocationData address;

    // This line defines a public constructor for the Person class.
    // A constructor is used to initialize a new Person object.
    // The final keyword prevents the parameters from being reassigned after they are set.
    public Person(final String name, final String id, final LocalDate birthday) {
        this.name = name;
        this.id = id;
        this.birthday = birthday;
    }

    // This line defines a public method named addLocationData.
    // The public method takes a LocationData object as a parameter.
    // This method sets the address variable of the Person object to the LocationData object.
    public void addsLocationData(LocationData locationData) {
        this.address = locationData;
    }

    //Lines 41 - 56 define public "getter" methods that return the values of the methods.
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocationData getAddress() {
        return address;
    }

    //The following method calculates the difference between the birthday and the current date.
    //It then returns a boolean value that confirms if the person in older than 18.
    public boolean isAnAdult() {
        return ChronoUnit.YEARS.between(this.birthday, LocalDate.now()) >18;
    }
}
