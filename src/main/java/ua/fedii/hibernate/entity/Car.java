package ua.fedii.hibernate.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car", schema = "public", catalog = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "release_year")
    private Integer releaseYear;

    public Car() {}

    public Car(String brand, String model, Integer releaseYear) {
        this.brand = brand;
        this.model = model;
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car carEntity = (Car) o;
        return Objects.equals(id, carEntity.id) && Objects.equals(brand, carEntity.brand) && Objects.equals(model, carEntity.model) && Objects.equals(releaseYear, carEntity.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, releaseYear);
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
