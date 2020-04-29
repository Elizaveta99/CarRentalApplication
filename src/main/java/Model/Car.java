package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity for table Car
 */
@Entity
@Table(name = "car")
public class Car implements Serializable {

    private Car() {}

    @Id
    @Column(name = "car_id")
    private int carId;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "car_state")
    private boolean carState;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setCarState(boolean carState) {
        this.carState = carState;
    }

    public boolean isCarState() {
        return carState;
    }
}
