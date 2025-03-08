package employee_management.system;
import java.sql.*;

public class Connectivity 
{
/*  42. NOW WE HAVE TO PERFORM THE SECOND STEP I.E.
        "CREATING THE CONNECTION STRING"*/   
    
/*  43. SO FOR THAT WE HAVE TO IMPLEMENT AN INTERFACE CALLED CONNECTION.
        THIS INTERFACE IS IN THE "import java.sql.*;" THIS PACKAGE. */    
    
    Connection c;
    
/* 46. WE HAVE TO PERFORM 3RD STEP I.E. "CREATING STATEMENT".
       THIS IS ALSO AN INTERFACE. */    
    Statement s;
    
    
 /* 40. WE ARE USING THE TRY AND CATCH BECAUSE MYSQL IS AN EXTERNAL 
        ENTITY SO WE MIGHT GET SOME ERROR. */   
    public Connectivity ()
    {
        try
        {
            
    /* 41. HERE WE HAVE TO PERFORM THE FIRST STEP THAT IS
           REGISTER THE DRIVER CLASS BY USING A CLASS CLASS CALLED FORNAME(). */      
           Class.forName("com.mysql.cj.jdbc.Driver");
           
    /* 44. NOW WE HAVE TO CREATE THE STRING.THIS IS 2ND STEP. SO WE HAVE TO USE 
           "DriverManager.getConnection()" THIS CLASS WITH THE STATIC 
           METHOD.*/ 
    
    /* 45. SO IN THIS METHOD WE HAVE TO MENTION FEW THINGS.
           a. WHICH DATATBASE YOU ARE USING .
           b. NAME OF THAT DATABASE YOU ARE USING FOR
           c. WE HAVE TO MENTION THE ADDRESS OF MYSQL WHERE IT IS RUNNING.
           d. WE HAVE TO MENTION THE DATABASE NAME
           e. WE HAVE TO MENTION THE USERNAME OF THE MYSQL
           F. WE HAVE TO MENTION THE USERNAME PASSWORD OF MYSQL */
    
           c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                   + "employeemanagementsystem","root","Rishikesh@078700");
           
    // 47. THIS IS HOW WE HAVE TO MAKE 3RD STEP        
           s = c.createStatement();
           
    // 48. NOW WE HAVE IMPLEMENT THE 4TH STEP I.E. "EXECUTING MYSQL QUERIES"
    
    // LINE NO 49 IS IN THE LOGIN PAGE.       
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

/* 38. NOW WE HAVE TO CONNECT TO DATABASE FOR STOREING THE DATA
       FROM THE USER INPUT. */

/* 39. IN ORDER TO CONNECT TO HTE DATABASE WE NEED TO PERFORM 5 STEPS.
      1. REGISTER THE DRIVER CLASS
      2. CREATING THE CONNECTION STRING
      3. CREATING STATEMENT
      4. EXECUTING MYSQL QUERIES
      5. CLOSING THE CONNECTIONS */