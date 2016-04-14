import java.math.BigInteger;

public class LongInteger {

	// DO NOT CHANGE OR REMOVE THIS LINE (UNTIL STEP 3)
	private SimpleList list = new SLLSimpleList();

	private String lngint, substr;
	private int intlength, listlength;
	Integer number;
	boolean isNegative = false;

	// private SimpleList<? extends Position> list = new ArraySimpleList();

	public LongInteger(String s) {
		if (s.isEmpty())
			System.out.println("Please enter a number");
		else {
			if (s.charAt(0) == '-') {
				lngint = s.substring(1, s.length());
				this.setSign(true);
			} else {
				lngint = s;
				this.setSign(false);
			}

			intlength = lngint.length();

			listlength = (int) Math.ceil((double) intlength / 4);

			for (int i = 0; i < listlength; i++) {
				if (intlength < 4) {
					substr = lngint.substring(0, intlength);
				} else {
					substr = lngint.substring(intlength - 4, intlength);
				}
				number = Integer.parseInt(substr);
				if (i == 0) {
					list.insertFirst(number);
				} else {
					list.insertLast(number);
				}
				intlength = intlength - 4;
			}
		}
	}

	public void testcase2() {
		Position temp;
		temp = list.last();

		while (temp != list.first()) {
			System.out.print(temp.getValue() + " ");
			temp = list.before(temp);

		}
		if (temp == list.first())
			System.out.print(temp.getValue());
	}

	public LongInteger() {

	}

	@SuppressWarnings("unchecked")
	public void output() {
		int tmpno, dgts;
		Position temp;

		if (list.isEmpty()) {
			System.out.println("There is no number");
		} else {
			if (this.getSign())
				System.out.print("-");
			temp = list.last();
			System.out.print(temp.getValue());
			while (temp != list.first()) {
				temp = list.before(temp);
				tmpno = temp.getValue();
				if (tmpno == 0) {
					System.out.print("000");
				} else {
					dgts = UtilityOperations.digits(tmpno);
					int j = 0;
					while (dgts < 4 && j < 4 - dgts) {
						System.out.print("0");
						j = j + 1;
					}
				}
				System.out.print(temp.getValue());
			}
		}
	}

	public void setSign(boolean sign) {
		isNegative = sign;
	}

	public boolean getSign() {
		return isNegative;
	}

	public int getDigitCount() {
		int temp = list.last().getValue();
		int tempsize = 0;
		int dgtcount;
		while (temp > 0) {
			tempsize = tempsize + 1;
			temp = Math.abs(temp / 10);
		}
		dgtcount = ((list.size() - 1) * 4) + tempsize;
		return dgtcount;
	}

	public boolean equalTo(LongInteger i) {
		Position tempfirst, tempsecond;
		boolean flag = true;
		if (this.list.isEmpty() || i.list.isEmpty()) {
			return false;
		} else if (this.getSign() != i.getSign() || this.list.size() != i.list.size()
				|| this.getDigitCount() != i.getDigitCount())
			return false;
		else {
			tempfirst = this.list.first();
			tempsecond = i.list.first();

			while (tempfirst != this.list.last() && tempsecond != i.list.last()) {
				if (tempfirst.getValue() == tempsecond.getValue()) {
					tempfirst = this.list.after(tempfirst);
					tempsecond = i.list.after(tempsecond);
				} else
					return false;
			}
			if (tempfirst.getValue() != tempsecond.getValue())
				flag = false;
			return flag;
		}
	}

