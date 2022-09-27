class Fourte extends PlayGame
{
	public static void main(String ar[])throws java.io.IOException
	{
		PlayGame playgame=new PlayGame();
		int target[]={6,2,7,8};
		int numbers[][]={
			{5, 7, 2, 8},
			{7, 2, 6, 5},
			{1, 2, 3, 4},
			{5, 9, 3, 1}
		};
		for(int i=0;i<numbers.length;i++)
		{
			playgame.getInput(target[i],numbers[i]);
		}
	}
}
