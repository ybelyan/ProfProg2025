import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static JLabel label;
    public static void main(String[] args) {
        JFrame mainForm = new JFrame();
        mainForm.setTitle("Calculator");
        mainForm.setBounds(100, 100, 600, 400);
        mainForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainForm.setResizable(false);
        mainForm.setLayout(null);

        label = new JLabel("0");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        mainForm.add(label);
        label.setBounds(100, 70, 200, 24);

        JButton button = new JButton("1");
        button.setBounds(100, 100, 60, 24);
        button.addActionListener(new ButtonActionListener());
        mainForm.add(button);

        JButton button2 = new JButton("2");
        button2.setBounds(170, 100, 60, 24);
        button2.addActionListener(new ButtonActionListener());
        mainForm.add(button2);

        mainForm.setVisible(true);
    }

    static class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText(e.getActionCommand());
        }
    }
}