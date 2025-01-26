import java.util.*;
public class BankAccountSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        BankAccount[] arr = new BankAccount[3];
        for(int i=0;i<arr.length;i++)
        {
            int accountNo = sc.nextInt();
            sc.nextLine();
            String accountHolderName = sc.nextLine();
            double balance = sc.nextDouble();
            arr[i] = new BankAccount(accountNo,accountHolderName,balance);
        }
        
        int firstset1 = sc.nextInt();
        double ans1 = withdraw(arr,firstset1,sc);

        int secondset1 = sc.nextInt();
        double ans2 = Deposit(arr,secondset1,sc);

        if(ans1==-2)
        {
            System.out.println("Sorry - Account not found");
        }
        else if(ans1==-1)
        {
            System.out.println("Sorry - Insufficient balance");
        }
        else
        {
            System.out.println(ans1);
        }

        if(ans2==-1)
        {
            System.out.println("Sorry - Account not found");
        }
        else{
            System.out.println(ans2);
        }

    }
    public static double withdraw(BankAccount[] arr,int firstset1,Scanner sc)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].getaccountNo()==firstset1)
            {
                double amount = sc.nextDouble();
                if(amount<=arr[i].getbalance())
                {
                    arr[i].setbalance(arr[i].getbalance()-amount);
                    return arr[i].getbalance();
                }
                else
                {
                    return -1;
                }
            }
        }
        return -2;
    }

    public static double Deposit(BankAccount[] arr,int secondset1,Scanner sc)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].getaccountNo()==secondset1)
            {
                double amount = sc.nextDouble();
                arr[i].setbalance(arr[i].getbalance()+amount);
                return arr[i].getbalance();
            }
        }
        return -1;
    }
}

class BankAccount
{
    private int accountNo;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNo,String accountHolderName,double balance)
    {
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getaccountNo()
    {
        return accountNo;
    }

    public String getaccountHolderName()
    {
        return accountHolderName;
    }

    public double getbalance()
    {
        return balance;
    }

    public void setbalance(double balance)
    {
        this.balance = balance;
    }
}