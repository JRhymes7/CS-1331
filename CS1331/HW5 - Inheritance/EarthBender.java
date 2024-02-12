public class EarthBender extends Bender {
    private boolean earthArmor;
    private static int earthPoints;
    //Constructors
    public EarthBender(String name, int strengthLevel, int health, boolean earthArmor) {
        super(name, strengthLevel, health);
        this.earthArmor = earthArmor;
    }
    public EarthBender(String name) {
        this(name, 40, 100, false);
    }
    //Methods
    public void attack(Bender b) {
        if (health > 0) {
            if (!(b instanceof EarthBender)) {
                return;
            } else {
                b.health -= strengthLevel;
                if (earthArmor) {
                    b.health -= 20;
                }
                if (b.health <= 0) {
                    b.health = 0;
                    b.strengthLevel = 0;
                }
                if ((b.health < 20) && (b.health > 0)) {
                    earthPoints += b.strengthLevel;
                }
                earthArmor = false;
            }
        }
    }
    public void buildArmor() {
        earthArmor = true;
    }
    //Accessors
    public boolean getEarthArmor() {
        return earthArmor;
    }
    public static int getEarthPoints() {
        return earthPoints;
    }
    //Setters
    public void setHealer(Boolean armor) {
        earthArmor = armor;
    }
}
