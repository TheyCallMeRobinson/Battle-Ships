package oop.kurs2.redundant;

import oop.kurs2.units.State;

public class Cell { // просто обертка для State
    private State state = State.Free;

    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
}
