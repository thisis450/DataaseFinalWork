package view;

import javax.swing.*;
import java.awt.*;

public class searchView extends JPanel {
    JComboBox<String>books=new JComboBox<String>();
    JLabel books_label=new JLabel("书籍信息");
    JPanel upper=new JPanel();
    JPanel lower=new JPanel();
    JTextField name=new JTextField(20);
    JTextField ID=new JTextField(10);
    JTextField author=new JTextField(20);
    JTextField publish=new JTextField(20);
    JTextField type=new JTextField(20);
    JTextField price=new JTextField(20);
    JLabel n=new JLabel("书名");
    JLabel id=new JLabel("书籍编号");
    JLabel a=new JLabel("作者");
    JLabel pb=new JLabel("出版商");
    JLabel ty=new JLabel("书籍类型");
    JButton sc=new JButton("搜索");

    searchView() {
        setLayout(new GridLayout(2, 1));
        upper.setLayout(new FlowLayout());
        lower.setLayout(new FlowLayout());
        upper.add(books_label);
        upper.add(books);
        lower.add(n);
        lower.add(name);
        lower.add(id);
        lower.add(ID);
        lower.add(a);
        lower.add(author);
        lower.add(pb);
        lower.add(publish);
        lower.add(ty);
        lower.add(type);
        lower.add(sc);
        add(upper);
        add(lower);
        setVisible(true);
        clear();
    }

    public void clear() {
        name.setText("");
        ID.setText("");
        author.setText("");
        publish.setText("");
        type.setText("");
    }


}
