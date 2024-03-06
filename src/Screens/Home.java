package Screens;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Home extends JPanel {
    String homeText = "Welcome to MART - Managerial Assertive Resolving Technology";
    LinkedList<String> commands = new LinkedList<>();
    LinkedList<String> dialog = new LinkedList<>();

    public Home() {
        dialog.add("Welcome to MART");
        dialog.add("Are you ready to start Y/N");
    }

    public void paintComponent(Graphics g) {
        System.out.println("MR GEORGE HOW MUCH YOU PAY THE PAINT");
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        g2.setColor(Color.green);
        g2.setFont((new Font("Monospaced Bold",Font.BOLD,20)));

        int lastTextPos = 20;
        for (String dialog: dialog) {
            g2.drawString(dialog,15,lastTextPos);
            lastTextPos += 20;
        }



        for (String command : commands) {
            g2.setFont((new Font("Monospaced",Font.PLAIN,20)));
            g2.drawString(command,15,lastTextPos);
            System.out.println("MR GEORGE HOW MUCH YOU PAY THE FOR LOOP");
            lastTextPos += 20;
        }


        System.out.println("why we heere");
        setBackground(Color.black);

    }

    public void sendCommand(String command) {
        String commandText;
        switch (command) {
            case "Y":
                commandText = ">>" + command;
                commands.add(commandText);
                commands.add("WE CAN PROCCEED...");
                break;
            case "I eat the fish":
                commandText = ">>" + command;
                commands.add(commandText);
                commands.add("yes");
                break;
            default:
                commandText = ">>" + command;
                commands.add(commandText);
                commands.add("BAD INPUT >:(");
                commands.add(dialog.get(1));
                break;
        }
        repaint();
    }
}
