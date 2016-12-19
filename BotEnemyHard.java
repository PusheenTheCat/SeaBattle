import java.awt.Graphics;
/*
public class BotEnemyHard implements Bot
{
	private int x = 3, y = 0;
	boolean linkor = false;
	boolean k1, k2;
	boolean injured = false;
	
	private void findLinkor(Field f)
	{
		x = 3;
		y = 0;
		
		while (f.getShooted(x, y) != true)
		{
			x += 4;
			if (x > 9)
			{
				y += 1;
				x -= 9;
			}
		}
		
		f.doShot(x, y);
		
		if (f.getStatus(x, y) == 0)
			injured = false;
		else
			injured = true;
	}
	
	private boolean killFinder(Field f)
	{
		if (y > 0)
		{
			if f.getShooted()
			int j = y;
			while (f.getStatus(x, j) == false)
			{
				
			}
			
			if (f.getShooted(x, y-1) == false)
			{
				f.doShot(x, y-1);
				if (f.getStatus(x, y-1) != 0)
				{
					if (f.checkKilled(x, y-1) == true)
						injured = false;
					else
						y -= 1;
				}
			}
		}
		
        
	}
	
	public void shootDown(int y2) {
		if (y2 == 9)
		{
			shootUp(y);
			return;
		}
		y2--;
		if (f.getShooted(x, y2) == false)
		{
			f.doShot(x, y2);
			if (f.getStatus(x, y2) != 0)
				if (f.checkKilled(x, y2) == true)
				{
					injured = false;
					return;
				}	
				else
					shootDown(y2);
			else
			{
				shootUp(y);
				return;
			}
		}	
				
	}
	
	public void enemyShot(Graphics g, Field f)
	{
		if (injured == true)
		{
			if (f.checkKilled(x, y))
			{
				injured = false;
			}
		}
		
		if (linkor == false)
		{
			
		}
	}
}
*/