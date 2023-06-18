package mydb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class mainView extends JFrame {
    JPanel upper=new JPanel();
    JPanel lower=new JPanel();
    JLabel wel=new JLabel();
    JLabel state=new JLabel();
    JButton myborrow=new JButton("我的借阅");
    JButton mypunish=new JButton("我的罚款");
    JButton borrow =new JButton("借阅书籍");
    JButton logout=new JButton("登出");
    mainView()
    {setLayout(new GridLayout(2, 1));
        upper.setLayout(new FlowLayout());
        upper.add(wel);
        upper.add(state);
        lower.setLayout(new FlowLayout());
        lower.add(myborrow);
        lower.add(mypunish);
        lower.add(borrow);
        lower.add(logout);
        add(upper);
        add(lower);
        setSize(500, 200);
        addlistener();
        setVisible(false);
    }
public void refresh() throws SQLException {
    int t=vars.dc.getState(vars.user_id);
    if(t==1)
    {
        state.setText("正常");
    }
    if(t==0)
    {
        state.setText("异常");
    }
}
    private void addlistener() {
        myborrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                vars.bov.setVisible(true);
            }
        });
        mypunish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                vars.pv.setVisible(true);
            }
        });
        borrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                vars.bv.setVisible(true);
            }
        });
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                vars.user_id="";
                vars.lv.setVisible(true);
            }
        });
    }
}
