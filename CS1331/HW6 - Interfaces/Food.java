/**
 *Food Class
 *@author JhaDeya Rhymes
 *@version 1.0
 **/
public class Food extends GroceryItem {
    private int age;
    private int expiration;
    /**
     *constructor Food a five argument constructor
     @param name assigns variable
     @param itemCode assigns variable
     @param price assigns variable
     @param age assigns variable
     @param expiration assigns variable
     **/
    public Food(String name, int itemCode, double price, int age, int expiration) {
        super(name, itemCode, price);
        this.age = age;
        this.expiration = expiration;
    }
    /**
     *Method calculateMonthsRemaining returns difference
     @return months remaining before expiration
     **/
    public int calculateMonthsRemaining() {
        return expiration - age;
    }
    /**
     *Method describe prints description
     @return description of food
     **/
    public String describe() {
        return "The food is " + age + " months old and has "
            + calculateMonthsRemaining() + " months remaining before it expires.";
    }
}
