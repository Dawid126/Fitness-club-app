package shop;

import model.persons.Client;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 15)
    private Status status;

    public Order () {}
    public Order (Client client, Product product, int quantity) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.status = Status.RESERVED;
    }

    public Client getClient() {
        return client;
    }
    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public Status getStatus() {
        return status;
    }

    public void statusChange(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (!client.equals(order.client)) return false;
        return product.equals(order.product);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + product.hashCode();
        result = 31 * result + client.hashCode();
        return result;
    }

    public enum Status {
        RESERVED,
        PAID,
        SEND,
        CANCELLED
    }
}
