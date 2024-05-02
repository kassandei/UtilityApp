import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        /**
         * calling invokeLater() is useful for Swing GUI's like ours because
         * it makes updates to the GUI more thread safe
         */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            // when our app is executed it calls run() creating the GUI and displaying it
            public void run() {
                // display our WeatherApp GUI
                new WeatherAppGui().setVisible(true);
            }
        });
    }
}
