package cs20viewcontroller;

/**
 * Write methods in this class for displaying data in the DrawnView.
 *
 * You can use all the public instance variables you defined in AllModelsForView
 * and DrawnView as though they were part of this class! This is due to the
 * magic of subclassing (i.e. using the extends keyword).
 *
 * The methods for displaying data in the DrawnView are written as methods in
 * this class.
 *
 * Make sure to use these methods in the ViewUserActions class though, or else
 * they will be defined but never used!
 *
 * @author cheng
 */
public class ViewOutputs extends DrawnView {

    //Main Update Display
    public void updateDisplay() {

        if (cal.getState().equals("first")) {
            if (cal.firstPower == 0 && cal.firstRoot == false) {
                String number = Double.toString(cal.firstNum);
                display.setText(number);
            } else if (cal.firstPower != 0 && cal.firstRoot == false) {
                String number = Double.toString(cal.firstNum);
                String power = Integer.toString(cal.firstPower);
                String newNumber = number + "^" + power;
                display.setText(newNumber);
            } else if (cal.firstPower == 0 && cal.firstRoot == true) {
                String number = Double.toString(cal.firstNum);
                String newNumber = "√" + number;
                display.setText(newNumber);
            } else if (cal.firstPower != 0 && cal.firstRoot == true) {
                String number = Double.toString(cal.firstNum);
                String power = Integer.toString(cal.firstPower);
                String newNumber = "√" + number + "^" + power;
                display.setText(newNumber);
            }
        } else if (cal.getState().equals("second")) {

            String first = Double.toString(cal.firstNum);
            String sign = "";
            if (cal.sign == 0) {
                sign = "+";
            } else if (cal.sign == 1) {
                sign = "-";
            } else if (cal.sign == 2) {
                sign = "*";
            } else if (cal.sign == 3) {
                sign = "/";
            }

            String second = Double.toString(cal.secNum);
            String power = Integer.toString(cal.firstPower);
            String power2 = Integer.toString(cal.secondPower);
            //__________________________________________________________________
            if (cal.secondPower == 0 && cal.secondRoot == false) {//-----       FIX THE DISPLAY FOR THE SECOND ROOT
                if (cal.firstPower == 0 && cal.firstRoot == false) {
                    display.setText(first + sign + second);
                } else if (cal.firstPower != 0 && cal.firstRoot == false) {
                    display.setText(first + "^" + power + sign + second);
                } else if (cal.firstPower == 0 && cal.firstRoot == true) {
                    display.setText("√" + first + sign + second);
                } else if (cal.firstPower != 0 && cal.firstRoot == true) {
                    display.setText("√" + first + "^" + power + sign + second);
                }
                //__________________________________________________________________
            } else if (cal.secondPower != 0 && cal.secondRoot == false) {//---  
                if (cal.firstPower == 0 && cal.secondPower != 0 && cal.firstRoot == false) {
                    String number = first + sign + second + "^" + power2;
                    display.setText(number);
                } else if (cal.firstPower != 0 && cal.secondPower != 0 && cal.firstRoot == false) {
                    String number = first + "^" + power + sign + second + "^" + power2;
                    display.setText(number);
                } else if (cal.firstPower == 0 && cal.secondPower != 0 && cal.firstRoot == true) {
                    String number = "√" + first + sign + second + "^" + power2;
                    display.setText(number);
                } else if (cal.firstPower != 0 && cal.secondPower != 0 && cal.firstRoot == true) {
                    String number = "√" + first + "^" + power + sign + second + "^" + power2;
                    display.setText(number);
                }
                //__________________________________________________________________ ---WORKS    
            } else if (cal.secondPower == 0 && cal.secondRoot == true) {//---  

                if (cal.firstPower == 0 && cal.firstRoot == false) {
                    display.setText(first + sign + second);
                } else if (cal.firstPower != 0 && cal.firstRoot == false) {
                    display.setText(first + "^" + power + sign + "√" + second);
                } else if (cal.firstPower == 0 && cal.firstRoot == true) {
                    display.setText("√" + first + sign + "√" + second);
                } else if (cal.firstPower != 0 && cal.firstRoot == true) {
                    display.setText("√" + first + "^" + power + sign + "√" + second);
                }
                //__________________________________________________________________
            } else if (cal.secondPower != 0 && cal.secondRoot == true) {//---      

                if (cal.firstPower == 0 && cal.secondPower != 0 && cal.firstRoot == false) {
                    String number = first + sign + second + "^" + power2;
                    display.setText(number);
                } else if (cal.firstPower != 0 && cal.secondPower != 0 && cal.firstRoot == false) {
                    String number = first + "^" + power + sign + second + "^" + power2;
                    display.setText(number);
                } else if (cal.firstPower == 0 && cal.secondPower != 0 && cal.firstRoot == true) {
                    String number = "√" + first + sign + "√" + second + "^" + power2;
                    display.setText(number);
                } else if (cal.firstPower != 0 && cal.secondPower != 0 && cal.firstRoot == true) {
                    String number = "√" + first + "^" + power + sign + "√" + second + "^" + power2;
                    display.setText(number);
                }
            }
            //__________________________________________________________________
        } else if (cal.state.equals("end")) {
            String number = Double.toString(cal.finNum);
            display.setText(number);
        }
    }
    //__________________________________________________________________________
    
