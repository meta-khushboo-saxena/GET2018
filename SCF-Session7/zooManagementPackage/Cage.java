package zooManagementPackage;

import interfacesPackage.Animal;

import java.util.List;

public class Cage {

    Zoo zoo = new Zoo();

    private String category;
    private int capacity;
    private int sparecapacity;
    private String type;
    private int id;
    private int zoneId;

    private List<Animal> listOfAnimal = zoo.listOfAnimal;

    // Getters and Setters START

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSparecapacity() {
        return sparecapacity;
    }

    public void setSparecapacity(int sparecapacity) {
        this.sparecapacity = sparecapacity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // getters and setters END

    /**
     * Function to get list and display info
     * 
     * @return listOfAnimal
     */
    public List<Animal> getInfo() {
        return listOfAnimal;
    }

    public void removeAnimal(int id) {
        this.listOfAnimal.remove(id);
    }
}
