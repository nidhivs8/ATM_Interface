import java.util.*;
//Task2----> ATM Interface
public class ATM_Interface {
    String username;
    String password;
    double balance=500000;
    int transactions=0;
    String transactionHistory="";

    Scanner sc=new Scanner(System.in);

    public void register() {
        System.out.println("Enter username: ");
        this.username=sc.next();
        System.out.println("Enter password: ");
         this.password=  sc.next();
        System.out.println("REGISTRATION COMPLETED! \nThank You for Registration\nProceed further");
    }

    public void login() {
        boolean login=true;
        while(login){
            System.out.println("Enter username: ");
            String username1=sc.next();
            if(username.equals(username1)) {
                while(login) {
                    System.out.println("Enter the password: ");
                    String password1=sc.next();
                    if(password.equals(password1)) {
                        System.out.println("Logined successfully");
                        login=false;
                    }else  {
                        System.out.println("Password unmatched..re-enter password");
                    }
                }
            }else {
                System.out.println("username not found");
            }
        }

    }

    //Withdraw
    public void withdraw() {
        System.out.println("Enter the amount to be withdrawn: ");
        double amount=sc.nextDouble();
        if(amount<=balance) {
            balance-=amount;
            String a1="Rs"+amount+"Withrawn  ";
            transactionHistory=transactionHistory+a1;
            transactions++;
        }
        else {
            System.out.println("Insufficient balance");
        }
    }


    //Deposit
    public void deposit() {
        System.out.println("Enter the amount to be deposited: ");
        double amount=sc.nextDouble();
        if(amount<=1000000) {
            balance+=amount;
            String a1="Rs"+amount+"Deposited  ";
            transactionHistory=transactionHistory+a1;
            transactions++;
        }
        else {
            System.out.println("Amount exceeds the limit!");
        }
    }

    //Transfer
    public void transfer() {
        System.out.println("Enter the name of receiptent:");
        String n1=sc.next();
        System.out.println("Enter the amount to be transfered: ");
        double amount=sc.nextDouble();
        if(amount<=balance) {
            balance-=amount;
            String a1="Rs"+amount+"Transfered  ";
            transactionHistory=transactionHistory+a1;
            transactions++;
        }
        else {
            System.out.println("Amount exceeds the balance!");
        }
    }
    
    //Balance
    public void checkBalance() {
        System.out.println("Balance=Rs"+balance);
    }
    
    //Transaction History
    public void transactionHistory() {
        System.out.println("Transaction History: "+transactionHistory);
    }

    //Interface
    public int  takeInput(int input) {
        System.out.println("Enter value between 1 and "+input);
        int value=sc.nextInt();
        return value;

    }

    public static void main(String[] args) {
        ATM_Interface atm=new ATM_Interface();
        System.out.println("Welcome to ATM");
        System.out.println("1.Rgister \n2.Exit");

        int choice1=atm.takeInput(2);
        if(choice1==1){
            atm.register();
            while(true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter choice: ");
                int choice2=atm.takeInput(2);
                if(choice2==1) {

                    atm.login();
                    boolean finished=true;
                    while(finished) {
                        System.out.println("\n 1.Withdraw \n 2.Deposit \n 3.Transfer \n 4.Transcation history \n 5.Check Balance \n 6.Exit");
                        int choice111=atm.takeInput(6);
                        switch(choice111) {
                            case 1:
                                atm.withdraw();
                                break;
                            case 2:
                                atm.deposit();
                                break;
                            case 3:
                                atm.transfer();
                                break;
                            case 4:
                                atm.transactionHistory();
                                break;
                            case 5:
                                atm.checkBalance();
                                break;
                            case 6:
                                System.out.println("Logout!");
                                finished=false;
                                break;
                            default:
                                System.out.println("Wrong choice");

                        }
                    }


                }
                else{
                	System.out.println("*************");
                    return;
                }

            }

        }
        else {
        	System.out.println("*************");
            return;
        }


    }

}



































