import java.util.UUID;

public class Bus extends Transport {

    static int maxPassenger = 30;
    int currenPassenger = 0;

    public Bus (String num, int oil, int speed, int charge, String status) {
        super(num,oil,speed,charge,status);
    }
//super(UUID.randomUUID().toString(), 50, 50, 1250, "운행");
    public Bus() {
        this(UUID.randomUUID().toString(), 50, 50, 1250, "운행");
    }

    public void driveStart() { //운행
        this.status = "운행";
        System.out.println("운행 시작");
    }

    public void busStatusChange(String status) { // 버스 상태 변경
        if (oil < 10) {
            System.out.println("주유량을 확인해 주세요");
            this.status = "차고지행";
            currenPassenger = 0;
        }else if (status == "운행종료") {
            this.status = "차고지행";
            currenPassenger = 0;
        } else {
            System.out.println("운행을 끝내려면 \"운행종료\"를 입력해주세요");
        }
    }


    @Override
    public void boarding(int passenger) { //승객 탑승
        if (status == "운행") {
            if (currenPassenger >= maxPassenger) {
                System.out.print("최대 승객수를 초과 할 수 없습니다.");
            } else {
                this.currenPassenger += passenger;
            }
        } else {
            System.out.print("운행중이 아닙니다.");
        }
    }
}