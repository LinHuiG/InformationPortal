package top.fxxxx.InformationPortal.dao;

public class Article
{
    private String title;
    private long author;
    private String content;
    private long id;
    private String partof;
    public Article(String title,long author,String content,String partof,long id)
    {
        this.author=author;
        this.content=content;
        this.title=title;
        this.id=id;
        this.partof=partof;
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

    public long getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(long author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
