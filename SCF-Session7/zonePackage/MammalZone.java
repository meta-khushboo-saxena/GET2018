package zonePackage;

import java.util.List;

import zooManagementPackage.*;


import interfacesPackage.*;

public class MammalZone implements Zone {
   
	public enum Mammal {
		LION, TIGER
	}
	 
    Zoo zoo = new Zoo();

    private int zoneCapacity;
    private int spareCapacity;
    private boolean canteenStatus;
    private boolean parkStatus;
    private int id;

    private List<Cage> listOfCage = zoo.listOfCage;

    private String typeOfZone = "MAMMAL";

    // setters and getters START
    public int getZoneCapacity() {
        return zoneCapacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setZoneCapacity(int capacityOfCage) {
        this.zoneCapacity = capacityOfCage;
    }

    public String getTypeOfZone() {
        return typeOfZone;
    }

    public int getSpareCapacity() {
        return spareCapacity;
    }

    public void setSpareCapacity(int spareCapacity) {
        this.spareCapacity = spareCapacity;
    }

    public boolean isCanteenStatus() {
        return canteenStatus;
    }

    public void setCanteenStatus(boolean canteenStatus) {
        this.canteenStatus = canteenStatus;
    }

    public boolean isParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(boolean parkStatus) {
        this.parkStatus = parkStatus;
    }

    // setters and getters END

    public List<Cage> getInfo() {
        return listOfCage;
    }
}
