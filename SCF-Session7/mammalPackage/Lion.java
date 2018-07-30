package mammalPackage;

/**
 * Class for Lion which extends Mammals
 * 
 */
public class Lion extends Mammals {
    private String type = "LION";
    private String sound = "...ROAR...";

    public String getSound() {
        return sound;
    }

    public String getType() {
        return this.type;
    }

    public String getInfo() {

        return "Name : " + this.getName() + "\nAnimalCageID : "
                + this.getAnimalCageId() + " \nType :" + this.getType()
                + " \nCategory :" + this.getCategory() + " \nAge :"
                + this.getAge() + " \nWeight :" + this.getWeight()
                + " \nSound :" + this.getSound();

    }
}
