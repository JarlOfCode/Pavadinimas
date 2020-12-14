package Memento;

import FlyweightAndState.State;

public class Memento {

	State state;

	public void getState(Originator org) {
		org.setState(this.state);
	}
	
	public Memento(State newState){
		state = newState;
	}
	
	public State getState(){
		return state;
	}
	
	
	
}
