import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class DataPanel extends JPanel {
    InputField name;
    InputField surname;
    InputField nickname;
    
    public DataPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        name = new InputField("Name", 20);
        surname = new InputField("Surname", 20);
        nickname = new InputField("Nickname", 20);

        add(name);
        add(surname);
        add(nickname);
    }
}
