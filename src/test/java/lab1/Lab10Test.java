package lab1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import lab1.Lab10;

public class Lab10Test {
    
    @Test
    @DisplayName("Test createNamesList method - Should return list with 4 specific names")
    public void testCreateNamesList() {
        // Test Lab10 implementation
        List<String> names = Lab10.createNamesList();
        
        assertNotNull(names, "Names list should not be null");
        assertEquals(4, names.size(), "Names list should contain exactly 4 names");
        assertEquals("Alice", names.get(0), "First name should be Alice");
        assertEquals("Bob", names.get(1), "Second name should be Bob");
        assertEquals("Charlie", names.get(2), "Third name should be Charlie");
        assertEquals("David", names.get(3), "Fourth name should be David");
        
        assertTrue(names.contains("Alice"), "List should contain Alice");
        assertTrue(names.contains("Bob"), "List should contain Bob");
        assertTrue(names.contains("Charlie"), "List should contain Charlie");
        assertTrue(names.contains("David"), "List should contain David");
    }
    
    @Test
    @DisplayName("Test createUniqueNamesSet method - Should return set with 2 unique names")
    public void testCreateUniqueNamesSet() {
        // Test Lab10 implementation
        Set<String> uniqueNames = Lab10.createUniqueNamesSet();
        
        assertNotNull(uniqueNames, "Unique names set should not be null");
        assertEquals(2, uniqueNames.size(), "Set should contain exactly 2 unique names (duplicates removed)");
        assertTrue(uniqueNames.contains("Alice"), "Set should contain Alice");
        assertTrue(uniqueNames.contains("Eve"), "Set should contain Eve");
        
        // Verify that duplicates are automatically removed by Set
        assertFalse(uniqueNames.size() == 3, "Set should not contain 3 elements due to duplicate removal");
    }
    
    @Test
    @DisplayName("Test createNumbersList method - Should return list with 5 specific numbers")
    public void testCreateNumbersList() {
        // Test Lab10 implementation
        List<Integer> numbers = Lab10.createNumbersList();
        
        assertNotNull(numbers, "Numbers list should not be null");
        assertEquals(5, numbers.size(), "Numbers list should contain exactly 5 numbers");
        assertEquals(Integer.valueOf(10), numbers.get(0), "First number should be 10");
        assertEquals(Integer.valueOf(20), numbers.get(1), "Second number should be 20");
        assertEquals(Integer.valueOf(30), numbers.get(2), "Third number should be 30");
        assertEquals(Integer.valueOf(40), numbers.get(3), "Fourth number should be 40");
        assertEquals(Integer.valueOf(50), numbers.get(4), "Fifth number should be 50");
        
        assertTrue(numbers.contains(10), "List should contain 10");
        assertTrue(numbers.contains(20), "List should contain 20");
        assertTrue(numbers.contains(30), "List should contain 30");
        assertTrue(numbers.contains(40), "List should contain 40");
        assertTrue(numbers.contains(50), "List should contain 50");
    }
    
    @Test
    @DisplayName("Test countWordFrequency method - Should count word frequencies correctly")
    public void testCountWordFrequency() {
        // Test Lab10 implementation
        Map<String, Integer> wordFrequency = Lab10.countWordFrequency();
        
        assertNotNull(wordFrequency, "Word frequency map should not be null");
        assertEquals(3, wordFrequency.size(), "Map should contain exactly 3 unique words");
        
        assertEquals(Integer.valueOf(2), wordFrequency.get("hello"), "Word 'hello' should appear 2 times");
        assertEquals(Integer.valueOf(2), wordFrequency.get("world"), "Word 'world' should appear 2 times");
        assertEquals(Integer.valueOf(1), wordFrequency.get("java"), "Word 'java' should appear 1 time");
        
        assertTrue(wordFrequency.containsKey("hello"), "Map should contain key 'hello'");
        assertTrue(wordFrequency.containsKey("world"), "Map should contain key 'world'");
        assertTrue(wordFrequency.containsKey("java"), "Map should contain key 'java'");
    }
    
