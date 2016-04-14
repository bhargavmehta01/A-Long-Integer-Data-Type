public class SLLSimpleList implements SimpleList<SLLNode> {

	private SLLNode head;
	private SLLNode tail;
	boolean isFirst,isLast = false;
	private SLLNode temp;


	public SLLSimpleList() {
		head=null;
		tail=null;
	}

	public void insertFirst(int value) {
		if(this.isEmpty())
		{
			head = new SLLNode(value);
			tail = head;
		}
		else
		{
			SLLNode node = new SLLNode(value);
			node.setNext(head);
			head = node;
		}
	}

	public void insertLast(int value) {
		if(this.isEmpty())
		{
			tail = new SLLNode(value);
			head = tail;
		}
		else
		{
			SLLNode node = new SLLNode(value);
			tail.setNext(node);
			tail = node;
		}

	}

	public SLLNode first() {
		return head;
	}

	public SLLNode last() {
		return tail;
	}

	public boolean isFirst(SLLNode p) {
		if(head==p)
			isFirst=true;
		return isFirst;
	}

	public boolean isLast(SLLNode p) {
		if(tail==p)
			isLast=true;
		return isLast;
	}

	public SLLNode before(SLLNode p) 
	{
		temp=head;
		while(temp.getNext()!=p)
		{
			temp=temp.getNext();
		}
		return temp;
	}

	public SLLNode after(SLLNode p) {
		return p.getNext();
	}

	public boolean isEmpty() 
	{
		if(head==null)
			return true;
		else
			return false;
	}

	public int size() 
	{
		int j=0;
		temp=head;
		while(temp.getNext() != null)
		{
			temp=temp.getNext();
			j=j+1;
		}
		return j+1;
	}

}
