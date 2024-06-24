package unit.testing.the.post.office.system.with.mockito;


import main.system.AddPerson;
import main.system.LocationData;
import main.system.Person;
import main.system.PostOfficeApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
@ExtendWith(MockitoExtension.class)
public class AddPersonTest {

    @Mock
    private PostOfficeApi postOfficeApi;

    @InjectMocks
    private AddPerson addPerson;

    @Test
    void validateRegistrationData(){
        LocationData locationData = new LocationData("SP", "Santos","St. 232","house", "Whatever");
        Mockito.when(postOfficeApi.getDataFromZipCode(anyString())).thenReturn(locationData);
        Person person = addPerson.addPerson("Amanda", "12345678", LocalDate.of(1995,1,8), "12345" );

        assertEquals("Amanda", person.getName());
        assertEquals("12345678", person.getId());
        assertEquals("house", person.getAddress().getComplement());
        assertEquals("SP", person.getAddress().getState());

    }

    @Test
    void addPersonFail() {
        Mockito.when(postOfficeApi.getDataFromZipCode(anyString())).thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () -> addPerson.addPerson("Amanda", "12345678", LocalDate.of(1995, 1, 8), "12345"));
    }
}


