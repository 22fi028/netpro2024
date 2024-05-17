public class DinnerFullCource {

    Dish dish1;
    Dish dish2;
    Dish dish3;
    Dish dish4;
    Dish dish5;

    public static void main(String[] args){

        DinnerFullCource fullcourse = new DinnerFullCource();
		fullcourse.eatAll();

    }

    public DinnerFullCource(){
        dish1 = new Dish();
        dish1.setName("お米");
        dish1.setValune(10);

        dish2 = new Dish();
        dish2.setName("味噌汁");
        dish2.setValune(7);

        dish3 = new Dish();
        dish3.setName("納豆");
        dish3.setValune(3);

        dish4 = new Dish();
        dish4.setName("牛乳");
        dish4.setValune(5);

        dish5 = new Dish();
        dish5.setName("シーザーサラダ");
        dish5.setValune(4);
    }
    public void eatAll(){
        Dish[] fullcource= new Dish[]{dish1, dish2, dish3, dish4, dish5};
        String str = "";
        for(Dish d : fullcource){
            str += d.getName() + "=" + d.getValune() + ",\n";
        }
        System.out.println("たかしへ、ママです。今日の晩御飯は\n" + str + "よ。");
    }
}
