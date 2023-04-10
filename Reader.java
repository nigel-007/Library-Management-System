package javaaplication9;

import java.awt.*;
import java.awt.event.*;

public class Reader extends Frame implements ActionListener
{  static String USER ;
    static  String PASS;
    static  String driver;
    static  String DB_URL;
    Button jButton1;
    Button jButton2;
    Button jButton3;
    Button jButton4;
    public Reader()
    {   addWindowListener(new WindowAdapter()
        {   public void windowClosing(WindowEvent we)
            {   System.exit(0); }
        });
        Font myFont=new Font("Tahoma", 1, 26); // NOI18N
        setLayout(new FlowLayout());
        jButton1 = new Button("Select User");
        jButton2 = new Button("Add User");
        jButton3 = new Button("Update User");
        jButton4 = new Button("Delete User");
        jButton1.setFont(myFont);
        jButton2.setFont(myFont);
        jButton3.setFont(myFont);
        add(jButton1);
        add(jButton2);
        add(jButton3);
        add(jButton4);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        Reader.initconnectionData();
    }
    static void initconnectionData()
   {  USER ="root";
      PASS="";
      driver="com.mysql.jdbc.Driver";
      DB_URL = "jdbc:mysql://localhost/library_management";
   }
    public void actionPerformed(ActionEvent e)
    {   String g=e.getActionCommand();
        if(g.equals("Select User"))
        {  
            Select_User i=new Select_User();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);          
        }
      if(g.equals("Add User"))
        {  
            Add_User i=new Add_User();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);          
        }
          if(g.equals("Update User"))
        {  
            Update_User i=new Update_User();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);          
        }
          if(g.equals("Delete User"))
        {  
            Delete_User i=new Delete_User();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);          
        }
       
    }
    public static void main(String args[])
    {   Reader e=new Reader();
        e.setSize(new Dimension(370, 700));
        e.setTitle("GraphicsDemo");
        e.setVisible(true);
    }
}