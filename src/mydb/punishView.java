package mydb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class punishView extends JFrame {
    Vector<punish> myborrow;
    JLabel bl=new JLabel("我的罚款");
    JComboBox<String>mb=new JComboBox<>();
    JPanel upper=new JPanel();
    JPanel lower=new JPanel();
    JButton rb=new JButton("交罚款");
    JButton rf=new JButton("刷新");
    JButton re=new JButton("返回主菜单");
    void refresh() throws SQLException {
        myborrow=vars.dc.getPunish(vars.user_id);
        mb.removeAllItems();
        for(punish temp :myborrow)
        {
            mb.addItem(temp.toString());
        }
    }
   punishView()
    { setLayout(new GridLayout(2, 1));
        lower.setLayout(new FlowLayout());
        upper.setLayout(new FlowLayout());
        upper.add(bl);
        upper.add(mb);
        lower.add(rb);
        lower.add(rf);
        lower.add(re);
        add(upper);
        add(lower);
        addlistener();
        setSize(500, 200);
        setVisible(false);
    }

    private void addlistener() {
        rb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a=vars.dc.payPunish(vars.user_id,myborrow.get(mb.getSelectedIndex()).b);
                    if(a==1)
                    {
                        JOptionPane.showMessageDialog(null,"还款成功");
                        refresh();
                    }
                    if(a==0)
                    {
                        JOptionPane.showMessageDialog(null,"还款失败");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        rf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    refresh();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        re.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                vars.mv.setVisible(true);
                try {
                    vars.mv.refresh();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
