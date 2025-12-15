import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {

        //crea la finestra e imposta tutto
        JFrame frame = new JFrame("Personal Space");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        Gui gui = new Gui();

        frame.add(gui.mainMenu(), BorderLayout.NORTH);
        frame.add(gui.chartMenu(), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
