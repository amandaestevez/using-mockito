package email.system.testing;

import email.system.simulation.Email;
import email.system.simulation.Formato;
import email.system.simulation.PlataformaDeEnvio;
import email.system.simulation.ServicoEnvioEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

//Lines 14-15:Creates a public class and calls the @ExtendWith annotation in JUnit
@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTeste {

    //Lines 19-20: Inserts the instantiated class as a mock
    //This allows us to test the code without using its dependencies
    @Mock
    private PlataformaDeEnvio plataforma;

    //Lines 23-24: Injects the mock PlataformaDeEnvio created by Mockito into the servico field.
    @InjectMocks
    private ServicoEnvioEmail servico;

    //Lines 27-28: captures the Email object passed to the emailCaptor method.
    @Captor
    private ArgumentCaptor<Email> emailCaptor;

    //Line 31-32: calls the @Test annotation and creates the method to execute the test
    @Test
    void validaSeEmailEstaComDadosCorretos() {

        String email = "random@test.com";
        String mensagem = "Hey there!";

        //Lines 38-39: tests enviaEmail is called on the platform with the correct parameters.
        servico.enviaEmail(email, mensagem, true);
        Mockito.verify(plataforma).enviaEmail(emailCaptor.capture());

        //Lines 42-43: Verifies that the service sets the mail format to HTML before sending
        Email emailCapturado = emailCaptor.getValue();
        Assertions.assertEquals(Formato.HTML, emailCapturado.getFormato());
    }
}