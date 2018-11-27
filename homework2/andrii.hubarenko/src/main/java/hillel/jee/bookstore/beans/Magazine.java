package hillel.jee.bookstore.beans;

/**
 * {@link Magazine} is a subclass of PrintEdition. Specific object of print edition,
 * using magazine name as an author and edition number as a name of work.
 */
public class Magazine extends PrintEdition {
    public Magazine(String magazineName, int editionNumber) {
        super(magazineName, Integer.toString(editionNumber));
    }
}
