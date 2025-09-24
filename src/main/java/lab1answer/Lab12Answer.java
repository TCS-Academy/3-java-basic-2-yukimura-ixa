package lab1answer;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.File;

public class Lab12Answer {
    
    // โจทย์ทำตาม: ใช้ FileWriter เพื่อสร้างไฟล์ชื่อ data.txt และเขียนข้อความลงไป
    // ให้สร้าง method ที่เขียนข้อความ "Hello, File I/O!" ลงในไฟล์ data.txt
    public static void writeToDataFile() throws IOException {
        try (FileWriter writer = new FileWriter("data.txt")) {
            writer.write("Hello, File I/O!");
        }
    }
    
    // โจทย์ทำตาม: ใช้ Scanner เพื่ออ่านข้อความจากไฟล์ data.txt และแสดงผลออกทางหน้าจอ
    // ให้สร้าง method ที่อ่านเนื้อหาจากไฟล์ data.txt และคืนค่าเป็น String
    public static String readFromDataFile() throws IOException {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(new File("data.txt"))) {
            while (scanner.hasNextLine()) {
                if (content.length() > 0) {
                    content.append("\n");
                }
                content.append(scanner.nextLine());
            }
        }
        return content.toString();
    }
    
    // โจทย์ทำเอง: เขียนโปรแกรมที่เขียนข้อมูลลงในไฟล์ชื่อ log.txt
    // ให้สร้าง method ที่เขียน "Application started at [เวลาปัจจุบัน]" ลงในไฟล์ log.txt
    public static void writeLogFile() throws IOException {
        try (FileWriter writer = new FileWriter("log.txt")) {
            LocalDateTime now = LocalDateTime.now();
            writer.write("Application started at " + now.toString());
        }
    }
    
    // โจทย์ทำเอง: อ่านเนื้อหาจากไฟล์ log.txt แล้วแสดงผล
    // ให้สร้าง method ที่อ่านเนื้อหาจากไฟล์ log.txt และคืนค่าเป็น String
    public static String readLogFile() throws IOException {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(new File("log.txt"))) {
            while (scanner.hasNextLine()) {
                if (content.length() > 0) {
                    content.append("\n");
                }
                content.append(scanner.nextLine());
            }
        }
        return content.toString();
    }
    
    // Optional: เขียนโปรแกรมที่อ่านไฟล์ที่มีตัวเลขในแต่ละบรรทัด แล้วคำนวณหาผลรวมของตัวเลขเหล่านั้น
    // ให้สร้าง method ที่สร้างไฟล์ numbers.txt ที่มีตัวเลข 1, 2, 3, 4, 5 แต่ละบรรทัด
    public static void writeNumbersFile() throws IOException {
        try (FileWriter writer = new FileWriter("numbers.txt")) {
            for (int i = 1; i <= 5; i++) {
                writer.write(String.valueOf(i));
                if (i < 5) {
                    writer.write("\n");
                }
            }
        }
    }
    
    // Optional: อ่านไฟล์ numbers.txt และคำนวณผลรวม
    // ให้สร้าง method ที่อ่านตัวเลขจากไฟล์ numbers.txt และคืนค่าผลรวม (ควรเป็น 15)
    public static int calculateSumFromFile() throws IOException {
        int sum = 0;
        try (Scanner scanner = new Scanner(new File("numbers.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    try {
                        sum += Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        // Skip invalid numbers
                        System.out.println("Skipping invalid number: " + line);
                    }
                }
            }
        }
        return sum;
    }
    
    // Helper method สำหรับตรวจสอบว่าไฟล์มีอยู่หรือไม่
    public static boolean fileExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }
    
    // Helper method สำหรับลบไฟล์ (สำหรับทำความสะอาดหลังจากทดสอบ)
    public static boolean deleteFile(String filename) {
        File file = new File(filename);
        return file.delete();
    }
    
    // Helper method สำหรับอ่านไฟล์ทั่วไป
    public static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                if (content.length() > 0) {
                    content.append("\n");
                }
                content.append(scanner.nextLine());
            }
        }
        return content.toString();
    }
    
    // Helper method สำหรับเขียนไฟล์ทั่วไป
    public static void writeFile(String filename, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        }
    }
    
    // Method สำหรับแสดงตัวอย่างการใช้งาน File I/O แบบต่างๆ
    public static void demonstrateFileOperations() throws IOException {
        System.out.println("=== File I/O Demonstration ===");
        
        // 1. Basic file writing and reading
        System.out.println("1. Basic file operations:");
        writeFile("demo.txt", "This is a demo file content.");
        String demoContent = readFile("demo.txt");
        System.out.println("Demo file content: " + demoContent);
        
        // 2. Append to file
        System.out.println("\n2. Appending to file:");
        try (FileWriter writer = new FileWriter("demo.txt", true)) {
            writer.write("\nThis line is appended.");
        }
        String appendedContent = readFile("demo.txt");
        System.out.println("After append: " + appendedContent);
        
        // 3. Working with numbers
        System.out.println("\n3. Working with numbers:");
        try (FileWriter writer = new FileWriter("calc.txt")) {
            writer.write("10\n20\n30\n");
        }
        
        int total = 0;
        try (Scanner scanner = new Scanner(new File("calc.txt"))) {
            while (scanner.hasNextInt()) {
                total += scanner.nextInt();
            }
        }
        System.out.println("Sum of numbers in calc.txt: " + total);
        
        // 4. Error handling example
        System.out.println("\n4. Error handling:");
        try {
            readFile("nonexistent.txt");
        } catch (IOException e) {
            System.out.println("Expected error for nonexistent file: " + e.getMessage());
        }
        
        // Cleanup
        deleteFile("demo.txt");
        deleteFile("calc.txt");
    }
    
    public static void main(String[] args) {
        System.out.println("Lab12Answer: File I/O Operations");
        
        try {
            // ทดสอบการเขียนและอ่านไฟล์ data.txt
            System.out.println("\n=== Testing data.txt ===");
            writeToDataFile();
            System.out.println("✓ Data written to data.txt");
            
            String dataContent = readFromDataFile();
            System.out.println("✓ Content from data.txt: " + dataContent);
            
            // ทดสอบการเขียนและอ่านไฟล์ log.txt
            System.out.println("\n=== Testing log.txt ===");
            writeLogFile();
            System.out.println("✓ Log written to log.txt");
            
            String logContent = readLogFile();
            System.out.println("✓ Content from log.txt: " + logContent);
            
            // ทดสอบการคำนวณผลรวมจากไฟล์
            System.out.println("\n=== Testing numbers.txt ===");
            writeNumbersFile();
            System.out.println("✓ Numbers written to numbers.txt");
            
            int sum = calculateSumFromFile();
            System.out.println("✓ Sum of numbers from file: " + sum);
            
            // แสดงตัวอย่างการใช้งานเพิ่มเติม
            System.out.println("\n");
            demonstrateFileOperations();
            
            // Cleanup test files
            System.out.println("\n=== Cleanup ===");
            if (deleteFile("data.txt")) System.out.println("✓ Deleted data.txt");
            if (deleteFile("log.txt")) System.out.println("✓ Deleted log.txt");
            if (deleteFile("numbers.txt")) System.out.println("✓ Deleted numbers.txt");
            
        } catch (IOException e) {
            System.out.println("✗ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
