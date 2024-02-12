public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private String species;
    //Constructors
    public Frog() {
        age = 5;
        tongueSpeed = 5.0;
    }
    public Frog(String initName, double ageinYears, double initTongueSpeed) {
        this();
        name = initName;
        age = (int) ageinYears * 12;
        if ((age >= 1) && (age <= 7)) {
            isFroglet = true;
        } else {
            isFroglet = false;
        }
        tongueSpeed = initTongueSpeed;
    } public Frog(String initName, int initAge, double initTongueSpeed) {
        this();
        name = initName;
        age = initAge;
        if ((age >= 1) && (age <= 7)) {
            isFroglet = true;
        }
        tongueSpeed = initTongueSpeed;
    }
    //Methods
    public void grow(int months) {
        for (int a = 0; a < months; a++) {
            age++;
            if (age <= 12) {
                tongueSpeed++;
            } else if (age > 30) {
                tongueSpeed--;
            }
        }
    }
    public void grow() {
        grow(1);
    }
    public void eat(Fly fly) {
        if (fly.isDead()) {
            return;
        } else if (tongueSpeed > fly.getSpeed()) {
            fly.setMass(0.0);
            if (fly.getMass() >= (.5 * age)) {
                this.grow(1);
            }
        } else {
            fly.setMass(fly.getMass() + 1.0);
        }
    }
    public String toString() {
        if ((age >= 1) && (age <= 7)) {
            isFroglet = true;
        } else {
            isFroglet = false;
        }
        if (isFroglet) {
            return String.format("My name is %s and I'm a rare froglet! "
             + "I'm %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        } else {
            return String.format("My name is %s and I'm a rare frog. "
             + "I'm %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }
    }
    //Accessors
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getTongueSpeed() {
        return tongueSpeed;
    }
    public boolean getIsFroglet() {
        return isFroglet;
    }
    public String getSpecies() {
        return species;
    }
    //Setters
    public void setName(String initName) {
        name = initName;
    }
    public void setAge(int initAge) {
        age = initAge;
    }
    public void setTongueSpeed(Double initTongueSpeed) {
        tongueSpeed = initTongueSpeed;
    }
    public void setSpecies(String initSpecies) {
        species = initSpecies;
    }
}
