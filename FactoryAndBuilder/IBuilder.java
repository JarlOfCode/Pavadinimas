package FactoryAndBuilder;

//import EnemyFactory.java;

public abstract class IBuilder {
	
	protected ContinuedEnemy CE;
	
	public ContinuedEnemy build(){
		return CE;
	}
		

	public IBuilder addBase(){
		CE.setConfiguration(CE.getConfiguration() + " / Base");
		return this;
		// configurator.add(+ / "base")
	}
	
	public void reset() {
		CE = new ContinuedEnemy();
	}
	
	public abstract IBuilder addArmor();
	
}
