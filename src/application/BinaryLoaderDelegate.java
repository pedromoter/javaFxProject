package application;

public interface BinaryLoaderDelegate {
	public void BinaryLoaderDelegateDidStart(String data);
	public void BinaryLoaderDelegateDidComplete(String result, binaryRepresentation data);
	public void BinaryLoaderDelegateDidError(Exception e);
}
