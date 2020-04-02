
import java.util.*; 

class GFG { 

	static int[][] mat = new int[10][6]; 

	static void arrangeArrival(int num, int[][] mat) { 
		for (int i = 0; i < num; i++) { 
			for (int j = 0; j < num - i - 1; j++) { 
				if (mat[j][1] > mat[j + 1][1]) { 
					for (int k = 0; k < 5; k++) { 
						int temp = mat[j][k]; 
						mat[j][k] = mat[j + 1][k]; 
						mat[j + 1][k] = temp; 
					} 
				} 
			} 
		} 
	} 




