Library-Management-System
=========================

The Library Management System is a Graphical User Interface Tool which allows librarian to perform following activities.

1)Book Search and Availability

 ->Using this option, librarian can able able to search for a book, given any combination of book_id, title, and/or authors.
Book Loans

2)Checking Out Books

 ->Using this option, librarian can able to check out a book, given the combination of BOOK_COPIES(book_id, branch_id) and BORROWER(Card_no), i.e. create a new tuple in BOOK_LOANS. [April 17] generate a new unique primary key for loan_id. The date_out should be today’s date. The due_date should be 14 days after the date_out. 

 ->Each BORROWER is permitted a maximum of 3 BOOK_LOANS. If a BORROWER already has 3 BOOK_LOANS, then the checkout (i.e. create new BOOK_LOANS tuple) should fail and return a useful error message.

 ->If the number of BOOK_LOANS for a given book at a branch already equals the No_of_copies (i.e. There are no more book copies available at your library_branch), then the checkout should fail and return a useful error message.

3)Checking In Books

 ->Using this option, librarian can able to check in a book. Be able to locate BOOK_LOANS tuples by searching on any of book_id, Card_no, and/or any part of BORROWER name. 

4)Borrower Management 

 ->Using this option, librarian can able to create new borrowers in the system.

5)FINES

 ->Using this option, librarian can pay the fines and display the fines.

System Requirements

Java 1.6 or Later

MySQL
