class Player {
    public State current;

    public Player() {
        current = new Starting();
    }

    public void setState(State state) {
        current = state;
    }

    public void low() {
        current.low(this);
    }

    public void high() {
        current.high(this);
    }
}