	public boolean lessThan(LongInteger i) {
		Position tempfirst = this.list.last();
		Position tempsecond = i.list.last();
		boolean flag = true;
		if (this.list.isEmpty() || i.list.isEmpty())
			return false;
		else if (this.getSign() && i.getSign()) {
			if (this.list.size() > i.list.size())
				return true;
			else if (this.list.size() == i.list.size()) {
				if (this.list.first() == this.list.last() && tempfirst.getValue() == tempsecond.getValue()) {
					return false;
				} else {
					while (tempfirst != this.list.first() && tempsecond != i.list.first()
							&& tempfirst.getValue() == tempsecond.getValue()) {
						if (tempfirst.getValue() > tempsecond.getValue())
							return true;
						else {
							tempfirst = this.list.before(tempfirst);
							tempsecond = i.list.before(tempsecond);
						}
					}
					if (tempfirst.getValue() < tempsecond.getValue())
						flag = false;
					else if (tempfirst.getValue() == tempsecond.getValue())
						flag = false;
					return flag;
				}
			} else
				return false;
		}
		else if (!this.getSign() && !i.getSign()) {
			if (this.list.size() < i.list.size())
				return true;
			else if (this.list.size() == i.list.size()) {
				if (this.list.first() == this.list.last() && tempfirst.getValue() == tempsecond.getValue()) {
					return false;
				} else {
					while (tempfirst != this.list.first() && tempsecond != i.list.first()
							&& tempfirst.getValue() == tempsecond.getValue()) {
						if (tempfirst.getValue() < tempsecond.getValue())
							return true;
						else {
							tempfirst = this.list.before(tempfirst);
							tempsecond = i.list.before(tempsecond);
						}
					}
					if (tempfirst.getValue() > tempsecond.getValue())
						flag = false;
					else if (tempfirst.getValue() == tempsecond.getValue())
						flag = false;
					return flag;
				}
			} else
				return false;
		}
		else {
			if ((!this.getSign() || !i.getSign()) && this.getSign())
				return true;
			else
				return false;
		}
	}

	public boolean greaterThan(LongInteger i) {
		Position tempfirst = this.list.last();
		Position tempsecond = i.list.last();
		boolean flag = true;
		if (this.list.isEmpty() || i.list.isEmpty())
			return false;
		else if (this.getSign() && i.getSign()) {
			if (this.list.size() < i.list.size())
				return true;
			else if (this.list.size() == i.list.size()) {
				if (this.list.first() == this.list.last() && tempfirst.getValue() == tempsecond.getValue()) {
					return false;
				} else {
					while (tempfirst != this.list.first() && tempsecond != i.list.first()
							&& tempfirst.getValue() == tempsecond.getValue()) {
						if (tempfirst.getValue() < tempsecond.getValue())
							return true;
						else {
							tempfirst = this.list.before(tempfirst);
							tempsecond = i.list.before(tempsecond);
						}
					}
					if (tempfirst.getValue() > tempsecond.getValue())
						flag = false;
					else if (tempfirst.getValue() == tempsecond.getValue())
						flag = false;
					return flag;
				}
			} else
				return false;
		}

		else if (!this.getSign() && !i.getSign()) {
			if (this.list.size() > i.list.size())
				return true;
			else if (this.list.size() == i.list.size()) {
				if (this.list.first() == this.list.last() && tempfirst.getValue() == tempsecond.getValue()) {
					return false;
				} else {
					while (tempfirst != this.list.first() && tempsecond != i.list.first()
							&& tempfirst.getValue() == tempsecond.getValue()) {
						if (tempfirst.getValue() > tempsecond.getValue())
							return true;
						else {
							tempfirst = this.list.before(tempfirst);
							tempsecond = i.list.before(tempsecond);
						}
					}
					if (tempfirst.getValue() < tempsecond.getValue())
						flag = false;
					else if (tempfirst.getValue() == tempsecond.getValue())
						flag = false;
					return flag;
				}
			} else
				return false;
		}
		else {
			if ((!this.getSign() || !i.getSign()) && !this.getSign())
				return true;
			else
				return false;
		}
	}

