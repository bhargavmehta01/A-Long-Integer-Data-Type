public class UtilityOperations {

	public static int overflow(int t) {
		int overdgt=0;
		if(t/10000>0)
		{
			overdgt=t/10000;
			return overdgt;
		}
		else
			return overdgt;
	}

	public static int underflow(int t) {
		int underdgt=t;
		if(t/10000>0)
		{
			underdgt=t%10000;
			return underdgt;
		}
		else
			return underdgt;

	}

	public static int digits(int t) {
		int dgts=0;
		while(t>0)
		{
			dgts=dgts+1;
			t=t/10;
		}
		return dgts;
	}

}
