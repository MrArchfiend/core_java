import java.util.ArrayList;
public class CharacterCheck {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('3');
        list.add('z');

        for (char c : list) {
            if (Character.isDigit(c))
                System.out.println(c + " is a Digit");
            else if (Character.isAlphabetic(c))
                System.out.println(c + " is an Alphabet");
            else
                System.out.println(c + " is something else");
        }
    }
}