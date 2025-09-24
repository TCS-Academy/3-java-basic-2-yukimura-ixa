package lab1answer;

// โจทย์ทำตาม: สร้าง Exception เอง ชื่อว่า InvalidNameException
// Exception นี้ควรเป็น checked exception (extends Exception)
public class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
    
    public InvalidNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
