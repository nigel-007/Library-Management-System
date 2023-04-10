package javaaplication9;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Update_Author extends Frame implements ActionListener
{  
        Choice Author_ID;
    TextField Author_Name;
    TextField Author_Address;
    TextField Author_Phone_Number;
    Label jLabel2;
    Label jLabel1;
    Label jLabel3;
    Label jLabel4;
    Button jButton1;
   
    Update_Author()            
    {   addWindowListener(new WindowAdapter()
        {   public void windowClosing(WindowEvent we)
            {   System.exit(0); }
        });
   
         Author_ID = new Choice();        
        Author_Name = new TextField(40);
        Author_Address = new TextField(40);
        Author_Phone_Number= new TextField(20);
        jLabel2 = new Label();
        jLabel1 = new Label();
        jLabel3 = new Label();
        jLabel4 = new Label();
        jButton1 = new Button("Update Author");
       

        Font myFont=new Font("Tahoma", 1, 20); // NOI18N
        jLabel1.setText("Author_ID");
        jLabel2.setText("Author_Name");
        jLabel3.setText("Author_Address");
        jLabel4.setText("Author_Phone_Number");
        jLabel1.setFont(myFont);
        jLabel2.setFont(myFont);
        jLabel3.setFont(myFont);
        jLabel4.setFont(myFont);
        add(jLabel1);add(Author_ID);
        add(jLabel2);add(Author_Name);
        add(jLabel3);add(Author_Address);
        add(jLabel4); add(Author_Phone_Number);
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
               
            String s="select aid from author";
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(s);//used with select command to read data from the table
            while(rs.next())
            {  Integer r=rs.getInt("aid");
                Author_ID.addItem(r.toString());
            }
            conn.close();
        }
        catch(SQLException e){} catch (ClassNotFoundException ex) {
        Logger.getLogger(Update_Author.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void actionPerformed(ActionEvent e)
    {   String s=e.getActionCommand();
        if(s.equals("Update Author"))
        {    try
            {   Statement stmt = null;
                int aid=Integer.parseInt(Author_ID.getSelectedItem());
                String aname=Author_Name.getText();                
                String adrr=Author_Address.getText();
                int apn=Integer.parseInt(Author_Phone_Number.getText());
                Class.forName(Library.driver);
                System.out.println("Connecting to database...");
                Connection conn = DriverManager.getConnection(Library.DB_URL, Library.USER,Library.PASS);
                System.out.println("Updating record...");
                stmt = conn.createStatement();//insert into empdata values(123,'tina','hr',23000)
                String sql = "UPDATE author set a_name='"+aname+"',a_add='"+adrr+"',aph_no="+apn+" where aid="+aid;
                System.out.println(sql);
                stmt.executeUpdate(sql);
                System.out.println("data record added to table successfully");
                conn.close();
                }
        catch(ClassNotFoundException | SQLException e1){}
        }
    }
}