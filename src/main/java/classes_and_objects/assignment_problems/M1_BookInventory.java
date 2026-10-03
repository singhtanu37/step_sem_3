package classes_and_objects.assignment_problems;

public class M1_BookInventory {
    String title;
    String author;
    int copiesAvailable;

    public M1_BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {
        M1_BookInventory[] books = new M1_BookInventory[] {
            new M1_BookInventory("Clean Code", "Robert C. Martin", 3),
            new M1_BookInventory("Effective Java", "Joshua Bloch", 5),
            new M1_BookInventory("Refactoring", "Martin Fowler", 0),
            new M1_BookInventory("Design Patterns", "GoF", 2)
        };

        for (M1_BookInventory book : books) {
            book.printEntry();
        }
    }
}
