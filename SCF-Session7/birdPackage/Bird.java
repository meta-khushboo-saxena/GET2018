package birdPackage;

import interfacesPackage.Animal;

/**
 * Class for Bird which implements Animal Interface
 */
public class Bird implements Animal {

    protected String name;
    protected int weight;
    protected int age;
    protected final String category = "Mammal";
    protected int animalCageId;

    // getter setter START

    public String getName() {
        return name;
    }

    public int getAnimalCageId() {
        return animalCageId;
    }

    public void setAnimalCageId(int animalCageId) {
        this.animalCageId = animalCageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public String getInfo() {

        return "This is bird parent class";

    }

    public String getType() {

        return this.category;
    }
    // getter setter END

}
