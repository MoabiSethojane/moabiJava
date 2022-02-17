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
public class CheckingAccount extends BankAccount{
private double FEE=2.5;
public CheckingAccount(){
    super();
}
public CheckingAccount(int accountNumber,double fee){
    super(accountNumber);
    this.FEE= fee;
}
public double getFee(){
    return FEE;
}
    @Override
    public void deposite(double amount) {
    if(amount<0){
        JOptionPane.showConfirmDialog(null,"Negative amount cannot be deposited");
        
    }else{
        balance+=amount;
        System.out.printf("Amount %.2f deposited int account %n",amount);
        balance-=FEE;
        System.out.printf("Fee charged%.2f from account%n",FEE);
        System.out.printf("Current Balance %.2f%n",balance);
    }
    }

    @Override
    public void withdraw(double amount) {
     if(amount<0){
         JOptionPane.showConfirmDialog(null, "Negative amount cannot be withdrawn");
     }else if( amount>(balance+FEE)){
         JOptionPane.showConfirmDialog(null,"Insufficient funds");
     }else{
        balance-=amount;
         System.out.printf("Amount %.2f withdrawn from account%n",amount);
         balance-=FEE;
         System.out.printf("Fee charged%.2f from account %n",FEE);
         System.out.printf("Current Account Balance %.2f%n",balance);
    }
    }
    
}
