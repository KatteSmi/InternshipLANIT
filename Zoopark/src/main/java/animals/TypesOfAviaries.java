package animals;

public enum TypesOfAviaries {
    SMALLAVIARY(50),
    MEDIUMAVIARY(100),
    LARGEAVIARY(150),
    VERYLARGEAVIARY(200);

    private int sizeEnclosure;


    public int getSizeEnclosure() {
        return sizeEnclosure;
    }

    TypesOfAviaries(int sizeEnclosure) {
        this.sizeEnclosure = sizeEnclosure;
    }
}
