package FactoryAndBuilder;

public class ContinuedEnemyBuilder extends IBuilder{
	public IBuilder addBoots(){
		CE.setConfiguration(CE.getConfiguration() + " / boots");
		CE.speed = CE.speed * 1.50;
		return this;
	}
}
