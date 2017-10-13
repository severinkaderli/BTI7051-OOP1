import java.util.Scanner;

public class TimeTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        // Get the first time
        System.out.println("Please enter the hours for the first point in time:");
        hours = scanner.nextInt();
        System.out.println("Please enter the minutes for the first point in time:");
        minutes = scanner.nextInt();
        System.out.println("Please enter the seconds for the first point in time:");
        seconds = scanner.nextInt();
        Time firstTime = new Time(hours, minutes, seconds);

        // Get the second time
        System.out.println("Please enter the hours for the second point in time:");
        hours = scanner.nextInt();
        System.out.println("Please enter the minutes for the second point in time:");
        minutes = scanner.nextInt();
        System.out.println("Please enter the seconds for the second point in time:");
        seconds = scanner.nextInt();
        Time secondTime = new Time(hours, minutes, seconds);

        if(firstTime.equals(secondTime)) {
            System.out.println(firstTime);
        } else if (firstTime.before(secondTime)) {
            System.out.println(firstTime);
            System.out.println(secondTime);
        } else {
            System.out.println(secondTime);
            System.out.println(firstTime);
        }
    }
}
