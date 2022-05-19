
import java.util.UUID;

public class Taxi extends Transport {

    static int maxPassenger = 4;
    int currentPassenger;
    int possiblePassenger;
    static int basicDistance = 1; // 기본 거리
    String destination; //목적지
    int destinationDistance; //목적지까지 거리
    static int plusCharge = 1000; // 기본거리 이상일 경우 적용되는 요금
    int payCheck; // 요금
    int money = 0;

    public Taxi (String num, int oil, int speed, int charge, String status) {
        super(num,oil,speed,charge,status);
    }

    public Taxi() {
        this(UUID.randomUUID().toString(), 100, 50, 3000, "일반");
    }


    @Override // 운행시작
    public void driveStart() {
        if (oil < 10) {
            System.out.println("주유량을 확인해 주세요");
        } else if (this.status == "일반"){
            System.out.println("현재 운행 중입니다.");
        } else{
            this.status = "일반";
        }
    }
    @Override //승객탑승
    public void boarding(int passenger) {
        if (this.status == "일반" && passenger <= maxPassenger) {
            this.status = "운행 중";
            this.currentPassenger += passenger;
            this.possiblePassenger = maxPassenger-passenger;
        } else {
            System.out.println("최대 승객 수 초과");
        }
    }

    public void payChecking() { // 거리당 요금 추가
        if(destination != null || destinationDistance != 0){
            if(destinationDistance <= basicDistance){
                this.payCheck = charge;
                this.money += payCheck;
            } else {
                this.payCheck = charge + ((destinationDistance-1)*plusCharge);
                this.money += payCheck;
            }
        }
    }

    public void charge() { // 요금 결제
        System.out.println(payCheck);
        this.destination = null;
        this.destinationDistance = 0;
        this.currentPassenger = 0;
        this.status = "일반";
    }


    public void setDestination(String destination, int distance) {
        this.destination = destination;
        this.destinationDistance = distance;
        this.status = "운행중";
    }

    @Override
    public void statusChecking() { // 요금 결제
        if(this.oil <= 0){
            this.status = "운행 불가";
            System.out.println("주유 필요");
        }
    }

}