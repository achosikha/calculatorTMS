import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField textField;

    public Calculator() {
        initMandatoryComponents();

        setTitle("Calculator");
        setBounds(0, 0, 300, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(initTop(), BorderLayout.NORTH);
        add(initBottom(), BorderLayout.CENTER);

        setVisible(true);
    }

    private void initMandatoryComponents() {
        textField = new JTextField();
    }

    private JPanel initBottom() {
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(5, 3));

        ActionListener concatenationButtonListener = new ConcatenationButtonListener(textField);

        for (int i = 1; i <= 9; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(concatenationButtonListener);
            bottom.add(btn);
        }

        JButton submit = new JButton("=");
        submit.addActionListener(new CalculationListener(textField));

        JButton zero = new JButton("0");
        zero.addActionListener(concatenationButtonListener);

        JButton clear = new JButton("C");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        JButton plus = new JButton("+");
        plus.addActionListener(concatenationButtonListener);
        JButton minus = new JButton("-");
        minus.addActionListener(concatenationButtonListener);
        JButton multiple = new JButton("*");
        multiple.addActionListener(concatenationButtonListener);

        bottom.add(submit);
        bottom.add(zero);
        bottom.add(clear);
        bottom.add(plus);
        bottom.add(minus);
        bottom.add(multiple);

        return bottom;
    }

    private JPanel initTop() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);
        top.add(textField, BorderLayout.CENTER);

        return top;
    }
}
