package model.shop;

import model.Address;
import model.price.Price;

import javax.persistence.*;

/**
 * Created by yaroslav on 17.03.16.
 */
@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column
    int id;

    @OneToOne
    Address address;
    Price price;

    public Shop(Address address, Price price) {
        this.address = address;
        this.price = price;
    }

    public Shop(){}

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
