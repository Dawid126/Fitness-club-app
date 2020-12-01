package shop;

public class Product {
    private String name;
    private int quantity;
    private int price;
    private String description;
    //private Image image;

    public Product (String name, int quantity, int price, String description) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean setQuantity(int quantity) {
        if(quantity < 0)
            return false;
        this.quantity = quantity;
        return true;
    }
    public boolean setPrice(int price) {
        if(price < 0)
            return false;
        this.price = price;
        return true;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
