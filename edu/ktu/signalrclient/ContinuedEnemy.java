package edu.ktu.signalrclient;

public class ContinuedEnemy implements Enemy {

	double speed = 5;	
	
	protected String configuration = "Empty String";
	
	public String getConfiguration() {
		return configuration;
	}
	
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	
	@Override
	public void Spawn() {
		////GetEnemy method should be implemented
		main.chatBox.append("\nContinuedEnemy Spawned");
		System.out.println("ContinuedEnemy Spawned");
		System.out.println("Stats: " + configuration);
		main.drawEnemy("continued");
		
	}
	
	@Override
	public String getEnemy(){
		return "continued";
	}
}
