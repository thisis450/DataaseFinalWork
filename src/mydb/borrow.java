package mydb;

import java.util.SplittableRandom;

public class borrow {
public String u_id;
public String b_id;
public String should_return;
public String borrow_time;

    @Override
    public String toString() {
        return "borrow{" +
                "user_id='" + u_id + '\'' +
                ", book_id='" + b_id + '\'' +
                ", should_return='" + should_return + '\'' +
                ", borrow_time='" + borrow_time + '\'' +
                '}';
    }
    borrow(String u_id,String b_id,String s_d,String s_t,String b_d,String b_t)
    {
        this.u_id=u_id;
        this.b_id=b_id;
        should_return=s_d+" "+s_t;
        borrow_time=b_d+" "+b_t;
    }
}
