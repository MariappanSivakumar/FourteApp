
class PlayGame
{
	public java.util.ArrayList<String> split(String expression)
	{ 
		java.util.ArrayList<String> al=new java.util.ArrayList<String>();
		String s=new String();
		for(int i=0;i<expression.length();i++)
		{
			if(expression.charAt(i)>=48&&expression.charAt(i)<=57)
				s+=expression.charAt(i);
			else 
			{
				al.add(s);
				s="";
				s+=expression.charAt(i);
				al.add(s);
				s="";
			}
			if(i==(expression.length()-1))
				al.add(s);
		}
		return al;
	} 

	public String process(java.util.ArrayList<String> arrayList,char c)
	{
		String value=new String();
		try 
		{
			for( int i=0;i<arrayList.size();i++ )
			{
				if(arrayList.get(i).equals(""+c))
				{
					if(arrayList.get(i).equals(" ")==false && arrayList.get(i-1).equals(" ")==false && arrayList.get(i+1).equals(" ")==false)
					{
						arrayList.set(i+1,""+sum(Integer.parseInt(arrayList.get(i-1)),Integer.parseInt(arrayList.get(i+1)),c)); 
						arrayList.set(i," ");
						arrayList.set(i-1," ");
					}
				}
			}

			for( String val : arrayList )
				if(val.equals(" ")==false)
					value+=val;
		}catch(NumberFormatException e)
		{
			System.out.println("\t\t\t>>>>   INVAILD ARGUMENT    <<<<");
		}catch (NullPointerException e){}
		return value;
	}
	public static int sum(int n1,int n2,char c)
	{
		int sum=0;
		try {
			sum=(c=='%'?n1%n2:(c=='/'?n1/n2:(c=='*'?n1*n2:(c=='+'?n1+n2:(c=='-'?n1-n2:0)))));
		}catch(NumberFormatException e){
			System.out.println("INVAILD EXPRESSION");
		}catch(ArithmeticException e)
		{
			System.out.println("\t\t\t>>>>>   CANNOT DIVIDE BY ZERO    <<<<<");
		}
		return sum;
	}

	void getInput( int target, int number[])
	{
		int operator[]={'*','/','+','-'};
		System.out.print("\tTARGET : "+target +"\tNUMBERS : [ ");
		for(int i:number)
			System.out.print(i+" ");
		System.out.print("]\n");

		PlayGame playgameObj=new PlayGame();

		ExpressionCompination expressioncompination=new ExpressionCompination();
		String expression[]=expressioncompination.compination(number);
		String express=new String();
		

		for(int i=0;i<expression.length;i++)
		{
			try 
			{
				express=expression[i];

				String temp="Expression :"+express;
				for(int j=0;j<operator.length;j++)
				{
					java.util.ArrayList<String> arrayListObj=new java.util.ArrayList<>(playgameObj.split(express));
					express = playgameObj.process(arrayListObj,(char)operator[j]);
				}
				if((""+target).equals(""+Math.abs(Integer.parseInt(express)))==true)
				{
					int count=0;
					for(int j=0;j<number.length;j++)
					{
						if(temp.indexOf(""+number[j])!=-1)
							count++;
					}
					if(count==4)
						System.out.print("\t"+temp+" : "+Integer.parseInt(express)+"\n");
				}
			}
			catch(NullPointerException e){}
		}

	}
}
