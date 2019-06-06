package top.fxxxx.InformationPortal.dao;

public class Article {
    private String title;
    private String author;
    private String content;
    private long id;
    private long mydate;
    private String partof;
    private String rootpartof;

    public Article(String title, String author, String content, long mydate, String partof, String rootpartof, long id) {
        this.author = author;
        this.content = content;
        this.title = title;
        this.id = id;
        this.partof = partof;
        this.mydate = mydate;
        this.rootpartof = rootpartof;
    }

    public Article() {
        rootpartof = title = author = content = partof = "";
    }

    public void setRootpartof(String rootpartof) {
        this.rootpartof = rootpartof;
    }

    public String getRootpartof() {
        return rootpartof;
    }

    public long getMydate() {
        return mydate;
    }

    public void setMydate(long mydate) {
        this.mydate = mydate;
    }

    public void setPartof(String partof) {
        this.partof = partof;
    }

    public String getPartof() {
        return partof;
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
