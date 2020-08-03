import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Elektronika {


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Электроника МК-001");
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();
    }
}
class CalculatorPanel extends JPanel {
    JPanel windowContent;
    JTextField displayFormattedField;

    public CalculatorPanel() {

        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start = true;

        Font font = new Font("Digital", Font.PLAIN, 28);
        windowContent= new JPanel();
        windowContent.setLayout(new BorderLayout());
        displayFormattedField = new JFormattedTextField("0");
        displayFormattedField.setHorizontalAlignment(SwingConstants.RIGHT);
        displayFormattedField.setFont(font);
        displayFormattedField.setBackground(Color.DARK_GRAY);
        displayFormattedField.setForeground(Color.cyan);
        windowContent.add(displayFormattedField);
        add(windowContent,BorderLayout.NORTH);

        ActionListener digit = new DigitInput();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4 ));

        addButton("7", digit);
        addButton("8", digit);
        addButton("9", digit);
        addButton("/", command);

        addButton("4", digit);
        addButton("5", digit);
        addButton("6", digit);
        addButton("*", command);

        addButton("1", digit);
        addButton("2", digit);
        addButton("3", digit);
        addButton("-", command);

        addButton("0", digit);
        addButton(".", digit);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);
    }
    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setBackground(Color.GRAY);
//        int red = (int)(Math.random()*255);
//        int green = (int)(Math.random()*255);
//        int blue = (int)(Math.random()*255);
//        Color randomColor= new Color(red,green,blue);
//        button.setBackground(randomColor);
        button.setForeground(Color.white);
        Font font = new Font("constanb", Font.BOLD,14);
        button.setFont(font);
        button.addActionListener(listener);
        panel.add(button);
    }

    private class DigitInput implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                displayFormattedField.setText("");
                start = false;
            }
            String clickedButtonLabel= displayFormattedField.getText();

            ///* защита от 2х точек
            if(input.equals(".")){
                if (clickedButtonLabel.indexOf(".")>0){
                    displayFormattedField.setText(displayFormattedField.getText() +"");}
                else displayFormattedField.setText(displayFormattedField.getText() + input);
            }
            else displayFormattedField.setText(displayFormattedField.getText() + input);
        }}

    private class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (start) {
                if (command.equals("-")) {
                    displayFormattedField.setText(command);
                    start = false;
                } else lastCommand = command;
            } else {
                calculate(Double.parseDouble(displayFormattedField.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }
    public void calculate(double x) {
        if (lastCommand.equals("+")) result += x;
        else if (lastCommand.equals("-")) result -= x;
        else if (lastCommand.equals("*")) result *= x;
        else if (lastCommand.equals("/")) result /= x;
        else if (lastCommand.equals("=")) result = x;
        displayFormattedField.setText("" + result);
    }
    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;
}