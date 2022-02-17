/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.data;

import javax.swing.JOptionPane;

/**
 *
 * @author Moabi Sethojane
 */
public class SavingsAccount extends BankAccount{
private double interestRate;
public SavingsAccount(){
    super();
}
public SavingsAccount(int accountNumber,double interestRate){
    super(accountNumber);
    this.interestRate= interestRate;
    
}
public double getInterestRate(){
    return interestRate;
}
public double calcInterest(){
    return balance*=interestRate;
}
public void applyInterest(){
    double interest= calcInterest();
    deposite(interest);
}
    @Override
    public void deposite(double amount) {
if(amount<0){
    JOptionPane.showConfirmDialog(null,"Negative amount cannot be deposited");
}else{
     balance+=amount;
     System.out.printf("Amount %.2f deposited into account %n",amount);
     System.out.printf("Current Balance %.2f%n",balance);
    }    
    }

    @Override
    public void withdraw(double amount) {
        if(amount<0){
            JOptionPane.showConfirmDialog(null, "Negative amount cannot be withdrawn");
        }else if(amount>balance){
            JOptionPane.showConfirmDialog(null,"Insufficent funds");
        }else{
            balance -=amount;
            System.out.printf("Amount %.2f withdrawn from account%n",amount);
            System.out.printf("Current Balance %.2f%n",balance);
        }
    }
    
}
