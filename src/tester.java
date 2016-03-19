
public class tester 
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
		LongInteger Z = new LongInteger("-");
		LongInteger z1 = new LongInteger("11111112");
		LongInteger z2 = new LongInteger("-11111112");


		System.out.println(UtilityOperations.overflow(1248790));
		System.out.println(UtilityOperations.underflow(1248790));
		System.out.println(UtilityOperations.digits(1287908560));

		System.out.println("Sign is "+F.getSign());
		System.out.println("Digit count "+F.getDigitCount());

		System.out.println("Yes it is first "+F.checkisFirst());
		System.out.println("Yes it is last "+F.checkisLast());
		F.output();
		System.out.println("\n"+z2.equalTo(z1));
		System.out.println(Z.lessThan(z1));



	}

}
