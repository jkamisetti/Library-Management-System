import java.awt.event.*;
import javax.swing.*;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class dbproject  implements ActionListener {
	static Connection conn = null;
	static Statement stmt;
	static JFrame frame = new JFrame();
	JButton searchButton;
	JButton clearButton;
	JButton SubmitButton;
	JButton CancelButton;
	JButton AddButton;
	JButton UpdateButton;
    JTextField textField1 = new JTextField(12);//instantiate new JTextField
    JTextField textField2 = new JTextField(12);//instantiate new JTextField
    JTextField textField3 = new JTextField(12);//instantiate new JTextField
    JTextField FnameField = new JTextField(12);//instantiate new JTextField       
    JTextField LnameField = new JTextField(12);//instantiate new JTextField
    JTextArea  AddressField = new JTextArea(5,15);//instantiate new JTextField
    JTextField PhoneField = new JTextField(12);//instantiate new JTextField
    JTable CheckInTable;
    JTextField BookIDField = new JTextField(12);//instantiate new JTextField
    JTextField CardNumberField = new JTextField(12);//instantiate new JTextField
    JTextField BranchIdField = new JTextField(12);
    JTextField LoanIdField = new JTextField(12);
    JTextField FineField = new JTextField(12);
    
    static JPanel panel=new JPanel();
    static JPanel IconPanel=new JPanel();
    static JPanel coutpanel= new JPanel();
	static JPanel tablepanel= new JPanel();
	static JPanel coutpanel1= new JPanel();
	static JPanel cinpanel = new JPanel();
	static JPanel cintablepanel =new JPanel();
	static JPanel cintablepanel1 =new JPanel();
	static JPanel newborrowerpanel = new JPanel();
	static JPanel newborrowerpanel1 = new JPanel();
	static JPanel finespanel = new JPanel();
	static JPanel finespanel1 = new JPanel();
	sqlqueryprocessor queryProcessor = new sqlqueryprocessor();
	static int rowLength=0;
	boolean firsttime=true;
	// Create some data

    public static void main(String[] s) {
        new dbproject();
    }
 
   /* protected dbproject(){
    	
    }*/
    protected dbproject() {
    	queryProcessor.startDatabase();
        //super("JMenu Example");
    	frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
 try{
    	conn = DriverManager.getConnection("jdbc:mysql://localhost/company", "root", "password");
    	stmt = conn.createStatement();
    	stmt.execute("use library;");
 }catch(Exception e)
 {
	 System.out.println(e.getMessage());
 }
 
 if(firsttime)
 {
        // Name the JMenu & Add Items
        JMenu menu = new JMenu("BookQuery");
        menu.add(makeMenuItem("Search and Availability"));
  
        // Name the JMenu & Add Items
        JMenu menu2 = new JMenu("BookLoans");
        menu2.add(makeMenuItem("CheckingIn"));
        menu2.add(makeMenuItem("CheckingOut"));
 
        
        //Name the JMenu & Add Items
        JMenu menu3 = new JMenu("BorrowerManagement");
        menu3.add(makeMenuItem("NewBorrower"));
 
        JMenu menu4 = new JMenu("Fines");
        menu4.add(makeMenuItem("UpdateFines"));
        menu4.add(makeMenuItem("PayFines"));
        
        //Add JMenu bar
        JMenuBar menuBar = new JMenuBar();        
        menuBar.add(menu);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        
  
    	//frame.setLayout(new BorderLayout());
//        frame.add(label);
        frame.setJMenuBar(menuBar);
        firsttime=false;
        frame.setSize(800, 800);
        frame.setLocation(200, 200);
        frame.setVisible(true);
 }


    }
 
    public void actionPerformed(ActionEvent e) {
        // Menu item actions
        String command = e.getActionCommand();
 
        if (command.equals("Search and Availability")) {
        	frameRefresh();
        	search searchObj=new search();
        	searchObj.searchPanel();
        } else if (command.equals("CheckingIn")) {
            // Save menu item action
        	frameRefresh();
        	loans loanObj=new loans();
        	loanObj.CheckInPanel();
        }else if (command.equals("CheckingOut")) {
            // Save menu item action
        	frameRefresh();
        	loans loanObj=new loans();
        	loanObj.CheckOutPanel();
        }else if (command.equals("NewBorrower")) {
            // Save menu item action
        	frameRefresh();
        	borrower borrowerObj=new borrower();
        	borrowerObj.NewBorrowerPanel();
        }else if (command.equals("UpdateFines")) {
            // Save menu item action
        	fines finesObj=new fines();
        	frameRefresh();
        	fines fobj=new fines();
        	fobj.FinesRefreshPanel();
        }else if(command.equals("Update/Refresh"))
        {
        	fines fobj=new fines();
            double Fine_amt=0.0;
      	    String sqlfineQuery1="SELECT Loan_id,Due_date,Date_in,DATEDIFF(Date_in,Due_date) AS Diff_date FROM BOOK_LOANS WHERE Date_in IS NOT null;";
      	    String sqlfineQuery2="SELECT Loan_id,Due_date,Date_in,DATEDIFF(NOW(),Due_date) AS Diff_date FROM BOOK_LOANS WHERE Date_in IS null;";
        	System.out.println(sqlfineQuery1);
        	try{
            	ResultSet rf=stmt.executeQuery("SELECT Loan_id,Due_date,Date_in,DATEDIFF(Date_in,Due_date) AS Diff_date FROM BOOK_LOANS WHERE Date_in IS NOT null;");
            System.out.println("Update Fines-2");
			while (rf.next()) {
				// Keep track of the line/tuple count
				// Populate field variables				
				if(rf.getInt("Diff_date") >0)
				{
					Fine_amt = (double)rf.getInt("Diff_date")*0.25;
				}else{
					Fine_amt=0.0;
				}
				String sqlfineQuery3="SELECT Loan_id,Fine_amt,Paid FROM FINES WHERE Loan_id="+rf.getInt("Loan_id")+" ;";
				ResultSet rsfine3=stmt.executeQuery(sqlfineQuery3);
				if (rsfine3.next()) {
					if(rsfine3.getInt("Paid")==0)
					{
						stmt.executeUpdate("UPDATE FINES SET Fine_amt="+Fine_amt+" WHERE Loan_id="+rf.getInt("Loan_id")+" ;");
					}
				}else{
					stmt.executeUpdate("INSERT INTO FINES (Loan_id,Fine_amt) VALUES("+rf.getInt("Loan_id")+","+Fine_amt+");");
				}
			}
				//rsfine1.close();
				
	            ResultSet rsfine2=stmt.executeQuery(sqlfineQuery2);
				System.out.println("Update Fines-3");
			while (rsfine2.next()) {
				if(rsfine2.getInt("Diff_date") >0)
				{
					Fine_amt = (double)rsfine2.getInt("Diff_date")*0.25;
				}else{
					Fine_amt=0.0;
				}
				String sqlfineQuery4="SELECT Loan_id,Fine_amt,Paid FROM FINES WHERE Loan_id="+rsfine2.getInt("Loan_id")+" ;";
				ResultSet rsfine4=stmt.executeQuery(sqlfineQuery4);
				if (rsfine4.next()) {
					if(rsfine4.getInt("Paid")==0)
					{
						stmt.executeUpdate("UPDATE FINES SET Fine_amt="+Fine_amt+" WHERE Loan_id="+rsfine4.getInt("Loan_id")+" ;");
					}
				}else{
					stmt.executeUpdate("INSERT INTO FINES (Loan_id,Fine_amt) VALUES("+rsfine4.getInt("Loan_id")+","+Fine_amt+");");
				}
						
				rsfine2.close();
			}
			
			System.out.println("Update Fines-4");
        	String sqlQuery="SELECT FINES.Loan_id,FINES.Fine_amt,FINES.Paid, BOOK_LOANS.Card_no, SUM(FINES.Fine_amt) AS Total_Fine FROM FINES,BOOK_LOANS WHERE BOOK_LOANS.Loan_id=FINES.Loan_id GROUP BY BOOK_LOANS.Card_no;";	
        	ResultSet rs=stmt.executeQuery(sqlQuery);
        	int linect=0;
			while (rs.next()) {
				linect++;
			}
			String[][] dataValues=new String[linect][6];
			// Iterate through the result set using ResultSet class's next() method
			//rs.first();
			rs.beforeFirst();
			int i=0;
			while (rs.next()) {
				// Keep track of the line/tuple count
				// Populate field variables
				
				dataValues[i][0] = rs.getString("Loan_id");
				dataValues[i][1] = rs.getString("Fine_amt");
				dataValues[i][2] = rs.getString("Paid");
				dataValues[i][3] = rs.getString("Card_no");
				dataValues[i][4] = rs.getString("Total_Fine");
				i++;
			} // End while(rs.next())
			System.out.println("Update Fines-5");
			fobj.DisplayFinesPanel(dataValues);
        	rs.close();
        	}catch(Exception ex)
        	{
        		System.out.println(ex.getMessage());
        	}
        	
        	
        }else if (command.equals("PayFines")) {
            // Save menu item action
        	fines finesObj=new fines();
        	frameRefresh();
        	finesObj.FinesPaymentPanel();
        }else if (command.equals("Search")) {
            // Save menu item action
        	//String sqlQuery="SELECT BOOK.Book_id,BOOK.Title,BOOK_AUTHORS.Author_name,BOOK_COPIES.Branch_id,BOOK_COPIES.No_of_copies FROM BOOK , BOOK_AUTHORS, BOOK_COPIES WHERE BOOK.Book_id=BOOK_AUTHORS.Book_id AND BOOK.Book_id=BOOK_COPIES.Book_id AND ";
        	//String sqlQuery="SELECT BOOK.Book_id,BOOK.Title,BOOK_AUTHORS.Author_name,BOOK_COPIES.Branch_id,BOOK_COPIES.No_of_copies,(BOOK_COPIES.No_of_copies-output2.output) AS No_of_available_copies FROM BOOK, BOOK_AUTHORS, BOOK_COPIES LEFT JOIN (select BOOK_COPIES.Branch_id, BOOK.Book_id, ifnull(count(1),0) as output FROM BOOK,BOOK_LOANS,BOOK_COPIES WHERE Date_in is null group by Branch_id,Book_id) AS output2 ON output2.Book_id = BOOK.Book_id AND output2.Branch_id = BOOK_COPIES.Branch_id WHERE BOOK.Book_id=BOOK_AUTHORS.Book_id AND BOOK.Book_id=BOOK_COPIES.Book_id AND ";
        	
        	String sqlQuery="SELECT B.Book_id,B.Title,BA.Author_name,BC.Branch_id,BC.No_of_copies,(BC.No_of_copies-output2.output) AS No_of_available_copies FROM BOOK B LEFT JOIN BOOK_AUTHORS AS BA ON BA.Book_id = B.Book_id LEFT JOIN BOOK_COPIES AS BC ON BC.Book_id = B.Book_id LEFT JOIN (select Branch_id, Book_id, ifnull(count(1),0) as output FROM BOOK_LOANS WHERE Date_in is null group by Branch_id,Book_id) AS output2 ON output2.Book_id = B.Book_id AND output2.Branch_id = BC.Branch_id WHERE ";
        	boolean prev=false;
        	if(!textField1.getText().isEmpty())
        	{
        		sqlQuery+="B.Book_id  LIKE '%"+textField1.getText()+"%'";
        		prev=true;
        	}
        	
        	if(!textField2.getText().isEmpty())
        	{
        		if(prev)
        		{
        			sqlQuery+=" AND ";
        		}
        		sqlQuery+="B.Title LIKE '%"+textField2.getText()+"%'";
        	}
        	
        	if(!textField3.getText().isEmpty())
        	{
        		if(prev)
        		{
        			sqlQuery+=" AND ,";
        			prev=false;
        		}
        		sqlQuery+="BA.Author_name LIKE '%"+textField3.getText()+"%'";
        	}
        	sqlQuery+=";";
        	System.out.println(sqlQuery);
        	try{
        	ResultSet rs=stmt.executeQuery(sqlQuery);
        	int linect=0;
			while (rs.next()) {
				linect++;
			}
			String[][] dataValues=new String[linect][6];
			// Iterate through the result set using ResultSet class's next() method
			//rs.first();
			rs.beforeFirst();
			int i=0;
			while (rs.next()) {
				// Keep track of the line/tuple count
				// Populate field variables
				
				dataValues[i][0] = rs.getString("Book_id");
				dataValues[i][1] = rs.getString("Title");
				dataValues[i][2] = rs.getString("Author_name");
				dataValues[i][3] = rs.getString("Branch_id");
				dataValues[i][4] = rs.getString("No_of_copies");

				if(rs.getString("No_of_available_copies")==null)
				{
					dataValues[i][5] = rs.getString("No_of_copies");
				}else{
					dataValues[i][5] = rs.getString("No_of_available_copies");
				}
				
				i++;
			} // End while(rs.next())
			
			search searchObj=new search();
			searchObj.TablePanel(dataValues);
        	rs.close();
        	}catch(Exception ex)
        	{
        		System.out.println(ex.getMessage());
        	}
        	
        }else if(command.equals("Checkout"))
        {
        	String sqlQuery="INSERT INTO BOOK_LOANS (Book_id,Branch_id,Card_no,date_out,due_date,date_in) VALUES(";
        	if(!BookIDField.getText().isEmpty())
        	{
        		sqlQuery+="'"+BookIDField.getText()+"'";
        	}
        	if(!BranchIdField.getText().isEmpty())
        	{
        		sqlQuery+=","+BranchIdField.getText();
        	}
        	
        	if(!CardNumberField.getText().isEmpty())
        	{
        		sqlQuery+=","+CardNumberField.getText();
        	}
      	        	
        	sqlQuery+=",now(),ADDDATE(now(),INTERVAL 14 DAY),null );";

        	try{
        		String sqlQuery1="SELECT BC.No_of_copies,(BC.No_of_copies-output2.output) AS No_of_available_copies FROM BOOK B LEFT JOIN BOOK_COPIES AS BC ON BC.Book_id = B.Book_id LEFT JOIN (select Branch_id, Book_id, ifnull(count(1),0) as output FROM BOOK_LOANS WHERE Date_in is null group by Branch_id,Book_id) AS output2 ON output2.Book_id = B.Book_id AND output2.Branch_id = BC.Branch_id WHERE B.Book_id="+"'"+BookIDField.getText()+"'"+" AND BC.Branch_id="+BranchIdField.getText()+";";
        		//System.out.println(sqlQuery1);
        		int No_of_available_copies=0;
        		ResultSet rs=stmt.executeQuery(sqlQuery1);
        		rs.first();
        		System.out.println(rs.getString("No_of_available_copies"));
        		if(rs.getString("No_of_available_copies")==null)
        		{
        			No_of_available_copies = rs.getInt("No_of_copies");
        		}else{
        			No_of_available_copies = rs.getInt("No_of_available_copies");
        		}
        		
            	if(No_of_available_copies ==0)
				{
            		loans loanObj=new loans();
                	loanObj.checkoutMessage("No Book Available for Book Id "+BookIDField.getText()+" At Branch "+BranchIdField.getText(),Color.RED);
				}else{
				String sqlQuery2="SELECT COUNT(Loan_id) AS MaxBooksTaken FROM BOOK_LOANS WHERE Card_no ="+CardNumberField.getText()+";";
				System.out.println(sqlQuery2);
				ResultSet rs2=stmt.executeQuery(sqlQuery2);
				rs2.first();
            	if(rs2.getInt("MaxBooksTaken") >=3)
				{
            		loans loanObj=new loans();
                	loanObj.checkoutMessage("Checkout Failed:Already Reached the Maximum Limit of Book Loans (Max Book Limit is 3)",Color.RED);
				}else{
		        System.out.println(sqlQuery);
        		stmt.executeUpdate(sqlQuery);
            	loans loanObj=new loans();
            	loanObj.checkoutMessage("Sucessfully Checkout the Book",Color.GREEN);
				}
				}
        	}catch(Exception ex)
        	{
        		System.out.println("Exception"+ex.getMessage());
        	}
        }else if (command.equals("Locate")) {
        	//String sqlQuery="SELECT Book_id,Branch_id,Card_no,Date_out,Date_in FROM BOOK_LOANS WHERE ";
        	String sqlQuery="SELECT Loan_id,Book_id,Branch_id,BL.Card_no,Fname,Lname,Date_out FROM BOOK_LOANS AS BL,BORROWER AS BR WHERE ";
        	boolean prev=false;
        	if(!BookIDField.getText().isEmpty())
        	{
        		sqlQuery+="BL.Book_id LIKE '%"+BookIDField.getText()+"%'";
        		prev=true;
        	}
        	
        	if(!CardNumberField.getText().isEmpty())
        	{
        		if(prev)
        		{
        			sqlQuery+=" AND ";
        		}
        		sqlQuery+="BL.Card_no LIKE '%"+CardNumberField.getText()+"%'";
        	}
        	
        	if(!FnameField.getText().isEmpty())
        	{
        		if(prev)
        		{
        			sqlQuery+=" AND ";
        		}
        		sqlQuery+="Fname LIKE '%"+FnameField.getText()+"%'";
        	}
        	
        	if(!LnameField.getText().isEmpty())
        	{
        		if(prev)
        		{
        			sqlQuery+=" AND ";
        		}
        		sqlQuery+="Lname LIKE '%"+LnameField.getText()+"%'";
        	}
        	sqlQuery+="AND BR.Card_no=BL.Card_no AND Date_in IS null;";
        	System.out.println(sqlQuery);
        	try{
            	ResultSet rs=stmt.executeQuery(sqlQuery);
            	
            	int linect=0;
    			while (rs.next()) {
    				linect++;
    			}
    			System.out.println("linect "+linect);
    			rowLength=linect;
            	Object[][] dataValues =new Object[linect][9];
    			// Iterate through the result set using ResultSet class's next() method
    			//rs.first();
    			rs.beforeFirst();
    			int i=0;
    			while (rs.next()) {
    				// Keep track of the line/tuple count
    				// Populate field variables
    				dataValues[i][0] = Boolean.FALSE;
    				dataValues[i][1] = rs.getString("Loan_id");
    				dataValues[i][2] = rs.getString("Book_id");
    				dataValues[i][3] = rs.getString("Branch_id");
    				dataValues[i][4] = rs.getString("Card_no");
    				dataValues[i][5] = rs.getString("Fname");
    				dataValues[i][6] = rs.getString("Lname");
    				dataValues[i][7] = rs.getString("Date_out");
    				dataValues[i][8] ="";
    				i++;
    			} // End while(rs.next())
            	
                loans loanObj=new loans();
                loanObj.cinTablePanel(dataValues);
            	rs.close();
            	}catch(Exception ex)
            	{
            		System.out.println(ex.getMessage());
            	}
            	
            	

        }else if (command.equals("Add Borrower")){
            int cardNumber=0;
            borrower boj=new borrower();
        	String sqlQuery="INSERT INTO BORROWER VALUES(";
        	boolean fieldchecker=true;
        	try{
            	ResultSet rs=stmt.executeQuery("SELECT MAX(Card_no) AS Card_no FROM BORROWER;");
            	if(rs.next())
            	{
            		cardNumber=Integer.parseInt(rs.getString("Card_no"))+1;
            	}else{
            		cardNumber=1001;
            	}
            	sqlQuery+=cardNumber;
            	rs.close();
            	}catch(Exception ex)
            	{
            		System.out.println(ex.getMessage());
            	}
 
        	if(!FnameField.getText().isEmpty())
        	{
        		sqlQuery+=",'"+FnameField.getText()+"'";
        	}else{
        		boj.BorrowerMessage("First Name should not be Empty, Enter First Name",Color.RED);
        		fieldchecker=false;
        	}
        	if(!LnameField.getText().isEmpty())
        	{
        		sqlQuery+=",'"+LnameField.getText()+"'";
        	}else{
        		boj.BorrowerMessage("Last Name should not be Empty, Enter First Name",Color.RED);
        		fieldchecker=false;
        	}
        	if(!AddressField.getText().isEmpty())
        	{
        		sqlQuery+=",'"+AddressField.getText()+"'";
        	}else{
        		boj.BorrowerMessage("Address should not be Empty, Enter First Name",Color.RED);
        		fieldchecker=false;
        	}
        	if(!PhoneField.getText().isEmpty())
        	{
        		sqlQuery+=",'"+PhoneField.getText()+"'";
        	}
        	sqlQuery+=");";
        	if(fieldchecker)
        	{
        	System.out.println(sqlQuery);
        	try{
        		
        		String sqlcheckquery="SELECT Card_no FROM BORROWER WHERE Fname='"+FnameField.getText()+"' AND Lname="+"'"+LnameField.getText()+"'"+" AND Address="+"'"+AddressField.getText()+"';";
        		System.out.println(sqlcheckquery);
        		ResultSet rsq=stmt.executeQuery(sqlcheckquery);
        		if(rsq.next()){		
        			boj.BorrowerMessage("Fname Lname and Address Already Exists in the System",Color.RED);
        		}else{
            	stmt.executeUpdate(sqlQuery);
            	boj.BorrowerMessage("Successfully Added New Borrower with Card Number "+cardNumber,Color.GREEN);
        		}
        	}catch(Exception ex)
        	{
        		System.out.println(ex.getMessage());
        	} 
        	}else{
        		boj.BorrowerMessage("Failed to Add New Borrower",Color.RED);
        	} 
        }else if(command.equals("Submit")){
        	System.out.println("Submit "+rowLength);
        	boolean status=false;
        	for(int i=0;i<rowLength;i++)
        	{
        		String sqlQuery="UPDATE BOOK_LOANS SET Date_in='";
        		System.out.println("IN FOR");
        			if(CheckInTable.getModel().getValueAt(i,0)==Boolean.TRUE)
        			{
        				System.out.println("checkIndate="+CheckInTable.getModel().getValueAt(i, 8)+":");
        				if(CheckInTable.getModel().getValueAt(i, 8).equals(""))
        				{
        	            	JOptionPane.showMessageDialog(null,"Checkin Date Should not be empty");
        				}else{
        					try{
        				//System.out.println(CheckInTable.getModel().getValueAt(i, j));
        				  sqlQuery+=CheckInTable.getModel().getValueAt(i, 8)+"' "+"WHERE Loan_id="+CheckInTable.getModel().getValueAt(i, 1)+" AND Book_id='"+CheckInTable.getModel().getValueAt(i, 2)+"';";
        				  stmt.executeUpdate(sqlQuery);
        				  status=true;
        					}catch(Exception ex)
        					{
        						System.out.println(ex.getMessage());
        					}
        				System.out.println(sqlQuery);
        				
        				}
        			}
        		
        	}
        	if(status)
        	{
        		JOptionPane.showMessageDialog(null,"Sucessfully Checked In");
        	}
        	
        }else if(command.equals("Pay"))
        {
        	System.out.println("Payment");
        	String sqlQuery1="SELECT Loan_id FROM BOOK_LOANS WHERE Loan_id="+LoanIdField.getText()+" AND Date_in IS NOT null;";
        	try{
        	ResultSet rs=stmt.executeQuery(sqlQuery1);
        	if(rs.next())
        	{
        		stmt.executeUpdate("UPDATE FINES SET Paid=1;");
        		JOptionPane.showMessageDialog(null,"Payment Successful");
        	}else{
        		JOptionPane.showMessageDialog(null,"Payment Not Allowed for books that are not yet returned.");
        	}
        	}catch(Exception ex)
        	{
        		
        	}
        	
        }
    }
 
    private JMenuItem makeMenuItem(String name) {
        JMenuItem m = new JMenuItem(name);
        m.addActionListener(this);
        return m;
    }
    
    protected JButton makeButton(String name) {
    	JButton m = new JButton(name);
        m.addActionListener(this);
        return m;
    }
    
    private void frameRefresh()
    {
    	System.out.println("Frame Repainting");
    	frame.remove(tablepanel);
    	frame.remove(panel);
    	frame.remove(cintablepanel);
       	frame.remove(cintablepanel1);
    	frame.remove(coutpanel1);
    	frame.remove(coutpanel);
       	frame.remove(cinpanel);
       	frame.remove(newborrowerpanel);
       	frame.remove(newborrowerpanel1);
       	frame.remove(finespanel);
       	frame.repaint();
    }
    
}