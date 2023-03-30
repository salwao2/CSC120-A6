import java.util.Hashtable;

/**
 * The Library class stores and manages a collection of books
 * The Library class inherits from the Building class and adds functionality specific to libraries
 */

public class Library extends Building {

    /**
     * A Hashtable that stores a collection of books as well as their availability status
     */

    private Hashtable<String, Boolean> collection;

    /**
     * Constructor for the Library class
     *
     * @param name     the name of the library
     * @param address  the address of the library
     * @param nFloors  the number of floors in the library
     */

    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        collection = new Hashtable<String, Boolean>();
    }

    /**
     * Adds a new book to the library's collection
     *
     * @param title  the title of the book added
     */

    public void addTitle(String title) {
      if (collection.containsKey(title)) {
          System.out.println(title + " is already in the collection.");
      } else {
          collection.put(title, true);
          System.out.println("Added " + title + " to the collection.");
      }
  }

  /**
     * Removes a book from the library's collection
     *
     * @param title  the title of the book removed
     * @return       the title of the book removed, or null if the book was not found in the collection
     */
  
  public String removeTitle(String title) {
      if (!collection.containsKey(title)) {
          System.out.println(title + " is not in the collection.");
          return null;
      } else {
          collection.remove(title);
          System.out.println("Removed " + title + " from the collection.");
          return title;
      }
  }

  /**
     * Checks out a book from the library's collection
     *
     * @param title  the title of the book checked out
     */
  
  public void checkOut(String title) {
      if (!collection.containsKey(title)) {
          System.out.println(title + " is not in the collection.");
      } else if (!collection.get(title)) {
          System.out.println(title + " is already checked out.");
      } else {
          collection.put(title, false);
          System.out.println("Checked out " + title + ".");
      }
  }

  /**
     * Returns a book to the library's collection
     *
     * @param title  the title of the book returned
     */
  
  public void returnBook(String title) {
      if (!collection.containsKey(title)) {
          System.out.println(title + " is not in the collection.");
      } else if (collection.get(title)) {
          System.out.println(title + " is already available.");
      } else {
          collection.put(title, true);
          System.out.println("Returned " + title + ".");
      }
    }

    /**
     * Checks whether the library's collection contains a given book
     *
     * @param title  the title of the book being checked for
     * @return       true if the book is in the collection, false otherwise
     */

  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
}

    /**
     * Checks whether a given book is available in the library's collection
     *
     * @param title  the title of the book to be checked for availability
     * @return       true if the book is available, false if it is checked out or not in the collection
     */
    
    public boolean isAvailable(String title) {
        if (!this.containsTitle(title)) {
            return false;
        }
        return this.collection.get(title);
    }

    /**
     * Prints the collection of titles in the library along with their availability status.
     */

    public void printCollection() {
        System.out.println("Library Collection:");
        for (String title : this.collection.keySet()) {
            String status = (this.collection.get(title)) ? "Available" : "Checked Out";
            System.out.println("- " + title + " (" + status + ")");
        }
    }

    public static void main(String[] args) {
        Library library = new Library("Neilson Library", "7 Neilson Drive, Northampton MA", 5);
        System.out.println(library);

        // Add some books to the collection
        library.addTitle("The Great Gatsby by F. Scott Fitzgerald");
        library.addTitle("The Song of Achilles by Madeline Miller");
        library.addTitle("The Vanishing Half by Brit Bennett");
        library.addTitle("Pride and Prejudice by Jane Austen");
        
        // Print the entire collection
        library.printCollection();

        // Check if a title is in the collection
        System.out.println("Contains 'The Song of Achilles by Madeline Miller': " + library.containsTitle("The Song of Achilles by Madeline Miller"));
  
        // Check if a title is available
        System.out.println("Is 'The Great Gatsby by F. Scott Fitzgerald' available: " + library.isAvailable("The Great Gatsby by F. Scott Fitzgerald"));
  
        // Check out a book
        library.checkOut("The Vanishing Half by Brit Bennettl");
  
        // Print the entire collection again to see updated status
        library.printCollection();
        
        // Return a book
        library.returnBook("The Vanishing Half by Brit Bennett");
        
        // Print the entire collection again to see updated status
        library.printCollection();
      }
    }




  