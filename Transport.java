public abstract class Transport extends Car {

    int charge;
    String status;

    public Transport(String num, int oil, int speed, int charge, String status) {
        super(num, oil, speed);
        this.charge = charge;
        this.status = status;
    }

    public abstract void driveStart(); // 운행시작

    public abstract void boarding(int passenger);  // 탑승
}
