package emailApplication;

import java.util.Scanner;

public class Email {
	
	// variables are private to ensure encapsulation.
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength = 10;
	private String email;
	private String department;
	private int mailBoxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	//Constructor to receive the first name, last name.
	public Email(String firstName, String lastName){
		
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email Created: " + this.firstName + " " + this.lastName);
		
		//call method asking for the department, return department.
		this.department = setDepartment();
		
		// call a method that returns a random password.
		this.password = genPassword(defaultPasswordLength);
		System.out.println("Your Password is: " + password);
		
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +"."+ companySuffix;
		
		
	}
	
	
	//Asks the user for the department they work for.
	private String setDepartment() {
		System.out.println("Please select the relevant Department Code: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
		//Scanner takes an input from the user (System.in) shows the input stream.
		Scanner in = new Scanner(System.in);
		// in.nextInt() moves to the next integer value in the input.
		int depChoice = in.nextInt();
		
		//if statement to show which department is selected by taking the numerical input from the user.
		if (depChoice == 1) {
			in.close();
			return "sales";
		} else if (depChoice == 2) {
			in.close();
			return "dev";
		} else if (depChoice == 3) {
			in.close();
			return "accounting";
			
		} else {
			in.close();
			return "";
		}
		
		
		
	}
	
	// generate random password for the user.
	private String genPassword(int length) {
		
		//Sets the valid characters for the password
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#';[]@:~{}<>?,./";
		
		char[] password = new char[length];
		
		for(int i=0; i<length; i++) {
			
			// cast as an integer. Times the random number by the length of the password set, this will always make
			// the random value between 1 and the number provided by the length variable.
			int rand = (int) (Math.random() * passwordSet.length());
			
			// takes the character at the random number in the password set and adds this to the password array.
			password[i] = passwordSet.charAt(rand);
			
		}
		
		// changes the password array into a string.
		return new String(password);		
	}
	
	// set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}
	
	// set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	// allows access to the properties (data binding/hiding)
	public int getMailboxCapacity() { return mailBoxCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
	}

}
