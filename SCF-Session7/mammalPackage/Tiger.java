package mammalPackage;

/**
 * Class for Tiger which extends Mammals
 */
public class Tiger extends Mammals {

    private String type = "TIGER";
    private String sound = "...GROWL...";

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
