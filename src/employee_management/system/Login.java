package employee_management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener
        
/* 49. NOW WHAT WE HAVE TO DO IS THAT , WE HAVE TO PULLOUT THE DATA FROM THE
       USER WHICH HE/SHE IS INSERTING INTO THE TEXTFIELD AND WE HAVE TO 
       COMPAIRE IT WITH THE DATABASE , SO THAT IT SHOULD MATCH IT. 
       BY DOING THIS WE CAN MOVE TO THE NEXT PAGE.*/ 
        
/* 50. SO TO DO THAT WE HAVE TO IMPLEMENT ACTIONLISTENER. */        
// NEXT LINE NO 51 IS AT THE BUTTOM        
{
 
    JTextField tfusername , tfpassword;
    
    
    Login()
    {
        
     // 24. THIS LINE WILL CHANGE THE BACKGROUND COLOR    
       getContentPane().setBackground(Color.WHITE);
       
     // 25. THIS MEANING OF THIS LINE IN THE LINE NO 14.  
       setLayout(null);
     
     /* 26. IT WILL SHOW THE USERNAME WRITTEN IN THE FRAME AT 
            THE PERTICULAR LOCATION  */
       JLabel lblusername = new JLabel("Username");
       lblusername.setBounds(40,20,100,30);
       add(lblusername);
      
     /* 28. SO NOW WHATEVER INPUT YOU WANT TO PASS FROM THE USER FOR THAT
            FIRST YOU HAVE TO CREATE THE TEXT FEILD AREA WHERE YOU WILL
            WRITE THE USER NAME .SO FOR THAT WE HAVE USE "JTextField()" METHOD
            WITH THE LOCATION. */  
       tfusername = new JTextField();
       tfusername.setBounds(150, 20, 150, 30);
       add(tfusername);
      
       
     /* 27. IT WILL SHOW THE PASSWORD WRITTEN IN THE FRAME AT 
            THE PERTICULAR LOCATION  */  
       JLabel lblpassword = new JLabel("Password");
       lblpassword.setBounds(40,70,100,30);
       add(lblpassword);
      
       
     /* 29. SO NOW WHATEVER PASSWORD YOU WANT TO PASS FROM THE USER FOR THAT
            FIRST YOU HAVE TO CREATE THE TEXT FEILD AREA WHERE YOU WILL
            WRITE THE USER NAME .SO FOR THAT WE HAVE USE "JTextField()" METHOD
            WITH THE LOCATION. */   
       tfpassword = new JTextField();
       tfpassword.setBounds(150, 70, 150, 30);
       add(tfpassword);
       
     /* 30. THIS IS HOW WE HAVE TO MAKE BUTTON. */  
        JButton Login = new JButton("LOGIN");
        Login.setBounds(150, 140, 150, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);
        
     /* 31. THIS IS HOW WE HAVE TO MAKE AN IMAGE AS PER IN THE PREVIOS PAGE.
            WITH THE DETAILED OF EACH LINE. */    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
     // LINE NO 31 IS IN THE SPLASH PAGE.   
        
       
    /* 23. THIS IS FOR THE LOCATION OF THE FRAME
           AND TO SET THE SIZE AND VISIBILITY OF THE FRAME */  
    // LINE NO 24 IS ON THE ABOVE
       setSize(600,300);
       setLocation(450,200);
       setVisible(true);
    }
    
    /* 51. SO VERY FIRST THING WE HAVE TO DO IS WE HAVE TO ADD 
           ACTIONLISTNER IN THE LOGIN BUTTON. THE MOTIVE OF DOING IS THAT 
           AS YOU CLICK ON THE LOGIN BUTTON WE CAN FETCH OUT THE DATA
           FROM THE TEXTFIELD ADN CAN COMPAIRE IT WITH THE DATABASE RECORD. */
    
    
    /* 52. SO BY DOING THIS WE CAN MAKE SURE THAT WE HAVE THE ENTRED VALUE IS 
           CORRECT OR NOT . AND IF CORRECT THEN WE HAVE TO CLOSE THIS PAGE 
           AND MOVE ON TO THE NEXT PAGE. */
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
     
    /*  53. SO HERE YOU CAN SEE THAT BY USING "getText()" METHOD 
            WE CAN PULL OUT THE TEXT FROM THE TEXTFILED FROM BOTH THE
            VARIABLES. */        
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Connectivity  c = new Connectivity();
            
     /* 54. THIS QUERY WILL HELP TO CHECK WHEATHER THE DATA IS PRESENT
            OR NOT IN THE DATABASE. */
            String query = "select * from Login where username = '"+username+"' and password = '"+password+"' ";
          
            
     /* 55. HERE WE ARE IN THE 4TH STEP I.E. "EXECUTING MYSQL QUERIES"
            TO PERFORM THAT WE HAVE TO USE A FUNCTION CALLED 
            "executeQuery(query)". */  
    
     /* 56. SO TO EXICUTE THAT FUNCTION FIRST WE HAVE TO CREATE AN OBJECT
            OF "Connectivity" . */
    
     /* 57. SO THIS STATEMENT WILL RETURN THE VALUE, BUT WE HAVE
            TO STORE IT IN THE OBJECT AND THE RESULT WILL BE IN 
            RESULTSET OBJECT. */
    
     /* 58. THIS "ResultSet" OBJECT COMES UNDER "java.sql.*" PACKAGE. */
            ResultSet rs = c.s.executeQuery(query);
            
            if(rs.next())
            {
     /*  59. SO IF YOU GET THE VALUE THEN YOU HAVE TO STOP THIS PAGE AND 
             AND GOES TO THE NEXT PAGE.    */            
                setVisible(false);
                new Home();
            }
            else
            {
     /*  60. SO NOW IF WE DON'NT GET THE VALUE THEN WE HAVE TO SHOW A 
             POPUP WITH THE MESSAGE. SO TO DO THAT WE HAVE A METHOD CALLED
             "JOptionPane.showMessageDialog" METHOD WHICH HELPS TO 
             POPUP SOME MESSAGE .  */            
             JOptionPane.showMessageDialog(null,"Invalid username or password");
             setVisible(false);
             
        // LINE NO 61 IS IN THE HOME PAGE.     
            }
            
        }
        catch(Exception e)
                {
                    
                }
    }
    
    
    public static void main(String args[])
    {
        new Login();
    }
}
