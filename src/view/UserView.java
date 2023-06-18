package view;

import javax.swing.*;
import java.awt.*;

public class UserView extends JFrame {
    searchView upper=new searchView();
    JPanel middle=new JPanel();
    JPanel lower=new JPanel();
    JPanel ll=new JPanel();
    JButton logout=new JButton("登出");
    JLabel Money_Lable=new JLabel("余额");
    JTextField money=new JTextField(7);
    JButton borrow=new JButton("借阅");
    JButton re=new JButton("还书");
    JButton fre=new JButton("刷新");
    JComboBox<String>borrows=new JComboBox<String>();
    JComboBox<String>punishs=new JComboBox<String>();
    JLabel myborrow =new JLabel("我的借阅");
    JLabel mypunish=new JLabel("我的违规");
    UserView()
    {setSize(1000, 500);
        setLayout(new GridLayout(4, 1));
        lower.setLayout(new FlowLayout());
        middle.setLayout(new FlowLayout());
        ll.setLayout(new FlowLayout());
        middle.add(myborrow);
        middle.add(borrows);
        lower.add(mypunish);
        lower.add(punishs);
        ll.add(logout);
        ll.add(Money_Lable);
        ll.add(money);
        ll.add(borrow);
        ll.add(re);
        ll.add(fre);
        add(upper);
        add(middle);
        add(lower);
        add(ll);

        setVisible(false);

    }

    public static void main(String[] args) {
        UserView uv=new UserView();
        uv.setVisible(true);
    }


}
