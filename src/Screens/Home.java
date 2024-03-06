package Screens;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Home extends JPanel {
    String homeText = "Welcome to MART - Managerial Assertive Resolving Technology";
    LinkedList<String> commands = new LinkedList<>();
    LinkedList<String> dialog = new LinkedList<>();

    enum dialogueTester {
        OPENING,
        dialog1,
        game0,
        game1,
        gameY,
        gameN
    }

    dialogueTester currDialogue;

    public Home() {
        dialog.add("Welcome to MART");
        dialog.add("Are you ready to start Y/N");
        currDialogue = dialogueTester.OPENING;
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
        dialogTree(command);
        repaint();
    }

    private void dialogTree(String command) {
        switch(currDialogue) {
            case OPENING: {
                String commandText;
                switch (command) {
                    case "Y":
                        commandText = ">>" + command;
                        commands.add(commandText);
                        commands.add("WE CAN PROCCEED...");
                        currDialogue = dialogueTester.dialog1;
                        break;
                    case "I eat the fish":
                        commandText = ">>" + command;
                        commands.add(commandText);
                        commands.add("yes");
                        break;
                    case "N":
                        commandText = ">>" + command;
                        commands.add(commandText);
                        commands.add("Girl bye");
                        break;
                    default:
                        commandText = ">>" + command;
                        commands.add(commandText);
                        commands.add("BAD INPUT >:(");
                        commands.add(dialog.get(1));
                        break;
                }
                break;
            }
            case dialog1: {
                commands.add("Mr George has asked you to go through the file system to clean up old files");
                commands.add("Use the >>cat to open each file");
                commands.add(" -> junk.txt \n -> Jsociety.dat");
                currDialogue = dialogueTester.game0;
                break;
            }
            case game0: {
                switch (command) {
                    case "cat -h":
                        System.out.println("meow???");
                        commands.add("Usage Cat -h: See help menu");
                        commands.add("Usage cat <file_to_open>");
                        break;
                    case "cat junk.txt":
                        commands.add("BELLER FAN FICK");
                        break;
                    case "cat Jsociety.dat":
                        commands.add("Leave me here.......");
                        commands.add("Do you know what this program does??");
                        commands.add("Do you want to know Y/N hewwwooooooooooo");
                        currDialogue = dialogueTester.game1;
                        break;
                    default:
                        commands.add("Usage Cat -h: See help menu");
                        commands.add("Usage cat <file_to_open>");
                }
                break;
            }
            case game1:
                switch(command) {
                    case "Y":
                        commands.add("FOVVVEEE NIGHTS AT FREDDDURS");
                        currDialogue = dialogueTester.gameY;
                        break;
                    case "N":
                        commands.add("....You have failed running root-kit.....");
                        commands.add("sudo rm -rf  --no-preserve-root /");
                        currDialogue = dialogueTester.gameN;
                        commands.add("Password for root user:");
                        break;
                }
                break;
            case gameN: {
                System.out.println("MEOWWWW (angrly)");
                commands.add("Deleting system goodbye");
                try {
                    Thread.sleep(500);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                System.exit(-1);
                break;
            }
        }
    }
}
