/**
 * Class for the norep command
 * This class processes a string to check for repetitions and find the minimum string from which it was created
 * @author Angelica
 *
 */
public class NoRep {
	
	/**
	 * Method to detect repetition characters on a given String
	 * @param checkString the String to check for repetition
	 * @return the String without repetitions
	 */

	public String detect(String checkString) {
		//Checking if a empty string was received
		if(checkString == null || checkString.length() == 0){
			return checkString;
		}		
		//Initial conditions
		StringBuilder candidate = new StringBuilder();
		candidate.append(checkString.charAt(0));
		int position = 1;
		//Main loop to find a suitable candidate string
		while(position < checkString.length()){
			if(checkString.charAt(position) != candidate.charAt(0)) {
				candidate.append(checkString.charAt(position));
				position++;
				continue;
			}
			//Check if candidate string is the minimum string
			if(!checkCandidate(candidate, checkString)) {
				candidate.append(checkString.charAt(position));
				position++;
			}else {				
				break;
			}
		}
		//Returning candidate string found
		return candidate.toString();
	}
	
	/**
	 * Method to check if a candidate string is he minimum string repeated in the original one 
	 * @param candidate the candidate string to check 
	 * @param checkString the original String
	 * @return a boolean indicating if the candidate is the minimum string
	 */

	private boolean checkCandidate(StringBuilder candidate, String checkString) {	
		//Using a regular expression to find the match
		return checkString.matches("("+candidate.toString()+")+");

	}

	/**
	 * Main method for the execution of the command norep
	 * @param argst the String to process for no repetition
	 */
	public static void main(String[] args) {
		//Check if arguments are given
		if(args.length == 0){
			System.out.println("Missing argument");
		} else {
			//Instance of class NoRep and calling method to process the argument
			NoRep r = new NoRep();
			System.out.println(r.detect(args[0]));	
		}
	}

}
