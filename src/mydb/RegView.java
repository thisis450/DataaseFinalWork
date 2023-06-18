package mydb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegView extends JFrame
{
    JLabel namelabel=new JLabel("姓名");
    JTextField name=new JTextField(20);
    JLabel IDlabel=new JLabel("ID");
    JTextField ID=new JTextField(20);
    JLabel pwdlabel=new JLabel("密码");
    JTextField pwd=new JTextField(20);
    JPanel upper=new JPanel();
    JPanel middle=new JPanel();
    JPanel lower=new JPanel();
    JButton reg=new JButton("注册");
    void addlistener()
    {
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a=vars.dc.regUser(ID.getText(),name.getText(),pwd.getText());
                    if(a==0)
                    {
                        JOptionPane.showMessageDialog(null,"注册失败，已存在的id");
                    }
                    if(a==1)
                    {
                        JOptionPane.showMessageDialog(null,"注册成功，返回登陆界面");
                        setVisible(false);
                        vars.lv.setVisible(true);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
public RegView()
{
    setLayout(new GridLayout(3, 1));
    upper.setLayout(new FlowLayout());
    lower.setLayout(new FlowLayout());
    middle.setLayout(new FlowLayout());
    upper.add(namelabel);
    upper.add(name);
    middle.add(IDlabel);
    middle.add(ID);
    lower.add(pwdlabel);
    lower.add(pwd);
    lower.add(reg);
    add(upper);
    add(middle);
    add(lower);
    setSize(1500, 300);
    setVisible(false);
    addlistener();

}

    public static void main(String[] args) {
        RegView rv=new RegView();
        rv.setVisible(true);
    }
}
