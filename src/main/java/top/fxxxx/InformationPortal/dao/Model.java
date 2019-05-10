package top.fxxxx.InformationPortal.dao;

public class Model {
}
class Account
{
    private String name;
    private long id;
    private String password;
    private int permissions;
    private String email;
    private String info="";
    private String status="";
    public Account(String name,long id,String password,int permissions,String email)
    {
        this.name=name;
        this.id=id;
        this.password=password;
        this.permissions=permissions;
        this.email=email;
    }

    public Account(String name,long id,String password,int permissions,String email,String info,String status)
    {
        this.name=name;
        this.id=id;
        this.password=password;
        this.permissions=permissions;
        this.email=email;
        this.info=info;
        this.status=status;
    }
    public String toString()
    {
        String s="name: "+name;
        s+="\n";
        s+="id: "+id;
        s+="\n";
        s+="password: " + password;
        s+="\n";
        s+= "permissions: "+permissions;
        s+="\n";
        s+="email: " +email;
        s+="\n";
        s+="info: "+ info;
        s+="\n";
        s+="status: "+ status;
        s+="\n";
        return  s;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPermissions() {
        return permissions;
    }

    public long getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
class Article
{
    private String title;
    private String author;
    private String content;
    private long id;
    public Article(String title,String author,String content,long id)
    {
        this.author=author;
        this.content=content;
        this.title=title;
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}