import java.util.Scanner;

public class MyExceptionHoliday{
    public static void main(String[] args){
        try{
            while(true){
                holidayCheck();
            }
        }catch(NoHolidayException e){
            System.out.println(e);
        }
    }

    public static void holidayCheck() throws NoHolidayException{
        Scanner scan = new Scanner(System.in);
        int date = 0;
        System.out.println("5月の日付を入力してください");
        date = scan.nextInt();
        while(date <0 && date > 32){
            System.out.println("正しい日付を入力してください。");
            date = scan.nextInt();
        }

        if(date % 7 == 5 || date % 7 == 4 || date == 3 || date == 6){
            System.out.println("休日");
        }else{
            throw new NoHolidayException("NoHoliday");
        }

    }
}