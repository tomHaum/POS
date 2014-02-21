package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import soBeSorted.*;
//has yet to be fully implemented
//will take over the spaghetti in the main class
public class Inventory implements ActionListener {
	JPanel master;
	JButton addNewBook;
	List<Book> book;
	List<InventoryRow> row;

	Inventory() {
		master = new JPanel();
		addNewBook = new JButton("Add New Book");
		addNewBook.addActionListener(this);
		master.setLayout(new GridLayout(0,3));
	
	}

	public void actionPerformed(ActionEvent arg0) {
		String bookData = "";
		 bookData += (String)JOptionPane.showInputDialog(new JFrame(),
                "How much does\n"
                + "This book cost?",//message
                "New Book:Price",//frame title
                JOptionPane.PLAIN_MESSAGE,//type of dialog
                null,//icon
                null,//options
                null);//default text
		bookData += "|";
		bookData += (String)JOptionPane.showInputDialog(new JFrame(),
                "What is the title\n"
                + "of this book?",//message
                "New Book:Title",//frame title
                JOptionPane.PLAIN_MESSAGE,//type of dialog
                null,//icon
                null,//options
                null);//default text
		bookData += (String)JOptionPane.showInputDialog(new JFrame(),
                "What is the authors\n"
                + "First name?",//message
                "New Book:Author",//frame title
                JOptionPane.PLAIN_MESSAGE,//type of dialog
                null,//icon
                null,//options
                null);//default text
		bookData += "|";
		bookData += (String)JOptionPane.showInputDialog(new JFrame(),
                "What is the authors\n"
                + "Last name?",//message
                "New Book:Author",//frame title
                JOptionPane.PLAIN_MESSAGE,//type of dialog
                null,//icon
                null,//options
                null);//default text
		bookData += "|";
		bookData += (String)JOptionPane.showInputDialog(new JFrame(),
                "What is the books\n"
                + "ISBN?",//message
                "New Book:ISBN",//frame title
                JOptionPane.PLAIN_MESSAGE,//type of dialog
                null,//icon
                null,//options
                null);//default text
		bookData += "|";
		bookData += (String)JOptionPane.showInputDialog(new JFrame(),
                "How many copies of this book\n"
                + "do you currenty have?",//message
                "New Book:Stock",//frame title
                JOptionPane.PLAIN_MESSAGE,//type of dialog
                null,//icon
                null,//options
                null);//default text
		
			
		Book newBook = new Book(bookData);
		String bookName = JOptionPane.showInputDialog("enter Books Name");
		System.out.println(bookName);
	}

}
