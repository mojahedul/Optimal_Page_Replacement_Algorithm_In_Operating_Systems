package optimal_page_replacement_algorithm;

import java.util.Scanner;

import optimal_page_replacement_algorithm_requirement.Optimal_Page_Replacement_Algorithm_Requirements;

public class Optimal_Page_Replacement_Algorithm {

	
	public static void main(String[] args)
	{
		
		int free_FramesNumber;
		String reference_String;
		String[] reference_StringArray;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter reference string (separating with space): ");
		reference_String = input.nextLine();
		
		System.out.print("Enter free frames number: ");
		free_FramesNumber = input.nextInt();
		
		System.out.println(free_FramesNumber);
		System.out.println(reference_String);
		
		reference_StringArray = reference_String.split(" ");
		
		Optimal_Page_Replacement_Algorithm_Requirements obj_Optimal = new Optimal_Page_Replacement_Algorithm_Requirements(free_FramesNumber, reference_StringArray);
		obj_Optimal.FIFO_Output_Calculation();
		
	} //End of Main() Method;
	
} //End Optimal_Page_Replacement_Algorithm;
