package lab1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import lab1answer.Lab13Answer;

public class Lab13Test {
    
    @Test
    @DisplayName("Test createNumbersList method - Should return List with numbers 1-10")
    public void testCreateNumbersList() {
        // Test Lab13 (student) implementation
        List<Integer> numbers = Lab13.createNumbersList();
        
        assertNotNull(numbers, "createNumbersList should return a non-null List");
        assertEquals(10, numbers.size(), "List should contain exactly 10 numbers");
        
        // Check specific numbers 1-10
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(expected, numbers, "List should contain numbers 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 in order");
    }
    
    @Test
    @DisplayName("Test filterEvenNumbers method - Should return only even numbers")
    public void testFilterEvenNumbers() {
        // Test Lab13 (student) implementation
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = Lab13.filterEvenNumbers(numbers);
        
        assertNotNull(evenNumbers, "filterEvenNumbers should return a non-null List");
        assertEquals(5, evenNumbers.size(), "Should return exactly 5 even numbers from 1-10");
        
        // Check specific even numbers
        List<Integer> expectedEvens = Arrays.asList(2, 4, 6, 8, 10);
        assertEquals(expectedEvens, evenNumbers, "Should return even numbers: 2, 4, 6, 8, 10");
        
        // Verify all numbers are actually even
        for (Integer num : evenNumbers) {
            assertEquals(0, num % 2, "All returned numbers should be even (divisible by 2)");
        }
    }
    
    @Test
    @DisplayName("Test printNumbers method - Should execute without throwing exceptions")
    public void testPrintNumbers() {
        // Test Lab13 (student) implementation
        List<Integer> testNumbers = Arrays.asList(2, 4, 6);
        
        // The method should execute without throwing any exceptions
        assertDoesNotThrow(() -> {
            Lab13.printNumbers(testNumbers);
        }, "printNumbers should execute without throwing exceptions");
    }
    
    @Test
    @DisplayName("Test doubleNumbers method - Should return numbers multiplied by 2")
    public void testDoubleNumbers() {
        // Test Lab13 (student) implementation
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> doubledNumbers = Lab13.doubleNumbers(numbers);
        
        assertNotNull(doubledNumbers, "doubleNumbers should return a non-null List");
        assertEquals(5, doubledNumbers.size(), "Doubled list should have same size as original");
        
        // Check specific doubled values
        List<Integer> expectedDoubled = Arrays.asList(2, 4, 6, 8, 10);
        assertEquals(expectedDoubled, doubledNumbers, "Should return numbers multiplied by 2: 2, 4, 6, 8, 10");
        
        // Verify each number is doubled correctly
        for (int i = 0; i < numbers.size(); i++) {
            assertEquals(numbers.get(i) * 2, doubledNumbers.get(i), 
                        "Each number should be exactly double the original");
        }
    }
    
    @Test
    @DisplayName("Test createNamesList method - Should return List with 7 specific names")
    public void testCreateNamesList() {
        // Test Lab13 (student) implementation
        List<String> names = Lab13.createNamesList();
        
        assertNotNull(names, "createNamesList should return a non-null List");
        assertEquals(7, names.size(), "List should contain exactly 7 names");
        
        // Check specific names (as specified in requirements)
        List<String> expectedNames = Arrays.asList("John", "Alexander", "Maria", "Christopher", "Anna", "Benjamin", "Kate");
        assertEquals(expectedNames, names, "List should contain exact names: John, Alexander, Maria, Christopher, Anna, Benjamin, Kate");
        
        // Verify some names are longer than 5 characters
        long longNamesCount = names.stream().filter(name -> name.length() > 5).count();
        assertTrue(longNamesCount >= 3, "At least 3 names should be longer than 5 characters");
    }
    
