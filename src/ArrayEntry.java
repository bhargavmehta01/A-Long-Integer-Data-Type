public class ArrayEntry extends Position {

	// This entry's index within the array.
    private int index;
	
    public ArrayEntry(int value, int index) {
        super(value);
		
		this.index = index;
    }
	
  //  ArrayEntry[] arr = new ArrayEntry[1000];
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
}
