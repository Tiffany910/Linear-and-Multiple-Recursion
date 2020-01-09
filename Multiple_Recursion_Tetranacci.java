import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Multiple_Recursion_Tetranacci {
	// Function to return the 
	// N-th tetranacci number 
	static long multiRecursTetra(long n) 
	{ 
	    // base cases 
	    if (n == 0||n==1||n==2) 
	        return 0; 
	    // base cases 
	    if (n == 3) 
	        return 1; 
	  
	    else
	        return multiRecursTetra(n - 1) + 
	               multiRecursTetra(n - 2) +  
	               multiRecursTetra(n - 3)+  
	               multiRecursTetra(n - 4); 
	} 
	  
	// Method to print the Nth tetranacci number 
	static void printMultiTetra(long n) 
	{ 
	    System.out.println(multiRecursTetra(n) + " "); 
	} 
	  
	
	public static void main(String[] args) 
	{ 
	    PrintWriter multiple_File = null;
	    long number;
	  
		File file = new File("MultipleRecursion_Tetranacci.txt");
		try {
			if(file.createNewFile()){
				System.out.println("MultipleRecursion_Tetranacci.txt: File Created");
			}else System.out.println("MultipleRecursion_Tetranacci.txt: Already exists");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try 
		{
			//PrintWriter 
			multiple_File = new PrintWriter("MultipleRecursion_Tetranacci.txt");
		} catch (FileNotFoundException e) 
		{
			System.out.println("The file MultipleRecursion_Tetranacci.txt was not found");
			e.printStackTrace();
		}

		System.out.println("");

		for(int i = 5;i<500;i=i+5)
		{
			number=i;
			System.out.println("number: "+ i/5);
			
			long startTime = System.currentTimeMillis();
			printMultiTetra(number); 
			long endTime = System.currentTimeMillis();
			long timeDifference= endTime -startTime;
			System.out.println("For i= "+ number +", that took " + timeDifference + " milliseconds");
			
			multiple_File.println("Start Time: "+ startTime + " End Time: "+ endTime);
			multiple_File.println("For i= " + number/5 + ", that took "+ timeDifference + " milliseconds");
			multiple_File.println();
			multiple_File.flush();
		}
		multiple_File.close();
		}
	} 

