package mydb;

public class book {
public String id;
public String name;
public String pub;
public String num;
public String author;
public String book_type;

    @Override
    public String toString() {
        return
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pub='" + pub + '\'' +
                ", num='" + num + '\'' +
                ", author='" + author + '\'' +
                        "book_type='"+book_type+'\''
                ;
    }
    book(String id,String name,String pub,String num,String author,String book_type)
    {
        this.id=id;
        this.name=name;
        this.pub=pub;
        this.num=num;
        this.author=author;
        this.book_type=book_type;
    }
}
