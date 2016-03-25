package ua.gnatyuk.yaroslav.music_shop.domain.shop;

import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Address;
import ua.gnatyuk.yaroslav.music_shop.domain.price.Price;

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

	public Shop() {
	}

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
