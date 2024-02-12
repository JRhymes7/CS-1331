/**
 *Vet Class
 *@author JhaDeya Rhymes
 *@version 1.0
 **/
public class Vet {
    public void inspectPet(Pet pet) {
        if (pet instanceof Dog) {
            Dog ro = (Dog) pet;
            ro.bark();
        }
        pet.toString();
    }
    /**
 *Method treatPet checks if pet is Treatable and treats it
 @param pet takes in Pet object
 @return none
 **/
    public static void treatPet(Pet pet) {
        if (pet instanceof Treatable) {
            System.out.printf("\nWelcome to the vet %s", pet.getName());
            if (pet instanceof Cat) {
                Cat rue = (Cat) pet;
                rue.treat();
            } else if (pet instanceof Dog) {
                Dog ro = (Dog) pet;
                ro.treat();
                System.out.println("Wow what a cute dog!");
                giveDogTreat(ro);
            }
        } else {
            System.out.printf("\nSorry, we cannot treat %s", pet.getName());
        }
    }
    /**
 *Method giveDogTreat reduces painLevel of Dog
 @param dog takes in Dog object
 @return none
 **/
    public static void giveDogTreat(Dog dog) {
        dog.painLevel -= 2;
    }
}
