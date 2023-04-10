package javaaplication9;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Add_User extends Frame implements
        ActionListener
{
   
    TextField User_ID;
    TextField User_Name;
    TextField User_Address;
    TextField User_Phone_Number;
    Label jLabel2;
    Label jLabel1;
    Label jLabel3;
    Label jLabel4;
    Button jButton1;
   
    Add_User()
    {   addWindowListener(new WindowAdapter()
        {   public void windowClosing(WindowEvent we)
            {   System.exit(0); }
        });
       
        User_ID = new TextField(20);        
        User_Name = new TextField(40);
        User_Address = new TextField(40);
        User_Phone_Number= new TextField(20);
        jLabel2 = new Label();
        jLabel1 = new Label();
        jLabel3 = new Label();
        jLabel4 = new Label();
        jButton1 = new Button("Insert User");
       

        Font myFont=new Font("Tahoma", 1, 20); // NOI18N
        jLabel1.setText("User_ID");
        jLabel2.setText("User_Name");
        jLabel3.setText("User_Address");
        jLabel4.setText("User_Phone_Number");
        jLabel1.setFont(myFont);
        jLabel2.setFont(myFont);
        jLabel3.setFont(myFont);
        jLabel4.setFont(myFont);
        add(jLabel1);add(User_ID);
        add(jLabel2);add(User_Name);
        add(jLabel3);add(User_Address);
        add(jLabel4); add(User_Phone_Number);
        add(jButton1);
        jButton1.addActionListener(this);
        setLayout(new FlowLayout());
    }
   
    public void actionPerformed(ActionEvent e)
    {   String s=e.getActionCommand();
        if(s.equals("Insert User"))
        {   try
            {   Statement stmt = null;              
                String uid=User_ID.getText();  
                String uname=User_Name.getText();                
                String uadd=User_Address.getText();
                int uph=Integer.parseInt(User_Phone_Number.getText());                
               
               
                Class.forName(Library.driver);
                System.out.println("Connecting to database...");
                Connection conn = DriverManager.getConnection(Library.DB_URL, Library.USER,Library.PASS);
                System.out.println("inserting record...");
                stmt = conn.createStatement();//insert into empdata values(123,'tina','hr',23000)
                String sql = "INSERT INTO user "+ "(Uid,u_name,u_add,uph_no)"
                    + " VALUES ("+uid+",'"+uname+"','"+uadd+"',"+uph+")";
                System.out.println(sql);
                stmt.executeUpdate(sql);
                System.out.println("data record added to table successfully");
                conn.close();
                }
        catch(ClassNotFoundException | SQLException e1)
        {}
        }
    }
   
}