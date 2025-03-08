package employee_management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{

// 86.  WITH THE HELP OF JLABLE WE CAN CREATE THE TABLE. 
    JTable table;
    Choice cemployeeId;
    JButton search, print, update, back;
    
    ViewEmployee() {
        
// 85.  THEN WE HAVE TO CHANGE THE BACKGROUND COLOUR OF THE FRAME.        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
// 89.  NOW WE HAVE TO ADD SEARCH BUTTON         
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
 
        
/*  90. FIRST WE HAVE TO MAKE A DROPDOWN FOR WHICH EMPLOYEE YOU HAVE TO 
        LOOK FROM THERE EMPLOYEE ID. SO TO DO THAT WE HAVE TO USE 
        CHOICE() FUNCTION. WE PREVIOULY MADE THE DROPDOWN WITH THE HELP OF
        "JComboBox()", BUT NOW WE WILL USE "CHOICE()". */        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        
/*  91. NOW AGAIN WE HAVE TO CONNECT TO THE DATABASE TO EXTRACT THE DATA
        FROM THE DATABASE FOR THAT PERTICULAR EMPLOYEE BY THERE ID. */           
        try {
            Connectivity  c = new Connectivity ();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()) {
                cemployeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
 /* 87. NOW WE HAVE TO INSERT THE DATA INTO THE TABLE . SO IN ORDER TO
        DO THAT WE HAVE TO USE TR AND CATCH BLOCK BEACUSE WE HAVE TO 
        PICK THE DATA FROM THE MYSQL AND IT IS EXTERNAL ENTITY SO
        IT MIGHT GICE SOME ERRORS. */        
        table = new JTable();
        
        try {
            Connectivity  c = new Connectivity ();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
 /* 88. IF THE DATA IS OVERFLOW THEN WE CAN USE SCROLL. TO USE SCROLL WE 
        CAN USE "JScrollPane()". */
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
       
        
 // 92. NOW WE HAVE TO MAKE 4 BUTTONS FOR NEXT FURTHER OPERATIONS.       
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
 
// 84.  FIRST WE HAVE TO FIX THE SIZE OF THE FRAME FOR VIEW EMPLOYEE
// 85 IS ON TOP
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    
// 93. NOW WE HAVE TO PERFORM AND EXTRACT THE INFORMATION FROM THE DATABASE.    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
            try {
                Connectivity  c = new Connectivity ();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
