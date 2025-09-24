package lab1answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lab10Answer {
    
    // โจทย์ทำตาม: สร้าง List ของ String และเพิ่มชื่อคน 4 ชื่อเข้าไป
    // ให้สร้าง method ที่คืนค่า List<String> ที่มีชื่อ "Alice", "Bob", "Charlie", "David"
    public static List<String> createNamesList() {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        return names;
    }
    
    // โจทย์ทำตาม: สร้าง Set ของ String และเพิ่มชื่อ 3 ชื่อ โดยมีชื่อซ้ำกัน 1 ชื่อ
    // ให้สร้าง method ที่คืนค่า Set<String> ที่เพิ่มชื่อ "Alice", "Eve", "Alice" (ซ้ำ)
    // ผลลัพธ์ควรมีแค่ 2 ชื่อใน Set เพราะ Set ไม่เก็บข้อมูลซ้ำ
    public static Set<String> createUniqueNamesSet() {
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("Alice");
        uniqueNames.add("Eve");
        uniqueNames.add("Alice"); // ชื่อซ้ำ - จะถูกลบออก
        return uniqueNames;
    }
    
    // โจทย์ทำเอง: สร้าง ArrayList ของ Integer และเพิ่มตัวเลข 5 ตัว
    // ให้สร้าง method ที่คืนค่า List<Integer> ที่มีตัวเลข 10, 20, 30, 40, 50
    public static List<Integer> createNumbersList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        return numbers;
    }
    
    // Optional: ใช้ Map เพื่อเก็บความถี่ของคำในประโยค
    // ให้สร้าง method ที่นับความถี่ของคำในประโยค "hello world hello java world"
    // ผลลัพธ์ควรเป็น: hello=2, world=2, java=1
    public static Map<String, Integer> countWordFrequency() {
        return countWords("hello world hello java world");
    }
    
    // Helper method สำหรับการนับคำ (สำหรับ Optional)
    public static Map<String, Integer> countWords(String sentence) {
        Map<String, Integer> wordCount = new HashMap<>();
        
        // แปลงประโยคเป็นตัวพิมพ์เล็ก
        String lowerSentence = sentence.toLowerCase();
        
        // แยกคำด้วย split และลบช่องว่างเกิน
        String[] words = lowerSentence.split("\\s+");
        
        // วนลูปนับความถี่แต่ละคำ
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        return wordCount;
    }
    
    public static void main(String[] args) {
        System.out.println("Lab10Answer: Collections Exercise");
        
        // ทดสอบ method ต่างๆ
        List<String> namesList = createNamesList();
        System.out.println("Names List: " + namesList);
        System.out.println("Names List size: " + namesList.size());
        
        Set<String> uniqueNamesSet = createUniqueNamesSet();
        System.out.println("Unique Names Set: " + uniqueNamesSet);
        System.out.println("Unique Names Set size: " + uniqueNamesSet.size());
        
        List<Integer> numbersList = createNumbersList();
        System.out.println("Numbers List: " + numbersList);
        System.out.println("Numbers List size: " + numbersList.size());
        
        Map<String, Integer> wordFrequency = countWordFrequency();
        System.out.println("Word Frequency: " + wordFrequency);
        System.out.println("Word Frequency size: " + wordFrequency.size());
        
        // แสดงการทำงานของ Collections แบบละเอียด
        demonstrateCollections();
    }
    
    // Method สำหรับแสดงผลการทำงานของ Collections
    public static void demonstrateCollections() {
        System.out.println("\n=== Demonstration of Collections ===");
        
        // List - อนุญาตให้มีข้อมูลซ้ำและเรียงลำดับ
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // ซ้ำได้
        System.out.println("List (allows duplicates): " + fruits);
        System.out.println("List size: " + fruits.size());
        
        // Set - ไม่อนุญาตให้มีข้อมูลซ้ำ
        Set<String> uniqueFruits = new HashSet<>(fruits);
        System.out.println("Set (no duplicates): " + uniqueFruits);
        System.out.println("Set size: " + uniqueFruits.size());
        
        // Map - เก็บข้อมูลเป็น key-value pairs
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Somchai", 95);
        studentScores.put("Somsri", 88);
        studentScores.put("Wichan", 92);
        System.out.println("Map (key-value pairs): " + studentScores);
        
        // การใช้งาน Map
        System.out.println("Somchai's score: " + studentScores.get("Somchai"));
        System.out.println("All students: " + studentScores.keySet());
        System.out.println("All scores: " + studentScores.values());
    }
}
