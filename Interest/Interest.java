import java.util.*;
public class Interest{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        double Accbalance = sc.nextDouble();
        double interestRate = sc.nextDouble();
        int noOfyears = sc.nextInt();
        Account one = new Account(id,Accbalance,interestRate);

        double ans = calculateInterest(one,noOfyears);
        System.out.println(ans);
    }
    public static double calculateInterest(Account one, int noOfyears)
    {
        double Tinterest = one.getbalance() * (one.getinterestRate() / 100) * noOfyears;
        return Tinterest;
    }   
}
class Account
{
    private int id;
    private double balance;
    private double interestRate;

    public Account(int id,double balance,double interestRate)
    {
        this.id = id;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public int getid()
    {
        return id;
    }

    public double getbalance()
    {
        return balance;
    }

    public double getinterestRate()
    {
        return interestRate;
    }
}