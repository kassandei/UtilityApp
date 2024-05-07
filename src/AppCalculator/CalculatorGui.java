package AppCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGui extends JFrame implements ActionListener {
    // Array to store buttons
    private JButton[] buttons;
    private JTextField inputField;
    private JPanel buttonPanel;

    // Variables for calculator functionality
    private double memory = 0;
    private boolean memoryNull = true;
    private double result = 0;
    private String operatore;
    private boolean isExecuted = false;

    // Array of button labels
    private static final String[] BUTTON_LABELS = {"7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "/", "="};

    // Constants for visual customization
    private static final Color BACKGROUND_COLOR = Color.BLACK;
    private static final Color BACKGROUND_COLOR_OPERATOR = Color.decode("#FF9500");
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final Font INPUT_FONT = new Font("Dialog", Font.PLAIN, 80);
    private static final Font BUTTON_FONT = new Font("Dialog", Font.BOLD, 30);
    private static final Insets BUTTON_MARGIN = new Insets(10, 10, 10, 10);
    private static final Cursor HAND_CURSOR = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

    // Constructor
    public CalculatorGui() {
        super("Calculator App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        Image icon = Toolkit.getDefaultToolkit().getImage("src/assets/icon2.png");
        setIconImage(icon);
        addGuiComponents(); // Add GUI components
    }

    // Method to add GUI components
    public void addGuiComponents() {
        // Create and customize input field
        inputField = createInputField();
        add(inputField, BorderLayout.NORTH);

        // Create and customize button panel
        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.CENTER);

    }

    // Method to create and customize input field
    private JTextField createInputField() {
        JTextField inputField = new JTextField();
        inputField.setFont(INPUT_FONT); // Set font
        inputField.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Add margin
        inputField.setBackground(BACKGROUND_COLOR); // Set background color
        inputField.setForeground(TEXT_COLOR); // Set text color
        inputField.setHorizontalAlignment(SwingConstants.RIGHT); // Set horizontal alignment to left
        inputField.setEditable(false); // Make the field uneditable from the keyboard of the user
        inputField.setCaretColor(BACKGROUND_COLOR); // Set caret color to background color
        return inputField;
    }

    // Method to create button panel with buttons
    private JPanel createButtonPanel() {
        buttonPanel = new JPanel(new GridLayout(4, 4, 10, 10)); // 4x4 grid layout with gaps
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add margin
        buttonPanel.setBackground(BACKGROUND_COLOR); // Set background color
        // Create buttons and add them to the panel
        buttons = createButtons();
        for (JButton button : buttons) {
            button.setCursor(HAND_CURSOR); // Set cursor
            buttonPanel.add(button); // Add button to panel
        }

        return buttonPanel;
    }

    // Method to create buttons with labels
    private JButton[] createButtons() {
        JButton[] buttons = new JButton[BUTTON_LABELS.length];
        for (int i = 0; i < BUTTON_LABELS.length; i++) {
            buttons[i] = new JButton(BUTTON_LABELS[i]);
            buttons[i].setOpaque(true); // Set opaque property to true
            buttons[i].setHorizontalAlignment(SwingConstants.CENTER); // Center align text
            buttons[i].setMargin(BUTTON_MARGIN); // Add margin
            buttons[i].setFont(BUTTON_FONT); // Set font
            buttons[i].setBackground(BACKGROUND_COLOR); // Set background color
            buttons[i].setForeground(TEXT_COLOR); // Set text color
            buttons[i].setFocusable(false); // Disable focus
            buttons[i].addActionListener(this);
        }
        buttons[3].setBackground(BACKGROUND_COLOR_OPERATOR); // X
        buttons[7].setBackground(BACKGROUND_COLOR_OPERATOR); // -
        buttons[11].setBackground(BACKGROUND_COLOR_OPERATOR); // +
        buttons[13].setBackground(BACKGROUND_COLOR_OPERATOR); // .
        buttons[14].setBackground(BACKGROUND_COLOR_OPERATOR); // /
        buttons[15].setBackground(BACKGROUND_COLOR_OPERATOR); // =

        return buttons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.matches("[0-9]")) {
            if(isExecuted) inputField.setText("");
            isExecuted = false;
            inputField.setText(inputField.getText() + actionCommand);
        } else if (actionCommand.matches("[.]")) {
            if(!inputField.getText().contains(".")) {
                if(isExecuted) inputField.setText("");
                isExecuted = false;
                inputField.setText(inputField.getText() + actionCommand);
            }
        } else if (!(actionCommand.equals("="))) {
            if (!inputField.getText().equals("")) {
                isExecuted = false;
                result = Double.parseDouble(inputField.getText());
                if (!memoryNull) {
                    calculateResult(operatore);
                    inputField.setText(String.valueOf(memory));
                    isExecuted = true;
                } else {
                    memoryNull = false;
                    memory = result;
                    inputField.setText("");
                }
                operatore = actionCommand;
            }
        }
        else {
            memoryNull = true;
            if(!isExecuted) {
                result = Double.parseDouble(inputField.getText());
                calculateResult(operatore);
                isExecuted = true;
                inputField.setText(String.valueOf(memory));
                memory = 0;
                operatore = "vuoto";
            } else {
                inputField.setText("");
            }
        }
    }

    public void calculateResult(String operatore) {
        if(!operatore.equals("vuoto")) {
            switch (operatore) {
                case "+":
                    memory += result;
                    break;
                case "-":
                    memory -= result;
                    break;
                case "x":
                    memory *= result;
                    break;
                case "/":
                    if (result == 0) {
                        inputField.setText("Error!");

                    } else {
                        memory /= result;
                    }
                    break;
            }
        }
    }
}
