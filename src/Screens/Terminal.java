package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Terminal extends JPanel {
    String commands;
    JTextField terminal;
    Home home;
    public Terminal(Home home) {
        this.home = home;

        this.setBackground(Color.black);

        Font terminalfont = new Font("DialogInput",Font.BOLD,20);
        JLabel inputDecorator = new JLabel(">>");
        inputDecorator.setFont(terminalfont);
        inputDecorator.setForeground(Color.GREEN);
        this.add(inputDecorator);

        terminal = new JTextField(20);
        terminal.setEditable(true);
        terminal.setFont(terminalfont);
        terminal.setCaretColor(Color.green);
        terminal.setBackground(Color.black);
        terminal.setForeground(Color.GREEN);
        terminal.setHorizontalAlignment(SwingConstants.LEFT);

        terminal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                System.out.println(e.getKeyCode());

                if (e.getKeyCode() == 10 ) {
                    home.sendCommand(terminal.getText());
                    System.out.println("Command = " + terminal.getText());
                    terminal.setText("");
                }
            }
        });

        this.add(terminal);
    }

    public String getText() {
        return terminal.getText();
    }
}
