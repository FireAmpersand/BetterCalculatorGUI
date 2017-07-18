/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs20models;

import java.util.*;

public class Calculator {

    //First Number Varibles
    public int firstDecNum;
    public int secDecNum;
    public double firstNum;
    public int firstPower;
    //__________________________________________________________________________

    //Second Number Varabiles
    public int firstSecondNum;
    public int secSecondNum;
    public double secNum;
    public int secondPower;
    //__________________________________________________________________________

    //Final Number
    public double finNum;
    //__________________________________________________________________________

    //Sign
    public int sign; // 0 = add  1 = sub  2 = multi 3 = divide  4 = none
    //__________________________________________________________________________

    //State Varibles
    public String state;
    public boolean dec = false;
    public boolean pow = false;
    public boolean firstRoot = false;
    public boolean secondRoot = false;
    //__________________________________________________________________________

    //Constuctor
    public Calculator() {
        this.firstNum = 0;
        this.secNum = 0;
        this.state = "first";
    }
    //__________________________________________________________________________

    //setFirst Method
    public void setFirst(String num) 
    {
        if (dec == false) {
            String number = Integer.toString(this.firstDecNum);
            String newNumber = number + num;
            this.firstDecNum = Integer.parseInt(newNumber);
            this.firstNum = Double.parseDouble(newNumber);
        } else if (dec == true) {
            if (this.secDecNum == 0) {
                this.secDecNum = Integer.parseInt(num);
                String number = Integer.toString(this.firstDecNum);
                String secNumber = Integer.toString(this.secDecNum);
                String newNumber = number + "." + secNumber;
                this.firstNum = Double.parseDouble(newNumber);
            } else {
                String number = Integer.toString(this.secDecNum);
                String newNumber = number + num;
                this.secDecNum = Integer.parseInt(newNumber);
                String nowNumber = Integer.toString(this.firstDecNum) + "." + newNumber;
                this.firstNum = Double.parseDouble(nowNumber);
            }
        }

    }
    //__________________________________________________________________________

    //setSecond Method
    public void setSecond(String num) {
        if (dec == false) {
            String number = Integer.toString(this.firstSecondNum);
            String newNumber = number + num;
            this.firstSecondNum = Integer.parseInt(newNumber);
            this.secNum = Double.parseDouble(newNumber);
        } else if (dec == true) {
            if (this.secSecondNum == 0) {
                this.secSecondNum = Integer.parseInt(num);
                String number = Integer.toString(this.firstSecondNum);
                String secNumber = Integer.toString(this.secSecondNum);
                String newNumber = number + "." + secNumber;
                this.secNum = Double.parseDouble(newNumber);
            } else {
                String number = Integer.toString(this.secSecondNum);
                String newNumber = number + num;
                this.secSecondNum = Integer.parseInt(newNumber);
                String nowNumber = Integer.toString(this.firstSecondNum) + "." + newNumber;
                this.secNum = Double.parseDouble(nowNumber);
            }
        }
    }
    //__________________________________________________________________________

    //setNegative Method
    public void setNegative() {
        if (this.state.equals("first")) {
            this.firstNum = this.firstNum * -1;
        } else if (this.state.equals("second")) {
            this.secNum = this.secNum * -1;
        }
    }
    //__________________________________________________________________________

    //setState Method
    public void setState(String state) {
        this.state = state;
    }
    //__________________________________________________________________________

