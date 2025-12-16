import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class ChartMaker extends JPanel {
    final int defxLength = 5;
    final int defyLength = 5;
    final int padding = 25;

    Point originPoint = new Point(0, 0);
    int xLength = 200;
    int yLength = 200;
    List<Point> points = new ArrayList<>();
    List<Point> pointsPos = new ArrayList<>();

    int highestX = defxLength;
    int highestY = defxLength;

    public ChartMaker(Point origin, int xLength, int yLength){
        originPoint = origin;
        this.xLength = xLength;
        this.yLength = yLength;

        setPreferredSize(new Dimension(xLength +padding*2, yLength + padding*2));
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        setBackground(Color.WHITE);
    }

    public void addPoint(Point point){
        points.add(point);
        rebuildPoints();
    }

    private void paintPoint(Point point){
        pointsPos.add(getPos(point));
        repaint();
    }

    private void rebuildPoints() {

        pointsPos.clear();

        for (Point point : points) {
            paintPoint(point);
        }
    }

    private Point getPos(Point point){
        int tempxLenght = defxLength;
        if (points.size() > defxLength){
            tempxLenght = points.size();
        }

        // int tempyLenght = defyLength;
        // if (points.size() > defyLength) {
        //     tempyLenght = points.size();
        // }

        Point temp = new Point(
            (xLength * point.x) / tempxLenght,
            (yLength * point.y) / defyLength
        );

        return new Point(
            originPoint.x + temp.x,
            originPoint.y - temp.y
        );
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        //draw x axis
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(3));
        Point endAxis = new Point(originPoint.x + xLength, originPoint.y - yLength);
        g2d.drawLine(originPoint.x, originPoint.y, endAxis.x, originPoint.y);
                //arrow
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(endAxis.x - 3, originPoint.y + 3, endAxis.x +1, originPoint.y);
        g2d.drawLine(endAxis.x - 3, originPoint.y - 3, endAxis.x +1, originPoint.y);

        //draw y axis
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(originPoint.x, originPoint.y, originPoint.x, endAxis.y);
                // arrow
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(originPoint.x - 3, endAxis.y + 3, originPoint.x, endAxis.y - 1);
        g2d.drawLine(originPoint.x + 3, endAxis.y + 3, originPoint.x, endAxis.y - 1);
        
        //draw points
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        
        for (int i = 0; i < pointsPos.size(); i++){
            Point p = pointsPos.get(i);
            g2d.drawOval(p.x - 2, p.y - 2, 4, 4);
        }

        //draw lines
        g2d.setColor(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(1));

        for (int i = 1; i < pointsPos.size(); i++) {
            Point a = pointsPos.get(i - 1);
            Point b = pointsPos.get(i);
            g2d.drawLine(a.x, a.y, b.x, b.y);
        }

        //draw marker
        g2d.setColor(Color.GRAY);
        g2d.setStroke(new BasicStroke(1));
        
        if (pointsPos.size() < defxLength){
            for (int i = 1; i < defxLength; i++) {
                Point p = getPos(new Point(i%defxLength, 0));
                g2d.drawLine(p.x, originPoint.y - 5, p.x, originPoint.y + 5);
                //g2d.drawString(Integer.toString(i), p.x - 3, originPoint.y + 17);
            }
        }
        else{
            for (int i = 1; i < pointsPos.size(); i++) {
                Point p = pointsPos.get(i);
                g2d.drawLine(p.x, originPoint.y - 5, p.x, originPoint.y + 5);
                //g2d.drawString(Integer.toString(i), p.x - 3, originPoint.y + 17);
            }
        }

        for (int i = 1; i < defyLength; i++) {
            Point p = getPos(new Point(0, i % defxLength));
            g2d.drawLine(originPoint.x - 5, p.y, originPoint.x + 5, p.y);
            g2d.drawString(Integer.toString(i), originPoint.x - 12, p.y + 5);
        }
    }
}
