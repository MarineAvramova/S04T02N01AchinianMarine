package cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n01.S04T02N01AchinianMarine.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "fruit")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name= "name")
    private String name;
    @Column(name = "quantity")
    private int quantity;

    public Fruit() {
    }

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Fruit " +
                "id " + id +
                ", name '" + name + '\'' +
                ", quantity " + quantity +
                " portion";
    }
}
