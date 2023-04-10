 
package javaaplication9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MenuCRUD extends Frame implements ActionListener
{   MenuBar m1;
    Menu CRUD,dept1;
    
    MenuCRUD()
    {   m1=new MenuBar();
        CRUD=new Menu("crud");
        dept1=new Menu("dept");
        Font myFont=new Font("Arial", 1, 20); 
        CRUD.setFont(myFont);
        m1.setFont(myFont);
        MenuItem i1=new MenuItem("INSERT DATA");
        MenuItem i2=new MenuItem("DELETE DATA");
        MenuItem i3=new MenuItem("UPDATE DATA");
        MenuItem i4=new MenuItem("SELECT DATA");
        MenuItem i5=new MenuItem("ADD DEPT");
        CRUD.add(i1);
        CRUD.add(i2);
        CRUD.add(i3);
        CRUD.add(i4);
        dept1.add(i5);
        m1.add(CRUD);
        m1.add(dept1);
        setMenuBar(m1);
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        setLayout(new BorderLayout(100,100));
        addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String args[])
    {   MenuCRUD m4=new MenuCRUD();
        m4.setVisible(true);
        m4.setSize(new Dimension(300,400));
    }
    public void actionPerformed(ActionEvent e) 
    {  String g=e.getActionCommand();
        EMPCRUD2.initconnectionData();
        if(g.equals("INSERT DATA"))
        {   InsertForm i=new InsertForm();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            i.show();
        }
        if(g.equals("DELETE DATA"))
        {   DeleteForm i=new DeleteForm();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            i.show();
        }
        if(g.equals("UPDATE DATA"))
        {   UpdateForm i=new UpdateForm();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            i.show();
        }
        if(g.equals("SELECT DATA"))
        {   EMPCRUD2 i=new EMPCRUD2();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            i.show();
        }
        if(g.equals("ADD DEPT"))
        {   AddDept i=new AddDept();
            i.setSize(new Dimension(370, 700));
            i.setVisible(true);
            i.show();
        }
    }
}
