/**
 * The Cafe class represents a cafe that sells coffee to customers
 * The Cafe class extends the Building class and adds the functionality of a cafe
 */

public class Cafe extends Building {

    /** The number of coffee ounces in the cafe's inventory */
    private int nCoffeeOunces;

    /** The number of sugar packets in the cafe's inventory */
    private int nSugarPackets;

    /** The number of cream containers in the cafe's inventory */
    private int nCreams;

    /** The number of cups in the cafe's inventory */
    private int nCups;

    /**
     * Creates a new Cafe with the given name, address, number of floors, and inventory levels
     *
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors the number of floors in the cafe
     * @param nCoffeeOunces the number of coffee ounces in the cafe's inventory
     * @param nSugarPackets the number of sugar packets in the cafe's inventory
     * @param nCreams the number of cream containers in the cafe's inventory
     * @param nCups the number of cups in the cafe's inventory
     */

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Sells a coffee of a given size with the specified number of sugar packets and cream containers to a customer
     * Restocks inventory if needed
     *
     * @param size the size of the coffee in ounces
     * @param nSugarPackets the number of sugar packets to add to the coffee
     * @param nCreams the number of cream containers to add to the coffee
     */

    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        int coffeeNeeded = size;
        int sugarNeeded = nSugarPackets;
        int creamNeeded = nCreams;
        int cupsNeeded = 1;

        if (this.nCoffeeOunces < coffeeNeeded || this.nSugarPackets < sugarNeeded || this.nCreams < creamNeeded || this.nCups < cupsNeeded) {
            restock(coffeeNeeded, sugarNeeded, creamNeeded, cupsNeeded);
        }

        this.nCoffeeOunces -= coffeeNeeded;
        this.nSugarPackets -= sugarNeeded;
        this.nCreams -= creamNeeded;
        this.nCups -= cupsNeeded;

        System.out.println("Here's your coffee! Enjoy.");
    }

    /**
     * Restocks the cafe's inventory with the given amounts of coffee, sugar packets, cream containers, and cups
     *
     * @param nCoffeeOunces the number of coffee ounces to add to the inventory
     * @param nSugarPackets the number of sugar packets to add to the inventory
     * @param nCreams the number of cream containers to add to the inventory
     * @param nCups the number of cups to add to the inventory
     */

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        System.out.println("Restocking inventory...");
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Returns the amount of coffee ounces currently in stock.
     *
     * @return the amount of coffee ounces currently in stock
     */

    public int getCoffeeOunces() {
        return this.nCoffeeOunces;
    }

    /**
     * Returns the number of sugar packets currently in stock.
     *
     * @return the number of sugar packets currently in stock
     */

    public int getSugarPackets() {
        return this.nSugarPackets;
    }

    /**
     * Returns the number of cream packets currently in stock.
     *
     * @return the number of cream packets currently in stock
     */

    public int getCreams() {
        return this.nCreams;
    }

    /**
     * Returns the number of cups currently in stock.
     *
     * @return the number of cups currently in stock
     */

    public int getCups() {
        return this.nCups;
    }

    /**
     * Prints the current inventory levels of coffee, sugar, cream, and cupsx
     */

    public void printInventory() {
        System.out.println("Coffee Ounces: " + this.nCoffeeOunces);
        System.out.println("Sugar Packets: " + this.nSugarPackets);
        System.out.println("Creams: " + this.nCreams);
        System.out.println("Cups: " + this.nCups);
    }
    

    public static void main(String[] args) {
        Cafe cafe = new Cafe("Campus Cafe", "1 Chapin Way Northampton MA", 1, 50, 50, 50, 50);
    
        // Print initial inventory
        System.out.println("Initial inventory:");
        cafe.printInventory();
        System.out.println();
    
        // Sell a cup of coffee
        System.out.println("Selling a cup of coffee...");
        cafe.sellCoffee(12, 2, 3);
    
        // Print updated inventory
        System.out.println("Updated inventory:");
        cafe.printInventory();
        System.out.println();
    
        // Try to sell a cup of coffee with insufficient ingredients
        System.out.println("Trying to sell a cup of coffee with insufficient ingredients...");
        cafe.sellCoffee(46, 3, 4);
    
        // Print updated inventory
        System.out.println("Inventory after attempted sale:");
        cafe.printInventory();
        System.out.println();
    
        // Restock ingredients and print updated inventory
        System.out.println("Restocking...");
        cafe.restock(50, 50, 50, 50);
        System.out.println("Inventory after restocking:");
        cafe.printInventory();
    }
    
}
