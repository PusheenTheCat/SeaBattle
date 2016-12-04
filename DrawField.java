import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public final class DrawField extends JPanel
{
    private int size = 25;
    
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 255, 255);
        g.setColor(Color.GRAY);
        for (int i = 0; i < 11; i++)
        {
            g.drawLine(i*size, 0, i*size, size*10); //вертикальные линии
            g.drawLine(0, i*size, size*10, i*size); //горизонтальные линии
        }  
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(3.0f));
        g2D.setColor(Color.BLACK);
        g2D.drawLine(0, 0, size*10, 0);
        g2D.drawLine(0, 0, 0, size*10);
        g2D.drawLine(size*10, 0, size*10, size*10);
        g2D.drawLine(0, size*10, size*10, size*10);   
    }
    
    public int getSz(){
        return size;
    }
}
