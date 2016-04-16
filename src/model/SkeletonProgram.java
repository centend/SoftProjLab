package model;

/**
 * The SkeletonProgram is responsible for calling the Initializer
 * for the use-case the user desires to check.
 * 
 * @author ChaTeam
 *
 */
public class SkeletonProgram {
	/**
	 * The main method asks the user to chose which use-case they 
	 * would like to check and then executes it. The user can 
	 * continue checking use-cases or exit the program by entering
	 * '0'.
	 * 
	 * @param args	Not used
	 */
	public static void main(String[] args) {
		Initializer init = new Initializer();

		while (true) {
			SkeletonDisplay.resetTab();
			SkeletonDisplay.println("Enter Use-Case Number: ");
		
			try {
				int useCase = Integer.parseInt(SkeletonDisplay.readLine());
				switch (useCase) {
					case 0:
						SkeletonDisplay.println("Exit");
						System.exit(0);
					case 1:
						init.useCase1();
						break;
					case 2:
						init.useCase2();
						break;
					case 3:
						init.useCase3();
						break;
					case 4:
						init.useCase4();
						break;
					case 5:
						init.useCase5();
						break;
					case 6:
						init.useCase6();
						break;
					case 7:
						init.useCase7();
						break;
					case 8:
						init.useCase8();
						break;
					case 9:
						init.useCase9();
						break;
					case 10:
						init.useCase10();
						break;
					case 11:
						init.useCase11();
						break;
					case 12:
						init.useCase12();
						break;
					case 13:
						init.useCase13();
						break;
					case 14:
						init.useCase14();
						break;
					case 15:
						init.useCase15();
						break;
					case 16:
						init.useCase16();
						break;
					default:
				}
			} catch (NumberFormatException e) { SkeletonDisplay.println("Not a Number"); }
		}
	}
}
