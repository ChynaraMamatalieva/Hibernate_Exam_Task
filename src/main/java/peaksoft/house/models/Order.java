package peaksoft.house.models;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import peaksoft.house.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter @Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {PERSIST, MERGE}, fetch = FetchType.EAGER)
    private Customer customer;

    @OneToOne
    private Address pointA;

    @OneToOne
    private Address pointB;

    @Column(name = "dateTime")
    private LocalDateTime date;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Supplier supplier;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "status")
    private OrderStatus status;

    public Order(LocalDateTime date, BigDecimal price, OrderStatus status) {
        this.date = date;
        this.price = price;
        this.status = status;
    }

    public Order(LocalDateTime date, BigDecimal price, OrderStatus status, Address pointA, Address pointB, Customer customer, Supplier supplier) {
        this.date = date;
        this.price = price;
        this.status = status;
        this.pointA = pointA;
        this.pointB = pointB;
        this.customer = customer;
        this.supplier = supplier;
    }

}
