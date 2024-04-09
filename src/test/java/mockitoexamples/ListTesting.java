package mockitoexamples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ListTesting {

    @Mock
    private List<String> letters;

    @Test
    void addItemsToTheList() {
            Mockito.when(letters.get(0)).thenReturn("B");
        Assertions.assertEquals("B",letters.get(0));
}
}
