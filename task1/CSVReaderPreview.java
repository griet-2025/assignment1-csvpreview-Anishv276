package task1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CSVReaderPreview {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\anish\\Downloads\\dataset.csv";
        String line;
        int recordCount = 0;
        int columnCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            if ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                columnCount = columns.length;
                System.out.println("=== Data Preview ===");
                System.out.println("Columns:");
                for (String column : columns) {
                    System.out.print(column + "\t");
                }
                System.out.println("\nTotal Columns: " + columnCount);
                System.out.println("\nFirst 10 Records:");
                int recordsToShow = 10;
                while ((line = br.readLine()) != null && recordsToShow > 0) {
                    String[] data = line.split(",");
                    for (String value : data) {
                        System.out.print(value + "\t");
                    }
                    System.out.println();
                    recordsToShow--;
                    recordCount++;
                }
            }
            while ((line = br.readLine()) != null) {
                recordCount++;
            }
            System.out.println("\nTotal Records (excluding header): " + (recordCount + 1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}