package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminView extends JFrame
{
   searchView sv=new searchView();
    JPanel lower=new JPanel();
    JButton logout=new JButton("登出");
    JButton change=new JButton("修改选定书籍信息");
    JLabel nu=new JLabel("数量");
    JTextField num=new JTextField(10);
    JButton adm=new JButton("出入库选定书籍");
    JButton add=new JButton("添加书籍");
    AdminView()
    {
        setLayout(new GridLayout(2, 1));
        lower.setLayout(new FlowLayout());
        lower.add(logout);
        lower.add(nu);
        lower.add(num);
        lower.add(adm);
        lower.add(add);
        lower.add(change);
        add(sv);
        add(lower);
        setSize(1500, 300);
        setVisible(false);
        addlistener();

    }

    private void addlistener()
    {
logout.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        vars.username="NULL";
        vars.userId=0;
        sv.clear();
    }
});
change.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

    }
});

    }

    public static void main(String[] args) {
        AdminView lw=new AdminView();
        lw.setVisible(true);
    }
}
