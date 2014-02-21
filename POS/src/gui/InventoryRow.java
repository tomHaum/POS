package gui;

import soBeSorted.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class InventoryRow extends JPanel implements ActionListener {
	JLabel title;
	JLabel authorFirst;
	JLabel authorLast;
	JLabel quantity;
	JButton addInv;
	Book book;
	int addedLast;

	public InventoryRow(Book b) {
		this.book = b;
		title = new JLabel(book.getTitle());
		authorLast = new JLabel(book.getLast());
		authorFirst = new JLabel(book.getFirst());
		quantity = new JLabel(book.getStock() + "");
		quantity.setMinimumSize(new Dimension(20, quantity.getHeight()));
		quantity.setMaximumSize(new Dimension(40, quantity.getHeight()));
		quantity.setSize(new Dimension(30, quantity.getHeight()));
		addInv = new JButton("Add more");
		addInv.addActionListener(this);

		this.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.ipadx = 10;
		//g.insets = new Insets(1, 1, 1, 1);
		g.gridx = 0;
		g.gridy = 0;
		g.weightx = 3;
		g.weighty = 1;
		this.add(title, g);
		g.weightx = 1;
		g.gridx++;
		this.add(authorLast, g);
		
		g.gridx++;
		this.add(authorFirst, g);
		g.weightx = 0;
		g.gridx++;
		this.add(quantity, g);
		g.gridx++;
		this.add(addInv, g);
	}

	public void update(Book b) {
		this.book = b;
		title.setText(book.getTitle());
		authorLast.setText(book.getLast());
		authorFirst.setText(book.getFirst());
		quantity.setText(book.getStock() + "");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String numAsString = (String) JOptionPane.showInputDialog(new JFrame(),
				"How Many More Books\n" + "Would You Like To Add?",
				"Add More Books", JOptionPane.PLAIN_MESSAGE, null, null,
				addedLast + "");
		int toAdd = 0;
		try {
			toAdd = Integer.parseInt(numAsString);
			addedLast = toAdd;

		} catch (Exception ignored) {

		}
		this.book.addCopies(toAdd);
		this.update(this.book);
	}
}
