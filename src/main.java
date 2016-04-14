import java.math.BigInteger;

public class main 
{

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
		LongInteger J = B.add(C);
		LongInteger K = C.add(D);
		LongInteger L = I.add(I);
		LongInteger M = A.add(I);
		LongInteger N = B.add(K);
		LongInteger O = A.subtract(D);
		LongInteger P = C.subtract(D);
		LongInteger Q = D.subtract(C);
		LongInteger R = L.subtract(L);
		LongInteger S = P.subtract(O);
		LongInteger T = N.subtract(Q);
		LongInteger U = A.multiply(D);
		LongInteger V = B.multiply(C);
		LongInteger W = D.multiply(D);
		LongInteger X = O.multiply(I);
		LongInteger Y = J.multiply(P);
		LongInteger Z = M.multiply(N);

		final LongInteger[] arr = {A , B , C , D , E , F , G , H , I};
		final LongInteger[] arr2 = {J , K , L , M , N , O , P , Q , R , S ,T , U , V , W , X , Y , Z};
		char alph[] = {'A','B','C','D','E','F','G','H','I'};
		
		char x,y;

		LongInteger z1,z2;

		System.out.println("Step 1 Test Cases:");
		for(int i=0; i<9; i++)
		{
			z1=arr[i];
			System.out.print(alph[i]+" = ");
			z1.output();
			System.out.println();
			System.out.print("Values at all positions : ");
			z1.testcase2();
			System.out.println();
			System.out.println("is Negative? : "+z1.getSign());
			System.out.println("No. of digits : "+z1.getDigitCount());
			System.out.println();
		}
		System.out.println();
		System.out.println("Comparisons : ");
		for(int i=0; i<9; i++)
		{
			z1=arr[i];
			x=alph[i];
			for(int j=0; j<9; j++)
			{
				z2=arr[j];
				y=alph[j];
				System.out.println(x+" equal to "+y+" : "+z1.equalTo(z2));
				System.out.println(x+" less than "+y+" : "+z1.lessThan(z2));
				System.out.println(x+" greater than "+y+" : "+z1.greaterThan(z2));
				System.out.println();
			}
		}
		
		int a=2222;
		int b=99999999;
		
		System.out.println("Overflow digits in a are "+UtilityOperations.overflow(a));
		System.out.println("Underflow digits in a are "+UtilityOperations.underflow(a));
		System.out.println("Number of digits in a are "+UtilityOperations.digits(a));

		System.out.println("Overflow digits in b are "+UtilityOperations.overflow(b));
		System.out.println("Underflow digits in b are "+UtilityOperations.underflow(b));
		System.out.println("Number of digits in b are "+UtilityOperations.digits(b));
		
		
		
		
		System.out.println("\n \n");
		System.out.println("Step 2 Test Cases:");
		System.out.println("1) Addition : ");
		for(int i=0; i<9; i++)
		{
			z1=arr[i];
			x=alph[i];
			for(int j=0; j<9; j++)
			{
				z2=arr[j];
				y=alph[j];
				System.out.print(x+" + "+y+" = ");
				z1.add(z2).output();
//				if(z1.add(z2).equalTo(z2.add(z1)))
//					System.out.println("\n true");
//				else
//					System.out.println("\n false");
				System.out.println("\n");
			}
		}
		System.out.println();
		System.out.println("2) Subtraction : ");
		for(int k=0; k<9; k++)
		{
			z1=arr[k];
			x=alph[k];
			for(int j=0; j<9; j++)
			{
				z2=arr[j];
				y=alph[j];
				
				System.out.print(x+" - "+y+" = ");
				z1.subtract(z2).output();
//				if(z1.subtract(z2).equalTo(z2.subtract(z1)))
//					System.out.println("\n true");
//				else
//					System.out.println("\n false");
				System.out.println("\n");
			}
		}
		
		

		System.out.println();
		System.out.println("3) Multiplication : ");
		for(int j=0; j<9; j++)
		{
			z1=arr[j];
			x=alph[j];
			for(int k=0; k<9; k++)
			{
				z2=arr[k];
				y=alph[k];
				
				System.out.print(x+" * "+y+" = ");
				z1.multiply(z2).output();
				System.out.println("\n");
				
			}
			
		}
		

		System.out.println();
		System.out.println("4) Power : ");
		for(int l=0; l<9; l++)
		{
			z1=arr[l];
			
			System.out.print(alph[l]+" ^ 5 = ");
			z1.power(5).output();
			System.out.println("\n");
			System.out.print(alph[l]+" ^ 10 = ");
			z1.power(10).output();
			System.out.println("\n");
			System.out.print(alph[l]+" ^ 20 = ");
			z1.power(20).output();
			System.out.println("\n");
			System.out.print(alph[l]+" ^ 30 = ");
			z1.power(30).output();
			System.out.println("\n");
		
		}
		
		System.out.println();
		System.out.println("5)");
		char val='J';
		for(int m=0; m<17; m++)
		{
			z1=arr2[m];
			System.out.print(val+" = ");
			z1.output();
			System.out.println();
			val++;
		}
		
//		System.out.println();
//		BigInteger e = new BigInteger("1423550000000010056810000054593452907711568359");
//		BigInteger r = new BigInteger("8436413168438618351351684694835434894364351846843435168484351684684315384684313846813153843135138413513843813513813138438435153454154515151513141592654543515316848613242587561516511233246174561276521672162416274123076527612");

		
	}
}
