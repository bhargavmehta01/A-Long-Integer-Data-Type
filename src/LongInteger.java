public class LongInteger {

	// DO NOT CHANGE OR REMOVE THIS LINE (UNTIL STEP 3)
	private SimpleList list = new SLLSimpleList();

	private String lngint,substr;
	private int intlength,listlength;
	Integer number;
	boolean isNegative = false;

	// private SimpleList<? extends Position> list = new ArraySimpleList();


	public LongInteger(String s) {
		if(s.isEmpty())
			System.out.println("Please enter a number");
		else
		{
			if(s.charAt(0)=='-')
			{
				lngint=s.substring(1, s.length());
				this.setSign(true);
			}
			else
			{
				lngint=s;
				this.setSign(false);
			}

			intlength=lngint.length();

			listlength=(int)Math.ceil((double)intlength/4);

			for(int i=0; i<listlength; i++)
			{
				if(intlength<4)
				{
					substr=lngint.substring(0, intlength);
				}
				else
				{
					substr=lngint.substring(intlength-4, intlength);
				}
				number=Integer.parseInt(substr);
				if(i==0)
				{
					list.insertFirst(number);
				}
				else
				{
					list.insertLast(number);
				}
				intlength=intlength-4;
			}
		}
	}

	public boolean checkisFirst()
	{
		return list.isFirst(list.first());
	}

	public boolean checkisLast()
	{
		return list.isLast(list.last());
	}


	public LongInteger() {

	}


	@SuppressWarnings("unchecked")
	public void output() {
		int tmpno,dgts;
		Position temp;

		if(list.isEmpty())
		{
			System.out.println("There is no number");
		}
		else
		{
			temp=list.last();
			System.out.print(temp.getValue()+" ");
			while(temp!=list.first())
			{
				temp=list.before(temp);
				tmpno=temp.getValue();
				if(tmpno==0)
				{
					System.out.print("000");
				}
				else
				{
					dgts=UtilityOperations.digits(tmpno);
					int j=0;
					while(dgts<4 && j<4-dgts)
					{
						System.out.print("0");
						j=j+1;
					}
				}
				System.out.print(temp.getValue()+" ");
			}
		}
	}

	public void setSign(boolean sign) 
	{
		isNegative = sign;
	}

	public boolean getSign() 
	{
		return isNegative;
	}

	public int getDigitCount() 
	{
		int temp=list.last().getValue();
		int tempsize=0;
		int dgtcount;
		while(temp>0)
		{
			tempsize=tempsize+1;
			temp=Math.abs(temp/10);
		}
		dgtcount=((list.size()-1)*4)+tempsize;
		return dgtcount;
	}

	public boolean equalTo(LongInteger i) 
	{
		Position tempfirst,tempsecond;
		boolean flag = true;
		if(this.list.isEmpty() || i.list.isEmpty())
		{
			return false;
		}
		else if(this.getSign() != i.getSign() || this.list.size() != i.list.size() || this.getDigitCount() != i.getDigitCount())
			return false;
		else
		{
			tempfirst=this.list.first();
			tempsecond=i.list.first();

			while(tempfirst!=this.list.last() && tempsecond!=i.list.last())				
			{
				if(tempfirst.getValue()==tempsecond.getValue())
				{
					tempfirst=this.list.after(tempfirst);
					tempsecond=i.list.after(tempsecond);
				}
				else
					return false;
			}
			if(tempfirst.getValue() != tempsecond.getValue())
				flag=false;
			return flag;
		}
	}

	public boolean lessThan(LongInteger i) 
	{
		Position tempfirst=this.list.last();
		Position tempsecond=i.list.last();
		boolean flag = true;
		if(this.list.isEmpty() || i.list.isEmpty())
			return false;
		else if(this.getSign() && i.getSign())
		{
			if(this.list.size()>i.list.size())
				return true;
			else if(this.list.size()==i.list.size())
			{
				if(this.list.first()==this.list.last() && tempfirst.getValue()==tempsecond.getValue())
				{
					return false;
				}
				else
				{
					while(tempfirst!=this.list.first() && tempsecond!=i.list.first() && tempfirst.getValue()==tempsecond.getValue())
					{
						if(tempfirst.getValue()>tempsecond.getValue())
							return true;
						else
						{
							tempfirst=this.list.before(tempfirst);
							tempsecond=i.list.before(tempsecond);
						}
					}
					if(tempfirst.getValue()<tempsecond.getValue())
						flag=false;
					else if(tempfirst.getValue()==tempsecond.getValue())
						flag=false;
					return flag;
				}
			}
			else
				return false;		
		}

		else if(!this.getSign() && !i.getSign())
		{
			if(this.list.size()<i.list.size())
				return true;
			else if(this.list.size()==i.list.size())
			{
				if(this.list.first()==this.list.last() && tempfirst.getValue()==tempsecond.getValue())
				{
					return false;
				}
				else
				{
					while(tempfirst!=this.list.first() && tempsecond!=i.list.first() && tempfirst.getValue()==tempsecond.getValue())
					{
						if(tempfirst.getValue()<tempsecond.getValue())
							return true;
						else
						{
							tempfirst=this.list.before(tempfirst);
							tempsecond=i.list.before(tempsecond);
						}
					}
					if(tempfirst.getValue()>tempsecond.getValue())
						flag=false;
					else if(tempfirst.getValue()==tempsecond.getValue())
						flag=false;
					return flag;
				}
			}
			else
				return flag;
		}

		else
		{
			if((!this.getSign() || !i.getSign()) && this.getSign())
				return true;
			else
				return false;
		}
	}



	public boolean greaterThan(LongInteger i) 
	{
		Position tempfirst = this.list.last();
		Position tempsecond = i.list.last();
		boolean flag=true;
		if(this.list.isEmpty() || i.list.isEmpty())
			return false;
		else if(this.getSign() && i.getSign())
		{
			if(this.list.size()<i.list.size())
				return true;
			else if(this.list.size()==i.list.size())
			{
				if(this.list.first()==this.list.last() && tempfirst.getValue()==tempsecond.getValue())
				{
					return false;
				}
				else
				{
					while(tempfirst!=this.list.first() && tempsecond!=i.list.first() && tempfirst.getValue()==tempsecond.getValue())
					{
						if(tempfirst.getValue()<tempsecond.getValue())
							return true;
						else
						{
							tempfirst=this.list.before(tempfirst);
							tempsecond=i.list.before(tempsecond);
						}
					}
					if(tempfirst.getValue()>tempsecond.getValue())
						flag=false;
					else if(tempfirst.getValue()==tempsecond.getValue())
						flag=false;
					return flag;
				}
			}
			else
				return false;
		}

		else if(!this.getSign() && !i.getSign())
		{
			if(this.list.size()>i.list.size())
				return true;
			else if(this.list.size()==i.list.size())
			{
				if(this.list.first()==this.list.last() && tempfirst.getValue()==tempsecond.getValue())
				{
					return false;
				}
				else
				{
					while(tempfirst!=this.list.first() && tempsecond!=i.list.first() && tempfirst.getValue()==tempsecond.getValue())
					{
						if(tempfirst.getValue()>tempsecond.getValue())
							return true;
						else
						{
							tempfirst=this.list.before(tempfirst);
							tempsecond=i.list.before(tempsecond);
						}
					}
					if(tempfirst.getValue()<tempsecond.getValue())
						flag=false;
					else if(tempfirst.getValue()==tempsecond.getValue())
						flag=false;
					return flag;
				}
			}
			else
				return flag;
		}

		else
		{
			if((!this.getSign() || !i.getSign()) && this.getSign())
				return true;
			else
				return false;
		}
		
	}


}



/*
    public LongInteger add(LongInteger i) {

    }

    public LongInteger subtract(LongInteger i) {

    }

    public LongInteger multiply(LongInteger i) {

    }

    public LongInteger power(int p) {

    }
 */


