package interfacesPackage;

import java.util.List;

import zooManagementPackage.Cage;


/**
 * 
 * Interface for zone
 * 
 */
public interface Zone {

    // Setters and getters along with usefull methods used
    
    int getId();

    void setId(int id);

    List<Cage> getInfo();

    int getZoneCapacity();

    void setZoneCapacity(int capacityOfCage);

    String getTypeOfZone();

    int getSpareCapacity();

    void setSpareCapacity(int spareCapacity);

    boolean isCanteenStatus();

    void setCanteenStatus(boolean canteenStatus);

    boolean isParkStatus();

    void setParkStatus(boolean parkStatus);
}
