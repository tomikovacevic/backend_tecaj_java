public enum Titula {
    PROFESOR("Profesor"),
    STUDENT("Student");

    private final String imeTitule;

    Titula(String imeTitule) {
        this.imeTitule = imeTitule;
    }

    public static Titula izNaziva(String naziv) {
        for (Titula t : Titula.values()) {
            if (t.imeTitule.equalsIgnoreCase(naziv)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Ova titula ne postoji:" + naziv);
    }

    public String povuciImeTitule() {
        return imeTitule;
    }
}
