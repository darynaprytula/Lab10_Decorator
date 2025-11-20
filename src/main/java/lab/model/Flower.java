package lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lab.store.flower.FlowerColor;
import lab.store.flower.FlowerType;
import lombok.Data;

@Data
@Entity
@Table(name = "flowers")
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double sepalLength;

    @Enumerated(EnumType.STRING)
    private FlowerColor color;

    private double price;

    @Enumerated(EnumType.STRING)
    private FlowerType flowerType;

    public String getColor() {
        return color.toString();
    }

    public void setPrice(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("flower price can't be negative");
        }
        price = cost;
    }

    public void setSepalLength(double sepalLen) {
        if (sepalLen < 0) {
            throw new IllegalArgumentException("sepal length can't be negative");
        }
        sepalLength = sepalLen;
    }
}
