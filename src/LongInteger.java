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
		LongInteger z = new LongInteger();
		int sum = 0, carry = 0;
		if (this.getSign() == i.getSign()) {
			if ((this.getSign() && this.getDigitCount() > i.getDigitCount())
					|| (i.getSign() && i.getDigitCount() > this.getDigitCount()))
				z.setSign(true);
			else
				z.setSign(false);
			while (temp1 != this.list.last() && temp2 != i.list.last()) {
				sum = temp1.getValue() + temp2.getValue() + carry;
				if (z.list.isEmpty())
					z.list.insertFirst(UtilityOperations.underflow(sum));
				else
					z.list.insertLast(UtilityOperations.underflow(sum));
				carry = UtilityOperations.overflow(sum);
				temp1 = this.list.after(temp1);
				temp2 = i.list.after(temp2);
			}
			if (temp2 == i.list.last() && temp1 != this.list.last()) {
				sum = temp1.getValue() + temp2.getValue() + carry;
				z.list.insertLast(UtilityOperations.underflow(sum));
				carry = UtilityOperations.overflow(sum);
				while (temp1 != this.list.last()) {
					temp1 = this.list.after(temp1);
					if (temp1 != this.list.last()) {
						sum = temp1.getValue() + carry;
						z.list.insertLast(UtilityOperations.underflow(sum));
						carry = UtilityOperations.overflow(sum);
					}
				}
				if (temp1 == this.list.last()) {
					sum = temp1.getValue() + carry;
					carry = UtilityOperations.overflow(sum);
					z.list.insertLast(UtilityOperations.underflow(sum));
					if (carry != 0)
						z.list.insertLast(carry);
				}
			} else if (temp1 == this.list.last() && temp2 != i.list.last()) {
				sum = temp1.getValue() + temp2.getValue() + carry;
				z.list.insertLast(UtilityOperations.underflow(sum));
				carry = UtilityOperations.overflow(sum);
				while (temp2 != i.list.last()) {
					temp2 = i.list.after(temp2);
					if (temp2 != i.list.last()) {
						sum = temp2.getValue() + carry;
						z.list.insertLast(UtilityOperations.underflow(sum));
						carry = UtilityOperations.overflow(sum);
					}
				}
				if (temp2 == i.list.last()) {
					sum = temp2.getValue() + carry;
					carry = UtilityOperations.overflow(sum);
					z.list.insertLast(UtilityOperations.underflow(sum));
					if (carry != 0)
						z.list.insertLast(carry);
				}
			}
			if (temp1 == this.list.last() && temp2 == i.list.last() && this.list.size() == i.list.size()) {
				sum = temp1.getValue() + temp2.getValue() + carry;
				z.list.insertLast(UtilityOperations.underflow(sum));
				carry = UtilityOperations.overflow(sum);

				if (carry != 0)
					z.list.insertLast(carry);
			}
		} else if (this.getSign() != i.getSign()) {
			if (this.getSign() && !i.getSign()) {
				// LongInteger x;
				this.setSign(false);
				z = i.subtract(this);
				this.setSign(true);
				return z;
			}

			if (!this.getSign() && i.getSign()) {
				i.setSign(false);
				z = this.subtract(i);
				i.setSign(true);
				return z;
			}
		}
		return z;
	}

	public LongInteger subtract(LongInteger i) {
		Position temp1, temp2;
		temp1 = this.list.first();
		temp2 = i.list.first();
		int diff = 0, extra = 0;
		LongInteger z = new LongInteger();
		if (this.getSign() == i.getSign()) {
			if (this.getDigitCount() > i.getDigitCount() || (this.getDigitCount() == i.getDigitCount()
					&& this.list.last().getValue() > i.list.last().getValue())) {
				extra = temp1.getValue();
				if (this.getSign() && this.getDigitCount() > i.getDigitCount())
					z.setSign(true);
				if (this.getDigitCount() == i.getDigitCount() && this.getSign()
						&& this.list.last().getValue() > i.list.last().getValue())
					z.setSign(true);

				while (temp1 != this.list.last() && temp2 != i.list.last()) {
					if (temp1.getValue() < temp2.getValue()) {
						diff = ((extra + 10000) - temp2.getValue());
						if (z.list.isEmpty())
							z.list.insertFirst(diff);
						else
							z.list.insertLast(diff);
						temp1 = this.list.after(temp1);
						temp2 = i.list.after(temp2);
						extra = temp1.getValue() - 1;
					} else {
						diff = extra - temp2.getValue();
						if (z.list.isEmpty())
							z.list.insertFirst(diff);
						else
							z.list.insertLast(diff);
						temp1 = this.list.after(temp1);
						temp2 = i.list.after(temp2);
						extra = temp1.getValue();
					}
				}
				if (temp2 == i.list.last() && temp1 != this.list.last()) {
					if (extra < temp2.getValue()) {
						diff = ((extra + 10000) - temp2.getValue());
						if (z.list.isEmpty())
							z.list.insertFirst(diff);
						else
							z.list.insertLast(diff);
						temp1 = this.list.after(temp1);
						extra = temp1.getValue() - 1;
					} else {
						diff = extra - temp2.getValue();
						if (z.list.isEmpty())
							z.list.insertFirst(diff);
						else
							z.list.insertLast(diff);
						temp1 = this.list.after(temp1);
						extra = temp1.getValue();
					}
					while (temp1 != this.list.last()) {
						z.list.insertLast(extra);
						temp1 = this.list.after(temp1);
						extra = temp1.getValue();
					}
					if (temp1 == this.list.last())
						z.list.insertLast(extra);
				}

				if (temp1 == this.list.last() && temp2 == i.list.last() && this.list.size() == i.list.size()) {
					if (extra < temp2.getValue())
						diff = temp2.getValue() - extra;
					else
						diff = extra - temp2.getValue();
					z.list.insertLast(diff);
				}
			} else {
				if (!i.getSign() && i.getDigitCount() > this.getDigitCount())
					z.setSign(true);
				extra = temp2.getValue();
				// if(i.getSign())
				// z.setSign(true);
				while (temp1 != this.list.last() && temp2 != i.list.last()) {
					if (temp1.getValue() < extra) {
						diff = extra - temp1.getValue();
						if (z.list.isEmpty())
							z.list.insertFirst(diff);
						else
							z.list.insertLast(diff);
						temp1 = this.list.after(temp1);
						temp2 = i.list.after(temp2);
						extra = temp2.getValue();
					} else if (temp1.getValue() == extra) // Case
					{ // when
						diff = extra - temp1.getValue(); // both the numbers
						// will be equal.
						if (z.list.isEmpty())
							z.list.insertFirst(diff);
						else
							z.list.insertLast(diff);
						temp1 = this.list.after(temp1);
						temp2 = i.list.after(temp2);
						extra = temp2.getValue();
						z.setSign(false);
					} //
					else {
						diff = ((extra + 10000) - temp1.getValue());
						if (z.list.isEmpty())
							z.list.insertFirst(diff);
						else
							z.list.insertLast(diff);
						temp1 = this.list.after(temp1);
						temp2 = i.list.after(temp2);
						extra = temp2.getValue() - 1;
					}
				}
				if (temp1 == this.list.last() && temp2 != i.list.last()) {
					if (temp1.getValue() < extra) {
						diff = extra - temp1.getValue();
						if (z.list.isEmpty())
							z.list.insertFirst(diff);
						else
							z.list.insertLast(diff);
						temp2 = i.list.after(temp2);
						extra = temp2.getValue();
					} else {
						diff = ((extra + 10000) - temp1.getValue());
						if (z.list.isEmpty())
							z.list.insertFirst(diff);
						else
							z.list.insertLast(diff);
						temp2 = i.list.after(temp2);
						extra = temp2.getValue() - 1;
					}
					while (temp2 != i.list.last()) {
						z.list.insertLast(extra);
						temp2 = i.list.after(temp2);
						extra = temp2.getValue();
					}
					if (temp2 == i.list.last()) {
						z.list.insertLast(extra);
					}
				}
				if (temp1 == this.list.last() && temp2 == i.list.last() && this.list.size() == i.list.size()) {
					diff = extra - temp1.getValue();
					z.list.insertLast(diff);
					z.setSign(false);
				}
			}
		}

		else {
			if ((this.getSign() && !i.getSign()) && this.getDigitCount() > i.getDigitCount()) {
				i.setSign(true);
				z = this.add(i);
				i.setSign(false);
				// return z;
			}

			if ((this.getSign() && !i.getSign()) && i.getDigitCount() > this.getDigitCount()) {
				i.setSign(true);
				z = this.add(i);
				i.setSign(false);
			}

			if ((!this.getSign() && i.getSign()) && i.getDigitCount() > this.getDigitCount()) {
				i.setSign(false);
				z = this.add(i);
				i.setSign(true);
				// return z;
			}

			if ((!this.getSign() && i.getSign()) && this.getDigitCount() > i.getDigitCount()) {
				i.setSign(false);
				z = this.add(i);
				i.setSign(true);
				// return z;
			}
		}
		// z.printdiff();
		return z;
	}

	public void printdiff() {
		Position temp, mp;
		temp = this.list.last();
		mp = this.list.first();
		LongInteger z = new LongInteger();
		while (temp.getValue() == 0) {
			temp = this.list.before(temp);
		}
		if (temp == this.list.first() && temp.getValue() == 0) {
			z.list.insertFirst(0);
		}
		if (temp == this.list.first() || temp.getValue() != 0) {
			while (mp != temp) {
				if (z.list.isEmpty())
					z.list.insertFirst(mp.getValue());
				else
					z.list.insertLast(mp.getValue());
				mp = this.list.after(mp);
			}
			if (mp == temp) {
				z.list.insertLast(mp.getValue());
			}
			// this.list.insertLast(temp.getValue());

		}
	}

	public LongInteger multiply(LongInteger i) {
		Position temp1, temp2;
		temp1 = this.list.first();
		temp2 = i.list.first();
		LongInteger z1 = new LongInteger("0");
		int prod, k = 0;
		
		while (temp2 != null) {
			LongInteger z = new LongInteger();
			int carry=0;
			temp1 = this.list.first();
			while (temp1 != null) {
				
				prod = (temp1.getValue() * temp2.getValue()) + carry;
				carry = UtilityOperations.overflow(prod);
				if (z.list.isEmpty())
					z.list.insertFirst(UtilityOperations.underflow(prod));
				else
					z.list.insertLast(UtilityOperations.underflow(prod));

				temp1 = this.list.after(temp1);
			}
			if(carry!=0)
				z.list.insertLast(carry);
			for (int b = 0; b < k; b++) {
				z.list.insertFirst(0);
			}

			k++;
			temp2 = i.list.after(temp2);
			z1 = z1.add(z);
		}
		if((this.getSign() && i.getSign()) || (!this.getSign() && !i.getSign()))
			z1.setSign(false);
		else
			z1.setSign(true);
		return z1;
	}

	  public LongInteger power(int p) {
		  
	  }


}