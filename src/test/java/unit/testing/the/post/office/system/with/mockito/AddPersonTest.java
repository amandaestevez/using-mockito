package unit.testing.the.post.office.system.with.mockito;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import simulating.a.post.office.system.AddPerson;
import simulating.a.post.office.system.LocationData;
import simulating.a.post.office.system.Person;
import simulating.a.post.office.system.PostOfficeApi;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AddPersonTest {

    @Mock
    private PostOfficeApi postOfficeApi;

    @InjectMocks
    private AddPerson addPerson;

    @Test
    void validateRegistrationData(){
        LocationData locationData = new LocationData("SP", "Santos","St. 232","house", "Whatever");
        Mockito.when(postOfficeApi.getDataFromZipCode("12345")).thenReturn(locationData);
        Person person = addPerson.addPerson("Amanda", "12345678", LocalDate.now(), "12345" );

        assertEquals("Amanda", person.getName());
        assertEquals("12345678", person.getId());
        assertEquals("house", person.getAddress().getComplement());
        assertEquals("SP", person.getAddress().getState());

    }

}