	public LongInteger add(LongInteger i) {
		Position temp1, temp2;
		temp1 = this.list.first();
		temp2 = i.list.first();
		LongInteger result = new LongInteger();
		int sum = 0, carry = 0;
		if (this.getSign() == i.getSign()) {
			if ((this.getSign() && this.getDigitCount() > i.getDigitCount())
					|| (i.getSign() && i.getDigitCount() > this.getDigitCount()))
				result.setSign(true);
			else
				result.setSign(false);
			while (temp1 != this.list.last() && temp2 != i.list.last()) {
				sum = temp1.getValue() + temp2.getValue() + carry;
				result.list.insertLast(UtilityOperations.underflow(sum));
				carry = UtilityOperations.overflow(sum);
				temp1 = this.list.after(temp1);
				temp2 = i.list.after(temp2);
			}
			if (temp2 == i.list.last() && temp1 != this.list.last()) {
				sum = temp1.getValue() + temp2.getValue() + carry;
				result.list.insertLast(UtilityOperations.underflow(sum));
				carry = UtilityOperations.overflow(sum);
				while (temp1 != this.list.last()) {
					temp1 = this.list.after(temp1);
					if (temp1 != this.list.last()) {
						sum = temp1.getValue() + carry;
						result.list.insertLast(UtilityOperations.underflow(sum));
						carry = UtilityOperations.overflow(sum);
					}
				}
				if (temp1 == this.list.last()) {
					sum = temp1.getValue() + carry;
					carry = UtilityOperations.overflow(sum);
					result.list.insertLast(UtilityOperations.underflow(sum));
					if (carry != 0)
						result.list.insertLast(carry);
				}
			} else if (temp1 == this.list.last() && temp2 != i.list.last()) {
				sum = temp1.getValue() + temp2.getValue() + carry;
				result.list.insertLast(UtilityOperations.underflow(sum));
				carry = UtilityOperations.overflow(sum);
				while (temp2 != i.list.last()) {
					temp2 = i.list.after(temp2);
					if (temp2 != i.list.last()) {
						sum = temp2.getValue() + carry;
						result.list.insertLast(UtilityOperations.underflow(sum));
						carry = UtilityOperations.overflow(sum);
					}
				}
				if (temp2 == i.list.last()) {
					sum = temp2.getValue() + carry;
					carry = UtilityOperations.overflow(sum);
					result.list.insertLast(UtilityOperations.underflow(sum));
					if (carry != 0)
						result.list.insertLast(carry);
				}
			}
			if (temp1 == this.list.last() && temp2 == i.list.last() && this.list.size() == i.list.size()) {
				sum = temp1.getValue() + temp2.getValue() + carry;
				result.list.insertLast(UtilityOperations.underflow(sum));
				carry = UtilityOperations.overflow(sum);

				if (carry != 0)
					result.list.insertLast(carry);
			}
		} else if (this.getSign() != i.getSign()) {
			if (this.getSign() && !i.getSign()) {
				this.setSign(false);
				result = i.subtract(this);
				this.setSign(true);
				return result;
			}

			if (!this.getSign() && i.getSign()) {
				i.setSign(false);
				result = this.subtract(i);
				i.setSign(true);
				return result;
			}
		}
		return result;
	}

