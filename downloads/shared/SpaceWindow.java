import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/** Technische Hilfsklasse für Mission Space. */
public class SpaceWindow {
    private JFrame frame;
    private SpacePanel panel;
    private volatile boolean links, rechts, oben, unten, leerzeichen, rTaste;

    public SpaceWindow(int width, int height, String title) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                frame = new JFrame(title);
                panel = new SpacePanel(width, height);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setContentPane(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.addKeyListener(new KeyAdapter() {
                    @Override public void keyPressed(KeyEvent e) { setKey(e.getKeyCode(), true); }
                    @Override public void keyReleased(KeyEvent e) { setKey(e.getKeyCode(), false); }
                });
                frame.setVisible(true);
                frame.requestFocus();
            });
        } catch (Exception e) { throw new RuntimeException("Fenster konnte nicht geöffnet werden.", e); }
    }
    private void setKey(int keyCode, boolean pressed) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT -> links = pressed;
            case KeyEvent.VK_RIGHT -> rechts = pressed;
            case KeyEvent.VK_UP -> oben = pressed;
            case KeyEvent.VK_DOWN -> unten = pressed;
            case KeyEvent.VK_SPACE -> leerzeichen = pressed;
            case KeyEvent.VK_R -> rTaste = pressed;
            default -> { }
        }
    }
    public boolean isOpen() { return frame != null && frame.isDisplayable(); }
    public boolean linksGedrueckt() { return links; }
    public boolean rechtsGedrueckt() { return rechts; }
    public boolean obenGedrueckt() { return oben; }
    public boolean untenGedrueckt() { return unten; }
    public boolean leerzeichenGedrueckt() { return leerzeichen; }
    public boolean rGedrueckt() { return rTaste; }
    public void beginFrame() { panel.clearScene(); }
    public void drawShip(double x,double y,String name,double treibstoff){ panel.ship=new ShipView(x,y,name,treibstoff); }
    public void drawPlanet(double x,double y,double radius,String name){ panel.planets.add(new PlanetView(x,y,radius,name)); }
    public void drawAsteroid(double x,double y,double radius){ panel.asteroids.add(new AsteroidView(x,y,radius)); }
    public void drawText(int x,int y,String text){ panel.texts.add(new TextView(x,y,text)); }
    public void endFrame(){ panel.repaint(); Toolkit.getDefaultToolkit().sync(); }
    public void pause(int milliseconds){ try{Thread.sleep(milliseconds);}catch(InterruptedException e){Thread.currentThread().interrupt();} }
    private static class SpacePanel extends JPanel {
        private final int worldWidth,worldHeight; private ShipView ship;
        private final List<PlanetView> planets=new ArrayList<>();
        private final List<AsteroidView> asteroids=new ArrayList<>();
        private final List<TextView> texts=new ArrayList<>();
        SpacePanel(int width,int height){worldWidth=width;worldHeight=height;setPreferredSize(new Dimension(width,height));setBackground(new Color(5,11,22));setDoubleBuffered(true);}
        void clearScene(){ship=null;planets.clear();asteroids.clear();texts.clear();}
        @Override protected void paintComponent(Graphics g){super.paintComponent(g);Graphics2D g2=(Graphics2D)g.create();g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);drawStarField(g2);for(PlanetView p:planets)drawPlanetShape(g2,p);for(AsteroidView a:asteroids)drawAsteroidShape(g2,a);if(ship!=null)drawShipShape(g2,ship);g2.setFont(new Font(Font.MONOSPACED,Font.PLAIN,14));g2.setColor(new Color(220,240,250));for(TextView t:texts)g2.drawString(t.text,t.x,t.y);g2.dispose();}
        private void drawStarField(Graphics2D g2){g2.setColor(new Color(120,160,190));for(int i=0;i<75;i++){int x=(i*97+41)%worldWidth,y=(i*53+17)%worldHeight,r=(i%5==0)?2:1;g2.fillOval(x,y,r,r);}}
        private void drawShipShape(Graphics2D g2,ShipView s){int x=(int)Math.round(s.x),y=(int)Math.round(s.y);Polygon body=new Polygon(new int[]{x,x-15,x-10,x+10,x+15},new int[]{y-24,y+13,y+20,y+20,y+13},5);g2.setColor(new Color(90,220,235));g2.fillPolygon(body);g2.setColor(Color.WHITE);g2.drawPolygon(body);g2.setColor(new Color(15,45,65));g2.fillOval(x-6,y-8,12,12);g2.setColor(new Color(255,175,70));g2.fillPolygon(new Polygon(new int[]{x-7,x,x+7},new int[]{y+20,y+34,y+20},3));g2.setColor(Color.WHITE);g2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));g2.drawString(s.name+"  "+String.format("%.1f",s.treibstoff)+"%",x+20,y-8);}
        private void drawPlanetShape(Graphics2D g2,PlanetView p){int r=(int)Math.round(p.radius),x=(int)Math.round(p.x-r),y=(int)Math.round(p.y-r);g2.setColor(new Color(85,105,190));g2.fillOval(x,y,2*r,2*r);g2.setColor(new Color(170,190,255));g2.drawOval(x,y,2*r,2*r);g2.setColor(new Color(220,230,255));g2.drawString(p.name,x,y-6);}
        private void drawAsteroidShape(Graphics2D g2,AsteroidView a){int r=(int)Math.round(a.radius),x=(int)Math.round(a.x),y=(int)Math.round(a.y);Polygon rock=new Polygon(new int[]{x-r,x-r/2,x+r/3,x+r,x+r/2,x-r/3},new int[]{y,y-r,y-r/2,y+r/4,y+r,y+r/2},6);g2.setColor(new Color(115,120,130));g2.fillPolygon(rock);g2.setColor(new Color(190,195,205));g2.drawPolygon(rock);}
    }
    private static class ShipView{final double x,y,treibstoff;final String name;ShipView(double x,double y,String name,double treibstoff){this.x=x;this.y=y;this.name=name;this.treibstoff=treibstoff;}}
    private static class PlanetView{final double x,y,radius;final String name;PlanetView(double x,double y,double radius,String name){this.x=x;this.y=y;this.radius=radius;this.name=name;}}
    private static class AsteroidView{final double x,y,radius;AsteroidView(double x,double y,double radius){this.x=x;this.y=y;this.radius=radius;}}
    private static class TextView{final int x,y;final String text;TextView(int x,int y,String text){this.x=x;this.y=y;this.text=text;}}
}
