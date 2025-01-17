import java.util.Scanner;
/**
 * 
 */
public class TextGUI
{
    int option = 1;
    Scanner scan = new Scanner(System.in);
    Calendar test = new Calendar();
    
    public TextGUI()
    {
        
        run();
    }

    /**
     * 
     */
    public void run()
    {
        while (option != 0){
            print();
            System.out.println("--------------------------------------------------------------------\nOPTIONS: \n1: Shift back a Week\n2: Shift Forward a week\n3: Select a specific Date\n4: Create a Meal\n\n5: Update Calorie Max\n6: Remove Meal\n7: Move back a Month\n8: Move forward a Month");
            option = scan.nextInt();
            if(option == 1){
                test.moveUpWeek();
            } else if(option == 2){
                test.moveDownWeek();
            } else if(option == 3){
                // point to specific date
                int month;
                int day;
                //Theoreticaly, the GUI would be incapable of entering a date OUT OF BOUNDs. I'm not checking for that here, Please keep it in bounds
                //ALSO this intakes the actual day you want. 1 == January ... 0 != January
                System.out.println("Please enter the Month (INT 1 to 12)");
                month = scan.nextInt();
                System.out.println("Please enter the Day (INT, MAKE SURE IT'S NOT OUT OF BOUND)");
                day = scan.nextInt();
                test.movePoint(month, day);
            } else if(option == 4){
                //insert meal at pointer
                String meal;
                int cal;
                int opt;
                double time;
                scan.nextLine();
                System.out.println("Please enter the Meal (STRING)");
                meal = scan.nextLine();
                System.out.println("Please enter the calories of this meal (INT)");
                cal = scan.nextInt();
                System.out.println("Please enter the daily meal this meal represents (INT, 0 = bearkfast, 1 = Lunch, 2 = Dinner, 3 = Snack)");
                opt = scan.nextInt();
                System.out.println("Please enter the time of Day this meal will be consumed (DOUBLE, Hour:Minuets)");
                time = scan.nextDouble();
                test.addMeal(time, meal, cal, opt);
            } else if(option == 5){
                // Update calories
                int cal;
                System.out.println("Please enter the new maximum calories  (INT)");
                cal = scan.nextInt();
                test.updateCals(cal);
            } else if(option == 6){
                //remove meal
                int opt;
                System.out.println("Please enter the daily meal that you wish to remove. (INT, 0 = bearkfast, 1 = Lunch, 2 = Dinner, 3 = Snack, options after 3 delete other listed snacks)");
                opt = scan.nextInt();
                test.removeMeal(opt);
            } else if(option == 7){
                //move back month
                test.moveDownMonth();
            } else if(option == 8){
                //move up month
                test.moveUpMonth();
            } 
            
        }
    }
    
    public void print(){
        String[] printOut = test.printWeek();
        for (int i = 0; i < printOut.length; i++){
            System.out.println(printOut[i]);
        }
    }
}
