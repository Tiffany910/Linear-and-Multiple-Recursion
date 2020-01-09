import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;

public class MultipleRecursion_into_TailRecursion {


	public static long starting_tetranacci(int n) {
		//We dont care about negative values
		if (n < 0)
			System.exit(0);
		//Starting values
		long[] A = {0, 0, 0, 1 };
		return linear_tetranacci(n, A);
	}

	public static long linear_tetranacci(int n, long[] A) {
		//Base case.
		if (n < 4)
			return A[n];
		long sum_of_4_values = A[0] + A[1] + A[2] + A[3];
		for (int i = 0; i < 3; i++){
			A[i] = A[i + 1];
		}
		A[3] = sum_of_4_values;
		return linear_tetranacci(n - 1, A);
	}

	public static void main(String[] args) {

		long number;
		PrintWriter linear_File = null;

		//Create new file to write meauserements
		File file = new File("MultipleRecursion_Tetranacci_inTail.txt");
		try {
			//Search if the file was created
			if(file.createNewFile()){
				System.out.println("MultipleRecursion_Tetranacci_inTail.txt: File Created");
			}else System.out.println("MultipleRecursion_Tetranacci_inTail.txt: Already exists"); //It already exists.
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try 
		{
			//PrintWriter => Write in file
			linear_File = new PrintWriter("MultipleRecursion_Tetranacci_inTail.txt");

		} catch (FileNotFoundException e) 
		{    //File does not exist
			System.out.println("The file MultipleRecursion_Tetranacci_inTail.txt was not found");
			e.printStackTrace();
		}

		//Start the multiple tetranacci with a for loop
		for (int i = 5; i <= 500; i = i + 5) {
			number = i;
			System.out.println("number: " + i/5);

			long startTime = System.currentTimeMillis();
			System.out.println(starting_tetranacci(i));
			long endTime = System.currentTimeMillis();
			long timeDifference=endTime - startTime;
			System.out.println("For i= " + number + ", that took " + timeDifference + " milliseconds");

			linear_File.println("Start Time: "+ startTime + " End Time: "+ endTime);
			linear_File.println("For i= " + number/5 + ", that took "+ timeDifference + " milliseconds");
			linear_File.println();
			linear_File.flush();	
			System.out.println("--------------------------------------------------------------------------");

		}
		linear_File.close();
	}
}
