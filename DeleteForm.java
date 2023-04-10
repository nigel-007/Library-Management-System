package javaaplication9;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
public class DeleteForm extends Frame implements ActionListener
{   Choice Bid;Button jButton;Label jLabel1;
    Label jLabel2;
    DeleteForm()
    {   Bid=new Choice();
        setLayout(new FlowLayout());
        jButton=new Button("Delete data");
        jLabel1 = new Label();
        jLabel1.setText("Bid");
        initCombo();
        Font myFont=new Font("Tahoma", 1, 14); // NOI18N
        addWindowListener(new WindowAdapter() 
        {   public void windowClosing(WindowEvent we) 
            {   System.exit(0); }
        });
        jLabel1.setFont(myFont);
        add(jLabel1);add(Bid);add(jButton);
        jButton.addActionListener(this);
    }
    void initCombo()
    {   try
        {   Class.forName(Library.driver);
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.
                    getConnection(Library.DB_URL,Library.USER,Library.PASS);
            String s="Select Bid from book";
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(s);//used with select command to read data from the table
            while(rs.next())
            {          Integer r=rs.getInt("Bid");
                       Bid.addItem(r.toString());
            } 
            conn.close();
        }
        catch(ClassNotFoundException | SQLException e){}
    }
    public void actionPerformed(ActionEvent e)
    { String s=e.getActionCommand();
      if(s.equals("Delete data"))
      {     try
        {   Statement stmt = null;
            String bno=Bid.getSelectedItem().toString();
            Class.forName(Library.driver);
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.
                    getConnection(Library.DB_URL,
                            Library.USER,Library.PASS);
            System.out.println("Deleting record...");
            stmt = conn.createStatement();
            String sql = "delete from book where Bid="+bno; 
            stmt.executeUpdate(sql);
            System.out.println("data record deleted from table successfully");
            conn.close();
        }
        catch(ClassNotFoundException | SQLException e4){}
      }
    }
}
