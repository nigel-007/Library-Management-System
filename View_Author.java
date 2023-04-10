package javaaplication9;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class View_Author extends Frame implements ActionListener
{  static String USER ;
    static  String PASS;
    static  String driver;
    static  String DB_URL;
 
    Button jButton4;
    ScrollPane jScrollPane1;
    TextArea jTextArea1;
    public View_Author()
    {   addWindowListener(new WindowAdapter()
        {   public void windowClosing(WindowEvent we)
            {   System.exit(0); }
        });
   
        Font myFont=new Font("Tahoma", 1, 26); // NOI18N
        setLayout(new FlowLayout());
        jButton4 = new Button("Select");
        jButton4.setFont(myFont);
        add(jButton4);
        jButton4.addActionListener(this);
        View_Author.initconnectionData();
    }
    static void initconnectionData()
   {  USER ="root";
      PASS="";
      driver="com.mysql.jdbc.Driver";
      DB_URL = "jdbc:mysql://localhost/library_management";
   }
    public void actionPerformed(ActionEvent e)
    {   String g=e.getActionCommand();
       
        if(g.equals("Select"))
        {   try
            {   Class.forName(driver);
                System.out.println("Connecting to database...");
         Connection conn =
          DriverManager.getConnection(DB_URL, USER, PASS);
                String s= "select * from author;";
                Statement stmt = conn.createStatement();
                ResultSet rs=stmt.executeQuery(s);
                JTable jTable1=new JTable();
                Font myFont=new Font("Tahoma", 1, 16);
                jTable1.setFont(myFont);
                jTable1.setModel
        (DbUtils.resultSetToTableModel(rs));
                JFrame j1=new JFrame();
                JScrollPane pg = new JScrollPane(jTable1);
                pg.setFont(myFont);
                j1.add(pg);
                j1.setSize(500, 300);
                j1.setVisible(true);
                conn.close();
            }
        catch(ClassNotFoundException | SQLException y){}
        }
    }
    public static void main(String args[])
    {   View_Author e=new View_Author();
        e.setSize(new Dimension(370, 700));
        e.setTitle("GraphicsDemo");
        e.setVisible(true);
    }
}