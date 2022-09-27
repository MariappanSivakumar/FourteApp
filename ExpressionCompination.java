class ExpressionCompination
{
	public String[] compination(int value[])
	{
		int count=0;
		char operator[]={'/', '*', '+', '-'};
		String expression[]=new String[4*4*4*4*4*4];
		for(int i=0;i<operator.length;i++)
		{
			for(int j=0;j<operator.length;j++)
			{
				for(int k=0;k<operator.length;k++)
				{
					for(int l=0;l<operator.length;l++)
					{
						expression[count++]=(value[i]+""+operator[i]+""+value[j]+""+operator[j]+""+value[k]+""+operator[k]+""+value[l]);
						for(int m=0;m<operator.length;m++)
						{
							expression[count++]=(value[i]+""+value[j]+""+operator[m]+""+value[k]+""+value[l]);
						}
					}
				}
			}
		}
		return expression;
	}
}
