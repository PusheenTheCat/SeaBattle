
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserPutShip
{
    private int x1, x2, y1, y2, o;

    public UserPutShip(int x1, int x2, int y1, int y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        o = 0;
    }

    public boolean moveLeft(){
        if (x1 > 0)
        {
            x1--;
            x2--;
            return true;
        }
        else
            return false;
    }

    public boolean moveRight(){
        if (x2 < 9)
        {
            x1++;
            x2++;
            return true;
        }
        else
            return false;
    }

    public boolean moveUp(){
        if (y1 > 0)
        {
            y1--;
            y2--;
            return true;
        }
        else
            return false;
    }

    public boolean moveDown(){
        if (y1 < 9)
        {
            y1++;
            y2++;
            return true;
        }
        else
            return false;
    }

    public boolean rotate(){
        int tmp;
        if (x2 == x1 && x1 + (y2-y1) < 10)
        {
            x2 = x1 + (y2-y1);
            y2 = y1;
            o = 0;
            return true;
        }
        if (y1 == y2 && y1 + (x2-x1) < 10)
        {
            o = 1;
            y2 = y1 + (x2-x1);
            x2 = x1;
            return true;
        }
        else
            return false;
    }

    public boolean put(Field f)
    {
        int l;
        if (y2-y1 != 0)
            l = y2-y1+1;
        else if (x2-x1 != 0)
            l = x2-x1+1;
        else
            l = 0;

        if (f.setHand(x1, y1, o, l))
        {
            if (x1 == x2 && y1 == y2)
            {
                f.putShip(l, x1, y1, Field.Orientation.HORIZONTAL);
                return true;
            }
            else
            {
                if (o == 1)
                {
                    f.putShip(l, x1, y1, Field.Orientation.HORIZONTAL);
                    return true;
                }
                else
                {
                    f.putShip(l, x1, y1, Field.Orientation.VERTICAL);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ifEmpty(Field f)
    {
        if (f.checkPlace(x1, y1) && f.checkPlace(x2, y2))
            return true;
        else
            return false;
    }

    public void DrawShip(Graphics g, Field f)
    {
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(2.0f));
        if (ifEmpty(f))
            g2D.setColor(new Color(71,155,255));
        else
            g2D.setColor(Color.RED);

        g2D.drawLine(x1*25, y1*25, (x2+1)*25, y1*25);
        g2D.drawLine(x1*25, (y2+1)*25, (x2+1)*25, (y2+1)*25);
        g2D.drawLine(x1*25, y1*25, x1*25, (y2+1)*25);
        g2D.drawLine((x2+1)*25, y1*25, (x2+1)*25, (y2+1)*25);

    }


}
