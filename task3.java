

import java.util.*;
class ATM {
   private double balance;
   private double deposit_Amt;
   private double withdraw_Amt;

   
   public ATM(){

   }

   
public double getBalance() {
       return balance;
   }

   public void setBalance(double balance) {
       this.balance = balance;
   }

   public double getDepositAmt() {
       return deposit_Amt;
   }

   public void setDepositAmount(double deposit_Amt) {
       this.deposit_Amt = deposit_Amt;
   }

   public double getWithdrawAmount() {
       return withdraw_Amt;
   }

   public void setWithdrawAmt(double withdraw_Amt) {
       this.withdraw_Amt = withdraw_Amt;
   }
}

interface AtmOperationInterface {
   public void viewBalance();
   public void withdraw_Amt(double withdraw_Amt);
   public void deposit_Amt(double deposit_Amt );
   public  void viewStatement();
}


class AtmOperation implements AtmOperationInterface{
   ATM atm=new ATM();
   Map<Double,String> ministmt=new HashMap<>();
   @Override
   public void viewBalance() {
       System.out.println("Available Account Balance is : "+atm.getBalance());

   }

   @Override
   public void withdraw_Amt(double withdraw_Amt) {
       if(withdraw_Amt%500==0) {
           if (withdraw_Amt <= atm.getBalance()) {
               ministmt.put(withdraw_Amt, " Amount Withdrawn Succesfully");
               System.out.println("Please Collect the Cash " + withdraw_Amt);
               atm.setBalance(atm.getBalance() - withdraw_Amt);
               viewBalance();
           } else {
               System.out.println("Your Account has Insufficient Balance !");
           }
       }
       else {
           System.out.println("Please Enter the amount in multiples of 500 !!");
       }

   }

   @Override
   public void deposit_Amt(double deposit_Amt) {
       ministmt.put(deposit_Amt," Amount Deposited !!");
       System.out.println(deposit_Amt+" Deposited Successfully !!");
       atm.setBalance(atm.getBalance()+deposit_Amt);
       viewBalance();

   }

   @Override
   public void viewStatement() {
       for(Map.Entry<Double,String> m:ministmt.entrySet()){
           System.out.println(m.getKey()+""+m.getValue());
       }

   }
}

public class task3 {
   public static void main(String[] args) {
       AtmOperationInterface op=new AtmOperation();
       int atmno=12345;
       int atmpin=123;
       Scanner in=new Scanner(System.in);
    
       System.out.print("Enter Atm Number : ");
       int atmNo=in.nextInt();
       System.out.print("Enter Pin: ");
       int pin=in.nextInt();
       if((atmno==atmNo)&&(atmpin==pin)){
           while(true){
               System.out.println("1.View Account Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Statement\n5.Exit");
               System.out.println("Enter Choice : ");
               int ch=in.nextInt();
               if(ch==1){
                   op.viewBalance();

               }
               else if(ch==2){
                   System.out.println("Enter amount to withdraw ");
                   double withdrawAmt=in.nextDouble();
                   op.withdraw_Amt(withdrawAmt);

               }
               else if(ch==3){
                   System.out.println("Enter Amount to Deposit :");
                   double depositAmt=in.nextDouble();
                   op.deposit_Amt(depositAmt);


               }
               else if(ch==4){
                   op.viewStatement();

               }
               else if(ch==5){
                   System.out.println(" Please collect your ATM Card.\n Thank you for using ATM!");
                   System.exit(0);
               }
               else
               {
                   System.out.println("Please enter a valid choice!!");
               }
           }
       }
       else{
           System.out.println("Wrong ATM Number or Passcode!!");
           System.exit(0);
       }


   }
}