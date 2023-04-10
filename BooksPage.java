package javaaplication9;

import java.awt.*;
import java.awt.event.*;

public class BooksPage extends Frame implements ActionListener
{  static String USER ;
    static  String PASS;
    static  String driver;
    static  String DB_URL;
    Button jButton1;
    Button jButton2;
    Button jButton3;
    Button jButton4;
    Button jButton5;
    Button jButton6;
    public BooksPage() 
    {   addWindowListener(new WindowAdapter() 
        {   public void windowClosing(WindowEvent we) 
            {   System.exit(0); }
        });
        Font myFont=new Font("Tahoma", 1, 26); // NOI18N
        setLayout(new FlowLayout());
        jButton1 = new Button("View Books");
        jButton2 = new Button("Add Books");
        jButton3 = new Button("Update Books");
        jButton4 = new Button("Delete Books");
        jButton5 = new Button("Educational Books");
        jButton6 = new Button("Authors");
        jButton1.setFont(myFont);
        jButton2.setFont(myFont);
        jButton3.setFont(myFont);
        jButton4.setFont(myFont);
        jButton5.setFont(myFont);
        jButton6.setFont(myFont);
        add(jButton1);
        add(jButton2);
        add(jButton3);
        add(jButton4);
        add(jButton5);
        add(jButton6);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        jButton5.addActionListener(this);
        jButton6.addActionListener(this);
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
        if(g.equals("View Books"))
        {   
           SelectForm i=new SelectForm();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            
        }
        if(g.equals("Add Books"))
        {   
           InsertForm i=new InsertForm();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            
        }
        if(g.equals("Update Books"))
        {   
           UpdateForm i=new UpdateForm();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            
        }
        if(g.equals("Delete Books"))
        {   
           DeleteForm i=new DeleteForm();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            
        }
        if(g.equals("Educational Books"))
        {   
           Educational_Books i=new Educational_Books();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            
        }
        if(g.equals("Authors"))
        {   
            Author i=new Author();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            
        }
        
        
        
    }
    public static void main(String args[])
    {   BooksPage e=new BooksPage();
        e.setSize(new Dimension(370, 700));
        e.setTitle("GraphicsDemo");
        e.setVisible(true);
    }
}
