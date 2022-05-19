public abstract class Car implements ChangeSpeed {
    String num;
    int oil;
    int speed;


    public Car(String num, int oil, int speed) {
        this.num = num;
        this.oil = oil;
        this.speed = speed;
    }



    public void setOil(int oil) {
        this.oil = oil;
    }

    @Override // 속도변경
    public void changeSpeed(int speed) {
        if(this.speed+speed <= 0){
            System.out.println("속도를 올려주세요");
            currentSpeed();
        }else if(this.speed+speed >=200){
            System.out.println("속도는 200을 넘을 수 없습니다.");
            currentSpeed();
        }else{
            this.speed += speed;
            currentSpeed();
        }
    }
    protected void currentSpeed() {
        System.out.println("현재속도는 " + speed + " 입니다.");
    }
}
