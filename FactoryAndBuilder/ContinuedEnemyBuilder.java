package FactoryAndBuilder;

public class ContinuedEnemyBuilder extends IBuilder{
	public IBuilder addArmor(){
		CE.setConfiguration(CE.getConfiguration() + " / armor");
		CE.HP = CE.HP * 2;
		return this;
	}
}
