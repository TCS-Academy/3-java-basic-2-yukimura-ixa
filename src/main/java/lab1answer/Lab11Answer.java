package lab1answer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab11Answer {
    
    // โจทย์ทำตาม: สร้าง method ชื่อว่า validateName 
    // โดยถ้า name = "XXX" จะ Throw InvalidNameException ออกมา
    // ถ้า name เป็น null หรือ empty string ก็ให้ throw InvalidNameException
    public static void validateName(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Name cannot be null or empty");
        }
        if ("XXX".equals(name)) {
            throw new InvalidNameException("Name cannot be XXX");
        }
    }
    
    // โจทย์ทำเอง: สร้างเมธอดที่รับค่าจากผู้ใช้และใช้ try-catch จัดการ InputMismatchException
    // ให้สร้าง method ที่รับตัวเลข integer จากผู้ใช้ โดยใช้ Scanner
    // ถ้าผู้ใช้ใส่ข้อมูลที่ไม่ใช่ตัวเลข ให้จัดการด้วย try-catch
    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Please enter a number: ");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            return -1; // Return -1 to indicate error
        }
    }
    
    // Method สำหรับทดสอบโดยไม่ใช้ Scanner จริง (สำหรับ testing)
    public static int simulateUserInput(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            return -1; // Return -1 to indicate error
        }
    }
    
    // Optional: สร้าง method สำหรับถอนเงินจากบัญชี
    // ให้สร้าง method withdraw ที่รับพารามิเตอร์ balance และ amount
    // ถ้า amount > balance ให้ throw InsufficientFundsException
    public static double withdraw(double balance, double amount) throws InsufficientFundsException {
        if (amount < 0) {
            throw new InsufficientFundsException("Withdrawal amount cannot be negative");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Balance: " + balance + ", Requested: " + amount);
        }
        return balance - amount;
    }
    
    public static void main(String[] args) {
        System.out.println("Lab11Answer: Exception Handling");
        
        // ทดสอบ validateName method
        System.out.println("\n=== Testing validateName ===");
        testValidateName();
        
        // ทดสอบ getUserInput method (simulation)
        System.out.println("\n=== Testing getUserInput (Simulation) ===");
        testGetUserInputSimulation();
        
        // ทดสอบ withdraw method (Optional)
        System.out.println("\n=== Testing withdraw ===");
        testWithdraw();
        
        // แสดงตัวอย่างการใช้งาน Exception ต่างๆ
        System.out.println("\n=== Exception Examples ===");
        demonstrateExceptions();
    }
    
    // Helper methods for testing
    public static void testValidateName() {
        // Test case 1: Valid name
        try {
            validateName("John");
            System.out.println("✓ Valid name accepted: John");
        } catch (InvalidNameException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
        
        // Test case 2: Invalid name "XXX"
        try {
            validateName("XXX");
            System.out.println("✗ This should not print - XXX should be rejected");
        } catch (InvalidNameException e) {
            System.out.println("✓ Caught exception for XXX: " + e.getMessage());
        }
        
        // Test case 3: Null name
        try {
            validateName(null);
            System.out.println("✗ This should not print - null should be rejected");
        } catch (InvalidNameException e) {
            System.out.println("✓ Caught exception for null: " + e.getMessage());
        }
        
        // Test case 4: Empty name
        try {
            validateName("");
            System.out.println("✗ This should not print - empty should be rejected");
        } catch (InvalidNameException e) {
            System.out.println("✓ Caught exception for empty string: " + e.getMessage());
        }
    }
    
    public static void testGetUserInputSimulation() {
        // Simulate valid input
        int result1 = simulateUserInput("123");
        System.out.println("Valid input '123' result: " + result1);
        
        // Simulate invalid input
        int result2 = simulateUserInput("abc");
        System.out.println("Invalid input 'abc' result: " + result2);
        
        // Simulate input with spaces
        int result3 = simulateUserInput("  456  ");
        System.out.println("Input with spaces '  456  ' result: " + result3);
    }
    
    public static void testWithdraw() {
        // Test case 1: Valid withdrawal
        try {
            double result = withdraw(100.0, 50.0);
            System.out.println("✓ Withdrawal successful. Remaining balance: " + result);
        } catch (InsufficientFundsException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
        
        // Test case 2: Insufficient funds
        try {
            withdraw(100.0, 150.0);
            System.out.println("✗ This should not print - insufficient funds");
        } catch (InsufficientFundsException e) {
            System.out.println("✓ Caught exception for insufficient funds: " + e.getMessage());
        }
        
        // Test case 3: Negative amount
        try {
            withdraw(100.0, -10.0);
            System.out.println("✗ This should not print - negative amount");
        } catch (InsufficientFundsException e) {
            System.out.println("✓ Caught exception for negative amount: " + e.getMessage());
        }
        
        // Test case 4: Exact balance withdrawal
        try {
            double result = withdraw(100.0, 100.0);
            System.out.println("✓ Exact balance withdrawal successful. Remaining: " + result);
        } catch (InsufficientFundsException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    public static void demonstrateExceptions() {
        System.out.println("Exception Handling Examples:");
        
        // Example 1: Multiple catch blocks
        try {
            String str = null;
            System.out.println(str.length()); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught general Exception: " + e.getMessage());
        }
        
        // Example 2: Finally block
        try {
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes");
        }
        
        // Example 3: Nested try-catch
        try {
            try {
                validateName("XXX");
            } catch (InvalidNameException e) {
                System.out.println("Inner catch: " + e.getMessage());
                throw new RuntimeException("Re-throwing as RuntimeException");
            }
        } catch (RuntimeException e) {
            System.out.println("Outer catch: " + e.getMessage());
        }
    }
}


