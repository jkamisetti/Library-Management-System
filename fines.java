import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class fines extends dbproject{
	public void FinesPaymentPanel()
    {
    	GridBagLayout layout = new GridBagLayout();
        finespanel.setLayout(layout);        
        GridBagConstraints gbc = new GridBagConstraints();
        
    	JLabel label1 = new JLabel();//instantiate new JLabel
    	label1.setText("Loan id:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        finespanel.add(label1,gbc);
        
        //FnameField.setText("Enter FirstName");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 0;
        finespanel.add(LoanIdField,gbc); 
             
    	JLabel label2 = new JLabel();//instantiate new JLabel
    	label2.setText("Fine Amount:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        finespanel.add(label2,gbc);
        
        //FnameField.setText("Enter FirstName");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 1;
        finespanel.add(FineField,gbc); 
        
        AddButton = makeButton("Pay");//instantiate new JTextField
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth=1;
        gbc.ipady=5;
        finespanel.add(AddButton,gbc);
        
        clearButton = makeButton("Clear");//instantiate new JTextField
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth=1;
        gbc.ipady=5;
        finespanel.add(clearButton,gbc);
        frame.add(finespanel,BorderLayout.NORTH);
        frame.setVisible(true);
    }
    
	public void FinesRefreshPanel()
    {
    	GridBagLayout layout = new GridBagLayout();
        finespanel1.setLayout(layout);        
        GridBagConstraints gbc = new GridBagConstraints();
        
        UpdateButton = makeButton("Update/Refresh");//instantiate new JTextField
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth=1;
        gbc.ipady=5;
        finespanel1.add(UpdateButton,gbc);
        frame.add(finespanel1,BorderLayout.NORTH);
        frame.setVisible(true);
    }
    
    public void DisplayFinesPanel(String[][] dataValues) {
        
		// Create columns names
    	String columnNames[] = { "Loan_id", "Fine_Amount", "Paid", "Card_no","TotalFine_Amount"};
        JTable Table = new JTable(dataValues,columnNames);
        JScrollPane scrollPane = new JScrollPane(Table);
        
        //scrollPane.setSize(100, 100);
        tablepanel.setLayout(new BorderLayout());
        tablepanel.setBackground(Color.WHITE);
        tablepanel.add(scrollPane);
        frame.add(tablepanel,BorderLayout.CENTER);
        frame.setVisible(true);
    }
}














