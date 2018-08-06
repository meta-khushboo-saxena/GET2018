package Counseling;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Queue.QueueUsingList;

public class Counseling {

	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("SubjectAllocation");

	/**
	 * Function to check availability of seats in the program
	 * 
	 * @param Preference
	 * @return true or false
	 * @throws IOException
	 */
	public boolean check(String Preference) throws IOException {

		String excelFilePath2 = "C:\\Users\\user38\\Downloads\\Programs.xlsx";
		FileInputStream inputStream2 = new FileInputStream(new File(excelFilePath2));
		Workbook workbook2 = new XSSFWorkbook(inputStream2);
		Sheet secondSheet = workbook2.getSheetAt(0);
		Iterator<Row> iterator2 = secondSheet.iterator();
		// Iterating row
		while (iterator2.hasNext()) {
			Row nextRow = iterator2.next();
			
			// checking preference available in the program list
			if (nextRow.getCell(0).getStringCellValue().equalsIgnoreCase(Preference)) {
				System.out.println("Before: " + nextRow.getCell(1).getNumericCellValue());

				// checking availability of seats
				if (nextRow.getCell(1).getNumericCellValue() > 0) {
					nextRow.getCell(1).setCellValue(nextRow.getCell(1).getNumericCellValue() - 1);
					System.out.println("After: " + nextRow.getCell(1).getNumericCellValue());

					inputStream2.close();

					// updating the available seat after allocation
					FileOutputStream outFile = new FileOutputStream(new File("C:\\Users\\user38\\Downloads\\Programs.xlsx"));
					workbook2.write(outFile);

					return true;
				}
			}
		}
		workbook2.close();
		return false;
	}

	/**
	 * Function to insert data in new Sheet after allocating program
	 * 
	 * @param student
	 * @param count
	 * @throws Exception
	 */
	public void insertData(Student student, int count) throws Exception {

		Row row = sheet.createRow(count);

		Cell cell1 = row.createCell(0);
		cell1.setCellValue(student.getName());

		Cell cell2 = row.createCell(1);
		cell2.setCellValue(student.getPreference());

		try {
			FileOutputStream out = new FileOutputStream(new File("C:\\Users\\user38\\Downloads\\SubjectAllocation.xlsx"));

			workbook.write(out);

			System.out.println("Sheet Created Successfully!!\n");

			out.close();

		} catch (Exception e) {

			throw new AssertionError("!! File not found !!");

		}
	}

	/**
	 * Function to read the Excel Sheet with names and Preferences , and Storing
	 * names in queue according to sequence
	 * 
	 * @throws Exception
	 *             if workbook not found
	 */
	public void readExcelData() throws Exception {
		int count = 0;

		Student student = new Student();
		QueueUsingList<String> queue = new QueueUsingList<String>();

		String excelFilePath1 = "C:\\Users\\user38\\Downloads\\Counseling.xlsx";

		FileInputStream inputStream1 = new FileInputStream(new File(excelFilePath1));

		Workbook workbook1 = new XSSFWorkbook(inputStream1);

		Sheet firstSheet = workbook1.getSheetAt(0);

		// Adding names in Queue in the given order
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			queue.push(nextRow.getCell(0).getStringCellValue());
		}

		// To display on the console
		queue.show();

		// Checking preferences according to given options for allocating branch
		// as per capacity available
		Iterator<Row> iteratorSheet = firstSheet.iterator();

		while (iteratorSheet.hasNext()) {
			Row nextRow = iteratorSheet.next();
			boolean flag = false;

			// For iterating cell in the sheet
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			// Accessing names from queue in order stored
			student.setName(queue.pop());
			System.out.println("Name: " + student.getName());
			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();

				// checking availability of seats according to preferences
				if (check(cell.getStringCellValue())) {

					System.out.println("Preference : " + cell.getStringCellValue());
					flag = true;
					student.setPreference(cell.getStringCellValue());
					break;

				}
			}

			// condition for unavailability of seats
			if (!flag) {

				System.out.println("Preference : Unallocated");
				student.setPreference("Unallocated");

			}
			insertData(student, count++);
		}
		workbook1.close();
		inputStream1.close();
	}

	public static void main(String[] args) throws Exception {
		Counseling counseling = new Counseling();
		counseling.readExcelData();
	}
}
