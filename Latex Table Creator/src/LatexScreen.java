import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LatexScreen extends JPanel{
	private static final long serialVersionUID = 1L;
	JFrame window;
	public int width = 800;
	public int height = 600;
	
	public LatexScreen(String screenName){
		this.window = new JFrame(screenName);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setPreferredSize(new Dimension(width, height));
		window.setFocusable(true);
	}
	
	public void show() {
		window.pack();
		window.setVisible(true);
	}
	
	public void makeMain() {
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints c;
		contentPane.setBackground(Color.LIGHT_GRAY);
		window.getContentPane().add(contentPane);
		
		JTextArea tableInput = new JTextArea();
		JScrollPane tableInputScroll = new JScrollPane (tableInput);
		tableInput.setToolTipText("Input Field");
		c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=1;
		c.weightx=0.1;
		c.weighty=0.3;
		c.ipadx = 80;
		c.insets = new Insets(10,10,10,10);
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_START;
		contentPane.add(tableInputScroll, c);
			JLabel tableInputLbl = new JLabel("Paste Formatted Excel Table Below:");
			c = new GridBagConstraints();
			c.gridx=0;
			c.gridy=0;
			c.weightx=0.3;
			c.weighty=0.0;
			c.anchor = GridBagConstraints.SOUTH;
			c.fill = GridBagConstraints.VERTICAL;
			contentPane.add(tableInputLbl, c);
		
		JTextField seperationChar = new JTextField("&");
		seperationChar.setToolTipText("Character that seperates cells");
		c = new GridBagConstraints();
		c.gridx=2;
		c.gridy=0;
		c.weightx=0.0;
		c.weighty=0.0;
		c.ipadx = 10;
		c.insets = new Insets(10,10,10,10);
		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.NONE;
		contentPane.add(seperationChar, c);
		
			JLabel seperationCharLbl = new JLabel("Cell Seperator:");
			c = new GridBagConstraints();
			c.gridx=1;
			c.gridy=0;
			c.weightx=0.3;
			c.weighty=0.0;
			c.anchor = GridBagConstraints.LINE_END;
			c.fill = GridBagConstraints.VERTICAL;
			contentPane.add(seperationCharLbl, c);
		
		SpinnerModel columnNumberModel = new SpinnerNumberModel(1, 1, 1000, 1);
		JSpinner columnNumber = new JSpinner(columnNumberModel);
		JFormattedTextField tf = ((JSpinner.DefaultEditor)columnNumber.getEditor()).getTextField();
		tf.setEditable(false);
		c = new GridBagConstraints();
		c.gridx=4;
		c.anchor = GridBagConstraints.LINE_START;
		c.gridy=0;
		c.fill = GridBagConstraints.NONE;
		contentPane.add(columnNumber,c);
		
			JLabel spinnerLbl = new JLabel("Table Columns:");
			spinnerLbl.setToolTipText("Number of columns in pasted table");
			c = new GridBagConstraints();
			c.gridx=3;
			c.gridy=0;
			c.weightx=0.0;
			c.weighty=0.0;
			c.anchor = GridBagConstraints.LINE_END;
			c.fill = GridBagConstraints.VERTICAL;
			contentPane.add(spinnerLbl, c);
		
		JTextField tableCaption = new JTextField();
		tableCaption.setToolTipText("Enter the caption for the table");
		c = new GridBagConstraints();
		c.gridx=2;
		c.gridy=1;
		c.weightx=0.0;
		c.weighty=0.0;
		c.ipadx = 100;
		c.insets = new Insets(0,0,0,10);
		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.NONE;
		contentPane.add(tableCaption, c);
		
			JLabel tableCaptionLbl = new JLabel("Table Caption:");
			tableCaptionLbl.setToolTipText("Enter the reference label for the table");
			c = new GridBagConstraints();
			c.gridx=1;
			c.gridy=1;
			c.weightx=0.0;
			c.weighty=0.0;
			c.anchor = GridBagConstraints.LINE_END;
			c.fill = GridBagConstraints.VERTICAL;
			contentPane.add(tableCaptionLbl, c);
			
		JTextField tableLabel = new JTextField();
		tableLabel.setToolTipText("Enter the reference label for the table");
		c = new GridBagConstraints();
		c.gridx=4;
		c.gridy=1;
		c.weightx=0.0;
		c.weighty=0.0;
		c.insets = new Insets(10,10,10,10);
		c.ipadx = 100;
		c.fill = GridBagConstraints.NONE;
		contentPane.add(tableLabel, c);
			
			JLabel tableLabellbl = new JLabel("Table Label:");
			c = new GridBagConstraints();
			c.gridx=3;
			c.gridy=1;
			c.weightx=0.3;
			c.weighty=0.0;
			c.anchor = GridBagConstraints.LINE_END;
			c.fill = GridBagConstraints.VERTICAL;
			contentPane.add(tableLabellbl, c);
			
			
			
		JButton printLatex = new JButton("Print Latex Code:");
		c = new GridBagConstraints();
		c.gridx=2;
		c.gridy=3;
		c.fill = GridBagConstraints.NONE;
		contentPane.add(printLatex,c);
		
		
		JTextArea latexOutput = new JTextArea();
		latexOutput.setEditable(false);
		JScrollPane latexOutputScroll = new JScrollPane (latexOutput);
		c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=4;
		c.weightx=0.5;
		c.weighty=0.5;
		c.ipady = 100;
		c.gridwidth = 5;
		c.insets = new Insets(10,10,10,10);
		c.fill = GridBagConstraints.BOTH;
		contentPane.add(latexOutputScroll,c);
		
		printLatex.addActionListener(new ActionListener() {
			// Input action:
			public void actionPerformed(ActionEvent e) {
				if(tableInput.getText().length()>0) {					
					Table table = new Table(tableCaption.getText(),tableLabel.getText(),
							tableInput.getText(),(Integer)columnNumber.getValue(),seperationChar.getText().charAt(0));
					
					latexOutput.setText(table.print());
				}
			} 
		});
		
		
			
	}

}
