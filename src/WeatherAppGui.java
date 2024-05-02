import javax.swing.*;

public class WeatherAppGui extends JFrame {
    public WeatherAppGui() {
        // setup our gui and add a title
        super("Weather App");

        // configure gui to end the program's process once it has been close off
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set the size of our gui (in pixels)
        setSize(450, 650);

        // load our gui at the center of the screen
        setLocationRelativeTo(null);

        // make our layout manager null to manually position our components within the gui
        setLayout(null);

        // prevent any resize of our gui
        setResizable(false);

        addGuiComponents();
    }

    private void addGuiComponents() {
        // search field
        JTextField searchTextField = new JTextField("cia");

        searchTextField.setBounds(15,15,350,45);
    }
}
