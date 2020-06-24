import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Elektron {


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setResizable(false);
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
    JTextField displayField;

    public CalculatorPanel() {
        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start = true;
        on=true;

        windowContent= new JPanel();

        BorderLayout bl = new BorderLayout();
        Font font = new Font("Digital", Font.PLAIN, 28);
        windowContent.setLayout(bl);
        displayField = new JTextField("0");
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        displayField.setFont(font);
        Color custom = new Color(184,207,229);
        displayField.setBackground(Color.DARK_GRAY);

        displayField.setForeground(Color.orange);
        displayField.setEnabled(true);

        windowContent.add("North",displayField);
        add(windowContent,BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(5,1 ));
        addButton("C", command);
        addButton("<==",command);
        addButton("color",command);
        addButton("/", command);

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("*", command);


        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("-", command);



        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("+", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("empty",null);
        addButton("=", command);

        add(panel, BorderLayout.CENTER);
    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
//        Color custom = new Color(184,207,229);
        button.setBackground(Color.gray);
        button.setForeground(Color.white);
        Font font = new Font("constanb", Font.BOLD,15);
        button.setFont(font);
        button.addActionListener(listener);
        panel.add(button);
    }

    private class InsertAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                displayField.setText("");
                start = false;
            }

            String pointButton= displayField.getText();             // проверка 1ой точки
            if(input.equals(".")){
                if (pointButton.indexOf(".")>0){
                    displayField.setText(displayField.getText() +"");}
                else displayField.setText(displayField.getText() + input);
            }
            else displayField.setText(displayField.getText() + input);
        }
    }

    private class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if(on){
                if(command.equals("color")){
                    if(trigger==1){ displayField.setForeground(Color.CYAN);
                        trigger=0;}
                    else  {displayField.setForeground(Color.orange);
                        trigger=1;}
                    result=(Double.parseDouble(displayField.getText()));
                    start=true;
                    command = "=";
                }
            }
            if(start){
                if(command.equals("<==")){
                    if(!displayField.getText().equals("0")){
                        String edit = displayField.getText();
                        if(edit.length()>1){
                            String tmp = edit.substring(0, edit.length() - 1);
                            System.out.println(tmp);
                            displayField.setText("");
                            displayField.setText(tmp);
                            result=(Double.parseDouble(displayField.getText()));
                            start = true;

                        }}
                    command = "=";
                }
            }

            if (command.equals("C")){                   // clear screen
                result = 0;
                displayField.setText(""+(int)result);
                start = true;
            }

            else if (start) {
                lastCommand = command;
            }
            else{
                calculate(Double.parseDouble(displayField.getText()));
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
        else if (lastCommand.equals("c")) result =0;
        if(result-(int)result==0){
            displayField.setText("" + (int)result);
        }
        else displayField.setText("" + result);

    }
    private JPanel panel;
    private int trigger=1;
    private double result;
    private String lastCommand;
    private boolean start;
    private boolean on;
}