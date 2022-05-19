import java.util.UUID;

public class Bus extends Transport {

    static int maxPassenger = 30;
    int currentPassenger;
    int payCheck;
    int possiblePassenger;
    public Bus (String num, int oil, int speed, int charge, String status) {
        super(num,oil,speed,charge,status);
    }
//super(UUID.randomUUID().toString(), 50, 50, 1250, "운행");
    public Bus() {
        this(UUID.randomUUID().toString(), 100, 50, 1000, "운행");
    }

    public void driveStart() { //운행시작
        this.status = "운행";
        System.out.println("운행중");
    }

    public void busStatusChange(String status) { // 버스 상태 변경
        if (oil < 10) {
            System.out.println("주유 필요");
            this.status = "차고지행";
            currentPassenger = 0;
        }else if (status == "차고지행") {
            this.status = "차고지행";
            currentPassenger = 0;
        } else if (status == "운행"){
            this.status = status;
        } else {
            System.out.println("운행을 끝내려면 \"차고지행\"를 입력해주세요");
        }
    }


    @Override
    public void boarding(int passenger) { //승객 탑승
        if (status == "운행") {
            if (this.currentPassenger+passenger >= this.maxPassenger) {
                System.out.println("최대 승객수를 초과 할 수 없습니다.");
            } else {
                this.currentPassenger += passenger;
                this.payCheck = (passenger*charge);
                this.possiblePassenger = this.maxPassenger-passenger;
            }
        } else {
            System.out.print("운행중이 아닙니다.");
        }
    }

    @Override
    public void statusChecking() {
        if(this.oil < 10){
            this.status = "차고지행";
            System.out.println("주유 필요");
        }
    }
}