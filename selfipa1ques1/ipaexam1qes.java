import java.util.*;
public class ipaexam1qes
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int sum =0;
       for(int i=0;i<str.length();i++)
       {
            // if(Character.isDigit(str.charAt(i)))
            int checknum = str.charAt(i);

            if(checknum>=48 && checknum<58)
            {
                int num = str.charAt(i)-'0';
                sum+=num;
            }
       }
        System.out.println(sum);
    }
}