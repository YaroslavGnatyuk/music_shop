package domain.price;

import java.util.List;

/**
 * Created by root on 17.03.16.
 */
public class Price  {
    List<Product> product;

    public Price(List<Product> product, long quantity, float price) {
        this.product = product;
    }

    public Price(){}

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
