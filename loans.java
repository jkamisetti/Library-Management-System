import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



class loans extends dbproject{
	
	public void CheckInPanel() {
		cinpanel.removeAll();
    	GridBagLayout layout = new GridBagLayout();
        cinpanel.setLayout(layout);        
        GridBagConstraints gbc = new GridBagConstraints();
        
    	JLabel label1 = new JLabel();//instantiate new JLabel
    	label1.setText("Book Id:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        cinpanel.add(label1,gbc);
        
        
        //BookIDField.setText("Enter BookID");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 0;
        cinpanel.add(BookIDField,gbc); 
             
    	JLabel label2 = new JLabel();//instantiate new JLabel
    	label2.setText("Card Number:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        cinpanel.add(label2,gbc);
               
        
        //CardNumberField.setText("Enter Card Number");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 1;
        cinpanel.add(CardNumberField,gbc);
        
        
    	JLabel label3 = new JLabel();//instantiate new JLabel
    	label3.setText("Borrower FirstName:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        cinpanel.add(label3,gbc);

        //FnameField.setText("Enter Borrower FName");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 2;
        cinpanel.add(FnameField,gbc);
        
    	JLabel label5 = new JLabel();//instantiate new JLabel
    	label5.setText("Borrower LastName:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        cinpanel.add(label5,gbc);

        //LnameField.setText("Enter Borrower LName");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 3;
        cinpanel.add(LnameField,gbc);
        
        
    	JLabel label4 = new JLabel();//instantiate new JLabel
    	label4.setText("");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth=2;
        gbc.ipady=6;
        cinpanel.add(label4,gbc);
        
        searchButton = makeButton("Locate");//instantiate new JTextField
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth=1;
        gbc.ipady=5;
        cinpanel.add(searchButton,gbc);
        
        clearButton = makeButton("Clear");//instantiate new JTextField
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth=1;
        gbc.ipady=5;
        cinpanel.add(clearButton,gbc);
        frame.add(cinpanel,BorderLayout.NORTH);
        frame.setVisible(true);

    }
    
    public void CheckOutPanel() {
    	coutpanel.removeAll();
    	GridBagLayout layout = new GridBagLayout();
        coutpanel.setLayout(layout);        
        GridBagConstraints gbc = new GridBagConstraints();
        
    	JLabel label1 = new JLabel();//instantiate new JLabel
    	label1.setText("Book Id:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        coutpanel.add(label1,gbc);
        
        //textField1.setText("Enter BookID");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 0;
        coutpanel.add(BookIDField,gbc); 
             
    	JLabel label2 = new JLabel();//instantiate new JLabel
    	label2.setText("Branch Id:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        coutpanel.add(label2,gbc);
               
        //BranchIdField.setText("Enter BranchID");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 1;
        coutpanel.add(BranchIdField,gbc);
        
        
    	JLabel label3 = new JLabel();//instantiate new JLabel
    	label3.setText("Card Number:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        coutpanel.add(label3,gbc);
        
        //textField3.setText("Enter Card Number");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 2;
        coutpanel.add(CardNumberField,gbc);
        
    	JLabel label4 = new JLabel();//instantiate new JLabel
    	label4.setText("");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth=2;
        gbc.ipady=6;
        coutpanel.add(label4,gbc);
        
        searchButton = makeButton("Checkout");//instantiate new JTextField
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth=1;
        gbc.ipady=5;
        coutpanel.add(searchButton,gbc);
        
        clearButton = makeButton("Clear");//instantiate new JTextField
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth=1;
        gbc.ipady=5;
        coutpanel.add(clearButton,gbc);
        frame.add(coutpanel,BorderLayout.NORTH);
        frame.setVisible(true);

    }
    
    public void checkoutMessage(String message, Color color) {
    	coutpanel1.removeAll();
    	GridBagLayout layout = new GridBagLayout();
        coutpanel1.setLayout(layout); 
    	JLabel label1 = new JLabel();//instantiate new JLabel
    	label1.setText(message);//set label text to name
    	label1.setBackground(color);
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth=10;
        coutpanel1.add(label1,gbc);
        frame.add(coutpanel1,BorderLayout.CENTER);
        frame.setVisible(true);
    }
	
    public void cinTablePanel(Object[][] dataValues) {
    	cintablepanel.removeAll();
		// Create columns names
		String columnNames[] = { "Select","Loan_id","book_id", "branch_id","Card Number","Fname","Lname","date_out","date_in"};
           CheckInTable = new JTable(dataValues,columnNames){

            private static final long serialVersionUID = 1L;

            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    default:
                        return String.class;
                }
            }
        };
        JScrollPane scrollPane = new JScrollPane(CheckInTable);
        cintablepanel.setLayout(new BorderLayout());
        cintablepanel.setBackground(Color.WHITE);
        cintablepanel.add(scrollPane);
        
        cintablepanel1.removeAll();
    	GridBagLayout layout = new GridBagLayout();
    	cintablepanel1.setLayout(layout);        
        GridBagConstraints gbc = new GridBagConstraints();
        SubmitButton = makeButton("Submit");//instantiate new JTextField
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth=1;
        gbc.ipady=5;
        cintablepanel1.add(SubmitButton,gbc);
        
        CancelButton = makeButton("Cancel");//instantiate new JTextField
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth=1;
        gbc.ipady=5;
        cintablepanel1.add(CancelButton,gbc);
        frame.add(cintablepanel,BorderLayout.CENTER);
        frame.add(cintablepanel1,BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}