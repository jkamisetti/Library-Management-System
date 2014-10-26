import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;



class borrower extends dbproject{
    public void NewBorrowerPanel() {
    	newborrowerpanel.removeAll();
    	GridBagLayout layout = new GridBagLayout();
        newborrowerpanel.setLayout(layout);        
        GridBagConstraints gbc = new GridBagConstraints();
        
    	JLabel label1 = new JLabel();//instantiate new JLabel
    	label1.setText("First Name:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        newborrowerpanel.add(label1,gbc);
        
        
        //FnameField.setText("Enter FirstName");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 0;
        newborrowerpanel.add(FnameField,gbc); 
             
    	JLabel label2 = new JLabel();//instantiate new JLabel
    	label2.setText("Last Name:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        newborrowerpanel.add(label2,gbc);
        
        //LnameField.setText("Enter LastName");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 1;
        newborrowerpanel.add(LnameField,gbc);
        
        
    	JLabel label3 = new JLabel();//instantiate new JLabel
    	label3.setText("Address:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        newborrowerpanel.add(label3,gbc);
        
        //AddressField.setText("Enter Address");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 2;
        newborrowerpanel.add(AddressField,gbc);
        
    	JLabel label4 = new JLabel();//instantiate new JLabel
    	label4.setText("Phone Number");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth=1;
        newborrowerpanel.add(label4,gbc);
        

        //PhoneField.setText("Enter Phone Number");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 3;
        newborrowerpanel.add(PhoneField,gbc);
        
        
        AddButton = makeButton("Add Borrower");//instantiate new JTextField
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth=1;
        gbc.ipady=5;
        newborrowerpanel.add(AddButton,gbc);
        
        clearButton = makeButton("Clear");//instantiate new JTextField
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth=1;
        gbc.ipady=5;
        newborrowerpanel.add(clearButton,gbc);
        frame.add(newborrowerpanel,BorderLayout.NORTH);
        frame.setVisible(true);

    }
    
    public  void BorrowerMessage(String message,Color color) {
    	newborrowerpanel1.removeAll();
    	GridBagLayout layout = new GridBagLayout();
    	newborrowerpanel1.setLayout(layout); 
     	JLabel label1 = new JLabel();//instantiate new JLabel
    	label1.setText(message);//set label text to name
    	label1.setForeground(color);
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth=10;
        newborrowerpanel1.add(label1,gbc);
        frame.add(newborrowerpanel1,BorderLayout.CENTER);
        frame.setVisible(true);
    }

	
}