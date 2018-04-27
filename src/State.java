abstract class State {
    public void left(Player wrapper) { }
    public void right(Player wrapper) { }
}

class Starting extends State {
    public void left(Player wrapper) {
        wrapper.setState(new LowBalance());
        System.out.println("--- Oops, your nutrition balance is now low ---");
    }

    public void right(Player wrapper) {
        wrapper.setState(new Starting());
        System.out.println("--- Way to go, your nutrition balance is now high ---");
    }
}

class LowBalance extends State {
    private int steps = 0;

    public void left(Player wrapper) {
        if (steps++ < 3) {
            System.out.println("--- Still low balance, meals left to recharge " + Integer.toString(3 - steps));
            return;
        }
        wrapper.setState(new Eliminated());
        System.out.println("--- You are now eliminated from the game ---");
    }

    public void right(Player wrapper) {
        wrapper.setState(new HighBalance());
        System.out.println( "--- Way to go, your nutrition balance is now high ---" );
    }
}

class HighBalance extends State {
    public void left(Player wrapper) {
        wrapper.setState(new LowBalance());
        System.out.println("--- Oops, your nutrition balance is now low ---");
    }

    public void right(Player wrapper) {
        wrapper.setState(new Winner());
        System.out.println( "--- Oops, your nutrition balance is now low --" );
    }
}

class Eliminated extends State {
    public void left(Player wrapper) {
        System.out.println("--- You are now eliminated from the game ---");
    }

    public void right(Player wrapper) {
        System.out.println( "--- You are now eliminated from the game ---" );
    }
}

class Winner extends State {
    public void left(Player wrapper) {
        System.out.println("You have won the food fight!");
    }

    public void right(Player wrapper) {
        System.out.println("You have won the food fight!");
    }
}




