package top.fxxxx.InformationPortal.dao;

public class Account
{
    private String name;
    private long id;
    private String password;
    //第0位代表是否有后台管理权限
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