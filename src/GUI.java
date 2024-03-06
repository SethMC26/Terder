import Screens.Terminal;
import Screens.Home;

import javax.swing.*;
import java.awt.*;


/**
 * GUI holds the Root GUI components
 */
public class GUI extends JFrame {
    Home home = new Home();
    public GUI()  {
        super("The MART");//set name (S for Sean and Seth)

        setLayout(new BorderLayout());
        this.add(home,BorderLayout.CENTER);
        this.add(new Terminal(home), BorderLayout.SOUTH);

    }


}
