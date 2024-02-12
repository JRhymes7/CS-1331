public class WaterBender extends Bender {
    private boolean healer;
    private static int waterPoints;
    //Constructors
    public WaterBender(String name, int strengthLevel, int health, boolean healer) {
        super(name, strengthLevel, health);
        this.healer = healer;
    }
    public WaterBender(String name) {
        this(name, 40, 80, false);
    }
    //Methods
    public void attack(Bender b) {
        if (health > 0) {
            b.health -= strengthLevel;
            if (b.health <= 0) {
                b.health = 0;
                b.strengthLevel = 0;
            }
            if ((b.health < 20) && (b.health > 0)) {
                waterPoints += b.strengthLevel;
            }
        }
    }
    protected void heal(WaterBender wb) {
        if (!healer) {
            return;
        } else {
            wb.health += 20;
            wb.strengthLevel += 20;
        }
    }
    public boolean equals(Object o) {
        if (!(o instanceof WaterBender)) {
            return false;
        }
        WaterBender k = (WaterBender) o;
        return ((k.health == health) && (k.name.equals(name))
            && (k.strengthLevel == strengthLevel) && (k.healer == healer));
    }
    public String toString() {
        if (healer) {
            return String.format("My name is %s. I am a bender. My strength"
            + " level is %s and my current health is %d. With my "
            + "waterbending, I can heal others.",
            name, strengthLevel, health);
        } else {
            return String.format("My name is %s. I am a bender. My strength"
            + " level is %s and my current health is %d. With my"
            + " waterbending, I cannot heal others.",
            name, strengthLevel, health);
        }
    }
    //Accessors
    public boolean getHealer() {
        return healer;
    }
    public static int getWaterPoints() {
        return waterPoints;
    }
    //Setters
    public void setHealer(Boolean healer) {
        this.healer = healer;
    }
}
