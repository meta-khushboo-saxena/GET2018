package birdPackage;

/**
 * Class for Peacock which extends Bird Class
 */
public class Peacock extends Bird {
    private String type = "PEACOCK";
    private String sound = "...HOOT...";

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
