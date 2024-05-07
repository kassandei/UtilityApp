import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import AppCalculator.*;
import AppMeteo.*;

public class AppGui extends JFrame {

    public AppGui() {
        // Set up the frame
        setTitle("Utility App");
        setSize(400, 150); // Increased size for the buttons
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background color to black
        getContentPane().setBackground(Color.BLACK);

        // Create buttons for calculator and weather
        JButton calculatorButton = new JButton("Open Calculator");
        JButton weatherButton = new JButton("Open Weather App");

        // Set font color to white and make it bold
        Font buttonFont = new Font("Arial", Font.BOLD, 24); // Increased font size
        calculatorButton.setForeground(Color.WHITE);
        calculatorButton.setBackground(Color.BLACK);
        calculatorButton.setFont(buttonFont);
        calculatorButton.setBorderPainted(false); // Remove border around the button
        calculatorButton.setFocusPainted(false); // Remove the square around the text
        calculatorButton.setContentAreaFilled(false); // Remove default button background

        weatherButton.setForeground(Color.WHITE);
        weatherButton.setBackground(Color.BLACK);
        weatherButton.setFont(buttonFont);
        weatherButton.setBorderPainted(false); // Remove border around the button
        weatherButton.setFocusPainted(false); // Remove the square around the text
        weatherButton.setContentAreaFilled(false); // Remove default button background

        // Set cursor to hand when hovering over the buttons
        calculatorButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        weatherButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add action listeners to the buttons
        calculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close AppGui window
                dispose();
                // Open the calculator app
                openCalculator();
            }
        });

        weatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close AppGui window
                dispose();
                // Open the weather app
                openWeatherApp();
            }
        });

        // Create a panel and add buttons to it
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.add(calculatorButton);
        panel.add(weatherButton);

        // Add the panel to the frame
        add(panel);

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    private void openCalculator() {
        // Create and display the calculator GUI
        CalculatorGui calculator = new CalculatorGui();
        calculator.setVisible(true);
    }

    private void openWeatherApp() {
        // Create and display the weather app GUI
        WeatherAppGui weatherApp = new WeatherAppGui();
        weatherApp.setVisible(true);
    }
}
