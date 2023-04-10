package javaaplication9;

import java.awt.*;
import java.awt.event.*;

public class Author extends Frame implements ActionListener
{  static String USER ;
    static  String PASS;
    static  String driver;
    static  String DB_URL;
    Button jButton1;
    Button jButton2;
    Button jButton3;
    Button jButton4;
    Button jButton5;
    public Author()
    {   addWindowListener(new WindowAdapter()
        {   public void windowClosing(WindowEvent we)
            {   System.exit(0); }
        });
        Font myFont=new Font("Tahoma", 1, 26); // NOI18N
        setLayout(new FlowLayout());
        jButton1 = new Button("View Author");
        jButton2 = new Button("Add Author");
        jButton3 = new Button("Update Author");
        jButton4 = new Button("Delete Author");
        jButton5 = new Button("Books by Author");
        
        jButton1.setFont(myFont);
        jButton2.setFont(myFont);
        jButton3.setFont(myFont);
        jButton4.setFont(myFont);
        jButton5.setFont(myFont);
        
        add(jButton1);
        add(jButton2);
        add(jButton3);
        add(jButton4);
        add(jButton5);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        jButton5.addActionListener(this);
        Author.initconnectionData();
    }
    static void initconnectionData()
   {  USER ="root";
      PASS="";
      driver="com.mysql.jdbc.Driver";
      DB_URL = "jdbc:mysql://localhost/library_management";
   }
    public void actionPerformed(ActionEvent e)
    {   String g=e.getActionCommand();
        if(g.equals("View Author"))
        {  
            View_Author i=new View_Author();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);          
        }
      if(g.equals("Add Author"))
        {  
            Add_Author i=new Add_Author();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);          
        }
          if(g.equals("Update Author"))
        {  
            Update_Author i=new Update_Author();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);          
        }
          if(g.equals("Delete Author"))
        {  
            Delete_Author i=new Delete_Author();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);          
        }
          if(g.equals("Books by Author"))
        {  
            Books_Author i=new Books_Author();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);          
        }
       
    }
    public static void main(String args[])
    {   Author e=new Author();
        e.setSize(new Dimension(370, 700));
        e.setTitle("GraphicsDemo");
        e.setVisible(true);
    }
}