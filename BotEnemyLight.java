import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BotEnemyLight implements Bot
{
    Graphics g;
    Field f;

    public BotEnemyLight(Graphics g, Field f){
        this.g = g;
        this.f = f;
    }
    public void enemyShot()

    {
        final Random random = new Random();
        int x, y;
        do{
            do{
                x = random.nextInt(10);
                y = random.nextInt(10);
            }while(f.getShooted(x, y));

            //saved = buffer.getGraphics();

            DrawField df = new DrawField(f.getField(), f.getShooted());
            df.paint(g);

            boolean flag = f.doShot(x, y);

            if (flag == true && f.getStatus(x, y) == 2)
            {
                g.setColor(Color.RED);
                g.drawLine(x*25, y*25, (x+1)*25, (y+1)*25);
                g.drawLine(x*25, (y+1)*25, (x+1)*25, y*25);
            }
            else
            {
                g.setColor(Color.BLUE);
                g.fillOval(x*25+10, y*25+10, 4, 4);
            }
            g.setColor(Color.BLACK);

            if (flag)
                if (f.checkKilled(x, y))
                {
                    df = new DrawField(f.getField(), f.getShooted());
                    df.paint(g);
                }
            g.setColor(Color.BLACK);
            if (f.getStatus(x, y) != 0)
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }while (f.getStatus(x, y) != 0 && f.checkVictory() != true);
    }
}
