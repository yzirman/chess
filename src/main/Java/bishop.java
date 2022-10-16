class bishop implements piece {
    bishop(boolean col, int pos) {
        setColor(col);
        setPosition(pos);
    }
    boolean white;
    int worth = 3;
    int pos;
    @Override
    public void setColor(boolean col) {
        this.white = col;
    }
    @Override
    public boolean getColor() {
        return this.white;
    }
    @Override
    public int getWorth() {
        return this.worth;
    }

    @Override
    public void setPosition(int pos) {
        //a two digit number, both between 0 and 7 representing its location on the board
        this.pos = pos;
    }

    @Override
    public int getPosition() {
        return this.pos;
    }
}
