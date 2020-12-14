package Visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import FactoryAndBuilder.ContinuedEnemy;
import FlyweightAndState.PlayingShootingState;
import Memento.Caretaker;

public class InfoVisitor implements Visitor {

	@Override
	public String getInfo(ContinuedEnemy info) {
		String str = info.getConfiguration();
		if(str.endsWith("Empty String")) {
			return "Standard ContinuedEnemy";
		}
		else {
			return "Armored ContinuedEnemy";
		}
	}

	@Override
	public String getInfo(Caretaker info) {
		String str = "The states that the player had gone through:\n";
		for(int i = 0; i < info.getList().size(); i++) {
			str += info.getList().get(i).getState().getClass().toString() + "\n";
		}
		
		return str;
	}
	
}
