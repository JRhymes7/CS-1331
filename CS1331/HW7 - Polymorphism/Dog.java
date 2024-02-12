/**
 *Dog Class
 *@author JhaDeya Rhymes
 *@version 1.0
 **/
public class Dog extends Pet implements Treatable {
    protected String breed;
    /**
     *constructor Dog a four argument constructor
     @param name assigns variable
     @param age assigns variable
     @param painLevel assigns variable
     @param breed assigns variable
     **/
    public Dog(String name, int age, int painLevel, String breed) {
        super(name , age, painLevel);
        this.breed = breed;
    }
    /**
     *constructor Dog a one argument constructor
     @param breed assigns variable
     **/
    public Dog(String breed) {
        this("Buzz", 6, 3, breed);
    }
    /**
 *Method playWith concrete Method
 @param p takes in Pet object
 @return none
 **/
    public void playWith(Pet p) {
        if (p instanceof Dog) {
            System.out.println("Woof! I love playing with other dogs so much that"
                + " my pain level went from " + painLevel + "to " + (painLevel - 3));
            painLevel -= 3;
        } else if (p instanceof Cat) {
            Cat rue = (Cat) p;
            if (!(rue.getHasStripes())) {
                System.out.println("\nWoof. Cats without stripes are okay since they"
                    + " made my pain level go from " + painLevel + "to " + (painLevel - 1));
                painLevel -= 1;
            } else {
                System.out.println("AHHH! I thought you were a tiger!");
                painLevel += 2;
            }
        }
    }
    /**
 *Method treat reduce painLevel
 @return none
 **/
    public void treat() {
        painLevel -= 3;
    }
    /**
 *Method bark prints statement
 @return none
 **/
    public void bark() {
        System.out.println("bark bark");
    }
    /**
@Override
 *Method toString prints description
 @return string description
 **/
    public String toString() {
        return String.format("My name is %s, I am %d, and I am a %s. On a scale"
        + " of one to ten my pain level is %d. My age in human years is "
        + Treatable.convertDogToHumanYears(age) + ".", name, age, breed, painLevel);
    }
    /**
@Override
 *Method equals
 @param other takes in Object
 @return boolean
 **/
    public boolean equals(Object other) {
        if (!(other instanceof Dog)) {
            return false;
        }
        Dog chi = (Dog) other;
        return ((chi.name.equals(name)) && (chi.age == (age)) && (chi.painLevel == painLevel) && (chi.breed == breed));
    }
}
