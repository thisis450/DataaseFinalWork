package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginview extends JFrame {
    JButton login=new JButton("登录");
    JButton admlogin=new JButton("管理员登录");
    JButton reg=new JButton("注册");
    JTextField id=new JTextField(30);
    JTextField password=new JTextField(30);
    JLabel ID=new JLabel("账号");
    JLabel pwd=new JLabel("密码");
    JPanel upper=new JPanel();
    JPanel lower=new JPanel();
    JPanel middle=new JPanel();
    void addlistener()
    {
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }
    loginview()
    {
        setLayout(new GridLayout(3, 1));
        upper.setLayout(new FlowLayout());
        lower.setLayout(new FlowLayout());
        upper.add(ID);
        upper.add(id);
        middle.add(pwd);
        middle.add(password);
        lower.add(login);
        lower.add(admlogin);
        lower.add(reg);
        add(upper);
        add(middle);
        add(lower);
        setSize(500, 200);
        setVisible(false);

    }

    public static void main(String[] args) {
        loginview lw=new loginview();
        lw.setVisible(true);
    }
}
