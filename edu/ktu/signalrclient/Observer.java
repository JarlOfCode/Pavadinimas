package edu.ktu.signalrclient;

import java.io.IOException;

public interface Observer {
	void update() throws IOException;
}
