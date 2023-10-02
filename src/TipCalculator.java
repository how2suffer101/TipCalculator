import java.text.DecimalFormat;
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
        DecimalFormat df = new DecimalFormat("##.00");

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
        System.out.println();

        //different variables for dialogue, ordered items, etc. (look at the variable names to see what they are)
        String order = "start";
        int amt;
        boolean validOrder = false;
        boolean luckyTax = false;
        double krabsTax = 0;

        int upperLimit = 3;

        List<String> items = new ArrayList<>();
        List<Integer> amounts = new ArrayList<>();
        List<Double> costs = new ArrayList<>();
        List<String> dialogueSquidward = new ArrayList<>() {{
            add("Squidward: We don't have all day here, what else would you like to order?");
            add("Squidward: Alright, what's next? Or are you done?");
            add("Squidward: How can anyone even eat this food, it's repulsive!");
            add("Squidward: You might as well order the entire Krusty Krab, Patrick would appreciate that."); //wow, rude
            add("Squidward: Please, don't order anything else, for my sake."); //average fast food worker
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
            int quoteSquidward = r.nextInt(upperLimit);
            if (items.isEmpty()) {
                System.out.print("(Enter the first item you would like to order, either how it appears on the menu or with no spaces): ");
                order = scan.nextLine();
            } else {
                System.out.println(dialogueSquidward.get(quoteSquidward));
                System.out.print("(Enter 'done' to finish your order, or enter another item you want here): ");
                order = scan.nextLine();
            }
            //the great wall of if statements, this is going to take forever to type out
            if (!Objects.equals(order, "")) {
                if (order.equalsIgnoreCase("krabby patty") || order.equalsIgnoreCase("krabbypatty")) {
                    items.add("Krabby Patty");
                    costs.add(1.25);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("double krabby patty") || order.equalsIgnoreCase("doublekrabbypatty")) {
                    items.add("Double Krabby Patty");
                    costs.add(2.00);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("triple krabby patty") || order.equalsIgnoreCase("triplekrabbypatty")) {
                    items.add("Triple Krabby Patty");
                    costs.add(3.00);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("krabby meal") || order.equalsIgnoreCase("krabbymeal")) {
                    items.add("Krabby Meal");
                    costs.add(3.50);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("double krabby meal") || order.equalsIgnoreCase("doublekrabbymeal")) {
                    items.add("Double Krabby Meal");
                    costs.add(3.75);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("triple krabby meal") || order.equalsIgnoreCase("triplekrabbymeal")) {
                    items.add("Triple Krabby Meal");
                    costs.add(4.00);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("salty sea dog") || order.equalsIgnoreCase("saltyseadog")) {
                    items.add("Salty Sea Dog");
                    costs.add(1.25);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("footlong")) {
                    items.add("Footlong");
                    costs.add(2.00);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("sailors surprise") || order.equalsIgnoreCase("sailorssurprise")) {
                    items.add("Sailor's Surprise");
                    costs.add(3.00);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("golden loaf") || order.equalsIgnoreCase("goldenloaf")) {
                    items.add("Golden Loaf");
                    costs.add(2.00);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("krusty krab pizza") || order.equalsIgnoreCase("krustykrabpizza")) {
                    items.add("Krusty Krab Pizza");
                    costs.add(10.00);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("coral bits s") || order.equalsIgnoreCase("coralbitss")) { //i know that i can just make it an option to choose the size
                    items.add("Coral Bits (Small)");
                    costs.add(1.00);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("coral bits m") || order.equalsIgnoreCase("coralbitsm")) { //however,
                    items.add("Coral Bits (Medium)");
                    costs.add(1.25);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("coral bits l") || order.equalsIgnoreCase("coralbitsl")) { //im too lazy to implement that
                    items.add("Coral Bits (Large)");
                    costs.add(1.50);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("seafoam soda s") || order.equalsIgnoreCase("seafoamsodas")) { //soooooooooooooo,
                    items.add("Seafoam Soda (Small)");
                    costs.add(1.00);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("seafoam soda m") || order.equalsIgnoreCase("seafoamsodam")) { //sadly, (not really)
                    items.add("Seafoam Soda (Medium)");
                    costs.add(1.25);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("seafoam soda l") || order.equalsIgnoreCase("seafoamsodal")) { //you have to deal with it (my bad) (haha)
                    items.add("Seafoam Soda (Large)");
                    costs.add(1.50);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("kelp rings") || order.equalsIgnoreCase("kelprings")) {
                    items.add("Kelp Rings");
                    costs.add(1.50);
                    validOrder = true;
                } else if (order.equalsIgnoreCase("kelp shake") || order.equalsIgnoreCase("kelpshake")) {
                    items.add("Kelp Shake");
                    costs.add(2.00);
                    validOrder = true;
                }

                //testing
                if (validOrder) {
                    System.out.print("(Enter how many you would like here): ");
                    amt = scan.nextInt();
                    amounts.add(amt);
                    System.out.println();
                    validOrder = false;
                } else {
                    if (!order.equals("done")) {
                        System.out.println("Squidward: Please tell me what you want from the menu, or leave. Or just leave right now."); //this stupid line is giving me problems and i hate it
                    }
                }
            }
        } //the end of the while loop!
        System.out.println();
        System.out.println("Squidward: Alright, how many people do you have with you? This hunk of junk can't handle over 50 anyways");
        System.out.print("(Enter how many people will be eating, if the amount is above 50 then an additional tax is added): ");
        int people = scan.nextInt();
        double taxPeople = 0;
        if (people > 50) {
            taxPeople = 10;
            taxPeople += (double) ((people - 50) / 5) / 100;
        }
        System.out.println();
        System.out.println("Squidward: Great, what would you like to tip? For having to deal with you, I feel like I deserve at least 20%..."); //also average fast food worker
        System.out.print("(Enter the tip here, any whole number that is 0 or greater): ");
        double tip = (double) scan.nextInt() / 100;
        System.out.println();
        System.out.println("Squidward: Alright Spongebob, here's the order. Don't mess it up!"); //squidward is the worst coworker, prove me wrong
        System.out.println("Sponegbob: On it!"); //spongebob is literally him
        System.out.println();

        upperLimit = 3;
        if (items.size() < 5) { //try & catch method is something that i had to look up but it works so it stays
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if (items.size() > 5) {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            upperLimit++;
        }
        int quoteSpongebob = r.nextInt(upperLimit);
        System.out.println(dialogueSpongebob.get(quoteSpongebob));
        if (quoteSpongebob == 3) {
            System.out.println("Squidward: Whatever you say, sponge."); //reason #9001 why squidward is a bad coworker
        }
        upperLimit = 20;
        if (r.nextInt(upperLimit) == 13) {
            System.out.println("Mr. Krabs: Hey! It seems you are our 'lucky' customer! You get to pay a discounted price of 200% of what you were going to pay!"); //average crab
            System.out.println("Squidward: Hehe, sucker."); //#9002
            krabsTax = 2.0;
            luckyTax = true;
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("-------------RECEIPT--------------");
        System.out.println();
        for (int i = 0; i < items.size(); i++) {
            System.out.println(amounts.get(i) + "x " + items.get(i) + ": $" + df.format((amounts.get(i) * costs.get(i))));
        }
        System.out.println();
        System.out.println("------TOTAL, TIPS, and TAXES------");
        System.out.println();
        double total = 0;
        for (int j = 0; j < amounts.size(); j++) {
            total += (amounts.get(j) * costs.get(j));
        }
        System.out.println("Total (Before tips + taxes): $" + df.format(total));
        if (people > 50) {
            System.out.println("Over-Capacity TAX: " + (taxPeople * 100) + "%");
        }
        if (luckyTax) {
            System.out.println("Krabs' TAX: " + (krabsTax * 100) + "%");
        }
        System.out.println("Tip: " + (tip * 100) + "%");
        System.out.println();
        double fullTotal = (total * taxPeople) + (total * tip) + total;
        System.out.println("Full Total: $" + df.format(fullTotal));
        System.out.println("Cost per Person: $" + df.format((fullTotal / people)));
        System.out.println();
        System.out.println("----------------------------------");

        System.out.println();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (fullTotal > 1000) { //if only i was this rich
            System.out.println("Squidward: Ehehehe, this certainly is going to break someone's bank! Maybe you shouldn't have eyes as big as your stomac- huh?!");
            System.out.println("Spongebob: Wow, that's a lot of money! It's even more than Mr. Krabs pays me!"); //krabs doesn't pay you at all
            System.out.println("Squidward: ...Sponge, Krabs doesn't pay us at all."); //told you
            System.out.println("Spongebob: Oh... I forgot because of how much fun I have working here!"); //impossible
            System.out.println("Mr. Krabs: Oh boy! Seems like we got a brand new VIP customer, mateys! Spongeboy, make sure you fix up this fine fish's food first next time they come!");
            System.out.println("Spongebob: Aye-aye, sir!");
            System.out.println("Squidward: That doesn't seem very fai- oh, why do I even try.");
        }
    }
}
/* it's finally over
i loved and hated every second of this
i blame past me for making present me (which is now also past me technically) go through all of this
this was not beneficial to my sanity whatsoever
credit to johnathan (or was it justin?) for giving me this idea */