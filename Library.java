package javaaplication9;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Library extends Frame implements ActionListener
{   static String USER ;
    static  String PASS;
    static  String driver;
    static  String DB_URL;
    Button jButton1;
    Button jButton2;
    Button jButton3;
    Button jButton4;
    public Library() 
    {   addWindowListener(new WindowAdapter() 
        {   public void windowClosing(WindowEvent we) 
            {   System.exit(0); }
        });
        Font myFont=new Font("Tahoma", 1, 26); // NOI18N
        setLayout(new FlowLayout());
        //setBackground(Color.BLUE);
        jButton1 = new Button("Books");
        jButton2 = new Button("Users");
        jButton3 = new Button("Lended Books");
        jButton4 = new Button("Book Count");
        
        jButton1.setFont(myFont);
        jButton2.setFont(myFont);
        jButton3.setFont(myFont);
        jButton4.setFont(myFont);
        add(jButton1);
        add(jButton2);
        add(jButton3);
        add(jButton4);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        Library.initconnectionData();
    }
    static void initconnectionData()
   {  USER ="root";
      PASS="";
      driver="com.mysql.jdbc.Driver";
      DB_URL = "jdbc:mysql://localhost/library_management";
   }
    public void actionPerformed(ActionEvent e) 
    {   String g=e.getActionCommand();
        if(g.equals("Books"))
        {   
           BooksPage i=new BooksPage();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            
           
        }
        if(g.equals("Users"))
        {   
           Reader i=new Reader();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            
           
        }
        if(g.equals("Book Count"))
        {   
           Book_Count i=new Book_Count();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            
           
        }
        /*if(g.equals("Lended Books"))
        {   
           LendedPage i=new LendedPage();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            
           
        }*/
        
    }
    public static void main(String args[])
    {   Library e=new Library();
        e.setSize(new Dimension(370, 700));
        e.setTitle("GraphicsDemo");
        e.setVisible(true);
    }
}
