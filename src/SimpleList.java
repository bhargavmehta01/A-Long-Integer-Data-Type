public interface SimpleList<P extends Position> {

	public void insertFirst(int value);
	public void insertLast(int value);

	public P first();
	public P last();

	public boolean isFirst(P p);
	public boolean isLast(P p);

	public P before(P p);
	public P after(P p);

	public boolean isEmpty();
	public int size();


}
