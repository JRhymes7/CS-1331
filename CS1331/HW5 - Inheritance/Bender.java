// I worked on the homework assignment alone, using only course materials
public abstract class Bender {
    protected String name;
    protected int strengthLevel;
    protected int health;
    //Constructors
    public Bender(String name, int strengthLevel, int health) {
        this.name = name;
        this.strengthLevel = strengthLevel;
        this.health = health;
    }
    //Methods
    public void recover(int i) {
        if (health == 0) {
            health += 0;
        } else {
            health += i;
        }
    }
    public void attack(Bender b) {

    }
    public boolean equals(Object o) {
        if (!(o instanceof Bender)) {
            return false;
        }
        Bender chi = (Bender) o;
        return ((chi.health == health) && (chi.name.equals(name)) && (chi.strengthLevel == strengthLevel));
    }
    public String toString() {
        return String.format("My name is %s. I am a bender. My strength level "
        + "is %d and my current health is %d.", name, strengthLevel, health);
    }
    //Accessors
    public String getName() {
        return name;
    }
    public int getStrengthLevel() {
        return strengthLevel;
    }
    public int getHealth() {
        return health;
    }
    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }
    public void setHealth(int health) {
        this.health = health;
    }
}
