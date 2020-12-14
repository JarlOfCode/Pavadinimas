package Visitor;

import FactoryAndBuilder.ContinuedEnemy;
import Memento.Caretaker;
public interface Visitor {
	
	public String getInfo(ContinuedEnemy info);
	public String getInfo(Caretaker info);
	
}