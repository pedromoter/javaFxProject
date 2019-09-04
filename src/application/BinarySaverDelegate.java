package application;

public interface BinarySaverDelegate {
	public void BinarySaverDidStart(String d);
	public void BinarySaverDidComplete();
	public void BinarySaverDidError(Exception e);

}
