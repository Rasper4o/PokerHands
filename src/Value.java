import java.util.HashMap;
import java.util.Map;

public enum Value {
    TWO ('2'),
    THREE ('3'),
    FOUR ('4'),
    FIVE ('5'),
    SIX ('6'),
    SEVEN ('7'),
    EIGHT ('8'),
    NINE ('9'),
    TEN ('T'),
    JACK ('J'),
    QUEEN ('Q'),
    KING ('K'),
    ACE ('A');

    private final char valueCharacter;

    Value (char valueCharacter) {
        this.valueCharacter = valueCharacter;
    }

    private static Map<Character, Value> valueMap = new HashMap<>();

    public char getChar(){
        return valueCharacter;
    }

    static {
        for (Value v : Value.values()) {
            valueMap.put(v.getChar(), v);
        }
    }

    public static Value retrieveValue (char valueChar) {
        Value v = valueMap.get(valueChar);
        return v;
    }
}