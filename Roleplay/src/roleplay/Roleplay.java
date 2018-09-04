/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roleplay;

/**
 *
 * @author Tim Barber
 */
public class Roleplay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ATM Chase = new ATM();
        String debit = Chase.createAccount("1234");
        System.out.println("Debit card#: "+ String.valueOf(debit));
        Chase.deposit(debit, "1234", 500);
        Chase.withdraw(debit, "1234", 60.00);
        Chase.deposit(debit, "1234", 357.05);
        Chase.withdraw(debit, "1234", 45.96);
        System.out.println("Will attempt to use incorrect PIN");
        Chase.withdraw(debit, "1254", 24.00);
        System.out.println("Will attempt to use incorrect card");
        String badDebit = String.valueOf(Double.parseDouble(debit)-1);
        Chase.withdraw(badDebit, "1234", 9);
        System.out.println("Balance of debit card is: " + Chase.bal_Inquiry(debit, "1234"));
    }
    
}
