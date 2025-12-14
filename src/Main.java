import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) throws Exception {

        //crea la finestra e imposta tutto
        JFrame frame = new JFrame("Personal Space");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        Gui gui = new Gui();
        gui.mainMenu();
        frame.add(gui.mainMenu(), BorderLayout.NORTH);

        frame.setVisible(true);
    }
}
