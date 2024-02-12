import java.util.Arrays;
/**
 *Grocery Class
 *@author JhaDeya Rhymes
 *@version 1.0
 **/
public class Grocery {
    private GroceryItem[] shelf;
    /**
     *constructor Grocery with no arguments
     **/
    public Grocery() {
        this.shelf = new GroceryItem[0];
    }
    /**
     *constructor Grocery with one argument
     @param shelf is a GroceryItem array
     **/
    public Grocery(GroceryItem[] shelf) {
        this.shelf = shelf;
        Arrays.sort(shelf);
    }
    /**
     *Method browseItems loops through and prints array items
     @return none
     **/
    public void browseItems() {
        for (GroceryItem x : shelf) {
            System.out.println(x.getItemCode() + ": " + x.describe());
        }
    }
    /**
     *Method addGroceryItem adds item to array
     *@param newItem is item to add to array
     @return none
     **/
    public void addGroceryItem(GroceryItem newItem) {
        GroceryItem[] newShelf = new GroceryItem[shelf.length + 1];
        for (int i = 0; i < shelf.length; i++) {
            newShelf[i] = shelf[i];
        }
        newShelf[newShelf.length - 1] = newItem;
        this.shelf = newShelf;
        Arrays.sort(shelf);
    }
    /**
     *Method getGroceryItem returns item corresponding to code
     *@param code is searched for in array
     @return GroceryItem if found, null if not
     **/
    public GroceryItem getGroceryItem(int code) {
        for (GroceryItem g : shelf) {
            if (g.getItemCode() == code) {
                return g;
            }
        }
        return null;
    }
    /**
     *Method getNumberOfItems returns number of items in array
     @return the number of shelf items
     **/
    public int getNumberOfItems() {
        return shelf.length;
    }
}
