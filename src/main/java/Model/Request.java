package Model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity for table Request
 */
@Entity
@Table(name = "request")
public class Request implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "model")
    private String model;
    @Column(name = "rental_time")
    private int rentalTime;

    @ManyToOne
    @JoinColumn(name="id_passport")
    private Client client;

    public int getId() {
        return id;
    }

    public void setId(int amountRequests) {
        this.id = amountRequests;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(int rentalTime) {
        this.rentalTime = rentalTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
