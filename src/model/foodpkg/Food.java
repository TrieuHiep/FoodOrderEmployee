package model.foodpkg;


/**
 * Created by tatsuya on 07/04/2018.
 */

public class Food {
    private int id;
    private String productName;
    private long price;
    private int quantity;
    private String imageURL;

    public Food() {
    }

    public Food(int id, String productName,
                long price, int quantity, String imageURL) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}
