package TemplateMethodAndIterator;

import java.util.ArrayList;
import java.util.List;

import FactoryAndBuilder.Enemy;

public class EnemyRepository implements Container {
	
	public List<Enemy> e = new ArrayList<Enemy>();
	
	public void addEnemy(Enemy en) {
		this.e.add(en);
	}
	
	public void removeEnemy(int index) {
		this.e.remove(index);
	}

	@Override
	public IIterator getIterator() {
		return new EnemyIterator();
	}
	
	private class EnemyIterator implements IIterator{

		int index = 0;
		
		@Override
		public boolean hasNext() {
			
			if(index < e.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if(this.hasNext()) {
				return e.get(index++);
			}
			return null;
		}
		
	}
	
}
