package Memento;

import FlyweightAndState.State;

public class Originator {

	State state;
	
	public void restoreState(Memento memento){
		
		//this.state = restoreState.getState();
		
		memento.getState(this);
		System.out.println("restore state: " + this.getState());
	}
	
	public Originator(State newState){
		System.out.println("Org created: " + newState);
		state = newState;
	}
	
	public State getState(){
		return state;
	}
	
	public void setState(State newState){
		System.out.println("set state: " + newState);
		state = newState;
	}
	
	public Memento saveState(){
		System.out.println("saved state: " + state);
		return new Memento(state);
	}
	

	
	
}
