import java.util.*;
public class CharRepeat{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int i = 0;
        int j = 0;
        String ans="";
        int count =0;
        while(i<str.length() && j<str.length())
        {
            while(j<str.length() && str.charAt(i)==str.charAt(j))
            {
                j++;
                count++;
            }
            if(j<str.length() && str.charAt(i)!=str.charAt(j))
            {
                ans = ans + str.charAt(i);
                ans = ans + count;
                i = j;
                count = 0;
            }
        }
        ans = ans + str.charAt(i) + count;
        System.out.println(ans);
    }
}