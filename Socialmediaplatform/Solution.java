import java.util.*;
public class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        SocialMediaPlatform plat = new SocialMediaPlatform();
        for(int i=0;i<n;i++)
        {
            String content = sc.nextLine();
            plat.createPost(content);
        }

        int lc = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<lc;i++)
        {
            int id = sc.nextInt();
            sc.nextLine();
            String username = sc.nextLine();
            plat.addlikes(id,username);
        }

        int cc = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<cc;i++)
        {
            int id = sc.nextInt();
            sc.nextLine();
            String comment = sc.nextLine();
            plat.addcomment(id,comment);
        }

        plat.display();
    }
}

class Post{
    int postId;
    String content;
    HashSet<String> likes = new HashSet<>();
    ArrayList<String> comments = new ArrayList<>();

    public Post(int postId,String content)
    {
        this.postId = postId;
        this.content = content;
        this.likes = new HashSet<>();
        this.comments = new ArrayList<>();
    }

    public void addlike(String username)
    {
        likes.add(username);
    }

    public void addcomment(String comment)
    {
        comments.add(comment);
    }

    public int getpostId()
    {
        return postId;
    }

    public String getContent(){
        return content;
    }

    public HashSet<String> getlikes()
    {
        return likes;
    }

    public ArrayList<String> getcomments()
    {
        return comments;
    }
}

class SocialMediaPlatform{
    int pid = 1;
    ArrayList<Post> posts = new ArrayList<>();
    HashMap<Integer,Integer> postCommentsCount = new HashMap<>();

    public void createPost(String content)
    {
        posts.add(new Post(pid,content));
        postCommentsCount.put(pid++,0);
    }

    public void addlikes(int postid,String username)
    {
        for(int i=0;i<posts.size();i++)
        {
            if(posts.get(i).getpostId()==postid)
            {
                Post temp = posts.get(i);
                temp.addlike(username);
            }
        }
    }
    public void  addcomment(int postid,String comment)
    {
        for(int i=0;i<posts.size();i++)
        {
            if(posts.get(i).getpostId()==postid)
            {
                Post temp = posts.get(i);
                temp.addcomment(comment);
                int  stemp = temp.getpostId();
                postCommentsCount.put(stemp,postCommentsCount.get(stemp)+1);
            }
        }
    }

    public void display()
    {
        for(int i=0;i<posts.size();i++)
        {
            System.out.println(posts.get(i).getpostId());
            System.out.println(posts.get(i).getContent());
        }
        for(Map.Entry<Integer,Integer> i : postCommentsCount.entrySet())
        {
            System.out.println(i.getKey()+" "+i.getValue());
        }
    }
}