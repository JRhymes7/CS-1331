public class FireBender extends Bender {
    private static int firePoints;
    //Constructors
    public FireBender(String name, int strengthLevel, int health) {
        super(name, strengthLevel, health);
    }
    public FireBender(String name) {
        this(name, 60, 50);
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
                firePoints += b.strengthLevel;
            }
        }
    }
    public void flameCircle(Bender[] b) {
        for (int i = 0; i < b.length; i++) {
            b[i].health -= 10;
            if (b[i].health <= 0) {
                b[i].health = 0;
            }
            firePoints += 5;
        }
    }
    //Accessors
    public static int getFirePoints() {
        return firePoints;
    }
}
