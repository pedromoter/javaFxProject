package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class binaryLoader implements Runnable {
	private BinaryLoaderDelegate delegate;
	private binaryRepresentation data;
	
	public binaryLoader(binaryRepresentation data, BinaryLoaderDelegate delegate) {
		this.data = data;
		this.delegate = (BinaryLoaderDelegate)delegate;
	}

	@Override
	public void run() {
		this.delegate.BinaryLoaderDelegateDidStart("Did Start");
		
		try {
		  FileInputStream fis = new FileInputStream("data.bin");
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    binaryRepresentation studentsFromSavedFile = (binaryRepresentation) ois.readObject();
		    ois.close();
		    delegate.BinaryLoaderDelegateDidComplete("ok", studentsFromSavedFile);
		    
		}catch (FileNotFoundException e) {
		    delegate.BinaryLoaderDelegateDidError(e);
		}
		catch (IOException e) {
		    e.printStackTrace();
		    delegate.BinaryLoaderDelegateDidError(e);
		}
		catch (ClassNotFoundException e) {
		    e.printStackTrace();
		    delegate.BinaryLoaderDelegateDidError(e);
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		
	}
	

}
