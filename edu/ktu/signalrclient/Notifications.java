package edu.ktu.signalrclient;

import java.util.Observable;
import java.util.Observer;
//import io.reactivex.Observer;

public class Notifications implements Observer {
	private String noti;
	
	@Override
	public void update(Observable o, Object noti) {
        this.setNoti((String) noti);
    }
}
