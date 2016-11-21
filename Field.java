import java.util.Random;

public class Field 
{
	private int[][] field;
	private int size;
	
	public Field()
	{
		size = 10;
		field = new int[size][size];
		
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				field[i][j] = 0;
	}
	
	public Field(int[][] mas)
	{
		size = 10;
		field = new int[size][size];
		
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				field[i][j] = mas[i][j];
	}
	
	private boolean checkPlace(int x, int y)
	{
		boolean flag = true;
		for (int i = x-1; i < x+2; i++)
			for (int j = y-1; j < y+2; j++)
			{
				if ((i < size) && (j < size) && (i >= 0) && (j >= 0))
					if (field[i][j] == 1)
						flag = false;
			}
		return flag;
	}
	
	private void putShip(int l, int x, int y, int o)
	{
		switch(o)
			{
				case 0:
				{
					for (int j = x; j < x+l; j++)
						field[j][y] = 1;
					break;
				}
				default:
				{
					for (int j = y; j < y+l; j++)
						field[x][j] = 1;
					break;
				}
			}
	}
	
	public void setAuto()
	{
		Random random = new Random();
		boolean success;
		int orient;
		int x, y, l;
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				success = false;
				
				do
				{
					x = random.nextInt(10);
					y = random.nextInt(10);
					orient = random.nextInt(2);
					
					if (checkPlace(x, y) == true)
					{
						if (4-i > 1)
						{
							switch(orient)
							{
								case 0:
								{
									if ((x+3-i < field.length) && (checkPlace(x+3-i, y)))							
										success = true;
									else if (x-3+i >= 0) 
										{
										x = x-3+i;
										if (checkPlace(x, y))							
											success = true;
										}
									break;
								}
								default:
								{
									if ((y+3-i < field.length) && (checkPlace(x, y+3-i)))							
										success = true;
									else if (y-3+i >= 0)
										{
										y = y-3+i;
										if ((y >= 0) && (checkPlace(x, y)))							
											success = true;
										}
									break;
								}
							}
						}
						else
							success = true;
					}
				}
				while (success != true);
				
				putShip(4-i, x, y, orient);
			}
		}
	}
	
	public void setHand(int x, int y, int o, int l)
	{
		if(checkPlace(x, y))
		{
			switch(o)
			{
				case 0:
				{
					if(checkPlace(x+3-l, y))
						putShip(l, x, y, o);
				}
				default:
				{
					if(checkPlace(x, y+3-l))
						putShip(l, x, y, o);
				}
				// Hello world!!!
			}
		}
	}
	
	public int[][] getField(){
		return field;
	}
}
