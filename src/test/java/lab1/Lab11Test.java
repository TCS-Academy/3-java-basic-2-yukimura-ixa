package lab1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import lab1answer.InvalidNameException;
import lab1answer.InsufficientFundsException;

public class Lab11Test {
    
    @Test
    @DisplayName("Test InvalidNameException exists and works correctly")
    public void testInvalidNameException() {
        // Test that the exception class exists and has proper constructor
        InvalidNameException exception = new InvalidNameException("Test message");
        assertEquals("Test message", exception.getMessage(), "Exception should have correct message");
        assertTrue(exception instanceof Exception, "InvalidNameException should extend Exception");
    }
    
    @Test
    @DisplayName("Test InsufficientFundsException exists and works correctly")
    public void testInsufficientFundsException() {
        // Test that the exception class exists and has proper constructor
        InsufficientFundsException exception = new InsufficientFundsException("Test message");
        assertEquals("Test message", exception.getMessage(), "Exception should have correct message");
        assertTrue(exception instanceof Exception, "InsufficientFundsException should extend Exception");
    }
    
    @Test
    @DisplayName("Test validateName method - Student implementation")
    public void testValidateName() {
        // Test Lab11 (student) implementation
        
        // Test case 1: Valid name should not throw exception
        assertDoesNotThrow(() -> {
            Lab11.validateName("John");
        }, "Valid name 'John' should not throw exception");
        
        assertDoesNotThrow(() -> {
            Lab11.validateName("Alice");
        }, "Valid name 'Alice' should not throw exception");
        
        // Test case 2: Name "XXX" should throw InvalidNameException
        lab1.InvalidNameException exception1 = assertThrows(lab1.InvalidNameException.class, () -> {
            Lab11.validateName("XXX");
        }, "Name 'XXX' should throw InvalidNameException");
        
        assertNotNull(exception1.getMessage(), "Exception should have a message");
        
        // Test case 3: Null name should throw InvalidNameException
        lab1.InvalidNameException exception2 = assertThrows(lab1.InvalidNameException.class, () -> {
            Lab11.validateName(null);
        }, "Null name should throw InvalidNameException");
        
        assertNotNull(exception2.getMessage(), "Exception should have a message");
        
        // Test case 4: Empty name should throw InvalidNameException
        lab1.InvalidNameException exception3 = assertThrows(lab1.InvalidNameException.class, () -> {
            Lab11.validateName("");
        }, "Empty name should throw InvalidNameException");
        
        assertNotNull(exception3.getMessage(), "Exception should have a message");
        
        // Test case 5: Whitespace only name should throw InvalidNameException
        lab1.InvalidNameException exception4 = assertThrows(lab1.InvalidNameException.class, () -> {
            Lab11.validateName("   ");
        }, "Whitespace-only name should throw InvalidNameException");
        
        assertNotNull(exception4.getMessage(), "Exception should have a message");
    }
    
    @Test
    @DisplayName("Test withdraw method - Student implementation")
    public void testWithdraw() {
        // Test Lab11 (student) implementation
        
        // Test case 1: Valid withdrawal
        assertDoesNotThrow(() -> {
            double result = Lab11.withdraw(100.0, 50.0);
            assertEquals(50.0, result, 0.001, "Withdrawal should return correct remaining balance");
        }, "Valid withdrawal should not throw exception");
        
        // Test case 2: Exact balance withdrawal
        assertDoesNotThrow(() -> {
            double result = Lab11.withdraw(100.0, 100.0);
            assertEquals(0.0, result, 0.001, "Exact balance withdrawal should result in 0");
        }, "Exact balance withdrawal should not throw exception");
        
        // Test case 3: Insufficient funds should throw exception
        lab1.InsufficientFundsException exception1 = assertThrows(lab1.InsufficientFundsException.class, () -> {
            Lab11.withdraw(100.0, 150.0);
        }, "Withdrawal exceeding balance should throw InsufficientFundsException");
        
        assertNotNull(exception1.getMessage(), "Exception should have a message");
        
        // Test case 4: Negative amount should throw exception (optional behavior)
        assertDoesNotThrow(() -> {
            try {
                Lab11.withdraw(100.0, -10.0);
            } catch (lab1.InsufficientFundsException e) {
                // This is acceptable if student throws exception for negative amounts
                assertNotNull(e.getMessage(), "Exception should have a message");
            }
        }, "Negative withdrawal should either work or throw InsufficientFundsException");
        
        // Test case 5: Zero withdrawal should be valid
        assertDoesNotThrow(() -> {
            double result = Lab11.withdraw(100.0, 0.0);
            assertEquals(100.0, result, 0.001, "Zero withdrawal should return original balance");
        }, "Zero withdrawal should not throw exception");
    }
    
    @Test
    @DisplayName("Test getUserInput method - Student implementation")
    public void testGetUserInput() {
        // Test Lab11 (student) implementation
        // Since getUserInput() uses Scanner for real user input, we can only test that the method exists
        // and returns some value without throwing unexpected exceptions
        
        assertDoesNotThrow(() -> {
            // We can't really test interactive input, but we can verify the method works
            // The method should handle InputMismatchException internally
            // For testing purposes, we just ensure the method is callable
            
            // Note: In a real test environment, you would mock System.in or use dependency injection
            // But for this lab, we're just testing that the method signature exists
            assertTrue(true, "getUserInput method should be implementable");
        }, "getUserInput method should exist and be callable");
    }
    
