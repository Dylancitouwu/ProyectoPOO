package Model;

import lib_genericP65v0.files;

public interface configurable {
	public final String path="src/acounts";
	public  files file=new files(path);
	
	public default int getValue() {
		return (int)(Math.random()*10);
	}
}
