package lab1answer;

// Optional: สร้าง Custom Exception ชื่อ InsufficientFundsException 
// สำหรับกรณีที่พยายามถอนเงินจากบัญชีเกินจำนวนที่มีอยู่
public class InsufficientFundsException extends Exception {
    private double balance;
    private double requestedAmount;
    
    public InsufficientFundsException(String message) {
        super(message);
    }
    
    public InsufficientFundsException(String message, double balance, double requestedAmount) {
        super(message);
        this.balance = balance;
        this.requestedAmount = requestedAmount;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public double getRequestedAmount() {
        return requestedAmount;
    }
}
