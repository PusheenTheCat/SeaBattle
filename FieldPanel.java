import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class FieldPanel extends JPanel
{
	final int size = 25;
	private int[][] field;
	private boolean[][] shooted;
	private boolean enemy;
	private int l;
	private UserPutShip ups;
	private Field f;
	
	public void setField(int[][] field, boolean[][] shooted, boolean enemy)
	{
		this.enemy = enemy;
		this.field = field;
        this.shooted = shooted;
        l = -1;
	}
	
	public void setField(Field f, boolean[][] shooted, boolean enemy, int l, UserPutShip ups)
	{
		this.enemy = enemy;
		this.f = f;
		this.field = f.getField();
        this.shooted = shooted;
        this.l = l;
        this.ups = ups;
	}
	
	@Override
	public void paint(Graphics g){ 
        DrawField df = new DrawField(field, shooted);
        df.paint(g);
        
        if (enemy == false)
        {
	        Graphics2D g2D = (Graphics2D)g;      
	        g2D.setStroke(new BasicStroke(2.0f));
	        
	        for (int i = 0; i < field.length; i++)
	            for (int j = 0; j < field[i].length; j++)
	            {
	                if (field[i][j] == 1 || field[i][j] == 2)
	                {
	                    if (j > 0 && field[i][j-1] == 0)
	                        g2D.drawLine(i*df.getSz(), j*df.getSz(), i*df.getSz()+df.getSz(), j*df.getSz());
	                    if (i > 0 && field[i-1][j] == 0)
	                        g2D.drawLine(i*df.getSz(), j*df.getSz(), i*df.getSz(), j*df.getSz()+df.getSz());
	                    if (j < 9 && field[i][j+1] == 0)
	                        g2D.drawLine(i*df.getSz(), j*df.getSz()+df.getSz(), i*df.getSz()+df.getSz(), j*df.getSz()+df.getSz());
	                    if (i < 9 && field[i+1][j] == 0)
	                        g2D.drawLine(i*df.getSz()+df.getSz(), j*df.getSz(), i*df.getSz()+df.getSz(), j*df.getSz()+df.getSz());  
	                }
	            }
	       
	      if (l != -1)  
	        ups.DrawShip(g, f);
         }
    }
}

