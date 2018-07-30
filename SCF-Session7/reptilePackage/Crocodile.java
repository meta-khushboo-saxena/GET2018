package reptilePackage;

/**
 *Class for Crocodile which extends Reptile class 
 */
public class Crocodile extends Reptile {

    private String sound = "!! Grunts !!";
    private String type = "CROCODILE";

    public String getType() {
        return type;
    }

    public String getSound() {
        return sound;
    }

    @Override
    public String getInfo() {

        return "Name : " + this.getName() + " \nType :" + this.getType()
                + " \nCategory :" + this.getCategory() + " \nAge :"
                + this.getAge() + " \nWeight :" + this.getWeight()
                + " \nSound :" + this.getSound();

    }

}
