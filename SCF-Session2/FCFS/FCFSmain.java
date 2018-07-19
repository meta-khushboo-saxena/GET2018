package FCFS;

import java.util.Scanner;

public class FCFSmain {

	static FirstComeFirstServe fcfs = new FirstComeFirstServe();

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n, i, j;

		System.out.println("Enter the number of processes");
		n = sc.nextInt();
		int process[][] = new int[n][2];
		int ct[] = new int[n];
		int tat[] = new int[n];
		int wt[] = new int[n];
		int maxwt;

		for (i = 0; i < n; i++) {
			System.out.println("Enter the Arrival time and Burst time for process"+ i + ":");
			for (j = 0; j < 2; j++) {
				process[i][j] = sc.nextInt();
			}
		}

		System.out.println("AT" + "\t" + "BT");
		for (i = 0; i < n; i++) {
			for (j = 0; j < 2; j++) {
				System.out.print(process[i][j] + "\t");
			}
			System.out.println();
		}
		
		fcfs.sort(process);
		System.out.println("After Sorting");
		System.out.println("AT" + "\t" + "BT");
		for (i = 0; i < n; i++) {
			for (j = 0; j < 2; j++) {
				System.out.print(process[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("Completion time for each processes are:");
		fcfs.completionTime(process, ct, n);

		System.out.println("Turn Around time for each processes are:");
		fcfs.turnAroundTime(process, ct, tat, n);

		System.out.println("Waiting time for each processes are:");
		fcfs.waitingTime(process, wt, tat, n);

		System.out.println("Average Waiting time of processes are:");
		fcfs.averageWaitingTime(wt, n);

		System.out.println("Maximum Waiting time of processes are:");
		maxwt = fcfs.maxWaitingTime(wt, n);
		System.out.println(maxwt);

		sc.close();
	}

}
