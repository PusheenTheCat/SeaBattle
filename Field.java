import java.util.Random;

public class Field 
{
	private int[][] field;  //—осто€ние €чейчки: 0 - вода, 1 - целый корабль, 2 - раненый корабль
	private boolean[][] shooted;
	private int size, alive;
	public enum Orientation {HORIZONTAL, VERTICAL}
	
	public Field()
	{
		size = 10;
		alive = 20;
		field = new int[size][size];
		shooted = new boolean[size][size];
		
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
			{
				field[i][j] = 0;
				shooted[i][j] = false;
			}
	}
	
	public Field(int[][] mas)
	{
		size = 10;
		alive = 20;
		field = new int[size][size];
		shooted = new boolean[size][size];
		
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
			{
				field[i][j] = mas[i][j];
				shooted[i][j] = false;
			}
	}
	
	public boolean checkPlace(int x, int y)
	{
		assert((x >= 0) && (x < size) && (y >= 0) && (y < size));
		
		for (int i = x-1; i < x+2; i++)
			for (int j = y-1; j < y+2; j++)
			{
				if ((i < size) && (j < size) && (i >= 0) && (j >= 0))
					if (field[i][j] == 1)
						return false;
			}
		return true;
	}
        
	public void putShip(int length, int x, int y, Orientation o)
	{
		assert((x >= 0) && (x < size) && (y >= 0) && (y < size) && (length >=0) && (length < 4));
		
                if (length == 0)
                {
                    field[x][y] = 1;
                    return;
                }
                
		switch(o)
			{
				case VERTICAL:
				{
					for (int j = x; j < x+length; j++)
						field[j][y] = 1;
					break;
				}
				default:
				{
					for (int j = y; j < y+length; j++)
						field[x][j] = 1;
					break;
				}
			}
	}
	
	public void setAuto()
	{
		Random random = new Random();
		boolean success;
		Orientation orient;
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
					
					if (random.nextInt(2) == 0)
						orient = Orientation.VERTICAL;
					else
						orient = Orientation.HORIZONTAL;
					
					if (checkPlace(x, y) == true)
					{
						if (4-i > 1)
						{
							switch(orient)
							{
								case VERTICAL:
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
	
	public boolean setHand(int x, int y, int o, int length)
	{
		Orientation orient;
		
		if (o == 0)
			orient = Orientation.VERTICAL;
		else
			orient = Orientation.HORIZONTAL;
		
		if(checkPlace(x, y))
		{
                    if (length == 0)
                        return true;
                    else          
			switch(orient)
			{
				case VERTICAL:
				{
					if(checkPlace(x+3-length, y))
						return true;
                                        else
                                            return false;
				}
				default:
				{
					if(checkPlace(x, y+3-length))
						return true;
                                        else
                                            return false;
				}
			}
		}
                else
                    return false;
	}
	
	public void fillWater(int x, int y)
	{
		int i = x;
		while (i < size)
		{
			if (field[i][y] == 0)
				break;
			
			for (int v = i-1; v <= i+1; v++)
				for (int w = y-1; w <= y+1; w++)
					if ((v >= 0) && (v < size) && (w >= 0) && (w < size) && (field[v][w] == 0))
						doShot(v, w);
					
			i++;
		}
                
		i = x;
		while (i >= 0)
		{
			if (field[i][y] == 0)
				break;
			
			for (int v = i-1; v <= i+1; v++)
				for (int w = y-1; w <= y+1; w++)
					if ((v >= 0) && (v < size) && (w >= 0) && (w < size) && (field[v][w] == 0))
						doShot(v, w);
			
			i--;
		}
		
		i = y;
		while (i < size)
		{
			if (field[x][i] == 0)
				break;
			
			for (int v = x-1; v <= x+1; v++)
				for (int w = i-1; w <= i+1; w++)
					if ((v >= 0) && (v < size) && (w >= 0) && (w < size) && (field[v][w] == 0))
						doShot(v, w);
			
			i++;
		}
		
		i = y;
		while (i >= 0)
		{
			if (field[x][i] == 0)
				break;
			
			for (int v = x-1; v <= x+1; v++)
				for (int w = i-1; w <= i+1; w++)
					if ((v >= 0) && (v < size) && (w >= 0) && (w < size) && (field[v][w] == 0))
						doShot(v, w);
			
			i--;
		}
	}
	
	public boolean checkKilled(int x, int y)
	{
    		assert((x >= 0) && (x < size) && (y >= 0) && (y < size));
		
		int i = x;
        	while (i < size)
		{
			if (field[i][y] == 1)
				return false;
			if (field[i][y] == 0)
				break;
			i++;
		}
		
		i = x;
		while (i >= 0)
		{
			if (field[i][y] == 1)
				return false;
			if (field[i][y] == 0)
				break;
			
			i--;
		}
		
		i = y;
		while (i < size)
		{
			if (field[x][i] == 1)
				return false;
			if (field[x][i] == 0)
				break;
			i++;
		}
		
		i = y;
		while (i >= 0)
		{
			if (field[x][i] == 1)
				return false;
			if (field[x][i] == 0)
				break;
			i--;
		}
		
		fillWater(x, y);
		return true;
	}
	
	public boolean doShot(int x, int y)
	{
		assert((x >= 0) && (x < size) && (y >= 0) && (y < size));
		
		if (shooted[x][y] == true)
			return false;
		else
		{
			shooted[x][y] = true;
			
			if (field[x][y] == 1)
			{
				field[x][y] = 2;
				alive--;
			}
			return true;
		}
	}
	
	public boolean checkVictory()
	{
		if (alive == 0)
			return true;
		else
			return false;
	}
	
	public int[][] getField(){
		return field;
	}
	
        public boolean[][] getShooted(){
                return shooted; 
        }
                
	public boolean getShooted(int x, int y){
		return shooted[x][y];
	}
	
	public int getStatus(int x, int y){
		return field[x][y];
	}
	
	public int getSize(){
		return size;
	}
}