	public LongInteger subtract(LongInteger i) {
		Position temp1, temp2;
		temp1 = this.list.first();
		temp2 = i.list.first();
		int diff = 0, extra = 0;
		LongInteger result = new LongInteger();
		if (this.getSign() == i.getSign() ) {
			
			if (this.getDigitCount() > i.getDigitCount() || this.getDigitCount() == i.getDigitCount() && ((this.getSign() && this.lessThan(i)) || (!this.getSign() && (this.greaterThan(i) || this.equalTo(i))))) 
			{
				extra = temp1.getValue();
				if (this.getSign() && this.getDigitCount() > i.getDigitCount())
					result.setSign(true);
				if (this.getDigitCount() == i.getDigitCount() && this.getSign()
						&& this.list.last().getValue() > i.list.last().getValue())
					result.setSign(true);

				while (temp1 != null && temp2 != null) {
					if (extra < temp2.getValue()) {
						diff = ((extra + 10000) - temp2.getValue());
						if((diff!=0 && !this.list.isLast(temp1)) || (diff==0 && this.list.isFirst(temp1)))
							result.list.insertLast(diff);
						temp1 = this.list.after(temp1);
						temp2 = i.list.after(temp2);
						if(temp1!=null)
							extra = temp1.getValue() - 1;
					} else {
						diff = extra - temp2.getValue();
						if((diff!=0 && !this.list.isLast(temp1)) || (diff==0 && this.list.isFirst(temp1)))
							result.list.insertLast(diff);
						temp1 = this.list.after(temp1);
						temp2 = i.list.after(temp2);
						if(temp1!=null)
							extra = temp1.getValue();
					}
				}
				if(temp2 == null && temp1 != null)
					{
						while (temp1 != this.list.last()) {
							result.list.insertLast(extra);
							temp1 = this.list.after(temp1);
							extra = temp1.getValue();
						}
						if (temp1 == this.list.last())
							if(extra!=0)
								result.list.insertLast(extra);
					}
			} else 
			{
				if ((!i.getSign() && i.getDigitCount() > this.getDigitCount()) || (this.getDigitCount()==i.getDigitCount() && i.greaterThan(this)))
					result.setSign(true);
				extra = temp2.getValue();

				while (temp1 != null && temp2 != null) {
					if (temp1.getValue() < extra || temp1.getValue() == extra) {
						diff = extra - temp1.getValue();
						if((diff!=0 && !i.list.isLast(temp2)) || (diff==0 && i.list.isFirst(temp2)))
							result.list.insertLast(diff);
						temp1 = this.list.after(temp1);
						temp2 = i.list.after(temp2);
						if(temp2!=null)
							extra = temp2.getValue();
					} 													
					else {
						diff = ((extra + 10000) - temp1.getValue());
						if((diff!=0 && !i.list.isLast(temp2)) || (diff==0 && i.list.isFirst(temp2)))
							result.list.insertLast(diff);
						temp1 = this.list.after(temp1);
						temp2 = i.list.after(temp2);
						if(temp2!=null)
							extra = temp2.getValue() - 1;
					}
				}
				if (temp1 == null && temp2 != null) 
				{
					while (temp2 != i.list.last()) {
						result.list.insertLast(extra);
						temp2 = i.list.after(temp2);
						extra = temp2.getValue();
					}
					if (temp2 == i.list.last()) {
						if(extra!=0)
							result.list.insertLast(extra);
					}
				}
			}
		}

		else {
			if ((this.getSign() && !i.getSign()) && this.getDigitCount() > i.getDigitCount()) {
				i.setSign(true);
				result = this.add(i);
				i.setSign(false);
			}

			if ((this.getSign() && !i.getSign()) && i.getDigitCount() > this.getDigitCount()) {
				i.setSign(true);
				result = this.add(i);
				i.setSign(false);
			}

			if ((!this.getSign() && i.getSign()) && i.getDigitCount() > this.getDigitCount()) {
				i.setSign(false);
				result = this.add(i);
				i.setSign(true);
			}

			if ((!this.getSign() && i.getSign()) && this.getDigitCount() > i.getDigitCount()) {
				i.setSign(false);
				result = this.add(i);
				i.setSign(true);
			}
		}
			Position ex=result.list.last();
			if(ex.getValue()==0 && result.list.last()==result.list.first())
				result = new LongInteger("0");
			else if(ex.getValue()==0 && result.list.before(ex).getValue()==0)
				result = new LongInteger("0");
		return result;
	}

	public LongInteger multiply(LongInteger i) {
		Position temp1, temp2;
		temp1 = this.list.first();
		temp2 = i.list.first();
		LongInteger mult = new LongInteger("0");
		int prod, k = 0;
		
		while (temp2 != null) {
			LongInteger result = new LongInteger();
			int carry=0;
			temp1 = this.list.first();
			while (temp1 != null) {
				
				prod = (temp1.getValue() * temp2.getValue()) + carry;
				carry = UtilityOperations.overflow(prod);
				if (result.list.isEmpty())
					result.list.insertFirst(UtilityOperations.underflow(prod));
				else
					result.list.insertLast(UtilityOperations.underflow(prod));

				temp1 = this.list.after(temp1);
			}
			if(carry!=0)
				result.list.insertLast(carry);
			for (int b = 0; b < k; b++) {
				result.list.insertFirst(0);
			}

			k++;
			temp2 = i.list.after(temp2);
			mult = mult.add(result);
		}
		if((this.getSign() && i.getSign()) || (!this.getSign() && !i.getSign()))
			mult.setSign(false);
		else
			mult.setSign(true);
		return mult;
	}

	  public LongInteger power(int p) {
		  int mod,j=0;
		  LongInteger extra=this;
		  LongInteger result=new LongInteger("1");
		  LongInteger zero=new LongInteger("0");
		  if(p<0)
			  return zero;
		  while(p>0)
		  {
			  mod=p%2;
			  if(j==0)
			  {
				  if(mod==1)
					  result=extra; 
			  }
			  else if(mod==1 && j>0)
			  {
				  extra=extra.multiply(extra);
				  result=extra.multiply(result);
			  }
			  else
				  extra=extra.multiply(extra);
			  j++;
			  p=(int)Math.ceil(p/2);
		  }
		  return result;
	  }


}