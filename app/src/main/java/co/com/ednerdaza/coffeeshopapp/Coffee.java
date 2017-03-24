package co.com.ednerdaza.coffeeshopapp;

/**
 * Created by edner.daza on 21/03/2017.
 */

class Coffee {
    //immutability using final variables and not setters
    private final String name, price, image;

    public Coffee(String name, String price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
