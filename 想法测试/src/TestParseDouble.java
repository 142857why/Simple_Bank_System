import java.text.ParseException;

public class TestParseDouble {
    public static void main(String[] args) {
        String oneNumber = "31a9687.19873611a";
        Double oneNumberDouble = Double.parseDouble(oneNumber);
        System.out.println(String.valueOf(oneNumberDouble).equals(oneNumber));
    }
}
