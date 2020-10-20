package edu.ktu.signalrclient;

//import EnemyFactory.java;

public abstract class IBuilder {
	
	ContinuedEnemy CE;
	
	public ContinuedEnemy build(){
		return CE;
	}
		

	public IBuilder addBase(){
		CE.setConfiguration(CE.getConfiguration() + " / Base");
		return this;
		// configurator.add(+ / "base")
	}
	
	public abstract IBuilder addBoots();
	
}
