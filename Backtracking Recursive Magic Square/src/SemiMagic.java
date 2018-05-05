

import java.util.*;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;

public class SemiMagic {
	
	static Set<Integer> givenNumbers = new HashSet<>();
	
	
	/* private static void fillBoolean(int[][] square){
		canAdd = new boolean[square.length][square.length];
		
		for(int i =0; i<square.length; i++){
			for(int k = 0; k<square[i].length; k++){
				if(square[i][k] == 0){
					canAdd[i][k] = true;
				}
				else{
					canAdd[i][k] = false;
				}
			}
		}
	} */
    public static boolean isFullSolution(int[][] square) {
		
		for(int i =0; i<square.length; i++){
			for(int j =0; j<square[0].length; j++){
				if(square[i][j] == 0){
					
					return false;
				
				}
				
			}
		}
		
		if(reject(square)){
			return false;
		}
		
		return true;
		
	}

    public static boolean reject(int[][] square){
		
		int[] temparr = new int[100];
		int size = 0;
		int sumOfSquare = 0;
		int n = square.length;
		int exp = n*n;
		int exp1 = exp+1;
		int mexp1 = n*exp1;
		int answer = mexp1/2;
		Set<Integer> dupeChecker = new HashSet<>();
		
		if(square.length==0){
			return true;
		}
		
		for(int i = 0; i<n; i++){
			
			for(int k = 0; k<square[0].length;k++){
				if(size == n){
					if(sumOfSquare !=answer){
						return true;
					}
					sumOfSquare = 0;
					size = 0;
				}
				
				int thing = square[k][i];
				if(dupeChecker.contains(thing)){
					return true;
				}
				if(thing >(n*n)){
					return true;
				}
				if(thing!=0){
					dupeChecker.add(thing);
				}
				
				if(thing ==0){
					size = 0;
					sumOfSquare = 0;
					for(int d = 0; d <square[0].length; d++){
						if(square[k][d] >(n*n)){
							return true;
						}
						
						sumOfSquare = sumOfSquare + square[k][d];
					}
					
					if(sumOfSquare>answer){
						return true;
					}
					sumOfSquare = 0;
					break;
				}
				
				sumOfSquare = sumOfSquare+thing;
				size++;
			}
			
			
		}
		
		size= 0;
		sumOfSquare = 0;
		
		for(int k =0; k<square[0].length; k++){
			
			for(int i = 0; i<square.length;i++){
				if(size ==n){
					if(sumOfSquare != answer){
						return true;
					}
					sumOfSquare = 0;
					size = 0;
				}
				int thing2 = square[k][i];
				if(thing2 == 0){
					
					sumOfSquare = 0;
					size = 0;
					for(int p = 0; p<square.length; p++){
						if(square[p][i]>(square.length *square.length)){
							return true;
						}
						sumOfSquare = sumOfSquare +square[p][i];
					}
					
					if(sumOfSquare > answer){
						return true;
					}
					sumOfSquare = 0;
					break;
				}
				
				size++;
				sumOfSquare = sumOfSquare +thing2;
			}
			
			
		}

        return false;
    }

    public static int[][] extend(int[][] square) {
        
		int[][] tempArr = new int[square.length][square.length];
		Set<Integer> numberTracker = new HashSet<>();
		
		for(int i =0; i<square.length; i++){
			for(int k = 0; k<square.length; k++){
				if(square[i][k]!= 0){
					tempArr[i][k] = square[i][k];
					numberTracker.add(square[i][k]);
				}
			}
		}
		
		for(int i = 0; i<square.length; i++){
			for(int k = 0; k<square.length;k++){
				if(square[i][k] ==0){
					for(int p =1; p<square.length*square.length+1;p++){
						if(!numberTracker.contains(p)){
							tempArr[i][k] = p;
							return tempArr;
						}
					}
				}
			}
		}
		
		
		// TODO: Complete this method
        return null;
    }

