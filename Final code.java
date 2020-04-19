import java.util.*; 
class ved { 
	static int[][] cat = new int[10][6]; 
	static void arrangeArrivale(int numm, int[][] cat) { 
		for (int a = 0; a < numm; a++) { 
			for (int b = 0; b < numm - a - 1; b++) { 
				if (cat[b][1] > cat[b + 1][1]) { 
					for (int c = 0; c < 5; c++) { 
						int tmp = cat[b][c]; 
						cat[b][c] = cat[b + 1][c]; 
						cat[b + 1][c] = tmp; 
					} 
				} 
			} 
		} 
	} 
	static void completionTime(int numm, int[][] cat) { 
		int tmp, vale = -1; 
		cat[0][3] = cat[0][1] + cat[0][2]; 
		cat[0][5] = cat[0][3] - cat[0][1]; 
		cat[0][4] = cat[0][5] - cat[0][2]; 

		for (int a = 1; a < numm; a++) { 
			tmp = cat[a - 1][3]; 
			int low = cat[a][2]; 
			for (int b = a; b < numm; b++) { 
				if (tmp >= cat[b][1] && low >= cat[b][2]) { 
					low = cat[b][2]; 
					vale = b; 
				} 
			} 
			cat[vale][3] = tmp + cat[vale][2]; 
			cat[vale][5] = cat[vale][3] - cat[vale][1]; 
			cat[vale][4] = cat[vale][5] - cat[vale][2]; 
			for (int c = 0; c < 6; c++) { 
				int tem = cat[vale][c]; 
				cat[vale][c] = cat[a][c]; 
				cat[a][c] = tem; 
			} 
		} 
	} 
	public static void main(String[] args) { 
		int numm; 
		Scanner nc = new Scanner(System.in); 
		System.out.println("Press nummber of Process: "); 
		numm = nc.nextInt(); 
		System.out.println("...Press the process ID..."); 
		for (int a = 0; a < numm; a++) { 
			System.out.println("...Process " + (a + 1) + "..."); 
			System.out.println("Press Process Id: "); 
			cat[a][0] = nc.nextInt(); 
			System.out.println("Press Arrivale Time: "); 
			cat[a][1] = nc.nextInt(); 
			System.out.println("Press Burst Time: "); 
			cat[a][2] = nc.nextInt(); 
		} 
		System.out.println("Before Arrange..."); 
		System.out.println("Process ID\tArrivale Time\tBurst Time"); 
		for (int a = 0; a < numm; a++) { 
			System.out.printf("%d\t\t%d\t\t%d\n", 
				cat[a][0], cat[a][1], cat[a][2]); 
		} 
		arrangeArrivale(numm, cat); 
		completionTime(numm, cat); 
		System.out.println("Final Result..."); 
		System.out.println("Process ID\tArrivale Time\tBurst" + 
						" Time\tWaiting Time\tTurnaround Time"); 
		for (int a = 0; a < numm; a++) { 
			System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\n", 
			cat[a][0], cat[a][1], cat[a][2], cat[a][4], cat[a][5]); 
		} 
		nc.close(); 
	} 
} 