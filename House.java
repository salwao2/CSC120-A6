import java.util.ArrayList;

/**
 * A House class represents a Smith dorm building that can be lived in by students and may have a dining hall
 * The House class extends the building class and adds the functionality of a house
 */

public class House extends Building {

  /** The list of students who are currently residents of this house */
  private ArrayList<String> residents;

  /** Whether or not this house has a dining room */
  private boolean hasDiningRoom;

  /**
   * Creates a new House object with the given name, address, number of floors, and dining room status
   *
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors the number of floors in the house
   * @param hasDiningRoom whether or not the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

/**
   * Returns whether or not this house has a dining room
   *
   * @return true if the house has a dining room, false otherwise
   */  
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Returns the number of residents currently living in this house
   *
   * @return the number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Adds a new resident to this house
   *
   * @param name the name of the new resident
   * @throws RuntimeException if the new resident is already a resident of this house
   */
  public void moveIn(String name) {
    // check if this.residents contains name
    if (this.residents.contains(name)) {
      //   if so: throw and exception
      throw new RuntimeException(name + " is already a resident of " + this.name);
    }
    // if not, add to roster
    this.residents.add(name);
    System.out.println(name + " has just moved into " + this.name + "! Go say hello :)");
  }

  /**
   * Removes a resident from this house
   *
   * @param name the name of the resident to remove
   * @throws RuntimeException if the named resident is not a resident of this house
   */

  public void moveOut(String name) {
    if (!this.residents.contains(name)) {
        throw new RuntimeException(name + " is not a resident of " + this.name);
    }
    this.residents.remove(name);
    System.out.println(name + " has moved out of " + this.name + ". Go say goodbye :(");
}

  /**
   * Returns whether or not the given person is a resident of this house
   *
   * @param person the name of the person to check
   * @return true if the person is a resident, false otherwise
   */
  public boolean isResident(String person) {
    return this.residents.contains(person);
  }  

  /**
   * Returns a String representation of this house, including its name, address, number of floors,
   * number of residents, and dining room status
   *
   * @return a String describing the house
   */
  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    return description;
  }

  public static void main(String[] args) {
    House morrow = new House("Morrow", "The Quad", 4, false);
    System.out.println(morrow);
    morrow.moveIn("Jordan");
    //morrow.moveIn("Jordan"); // this should throw an exception
    morrow.moveIn("Taylor");
    System.out.println(morrow);
    morrow.moveOut("Jordan");
    System.out.println(morrow);

    House king = new House("King", "The Quad", 3, true);
    System.out.println(king);

    // Check if Jordan is a resident of Morrow
    System.out.println("Is Taylor a resident of Morrow? " + morrow.isResident("Taylor"));
    // Check if Alice is a resident of Morrow
    System.out.println("Is Jordan a resident of Morrow? " + morrow.isResident("Jordan"));


    
  }

}