    public static int[][] next(int[][] square) {
		Set<Integer> numberTracker = new HashSet<>();
		int[][] tempArrMatrix= new int[square.length][square.length];
		int[] tempArr = new int[square.length*square.length];
		int tempIndex = 0;
		int column = 0; 
		int row = 0;
		
		for(int i = 0;i<square.length;i++){
			for(int k = 0; k<square.length; k++){
				tempArr[tempIndex] = square[k][i];
				if(square[k][i] != 0){
					numberTracker.add(square[k][i]);
				}
				tempIndex++;
			}
		}
		
		controlLoop: for(int i= 0; i<tempArr.length; i++){
			if(i== tempArr.length-1|| tempArr[i+1] ==0){
				if(tempArr[i]>= (square.length*square.length)){
					return null;
				}
				if(givenNumbers.contains(tempArr[i])){
					if(tempArr[i-1]>=(square.length*square.length))
					{
						return null;
					}
					else{
						for(int f= tempArr[i-1]; f<=square.length*square.length; f++){
							if(!numberTracker.contains(f+1)){
								tempArr[i-1] = f+1;
								break controlLoop;
							}
						}
						
						return null;
					}
				}
				else{
					for(int d = tempArr[i]; d<= square.length*square.length; d++){
						if(!numberTracker.contains(d+1)){
							tempArr[i] = d+1;
							break controlLoop;
						}
					}
					return null;
				}
				
			}
		}
		
		for(int i = 0; i<tempArr.length; i++){
			
			if(column == tempArrMatrix[0].length){
				column =0;
				row++;
			}
			tempArrMatrix[row][column] = tempArr[i];
			column++;
		}
		
        // TODO: Complete this method
        return tempArrMatrix;
    }

    static void testIsFullSolution() {
        // TODO: Complete this method
		int[][] ints1 = {{8,1,6}, {3,5,7}, {4,9,2}};
		int[][] ints3 =	{{1}};
		int[][] ints2 = {{16,2,3,13}, {5,11,10,8}, {9,7,6,12}, {4,14, 15,1}};
		int[][] ints4 = {{8,1,6}, {3,5,7}, {4,9,2}};
		int[][] ints5 =  {{9,6,3,16}, {4,15,10,5},{14,1,8,11},{7,12,13,2}};
		
		int[][] wrong1 = {{16,5,9,4}, {2,11,7,14}, {3,4,6,15}, {13,8,12,1}};
		int[][] wrong2 = {{8,0,4}, {1,5,9}, {6,7,2}};
		int[][] wrong3 = {{9,3,1}, {2,5,6}, {4,7,8}};
		int[][] wrong4 = {{8,1,6},{5,7,3},{4,9,2}};
		int[][] wrong5 = {{1,3},{2,4}};
		int[][] wrong6 = {{1,2},{2,4}};
		
		System.out.println("You are in testIsFullSolution()");
		
		System.err.println("These should be full:");
		
		if(isFullSolution(ints1)){
			System.out.println("Full solution:");
			System.out.println();
			printSquare(ints1);
		}
		else{
			System.out.println("This does not work");
			System.out.println();
			printSquare(ints1);
		}
		
		if(isFullSolution(ints2)){
			System.out.println("Full solution:");
			System.out.println();
			printSquare(ints2);
		} 
		else{
			System.out.println("This does not work");
			System.out.println();
			printSquare(ints2);
		}		
		
		if(isFullSolution(ints3)){
			System.out.println("Full solution:");
			System.out.println();
			printSquare(ints3);
		}
		else{
			System.out.println("This does not work");
			System.out.println();
			printSquare(ints3);
		}
        if(isFullSolution(ints4)){
			System.out.println("Full solution:");
			System.out.println();
			printSquare(ints4);
		}
		else{
			System.out.println("This does not work");
			System.out.println();
			printSquare(ints4);
		}
		if(isFullSolution(ints5)){
			System.out.println("Full solution:");
			System.out.println();
			printSquare(ints5);
		}
		else{
			System.out.println("This does not work");
			System.out.println();
			printSquare(ints5);
		}

        System.err.println("These should NOT be full:");
		
		if(!isFullSolution(wrong1)){
			
			System.out.println("Not full solution:");
			System.out.println();
			printSquare(wrong1);
		}
		else{
			System.out.println("Full solution:");
			System.out.println();
			printSquare(wrong1);
		}
		
		if(!isFullSolution(wrong2)){
			System.out.println("Not full solution:");
			System.out.println();
			printSquare(wrong2);
		}
		else{
			System.out.println("Full solution:");
			System.out.println();
			printSquare(wrong2);
		}
		if(!isFullSolution(wrong3)){
			System.out.println("Not full solution:");
			System.out.println();
			printSquare(wrong3);
		}
		else{
			System.out.println("Full solution:");
			System.out.println();
			printSquare(wrong3);
		}
		if(!isFullSolution(wrong4)){
			System.out.println("Not full solution:");
			System.out.println();
			printSquare(wrong4);
		}
		else{
			System.out.println("Full solution:");
			System.out.println();
			printSquare(wrong4);
		}
		if(!isFullSolution(wrong5)){
			System.out.println("Not full solution:");
			System.out.println();
			printSquare(wrong5);
		}
		else{
			System.out.println("Full solution:");
			System.out.println();
			printSquare(wrong5);
		}
		if(!isFullSolution(wrong6)){
			System.out.println("Not full solution:");
			System.out.println();
			printSquare(wrong6);
		}
		else{
			System.out.println("Full solution:");
			System.out.println();
			printSquare(wrong6);
		}
       
    }
		
    

