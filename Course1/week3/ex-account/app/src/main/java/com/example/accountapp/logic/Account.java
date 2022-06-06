package com.example.accountapp.logic;

import static androidx.core.util.ObjectsCompat.hash;

import com.example.accountapp.ui.OutputInterface;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * This file defines the Account class.  It provides the basis for a
 * series of improvements you'll need to make as you progress through
 * the lessons in Module 6.
 */
public class Account {
    /**
     * This is the variable that stores our OutputInterface instance.
     * <p/>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * </p>
     * This was renamed to 'mOut' from 'out', as it is in the video
     * lessons, to better match Android/Java naming guidelines.
     */
    final OutputInterface mOut;

    /**
     * Name of the account holder.
     */
    private String name;
    public static int count=3213;

    /**
     * Number of the account.
     */
    private String number;

    /**
     * Current balance in the account.
     */
    private double balance;

    /**
     * Constructor initializes the field
     */
    public Account(OutputInterface out) {
        mOut = out;
    }

    public Account(OutputInterface out, double initBalance) {
        this(out);
        balance = initBalance;
        number = buildAccNum();
    }
    public String getNumber(){
        return number;
    }
    public String getName() {
        return (name);
    }
    public void setName(String nm) {
        name = nm;
    }
    public void setBalance(double blnc){

        balance = balance;
    }


    // Important note on constructors...
    // Each constructor that you add should take an OutputInterface parameter that
    // is used to initialize mOut (similar to the constuctor above).
    // Please remember to add that parameter to the code that you see in the lectures.

    /**
     * Deposit @a amount into the account.
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Withdraw @a amount from the account.  Prints "Insufficient
     * Funds" if there's not enough money in the account.
     */
    public void withdrawal(double amount) {
        if (balance > amount)
            balance -= amount;
        else 
            mOut.println("Insufficient Funds");
    }

    /**
     * Display the current @a amount in the account.
     */
    public void displayBalance() {
        mOut.println("The balance on account " 
                     + number
                     + " is " 
                     + balance);
    }

    // Overriding toString method
    public String toString(){
        //this is optional it will implicitly refer to the caller object
        return ("Account holder :"+ this.getName() +"\nAccount no."+getNumber());
    }
    // Overriding equals method
    public boolean equals(Object other) {
        if (other instanceof Account){
            // creating instance of other object to access its field
            Account otherAcc = (Account) other;

            return (number == otherAcc.number);
        }
        else {
            return false ;
        }
    }
    Date date = new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat("yy");
    String stringDate= DateFor.format(date);

    // Building an account number
    private String buildAccNum(){
        count = (count +1 ) %100;
        return(stringDate+ hash(this.name)+count);
    }
}