    //setFinal Method
    public void setfinal() {
        int signType = this.sign;

        switch (signType) {

            case (0):
                if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == false) { //No Values
                    this.finNum = this.firstNum + this.secNum;
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == false) {//First Power but tnothing else
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) + (this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == false) {//Second Power but nothing else
                    this.finNum = (this.firstNum) + (Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == false) {//First and Second Power
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) + (Math.pow(this.secNum, this.secondPower));
                    break;

                } else if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == false) {//First Root
                    this.finNum = Math.sqrt(this.firstNum) + this.secNum;
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == false) {//First Root, and First Power
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) + (this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == false) {//First Root, and second Power
                    this.finNum = Math.sqrt(this.firstNum) + (Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == false) {//First and second Power, First Root 
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) + (Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == true) {//Second Root
                    this.finNum = this.firstNum + Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == true) {//First Power, Second Root
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) + Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == true) {//Second Power, Second Root
                    this.finNum = (this.firstNum) + Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == true) {//First And Second Power, Second Power
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) + Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == true) {//First and Second Root
                    this.finNum = Math.sqrt(this.secNum) + Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == true) {//First Power, First And Second Root
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) + Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == true) {//Second Power, First And Second Root
                    this.finNum = Math.sqrt(this.firstNum) + Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == true) {//All Values
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) + Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                }

            case (1):
                if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == false) {
                    this.finNum = this.firstNum - this.secNum;
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == false) {
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) - (this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == false) {
                    this.finNum = (this.firstNum) - (Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == false) {
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) - (Math.pow(this.secNum, this.secondPower));
                    break;

                } else if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == false) {
                    this.finNum = Math.sqrt(this.firstNum) - this.secNum;
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == false) {
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) - (this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == false) {
                    this.finNum = Math.sqrt(this.firstNum) - (Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == false) {
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) - (Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == true) {
                    this.finNum = this.firstNum - Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == true) {
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) - Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == true) {
                    this.finNum = (this.firstNum) - Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == true) {
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) - Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == true) {
                    this.finNum = Math.sqrt(this.secNum) - Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == true) {
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) - Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == true) {
                    this.finNum = Math.sqrt(this.firstNum) - Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == true) {
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) - Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                }

            case (2):
                if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == false) {
                    this.finNum = this.firstNum * this.secNum;
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == false) {
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) * (this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == false) {
                    this.finNum = (this.firstNum) * (Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == false) {
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) * (Math.pow(this.secNum, this.secondPower));
                    break;

                } else if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == false) {
                    this.finNum = Math.sqrt(this.firstNum) * this.secNum;
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == false) {
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) * (this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == false) {
                    this.finNum = Math.sqrt(this.firstNum) * (Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == false) {
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) * (Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == true) {
                    this.finNum = this.firstNum * Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == true) {
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) * Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == true) {
                    this.finNum = (this.firstNum) * Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == true) {
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) * Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == true) {
                    this.finNum = Math.sqrt(this.secNum) * Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == true) {
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) * Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == true) {
                    this.finNum = Math.sqrt(this.firstNum) * Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == true) {
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) * Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                }

            case (3):
                if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == false) {
                    this.finNum = this.firstNum / this.secNum;
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == false) {
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) / (this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == false) {
                    this.finNum = (this.firstNum) / (Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == false) {
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) / (Math.pow(this.secNum, this.secondPower));
                    break;

                } else if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == false) {
                    this.finNum = Math.sqrt(this.firstNum) / this.secNum;
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == false) {
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) / (this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == false) {
                    this.finNum = Math.sqrt(this.firstNum) / (Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == false) {
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) / (Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == true) {
                    this.finNum = this.firstNum / Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == false && this.secondRoot == true) {
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) / Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == true) {
                    this.finNum = (this.firstNum) / Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == false && this.secondRoot == true) {
                    this.finNum = (Math.pow(this.firstNum, this.firstPower)) / Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower == 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == true) {
                    this.finNum = Math.sqrt(this.secNum) / Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower != 0 && this.secondPower == 0 && this.firstRoot == true && this.secondRoot == true) {
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) / Math.sqrt(this.secNum);
                    break;
                } else if (this.firstPower == 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == true) {
                    this.finNum = Math.sqrt(this.firstNum) / Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                } else if (this.firstPower != 0 && this.secondPower != 0 && this.firstRoot == true && this.secondRoot == true) {
                    this.finNum = Math.sqrt(Math.pow(this.firstNum, this.firstPower)) / Math.sqrt(Math.pow(this.secNum, this.secondPower));
                    break;
                }
        }
    }
    //__________________________________________________________________________

    //setDec Method (State)
    public void setDec() {
        this.dec = true;
    }
    //__________________________________________________________________________

    //setPow Method (State)
    public void setPow() {
        this.pow = true;
    }
    //__________________________________________________________________________

    //setPower
    public void setPower(String number) {
        if (state.equals("first")) {
            String powNumber = Integer.toString(this.firstPower);
            String newPowNumber = powNumber + number;
            this.firstPower = Integer.parseInt(newPowNumber);
        } else if (state.equals("second")) {
            String powNumber = Integer.toString(this.secondPower);
            String newPowNumber = powNumber + number;
            this.secondPower = Integer.parseInt(newPowNumber);
        }

    }
    //__________________________________________________________________________

    //setRoot Method
    public void setRoot() {
        if (this.state.equals("first")) {
            this.firstRoot = true;
        } else if (this.state.equals("second")) {
            this.secondRoot = true;
        }
    }

    //__________________________________________________________________________
    //setSign Method
    public void setSign(int signType) {
        if (signType == 0) {
            this.sign = 0;
            this.state = "second";
            this.dec = false;
            this.pow = false;
        } else if (signType == 1) {
            this.sign = 1;
            this.state = "second";
            this.dec = false;
            this.pow = false;
        } else if (signType == 2) {
            this.sign = 2;
            this.state = "second";
            this.dec = false;
            this.pow = false;
        } else if (signType == 3) {
            this.sign = 3;
            this.state = "second";
            this.dec = false;
            this.pow = false;
        }
    }
    //__________________________________________________________________________

//                              Get Methods
    //getSign Method
    public int getSign() {
        return this.sign;
    }
    //__________________________________________________________________________

    //getFinal Method
    public double getFinal() {
        return this.finNum;
    }
    //__________________________________________________________________________

    //getFirst Method
    public double getFirst() {
        return this.firstNum;
    }
    //__________________________________________________________________________

    //getSecond Method
    public double getSecond() {
        return this.secNum;
    }
    //__________________________________________________________________________

    //getState Method
    public String getState() {
        return this.state;
    }
    //__________________________________________________________________________
}
