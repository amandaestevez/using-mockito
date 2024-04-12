package simulating.a.post.office.system;


//This line imports the LocalDate class from the java.time library.
//The LocalDate class is used to work with dates.
import java.time.LocalDate;


//This line defines a public class named AddPerson.
//"Public" means that this class can be accessed by other classes.
public class AddPerson {

    // This line defines a private PostOfficeApi variable named postOfficeApi.
    // Private means only methods within the AddPerson class can access it directly.
    // PostOfficeApi is a class that provides methods for interacting with the post office system.
    private PostOfficeApi postOfficeApi;

    // This line defines a public constructor for the AddPerson class.
    // A constructor is used to initialize a new AddPerson object.
    // The final keyword prevents the postOfficeApi parameter from being reassigned after it is set.
    public AddPerson(final PostOfficeApi postOfficeApi) {
        // This line assigns the value of the postOfficeApi parameter to the postOfficeApi variable of the AddPerson object.
        this.postOfficeApi = postOfficeApi;
     }

    // This line defines a public method named addPerson that takes 4 parameters:
    // name (String), id (String), birthday (LocalDate), and zipcode (String).
    // This method creates a new person, retrieves their address data based on the zipcode, sets the address, and returns the new person object.
     public Person addPerson(String name, String id, LocalDate birthday, String zipcode) {
         // This line creates a new Person object using the provided name, id, and birthday.
        Person person = new Person(name, id, birthday);
         // This line calls the postOfficeApi object's getDataFromZipCode method to retrieve location data based on the zipcode.
         LocationData locationData = postOfficeApi.getDataFromZipCode(zipcode);
         // This line calls the person object's addLocationData method to set the address information retrieved from the zipcode.
        person.addsLocationData(locationData);
        return person;
         }
     }

