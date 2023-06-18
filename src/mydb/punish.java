package mydb;

public class punish {
    public String u;
    public String b;
    public String money;

    @Override
    public String toString() {
        return "punish{" +
                "user_id='" + u + '\'' +
                ", book_id='" + b + '\'' +
                ", money=" + money +
                '}';
    }
    punish(String u,String b,String money)
    {
        this.u=u;
        this.b=b;
        this.money=money;
    }
}
