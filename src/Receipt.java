import java.util.HashMap;

public class Receipt {
    private Cart cartInfo;
    private int totalAmount;
    private int orderNumber;

    Receipt(Cart cartInfo, int totalAmount, int orderNumber) {
        this.cartInfo = cartInfo;
        this.totalAmount = totalAmount;
        this.orderNumber = orderNumber;
    }

    void setCartInfo() {}
    void setOrderNumber() {}
    void setTotalAmount() {}

    String print() {
        return "";
    }
}
