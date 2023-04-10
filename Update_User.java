package javaaplication9;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Update_User extends Frame implements ActionListener
{  
        Choice User_ID;
    TextField User_Name;
    TextField User_Address;
    TextField User_Phone_Number;
    Label jLabel2;
    Label jLabel1;
    Label jLabel3;
    Label jLabel4;
    Button jButton1;
   
    Update_User()            
    {   addWindowListener(new WindowAdapter()
        {   public void windowClosing(WindowEvent we)
            {   System.exit(0); }
        });
   
         User_ID = new Choice();        
        User_Name = new TextField(40);
        User_Address = new TextField(40);
        User_Phone_Number= new TextField(20);
        jLabel2 = new Label();
        jLabel1 = new Label();
        jLabel3 = new Label();
        jLabel4 = new Label();
        jButton1 = new Button("Update User");
       

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
        initCombo();    
    }
    void initCombo()
    {   try
        {  
            Class.forName(Library.driver);
                System.out.println("Connecting to database...");
                Connection conn = DriverManager.getConnection(Library.DB_URL, Library.USER,Library.PASS);
               
            String s="select Uid from user";
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(s);//used with select command to read data from the table
            while(rs.next())
            {  Integer r=rs.getInt("Uid");
                User_ID.addItem(r.toString());
            }
            conn.close();
        }
        catch(SQLException e){} catch (ClassNotFoundException ex) {
        Logger.getLogger(Update_Author.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void actionPerformed(ActionEvent e)
    {   String s=e.getActionCommand();
        if(s.equals("Update User"))
        {    try
            {   Statement stmt = null;
                String uid = User_ID.getSelectedItem();
                String uname=User_Name.getText();                
                String udrr=User_Address.getText();
                int upn=Integer.parseInt(User_Phone_Number.getText());
                Class.forName(Library.driver);
                System.out.println("Connecting to database...");
                Connection conn = DriverManager.getConnection(Library.DB_URL, Library.USER,Library.PASS);
                System.out.println("Updating record...");
                stmt = conn.createStatement();//insert into empdata values(123,'tina','hr',23000)
                String sql = "UPDATE user set u_name='"+uname+"',u_add='"+udrr+"',uph_no="+upn+" where Uid='"+uid+"'" ;
                System.out.println(sql);
                stmt.executeUpdate(sql);
                System.out.println("data record added to table successfully");
                conn.close();
                }
        catch(ClassNotFoundException | SQLException e1){}
        }
    }
}