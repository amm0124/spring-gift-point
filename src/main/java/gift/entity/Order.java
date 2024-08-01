package gift.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id", nullable = false)
    private Option option;

    @Column(nullable = false, name = "order_quantity")
    private Integer orderQuantity;

    @Column(nullable = false, name = "order_message")
    private String message;

    @Column(nullable = false, updatable = false, name = "order_date")
    private LocalDateTime orderDate;

    public Order() {
    }

    public Order(Member member, Option option, Integer orderQuantity, String message, LocalDateTime orderDate) {
        this.member = member;
        this.option = option;
        this.orderQuantity = orderQuantity;
        this.message = message;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Option getOption() {
        return option;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getMessage() {
        return message;
    }
}