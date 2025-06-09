package lectures.lecture2;

public class CarV2 {
    public String name;
    public String price;
    public String engType;
    public String engPower;
    public int maxSpeed;


    public CarV2(String name) {
        this.name = name;
        this.price = "5000000";
        this.engType = "V8";
        this.engPower = "123";
        this.maxSpeed = 100;
    }

    @Override
    public String toString() {
        return "CarV2{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
