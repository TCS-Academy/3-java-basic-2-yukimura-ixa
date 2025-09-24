package lab1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import lab1answer.Lab12Answer;

public class Lab12Test {
    
    @BeforeEach
    public void setUp() {
        // Clean up any existing test files before each test
        Lab12.deleteFile("data.txt");
        Lab12.deleteFile("log.txt");
        Lab12.deleteFile("numbers.txt");
        Lab12Answer.deleteFile("data.txt");
        Lab12Answer.deleteFile("log.txt");
        Lab12Answer.deleteFile("numbers.txt");
    }
    
    @AfterEach
    public void tearDown() {
        // Clean up test files after each test
        Lab12.deleteFile("data.txt");
        Lab12.deleteFile("log.txt");
        Lab12.deleteFile("numbers.txt");
        Lab12Answer.deleteFile("data.txt");
        Lab12Answer.deleteFile("log.txt");
        Lab12Answer.deleteFile("numbers.txt");
    }
    
    @Test
    @DisplayName("Test writeToDataFile method - Should create data.txt with specific content")
    public void testWriteToDataFile() {
        // Test Lab12 (student) implementation
        
        assertDoesNotThrow(() -> {
            Lab12.writeToDataFile();
            assertTrue(Lab12.fileExists("data.txt"), "data.txt should be created");
            
            String content = Lab12.readFromDataFile();
            assertEquals("Hello, File I/O!", content, "data.txt should contain exact text 'Hello, File I/O!'");
        }, "writeToDataFile should create file with correct content");
    }
    
    @Test
    @DisplayName("Test readFromDataFile method - Should read content from data.txt")
    public void testReadFromDataFile() {
        // Test Lab12 (student) implementation
        
        assertDoesNotThrow(() -> {
            // First create the file with known content
            Lab12.writeToDataFile();
            
            // Then read it back
            String content = Lab12.readFromDataFile();
            assertNotNull(content, "readFromDataFile should return non-null content");
            assertEquals("Hello, File I/O!", content, "Should read exact content from data.txt");
        }, "readFromDataFile should read file content correctly");
    }
    
    @Test
    @DisplayName("Test writeLogFile method - Should create log.txt with timestamp")
    public void testWriteLogFile() {
        // Test Lab12 (student) implementation
        
        assertDoesNotThrow(() -> {
            Lab12.writeLogFile();
            assertTrue(Lab12.fileExists("log.txt"), "log.txt should be created");
            
            String logContent = Lab12.readLogFile();
            assertNotNull(logContent, "Log content should not be null");
            assertTrue(logContent.startsWith("Application started at"), 
                      "Log should start with 'Application started at'");
            assertTrue(logContent.length() > 20, "Log should contain timestamp information");
        }, "writeLogFile should create log with timestamp");
    }
    
    @Test
    @DisplayName("Test readLogFile method - Should read content from log.txt")
    public void testReadLogFile() {
        // Test Lab12 (student) implementation
        
        assertDoesNotThrow(() -> {
            // First create the log file
            Lab12.writeLogFile();
            
            // Then read it back
            String logContent = Lab12.readLogFile();
            assertNotNull(logContent, "readLogFile should return non-null content");
            assertTrue(logContent.contains("Application started at"), 
                      "Log content should contain expected text");
        }, "readLogFile should read log file content correctly");
    }
    
    @Test
    @DisplayName("Test writeNumbersFile method - Should create numbers.txt with 1,2,3,4,5")
    public void testWriteNumbersFile() {
        // Test Lab12 (student) implementation
        
        assertDoesNotThrow(() -> {
            Lab12.writeNumbersFile();
            assertTrue(Lab12.fileExists("numbers.txt"), "numbers.txt should be created");
            
            // Verify the numbers file contains correct numbers
            int sum = Lab12.calculateSumFromFile();
            assertEquals(15, sum, "Sum of numbers 1+2+3+4+5 should equal 15");
        }, "writeNumbersFile should create file with numbers 1-5");
    }
    
    @Test
    @DisplayName("Test calculateSumFromFile method - Should return sum of 15")
    public void testCalculateSumFromFile() {
        // Test Lab12 (student) implementation
        
        assertDoesNotThrow(() -> {
            // First create the numbers file
            Lab12.writeNumbersFile();
            
            // Then calculate sum
            int sum = Lab12.calculateSumFromFile();
            assertEquals(15, sum, "Sum of numbers 1+2+3+4+5 should equal 15");
        }, "calculateSumFromFile should return correct sum");
    }
    
    @Test
    @DisplayName("Test fileExists helper method")
    public void testFileExists() {
        // Test helper method functionality
        
        assertFalse(Lab12.fileExists("nonexistent.txt"), 
                   "fileExists should return false for nonexistent file");
        
        assertDoesNotThrow(() -> {
            Lab12.writeToDataFile();
            assertTrue(Lab12.fileExists("data.txt"), 
                      "fileExists should return true for existing file");
        }, "fileExists should work correctly");
    }
    
