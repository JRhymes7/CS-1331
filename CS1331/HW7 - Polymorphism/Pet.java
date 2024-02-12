/*I worked on the homework assignment alone, using only course materials*/
abstract class Pet {
    protected String name;
    protected int age;
    protected int painLevel;
    /**
     *constructor Pet a three argument constructor
     @param name assigns variable
     @param age assigns variable
     @param painLevel assigns variable
     **/
    public Pet(String name, int age, int painLevel) {
        this.name = name;
        if (age < 1) {
            age = 1;
        } else if (age > 100) {
            age = 100;
        }
        this.age = age;
        if (painLevel < 1) {
            painLevel = 1;
        } else if (painLevel > 10) {
            painLevel = 10;
        }
        this.painLevel = painLevel;
    }
    /**
 *Method playWith abstract Method
 @param p takes in Pet object
 @return none
 **/
    public void playWith(Pet p) { }
    /**
@Override
 *Method toString prints description
 @return string description
 **/
    public String toString() {
        return String.format("My name is %s and I am %d. On a scale of one to "
        + "ten my pain level is %d.", name, age, painLevel);
    }
    /**
@Override
 *Method equals
 @param other takes in Object
 @return boolean
 **/
    public boolean equals(Object other) {
        if (!(other instanceof Pet)) {
            return false;
        }
        Pet chi = (Pet) other;
        return ((chi.name.equals(name)) && (chi.age == (age)) && (chi.painLevel == painLevel));
    }
    /**
 *Method getName accessor Method
 @return name
 **/
    public String getName() {
        return name;
    }
    /**
 *Method getAge accessor Method
 @return age
 **/
    public int getAge() {
        return age;
    }
    /**
 *Method getPainLevel accessor Method
 @return painLevel
 **/
    public int getPainLevel() {
        return painLevel;
    }
}
