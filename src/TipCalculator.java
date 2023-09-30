import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.Timer;

/*
this is a very bad idea but i love bad ideas
this will also take a while
these comments are mainly me documenting my descent into insanity but you are welcome to read along
(some are actually useful if you want to see how the code is organized so maybe read all of them..?)
enjoy dining at the krusty krab, where the pizza is the pizza for you and me (real quote)
*/

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        Timer t = new Timer();

        //appreciate how long this took because i refuse to ever do this again
        System.out.println("Welcome to the Krusty Krab!");
        System.out.println();

        //galley grubs menu right here (took forever to type)
        System.out.println("-----------GALLEY GRUBS-----------");
        System.out.println();
        System.out.println("KRABBY PATTY.................$1.25");
        System.out.println("DOUBLE KRABBY PATTY..........$2.00");
        System.out.println("TRIPLE KRABBY PATTY..........$3.00");
        System.out.println("KRABBY MEAL..................$3.50");
        System.out.println("DOUBLE KRABBY MEAL...........$3.75");
        System.out.println("TRIPLE KRABBY MEAL...........$4.00");
        System.out.println("SALTY SEA DOG................$1.25");
        System.out.println("FOOTLONG.....................$2.00");
        System.out.println("SAILOR'S SURPRISE............$3.00");
        System.out.println("GOLDEN LOAF..................$2.00");
        System.out.println("KRUSTY KRAB PIZZA...........$10.00");
        System.out.println();
        System.out.println("CORAL BITS S.................$1.00");
        System.out.println("CORAL BITS M.................$1.25");
        System.out.println("CORAL BITS L.................$1.50");
        System.out.println();
        System.out.println("KELP SHAKE...................$2.00");
        System.out.println("KELP RINGS...................$1.50");
        System.out.println();
        System.out.println("SEAFOAM SODA S...............$1.00");
        System.out.println("SEAFOAM SODA M...............$1.25");
        System.out.println("SEAFOAM SODA L...............$1.50");
        System.out.println();
        System.out.println("----------------------------------");

        //different variables for dialogue, ordered items, etc. (look at the variable names to see what they are)
        String order = "";

        int upperLimit = 3;

        List<String> items = new ArrayList<>();
        List<Integer> amounts = new ArrayList<>();
        List<String> dialogueSquidward = new ArrayList<>() {{
            add("Squidward: We don't have all day here, what else would you like to order?");
            add("Squidward: Alright, what's next? Or are you done?");
            add("Squidward: How can anyone even eat this food..? Alright, what's next?");
            add("Squidward: You might as well order the entire Krusty Krab... Next?"); //wow, rude
            add("Squidward: Please, don't order anything else, for my sake.");
        }};
        List<String> dialogueSpongebob = new ArrayList<>() {{
            add("Spongebob: Ooooorder up!");
            add("Spongebob: All done! Enjoy!");
            add("Spongebob: It helps having the best coworker ever to brighten the work day, right Squidward?"); //unique Squidward dialogue if this is printed
            add("Spongebob: Wow, a personal best for this amount of food! Man, I'm good!");
        }};

        //while loop goes here, pray that it works for my sanity
        while (order.toLowerCase() != ("done")) {
            if (items.size() > 10) {
                upperLimit += 2;
            }
            int quote = r.nextInt(upperLimit);
            if (items.isEmpty()) {
                System.out.print("(Enter the first item you would like to order (please enter the name how it appears on the menu): ");
            } else {
                System.out.println(dialogueSquidward.get(quote));
                System.out.print("Enter 'done' to finish your order, or enter another item you want here: ");
            }
            order = scan.nextLine();
            if (order.toLowerCase().equals("krabby patty") || order.toLowerCase().equals("krabbypatty")) {
                items.add("Krabby Patty");
            } else if (order.toLowerCase().equals("double krabby patty") || order.toLowerCase().equals("doublekrabbypatty")) {
                items.add("Double Krabby Patty");
            }
        }
    }
}