package Memento;
import java.util.*;

import Visitor.InfoGiver;
import Visitor.Visitor;


public class Caretaker implements InfoGiver {

	ArrayList<Memento> statesList;
	
	public Caretaker(){
		statesList = new ArrayList<Memento>();
	}
	
	public void add(Memento state){
		statesList.add(state);
	}
	
	public Memento get(int index){
		Memento restoreState = statesList.get(index);
		statesList.remove(index);
		return restoreState;
	}
	/*
	public Memento undo(){
		Memento restoreState = statesList.get(index);
		//statesList.remove(index);
		return restoreState;
	}
	
	public Memento redo(){
		Memento restoreState = statesList.get(index);
		statesList.remove(index);
		return restoreState;
	}
		*/
		
	
	public int size(){
		return statesList.size();
	}

	@Override
	public String getInfo(Visitor visitor) {
		return visitor.getInfo(this);
	}
	
	public ArrayList<Memento> getList(){
		return statesList;
	}
	
}
