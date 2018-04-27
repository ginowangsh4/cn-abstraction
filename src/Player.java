class Player {
    private State current;

    public Player() {
        current = new Starting();
    }

    public void setState(State state) {
        current = state;
    }

    public void left() {
        current.left(this);
    }

    public void right() {
        current.right(this);
    }
}