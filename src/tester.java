
public class tester 
{
	static int a = 2222;
	static int b = 99999999;

	public static void main(String[] args) {

		LongInteger A = new LongInteger("2222");
		LongInteger B = new LongInteger("99999999");
		LongInteger C = new LongInteger("-246813575732");
		LongInteger D = new LongInteger("180270361023456789");
		LongInteger E = new LongInteger("1423550000000010056810000054593452907711568359");
		LongInteger F = new LongInteger("-350003274594847454317890");
		LongInteger G = new LongInteger("29302390234702973402973420937420973420937420937234872349872934872893472893749287423847");
		LongInteger H = new LongInteger("-98534342983742987342987339234098230498203894209928374662342342342356723423423");
		LongInteger I = new LongInteger("8436413168438618351351684694835434894364351846843435168484351684684315384684313846813153843135138413513843813513813138438435153454154515151513141592654543515316848613242587561516511233246174561276521672162416274123076527612");

		final LongInteger[] arr = {A , B , C , D , E , F , G , H , I};
		char alph[] = {'A','B','C','D','E','F','G','H','I'};
		char x,y;
		//	final LongInteger[] arr1 = arr;

		LongInteger z1 = new LongInteger("11221111");
		LongInteger z2 = new LongInteger("11331111");
		LongInteger z3 = new LongInteger("11111122");
		LongInteger z4 = new LongInteger("11111133");
		LongInteger zc,zc1;

		System.out.println("Test case 1:");
		for(int i=0; i<9; i++)
		{
			zc=arr[i];
			System.out.print(alph[i]+" : ");
			zc.output();
			System.out.println();
			zc.testcase2();
			System.out.println();
			System.out.println("is Negative? : "+zc.getSign());
			System.out.println("No. of digits : "+zc.getDigitCount());
			System.out.println();
		}
		System.out.println();
		System.out.println("Comparisons : ");
		for(int i=0; i<9; i++)
		{
			zc=arr[i];
			x=alph[i];
			for(int j=0; j<9; j++)
			{
				zc1=arr[j];
				y=alph[j];
				System.out.print(x+" = ");
				zc.output();
				System.out.println();
				System.out.print(y+" = ");
				zc1.output();
				System.out.println();
				System.out.println(x+" equal to "+y+" : "+zc.equalTo(zc1));
				System.out.println(x+" less than "+y+" : "+zc.lessThan(zc1));
				System.out.println(x+" greater than "+y+" : "+zc.greaterThan(zc1));
				System.out.println();
			}
		}
		System.out.println("Overflow digits in a are "+UtilityOperations.overflow(a));
		System.out.println("Underflow digits in a are "+UtilityOperations.underflow(a));
		System.out.println("Number of digits in a are "+UtilityOperations.digits(a));

		System.out.println("Overflow digits in b are "+UtilityOperations.overflow(b));
		System.out.println("Underflow digits in b are "+UtilityOperations.underflow(b));
		System.out.println("Number of digits in b are "+UtilityOperations.digits(b));

		//		System.out.println("Sign is "+F.getSign());
		//		System.out.println("Digit count "+F.getDigitCount());

		//		System.out.println("Is it first? : "+F.checkisFirst());
		//		System.out.println("Is it last? : "+F.checkisLast());

		//		System.out.println("\n"+z2.equalTo(z1));
		//		System.out.println(z3.lessThan(z4));
		//		System.out.println(z3.greaterThan(z4));


	}

}
