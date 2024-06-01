import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                    try {
                        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    } catch (Exception var1) {
                        Exception e = var1;
                        e.printStackTrace();
                    }
                }
        );
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