    @Test
    @DisplayName("Test filterLongNames method - Should return only names longer than 5 characters")
    public void testFilterLongNames() {
        // Test Lab13 (student) implementation
        List<String> names = Arrays.asList("John", "Alexander", "Maria", "Christopher", "Anna", "Benjamin", "Kate");
        List<String> longNames = Lab13.filterLongNames(names);
        
        assertNotNull(longNames, "filterLongNames should return a non-null List");
        assertEquals(3, longNames.size(), "Should return exactly 3 names longer than 5 characters");
        
        // Check specific long names
        List<String> expectedLongNames = Arrays.asList("Alexander", "Christopher", "Benjamin");
        assertTrue(longNames.contains("Alexander"), "Should include Alexander (9 characters)");
        assertTrue(longNames.contains("Christopher"), "Should include Christopher (11 characters)");
        assertTrue(longNames.contains("Benjamin"), "Should include Benjamin (8 characters)");
        
        // Verify all returned names are actually longer than 5 characters
        for (String name : longNames) {
            assertTrue(name.length() > 5, "All returned names should be longer than 5 characters: " + name);
        }
        
        // Verify no short names are included
        assertFalse(longNames.contains("John"), "Should not include John (4 characters)");
        assertFalse(longNames.contains("Maria"), "Should not include Maria (5 characters)");
        assertFalse(longNames.contains("Anna"), "Should not include Anna (4 characters)");
        assertFalse(longNames.contains("Kate"), "Should not include Kate (4 characters)");
    }
    
    @Test
    @DisplayName("Test getNameLengths method - Should return List of name lengths")
    public void testGetNameLengths() {
        // Test Lab13 (student) implementation
        List<String> names = Arrays.asList("John", "Alexander", "Maria");
        List<Integer> nameLengths = Lab13.getNameLengths(names);
        
        assertNotNull(nameLengths, "getNameLengths should return a non-null List");
        assertEquals(3, nameLengths.size(), "Length list should have same size as names list");
        
        // Check specific lengths
        List<Integer> expectedLengths = Arrays.asList(4, 9, 5);
        assertEquals(expectedLengths, nameLengths, "Should return lengths: 4, 9, 5");
        
        // Verify each length matches the corresponding name
        for (int i = 0; i < names.size(); i++) {
            assertEquals(names.get(i).length(), nameLengths.get(i), 
                        "Length should match the actual name length for: " + names.get(i));
        }
    }
    
