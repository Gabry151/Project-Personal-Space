import java.awt.*;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class ChartMaker extends JPanel {
    final int defxLength = 10;
    final int defyLength = 10;

    final int padding = 25;

    Point originPoint = new Point(0, 0);
    int xLength = 200;
    int yLength = 200;
    ArrayList<Point> points = new ArrayList<Point>();

    public ChartMaker(Point origin, int xLength, int yLength){
        originPoint = origin;
        this.xLength = xLength;
        this.yLength = yLength;

        setPreferredSize(new Dimension(xLength +padding*2, yLength + padding*2));
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    public void addPoint(Point point){
        Point temp = new Point(
            (xLength * point.x) / defxLength,
            (yLength * point.y) / defyLength
        );

        points.add(new Point(
            originPoint.x + temp.x,
            originPoint.y - temp.y
        ));
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        //draw x axis
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(originPoint.x, originPoint.y, originPoint.x + xLength, originPoint.y);

        //draw y axis
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(originPoint.x, originPoint.y, originPoint.x, originPoint.y - yLength);
        
        //draw points
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        
        for (int i = 0; i < points.size(); i++){
            Point p = points.get(i);
            g2d.drawOval(p.x - 2, p.y - 2, 4, 4);
        }

        for (int i = 1; i < points.size(); i++) {
            Point a = points.get(i - 1);
            Point b = points.get(i);
            g2d.drawLine(a.x, a.y, b.x, b.y);
        }
    }
}
