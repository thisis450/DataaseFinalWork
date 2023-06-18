package mydb;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

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
        admlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a=vars.dc.admLogin(id.getText(),password.getText());
                    if(a==1)
                    {

                        setVisible(false);
                        vars.av.setVisible(true);
                        id.setText("");
                        password.setText("");
                    }
                    if(a==0)
                    {
                        JOptionPane.showMessageDialog(null,"账号或密码错误，登陆失败");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a=vars.dc.userLogin(id.getText(),password.getText());
                    if(a==1)
                    {

setVisible(false);
vars.mv.setVisible(true);
vars.user_id=id.getText();
id.setText("");
vars.mv.wel.setText("欢迎你 id: "+vars.user_id+"你的账号状态为: ");
int t=vars.dc.getState(vars.user_id);
if(t==1)
{
    vars.mv.state.setText("正常");
}
if(t==0)
{
    vars.mv.state.setText("异常");
}
password.setText("");
                    }
                    if(a==0)
                    {
                        JOptionPane.showMessageDialog(null,"账号或密码错误，登陆失败");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                vars.rv.setVisible(true);
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
        addlistener();

    }

    public static void main(String[] args) {
        loginview lw=new loginview();
        lw.setVisible(true);
    }
}