    @Test
    @DisplayName("Test countWords helper method - Should work with various sentences")
    public void testCountWordsHelper() {
        // Test Lab10 implementation
        Map<String, Integer> result1 = Lab10.countWords("hello world hello java world");
        
        assertNotNull(result1, "Result should not be null");
        assertEquals(3, result1.size(), "Should have 3 unique words");
        assertEquals(Integer.valueOf(2), result1.get("hello"), "hello should appear 2 times");
        assertEquals(Integer.valueOf(2), result1.get("world"), "world should appear 2 times");
        assertEquals(Integer.valueOf(1), result1.get("java"), "java should appear 1 time");
        
        // Test with different sentence
        Map<String, Integer> result2 = Lab10.countWords("java is great java is powerful");
        assertEquals(4, result2.size(), "Should have 4 unique words");
        assertEquals(Integer.valueOf(2), result2.get("java"), "java should appear 2 times");
        assertEquals(Integer.valueOf(2), result2.get("is"), "is should appear 2 times");
        assertEquals(Integer.valueOf(1), result2.get("great"), "great should appear 1 time");
        assertEquals(Integer.valueOf(1), result2.get("powerful"), "powerful should appear 1 time");
        
        // Test with empty string
        Map<String, Integer> result3 = Lab10.countWords("");
        assertEquals(0, result3.size(), "Empty string should result in empty map");
        
        // Test with single word
        Map<String, Integer> result4 = Lab10.countWords("Hello");
        assertEquals(1, result4.size(), "Single word should result in map with 1 entry");
        assertEquals(Integer.valueOf(1), result4.get("hello"), "hello should appear 1 time");
    }
    
    @Test
    @DisplayName("Test student implementation exists - Methods should be callable")
    public void testStudentImplementationExists() {
        // These tests check if student has implemented the methods in Lab10
        // They will pass even if methods return empty collections (until student implements)
        
        assertDoesNotThrow(() -> {
            List<String> names = Lab10.createNamesList();
            assertNotNull(names, "Student's createNamesList should return a non-null list");
        }, "Student should implement createNamesList method");
        
        assertDoesNotThrow(() -> {
            Set<String> uniqueNames = Lab10.createUniqueNamesSet();
            assertNotNull(uniqueNames, "Student's createUniqueNamesSet should return a non-null set");
        }, "Student should implement createUniqueNamesSet method");
        
        assertDoesNotThrow(() -> {
            List<Integer> numbers = Lab10.createNumbersList();
            assertNotNull(numbers, "Student's createNumbersList should return a non-null list");
        }, "Student should implement createNumbersList method");
        
        assertDoesNotThrow(() -> {
            Map<String, Integer> wordFreq = Lab10.countWordFrequency();
            assertNotNull(wordFreq, "Student's countWordFrequency should return a non-null map");
        }, "Student should implement countWordFrequency method");
        
        assertDoesNotThrow(() -> {
            Map<String, Integer> wordCount = Lab10.countWords("test sentence");
            assertNotNull(wordCount, "Student's countWords should return a non-null map");
        }, "Student should implement countWords helper method");
    }
    
    @Test
    @DisplayName("Test Collections behavior - List allows duplicates, Set doesn't")
    public void testCollectionsBehavior() {
        // Test List behavior - allows duplicates
        List<String> list = new ArrayList<>();
        list.add("item");
        list.add("item"); // duplicate
        assertEquals(2, list.size(), "List should allow duplicates");
        
        // Test Set behavior - doesn't allow duplicates
        Set<String> set = new HashSet<>();
        set.add("item");
        boolean added = set.add("item"); // duplicate
        assertEquals(1, set.size(), "Set should not allow duplicates");
        assertFalse(added, "Adding duplicate to Set should return false");
        
        // Test Map behavior - key-value pairs
        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key1", 10); // update existing key
        assertEquals(2, map.size(), "Map should have 2 keys");
        assertEquals(Integer.valueOf(10), map.get("key1"), "Map should update existing key");
    }
}
