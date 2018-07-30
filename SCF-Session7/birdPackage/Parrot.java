package birdPackage;

/**
 * Class for Parrot which extends Bird Class
 */
public class Parrot extends Bird {

    private String type = "PARROT";
    private String sound = "...OMLET...";

    public String getType() {
        return type;
    }

    public String getSound() {
        return sound;
    }

    @Override
    public String getInfo() {

        return "Name : " + this.getName() + "\nAnimalCageID : "
                + this.getAnimalCageId() + " \nType :" + this.getType()
                + " \nCategory :" + this.getCategory() + " \nAge :"
                + this.getAge() + " \nWeight :" + this.getWeight()
                + " \nSound :" + this.getSound();

    }
}
