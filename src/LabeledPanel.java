import javax.swing.*;
import java.awt.*;


public class LabeledPanel extends JPanel {
    public LabeledPanel(String text, layoutType layout, JComponent[] components){
        setPanelContent(text, layout, components);
    }

    public LabeledPanel(int width, int height, String text, layoutType layout, JComponent[] components){
        setPreferredSize(new Dimension(width, height));
        setPanelContent(text, layout, components);
    }

    public void setPanelContent(String text, layoutType layout, JComponent[] components){
        switch (layout) {
            case horizontal:
                setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
                setAlignmentX(Component.CENTER_ALIGNMENT);
                break;
            case vertical:
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                setAlignmentX(Component.CENTER_ALIGNMENT);
                break;
            case flow:
                setLayout(new FlowLayout());
                break;
            default:
                break;
        }
        setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK, 1), text));

        for (Component component : components) {
            add(component);
        }
    }

    public enum layoutType{
        horizontal,
        vertical,
        flow,
    }
}