    @Test
    @DisplayName("Test deleteFile helper method")
    public void testDeleteFile() {
        // Test helper method functionality
        
        assertDoesNotThrow(() -> {
            Lab12.writeToDataFile();
            assertTrue(Lab12.fileExists("data.txt"), "File should exist before deletion");
            
            boolean deleted = Lab12.deleteFile("data.txt");
            assertTrue(deleted, "deleteFile should return true when file is successfully deleted");
            assertFalse(Lab12.fileExists("data.txt"), "File should not exist after deletion");
        }, "deleteFile should work correctly");
    }
    
    @Test
    @DisplayName("Test IOException handling")
    public void testIOExceptionHandling() {
        // Test that methods properly declare IOException
        
        // These should compile without issues (testing method signatures)
        assertDoesNotThrow(() -> {
            try {
                Lab12.writeToDataFile();
                Lab12.readFromDataFile();
                Lab12.writeLogFile();
                Lab12.readLogFile();
                Lab12.writeNumbersFile();
                Lab12.calculateSumFromFile();
            } catch (IOException e) {
                // This is expected and acceptable
            }
        }, "All file methods should properly handle IOException");
    }
    
    @Test
    @DisplayName("Test complete file workflow")
    public void testCompleteWorkflow() {
        // Test the complete workflow works together
        
        assertDoesNotThrow(() -> {
            // Test data.txt workflow
            Lab12.writeToDataFile();
            String dataContent = Lab12.readFromDataFile();
            assertEquals("Hello, File I/O!", dataContent);
            
            // Test log.txt workflow
            Lab12.writeLogFile();
            String logContent = Lab12.readLogFile();
            assertTrue(logContent.startsWith("Application started at"));
            
            // Test numbers.txt workflow
            Lab12.writeNumbersFile();
            int sum = Lab12.calculateSumFromFile();
            assertEquals(15, sum);
            
            // Verify all files exist
            assertTrue(Lab12.fileExists("data.txt"));
            assertTrue(Lab12.fileExists("log.txt"));
            assertTrue(Lab12.fileExists("numbers.txt"));
            
        }, "Complete file workflow should work correctly");
    }
    
    @Test
    @DisplayName("Reference: Lab12Answer working examples")
    public void testAnswerExamples() {
        // This test shows how the complete implementation works
        // Students can see expected behavior here
        
        assertDoesNotThrow(() -> {
            // Example 1: Data file operations
            Lab12Answer.writeToDataFile();
            String dataContent = Lab12Answer.readFromDataFile();
            assertEquals("Hello, File I/O!", dataContent, 
                        "Answer should write and read data.txt correctly");
            
            // Example 2: Log file operations
            Lab12Answer.writeLogFile();
            String logContent = Lab12Answer.readLogFile();
            assertTrue(logContent.startsWith("Application started at"), 
                      "Answer should write log with timestamp");
            
            // Example 3: Numbers file operations
            Lab12Answer.writeNumbersFile();
            int sum = Lab12Answer.calculateSumFromFile();
            assertEquals(15, sum, "Answer should calculate sum correctly");
            
            // Example 4: Helper methods
            assertTrue(Lab12Answer.fileExists("data.txt"), 
                      "Answer fileExists should work");
            
        }, "Answer implementation should work correctly");
    }
    
    @Test
    @DisplayName("Test student implementation methods exist and are callable")
    public void testStudentImplementationExists() {
        // Test that all required methods exist and are callable
        
        assertDoesNotThrow(() -> {
            Lab12.writeToDataFile();
        }, "Student should implement writeToDataFile method");
        
        assertDoesNotThrow(() -> {
            Lab12.writeToDataFile(); // Create file first
            Lab12.readFromDataFile();
        }, "Student should implement readFromDataFile method");
        
        assertDoesNotThrow(() -> {
            Lab12.writeLogFile();
        }, "Student should implement writeLogFile method");
        
        assertDoesNotThrow(() -> {
            Lab12.writeLogFile(); // Create file first
            Lab12.readLogFile();
        }, "Student should implement readLogFile method");
        
        assertDoesNotThrow(() -> {
            Lab12.writeNumbersFile();
        }, "Student should implement writeNumbersFile method");
        
        assertDoesNotThrow(() -> {
            Lab12.writeNumbersFile(); // Create file first
            Lab12.calculateSumFromFile();
        }, "Student should implement calculateSumFromFile method");
        
        assertDoesNotThrow(() -> {
            Lab12.fileExists("test.txt");
        }, "Student should implement fileExists helper method");
        
        assertDoesNotThrow(() -> {
            Lab12.deleteFile("test.txt");
        }, "Student should implement deleteFile helper method");
    }
}
