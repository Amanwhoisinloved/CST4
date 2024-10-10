package CST4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainpanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    public mainpanel() {
        // Set layout for the main panel
        setLayout(new BorderLayout());

        // Create the JTabbedPane instance
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        add(tabbedPane, BorderLayout.CENTER); // Add the tabbed pane to the main panel
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("Main Menu", null, panel, null);

        // Panel 1: Contains DFA
        JPanel panel1 = new JPanel();
        tabbedPane.addTab("DFA", panel1);
        panel1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Input String:");
        lblNewLabel.setBounds(10, 10, 85, 13);
        panel1.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(10, 33, 96, 19);
        panel1.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("Calculate");
        btnNewButton.setBounds(10, 62, 96, 21);
        panel1.add(btnNewButton);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(116, 30, 629, 652);
        panel1.add(textArea);

        // Action for the "Calculate" button in the DFA panel
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText(); // Get the input string
                boolean result = q0(input, 0); // Call DFA's q0 state
                textArea.setText("The String is " + (result ? "Accepted" : "Rejected"));
            }
        });

        // Panel 2 to 7: Each has one button
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        JButton button = new JButton("Button in Tab 2");
        button.setBounds(10, 70, 103, 21);
        panel2.add(button);
        tabbedPane.addTab("NDFA", panel2);
        
        JLabel lblNewLabel_1 = new JLabel("Input String:");
        lblNewLabel_1.setBounds(10, 10, 85, 13);
        panel2.add(lblNewLabel_1);
        
        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(123, 30, 629, 652);
        panel2.add(textArea_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(10, 33, 96, 19);
        panel2.add(textField_1);

        JPanel panel3 = new JPanel();
        JButton button_1 = new JButton("Button in Tab 3");
        button_1.setBounds(10, 85, 103, 21);
        button_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panel3.setLayout(null);
        panel3.add(button_1);
        tabbedPane.addTab("CFG", panel3);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(10, 52, 96, 19);
        panel3.add(textField_2);
        
        JTextArea textArea_1_1 = new JTextArea();
        textArea_1_1.setBounds(124, 49, 629, 652);
        panel3.add(textArea_1_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Input String:");
        lblNewLabel_1_1.setBounds(10, 29, 85, 13);
        panel3.add(lblNewLabel_1_1);

        JPanel panel4 = new JPanel();
        panel4.setLayout(null);
        JButton button_2 = new JButton("Button in Tab 4");
        button_2.setBounds(10, 65, 103, 21);
        panel4.add(button_2);
        tabbedPane.addTab("Tower of Hanoi", panel4);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Input String:");
        lblNewLabel_1_1_1.setBounds(10, 13, 85, 13);
        panel4.add(lblNewLabel_1_1_1);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(10, 36, 96, 19);
        panel4.add(textField_3);
        
        JTextArea textArea_1_1_1 = new JTextArea();
        textArea_1_1_1.setBounds(116, 33, 629, 652);
        panel4.add(textArea_1_1_1);

        JPanel panel5 = new JPanel();
        panel5.setLayout(null);
        JButton button_3 = new JButton("Button in Tab 5");
        button_3.setBounds(10, 61, 103, 21);
        panel5.add(button_3);
        tabbedPane.addTab("Turing Machine", panel5);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Input String:");
        lblNewLabel_1_1_1_1.setBounds(10, 9, 85, 13);
        panel5.add(lblNewLabel_1_1_1_1);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(10, 32, 96, 19);
        panel5.add(textField_4);
        
        JTextArea textArea_1_1_1_1 = new JTextArea();
        textArea_1_1_1_1.setBounds(118, 29, 629, 652);
        panel5.add(textArea_1_1_1_1);
    }

    // Recursive DFA methods
    public static boolean q0(String sets, int i) {
        if (i == sets.length()) {
            return false;
        }

        if (sets.charAt(i) == 'a') {
            return q1(sets, i + 1);
        } else {
            return q3(sets, i + 1);
        }
    }

    public static boolean q1(String sets, int i) {
        if (i == sets.length()) {
            return false;
        }

        if (sets.charAt(i) == 'a') {
            return q1(sets, i + 1);
        } else {
            return q4(sets, i + 1);
        }
    }

    public static boolean q3(String sets, int i) {
        if (i == sets.length()) {
            return false;
        }

        if (sets.charAt(i) == 'a') {
            return q4(sets, i + 1);
        } else {
            return q3(sets, i + 1);
        }
    }

    public static boolean q4(String sets, int i) {
        if (i == sets.length()) {
            return true;
        }

        if (sets.charAt(i) == 'a') {
            return q4(sets, i + 1);
        } else {
            return q3(sets, i + 1);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            // Create the frame
            JFrame frame = new JFrame("Main Panel with Tabs");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Add the main panel to the frame
            frame.getContentPane().add(new mainpanel());

            // Set the frame size and make it visible
            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }
}
