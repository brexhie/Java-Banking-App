/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankingapp;

/**
 *
 * @author brett
 */
import java.util.*;

class BankingApp {
	static Scanner input = new Scanner(System.in); //Creates new user input object
	String name, accountType; //create global string variables
	double balance, amount, interest_rate; //create global double values
        int accountNumber;

	BankingApp(String name, int accountNumber, String accountType, int balance) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
	}
        
        //create deposit method
	int deposit() {
		System.out.print("\nEnter amount to deposit (Adds 1 month's interest rate if applicable): ");
		amount = input.nextInt(); //read next integer user input
                if (amount >= 100 && amount <= 500) { //if amount is between 100 and 500 or equal to both, interest rate is equal to 0.5% of entered amount
                    interest_rate = amount * 0.5/100;
                    balance = balance + amount + interest_rate; //add user input amount and interest rate value
                    System.out.println(amount + " successfully deposited (including 0.5% interest rate). Your balance is " + balance);
                } 
                
                else if(amount >= 600 && amount <= 1000) { //if amount is between 600 and 1000 or equal to both, interest rate is equal to 2% of entered amount
                    interest_rate = amount * 2/100;
                    balance = balance + amount + interest_rate;//add user input amount and interest rate value
                    System.out.println(amount + " successfully deposited (including 2% interest rate). Your balance is " + balance);
                }
                
                else if (amount > 1000) { //if amount is greater than 1000, interest rate is equal to 5% of entered amount
                    interest_rate = amount * 5/100;
                    balance = balance + amount + interest_rate; //add user input amount and interest rate value and save
                    System.out.println(amount + " successfully deposited (including 5% interest rate). Your balance is " + balance);
                }
		if (amount < 0) { //if amount is less than 0
			System.out.println("\nInvalid Amount");
			return 1; //Allow user to re-enter
		}
		
		return 0; //displays selection prompt
	}
        
        //create withdraw method
	int withdraw() {
		System.out.println("Your Balance = " + balance); //display current balance
		System.out.print("Enter amount to withdraw: ");
		amount = input.nextInt(); //Read next integer user input
		if (balance < amount) { //if balance is less than entered amount
			System.out.println("Insufficient balance");
			return 1; //Allow user to re-enter
		}
		if (amount < 0) { //if amount is less than 0
			System.out.println("Invalid Amount");
			return 1; //Allow user to re-enter
		}
		balance = balance - amount; //subtract entered amount from balance and save
                System.out.println(amount + " successfully withdrawn from account. Your balance is " + balance);
		return 0; //display selection prompt
	}
        
        //create display method
	void display() {
		System.out.println("\nName: " + name);
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Balance: " + balance);

	}

	void dbal() {
		System.out.println("Balance: " + balance);
	}

	public static void main(String args[]) {
		System.out.print("Enter your Name: ");
		String nn = input.nextLine(); //read input
		System.out.print("Enter Account Number: ");
		int num = input.nextInt(); //read input
		System.out.print("Enter Account Type: ");
		String type = input.next(); //read input
		System.out.print("Enter Balance: ");
		int bal = input.nextInt(); //read input
		BankingApp b1 = new BankingApp(nn, num, type, bal); //saves input
		int menu; //menu screen
		System.out.println("\nWelcome");
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Display Information");
		System.out.println("4. Exit");
		boolean quit = false; //prevent program from closing
		do {
			System.out.print("\nPlease make a selection: ");
			menu = input.nextInt();
			switch (menu) {
			case 1:
				b1.deposit();
				break;

			case 2:
				b1.withdraw();
				break;

			case 3:
				b1.display();
				break;

			case 4:
				quit = true;
                                System.out.println("\nGoodbye");
				break;
			}
		} while (!quit); //quits program
	}
}