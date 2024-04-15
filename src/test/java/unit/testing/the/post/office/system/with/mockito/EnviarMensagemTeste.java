package unit.testing.the.post.office.system.with.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import simulating.a.post.office.system.EnviarMensagem;
import simulating.a.post.office.system.Mensagem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;

//ExtendWith tells JUnit to use the Mockito extension 
@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTeste {

    @Spy
    EnviarMensagem enviarMensagem = new EnviarMensagem();

    @Test
    void adicionarMensagem() {
        Mensagem mensagem = new Mensagem("Hello World!");

        enviarMensagem.adicionarMensagem(mensagem);

        verify(enviarMensagem).adicionarMensagem(mensagem);

        assertEquals(1, enviarMensagem.getMensagens().size());
        assertFalse(enviarMensagem.getMensagens().isEmpty());
    }
}