    static void testReject() {
		int[][] intsDontReject1 = {{8,1,0}, {3,5,0}, {4,9,0}};
		int[][] intsDontReject2 = {{8,0,0}, {3,0,0}, {4,0,0}};
		int[][] intsDontReject3 = {{0,0,0},
    		 {0,0,0},
    		 {0,0,0}};
		int[][] intsDontReject4 = {{1,8,6},
    		 {0,0,0},
    		 {0,0,0}};
			 
		int[][] intsDontReject5 = {{3,0,6},
    		 {8,0,2},
    		 {4,0,7}};
		
		
		int[][] wrongReject1 = {{16,0,0}, {23,0,8}, {48, 3, 85}};
		int[][] wrongReject2 = {{8,1,6},{8,1,6},{4,9,2}};
		int[][] wrongReject3 = {{4,9,2},
    		 {3,5,7},
    		 {8,6,1}};
		
		int[][] wrongReject4 = {{6,1,3},
    		 {7,5,8},
    		 {2,9,4}};
				
		
		System.out.println();
		System.err.println("These should BE REJECTED:");
		
		if(reject(wrongReject1)){
			System.out.println("Rejected:");
			System.out.println();
			printSquare(wrongReject1);
		}
		else{
			System.out.println("Not rejected:");
			System.out.println();
			printSquare(wrongReject1);
		}
		if(reject(wrongReject2)){
			System.out.println("Rejected:");
			System.out.println();
			printSquare(wrongReject2);
		}
		else{
			System.out.println("Not rejected:");
			System.out.println();
			printSquare(wrongReject2);
		}
		if(reject(wrongReject3)){
			System.out.println("Rejected:");
			System.out.println();
			printSquare(wrongReject3);
		}
		else{
			System.out.println("Not rejected:");
			System.out.println();
			printSquare(wrongReject3);
		}
		if(reject(wrongReject4)){
			System.out.println("Rejected:");
			System.out.println();
			printSquare(wrongReject4);
		}
		else{
			System.out.println("Not rejected:");
			System.out.println();
			printSquare(wrongReject4);
		}
		
		System.out.println("These should not be rejected:");
		
		if(!reject(intsDontReject1)){
			System.out.println("Not rejected:");
			System.out.println();
			printSquare(intsDontReject1);
		}
		else{
			System.out.println("Rejected:");
			System.out.println();
			printSquare(intsDontReject1);
		}
		if(!reject(intsDontReject2)){
			System.out.println("Not rejected:");
			System.out.println();
			printSquare(intsDontReject2);
		}
		else{
			System.out.println("Rejected:");
			System.out.println();
			printSquare(intsDontReject2);
		}
		if(!reject(intsDontReject3)){
			System.out.println("Not rejected:");
			System.out.println();
			printSquare(intsDontReject3);
		}
		else{
			System.out.println("Rejected:");
			System.out.println();
			printSquare(intsDontReject3);
		}
		if(!reject(intsDontReject4)){
			System.out.println("Not rejected:");
			System.out.println();
			printSquare(intsDontReject4);
		}
		else{
			System.out.println("Rejected:");
			System.out.println();
			printSquare(intsDontReject4);
		}
		if(!reject(intsDontReject5)){
			System.out.println("Not rejected:");
			System.out.println();
			printSquare(intsDontReject5);
		}
		else{
			System.out.println("Rejected:");
			System.out.println();
			printSquare(intsDontReject5);
		}
		
		
		
		
		
		
	
	
        // TODO: Complete this method
    }

