package db;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.*;

public class DatabaseConnector {
     Connection conn;
     Statement stmt;
    DatabaseConnector() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root") ;
        stmt = conn.createStatement();
    }
    public  int insertBook(String book_name,int book_id,int book_num,String book_author,String publish,int book_remain,float price,String book_type,float price_perday,float punish_perday,float punish_destroy) throws SQLException {
        String sql="INSERT INTO book (book_name, book_Id, book_num, book_author, publish, book_remain, price, book_type, price_perday, punish_perday, punish_destroy) values ("+book_name+' '+book_id+' '+book_num+' '+book_author+' '+publish;
sql=sql+' '+book_remain+' '+price+' '+book_type+' '+price_perday+' '+punish_perday+' '+punish_destroy+')';
        int a=stmt.executeUpdate(sql);
        return a;

    }
    public int addBook(int book_id,int num) throws SQLException {
        String sql="UPDATA book SET book_num=book_num+"+num+" WHERE book_Id="+book_id;
        int a=stmt.executeUpdate(sql);
        return a;
    }
    public  int borrowBook(int userId,int bookId,String borrowTime,String returnTime,int day) throws SQLException {

        String sql="UPDATA book SET book_remain=book_remain-1 WHERE book_Id="+bookId;
        stmt.execute(sql);
        sql="INSERT INTO borrow (user_ID, book_Id, borrow_time, should_return) VALUES ("+userId+' '+bookId+' '+borrowTime+' '+returnTime+')';
        stmt.execute(sql);
        return 2;
    }
    public  int canBorrow(int userId,int moneyPerday,int day) throws SQLException {
        String sql="SELECT * FROM user WHERE user_ID="+userId;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            // 通过字段检索
            int already=rs.getInt("user_already");
            int can=rs.getInt("user_can");
            String state  = rs.getString("帐号状态");
            if(state!="正常")
            {
                return 0;//0代表账号异常
            }
            int money = rs.getInt("money");
            if(money<moneyPerday)
            {
                return 1;//1代表余额不足
            }
            if(already>=can)
            {
                return 2;//2代表超过借阅上限
            }
        }
return 3;
    }

   public  void subMoney(int userId,int money) throws SQLException {
       String sql="UPDATE user SET money=money-"+money+"WHERE user_ID="+userId;
       stmt.execute(sql);
   }
   public  boolean checkPassword(int userId,String user_password) throws SQLException {
    String sql="SELECT user_password WHER usre_ID="+userId;
       ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()){
           // 通过字段检索
           String pwd  = rs.getString("user_password");
           if(pwd!=user_password)
           {
               return false;//0代表账号异常
           }

       }
return true;
   }






    public static void main(String[] args) throws ClassNotFoundException, SQLException {
DatabaseConnector dc=new DatabaseConnector();

ResultSet rs=dc.stmt.executeQuery("select * from borrow");
while (rs.next())
{
    Date id=rs.getDate("borrow_time");
    System.out.println(id.toString());
}
    }






}