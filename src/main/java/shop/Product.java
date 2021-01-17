package shop;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "description", nullable = false, length = 50)
    private String description;

    @Column(name = "image")
    private byte[] image;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    public Product () {}
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
    public String getPriceAsString() {
        if(price%100 < 10)
            return price/100+".0"+price%100;
        return price/100+"."+price%100;
    }
    public String getDescription() {
        return description;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public byte[] getImage() {
        return image;
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
    public boolean setPrice(double newPrice) { // || (price*100 - Math.round(price*100) != 0)
        System.out.println("New price "+newPrice);
        if(newPrice < 0)
            return false;
        System.out.println("Parsed "+(int) (newPrice*100));
        this.price = (int) (newPrice*100);
        return true;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + price;
        result = 31 * result + quantity;
        return result;
    }
}
