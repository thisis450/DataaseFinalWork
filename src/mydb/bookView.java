package mydb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class bookView extends JFrame {
   Vector<book>mybook;
   JPanel p1=new JPanel();
   JLabel idlabel=new JLabel("书籍id:");
   JTextField id=new JTextField(10);
   JLabel namelabel=new JLabel("书籍名:");
   JTextField name=new JTextField(30);
    JPanel p2=new JPanel();
    JLabel bplabel=new JLabel("出版商:");
    JTextField publisher=new JTextField(30);
    JLabel balabel=new JLabel("作者:");
    JTextField author=new JTextField(30);
    JLabel typelabel=new JLabel("类型");
    JTextField type=new JTextField(10);
    JPanel p3=new JPanel();
    JLabel daylabel=new JLabel("借阅天数:");
    JTextField day=new JTextField(5);
    JLabel book=new JLabel("书籍：");
    JComboBox<String>mb=new JComboBox<>();
    JButton borrow=new JButton("借阅");
    JPanel p4=new JPanel();
    JButton search=new JButton("搜索");
    JButton re=new JButton("返回主菜单");
    bookView()
    {
        setLayout(new GridLayout(4, 1));
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        p3.setLayout(new FlowLayout());
        p4.setLayout(new FlowLayout());
        p1.add(idlabel);
        p1.add(id);
        p1.add(namelabel);
        p1.add(name);
        add(p1);
        p2.add(bplabel);
        p2.add(publisher);
        p2.add(balabel);
        p2.add(author);
        p2.add(typelabel);
        p2.add(type);
        add(p2);
        p3.add(book);
        p3.add(mb);
        p3.add(borrow);
        p3.add(daylabel);p3.add(day);
        add(p3);
        p4.add(search);
        p4.add(re);
        add(p4);
        setVisible(false);
        setSize(700, 400);
        addlistener();
        //setnone();
    }
void setnone()
{
    id.setText("书籍id");
name.setText("书籍名");
publisher.setText("出版商");
        author.setText("作者");
        type.setText("类别");

}
    private void addlistener() {
        re.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                vars.mv.setVisible(true);
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //setnone();
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
        borrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                book temp=mybook.get(mb.getSelectedIndex());
                try {
                   int a= vars.dc.borrowBook(vars.user_id,temp.id,day.getText());
                   if(a==1)
                   {
                       JOptionPane.showMessageDialog(null,"借阅成功");
                   }
                   if(a==0)
                   {
                       JOptionPane.showMessageDialog(null,"借阅失败，账号异常或图书不足或借阅超过7天");
                   }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
