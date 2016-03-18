package domain.shop;

import domain.musicRecord.Address;
import domain.price.Price;

/**
 * Created by yaroslav on 17.03.16.
 */
public class Shop {
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
