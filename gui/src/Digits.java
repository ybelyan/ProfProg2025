public enum Digits {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    ZERO("0");
    private final String digit;

    Digits(String digit){
        this.digit = digit;
    }

    public static boolean contains(String digit) {
        for (Digits value : values()) {
            if (value.getDigit().equals(digit)) {
                return true;
            }
        }
        return false;
    }

    String getDigit() {
        return digit;
    }
}
