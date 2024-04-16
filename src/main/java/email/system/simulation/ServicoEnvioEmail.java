package email.system.simulation;

/*Line 06: The class "ServicoEnvioEmail" contains a private variable "plataforma".
*This variable will be used to interact with the email sending platform.*/

public class ServicoEnvioEmail {

    private PlataformaDeEnvio plataforma;

    //Line 11: constructor method.
    public void enviaEmail (String enderecoEmail, String mensagem, boolean formatoHtml) {
        //Line 13: Instance of the "Email" class which is set to null.
        Email email = null;

        //Line 16: Conditional statement determnines the email format using getters.
        if(formatoHtml) {
            email = new Email(enderecoEmail, mensagem, Formato.HTML);
        } else {
            email = new Email(enderecoEmail, mensagem, Formato.TEXTO);
        }

        //Line 23: The actual email sending happens here, using the "plataforma" to send the created "email" object.
        plataforma.enviaEmail(email);
        }
}

