package employee_management.system;


/* 61. SO HERE IN HTIS PAGE WE JUST HAVE TO DO ALL THE PREVIOUS STEPS
       EG :-  CREATING 4 BUTTONS, MAKE THEM FUNCTIONAL BY ADDING 
              ACTIONLISTENER TO THEM, MADE THEM IN THE LOCATION,
              ADDING THE IMAGE .*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener
{
    
  JButton view, add, update,remove;  
    
  Home()
  {
      setLayout(null);
      
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("TAHOMA",Font.BOLD,25));
        image.add(heading);
        
        
        add = new JButton("Add Employee");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        image.add(add);
       
        view = new JButton("View Employee");
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Employee");
        update.setBounds(650,140,150,40);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(820,140,150,40);
        remove.addActionListener(this);
        image.add(remove);
        
        
        
      
      setSize(1120, 630);
      setLocation(250,100);
      setVisible(true);
  }
  
    public void actionPerformed(ActionEvent ae)
    {
    /* 61. NOW HERE WE HAVE TO DIFFERENCIATE THAT TO WHICH BUTTON 
           WE HAVE CLICKED. SO DO SO WE HAVE TO USE A FUNCTION
           CALLED "getSource()". THIS WILL GIVE YOU THE SOURCE OF THE CLICK. */    
        
    /* 62. SO IF THE SOURCE OF THE CLICK IS ADD BUTTON THEN WE HAVE TO PERFORM
           ADD OPERATION. */    
        
        if(ae.getSource() == add)
        {
            setVisible(false);
            new AddEmployee();
        }
    /* 63. SO IF THE SOURCE OF THE CLICK IS VIEW BUTTON THEN WE HAVE TO PERFORM
           VIEW OPERATION. */     
        else if (ae.getSource() == view)
        {
            setVisible(false);
            new ViewEmployee();
        }
        
    /* 64. SO IF THE SOURCE OF THE CLICK IS  UPDATE BUTTON THEN WE HAVE 
           TO PERFORM UPDATE OPERATION. */  
        
     // NEXT LINE NO 65 IS IN THE ADDEMPLOYEE PAGE   
        else if (ae.getSource() == update)
        {
            setVisible(false);
            new ViewEmployee();
        }
        
        else 
        {
            setVisible(false);
            new RemoveEmployee();
        }
    }

    public static void main(String args[])
    {
        new Home();
    }
    
}
