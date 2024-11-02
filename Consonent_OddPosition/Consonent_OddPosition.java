import java.util.*;
public class Consonent_OddPosition{
    public static void  main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans = "";
        for(int i=0;i<str.length();i++)
        {
            if((i+1)%2!=0 && isConsonent(str.charAt(i)))
            {
                ans = ans + str.charAt(i);
            }
        }
        System.out.println(ans);
    }

    public static boolean isConsonent(char a)
    {
        if(a !='a' && a != 'A' && a != 'e'&& a != 'E' && a != 'I' && a != 'i' && a != 'O' && a!='o' && a!='u' && a!='U')
        {
            return true;
        }
        return false;
    }
}