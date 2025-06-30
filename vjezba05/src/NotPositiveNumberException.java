public class NotPositiveNumberException extends Exception {
    public NotPositiveNumberException() {
        super("Unijeli ste broj koji je 0 ili manji od 0, molimo ponovo unesite broj:");
    }
}
