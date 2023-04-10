package javaaplication9;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class EMPCRUD2 extends Frame implements ActionListener
{  static String USER ;
    static  String PASS;
    static  String driver;
    static  String DB_URL;
    Button jButton1;
    Button jButton2;
    Button jButton3;
    Button jButton4;
    ScrollPane jScrollPane1;
    TextArea jTextArea1;
    public EMPCRUD2() 
    {   addWindowListener(new WindowAdapter() 
        {   public void windowClosing(WindowEvent we) 
            {   System.exit(0); }
        });
        Font myFont=new Font("Tahoma", 1, 26); // NOI18N
        setLayout(new FlowLayout());
        jButton1 = new Button("insert data");
        jButton2 = new Button("update data");
        jButton3 = new Button("delete data");
        jButton4 = new Button("select");
        jButton1.setFont(myFont);
        jButton2.setFont(myFont);
        jButton3.setFont(myFont);
        jButton4.setFont(myFont);
        jScrollPane1 = new ScrollPane();
        jTextArea1 = new TextArea();
        jTextArea1.setColumns(500);
        jTextArea1.setRows(500);
        jTextArea1.setFont(myFont);
        jScrollPane1.add(jTextArea1);
        add(jButton1);
        add(jButton2);
        add(jButton3);
        add(jButton4);
        add(jScrollPane1);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        EMPCRUD2.initconnectionData();
    }
    static void initconnectionData()
   {  USER ="root";
      PASS="";
      driver="com.mysql.jdbc.Driver";
      DB_URL = "jdbc:mysql://localhost/library_management";
   }
    public void actionPerformed(ActionEvent e) 
    {   String g=e.getActionCommand();
        if(g.equals("insert data"))
        {   InsertForm i=new InsertForm();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            i.show();
        }
        if(g.equals("delete data"))
        {   DeleteForm i=new DeleteForm();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            i.show();
        }
        if(g.equals("update data"))
        {   UpdateForm i=new UpdateForm();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            i.show();
        }
        if(g.equals("select"))
        {   try
            {   Class.forName(driver);
                System.out.println("Connecting to database...");
         Connection conn =
          DriverManager.getConnection(DB_URL, USER, PASS);
                String s="";
                Statement stmt = conn.createStatement();
                ResultSet rs=stmt.executeQuery(s);
                JTable jTable1=new JTable();
                Font myFont=new Font("Tahoma", 1, 26); 
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
    {   EMPCRUD2 e=new EMPCRUD2();
        e.setSize(new Dimension(370, 700));
        e.setTitle("GraphicsDemo");
        e.setVisible(true);
    }
}
