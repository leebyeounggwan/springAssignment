
import java.util.UUID;

public class Taxi extends Transport {

    static int basicDistance = 50; // 기본 거리
    String destination; //목적지
    int destinationDistance; //목적지까지 거리
    static int plusCharge = 1000; // 기본거리 이상일 경우 적용되는 요금
    int payCheck; // 요금

    public Taxi (String num, int oil, int speed, int charge, String status) {
        super(num,oil,speed,charge,status);
    }

    public Taxi() {
        this(UUID.randomUUID().toString(), 50, 50, 4000, "일반");
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
        if (super.status == "일반" && passenger <= 4) {
            super.status = "운행 중";
        } else {
            System.out.print("탑승 불가");
        }
    }

    public void payChecking() { // 거리당 요금 추가
        if(destination != null || destinationDistance != 0){
            if(destinationDistance <= basicDistance){
                this.payCheck = charge;
            } else {
                this.payCheck = charge + ((destinationDistance-50)/10)*plusCharge;
                charge();
            }
        }else {
            System.out.println("목적지와 목적지까지 거리를 입력해주세요. ex)setDestination(\"목적지\", 30)");
        }
    }

    public void charge() { // 요금 결제
        payChecking();
        if(destination != null || destinationDistance != 0){
            System.out.println("요금은 " + payCheck + "원 입니다." );
            driveStart();
            this.destination = null;
            this.destinationDistance = 0;
        }
    }


    public void setDestination(String destination, int distance) {
        this.destination = destination;
        this.destinationDistance = distance;
        this.oil -= (distance/15);
    }

}