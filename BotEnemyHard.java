import java.awt.*;
import java.util.Random;

public class BotEnemyHard implements Bot
{
	private int x = 3, y = 0;
	boolean linkor = false;
	boolean cruiser = false;
	boolean injured = false;
    boolean stop;
    private Graphics g;
    Graphics2D g2d;
    private Field f;
    public enum Direction {UP, DOWN, LEFT, RIGHT}
    Direction d = Direction.DOWN;

    public BotEnemyHard(Graphics g, Field f) {
        this.g = g;
        this.f = f;
        g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(2.0f));
    }

	private void findLinkor()
	{
		while (f.getShooted(x, y) != false)
		{
			x += 4;
			if (x > 9)
			{
				y++;
				x -= 9;
                if (y == 10) {
                    linkor = true;
                    x = 1;
                    y = 0;
                    return;
                }
			}
		}


		f.doShot(x, y);

		if (f.getStatus(x, y) == 0) {
            g2d.setColor(Color.BLUE);
            g2d.fillOval(x*25+10, y*25+10, 4, 4);
            injured = false;
            stop = true;
        }
		else {
            g2d.setColor(Color.RED);
            g2d.drawLine(x*25, y*25, (x+1)*25, (y+1)*25);
            g2d.drawLine(x*25, (y+1)*25, (x+1)*25, y*25);
            if (f.checkKilled(x, y) == false)
                injured = true;
        }
	}

    private void findCruiser()
    {
        while (f.getShooted(x, y) != false)
        {
            x += 4;
            if (x > 9)
            {
                y++;
                x -= 9;
                if (y == 10) {
                    cruiser = true;
                    return;
                }
            }
        }

        f.doShot(x, y);

        if (f.getStatus(x, y) == 0) {
            g2d.setColor(Color.BLUE);
            g2d.fillOval(x*25+10, y*25+10, 4, 4);
            injured = false;
            stop = true;
        }
        else {
            g2d.setColor(Color.RED);
            g2d.drawLine(x*25, y*25, (x+1)*25, (y+1)*25);
            g2d.drawLine(x*25, (y+1)*25, (x+1)*25, y*25);
            if (f.checkKilled(x,y) == false)
                injured = true;
        }
    }

    private void simpleShot() {
        final Random random = new Random();
            do {
                x = random.nextInt(10);
                y = random.nextInt(10);
            } while (f.getShooted(x, y));
          f.doShot(x, y);

        if (f.getStatus(x, y) == 0) {
            g2d.setColor(Color.BLUE);
            g2d.fillOval(x*25+10, y*25+10, 4, 4);
            injured = false;
            stop = true;
        }
        else {
            g2d.setColor(Color.RED);
            g2d.drawLine(x*25, y*25, (x+1)*25, (y+1)*25);
            g2d.drawLine(x*25, (y+1)*25, (x+1)*25, y*25);
            if (f.checkKilled(x,y) == false)
                injured = true;
        }
    }
	
	public void shootDown(int y2) {
		if (y2 == 9)
		{
			shootUp(y);
			return;
		}
		y2++;
		if (f.getShooted(x, y2) == false)
		{
			f.doShot(x, y2);
			if (f.getStatus(x, y2) != 0) {
                g2d.setColor(Color.RED);
                g2d.drawLine(x * 25, y2 * 25, (x + 1) * 25, (y2 + 1) * 25);
                g2d.drawLine(x * 25, (y2 + 1) * 25, (x + 1) * 25, y2 * 25);
                if (f.checkKilled(x, y2) == true) {
                    injured = false;
                    return;
                } else
                    shootDown(y2);
            }
			else
			{
                g2d.setColor(Color.BLUE);
                g2d.fillOval(x*25+10, y2*25+10, 4, 4);
				d = Direction.UP;
                stop = true;
				return;
			}
		}
        else
        if (f.checkKilled(x, y) == false)
        {
            if (f.getStatus(x, y2) != 0)
              shootDown(y2);
            else
              shootUp(y);
        }
	}

    public void shootUp(int y2) {
        if (y2 == 0)
        {
            shootLeft(x);
            return;
        }
        y2--;
        if (f.getShooted(x, y2) == false)
        {
            f.doShot(x, y2);
            if (f.getStatus(x, y2) != 0) {
                g2d.setColor(Color.RED);
                g2d.drawLine(x * 25, y2 * 25, (x + 1) * 25, (y2 + 1) * 25);
                g2d.drawLine(x * 25, (y2 + 1) * 25, (x + 1) * 25, y2 * 25);
                if (f.checkKilled(x, y2) == true) {
                    injured = false;
                    d = Direction.DOWN;
                    return;
                } else
                    shootUp(y2);
            }
            else
            {
                g2d.setColor(Color.BLUE);
                g2d.fillOval(x*25+10, y2*25+10, 4, 4);
                d = Direction.LEFT;
                stop = true;
                return;
            }
        }
        else
        if (f.checkKilled(x, y) == false)
        {
            if (f.getStatus(x, y2) != 0)
                shootUp(y2);
            else
                shootLeft(x);
        }
    }

    public void shootLeft(int x2) {
        if (x2 == 0)
        {
            shootRight(x);
            return;
        }
        x2--;
        if (f.getShooted(x2, y) == false)
        {
            f.doShot(x2, y);
            if (f.getStatus(x2, y) != 0) {
                g2d.setColor(Color.RED);
                g2d.drawLine(x2 * 25, y * 25, (x2 + 1) * 25, (y + 1) * 25);
                g2d.drawLine(x2 * 25, (y + 1) * 25, (x2 + 1) * 25, y * 25);
                if (f.checkKilled(x2, y) == true) {
                    injured = false;
                    d = Direction.DOWN;
                    return;
                } else
                    shootLeft(x2);
            }
            else
            {
                g2d.setColor(Color.BLUE);
                g2d.fillOval(x2*25+10, y*25+10, 4, 4);
                d = Direction.RIGHT;
                stop = true;
                return;
            }
        }
        else
        if (f.checkKilled(x, y) == false)
        {
            if (f.getStatus(x2, y) != 0)
                shootLeft(x2);
            else
                shootRight(x);
        }
    }

    public void shootRight(int x2) {
        if (x2 == 9)
        {
            shootRight(x);
            return;
        }
        x2++;
        if (f.getShooted(x2, y) == false)
        {
            f.doShot(x2, y);
            if (f.getStatus(x2, y) != 0) {
                g2d.setColor(Color.RED);
                g2d.drawLine(x2 * 25, y * 25, (x2 + 1) * 25, (y + 1) * 25);
                g2d.drawLine(x2 * 25, (y + 1) * 25, (x2 + 1) * 25, y * 25);
                if (f.checkKilled(x2, y) == true) {
                    injured = false;
                    d = Direction.DOWN;
                    return;
                } else
                    shootLeft(x2);
            }
            else
            {
                g2d.setColor(Color.BLUE);
                g2d.fillOval(x2*25+10, y*25+10, 4, 4);
                d = Direction.DOWN;
                stop = true;
                return;
            }
        }
        else
        if (f.checkKilled(x, y) == false)
        {
            if (f.getStatus(x2, y) != 0)
                shootRight(x2);
            else
                shootDown(y);
        }

    }
	
	public void enemyShot() {
        stop = false;
        while ((stop == false) && (f.checkVictory() != true)) {
            if (injured == true) {
                switch (d) {
                    case DOWN: {
                        shootDown(y);
                        break;
                    }
                    case UP: {
                        shootUp(y);
                        break;
                    }
                    case LEFT: {
                        shootLeft(x);
                        break;
                    }
                    case RIGHT: {
                        shootRight(x);
                        break;
                    }
                }
                continue;
            }

            if (linkor == false) {
                findLinkor();
                continue;
            }

            if (cruiser == false) {
                findCruiser();
                continue;
            }

            simpleShot();
        }
    }
}
