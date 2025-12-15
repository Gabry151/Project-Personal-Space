import javax.swing.*;
import java.awt.*;


public class SpacePanel extends JPanel {
    public SpacePanel(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout());
    }
}
