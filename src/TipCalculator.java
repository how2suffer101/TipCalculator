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
        System.out.println("SAILORS SURPRISE.............$3.00");
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
        List<String> dialogueSquidward = new ArrayList<>() {{ //average brooklyn tech student
            add("Squidward: We don't have all day here, what else would you like to order?");
            add("Squidward: Alright, what's next? Or are you done?");
            add("Squidward: How can anyone even eat this food..? Alright, what's next?");
            add("Squidward: You might as well order the entire Krusty Krab... Next?"); //wow, rude
            add("Squidward: Please, don't order anything else, for my sake.");
        }};
        List<String> dialogueSpongebob = new ArrayList<>() {{ // *insert Spongebob laugh track here*
            add("Spongebob: Ooooorder up!"); //literally so iconic that i couldn't not include this
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
                System.out.print("(Enter the first item you would like to order, either how it appears on the menu or with no spaces): ");
            } else {
                System.out.println(dialogueSquidward.get(quote));
                System.out.print("Enter 'done' to finish your order, or enter another item you want here: ");
            }
            order = scan.nextLine();
            //the great wall of if statements, this is going to take forever to type out
            if (order.toLowerCase().equals("krabby patty") || order.toLowerCase().equals("krabbypatty")) {
                items.add("Krabby Patty");
            } else if (order.toLowerCase().equals("double krabby patty") || order.toLowerCase().equals("doublekrabbypatty")) {
                items.add("Double Krabby Patty");
            } else if (order.toLowerCase().equals("triple krabby patty") || order.toLowerCase().equals("triplekrabbypatty")) {
                items.add("Triple Krabby Patty");
            } else if (order.toLowerCase().equals("krabby meal") || order.toLowerCase().equals("krabbymeal")) {
                items.add("Krabby Meal");
            } else if (order.toLowerCase().equals("double krabby meal") || order.toLowerCase().equals("doublekrabbymeal")) {
                items.add("Double Krabby Meal");
            } else if (order.toLowerCase().equals("triple krabby meal") || order.toLowerCase().equals("triplekrabbymeal")) {
                items.add("Triple Krabby Meal");
            } else if (order.toLowerCase().equals("salty sea dog") || order.toLowerCase().equals("saltyseadog")) { //line 100!!! #ihatemyself
                items.add("Salty Sea Dog");
            } else if (order.toLowerCase().equals("footlong")) {
                items.add("Footlong");
            } else if (order.toLowerCase().equals("sailors surprise") || order.toLowerCase().equals("sailorssurprise")) {
                items.add("Sailor's Surprise");
            } else if (order.toLowerCase().equals("golden loaf") || order.toLowerCase().equals("goldenloaf")) {
                items.add("Golden Loaf");
            } else if (order.toLowerCase().equals("krusty krab pizza") || order.toLowerCase().equals("krustykrabpizza")) {
                items.add("Krusty Krab Pizza");
            } else if (order.toLowerCase().equals("coral bits s") || order.toLowerCase().equals("coralbitss")) { //i know that i can just make it an option to choose the size
                items.add("Coral Bits (Small)");
            } else if (order.toLowerCase().equals("coral bits m") || order.toLowerCase().equals("coralbitsm")) { //however,
                items.add("Coral Bits (Medium)");
            } else if (order.toLowerCase().equals("coral bits l") || order.toLowerCase().equals("coralbitsl")) { //im too lazy to implement that
                items.add("Coral Bits (Large)");
            } else if (order.toLowerCase().equals("seafoam soda s") || order.toLowerCase().equals("seafoamsodas")) { //soooooooooooooo,
                items.add("Seafoam Soda (Small)");
            } else if (order.toLowerCase().equals("seafoam soda m") || order.toLowerCase().equals("seafoamsodam")) { //sadly, (not really)
                items.add("Seafoam Soda (Medium)");
            } else if (order.toLowerCase().equals("seafoam soda l") || order.toLowerCase().equals("seafoamsodal")) { //you have to deal with it (my bad) (haha)
                items.add("Seafoam Soda (Large)");
            } else if (order.toLowerCase().equals("kelp rings") || order.toLowerCase().equals("kelprings")) {
                items.add("Kelp Rings");
            } else if (order.toLowerCase().equals("kelp shake") || order.toLowerCase().equals("kelpshake")) {
                items.add("Kelp Shake");
            }
        }
    }
}