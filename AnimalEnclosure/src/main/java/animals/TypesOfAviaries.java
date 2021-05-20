package animals;

public enum TypesOfAviaries {
    SMALLAVIARY(0),
    MEDIUMAVIARY(1),
    LARGEAVIARY(2),
    VERYLARGEAVIARY(3);

    private int sizeEnclosure;


    public int getSizeEnclosure() {
        return sizeEnclosure;
    }

    TypesOfAviaries(int sizeEnclosure) {
        this.sizeEnclosure = sizeEnclosure;
    }


}
