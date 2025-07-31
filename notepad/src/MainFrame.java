import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final JTextArea textArea = new JTextArea();
    private final JTextField fileNameTextField = new JTextField();
    private final FileHandler handler = new FileHandler();

    public MainFrame() {
        setTitle("Блокнот");

        JPanel buttonPanel = new JPanel();
        JButton readButton = new JButton("Читать");
        JButton writeButton = new JButton("Записать");
        JButton clearButton = new JButton("Очистить");
        ButtonActionListener listener = new ButtonActionListener();
        readButton.addActionListener(listener);
        writeButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        buttonPanel.add(readButton);
        buttonPanel.add(writeButton);
        buttonPanel.add(clearButton);

        setLayout(new BorderLayout());
        add(fileNameTextField, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        pack();
        setVisible(true);
    }

    private class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            switch (button.getText()) {
                case "Читать":
                    String text = handler.read(fileNameTextField.getText().trim());
                    textArea.setText(text);
                    break;
                case "Записать":
                    handler.write(fileNameTextField.getText().trim(), textArea.getText());
                    break;
                case "Очистить":
                    textArea.setText("");
                    fileNameTextField.setText("");
                    break;
                default:
                    System.out.println("Неизвестная команда");
            }
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}