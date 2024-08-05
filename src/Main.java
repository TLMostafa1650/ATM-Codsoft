/**

 * @author Mostafa EL-Hosseny
 */

public class Main {
    public static void main(String[] args)
    {
        Bankaccount account = new Bankaccount();
    ATM atm = new ATM(account);
    atm.Starting();
    }
    }
