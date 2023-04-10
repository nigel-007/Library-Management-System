package javaaplication9;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import net.proteanit.sql.DbUtils;
public class InsertForm extends Frame implements 
        ActionListener
{
    
    TextField Book_ID;
    TextField Book_Title;
    TextField Category;
    TextField Page_count;
    Label jLabel2;
    Label jLabel1;
    Label jLabel3;
    Label jLabel4;
    Button jButton1;
    
    InsertForm()
    {   addWindowListener(new WindowAdapter() 
        {   public void windowClosing(WindowEvent we) 
            {   System.exit(0); }
        });
        
        Book_ID = new TextField(20);        
        Book_Title = new TextField(40);
        Category = new TextField(40);
        Page_count= new TextField(20);
        jLabel2 = new Label();
        jLabel1 = new Label();
        jLabel3 = new Label();
        jLabel4 = new Label();
        jButton1 = new Button("Insert Book");
        

        Font myFont=new Font("Tahoma", 1, 20); // NOI18N
        jLabel1.setText("Book_ID");
        jLabel2.setText("Book_Title");
        jLabel3.setText("Category");
        jLabel4.setText("Page_count");
        jLabel1.setFont(myFont);
        jLabel2.setFont(myFont);
        jLabel3.setFont(myFont);
        jLabel4.setFont(myFont);
        add(jLabel1);add(Book_ID);
        add(jLabel2);add(Book_Title);
        add(jLabel3);add(Category);
        add(jLabel4); add(Page_count);
        add(jButton1);
        jButton1.addActionListener(this);
        setLayout(new FlowLayout());
    }
    
    public void actionPerformed(ActionEvent e) 
    {   String s=e.getActionCommand();
        if(s.equals("Insert Book"))
        {   try
            {   Statement stmt = null;
                int Bid=Integer.parseInt(Book_ID.getText());
                String Title=Book_Title.getText();                
                String Cat=Category.getText();
                int pgcnt=Integer.parseInt(Page_count.getText());
                Class.forName(Library.driver);
                System.out.println("Connecting to database...");
                Connection conn = DriverManager.getConnection(Library.DB_URL, Library.USER,Library.PASS);
                System.out.println("inserting record...");
                stmt = conn.createStatement();//insert into empdata values(123,'tina','hr',23000)
                String sql = "INSERT INTO book "+ "(Bid,Title,Category,pg_cnt)"
                    + " VALUES ("+Bid+",'"+Title+"','"+Cat+"',"+pgcnt+")"; 
                System.out.println(sql);
                stmt.executeUpdate(sql);
                System.out.println("data record added to table successfully");
                conn.close();
                }
        catch(ClassNotFoundException | SQLException e1){}
        }
    }
    
}
