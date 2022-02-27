package domain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class CustomerBill {

	private JFrame frame;
	public ArrayList<Cart> cart;
	private Date purchaseDate;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	private double price;
	private double totalDiscount;
	
	public CustomerBill(ArrayList<Cart> cart, Date purchaseDate) {
		initialize();
		this.cart = cart;
		this.purchaseDate = purchaseDate;
		frame.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 446, 626);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea jtxtReceipt = new JTextArea();
		jtxtReceipt.setBounds(41, 45, 316, 403);
		frame.getContentPane().add(jtxtReceipt);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				jtxtReceipt.print();
			}
			catch(java.awt.print.PrinterException e) {
				System.err.format("No printer found", e.getMessage());
			}
				
			}
		});
		btnPrint.setBounds(154, 485, 115, 29);
		frame.getContentPane().add(btnPrint);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(24, 485, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnTotal = new JButton("CALCULATE");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//=======================================
				jtxtReceipt.setEditable(true);
				//=======================================
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				jtxtReceipt.append("Date: " + sdf.format(purchaseDate));
				jtxtReceipt.append("\n---Products---\n");
				for (Cart p : cart) {
					if(p.getP() instanceof Food) {
						Food p1 = (Food)p.getP();
						price += p.quantity * p1.getPrice();
						jtxtReceipt.append(( "\n" + p1.name + " " + p1.brand + "\n" + p.getQuantity() + " x " 
								+ "$" + p1.getPrice() + " = $" + df.format((p.getQuantity() * p1.getPrice()))) + "\n");
						if(p1.isCalculate()) {
							jtxtReceipt.append("#discount " + p1.getDiscountPercent() + "% -" + df.format((p.getQuantity() * p1.getPrice()) * p1.getDiscount()) );
							totalDiscount += (p.getQuantity() * p1.getPrice()) * p1.getDiscount();
						}
					
					}
					if(p.getP() instanceof Beverage) {
						Beverage p2 = (Beverage)p.getP();
						price += p.quantity * p2.getPrice();
						jtxtReceipt.append("\n\n" + p2.name + " " + p2.brand + "\n" + p.getQuantity() + " x " 
								+ "$" + p2.getPrice() + " = $" + df.format((p.getQuantity() * p2.getPrice())) + "\n");
						if(p2.isCalculate()) {
							jtxtReceipt.append("#discount " + p2.getDiscountPercent() + "% -" + df.format((p.getQuantity() * p2.getPrice()) * p2.getDiscount()) );
							totalDiscount += (p.getQuantity() * p2.getPrice()) * p2.getDiscount();
						}
					}
					if(p.getP() instanceof Clothes) {
						Clothes p3 = (Clothes)p.getP();
						price += p.quantity * p3.getPrice();
						jtxtReceipt.append("\n\n" + p3.name + " " + p3.brand + " " + p3.getSize() + " " + p3.getColor() + "\n" + p.getQuantity() + " x " 
								+ "$" + p3.getPrice() + " = $" + df.format((p.getQuantity() * p3.getPrice())) + "\n");
						if(p3.isCalculate()) {
							jtxtReceipt.append("#discount " + p3.getDiscountPercent() + "% -" + df.format((p.getQuantity() * p3.getPrice()) * p3.getDiscount()));
							totalDiscount += (p.getQuantity() * p3.getPrice()) * p3.getDiscount();
						}
					}
					if(p.getP() instanceof Appliance) {
						Appliance p4 = (Appliance)p.getP();
						price +=p.quantity * p4.getPrice();
						jtxtReceipt.append("\n\n" + p4.name + " " + p4.brand + " " + p4.getModel() + "\n" + p.getQuantity() + " x " 
								+ "$" + p4.getPrice() + " = $" + df.format((p.getQuantity() * p4.getPrice())) + "\n");
						if(p4.isCalculate()) {
							jtxtReceipt.append("#discount " + p4.getDiscountPercent() + "% -" + df.format((p.getQuantity() * p4.getPrice()) * p4.getDiscount()) );
							totalDiscount += (p.getQuantity() * p4.getPrice()) * p4.getDiscount();
						}
								 
					}
					
					}
				jtxtReceipt.append("\n----------------------------------------------------------\n");
				jtxtReceipt.append("SUBTOTAL: $" + df.format(price));
				jtxtReceipt.append("\nDISCOUNT: -$" + df.format(totalDiscount));
				jtxtReceipt.append("\n\n TOTAL: " + df.format(price - totalDiscount));
				
			}}
				
			
		);
		btnTotal.setBounds(284, 485, 115, 29);
		frame.getContentPane().add(btnTotal);
	}}

