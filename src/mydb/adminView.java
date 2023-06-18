package mydb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class adminView extends JFrame {
    Vector<book> mybook;
    JPanel p1=new JPanel();
    JLabel nl=new JLabel("书名");
    JTextField name=new JTextField(30);
    JLabel pl=new JLabel("出版商");
    JTextField publisher=new JTextField(30);
    JPanel p2=new JPanel();
    JLabel il=new JLabel("书籍id");
    JTextField id=new JTextField(10);
JLabel al=new JLabel("作者");
JTextField author=new JTextField(30);
JLabel tl=new JLabel("书籍类型");
JTextField type=new JTextField(10);
JLabel numl=new JLabel("出/入库数量");
JTextField num=new JTextField(10);
    JPanel p3=new JPanel();
    JButton search=new JButton("搜索");
    JButton out=new JButton("出库");
    JButton in =new JButton("入库");
    JButton logout=new JButton("登出");
    JPanel p4=new JPanel();
    JComboBox<String>mb=new JComboBox<>();
    adminView()
    {
        setLayout(new GridLayout(4, 1));
        p1.setLayout(new FlowLayout());
        p1.add(nl);
        p1.add(name);
        p1.add(pl);
        p1.add(publisher);
        add(p1);
    p2.setLayout(new FlowLayout());
    p2.add(il);
    p2.add(id);
    p2.add(al);
    p2.add(author);
    p2.add(tl);
    p2.add(type);
    p2.add(numl);
    p2.add(num);
    add(p2);
    p4.add(mb);
    add(p4);
        p3.setLayout(new FlowLayout());
        p3.add(search);
        p3.add(out);
        p3.add(in);
        p3.add(logout);
        add(p3);
        setVisible(false);
        addlistener();
        setSize(700, 400);
    }

    private void addlistener() {
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mb.removeAllItems();
                    mybook=vars.dc.getBook(id.getText(),name.getText(),publisher.getText(),author.getText(),type.getText());
                for(book b:mybook)
                {
                    mb.addItem(b.toString());
                }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a=vars.dc.out_book(mybook.get(mb.getSelectedIndex()).id,num.getText());
                    if(a!=0)
                    {
                        JOptionPane.showMessageDialog(null,"出库成功");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"出库失败");
                    }
                    mb.removeAllItems();
                    mybook=vars.dc.getBook("","","","","");
                    for(book b:mybook)
                    {
                        mb.addItem(b.toString());
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a=vars.dc.in_book(name.getText(),publisher.getText(),num.getText(),author.getText());
                    if(a!=0)
                    {
                        JOptionPane.showMessageDialog(null,"入库成功");

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"入库失败");
                    }
                    mb.removeAllItems();
                    mybook=vars.dc.getBook("","","","","");
                    for(book b:mybook)
                    {
                        mb.addItem(b.toString());
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                vars.lv.setVisible(true);
            }
        });
    }

}
