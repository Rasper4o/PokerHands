import java.util.HashMap;
import java.util.Map;

public enum Suit {
    HEART ('H'),
    DIAMOND ('D'),
    SPADE ('S'),
    CLUB ('C');

    private final char suitCharacter;

    Suit (char suitCharacter) {
        this.suitCharacter = suitCharacter;
    }

    private static Map<Character, Suit> suitMap = new HashMap<>();

    public char getChar() {
        return suitCharacter;
    }

    static {
        for (Suit s : Suit.values()) {
            suitMap.put(s.getChar(), s);
        }
    }

    public static Suit retrieveSuit (char suitChar) {
        Suit s = suitMap.get(suitChar);
        return s;
    }
}