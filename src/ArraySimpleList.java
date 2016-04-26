public class ArraySimpleList implements SimpleList<ArrayEntry> {
		
	// # of positions in the list
	private int n = 0,count=0;
	
	// Current size of array
	private int arraySize = 1;
	boolean isFirst,isLast=false;
	ArrayEntry[] entrylist;
	
    public ArraySimpleList() {
    	entrylist = new ArrayEntry[arraySize];
    }

    public void insertFirst(int value) {
    	count=n;
    	while(count>0)
    	{
    		entrylist[count] = entrylist[count-1];
    		entrylist[count].setIndex(count);
    		count--;
    	}	
    	entrylist[0] = new ArrayEntry(value,0);
        n++;
        if(n/arraySize > 0.80)
        {
        	arraySize=arraySize*2;
        	ArrayEntry[] arr1 = new ArrayEntry[arraySize];
        	System.arraycopy(entrylist, 0, arr1, 0, entrylist.length);
        	entrylist=arr1;
        }
    }
    
    public void insertLast(int value) {
    	
    	entrylist[n] = new ArrayEntry(value, n);
        
        n++;
        if(n/arraySize > 0.80)
    	{
    		arraySize=arraySize*2;
        	ArrayEntry[] arr1 = new ArrayEntry[arraySize];
        	System.arraycopy(entrylist, 0, arr1, 0, entrylist.length);
        	entrylist=arr1;
    	}
    }
    
    public ArrayEntry first() {
		return entrylist[0];
    }

    public ArrayEntry last() {
    	return entrylist[n-1];
    }

    public boolean isFirst(ArrayEntry p) {
        if(entrylist[0]==p)
        	isFirst=true;
       return isFirst;
    }

    public boolean isLast(ArrayEntry p) {
        if(entrylist[n-1]==p)
        	isLast=true;
        return isLast;
    }

    public ArrayEntry before(ArrayEntry p) {
    	if(p.getIndex()==0)
    		return null;
    	else
    		return entrylist[p.getIndex()-1];
    }

    public ArrayEntry after(ArrayEntry p) {
    	if(p.getIndex()==(n-1))
    		return null;
    	else
    		return entrylist[p.getIndex()+1];
    }

    public boolean isEmpty() {
        if(arraySize==1)
        	return true;
        else
        	return false;
    }

    public int size() {
        return n;
    }

}
