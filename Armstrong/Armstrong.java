import java.util.Scanner;
public class Armstrong{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int number =  sc.nextInt();
        int n = number;
        int sum = 0;
        while(n>0)
        {
            int rem = n%10;
            sum = sum*10 + rem;
            n = n/10;
        }
        if(sum == (number))
        {
            System.out.println("Yes, the number is an Armstrong");
        }
        else{
            System.out.println("No, the number is an Not Armstrong");
        }
    }
}