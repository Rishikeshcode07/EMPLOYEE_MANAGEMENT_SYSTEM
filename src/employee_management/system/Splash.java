package employee_management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener 
        
   /* 32. SO TO PERFORM THE ACTION ON HTE BUTTON WE HAVE TO IMPLEMENT
          ACTIONLISTENER. THIS IS IN THE "import java.awt.event.*;" PACKAGE.
          */  
        
   // LINE NO 33 IS IN THE BUTTOM.     
{
    
    // 2. THE MAIN WORK WILL BE DONE IN THIS CONSTRUCTOR.

    /* 3. THE MAIN GOAL IS THAT AS SOON AS I RUN THE CLASS 
          THE FRAME SHOULD BE AVAILABLE IN FRONT OF THE SCREEN. */
    
    // 4. SO FOR MAKING OF THE FRAME WE USE A CLASS CALLED JFRAME
    // 5. THIS CLASS COMES FROM THE SWING PACKAGE WHICH IS THE EXTENED PACKAGE.
    
    Splash()
    {
        getContentPane().setBackground(Color.WHITE);
     /* 10. SO TO CHANGE THE COLOR OF THE FRAME WE CAN USE 
            "setBackground(Color.WHITE)" WHICH COMES UNDER AWT PACKAGE.  */
     
     /* 11. "getContentPane()" THIS FUNCTION IS USED TO GET 
             ACCESS OF THE ENTIRE FRAME. */
     
        setLayout(null);
     /* 14. SO BY MENTIONING THE "setLayout(null)"FUNCTION, WE ARE GIVING THE 
            INSTRUCTION TO THE SWING THAT , I DON'T WANT TO USE 
            YOUR LAYOUTS, RATHER THAN I WILL MAKE THE LAYOUTS BY MY OWN. */  
        
        
     /* 12. SO, TO WRITE ANYTHING ON THE FRAME WE USE A CLASS CALLED JFRAME.
            SO WHATEVER YOU WILL WRITE IN THE OBJECT CLASS, 
            IT WILL SHOW IN THE FRAME */
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        
        
     /* 15. SO, TO MAKE YOUR OWN LAYOUT WE HAVE TO USE A METHOD CALLED 
            "object.setBound(left from the frame,
                             top from the frame,
                             length of the heading,
                             wridth of the heading)" */   
        heading.setBounds(80, 30, 1200,60);
        
     // 16. THIS LINE HELPS TO CHANGE THE FONT COLOR AND SIZE OF THE OBJECT   
        heading.setFont(new Font("serif",Font.PLAIN,60));
        
     // 17. THIS LINE HELPS TO CHANGE THE COLOR OF THE TEXT.    
        heading.setForeground(Color.RED);
        
     /*  13. SO TO SHOW WHAT YOU HAVE WRITTEN IN THE OBJECT SECTION
             ON THE SCREEN, YOU HAVE TO USE A FUNCTION CALLED 
             "add(object passing)". */   
        add(heading);
       
        
      /*  18. SO , NOW WE HAVE TO PICK THE IMAGE. SO, TO DO SO WE HAVE TO USE 
              A CLASS CLASS "ImageIcon". AND TO PICK THE IMAGE FROM YOUR SYSTEM
              WE HAVE TO USE DIRECTORY CALLED "ClassLoader.getSystemResource" */
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        
      /*  19. NOW TO PASTE THE IMAGE WE HAVE TO USE "i1.getImage()" FUNCTION 
              TO PICK THE IMAGE AND TO SCALE IT WE HAVE TO USE A FUNCTION 
              CALLED "getScaledInstance()". */  
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        
        
      /*  20. SO TILL NOW , WE HAVE PICKED THE IMAGE AND SCALED IT , 
              BUT NOW WE HAVE TO PASTE THE IMAGE IN THE FRAME. SO
              INORDER TO DO THAT WE HAVE TO CREATE THE JLABLE TO PASTE
              IN HTE FRAME. BUT BEFORE, WE HAVE TO CONVERT TO IMAGEICON 
              SO THAT WE CANNOT DIRECTLY ADD THE IMAGE. SO TO ADD WE HAVE
              WE HAVE TO CREATE THE JLABLE WITH THE LOCATIONS. */  
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
      // 21. KNOW WE HAVE TO CREATE THE BUTTON  
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        
      /* 33. HERE WE HAVE TO ADD "addActionListener(this)" METHOD
             FOR CLICK EVENT  */
        clickhere.addActionListener(this);
        image.add(clickhere);
        
     /*  34. NOW THE NEXT THING WE HAVE TO DO IS THAT WE HAVE  
             TO JOIN TWO PAGES.*/ 
     
     /*  35. SO NOW AS WE HAVE ADD THE CLICK EVENT ON THE BUTTON
             THE NEXT THING WE HAVE TO DO IS TO CONNECT TWO PAGES
             I.E. IS SPLASH ANF LOGIN PAGE.*/
     
     /*  36. SO TO DO THAT WE HAVE PERFORMED THE ACTION IN THE THIS
             "actionPerformed(ActionEvent ae)" CLASS. */
     
     // LINE NO 37 IS IN THE BUTTOM
        
        
     /* 31. SO NOW WE HAVE TO CONNECT TO THE LOGIN PAGE BY CLICKING 
            THE BUTTON "CLICK HERE TO CONTINUE"IN THE SPLASH PAGE.
            SO IN ORDER TO DO THAT WE HAVE TO CREATE THE EVENT ON HTE BUTTON
            SO THAT WE CAN PERFORM SOME ACTION ON IT IN ORDER TO CONNECT 
            THESE TWO PAGES.*/ 
     
     // LINE NO 32 IS ON THE TOP.
        
        
        
        
        
    // 6. THE VERY FIRST THING IS THAT TO SET THE SIZE OF THE FRAME 
    // 7. SO TO DO SO WE USE "setSize(length,breadth)"function.     
       setSize(1170, 650);
      
       
       setLocation(200, 50);
    /* 9. SO,BY DEFAULT THE LOCATION OF THE FRAME IS FROM THE TOP LEFT.
          BUT TO REALLOCATE THE FRAME LOCATION WE CAN USE
          setLocation(distance from left,distance from top). */  
    
    // LINE NO 10 IS ON TOP.
       
       setVisible(true);
    /* 8. SO BY DEFAULT THE VISIBILITY OF THE FRAME IS FALSE , TO MAKE IT
          VISIBLE , WE HAVE TO USE setVisible(true). */
      
    
    /* 21. SO WHAT I WANT IS THAT I HAVE TO MAKE THE HEAADING LITTLE DIPPER
           SO IN ORDER TO DO THAT WE HAVE TO USE WHILE LOOP .*/
       while(true)
       {
           heading.setVisible(false);
           try 
           {
               Thread.sleep(500); 
     // 22. THIS METHOD IS USED TO STOP THE RUNNING THE CODE FOR HALF A SECOND.        
     // NEXT LINE NO 23 WILL BE IN LOGIN PAGE          
           }
           catch(Exception e)
           {
               
           }
           
           heading.setVisible(true);
              try 
           {
               Thread.sleep(500);
           }
           catch(Exception e)
           {
               
           }
       }
    }
    
    
    /* 37. SO HERE WE HAVE TO FIRST CLOSE THE SPLASH PAGE AND
           THEN WE HAVE TO CALL THE LOGIN PAGE FOR THE CONNECTION.
           BY DOING THAT WE WILL CONNECT TO THE LOGIN PAGE. */
    
    // LINE NO 38 IS IN THE CONNECTIVITY PAGE
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
    }
 public static void main(String args[])
 {
     new Splash();
     /* 1. FIRST WE WILL CREATE THE CLASSS OBJECT
           AND THE COSNTRUCTOR WILL BE CALLED.I.E SPLASH() */
     
     // LINE NO 2 IS IN THE TOP.
 }
}
/* NOTE :- AS SOON AS YOU RUN THE CODE THE MAIN METHOD WILL BE CALLED FIRST,
           AND IN THE MAIN METHOD THERE IS AN OBJECT AND THAT WILL BE CALLED 
           NEXT AND AFTER THAT CONSTRUCTOR WILL BE CALLED . THAT'S THE
           REASON I HAVE DONE ALL THE CODE INSIDE THE CONSTRUCTOR. */