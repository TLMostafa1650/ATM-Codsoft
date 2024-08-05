public class Bankaccount {
    private double balance;

    public Bankaccount()
    {
        this.balance = 0.0;
    }
    public double getBalance()
    {
        return balance;
    }

    public void withdraw(double user_amount)
    {
        if (user_amount > 0 && user_amount <= balance)
            balance -= user_amount;
    }

    public void deposit(double user_amount)
    {
        if (user_amount > 0)
        {
            balance += user_amount;
        }
    }

}
