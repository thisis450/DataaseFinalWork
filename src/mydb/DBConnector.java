package mydb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

public class DBConnector {
public
    Connection conn;
    DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root") ;

    }

    public int admLogin(String u_id,String pwd) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql="select * from admin where admin_id="+u_id+" and admin_pwd='"+pwd+"'";
        ResultSet rs = stmt.executeQuery(sql);
        int t=-99;
        while(rs.next())
        {
            t=rs.getInt("admin_id");
        }
        if(t!=-99)
        {stmt.close();
            return 1;

        }
        stmt.close();
        return 0;
    }
    public int out_book(String book_id,String num) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql="call out_book("+book_id+","+num+")";
        int result=stmt.executeUpdate(sql);
        return result;
    }
    public int in_book(String name,String publisher,String num,String author) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql="call add_book('"+name+"','"+publisher+"',"+num+",'"+author+"')";
        int a=stmt.executeUpdate(sql);
        return a;
    }
    public int getState(String u_id) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql="select * from user where user_id='"+u_id+"'";
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next())
        {
            return rs.getInt("user_state");
        }
        return 0;
    }
    public Vector<borrow>getBorrow(String u_id) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql="select*from borrow where user_id="+u_id;
        ResultSet rs=stmt.executeQuery(sql);
        Vector<borrow>result=new Vector<borrow>();
        while(rs.next())
        {
            String user=Integer.toString(rs.getInt("user_id"));
            String book=Integer.toString(rs.getInt("book_id"));
            String s_d=rs.getDate("should_return").toString();
            String s_t=rs.getTime("should_return").toString();
            String b_d=rs.getDate("borrow_time").toString();
            String b_t=rs.getTime("borrow_time").toString();
            result.add(new borrow(user,book,s_d,s_t,b_d,b_t));
        }
        return result;
    }
    public Vector<punish> getPunish(String u_id) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql="select*from punish where user_id="+u_id;
        ResultSet rs=stmt.executeQuery(sql);
        Vector<punish>result=new Vector<>();
        while(rs.next())
        {
            String user=Integer.toString(rs.getInt("user_id"));
            String book=Integer.toString(rs.getInt("book_id"));
            String money=Float.toString(rs.getFloat("money"));
            result.add(new punish(user,book,money));
        }
return result;
    }
    public int payPunish(String u_id,String b_id) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql="call pay_punish("+u_id+','+b_id+')';
        System.out.println(sql);
        int result=stmt.executeUpdate(sql);
        stmt.close();
        return result;
    }
    public int regUser(String u_id,String name,String pwd) throws SQLException {
        Statement stmt = conn.createStatement();
    String sql="insert into user(user_id,user_name,user_state,user_pwd) values("+u_id+",'"+name+"',"+"true"+",'"+pwd+"')";
    System.out.println(sql);
    int result=stmt.executeUpdate(sql);
    stmt.close();
    return result;
}
    public int borrowBook(String u_id,String b_id,String days) throws SQLException {
        Statement stmt = conn.createStatement();
    String sql="call borrow_book("+u_id+','+b_id+","+"now()"+","+days+')';
    System.out.println(sql);
    int result=stmt.executeUpdate(sql);
    stmt.close();
    return result;
}
    public int returnBook(String u_id,String b_id) throws SQLException {
        Statement stmt = conn.createStatement();
    String sql="call book_return("+u_id+','+b_id+')';
    System.out.println(sql);
    int result=stmt.executeUpdate(sql);
    stmt.close();
    return result;
}
    public Vector<String> getType(String b_id) throws SQLException {
    Statement stmt = conn.createStatement();
    Vector<String>result=new Vector<String>();
    String sql="SELECT type_id from book_type_relation relation where book_id="+b_id;
    ResultSet rs = stmt.executeQuery(sql);
    while(rs.next())
    {
        String temp="类别"+rs.getInt("type_id");
        if(!temp.equals("类别0"))
        result.add(temp);
    }
    stmt.close();
   return result;
}
    public int userLogin(String u_id,String pwd) throws SQLException {
    Statement stmt = conn.createStatement();
    String sql="select * from user where user_id='"+u_id+"' and user_pwd='"+pwd+"'";
    ResultSet rs = stmt.executeQuery(sql);
    int t=-99;
    while(rs.next())
    {
        t=rs.getInt("user_id");
    }
    if(t!=-99)
    {stmt.close();
        return 1;

    }
    stmt.close();
    return 0;
}
    public Vector<book> getBook(String b_id,String name,String bp,String b_a,String type) throws SQLException {
    Statement stmt = conn.createStatement();
    String t="type_0";
    int num=0;
    for(int i=0;i<5;i++)
    {
        if(type.equals(vars.types[i]))
        {
            t="type_"+(i+1);
            break;
        }
    }
    String sql="select * from "+t;
    if(!(b_id.equals("")&&name.equals("")&&bp.equals("")&&b_a.equals("")))
    {
        sql+=" where";
    }
    if(!b_id.equals(""))
    {
        sql+=" book_id="+b_id;
        num++;
    }
    if(!name.equals(""))
    {
        if(num!=0)
        {
            sql+=" and";
        }
        sql+=" book_name='"+name+"'";
        num++;
    }
    if(!bp.equals(""))
    {
        if(num!=0)
        {
            sql+=" and";
        }
        sql+=" book_publisher='"+bp+"'";
        num++;
    }
    if(!b_a.equals(""))
    {
        if(num!=0)
        {
            sql+=" and";
        }
        sql+=" book_author='"+b_a+"'";
        num++;
    }
    System.out.println(sql);
    ResultSet rs=stmt.executeQuery(sql);
   Vector<book> result=new Vector<book>();
   while(rs.next())
   {
       String i= Integer.toString(rs.getInt("book_id"));
       String n=rs.getString("book_name");
       String nu=Integer.toString(rs.getInt("book_num"));
       String p=rs.getString("book_publisher");
       String a=rs.getString("book_author");
       String ty="";
       Vector<String> temp=getType(i);
       for(String temp2:temp)
       {
           ty+=temp2+",";
       }
       result.add(new book(i,n,p,nu,a,ty));
   }
   stmt.close();
   return result;

}

}
