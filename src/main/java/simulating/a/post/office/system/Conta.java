package simulating.a.post.office.system;

//This class simulates a bank account
//Lines 05-06 create a public class called "Conta" which stores a variable "saldo".
public class Conta {
    private int saldo;

    //The constructor initializes the account balance
    public Conta(int saldo) {
        this.saldo = saldo;
    }

    //Lines 15-18 simulate the payment of a bill.
    //The "pagaBoleto" method performs the actions of the three other methods in order to update the account.
    public void pagaBoleto (int valorAPagar){
        validaSaldo(valorAPagar);
        debita(valorAPagar);
        enviaCreditoParaEmissor(valorAPagar);
    }

    //Lines 23-25: this method checks if there's enough account balance to pay the bill
    public void validaSaldo (int valorAPagar) {
        if(valorAPagar > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
    }

    //Lines 30-31: the method updates the balance after the bill was paid
    public void debita (int valorAPagar) {
        this.saldo = this.saldo - valorAPagar;
    }

    //this method sends the value paid to the creditor
    public void enviaCreditoParaEmissor (int valorAPagar){

    }
}
