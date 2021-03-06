/*
 * This class simulates the function of an ATM, you can create[an]Account(),
 * deposit() money, withdraw() money, or send a bal[ance]_Inquiry(). The card
 * number(s) generated by the createAccount() function, while most likely not
 * active, pass the Luhn algorithm for validating credit/debit card numbers.
 * This means if you pasted one of these numbers onto a payment form online, 
 * while it would be certainly denied after the transaction was processed, 
 * the form will not say the number is incorrect.
 */
package roleplay;

import java.util.*;  //import random
import java.math.*;

/**
 * @author Tim Barber
 */
//create a random object
public class ATM {

    Random rand = new Random();

    ArrayList dir = new ArrayList();

    public String createAccount(String PIN) {   // Create Account method
        String cardNum = ""; //Initialization of String variable that will hold card number

        //next section adds 15 random digits to the string
        int[] valids = {4, 51, 55, 5, 65, 35};

        int rnd = new Random().nextInt(valids.length);
        
        cardNum += valids[rnd];
        int x = cardNum.length();

        while (x < 15) {
            cardNum += rand.nextInt(9) + 1;
            x++;
        }
        // next code taken from https://gist.github.com/josefeg/5781824
        //this implements the Luhn algorithm to determine the check digit
        //that needs to be appended to the 15 digit card number
        int sum = 0;
        for (int i = 0; i < cardNum.length(); i++) {

            // Get the digit at the current position.
            int digit = Integer.parseInt(cardNum.substring(i, (i + 1)));

            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }

        // The check digit is the number required to make the sum a multiple of
        // 10.
        int mod = sum % 10;
        cardNum += ((mod == 0) ? 0 : 10 - mod);
        //end of code taken from https://gist.github.com/josefeg/5781824
        String[] account = {cardNum, PIN, "0"};  //information to document in case withdrawals or deposits are made
        dir.add(dir.size(), account);  //information is added to the dir[ectory] ArrayList
        return cardNum; //Account was created, new number is given back as String
    }

    public void deposit(String card, String PIN, double amt) {
        /*
        * Checks for numbers with more than three decimal places
        * like 0.001 or 10.355
        */
        BigDecimal checkAmt = new BigDecimal(amt);
        checkAmt = checkAmt.setScale(2, RoundingMode.HALF_UP);
        if (checkAmt.doubleValue() != amt){
            throw new IllegalArgumentException("Nope");
        }
        
        for (int i = 0; i < dir.size(); i++) {
            String[] accountx = (String[]) dir.get(i);
            
            if (accountx[0].equals(card) & accountx[1].equals(PIN)){
                double prevBal = Double.parseDouble(accountx[2]);
                prevBal += amt;
                String[] newAccInfo = {card, PIN, String.valueOf(prevBal)};
                dir.set(i, newAccInfo);
                System.out.println("Succesfully deposited " + amt + " into your account ending in " + card.substring(12,16) + ".");
                String[] newBal = (String[]) dir.get(i);  //check
                System.out.println("Your current balance is now: " + newBal[2]);
            }
        }
        
        
    }
    
    public double bal_Inquiry(String card, String PIN){
        for (int i = 0; i < dir.size(); i++) {
            String[] accountx = (String[]) dir.get(i);

            if (accountx[0].equals(card) & accountx[1].equals(PIN)){
                double amt = Double.valueOf(accountx[2]);
                return amt;
            }
        }
        return -1;
    }
    
    public void withdraw(String card, String PIN, double amt){
        
        /*
        * Checks for numbers with more than three decimal places
        * like 0.001 or 10.355
        */
        BigDecimal checkAmt = new BigDecimal(amt);
        checkAmt = checkAmt.setScale(2, RoundingMode.HALF_UP);
        if (checkAmt.doubleValue() != amt){
            throw new IllegalArgumentException("Nope");
        }
        
        for (int i = 0; i < dir.size(); i++) {
            String[] accountx = (String[]) dir.get(i);

            if (accountx[0].equals(card) & accountx[1].equals(PIN)){
                double prevBal = Double.valueOf(accountx[2]);
                prevBal -= amt;
                BigDecimal roundPrevBal = new BigDecimal(prevBal);
                roundPrevBal = roundPrevBal.setScale(2, RoundingMode.HALF_UP);
                
                
                double newBal = roundPrevBal.doubleValue();

                String[] newAccInfo = {card, PIN, String.valueOf(newBal)};

                dir.set(i, newAccInfo);
                
                System.out.println("Successfully withdrew " + amt + " from your account ending in " + card.substring(12,16) + ".");
                String[] checkBal = (String[]) dir.get(i);  //check
                System.out.println("Your current balance is now: " + checkBal[2]);
                
            }
        }
    }

}
