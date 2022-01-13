package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
 
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
 
public class ComboRender extends JLabel implements ListCellRenderer<Object> {
 
    public ComboRender() {
        setOpaque(true);
        setFont(new Font("Arial", Font.BOLD, 14));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
    }
     
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.toString());
        return this;
    }
 
}