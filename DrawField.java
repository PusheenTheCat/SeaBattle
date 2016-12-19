import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public final class DrawField extends JPanel
{
    private int size = 25;
    private int[][] field;
    private boolean[][] shooted;
    
    public DrawField(int[][] field, boolean[][] shooted)
    {
        this.field = field;
        this.shooted = shooted;
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(1.0f));
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 255, 255);
        
        g.setColor(Color.GRAY);
        for (int i = 0; i < 11; i++)
        {
            g.drawLine(i*size, 0, i*size, size*10); //вертикальные линии
            g.drawLine(0, i*size, size*10, i*size); //горизонтальные линии
        }  

        g2D.setStroke(new BasicStroke(4.0f));
        g2D.setColor(Color.BLACK);
        
        g2D.drawLine(0, 0, size*10, 0);
        g2D.drawLine(0, 0, 0, size*10);
        g2D.drawLine(size*10, 0, size*10, size*10);
        g2D.drawLine(0, size*10, size*10, size*10);   
        
        g2D.setStroke(new BasicStroke(2.0f));
        for (int i = 0; i < field.length; i++)
            for (int j =0; j < field.length; j++)
            {
                if (shooted[i][j])
                {
                    if (field[i][j] == 0)
                    {
                        g.setColor(Color.BLUE);
                        g.fillOval(i*25+10, j*25+10, 4, 4);
                    }
                    else
                    {
                        g.setColor(Color.RED);
                        g.drawLine(i*25, j*25, (i+1)*25, (j+1)*25);
                        g.drawLine(i*25, (j+1)*25, (i+1)*25, j*25);
                    }
                }
            }
        g.setColor(Color.BLACK);
    }
    
    public int getSz(){
        return size;
    }
}
