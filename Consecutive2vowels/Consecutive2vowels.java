import java.util.*;
public class Consecutive2vowels{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        if(str.length()>1)
        {
            for(int i=1;i<str.length();i++)
            {
                boolean a = isVovel(str.charAt(i));
                boolean b = isVovel(str.charAt(i-1));
                if(a && b)
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isVovel(char a)
    {
        if(a=='a' || a == 'e' || a == 'i'|| a == 'o' || a == 'u' || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U')
        {
            return true;
        }
        return false;
    }
}