package Memento;

import FlyweightAndState.State;

public class Originator {

	State state;
	
	public State restoreState(Memento memento){
		
		//this.state = restoreState.getState();
		
		memento.getState(this);
		return this.getState();
	}
	
	public Originator(State newState){
		state = newState;
	}
	
	public State getState(){
		return state;
	}
	
	public void setState(State newState){
		state = newState;
	}
	
	public Memento saveState(){
		return new Memento(state);
	}
	

	
	
}
