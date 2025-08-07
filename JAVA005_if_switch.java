import java.util.Scanner;

public class JAVA005_if_switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // if, if-else, if-else if-else
        System.out.println("\n--------------------");
        System.out.println("IF / IF-ELSE / IF-ELSE IF-ELSE");
        System.out.print("Enter a number: ");
        String numberStr = sc.nextLine();
        Boolean isNumber = true, hasFloatingPoint = false;
        Double number = 0d;
        Integer arg = 1;
        // check number with if else :)
        for (int i = 0; i < numberStr.length(); ++i) {
            char digit = numberStr.charAt(i);
            if (digit == '.') {
                if (hasFloatingPoint || i == 0) {
                    isNumber = false;
                    break;
                } else {
                    hasFloatingPoint = true;
                }
            } else if (digit < '0' || digit > '9') {
                isNumber = false;
                break;
            } else {
                if (hasFloatingPoint) {
                    arg *= 10; // arg*8 + arg*2
                    number = number + 1.0 * (digit - '0') / arg;
                } else {
                    number = number * 10 + (digit - '0');
                }
            }
        }
        // print the status
        if (isNumber) {
            System.out.print(">>> Your number is: ");
            if (hasFloatingPoint)
                System.out.println(number + " !");
            else
                System.out.println(number.longValue() + " !");
        } else {
            System.out.println(">>> Your input is not a number!");
        }

        // switch case
        System.out.println("\n--------------------");
        System.out.println("SWITCH CASE");
        Integer monthNumber = (int) (number.longValue() % 12);
        System.out.println(">>> monthNumber: " + monthNumber);
        String monthName;
        switch (monthNumber) {
            case 1:
                monthName = "January";
                break; // to exit the switch-case
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            default:
                monthName = "December";
                break;
        }

        System.out.print(">>> ");
        switch (monthNumber) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 0: // for 12
                System.out.println(monthName + " has 31 days!");
                break;
            case 2:
                System.out.println(monthName + " has 28 or 29 days!");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(monthName + " has 30 days!");
                break;
        }

        sc.close();
        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
