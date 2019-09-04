package application;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class binarySaver implements Runnable {
	private BinarySaverDelegate delegate;
	private binaryRepresentation data;
	
	public binarySaver(BinarySaverDelegate delegate, binaryRepresentation data) {
		super();
		this.delegate = delegate;
		this.data = data;
	}

	@Override
	public void run() {
		this.delegate.BinarySaverDidStart("Did Start");
		try {
			  FileOutputStream fos = new FileOutputStream("data.bin");
			    ObjectOutputStream oos = new ObjectOutputStream(fos);
			    oos.writeObject(data);
			    oos.close();
			    
		}catch (IOException e) {
		    e.printStackTrace();
		    this.delegate.BinarySaverDidError(e);
		}
	this.delegate.BinarySaverDidComplete();
	}


	

}
