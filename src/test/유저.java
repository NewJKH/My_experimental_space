package test;

public class 유저 {
    private int money;

    public 유저(int money) {
        this.money = money;
    }

    public String getMoney() {
        return money+" 원";
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getUsaMoney(){
        return money+" 달러";
    }
}
