package mydb;

import java.sql.SQLException;

public class vars {
    public static String user_id;
    public static loginview lv=new loginview();
    public static DBConnector dc;
    public static RegView rv=new RegView();
    public static punishView pv=new punishView();
    public static borrowView bov=new borrowView();
    public static bookView bv=new bookView();
    public static adminView av=new adminView();

    static {
        try {
            dc = new DBConnector();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static mainView mv=new mainView();
public static String[] types={"类别1","类别2","类别3","类别4","类别5"};

    public static void main(String[] args) {
        vars.lv.setVisible(true);
    }
}
