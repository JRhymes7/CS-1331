/**
 *Treatable Interface
 *@author JhaDeya Rhymes
 *@version 1.0
 **/
interface Treatable {
    /**
     *method convertDogToHumanYears converts age
     @param dogAge takes in int
     @return int value of dogAge in human years
     **/
    static int convertDogToHumanYears(int dogAge) {
        int human = (int) Math.round(Math.log(dogAge) * 16);
        return 31 + human;
    }
    /**
     *method convertCatToHumanYears converts age
     @param catAge takes in int
     @return int value of catAge in human years
     **/
    static int convertCatToHumanYears(int catAge) {
        int human = (int) Math.round(Math.log(catAge) * 9);
        return 18 + human;
    }
    /**
 *Method treat abstract Method
 @return none
 **/
    static void treat() { }
}
//Treatable double
//visibility modifiers
