import java.util.*;
import java.util.concurrent.TimeUnit;

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
        String order = "start";
        int amt;
        boolean validOrder = false;

        int upperLimit = 3;

        List<String> items = new ArrayList<>();
        List<Integer> amounts = new ArrayList<>();
        List<String> dialogueSquidward = new ArrayList<>() {{ //average brooklyn tech student
            add("Squidward: We don't have all day here, what else would you like to order?");
            add("Squidward: Alright, what's next? Or are you done?");
            add("Squidward: How can anyone even eat this food, it's repulsive!");
            add("Squidward: You might as well order the entire Krusty Krab, Patrick would appreciate that."); //wow, rude
            add("Squidward: Please, don't order anything else, for my sake.");
        }};
        List<String> dialogueSpongebob = new ArrayList<>() {{ // *insert Spongebob laugh track here*
            add("Spongebob: Ooooorder up!"); //literally so iconic that i couldn't not include this
            add("Spongebob: All done! Enjoy!");
            add("Spongebob: It helps having the best coworker ever to brighten the work day, right Squidward?"); //unique Squidward dialogue if this is printed
            add("Spongebob: Wow, a personal best for this amount of food! Man, I'm good!");
        }};

        //while loop goes here, pray that it works for my sanity (update 1: it did not work and im going insane)
        while (!order.equalsIgnoreCase("done")) {
            if (items.size() > 5) {
                upperLimit += 2;
            }
            int quote = r.nextInt(upperLimit);
            if (items.isEmpty()) {
                System.out.print("(Enter the first item you would like to order, either how it appears on the menu or with no spaces): ");
                order = scan.nextLine();
            } else {
                System.out.println(dialogueSquidward.get(quote));
                System.out.print("(Enter 'done' to finish your order, or enter another item you want here): ");
                order = scan.nextLine();
            }
            //the great wall of if statements, this is going to take forever to type out
            if (!Objects.equals(order, "")) {
                if (order.equalsIgnoreCase("krabby patty") || order.equalsIgnoreCase("krabbypatty")) {
                    items.add("Krabby Patty");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("double krabby patty") || order.equalsIgnoreCase("doublekrabbypatty")) {
                    items.add("Double Krabby Patty");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("triple krabby patty") || order.equalsIgnoreCase("triplekrabbypatty")) {
                    items.add("Triple Krabby Patty");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("krabby meal") || order.equalsIgnoreCase("krabbymeal")) {
                    items.add("Krabby Meal");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("double krabby meal") || order.equalsIgnoreCase("doublekrabbymeal")) {
                    items.add("Double Krabby Meal");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("triple krabby meal") || order.equalsIgnoreCase("triplekrabbymeal")) {
                    items.add("Triple Krabby Meal");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("salty sea dog") || order.equalsIgnoreCase("saltyseadog")) { //line 100!!! #ihatemyself
                    items.add("Salty Sea Dog");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("footlong")) {
                    items.add("Footlong");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("sailors surprise") || order.equalsIgnoreCase("sailorssurprise")) {
                    items.add("Sailor's Surprise");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("golden loaf") || order.equalsIgnoreCase("goldenloaf")) {
                    items.add("Golden Loaf");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("krusty krab pizza") || order.equalsIgnoreCase("krustykrabpizza")) {
                    items.add("Krusty Krab Pizza");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("coral bits s") || order.equalsIgnoreCase("coralbitss")) { //i know that i can just make it an option to choose the size
                    items.add("Coral Bits (Small)");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("coral bits m") || order.equalsIgnoreCase("coralbitsm")) { //however,
                    items.add("Coral Bits (Medium)");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("coral bits l") || order.equalsIgnoreCase("coralbitsl")) { //im too lazy to implement that
                    items.add("Coral Bits (Large)");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("seafoam soda s") || order.equalsIgnoreCase("seafoamsodas")) { //soooooooooooooo,
                    items.add("Seafoam Soda (Small)");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("seafoam soda m") || order.equalsIgnoreCase("seafoamsodam")) { //sadly, (not really)
                    items.add("Seafoam Soda (Medium)");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("seafoam soda l") || order.equalsIgnoreCase("seafoamsodal")) { //you have to deal with it (my bad) (haha)
                    items.add("Seafoam Soda (Large)");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("kelp rings") || order.equalsIgnoreCase("kelprings")) {
                    items.add("Kelp Rings");
                    validOrder = true;
                } else if (order.equalsIgnoreCase("kelp shake") || order.equalsIgnoreCase("kelpshake")) {
                    items.add("Kelp Shake");
                    validOrder = true;
                }

                if (validOrder) {
                    System.out.print("(Enter how many you would like here): ");
                    amt = scan.nextInt();
                    amounts.add(amt);
                }
                validOrder = false;
            } //testing
            if (order.isEmpty()) {
                System.out.println("Squidward: Please tell me what you want from the menu, or leave. Or just leave right now.");
            }
        } //the end of the while loop!

        System.out.println("Squidward: Alright Spongebob, here's the order. Don't mess it up!");
        System.out.println("Sponegbob: On it!");
        if (items.size() < 5) {

        }
    }
}