public class Main {
    public static void main() {
        Barista barista = new Barista(3000,2);

        Customer customer1 = new Customer("[손님1]", 10000, false);
        customer1.order(barista, "아메리카노");

        System.out.println("-------------------------");

        Customer customer2 = new Customer("[손님2]", 5000, false);
        customer2.order(barista, "아메리카노");

        System.out.println("-------------------------");

        Customer customer3 = new Customer("[손님3]", 7000, false);
        customer3.order(barista, "아메리카노");
    }
}