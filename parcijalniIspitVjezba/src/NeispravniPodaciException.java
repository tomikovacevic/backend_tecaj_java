public class NeispravniPodaciException extends RuntimeException {
    public NeispravniPodaciException() {
        super("Unijeli ste praznu ili neispravnu vrijednost");
    }
}
