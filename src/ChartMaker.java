import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

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

        //draw borders
        g.setColor(Color.GRAY);
        g.drawLine(originPoint.x - padding, originPoint.y + padding, originPoint.x + xLength + padding, originPoint.y + padding);                       //down-base
        g.drawLine(originPoint.x - padding, originPoint.y + padding, originPoint.x - padding, originPoint.y - yLength - padding);                       //left-wall
        g.drawLine(originPoint.x + xLength + padding, originPoint.y + padding, originPoint.x + xLength + padding, originPoint.y - yLength - padding);   //right-wall
        g.drawLine(originPoint.x - padding, originPoint.y - yLength - padding, originPoint.x + xLength + padding, originPoint.y - yLength - padding);   //top-base

        //draw x axis
        g.setColor(Color.RED);
        g.drawLine(originPoint.x, originPoint.y, originPoint.x + xLength, originPoint.y);

        //draw y axis
        g.setColor(Color.BLUE);
        g.drawLine(originPoint.x, originPoint.y, originPoint.x, originPoint.y - yLength);
        
        //draw points
        g.setColor(Color.BLACK);
        for (Point point : points) {
            g.drawOval(point.x-2, point.y-2, 4, 4);
        }
    }
}
