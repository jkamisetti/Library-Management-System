import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



class search extends dbproject{
	
	public void searchPanel() {
		panel.removeAll();
    	GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);    
        GridBagConstraints gbc = new GridBagConstraints();
                
        JLabel titleLable = new JLabel();//instantiate new JLabel
    	titleLable.setText("");//set label text to name
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth=2;
        panel.add(titleLable,gbc);
        
        gbc.gridwidth=1;      
    	JLabel label1 = new JLabel();//instantiate new JLabel
    	label1.setText("Book Id:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(label1,gbc);
        
        //textField1.setText("Enter BookID");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(textField1,gbc); 
             
    	JLabel label2 = new JLabel();//instantiate new JLabel
    	label2.setText("Title:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(label2,gbc);
               
        
        //textField2.setText("Enter Title");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(textField2,gbc);
        
        
    	JLabel label3 = new JLabel();//instantiate new JLabel
    	label3.setText("Author Name:");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(label3,gbc);

        //textField3.setText("Enter Author Name");//clear JTextField
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(textField3,gbc);
        
    	JLabel label4 = new JLabel();//instantiate new JLabel
    	label4.setText("");//set label text to name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth=2;
        gbc.ipady=6;
        panel.add(label4,gbc);
        
        searchButton = makeButton("Search");//instantiate new JTextField
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth=1;
        gbc.ipady=5;
        panel.add(searchButton,gbc);
        
        clearButton = makeButton("Clear");//instantiate new JTextField
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth=1;
        gbc.ipady=5;
        panel.add(clearButton,gbc);
        frame.add(panel,BorderLayout.NORTH);
        frame.setVisible(true);

    }
	
    public void TablePanel(String[][] dataValues) {
        
		// Create columns names
    	tablepanel.removeAll();
		String columnNames[] = { "book_id", "title", "author(s)", "branch_id","NO.Of copies at each branch","NO.Of available copies at each branch" };
        JTable Table = new JTable(dataValues,columnNames);//instantiate new JTextField
        JScrollPane scrollPane = new JScrollPane(Table);
        //scrollPane.setSize(100, 100);
        tablepanel.setLayout(new BorderLayout());
        tablepanel.setBackground(Color.WHITE);
        tablepanel.add(scrollPane);
        frame.add(tablepanel,BorderLayout.CENTER);
        frame.setVisible(true);
    }
	
}