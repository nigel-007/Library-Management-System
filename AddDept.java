package javaaplication9;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class AddDept extends Frame implements ActionListener
{   List l1;
    TextField t1,t2;
    Button b1;
    Font myFont;
    AddDept()
    {   setLayout(new GridLayout(0,1,2,2));
        myFont=new Font("Tahoma", 1, 20); 
        Label l2=new Label("department name");
        Label l4=new Label("dnumber");
        t1=new TextField(15);
        t2=new TextField(15);
        b1=new Button("add dept");
        Label l3=new Label("Existing departments");
        l4.setFont(myFont);l2.setFont(myFont);
        t1.setFont(myFont);t2.setFont(myFont);
        b1.setFont(myFont);l3.setFont(myFont);
        add(l4);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        initList();
        add(l3);
        add(l1);
        b1.addActionListener(this);
        addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        
    }
    void initList()
    {   try
        {   Class.forName(EMPCRUD2.driver);
            Connection conn = DriverManager.getConnection
          (EMPCRUD2.DB_URL,EMPCRUD2.USER,EMPCRUD2.PASS);
            String s="select * from Department";
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(s);//used with select command to read data from the table
            rs=stmt.executeQuery(s);//used with select command to read data from the table
            l1=new List();
            l1.setFont(myFont);
            while(rs.next())
            {  Integer r=rs.getInt("dnumber");
              // cnt++;
               l1.add(rs.getString("dname"));
            } 
            conn.close();
        }
        catch(ClassNotFoundException | SQLException e){}
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {   String s=e.getActionCommand();
        if(s.equals("add dept"))
        {   try
            {Statement stmt = null;
            int dno=Integer.parseInt(t1.getText());
            String dname=t2.getText();
            Class.forName(EMPCRUD2.driver);
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(EMPCRUD2.DB_URL, EMPCRUD2.USER,EMPCRUD2.PASS);
            System.out.println("inserting record...");
            stmt = conn.createStatement();//insert into empdata values(123,'tina','hr',23000)
            String sql = "INSERT INTO department "
               + "(dnumber,dname)"+ " VALUES ("+dno+",'"+dname+"')"; 
            stmt.executeUpdate(sql);
            System.out.println("data record added to table successfully");
            conn.close();
            conn=DriverManager.getConnection
        (EMPCRUD2.DB_URL,EMPCRUD2.USER,EMPCRUD2.PASS);
            String s1="select * from department";
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(s1);//used with select command to read data from the table
            JTable jTable2=new JTable();
           jTable2.setModel(DbUtils.resultSetToTableModel(rs));
           JFrame j1=new JFrame();
           Font myFont=new Font("Tahoma", 1, 22); 
           JScrollPane pg = new JScrollPane(jTable2);
           pg.setFont(myFont);
           j1.add(pg);
           j1.setSize(500, 300);
           j1.setVisible(true);
           conn.close();
           }
          catch(ClassNotFoundException | SQLException e1){}
        }
    }
    
}
