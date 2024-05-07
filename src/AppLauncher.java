import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        // Call invokeLater to make GUI updates thread safe
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create and display the UtilityApp GUI
                AppGui utilityApp = new AppGui();
                utilityApp.setVisible(true);
            }
        });
    }
}
