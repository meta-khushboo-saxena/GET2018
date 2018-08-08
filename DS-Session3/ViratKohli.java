package ViratKohli;

import java.util.Scanner;

import PriorityQueue.*;

public class ViratKohli {
	QueueItem queueArray[];
	private Queue queue;
	private int numberOfBowler;
	static Scanner sc = new Scanner(System.in);

	/**
	 * Constructor to initialize bowler number of bowler
	 * 
	 * @param bowlerNumber
	 * @param bowlerQuota
	 */
	public ViratKohli(int numberOfBowler) {
		this.numberOfBowler = numberOfBowler;
	}

	/**
	 * Functon to get the number of bowler
	 */
	public int getNumberOfBowler() {
		return this.numberOfBowler;
	}

	/**
	 * Function to check if the inputs are Integer
	 */
	public static int check() {
		int value = 0;

		// Loop until user inputs non integer values or negative values
		while (!sc.hasNextInt() || (sc.hasNextInt() && (value = sc.nextInt()) <= 0)) {
			System.out.print("Enter Positive Integer !!\n");
			if (!sc.hasNextInt())
				sc.next();
		}
		return value;
	}

	/**
	 * Function to set attributes like, number of bowlers, their quota
	 */
	public void setAttributesAndAddToQueue() {

		queueArray = new QueueItem[this.getNumberOfBowler()];
		queue = new PriorityQueue(queueArray);

		int bowler = 0, quota = 0;
		for (int i = 0; i < this.getNumberOfBowler(); i++) {

			System.out.println("Enter bowler number : ");
			bowler = check();

			System.out.println("Enter bowler Quota : ");
			quota = check();

			queue.addElement(bowler, quota);
		}
	}

	/**
	 * Function to arrange bowlers so that virat can score low
	 */
	public int[] arrangeBowlersToBowl() {

		int orderOfBowlers[] = new int[this.getNumberOfBowler()];

		for (int i = 0; i < orderOfBowlers.length; i++) {

			// Arranging bowlers according to priority queue
			orderOfBowlers[i] = queue.getHighestPriorityElement();
			queue.deleteHighestPriorityElement();
		}
		return orderOfBowlers;
	}

	public static void main(String args[]) {
		int bowler;
		System.out.println("Enter the number of bowler:");
		bowler = check();
		ViratKohli virat = new ViratKohli(bowler);
		virat.setAttributesAndAddToQueue();

		int orderOfBowlers[] = virat.arrangeBowlersToBowl();

		System.out.println("Sequence of bowler to bowl:");
		for (int i = 0; i < orderOfBowlers.length; i++) {

			System.out.println((i + 1) + " Bowler No. " + orderOfBowlers[i]);
		}
	}
}
