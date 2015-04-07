package csis.pace.edu.animalfaceoff;

/**
 * Created by Gagandeep on 4/5/2015.
 */
public enum AnimalTypes {

    RAT("Rat"),
    CAT("Cat"),
    ELEPHANT("Elephant");

    private String name;

    private AnimalTypes(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public static AnimalTypes getType(String name){
        return AnimalTypes.valueOf(name.toUpperCase());
    }
}
