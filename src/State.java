import com.sun.org.apache.regexp.internal.RE;

abstract class State {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public void low(Player wrapper) { }
    public void high(Player wrapper) { }
}

class Starting extends State {
    public void low(Player wrapper) {
        wrapper.setState(new LowBalance());
        System.out.println(RED + "--- Oops, your nutrition balance is now low, meals left to recharge " + Integer.toString(2) + "---\n" + RESET);
    }

    public void high(Player wrapper) {
        wrapper.setState(new Starting());
        System.out.println(GREEN + "--- Way to go, your nutrition balance is now high ---\n" + RESET);
    }
}

class LowBalance extends State {
    private int steps = 0;

    public void low(Player wrapper) {
        if (steps++ < 2) {
            System.out.println(RED + "--- Still low balance, meals left to recharge " + Integer.toString(2 - steps) + "---\n" + RESET);
            return;
        }
        wrapper.setState(new Eliminated());
        System.out.println(RED + "--- You are now eliminated from the game ---\n" + RESET);
    }

    public void high(Player wrapper) {
        wrapper.setState(new HighBalance());
        System.out.println(GREEN + "--- Way to go, your nutrition balance is now high ---\n" + RESET);
    }
}

class HighBalance extends State {
    public void low(Player wrapper) {
        wrapper.setState(new LowBalance());
        System.out.println(RED + "--- Oops, your nutrition balance is now low, meals left to recharge " + Integer.toString(2) + "---\n" + RESET);
    }

    public void high(Player wrapper) {
        wrapper.setState(new Winner());
        System.out.println(GREEN + "--- You have won the food fight! ---\n" + RESET);
    }
}

class Eliminated extends State {
//    public void left(Player wrapper) {
//        System.out.println(RED + "--- You are now eliminated from the game ---\n" + RESET);
//    }
//
//    public void right(Player wrapper) {
//        System.out.println(RED + "--- You are now eliminated from the game ---\n" + RESET);
//    }
}

class Winner extends State {
//    public void left(Player wrapper) {
//        System.out.println(GREEN + "--- You have won the food fight! ---\n" + RESET);
//    }
//
//    public void right(Player wrapper) {
//        System.out.println(GREEN + "--- You have won the food fight! ---\n" + RESET);
//    }
}




