import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static jdk.nashorn.internal.objects.ArrayBufferView.buffer;

public class NewJFrame extends javax.swing.JFrame {

    public NewJFrame() { 
        initComponents();
        btnUp.setVisible(false);
        btnDown.setVisible(false);
        btnLeft.setVisible(false);
        btnRight.setVisible(false);
        btnSpace.setVisible(false);
        btnEnter.setVisible(false);
        jEnemyField.setVisible(false);

        jPanel4.setVisible(false);
        jBtnNewGame.setEnabled(false);
    }
        
    private void initComponents() {
    	
        jDialogWin = new javax.swing.JDialog();
        label4 = new java.awt.Label();
        jButtonClose = new javax.swing.JButton();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jBtnSetAuto = new javax.swing.JButton();
        jBtnSetHand = new javax.swing.JButton();
        btnLeft = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnSpace = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();
        jMyField = new FieldPanel();
        jPanel3 = new javax.swing.JPanel();
        jBtnNewGame = new javax.swing.JButton();
        jBtnEndGame = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jTextField1 = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jEnemyField = new FieldPanel();

        jMyField.setField(f.getField(), f.getShooted(), false);
        jEnemyField.setField(f2.getField(), f2.getShooted(), true);
        
        jDialogWin.setResizable(false);
        jDialogWin.setSize(new java.awt.Dimension(200, 115));

        label4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label4.setText("label4");

        jButtonClose.setText("Продолжить");
        jButtonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jDialogWinLayout = new javax.swing.GroupLayout(jDialogWin.getContentPane());
        jDialogWin.getContentPane().setLayout(jDialogWinLayout);
        jDialogWinLayout.setHorizontalGroup(
            jDialogWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogWinLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jDialogWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogWinLayout.createSequentialGroup()
                        .addComponent(jButtonClose)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogWinLayout.createSequentialGroup()
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jDialogWinLayout.setVerticalGroup(
            jDialogWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogWinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClose)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jBtnSetAuto.setBackground(new java.awt.Color(52, 142, 249));
        jBtnSetAuto.setForeground(new java.awt.Color(255, 255, 255));
        jBtnSetAuto.setText("Автоматическое заполнение");
        jBtnSetAuto.setToolTipText("");
        jBtnSetAuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnSetAutoMouseClicked(evt);
            }
        });

        jBtnSetHand.setBackground(new java.awt.Color(52, 142, 249));
        jBtnSetHand.setForeground(new java.awt.Color(255, 255, 255));
        jBtnSetHand.setText("Ручное заполнение");
        jBtnSetHand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnSetHandMouseClicked(evt);
            }
        });

        //btnLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left.jpg"))); // NOI18N
        btnLeft.setPreferredSize(new java.awt.Dimension(24, 23));
        btnLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLeftMouseClicked(evt);
            }
        });

        //btnDown.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("C:/Users/User274/Desktop/Универ/ООП/OceanBattle/src/down.jpg"))); // NOI18N
        btnDown.setPreferredSize(new java.awt.Dimension(24, 23));
        btnDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDownMouseClicked(evt);
            }
        });

        //btnRight.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("C:/Users/User274/Desktop/Универ/ООП/OceanBattle/src/right.jpg"))); // NOI18N
        btnRight.setPreferredSize(new java.awt.Dimension(24, 23));
        btnRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRightMouseClicked(evt);
            }
        });

        //btnUp.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("C:/Users/User274/Desktop/Универ/ООП/OceanBattle/src/up.jpg"))); // NOI18N
        btnUp.setPreferredSize(new java.awt.Dimension(24, 23));
        btnUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpMouseClicked(evt);
            }
        });

        //btnSpace.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("C:/Users/User274/Desktop/Универ/ООП/OceanBattle/src/Space.jpg"))); // NOI18N
        btnSpace.setPreferredSize(new java.awt.Dimension(33, 23));
        btnSpace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSpaceMouseClicked(evt);
            }
        });

        //btnEnter.setIcon(new javax.swing.ImageIcon(getClass().getResource("C:/Users/User274/Desktop/Универ/ООП/OceanBattle/src/Enter.jpg"))); // NOI18N
        btnEnter.setPreferredSize(new java.awt.Dimension(60, 23));
        btnEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnSetAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnSetHand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(btnRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSpace, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jBtnSetAuto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnSetHand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSpace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jMyField.setBackground(new java.awt.Color(255, 255, 255));
        jMyField.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout jMyFieldLayout = new javax.swing.GroupLayout(jMyField);
        jMyField.setLayout(jMyFieldLayout);
        jMyFieldLayout.setHorizontalGroup(
            jMyFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jMyFieldLayout.setVerticalGroup(
            jMyFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        jBtnNewGame.setLabel("Начать игру");
        jBtnNewGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnNewGameMouseClicked(evt);
            }
        });

        jBtnEndGame.setLabel("Отключиться");
        jBtnEndGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnEndGameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnEndGame)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnEndGame, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnNewGame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(215, 215, 215));

        label1.setText("Ваше имя:");

        jTextField1.setForeground(new java.awt.Color(0, 153, 255));
        jTextField1.setText("Anonym");

        label2.setText("ip противника:");

        jButton3.setText("Отправить приглашение");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3))
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label1.getAccessibleContext().setAccessibleDescription("");

        jEnemyField.setBackground(new java.awt.Color(255, 255, 255));
        jEnemyField.setPreferredSize(new java.awt.Dimension(250, 250));
        jEnemyField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					jEnemyFieldMouseClicked(evt);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jEnemyFieldMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jEnemyFieldLayout = new javax.swing.GroupLayout(jEnemyField);
        jEnemyField.setLayout(jEnemyFieldLayout);
        jEnemyFieldLayout.setHorizontalGroup(
            jEnemyFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jEnemyFieldLayout.setVerticalGroup(
            jEnemyFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jMyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEnemyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jEnemyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }                       
 
    private void jBtnSetAutoMouseClicked(java.awt.event.MouseEvent evt) {                                      
        btnUp.setVisible(false);
        btnDown.setVisible(false);
        btnLeft.setVisible(false);
        btnRight.setVisible(false);
        btnSpace.setVisible(false);
        btnEnter.setVisible(false);
        
        Graphics g = jMyField.getGraphics();
        f = new Field();
        f.setAuto();
        
        drawShips(f);
        
        jMyField.setField(f.getField(), f.getShooted(), false);
        jBtnNewGame.setEnabled(true);
        l = -1;
    }                                     

    private void jBtnSetHandMouseClicked(java.awt.event.MouseEvent evt) {                                      
        btnUp.setVisible(true);
        btnDown.setVisible(true);
        btnLeft.setVisible(true);
        btnRight.setVisible(true);
        btnSpace.setVisible(true);
        btnEnter.setVisible(true);
        
        Graphics g = jMyField.getGraphics();  
        saved = null;
        saved = buffer.getGraphics();
        
        f = new Field();
        drawShips(f);
        l = 3;
        count = 1;
        ups = new UserPutShip(0, l, 0, 0);
        ups.DrawShip(saved, f);
        g.drawImage(buffer, 0, 0, null);
    }                                     

    public void drawShips(Field f)
    {
        Graphics g = jMyField.getGraphics();
        saved = null;
        saved = buffer.getGraphics();
        Graphics2D g2D = (Graphics2D)saved;
        saved.clearRect(0, 0, 255, 255);        
        
        DrawField df = new DrawField(f.getField(), f.getShooted());
        df.paint(saved);
        int[][] field = f.getField();
        
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
        g.drawImage(buffer, 0, 0, null);
    }
    
    public void drawShot(Graphics g)
    {
        saved = buffer.getGraphics();
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(2.0f)); 
        
        DrawField df = new DrawField(f2.getField(), f2.getShooted());
        df.paint(saved);

        boolean flag = f2.doShot(mouseX, mouseY);
        jTextField2.setText(mouseX + " " + mouseY + "!!!");
        if (flag == true && f2.getStatus(mouseX, mouseY) == 2)
        {
            g.setColor(Color.RED);
            g.drawLine(mouseX*25, mouseY*25, (mouseX+1)*25, (mouseY+1)*25);
            g.drawLine(mouseX*25, (mouseY+1)*25, (mouseX+1)*25, mouseY*25);
            g.setColor(Color.BLACK);
        }
        else
        {    
            g.setColor(Color.BLUE);
            g.fillOval(mouseX*25+10, mouseY*25+10, 4, 4);
            g.setColor(Color.BLACK);
        }   
        
        g = jEnemyField.getGraphics(); 
        if (flag)
            if (f2.checkKilled(mouseX, mouseY))
            {
                df = new DrawField(f2.getField(), f2.getShooted());
                df.paint(g);
            }
    }
    
    private void btnUpMouseClicked(java.awt.event.MouseEvent evt) {                                   
        Graphics g = jMyField.getGraphics();
        saved = null;
        saved = buffer.getGraphics();
        ups.moveUp();
        drawShips(f);
        ups.DrawShip(saved, f);
        g.drawImage(buffer, 0, 0, null);
    }                                  

    private void btnLeftMouseClicked(java.awt.event.MouseEvent evt) {                                     
        Graphics g = jMyField.getGraphics();
        saved = null;
        saved = buffer.getGraphics();
        ups.moveLeft();
        drawShips(f);
        ups.DrawShip(saved, f);
        g.drawImage(buffer, 0, 0, null);
    }                                    

    private void btnDownMouseClicked(java.awt.event.MouseEvent evt) {                                     
        Graphics g = jMyField.getGraphics();
        saved = null;
        saved = buffer.getGraphics();
        ups.moveDown();
        drawShips(f);
        ups.DrawShip(saved, f);
        g.drawImage(buffer, 0, 0, null);
    }                                    

    private void btnRightMouseClicked(java.awt.event.MouseEvent evt) {                                      
        Graphics g = jMyField.getGraphics();
        saved = null;
        saved = buffer.getGraphics();
        ups.moveRight();
        drawShips(f);
        ups.DrawShip(saved, f);
        g.drawImage(buffer, 0, 0, null);
    }                                     

    private void btnSpaceMouseClicked(java.awt.event.MouseEvent evt) {                                      
        Graphics g = jMyField.getGraphics();
        saved = null;
        saved = buffer.getGraphics();
        ups.rotate();
        drawShips(f);
        ups.DrawShip(saved, f);
        g.drawImage(buffer, 0, 0, null);
    }                                     

    private void btnEnterMouseClicked(java.awt.event.MouseEvent evt) {                                      
        Graphics g = jMyField.getGraphics();
        saved = null;
        saved = buffer.getGraphics();
        
            if ((l > -1) && (ups.ifEmpty(f))) 
            {   
             ups.put(f);
             drawShips(f);
             count--;
             if (count ==0)
              {
                 l--;
                 count = 4-l;
              }
             if (l != -1)
              {
                 ups = new UserPutShip(0, l, 0, 0);
                 ups.DrawShip(saved, f);
                 jMyField.setField(f, f.getShooted(), false, l, ups);
              }
             g.drawImage(buffer, 0, 0, null);
            }
            if (l == -1)
            {
                jBtnNewGame.setEnabled(true);
                btnUp.setVisible(false);
                btnDown.setVisible(false);
                btnLeft.setVisible(false);
                btnRight.setVisible(false);
                btnSpace.setVisible(false);
                btnEnter.setVisible(false); 
                l--;
            }
    }                                     
    
    private void jEnemyFieldMouseClicked(java.awt.event.MouseEvent evt) throws InterruptedException {   
    	Bot b = new BotEnemyLight();
        do{
            mouseX = evt.getX()/25;
            mouseY = evt.getY()/25;

            boolean shot = false;
            if (f2.getShooted(mouseX, mouseY) == false)
                shot = true;

            if (shot == true)
            {               
            	Graphics g = jEnemyField.getGraphics();
            	drawShot(g);
            	
                if (f2.getStatus(mouseX, mouseY) == 0)
                {
                	g = jMyField.getGraphics();
                	b.enemyShot(g, f);
                	drawShips(f);
                	jMyField.setField(f.getField(), f.getShooted(), false);
                }   
            }
            
        
        jEnemyField.setField(f2.getField(), f2.getShooted(), true);
            
        }while (f2.checkVictory() && f.checkVictory());
        
        if (f2.checkVictory())
        {
            jBtnNewGame.setEnabled(true);
            label4.setText("Вы выиграли!");
            jDialogWin.setVisible(true);
        }
        else if (f.checkVictory())
        {
            jBtnNewGame.setEnabled(true);
            label4.setText("Вы проиграли!");
            jDialogWin.setVisible(true);
        }
    }                                    

    private void jBtnNewGameMouseClicked(java.awt.event.MouseEvent evt) {                                      
        jBtnNewGame.setEnabled(false);
        jPanel1.setVisible(false);
        jEnemyField.setVisible(true);
        jBtnEndGame.setEnabled(true);
        
        f2 = new Field();
        f2.setAuto();
        
        jMyField.setField(f.getField(), f.getShooted(), false);
        jEnemyField.setField(f2.getField(), f2.getShooted(), true);
        
        jMyField.repaint();
        jEnemyField.repaint();
           
        DrawField df = new DrawField(f2.getField(), f2.getShooted());
        df.paint(jEnemyField.getGraphics());    
    }                                     

    private void jButtonCloseMouseClicked(java.awt.event.MouseEvent evt) {                                          
        jDialogWin.setVisible(false);
        
        jBtnEndGameMouseClicked(evt); 
    }                                         

    private void jBtnEndGameMouseClicked(java.awt.event.MouseEvent evt) {                                      
        f = new Field();
        
        jPanel1.setVisible(true);
        jEnemyField.setVisible(false);
        
        jMyField.setField(f.getField(), f.getShooted(), false);
        jMyField.repaint();
        jBtnEndGame.setEnabled(false);
    }                                     

    private void jEnemyFieldMousePressed(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                NewJFrame frame = new NewJFrame();
                frame.setVisible(true);
            }
        });
    }

    private UserPutShip ups;
    private int l, count, mouseX, mouseY;
    private Field f = new Field(); 
    private Field f2 = new Field();
    private Graphics saved = null;
    private BufferedImage buffer = new BufferedImage(250, 250, BufferedImage.TYPE_INT_RGB);
                      
    private javax.swing.JButton btnDown, btnLeft, btnRight, btnSpace, btnUp, btnEnter;
    private javax.swing.JButton jBtnSetAuto, jBtnSetHand;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jBtnNewGame, jBtnEndGame, jButtonClose;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JDialog jDialogWin;
    private FieldPanel jMyField, jEnemyField;
    private javax.swing.JPanel jPanel1, jPanel3, jPanel4;
    private javax.swing.JTextField jTextField1, jTextField2;
    private java.awt.Label label1, label2, label4;               
}

