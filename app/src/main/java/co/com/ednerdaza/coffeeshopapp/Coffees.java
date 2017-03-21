package co.com.ednerdaza.coffeeshopapp;

/**
 * Created by edner.daza on 21/03/2017.
 */

class Coffees {

    private String name, price, image;

    public Coffees() {
    }

    public Coffees(String name, String price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
