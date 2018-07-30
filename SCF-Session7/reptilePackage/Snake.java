package reptilePackage;

/**
 * Class for Snake which extend Reptile
 * 
 */
public class Snake extends Reptile {

	private String sound = "!! HISS !!";
	private String type = "SNAKE";

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
