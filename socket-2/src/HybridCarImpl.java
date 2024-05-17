public class HybridCarImpl implements ICar, IElectricCharge, INavigation {
    int b = 50;
    int sp = 5;
    String distination = "";

    public static void main(String[] args) {
        HybridCarImpl masaCar = new HybridCarImpl();

        ICar car = (ICar) masaCar;
        car.setSpeed(60);
        car.printCarName();

        IElectricCharge charger = (IElectricCharge) masaCar;
        charger.chargeBattery(100);

        INavigation inavi = (INavigation)masaCar;
        inavi.setDistination("北海道");
        inavi.printRoute();

    }

    @Override
    public void chargeBattery(int b) {
        this.b = b;

    }

    @Override
    public int getAllBattery() {

        return b;
    }

    @Override
    public int consumeBattery(int b) {
        this.b -= b;
        return this.b;
    }

    @Override
    public void setSpeed(int sp) {
        this.sp = sp;

    }

    @Override
    public int getSpeed() {
        // TODO Auto-generated method stub
        return sp;
    }

    @Override
    public void printCarName() {
        System.out.println("masacar");

    }

    @Override
    public void setDistination(String d) {
        System.out.println("目的地を" + d + "に設定しました。");
    }

    @Override
    public void printRoute() {
        System.out.println("100km道なりです。");
    }

}