import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.NORTH;

public class CalculatorGUI extends JFrame {
    static JTextField result;
    private static final String[] BUTTONS = {"1", "2", "3", "+","4", "5", "6","-", "7", "8", "9", "*", "C", "0", "=", "/"};
    static double operand1;
    static Operations operation;
    public CalculatorGUI() {
        setTitle("Calculator");
        setBounds(100, 100, 300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        result = new JTextField();
        result.setHorizontalAlignment(SwingConstants.RIGHT);
        result.setEditable(false);
        result.setPreferredSize(new Dimension(294, 30));
        add(result, NORTH);
        ActionListener listener = new ButtonActionListener();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 3, 3));
        for (String buttonText : BUTTONS) {
            JButton button = new JButton(buttonText);
            button.setSize(60, 24);
            button.addActionListener(listener);
            buttonPanel.add(button);
        }
        add(buttonPanel);
        setVisible(true);
    }

    static class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonText = e.getActionCommand();
            if (Digits.contains(buttonText)) {
                result.setText(result.getText() + buttonText);
            } else if ("=".equals(e.getActionCommand())) {
                result.setText(String.valueOf(
                        operation.action(operand1, Double.parseDouble(result.getText()))));
                operand1 = 0.0;
                operation = Operations.UNKNOWN;
            } else {
                Operations buttonOperation = Operations.valueBy(buttonText);
                if (buttonOperation != Operations.UNKNOWN) {
                    operand1 = Double.parseDouble(result.getText());
                    result.setText("");
                    operation = buttonOperation;
                    System.out.println(operand1 + operation.getOperation());
                }
            }
        }
    }
}
