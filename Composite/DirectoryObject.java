package Composite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DirectoryObject extends FileSystemObject{

	public DirectoryObject(String newName) {
		super(newName);
		// TODO Auto-generated constructor stub
	}
	
	public void add(FileSystemObject item){
		this.children.add(item);
		item.setParent(this);
	}
	
	public void remove(FileSystemObject item){
		this.children.remove(item);
	}
	
	public Iterator getChildren(){
		return this.children.iterator();		
	}
	
	public void getDir(){
		Iterator iterator = getChildren();
		while( iterator.hasNext() ){
			FileSystemObject item = (FileSystemObject) iterator.next();
			item.getPath();
		}		
	}
	
	public void getTree(){
		Iterator iterator = getChildren();
		
		while(iterator.hasNext()){
			FileSystemObject item = (FileSystemObject) iterator.next();
			String str = item.getPath();
			
			if (item instanceof DirectoryObject) {
				DirectoryObject subdir = (DirectoryObject) item;
				subdir.getTree();
			}
			
		}
		//return paths;
	}

}
