package jpql;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Address homeAddress;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Product> products = new ArrayList<>();

    private int orderAmount;
}
