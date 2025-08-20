package org.example.screensaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Component
public abstract class ColorFrame extends JWindow {
    @Autowired
    private Color color;

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(random.nextInt(dimension.width), random.nextInt(dimension.height));
        getContentPane().setBackground(getColor());
        repaint();
    }

    @Lookup("color")
    protected abstract Color getColor();
}
