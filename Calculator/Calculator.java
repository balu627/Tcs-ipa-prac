import java.util.*;
public class Calculator{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int i = 0;
        int count = 0;
        int firstnum = 0;
        int secondnum = 0;
        char opr = ' ';
        while(i<str.length())
        {
            String num = "";
            while(i<str.length() && str.charAt(i)!=',' && Character.isDigit(str.charAt(i)))
            {
                num = num + str.charAt(i);
                i++;
            }
            if(count==0)
            {
                firstnum = Integer.parseInt(num);
                count++;
            }
            else if(count == 1)
            {
                secondnum = Integer.parseInt(num);
                count++;
            }
            else if(count==2){
                opr = str.charAt(i);
                break;
            }
            i++;
        }
        int ans = 0;
        switch(opr)
        {
            case '+':
                ans = firstnum + secondnum;
                break;
            case '-':
                ans = firstnum - secondnum;
                break;
            case '*':
                ans = firstnum * secondnum;
                break;
            case '/':
                ans = firstnum / secondnum;
                break;
            default:
                System.out.println("This opr is wrong");
        }

        System.out.println(ans);
    }
}