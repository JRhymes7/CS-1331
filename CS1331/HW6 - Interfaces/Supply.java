public class Supply extends GroceryItem {
    private String blurb;
    /**
     *constructor Supply
     @param name assigns variable
     @param itemCode assigns variable
     @param price assigns variable
     @param description assigns variable
     **/
    public Supply(String name, int itemCode, double price, String description) {
        super(name, itemCode, price);
        this.blurb = description;
    }
    /**
     *Method describe prints description
     @return description of Supply
     **/
    public String describe() {
        return "The item looks like " + blurb + ".";
    }
}
