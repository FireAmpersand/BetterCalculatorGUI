/*
 * The controller classes (like the ViewUserActions class) provides actions
 * that the user can trigger through the view classes.  Those actions are 
 * written in this class as private inner classes (i.e. classes 
 * declared inside another class).
 *
 * You can use all the public instance variables you defined in AllModelsForView, 
 * DrawnView, and ViewOutputs as though they were part of this class! This is 
 * due to the magic of subclassing (i.e. using the extends keyword).
 */
package cs20viewcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ViewUserActions is a class that contains actions users can trigger.
 *
 * User actions are written as private inner classes that implements the
 * ActionListener interface. These actions must be "wired" into the DrawnView in
 * the ViewUserActions constructor, or else they won't be triggered by the user.
 *
 * Actions that the user can trigger are meant to manipulate some model classes
 * by sending messages to them to tell them to update their data members.
 *
 * Actions that the user can trigger can also be used to manipulate the GUI by
 * sending messages to the view classes (e.g. the DrawnView class) to tell them
 * to update themselves (e.g. to redraw themselves on the screen).
 *
 * @author cheng
 */
public class ViewUserActions extends ViewOutputs {
    
    public class Work implements ActionListener {
        
        public int number;

        public Work (int number){
            this.number = number;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if (cal.getState().equals("first") && cal.pow == false){
                String newNumber = Integer.toString(this.number);
                cal.setFirst(newNumber);
                updateDisplay();
            }else if (cal.getState().equals("second") && cal.pow == false){
                String newNumber = Integer.toString(this.number);
                cal.setSecond(newNumber);
                updateDisplay();
            }else if (cal.pow == true){
                String newNumber = Integer.toString(this.number);
                cal.setPower(newNumber);
                updateDisplay();
            }
            
        }
    }
    
    //Sign Class
    public class Sign implements ActionListener{
        
        public int sign;
        
        public Sign(int type){
            this.sign = type;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            cal.setSign(sign);
            signDisplay();
        }
    }
    //Equals Class
    public class Equals implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            cal.setfinal();
            cal.setState("end");
            finDisplay();
        }
    }
    
    public class Clear implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            cal.firstNum = 0;
            cal.firstDecNum = 0;
            cal.secDecNum = 0;
            
            cal.secNum = 0;
            cal.firstSecondNum = 0;
            cal.secSecondNum = 0;
            
            cal.dec = false;
            cal.pow = false;
            cal.firstRoot = false;
            cal.secondRoot = false;
            cal.firstPower = 0;
            cal.secondPower = 0;
            cal.state = "first";
            cal.setSign(4);
            clearDisplay();
        }
    }
    
    
    public class Decimal implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            cal.setDec();
        }
    }
    
    
    public class Negative implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            cal.setNegative();
            updateDisplay();
        }
    }
    
    public class Power implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            cal.setPow();
            powerDisplay();
        }
    }
    
    public class Root implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            cal.setRoot();
            rootDisplay();
        }
    }
    
    public class On implements ActionListener{
        public boolean off = false;
        @Override
        public void actionPerformed(ActionEvent ae){
            if (this.off == false){
                this.off = true;
                turnOffDisplay();
            }else if (this.off == true){
                this.off = false;
                updateDisplay();
            }
        }
    }
    
    public ViewUserActions() {
        
        //Numbers
        numOne.addActionListener(new Work(1));
        numTwo.addActionListener(new Work(2));
        numThree.addActionListener(new Work(3));
        numFour.addActionListener(new Work(4));
        numFive.addActionListener(new Work(5));
        numSix.addActionListener(new Work(6));
        numSeven.addActionListener(new Work(7));
        numEight.addActionListener(new Work(8));
        numNine.addActionListener(new Work(9));
        numZero.addActionListener(new Work(0));
        //Buttons
        plusButton.addActionListener(new Sign(0));
        subButton.addActionListener(new Sign(1));
        multiButton.addActionListener(new Sign(2));
        divideButton.addActionListener(new Sign(3));
        negativeButton.addActionListener (new Negative());
        equalsButton.addActionListener(new Equals());
        clearButton.addActionListener(new Clear());
        decimalButton.addActionListener(new Decimal());
        powButton.addActionListener(new Power());
        rootButton.addActionListener(new Root());
        onButton.addActionListener(new On());
        
    }
}
