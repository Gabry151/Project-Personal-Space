import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class DataPanel extends JPanel {
    InputField name = new InputField("Name", 20);
    InputField surname = new InputField("Surname", 20);
    InputField nickname = new InputField("Nickname", 20);
    
    public DataPanel(){
        set();
    }

    private void set(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        add(name);
        add(surname);
        add(nickname);
    }
}
