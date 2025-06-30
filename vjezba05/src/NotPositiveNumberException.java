public class NotPositiveNumberException extends Exception {
    public NotPositiveNumberException() {
        super("Unijeli ste 0 ili broj manji od 0, molimo ponovo unesite broj:");
    }
}
