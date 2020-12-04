package CompositeAndMediator;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ktu.signalrclient.main;



public abstract class FileSystemObject {

	private String name;
	protected FileSystemObject parent = null;
	protected ArrayList children;
	public static List<File> imageFiles = new ArrayList<File>();
	
	public FileSystemObject(String newName) {
		name = newName;
		children = new ArrayList();
	}

	public final String getPath(){
		//throw new UnsupportedOperationException();
		FileSystemObject item = this;
		String path = "";
		while(item.getParent() != null){
			path = item.getParent().getName() + "/" + path;
			item = item.getParent();
		}
		if(path.isEmpty()){
			path = "../";
		}
		path += name;
		
		if(path.endsWith(".png")) { 
			File f = new File(path);
			imageFiles.add(f);	
		}
		
		return path;
		
	}
	
	public List<File> getImageFiles(){
		return imageFiles;
	}
	
	public void getDir(){
		throw new UnsupportedOperationException();
	}
	
	public void getTree(){
		throw new UnsupportedOperationException();
	}
	public String getName(){
		return name;
	}
	
	public void setParent(FileSystemObject newParent){
		parent = newParent;
	}
	
	public FileSystemObject getParent(){
		return parent;
	}
	
	public Iterator getChildren(){
		throw new UnsupportedOperationException();
	}
	
	public void remove(FileSystemObject newObject){
		throw new UnsupportedOperationException();
	}

	public void add(FileSystemObject newObject){
		throw new UnsupportedOperationException();
	}

	
}