    @Test
    @DisplayName("Test complete workflow with numbers 1-10")
    public void testCompleteNumbersWorkflow() {
        // Test the complete numbers workflow
        
        // Create numbers list
        List<Integer> numbers = Lab13.createNumbersList();
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), numbers);
        
        // Filter even numbers
        List<Integer> evenNumbers = Lab13.filterEvenNumbers(numbers);
        assertEquals(Arrays.asList(2, 4, 6, 8, 10), evenNumbers);
        
        // Double numbers
        List<Integer> doubledNumbers = Lab13.doubleNumbers(numbers);
        assertEquals(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20), doubledNumbers);
        
        // Print numbers should not throw exception
        assertDoesNotThrow(() -> Lab13.printNumbers(evenNumbers));
    }
    
    @Test
    @DisplayName("Test complete workflow with names")
    public void testCompleteNamesWorkflow() {
        // Test the complete names workflow
        
        // Create names list
        List<String> names = Lab13.createNamesList();
        assertEquals(Arrays.asList("John", "Alexander", "Maria", "Christopher", "Anna", "Benjamin", "Kate"), names);
        
        // Filter long names
        List<String> longNames = Lab13.filterLongNames(names);
        assertEquals(3, longNames.size());
        assertTrue(longNames.contains("Alexander"));
        assertTrue(longNames.contains("Christopher"));
        assertTrue(longNames.contains("Benjamin"));
        
        // Get name lengths
        List<Integer> nameLengths = Lab13.getNameLengths(names);
        assertEquals(Arrays.asList(4, 9, 5, 11, 4, 8, 4), nameLengths);
    }
    
    @Test
    @DisplayName("Test edge cases")
    public void testEdgeCases() {
        // Test with empty list
        List<Integer> emptyNumbers = new ArrayList<>();
        List<Integer> filteredEmpty = Lab13.filterEvenNumbers(emptyNumbers);
        assertEquals(0, filteredEmpty.size(), "Filtering empty list should return empty list");
        
        List<Integer> doubledEmpty = Lab13.doubleNumbers(emptyNumbers);
        assertEquals(0, doubledEmpty.size(), "Doubling empty list should return empty list");
        
        // Test with empty names list
        List<String> emptyNames = new ArrayList<>();
        List<String> filteredEmptyNames = Lab13.filterLongNames(emptyNames);
        assertEquals(0, filteredEmptyNames.size(), "Filtering empty names list should return empty list");
        
        List<Integer> emptyLengths = Lab13.getNameLengths(emptyNames);
        assertEquals(0, emptyLengths.size(), "Getting lengths of empty list should return empty list");
    }
    
    @Test
    @DisplayName("Reference: Lab13Answer working examples")
    public void testAnswerExamples() {
        // This test shows how the complete implementation works
        // Students can see expected behavior here
        
        // Example 1: Numbers operations
        List<Integer> answerNumbers = Lab13Answer.createNumbersList();
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), answerNumbers, 
                    "Answer should create correct numbers list");
        
        List<Integer> answerEvens = Lab13Answer.filterEvenNumbers(answerNumbers);
        assertEquals(Arrays.asList(2, 4, 6, 8, 10), answerEvens, 
                    "Answer should filter even numbers correctly");
        
        List<Integer> answerDoubled = Lab13Answer.doubleNumbers(answerNumbers);
        assertEquals(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20), answerDoubled, 
                    "Answer should double numbers correctly");
        
        // Example 2: Names operations
        List<String> answerNames = Lab13Answer.createNamesList();
        assertEquals(Arrays.asList("John", "Alexander", "Maria", "Christopher", "Anna", "Benjamin", "Kate"), 
                    answerNames, "Answer should create correct names list");
        
        List<String> answerLongNames = Lab13Answer.filterLongNames(answerNames);
        assertEquals(3, answerLongNames.size(), "Answer should filter 3 long names");
        
        List<Integer> answerLengths = Lab13Answer.getNameLengths(answerNames);
        assertEquals(Arrays.asList(4, 9, 5, 11, 4, 8, 4), answerLengths, 
                    "Answer should return correct name lengths");
        
        // Test printNumbers doesn't throw exception
        assertDoesNotThrow(() -> Lab13Answer.printNumbers(answerEvens), 
                          "Answer printNumbers should work correctly");
    }
    
    @Test
    @DisplayName("Test student implementation methods exist and are callable")
    public void testStudentImplementationExists() {
        // Test that all required methods exist and are callable
        
        assertDoesNotThrow(() -> {
            Lab13.createNumbersList();
        }, "Student should implement createNumbersList method");
        
        assertDoesNotThrow(() -> {
            List<Integer> testList = Arrays.asList(1, 2, 3, 4);
            Lab13.filterEvenNumbers(testList);
        }, "Student should implement filterEvenNumbers method");
        
        assertDoesNotThrow(() -> {
            List<Integer> testList = Arrays.asList(1, 2, 3);
            Lab13.printNumbers(testList);
        }, "Student should implement printNumbers method");
        
        assertDoesNotThrow(() -> {
            List<Integer> testList = Arrays.asList(1, 2, 3);
            Lab13.doubleNumbers(testList);
        }, "Student should implement doubleNumbers method");
        
        assertDoesNotThrow(() -> {
            Lab13.createNamesList();
        }, "Student should implement createNamesList method");
        
        assertDoesNotThrow(() -> {
            List<String> testNames = Arrays.asList("John", "Alexander");
            Lab13.filterLongNames(testNames);
        }, "Student should implement filterLongNames method");
        
        assertDoesNotThrow(() -> {
            List<String> testNames = Arrays.asList("John", "Maria");
            Lab13.getNameLengths(testNames);
        }, "Student should implement getNameLengths method");
    }
}
