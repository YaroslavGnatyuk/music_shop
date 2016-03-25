package ua.gnatyuk.yaroslav.music_shop.domain.price;

import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;

/**
 * Created by root on 17.03.16.
 */
public class MusicRecord implements Product {
	TypeOfRecord musicRecord;
	Album album;
	float price;
	long quantity;

	public MusicRecord(TypeOfRecord musicRecord, Album album, float price, long quantity) {

		this.musicRecord = musicRecord;
		this.album = album;
		this.price = price;
		this.quantity = quantity;
	}

	public MusicRecord() {
	}

	public TypeOfRecord getMusicRecord() {
		return musicRecord;
	}

	public void setMusicRecord(TypeOfRecord musicRecord) {
		this.musicRecord = musicRecord;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
