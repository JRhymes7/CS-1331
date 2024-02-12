/**
 *Cat Class
 *@author JhaDeya Rhymes
 *@version 1.0
 **/
public class Cat extends Pet implements Treatable {
    private boolean hasStripes;
    /**
     *constructor Cat a four argument constructor
     @param name assigns variable
     @param age assigns variable
     @param painLevel assigns variable
     @param hasStripes assigns variable
     **/
    public Cat(String name, int age, int painLevel, boolean hasStripes) {
        super(name, age, painLevel);
        this.hasStripes = hasStripes;
    }
    /**
     *constructor Cat a one argument constructor
     @param hasStripes assigns variable
     **/
    public Cat(boolean hasStripes) {
        this("Purrfect", 4, 9, hasStripes);
    }
    /**
 *Method playWith concrete Method
 @param p takes in Pet object
 @return none
 **/
    public void playWith(Pet p) {
        if (p instanceof Cat && hasStripes) {
            painLevel -= 4;
            System.out.println("Meow! I love playing with other cats with the same pattern as me");
        } else if (p instanceof Cat && !hasStripes) {
            System.out.println("Meow! I like playing with other cats without the same pattern as me");
            painLevel -= 2;
        } else if (p instanceof Dog) {
            System.out.println("Meow. Go away [Dog’s name]! I don’t like playing with Dogs!");
            painLevel += 1;
        }
    }
    /**
 *Method treat reduce painLevel
 @return none
 **/
    public void treat() {
        painLevel -= 1;
    }
    /**
@Override
 *Method toString prints description
 @return string description
 **/
    public String toString() {
        return String.format("My name is %s and I am %d. On a scale of one to ten my pain level is"
        + " %d. My age in human years is " + Treatable.convertCatToHumanYears(age) + ".", name, age, painLevel);
    }
    /**
@Override
 *Method equals
 @param other takes in Object
 @return boolean
 **/
    public boolean equals(Object other) {
        if (!(other instanceof Cat)) {
            return false;
        }
        Cat chi = (Cat) other;
        return ((chi.name.equals(name)) && (chi.age == age)
            && (chi.painLevel == painLevel) && (chi.hasStripes == hasStripes));
    }
    /**
 *Method getHasStripes accessor Method
 @return hasStripes
 **/
    public boolean getHasStripes() {
        return hasStripes;
    }
}
