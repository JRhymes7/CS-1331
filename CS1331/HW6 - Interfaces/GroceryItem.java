/**
 *GroceryItem Class
 *@author JhaDeya Rhymes
 *@version 1.0
 **/
abstract class GroceryItem implements Comparable<GroceryItem>, Describable {
    private String name;
    private int itemCode;
    private double price;
    /**
     *constructor GroceryItem with a name, int, and a price
     @param name is the name of item
     @param itemCode is the code of the item
     @param price is the price of item
     **/
    public GroceryItem(String name, int itemCode, double price) {
        this.name = name;
        this.itemCode = itemCode;
        this.price = price;
    }
    /**
    @override
     *Method compareTo adds to list at index
     *@param other item to compareTo
     @return integer value
     **/
    public int compareTo(GroceryItem other) {
        if (price > other.price) {
            return -1;
        } else if (price < other.price) {
            return 1;
        } else {
            return 0;
        }
    }
    /**
    @Override
     *Method toString prints description
     @return string description
     **/
    public String toString() {
        return itemCode + ": " + describe();
    }
    /**
     *Method getName is accessor for name
     @return name
     **/
    public String getName() {
        return name;
    }
    /**
     *Method getItemCode is accessor for itemCode
     @return itemCode
     **/
    public int getItemCode() {
        return itemCode;
    }
    /**
     *Method getPrice is accessor for price
     @return price
     **/
    public double getPrice() {
        return price;
    }
}
