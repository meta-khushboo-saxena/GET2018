package FCFS;

/**
 * Contain operation for calculation Completion time
 */
public class FirstComeFirstServe {

	/**
	 * Function for calculating Completion time for each Process
	 * 
	 * @param process
	 *            [][] containing Arrival time and Burst Time
	 * @param ct
	 *            [] array for storing completion time
	 * @param n
	 *            containing number of processes
	 */
	public void completionTime(int process[][], int ct[], int n) {
		int j = 1, i;

		ct[0] = process[0][1];
		System.out.println("CT[0]:" + ct[0]);
		for (i = 1; i < n; i++) {

			if (process[i - 1][j] > process[i][j - 1]) {
				ct[i] = ct[i - 1] + process[i][j];

			} else {
				ct[i] = process[i][j - 1] + process[i][j];
			}
			System.out.println("CT[" + i + "]:" + ct[i]);
		}

	}

	/**
	 * Function for calculating Turn Around time for each Process
	 * 
	 * @param tat
	 *            [] array for storing Turn Around time
	 * @param n
	 *            containing number of processes
	 */
	public void turnAroundTime(int[][] process, int[] ct, int tat[], int n) {
		for (int i = 0; i < n; i++) {
			tat[i] = ct[i] - process[i][0];
			System.out.println("TAT[" + i + "]:" + tat[i]);
		}
	}

	/**
	 * Function for calculating Waiting time for each Process
	 * 
	 * @param wt
	 *            [] array for storing Waiting time
	 */
	public void waitingTime(int[][] process, int[] wt, int tat[], int n) {
		for (int i = 0; i < n; i++) {
			wt[i] = tat[i] - process[i][1];
			System.out.println("WT[" + i + "]:" + wt[i]);
		}
	}

	/**
	 * Function for calculating Average Waiting time of the Processes
	 */
	public void averageWaitingTime(int[] wt, int n) {
		double awt, total = 0;
		for (int i = 0; i < n; i++) {
			total += wt[i];

		}
		awt = total / n;
		System.out.println(awt);
	}

	/**
	 * Function for calculating maximum waiting time among processes
	 */
	public int maxWaitingTime(int[] wt, int n) {
		int max = wt[0];
		for (int i = 1; i < n; i++) {
			if (max < wt[i]) {
				max = wt[i];
			}

		}

		return max;
	}

}
