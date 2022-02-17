/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.data;

import java.util.Scanner;

/**
 *
 * @author Moabi Sethojane
 */
public class BankMainMenu {
 public static void main(String[]args){
     BankAccount []bankAccount= new BankAccount[10];
     Scanner keyboard= new Scanner(System.in);
     int accountNumber= 0;
     int choice;
     do{
        choice= bankMenu(keyboard);
         if(choice==1){
            bankAccount[accountNumber++]= createAccount(keyboard);
        }else if(choice==2){
            doDeposite(bankAccount,accountNumber, keyboard);
        }else if(choice==3){
            doWithdraw(bankAccount, accountNumber, keyboard);
        }else if(choice==4){
            applyInterest(bankAccount, accountNumber, keyboard);
        }else{
            System.out.println("Good Bye");
        }
         
     }while(choice!=5);
 
 }
 public static int bankMenu(Scanner keyboard){
     System.out.println("Bank Menu");
     System.out.println("1. Create account");
     System.out.println("2. Deposite into account");
     System.out.println("3. Withdraw funds from account");
     System.out.println("4. Apply Interest");
     System.out.println("5. Quit");
     int choice;
     do{
         System.out.println("Enter choice ");
         choice= keyboard.nextInt();
     }while(choice<1||choice>5);
     return choice;
 }
 public static int accountType(Scanner keyboard){
     System.out.println("Account Type Menu");
     System.out.println("1. Checking Account");
     System.out.println("2. Savings Account");
     int choice;
     do{
         System.out.println("Enter account type choice ");
        choice= keyboard.nextInt();
     }while(choice<1||choice>2);
     return choice;
 }
 public static int searchAccount(BankAccount[]bankAccounts,int count,int accountNumber){
     for(int i=0;i<count;i++){
         if(bankAccounts[i].getAccountNumber()== accountNumber)
             return i;
     }
     return -1;
 }
 public static BankAccount createAccount(Scanner keyboard){
     BankAccount acc=null;
     System.out.println("Enter account Number");
     int accountNumber= keyboard.nextInt();
     int choice;
     choice= accountType(keyboard);
     if(choice==1){
         System.out.println("Enter fee");
         double fee= keyboard.nextDouble();
         acc= new CheckingAccount(accountNumber, fee);
     }else{
         System.out.println("Enter Interest Rate ");
         double interestRate = keyboard.nextDouble();
        acc= new SavingsAccount(accountNumber, interestRate);
     }
     return acc;
 }
  public static void doDeposite(BankAccount[]bankAccounts,int count,Scanner keyboard){
      System.out.println("Enter account number ");
      int accountNumber= keyboard.nextInt();
      int index= searchAccount(bankAccounts, count, accountNumber);
      if(index>=0){
          System.out.println("Enter amount to be deposited");
          double amount= keyboard.nextDouble();
          bankAccounts[index].deposite(amount);
      }else{
          System.out.println("Account does not exist "+accountNumber);
      }
 }
  public static void doWithdraw(BankAccount[]bankAccounts,int count, Scanner keyboard){
      System.out.println("Enter account number");
      int accountNumber= keyboard.nextInt();
      int index= searchAccount(bankAccounts, count, accountNumber);
      if(index>=0){
          System.out.println("Enter withdrawal amount");
          double amount = keyboard.nextDouble();
          bankAccounts[index].withdraw(amount);
      }else{
          
      System.out.println("account does not exist "+accountNumber);
  }
  }
  public static void applyInterest(BankAccount[]bankAccounts,int count, Scanner keyboard){
      System.out.println("Enter account number ");
      int accountNumber= keyboard.nextInt();
      int index = searchAccount(bankAccounts, count, accountNumber);
      if(bankAccounts[index]instanceof SavingsAccount){
          ((SavingsAccount) bankAccounts[index]).applyInterest();
      }
  }
}