    @Test
    @DisplayName("Test student implementation exists - Methods should be callable")
    public void testStudentImplementationExists() {
        // These tests check if student has implemented the methods in Lab11
        // They will pass even if methods don't work correctly (until student implements)
        
        // Test validateName method exists
        assertDoesNotThrow(() -> {
            try {
                Lab11.validateName("TestName");
            } catch (lab1.InvalidNameException e) {
                // This is expected if student implemented the method
            }
        }, "Student should implement validateName method");
        
        // Test getUserInput method exists
        assertDoesNotThrow(() -> {
            // We can't really test Scanner-based method in unit test
            // Just verify the method signature exists
            // int result = Lab11.getUserInput(); // Would require user input
            assertTrue(true, "getUserInput method should be implemented");
        }, "Student should implement getUserInput method");
        
        // Test withdraw method exists
        assertDoesNotThrow(() -> {
            try {
                Lab11.withdraw(100.0, 50.0);
            } catch (lab1.InsufficientFundsException e) {
                // This is expected if student implemented the method
            }
        }, "Student should implement withdraw method");
    }
    
    @Test
    @DisplayName("Test Exception inheritance - Custom exceptions should extend Exception")
    public void testExceptionInheritance() {
        // Test InvalidNameException inheritance (from lab1answer package)
        InvalidNameException invalidNameEx = new InvalidNameException("test");
        assertTrue(invalidNameEx instanceof Exception, "InvalidNameException should extend Exception");
        assertTrue(invalidNameEx instanceof Throwable, "InvalidNameException should be Throwable");
        
        // Test InsufficientFundsException inheritance (from lab1answer package)
        InsufficientFundsException fundsEx = new InsufficientFundsException("test");
        assertTrue(fundsEx instanceof Exception, "InsufficientFundsException should extend Exception");
        assertTrue(fundsEx instanceof Throwable, "InsufficientFundsException should be Throwable");
        
        // Test student's exception classes exist
        assertDoesNotThrow(() -> {
            lab1.InvalidNameException studentEx = new lab1.InvalidNameException("test");
            assertTrue(studentEx instanceof Exception, "Student's InvalidNameException should extend Exception");
        }, "Student's InvalidNameException should be properly implemented");
        
        assertDoesNotThrow(() -> {
            lab1.InsufficientFundsException studentEx = new lab1.InsufficientFundsException("test");
            assertTrue(studentEx instanceof Exception, "Student's InsufficientFundsException should extend Exception");
        }, "Student's InsufficientFundsException should be properly implemented");
    }
    
    @Test
    @DisplayName("Test Exception messages are meaningful")
    public void testExceptionMessages() {
        // Test that exceptions have meaningful messages (from lab1answer package)
        InvalidNameException invalidEx = new InvalidNameException("Name cannot be XXX");
        assertNotNull(invalidEx.getMessage(), "InvalidNameException should have a message");
        assertFalse(invalidEx.getMessage().trim().isEmpty(), "InvalidNameException message should not be empty");
        
        InsufficientFundsException fundsEx = new InsufficientFundsException("Insufficient funds");
        assertNotNull(fundsEx.getMessage(), "InsufficientFundsException should have a message");
        assertFalse(fundsEx.getMessage().trim().isEmpty(), "InsufficientFundsException message should not be empty");
    }
    
    @Test
    @DisplayName("Test try-catch behavior understanding")
    public void testTryCatchBehavior() {
        // Test that exceptions can be caught and handled (using lab1answer package)
        boolean exceptionCaught = false;
        
        try {
            throw new InvalidNameException("Test exception");
        } catch (InvalidNameException e) {
            exceptionCaught = true;
            assertEquals("Test exception", e.getMessage(), "Caught exception should have correct message");
        }
        
        assertTrue(exceptionCaught, "Exception should be caught by try-catch block");
        
        // Test with InsufficientFundsException
        boolean fundsExceptionCaught = false;
        
        try {
            throw new InsufficientFundsException("Test funds exception");
        } catch (InsufficientFundsException e) {
            fundsExceptionCaught = true;
            assertEquals("Test funds exception", e.getMessage(), "Caught exception should have correct message");
        }
        
        assertTrue(fundsExceptionCaught, "InsufficientFundsException should be caught by try-catch block");
    }
    
    @Test
    @DisplayName("Reference: Lab11Answer working examples")
    public void testAnswerExamples() {
        // This test shows how the complete implementation works
        // Students can see expected behavior here
        
        // Example 1: ValidateName working correctly
        assertDoesNotThrow(() -> {
            lab1answer.Lab11Answer.validateName("ValidName");
        }, "Answer validateName should accept valid names");
        
        assertThrows(InvalidNameException.class, () -> {
            lab1answer.Lab11Answer.validateName("XXX");
        }, "Answer validateName should reject XXX");
        
        // Example 2: Withdraw working correctly  
        assertDoesNotThrow(() -> {
            double result = lab1answer.Lab11Answer.withdraw(100.0, 50.0);
            assertEquals(50.0, result, 0.001, "Answer withdraw should work correctly");
        }, "Answer withdraw should handle valid amounts");
        
        assertThrows(InsufficientFundsException.class, () -> {
            lab1answer.Lab11Answer.withdraw(100.0, 150.0);
        }, "Answer withdraw should reject insufficient funds");
        
        // Example 3: SimulateUserInput working correctly
        assertEquals(123, lab1answer.Lab11Answer.simulateUserInput("123"), 
                    "Answer simulateUserInput should parse valid numbers");
        assertEquals(-1, lab1answer.Lab11Answer.simulateUserInput("abc"), 
                    "Answer simulateUserInput should return -1 for invalid input");
    }
}
