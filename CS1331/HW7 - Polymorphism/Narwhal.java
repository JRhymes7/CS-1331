/**
 *Narwhal Class
 *@author JhaDeya Rhymes
 *@version 1.0
 **/
public class Narwhal extends Pet {
    protected int hornLength;
    /**
     *constructor Narwhal a four argument constructor
     @param name assigns variable
     @param age assigns variable
     @param painLevel assigns variable
     @param hornLength assigns variable
     **/
    public Narwhal(String name, int age, int painLevel, int hornLength) {
        super(name, age, painLevel);
        this.hornLength = hornLength;
    }
    /**
     *constructor Narwhal no argument constructor
     **/
    public Narwhal() {
        this("Jelly", 19, 2, 7);
    }
    /**
 *Method playWith concrete Method
 @param p takes in Pet object
 @return none
 **/
    public void playWith(Pet p) {
        if (p instanceof Narwhal) {
            System.out.println("Who needs dogs and cats when we have each other");
            painLevel -= 2;
        } else if (!(p instanceof Narwhal)) {
            System.out.println("I live in the ocean so I can’t play with you");
            painLevel += 1;
        }
    }
    /**
@Override
 *Method toString prints description
 @return string description
 **/
    public String toString() {
        return "My name is " + name + ", and I am " + age + ". On a scale of one to ten my pain level is "
            + painLevel + ". I have a horn that is " + hornLength + " feet long.";
    }
    /**
@Override
 *Method equals
 @param other takes in Object
 @return boolean
 **/
    public boolean equals(Object other) {
        if (!(other instanceof Narwhal)) {
            return false;
        }
        Narwhal chi = (Narwhal) other;
        return ((chi.name.equals(name)) && (chi.age == (age))
            && (chi.painLevel == painLevel) && (chi.hornLength == hornLength));
    }
}
