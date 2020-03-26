import java.util.Scanner;


public class VacationDecisions {
	
	public static void main(String[] args) {
	
		
		Scanner scanner = new Scanner(System.in);
		
		
		String  vacationType = ""; //**declares vacationType as string  |Initializing these now due to|
		int     groupSize = 0;     //**declares groupSize as integer    |adding bug prevention loops  |
		String  result;            //**declares result as string
		boolean chkInput = true;
	
		
		//Displays request for vacation type
		System.out.print("What kind of trip would you like to go on, " + "musical," + 
				 		 "\ntropical, or adventurous? ");	
		
		//Input check: Doing this prevents a possible bug 
		//by making sure the user's input is a valid answer.
		while (chkInput == true) {
			vacationType = (scanner.next()).toLowerCase(); //**stores input into vacationType
			
			if (vacationType.equals("musical") || vacationType.equals("tropical") ||
					vacationType.equals("adventurous")){
				chkInput = false;
			} else {
				System.out.print("Answer is invalid." +
								 "\nPlease enter musical, tropical, or adventurous: ");
			}
		}
		
		//Asks for group size
		System.out.print("How many are in your group? ");
		
		//Another input check, asks user to answer again if user input < 1
		while (chkInput == false) {
			groupSize = scanner.nextInt(); //**stores input into groupSize
			
			if (groupSize > 0) {
				chkInput = true;
			} else {
				System.out.print("Group size must be at least one." +
								 "\nPlease re-enter: ");
			}
		}
		//main vacationType comparisons and groupSize operators come later
		
		
		//**Formats first part of "result" string using user input,
		//the if-then statement ensure correct grammar
		if (vacationType.equals("adventurous")) {
			result = String.format("Since you're a group of " + groupSize + " going on an " +
					 vacationType + " vacation, you\nshould take a ");
		} else {
			result = String.format("Since you're a group of " + groupSize + " going on a " +
					 vacationType + " vacation, you\nshould take a ");
		} 
		//string "result" gets put together gradually
		
		
		//**Determines travel method and concatenates it to "result"
		if (groupSize < 3) { //(already took care of "less than 1" possibility)
			result = result.concat("first class flight ");
		} else if (groupSize < 6) { //**relational operators for groupSize comparisons
			result = result.concat("helicopter ");
		} else {
			result = result.concat("charter flight ");
		}
		
		//**Determines the vacation destination and concatenates it to "result"
		if (vacationType.equals("musical")) { //**makes vacationType comparisons
			result += "to New Orleans.";
		} else if (vacationType.equals("tropical")) {
			result += "to Mexico for a beach vacation.";
		} else if (vacationType.equals("adventurous")) {
			result += "to the Grand Canyon for whitewater rafting.";
		}
		
		
		//**Prints "result" to console
		System.out.println(result);
		//**Final result should include correct variables and structure
		
		
		scanner.close();
	}
}
