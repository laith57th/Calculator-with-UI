import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {
	private TextField txField = new TextField();
	private Panel buttonPanel = new Panel();

	// total of 20 buttons on the calculator,
	// numbered from left to right, top to bottom
	// bText[] array contains the text for corresponding buttons
	private static final String[] bText = {
		"7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
		"*", "0", "^", "=", "/", "(", ")", "C", "CE"
	};
	private Button[] buttons = new Button[bText.length];

	public static void main(String argv[]) {
		EvaluatorUI calc = new EvaluatorUI();
	}

	public EvaluatorUI() {
		setLayout(new BorderLayout());

		add(txField, BorderLayout.NORTH);
		txField.setEditable(false);

		add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.setLayout(new GridLayout(5, 4));

		//create 20 buttons with corresponding text in bText[] array
		for (int i = 0; i < 20; i++) {
			buttons[i] = new Button(bText[i]);
			buttonPanel.add(buttons[i]);
			buttons[i].addActionListener(this);
		}

		setTitle("Calculator");
		setSize(400, 400);
		setLocationByPlatform(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		String text = this.txField.getText();
		if (arg0.getSource() == buttons[14]) {
			Evaluator equal = new Evaluator();
			txField.setText(Integer.toString(equal.eval(txField.getText())));
		} else if (arg0.getSource() == buttons[18] || arg0.getSource() == buttons[19]) {
			txField.setText(" ");
		} else {
			this.txField.setText(text + arg0.getActionCommand());
		}
	}
}
