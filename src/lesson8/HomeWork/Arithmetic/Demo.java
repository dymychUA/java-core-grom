package lesson8.HomeWork.Arithmetic;

public class Demo {
    public static void main(String[] args) {
        Adder adder = new Adder();
        System.out.println(adder.add(10, 20));
        System.out.println(adder.check(new int[] {30, 50, 20, -20, 180}));
    }
}
