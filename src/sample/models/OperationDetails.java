package sample.models;

public class OperationDetails {

    private int id;
    private int operationId;
    private int amount;
    private double price;
    private int productId;

    public OperationDetails() { }

    public OperationDetails(int id, int operationId, int amount, double price, int productId) {
        this.id = id;
        this.operationId = operationId;
        this.amount = amount;
        this.price = price;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