    //Sign Display Method
    public void signDisplay() {
        if (cal.sign == 0) {
            String number = Double.toString(cal.getFirst());
            if (cal.firstPower == 0 && cal.firstRoot == false) {
                display.setText(number + "+");
            } else if (cal.firstPower != 0 && cal.firstRoot == false) {
                String power = Integer.toString(cal.firstPower);
                display.setText(number + "^" + power + "+");
            } else if (cal.firstPower == 0 && cal.firstRoot == true) {
                display.setText("√" + number + "+");
            } else if (cal.firstPower != 0 && cal.firstRoot == true) {
                String power = Integer.toString(cal.firstPower);
                display.setText("√" + number + "^" + power + "+");
            }
        } else if (cal.sign == 1) {
            String number = Double.toString(cal.getFirst());
            if (cal.firstPower == 0 && cal.firstRoot == false) {
                display.setText(number + "-");
            } else if (cal.firstPower != 0 && cal.firstRoot == false) {
                String power = Integer.toString(cal.firstPower);
                display.setText(number + "^" + power + "-");
            } else if (cal.firstPower == 0 && cal.firstRoot == true) {
                display.setText("√" + number + "-");
            } else if (cal.firstPower != 0 && cal.firstRoot == true) {
                String power = Integer.toString(cal.firstPower);
                display.setText("√" + number + "^" + power + "-");
            }
        } else if (cal.sign == 2) {
            String number = Double.toString(cal.getFirst());
            if (cal.firstPower == 0 && cal.firstRoot == false) {
                display.setText(number + "*");
            } else if (cal.firstPower != 0 && cal.firstRoot == false) {
                String power = Integer.toString(cal.firstPower);
                display.setText(number + "^" + power + "*");
            } else if (cal.firstPower == 0 && cal.firstRoot == true) {
                display.setText("√" + number + "*");
            } else if (cal.firstPower != 0 && cal.firstRoot == true) {
                String power = Integer.toString(cal.firstPower);
                display.setText("√" + number + "^" + power + "*");
            }
        } else if (cal.sign == 3) {
            String number = Double.toString(cal.getFirst());
            if (cal.firstPower == 0 && cal.firstRoot == false) {
                display.setText(number + "/");
            } else if (cal.firstPower != 0 && cal.firstRoot == false) {
                String power = Integer.toString(cal.firstPower);
                display.setText(number + "^" + power + "/");
            } else if (cal.firstPower == 0 && cal.firstRoot == true) {
                display.setText("√" + number + "/");
            } else if (cal.firstPower != 0 && cal.firstRoot == true) {
                String power = Integer.toString(cal.firstPower);
                display.setText("√" + number + "^" + power + "/");
            }
        }
    }
    //__________________________________________________________________________
    
    //Power Display Method
    public void powerDisplay() {
        if (cal.state.equals("first")) {
            String first = Double.toString(cal.firstNum);
            String power = Integer.toString(cal.firstPower);
            String number = first + "^" + power;
            display.setText(number);
        } else if (cal.state.equals("second")) {
            String first = Double.toString(cal.firstNum);
            String second = Double.toString(cal.secNum);
            String power = Integer.toString(cal.firstPower);
            String power2 = Integer.toString(cal.secondPower);

            String sign = "";
            if (cal.sign == 0) {
                sign = "+";
            } else if (cal.sign == 1) {
                sign = "-";
            } else if (cal.sign == 2) {
                sign = "*";
            } else if (cal.sign == 3) {
                sign = "/";
            }

            if (cal.firstPower == 0 && cal.secondPower == 0) {
                String number = first + sign + second + "^" + power2;
                display.setText(number);
            } else if (cal.firstPower != 0 && cal.secondPower == 0) {
                String number = first + "^" + power + sign + second + "^" + power2;
                display.setText(number);
            }
        }
    }
    //__________________________________________________________________________
    
    //Final Display
    public void finDisplay() {
        String number = Double.toString(cal.getFinal());
        answer.setText(number);
    }
    //__________________________________________________________________________
    
    //Clear Display Method
    public void clearDisplay() {
        display.setText("||||||||||||||||||||||||");
        answer.setText("0.0");
    }
    //__________________________________________________________________________
    
    //Root Display Method 
    public void rootDisplay() {
        if (cal.state.equals("first") && cal.firstRoot == true) {
            String first = Double.toString(cal.firstNum);
            String number = "√" + first;
            display.setText(number);
        } else if (cal.state.equals("second") && cal.secondRoot == true) {
            String first = Double.toString(cal.firstNum);
            String second = Double.toString(cal.secNum);

            String sign = "";
            if (cal.sign == 0) {
                sign = "+";
            } else if (cal.sign == 1) {
                sign = "-";
            } else if (cal.sign == 2) {
                sign = "*";
            } else if (cal.sign == 3) {
                sign = "/";
            }

            if (cal.firstRoot == false && cal.secondRoot == true) {
                String number = first + sign + "√" + second;
                display.setText(number);
            } else if (cal.firstRoot == true && cal.secondRoot == true) {
                String number = "√" + first + sign + "√" + second;
                display.setText(number);
            }
        } else if (cal.state.equals("first") && cal.firstRoot == false) {
            String first = Double.toString(cal.firstNum);
            String number = first;
            display.setText(number);
        } else if (cal.state.equals("second") && cal.secondRoot == false) {
            String first = Double.toString(cal.firstNum);
            String second = Double.toString(cal.secNum);

            String sign = "";
            if (cal.sign == 0) {
                sign = "+";
            } else if (cal.sign == 1) {
                sign = "-";
            } else if (cal.sign == 2) {
                sign = "*";
            } else if (cal.sign == 3) {
                sign = "/";
            }

            if (cal.firstRoot == false && cal.secondRoot == true) {
                String number = first + sign + second;
                display.setText(number);
            } else if (cal.firstRoot == true && cal.secondRoot == true) {
                String number = first + sign + second;
                display.setText(number);
            }
        }
    }

    //__________________________________________________________________________
    
    //Turn Off Display
    public void turnOffDisplay() {
        display.setText("");
        answer.setText("");
    }
    //__________________________________________________________________________
}