    static void testExtend() {
		
		int[][] cantExtend = {{5,1,9},
     		{7,6,2},
     		{3,8,4}};
		int[][] cantExtend2 = {{3,2,1},
     		{6,5,4},
     		{9,8,7}};
		int[][] cantExtend3 = {{2,4,9},
     		{6,8,1},
     		{7,3,5}};
			
		int[][] extend1 = {{7, 3, 5},
                {8, 6, 1},
                {4, 9, 0}};
		int[][] extend2 = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
		int[][] extend3 = {{0,0,0},{0,0,0},{0,0,0}};
		
        // TODO: Complete this method
		
		System.out.println("These cannot be extended:");
		
		System.out.println("Extended:");
		printSquare(cantExtend);
		System.out.println("Can't extend this");
		
		System.out.println("Extended:");
		printSquare(cantExtend2);
		System.out.println("Can't extend this");
		
		System.out.println("Extended:");
		printSquare(cantExtend3);
		System.out.println("Can't extend this");
		
		System.out.println();
		
		System.out.println("These can be extended");
		System.out.println("Extended:");
		printSquare(extend1);
		Arrays.deepToString(extend(extend1));
		
		System.out.println("These can be extended");
		System.out.println("Extended:");
		printSquare(extend2);
		Arrays.deepToString(extend(extend2));
		System.out.println("These can be extended");
		System.out.println("Extended:");
		printSquare(extend3);
		Arrays.deepToString(extend(extend3));
		
		
    }

    static void testNext() {
		
		
        // TODO: Complete this method
    }

    /**
     * Returns a string representation of a number, padded with enough zeros to
     * align properly for the current size square.
     * @param num the number to pad
     * @param size the size of the square that we are padding to
     * @return the padded string of num
     */
    static String pad(int num, int size) {
        // Determine the max value for a square of this size
        int max = size * size;
        // Determine the length of the max value
        int width = Integer.toString(max).length();
        // Convert num to string
        String result = Integer.toString(num);
        // Pad string with 0s to the desired length
        while (result.length() < width) {
            result = " " + result;
        }
        return result;
    }

    /**
     * Prints a square
     * @param square the square to print
     */
    public static void printSquare(int[][] square) {
        if (square == null) {
            System.out.println("Null (no solution)");
            return;
        }
        int size = square.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(pad(square[i][j], size) + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Reads a square of a specified size from a plaintext file
     * @param filename the name of the file to read from
     * @param size the size of the square in the file
     * @return the square
     * @throws FileNotFoundException if the named file is not found
     */
    public static int[][] readSquare(String filename, int size)
                throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int[][] square = new int[size][size];
        int val = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                square[i][j] = scanner.nextInt();
				if(square[i][j]!=0){
					givenNumbers.add(square[i][j]);
				}
            }
        }
        return square;
    }

    /**
     * Solves the magic square
     * @param square the partial solution
     * @return the solution, or null if none
     */
    public static int[][] solve(int[][] square) {
		
        if (reject(square)) return null;
        if (isFullSolution(square)) return square;
        int[][] attempt = extend(square);
        while (attempt != null) {
            int[][] solution;
            solution = solve(attempt);
            if (solution != null) return solution;
            attempt = next(attempt);
        }
        return null;
    }

    public static void main(String[] args) {
        if (args.length >= 1 && args[0].equals("-t")) {
            System.out.println("Running tests...");
            testIsFullSolution();
            testReject();
            testExtend();
            testNext();
        } else if (args.length >= 1) {
            try {
                // First get the specified size
                int size = Integer.parseInt(args[0]);

                int[][] square;
                if (args.length >= 2) {
                    // Read the square from the file
                    square = readSquare(args[1], size);
                } else {
                    // Initialize to a blank square
                    square = new int[size][size];
                }
				
				//fillBoolean(square);
				
                System.out.println("Initial square:");
                printSquare(square);

                System.out.println("\nSolution:");
                int[][] result = solve(square);
                printSquare(result);
            } catch (NumberFormatException e) {
                // This happens if the first argument isn't an int
                System.err.println("First argument must be the size");
            } catch (FileNotFoundException e) {
                // This happens if the second argument isn't an existing file
                System.err.println("File " + args[1] + " not found");
            }
        } else {
			System.out.println(); 
            System.err.println("See example usage in README.md");
        }
    }	
}

