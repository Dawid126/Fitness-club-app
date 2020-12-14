package shop;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
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

    @OneToMany(mappedBy = "product")
    private List<Order> orders = new ArrayList<>();

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
        return price/100+","+price%100+"$";
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
    public boolean setPrice(double price) {
        if(price < 0 || (price*100 - Math.round(price*100) != 0))
            return false;
        this.price = (int) price*100;
        return true;
    }
    public void setDescription(String description) {
        this.description = description;
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
