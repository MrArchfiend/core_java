public class ConversionChain {
    public static void main(String[] args) {
        int a = 50;
        Integer obj = Integer.valueOf(a);
        String str = obj.toString();
        Integer obj2 = Integer.valueOf(str);

        System.out.println(a);
        System.out.println(obj);
        System.out.println(str);
        System.out.println(obj2);
    }
}