public class Customer {
    private String name;
    private int money;
    private boolean hasCoffee;

    public Customer() {
        name = " ";
        money = 0;
        hasCoffee = false;
    }

    public Customer(String name, int money) {
        this.money = money;
        hasCoffee = false;
    }

    public Customer(String name, int money, boolean hasCoffee) {
        this.name = name;
        this.money = money;
        this.hasCoffee = hasCoffee;
    }

    public void checkMoney()
    {
        System.out.println("[손님]" + this.money + "원 남았습니다.");
    }

    public void getPayBack(int payback)
    {
        money += payback;
    }

    public void print() {
        System.out.println(money);
        System.out.println(hasCoffee);
    }

    // 잔액이 부족할 경우 -9 반환, 정상일 경우 0 반환
    public int pay(int coffeePrice) {
        if (money <= coffeePrice) {
            System.out.println(name + "의 잔액이 부족합니다.");
            return -9;
        }
        money = money - coffeePrice;
        return 0;
    }

    public void order(Barista barista, String menuName) {
        if(hasCoffee)
        {
            System.out.println(name + " " + menuName + "를 한 잔 주세요.");
        }

        else
        {
            System.out.println(name + " " + menuName + "를 한 잔 더 주세요!");
        }

        int price = barista.getCoffeePrice();
        System.out.println("[바리스타] 커피 가격은 " + price + "원 입니다.");

        int paymentCheck = pay(price);
        if (paymentCheck == -9)
            return;

        else if (paymentCheck == 0)
        {
            System.out.println(name + " " + price + "원을 지불했습니다.");
            String coffee = barista.takeOrder(this, menuName, price);
            takeCoffee(coffee, 3000);
        }
    }

    public void takeCoffee(String coffee, int coffeePrice)
    {
        hasCoffee = true;
        if (coffee == "0")
        {
            System.out.println(name + coffeePrice + "원을 환불 받았습니다.");
        }
        else
        {
            System.out.println(name + " " + coffee + "를 받았습니다");
        }
    }
}