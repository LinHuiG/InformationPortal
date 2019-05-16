package top.fxxxx.InformationPortal.dao;

public class Article
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