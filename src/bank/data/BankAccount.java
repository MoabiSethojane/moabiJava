/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.data;

/**
 *
 * @author Moabi Sethojane
 */
public abstract class BankAccount {
    private int accountNumber;
    protected double balance;
    public BankAccount(){
        
    }
    public BankAccount(int accountNumber){
        this.accountNumber= accountNumber;
        balance=0;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public abstract void deposite(double amount);
    public abstract void withdraw(double amount);
}
