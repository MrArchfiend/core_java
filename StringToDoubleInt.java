public class StringToDoubleInt {
    public static void main(String[] args) {
        String s = "45.98";
        Double d = Double.parseDouble(s);
        System.out.println("Integer value: " + d.intValue());
    }
}