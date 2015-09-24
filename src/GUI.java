import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * GUI for program
 * @author Connor LoMonaco
 * @version 4/01/2015
 */
public class GUI extends JPanel implements ActionListener {

	private JTextField text;
	private JTextField compareText1;
	private JTextField compareText2;
	private JTextField guessText;
	private String compare1Formal;
	private String compare2Formal;
	Model myModel;
	JFrame frame;
	JFrame attributeFrame;
	JFrame abbrFrame;
	JFrame compareFrame;
	JPanel p;

	/**
	 * Creates the UI for the program, complete with buttons/labels/text fields
	 * and subsequent frames/etc that are created by each button
	 * 
	 * @param m  the model to handle computations
	 */
	public GUI(Model m) {
		myModel = m;
		frame = new JFrame("DNA Helper");
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(500, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setJMenuBar(createMenuBar());

		JLabel tLabel = new JLabel("Original DNA Strand (5' -> 3':");
		text = new JTextField("");
		text.setPreferredSize(new Dimension(300, 50));
		JPanel tPanel = new JPanel();
		tPanel.add(tLabel);
		tPanel.add(text);
		frame.add(tPanel, BorderLayout.NORTH);
		text.addActionListener(new ActionListener() {
			/**
			 * What happens after DNA strand is entered Checks for valid strand
			 * as well before displaying new actions and strand/compliment of
			 * the strand
			 */
			public void actionPerformed(ActionEvent e) {
				String inputStrand = text.getText().toUpperCase();
				boolean valid = true;
				for (int i = 0; i < inputStrand.length(); i++) {
					if (inputStrand.charAt(i) != 'A'
							&& inputStrand.charAt(i) != 'C'
							&& inputStrand.charAt(i) != 'G'
							&& inputStrand.charAt(i) != 'T') {
						valid = false;
					}
				}
				if (!valid) {
					text.setText("Incorrect Base entered");
				} else {
					myModel.setOriginalStrand(inputStrand);
					JLabel originalBases = new JLabel("Original Strand: "
							+ myModel.getOriginal());
					originalBases.setFont(new Font("Courier New", Font.ITALIC,
							18));

					JLabel complimentBases = new JLabel("Compliment Strand: "
							+ myModel.makeComplimentaryStrand());
					complimentBases.setFont(new Font("Courier New", Font.BOLD,
							18));
					JPanel p1 = new JPanel(new GridLayout(0, 1));

					p1.add(originalBases);
					p1.add(complimentBases);
					frame.add(p, BorderLayout.SOUTH);
					frame.add(p1, BorderLayout.CENTER);
					frame.pack();
				}

			}
		});

		// Button that shows the amino acid attributes
		// such as polar/nonpolar
		JButton bases = new JButton("Show Attributes");
		bases.addActionListener(this);
		bases.setActionCommand("bases");
		bases.setToolTipText("Show Strand base pairs");
		bases.addActionListener(new ActionListener() {
			/**
			 * When Attribute button is pressed, opens a new frame and displays
			 * the attributes of strand/compliment
			 */
			public void actionPerformed(ActionEvent e) {
				// make the attribute frame
				attributeFrame = new JFrame("Attributes");
				attributeFrame.setLayout(new BorderLayout());
				attributeFrame.setPreferredSize(new Dimension(500, 300));

				// Original strand attributes
				JLabel attributes = new JLabel("Original Attributes: "
						+ myModel.getAttributes());
				attributes.setFont(new Font("Courier New", Font.BOLD, 18));

				// compliment strand attributes
				JLabel complimentAttributes = new JLabel(
						"Compliment Attributes: "
								+ myModel.getComplimentAttributes());
				complimentAttributes.setFont(new Font("Courier New", Font.BOLD,
						18));

				// make the jpanel and add labels
				JPanel attributePanel = new JPanel(new GridLayout(0, 1));
				attributePanel.add(attributes);
				attributePanel.add(complimentAttributes);
				attributeFrame.add(attributePanel, BorderLayout.CENTER);
				attributeFrame.pack();
				attributeFrame.setVisible(true);

			}
		});

		// Button that shows the amino acid names
		// in abbreviation form
		JButton abbr = new JButton("Show Amino Acids");
		abbr.addActionListener(this);
		abbr.setActionCommand("abbr");
		abbr.setToolTipText("Show Amino Acids by Abbreviaitons");
		abbr.addActionListener(new ActionListener() {
			/**
			 * When Attribute button is pressed, opens a new frame and displays
			 * the Amino Acid Sequences strand/compliment
			 */
			public void actionPerformed(ActionEvent e) {
				// make the abbreviations frame
				abbrFrame = new JFrame("Abbreviations");
				abbrFrame.setLayout(new BorderLayout());
				abbrFrame.setPreferredSize(new Dimension(500, 300));

				// Original strand abbreviations
				JLabel abbreviatons = new JLabel("Original Acids: "
						+ myModel.getAbbreviations());
				abbreviatons.setFont(new Font("Courier New", Font.BOLD, 18));

				// compliment strand abbreviations
				JLabel complimentAbbreviations = new JLabel(
						"Compliment Acids: "
								+ myModel.getComplimentAbbreviations());
				complimentAbbreviations.setFont(new Font("Courier New",
						Font.BOLD, 18));

				// make the jpanel and add labels
				JPanel abbrPanel = new JPanel(new GridLayout(0, 1));
				abbrPanel.add(abbreviatons);
				abbrPanel.add(complimentAbbreviations);
				abbrFrame.add(abbrPanel, BorderLayout.CENTER);
				abbrFrame.pack();
				abbrFrame.setVisible(true);
			}
		});

		// Button for comparing 2 strands
		// in terms of amino acid and attribute
		JButton compare = new JButton("Compare 2 Strands");
		compare.addActionListener(this);
		compare.setActionCommand("compare");
		compare.setToolTipText("Show Amino Acids by full names");
		compare.addActionListener(new ActionListener() {
			/**
			 * When Compare button is pressed, opens a new frame and displays an
			 * interface to input 2 strands for comparison
			 */
			public void actionPerformed(ActionEvent e) {
				// make the compare frame
				compareFrame = new JFrame("Comparison");
				compareFrame.setLayout(new BorderLayout());
				compareFrame.setPreferredSize(new Dimension(500, 500));

				// text field for first strand
				JLabel tLabel = new JLabel("First Strand (5' -> 3':");
				compareText1 = new JTextField("");
				compareText1.setPreferredSize(new Dimension(300, 50));

				// new panel for textboxes
				final JPanel tPanel = new JPanel(new GridLayout(0, 1));
				tPanel.add(tLabel);
				tPanel.add(compareText1);
				compareFrame.add(tPanel, BorderLayout.NORTH);
				compareFrame.pack();
				compareFrame.setVisible(true);

				compareText1.addActionListener(new ActionListener() {
					/**
					 * When the first strand is entered it is checked for
					 * legitimacy (valid letters) and a new field/label is
					 * created for second strand inputing
					 */
					public void actionPerformed(ActionEvent e) {
						String compareStrand1Raw = compareText1.getText()
								.toUpperCase();
						boolean valid = true;
						// checking for legitimacy
						for (int i = 0; i < compareStrand1Raw.length(); i++) {
							if (compareStrand1Raw.charAt(i) != 'A'
									&& compareStrand1Raw.charAt(i) != 'C'
									&& compareStrand1Raw.charAt(i) != 'G'
									&& compareStrand1Raw.charAt(i) != 'T') {
								valid = false;
							}
						}
						if (!valid) {
							text.setText("Incorrect Base entered");

							// if valid, new textfield created with label
							// for second strand
						} else {
							compare1Formal = compareStrand1Raw;
					//		System.out.println("here 1: " + compare1Formal);
							JLabel tLabel2 = new JLabel(
									"Second Strand (5' -> 3':");
							compareText2 = new JTextField("");
							compareText2
									.setPreferredSize(new Dimension(300, 50));
							tPanel.add(tLabel2);
							tPanel.add(compareText2);
							compareFrame.add(tPanel, BorderLayout.NORTH);
							compareFrame.pack();
							compareText2
									.addActionListener(new ActionListener() {
										/**
										 * When second strand is entered, it is
										 * checked for legitimacy and then the
										 * comparison results are displayed
										 */
										public void actionPerformed(
												ActionEvent e) {
											String compareStrand2Raw = compareText2
													.getText().toUpperCase();
											boolean valid = true;
											for (int i = 0; i < compareStrand2Raw
													.length(); i++) {
												// legitimacy check
												if (compareStrand2Raw.charAt(i) != 'A'
														&& compareStrand2Raw
																.charAt(i) != 'C'
														&& compareStrand2Raw
																.charAt(i) != 'G'
														&& compareStrand2Raw
																.charAt(i) != 'T') {
													valid = false;
												}
											}
											if (!valid) {
												text.setText("Incorrect Base entered");

												// if valid, all new labels are
												// created with
												// comparison data
											} else {
												compare2Formal = compareStrand2Raw;
												final JPanel tPanelCompare = new JPanel(
														new GridLayout(0, 1));

												// to prevent bad loops of
												// trying to input data
												// after the fact, textboxes are
												// removed
												tPanel.removeAll();
												// label showing where specific
												// acids differ
												JLabel differences = new JLabel(
														"Amino Acids Differ at Spot(s): "
																+ myModel
																		.compareAcids(
																				compare1Formal,
																				compare2Formal));
												differences.setFont(new Font(
														"Courier New",
														Font.BOLD, 18));
												// label displaying the first
												// strand
												JLabel strand1Acids = new JLabel(
														"Strand 1: "
																+ myModel
																		.getCompare1());
												strand1Acids.setFont(new Font(
														"Courier New",
														Font.BOLD, 18));
												// second strand
												JLabel strand2Acids = new JLabel(
														"Strand 2: "
																+ myModel
																		.getCompare2());
												strand2Acids.setFont(new Font(
														"Courier New",
														Font.BOLD, 18));
												// Where the strands differ in
												// polarity
												JLabel attributeCompare = new JLabel(
														"Acids Differ in polarity at spot(s): "
																+ myModel
																		.compareAttributes(
																				compare1Formal,
																				compare2Formal));
												attributeCompare
														.setFont(new Font(
																"Courier New",
																Font.BOLD, 18));

												// putting it all up
												tPanelCompare.add(strand1Acids);
												tPanelCompare.add(strand2Acids);
												tPanelCompare.add(differences);
												tPanelCompare
														.add(attributeCompare);
												compareFrame.add(tPanelCompare);
												compareFrame.pack();
											}
										}
									});

						}
					}
				});
			}
		});

		// create button panel and adds buttons to panel (not in logical place)
		p = new JPanel(new GridBagLayout());
		p.add(compare);
		p.add(abbr);
		p.add(bases);

		frame.pack();
		frame.setVisible(true);

	}

	/**
	 * Creates the main menu bar
	 * 
	 * @return MenuBar of Main Frame
	 */
	public JMenuBar createMenuBar() {
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;

		// Create the menu bar.
		menuBar = new JMenuBar();

		// file menu.
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);

		// quit item
		menuItem = new JMenuItem("Quit", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menu.add(menuItem);

		// edit menu
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_N);
		menuBar.add(menu);

		// about menu
		menuItem = new JMenuItem("About", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menuItem.setActionCommand("About");
		menu.add(menuItem);

		return menuBar;
	}

	/**
	 * To add an "About" window at some point
	 */
	public void actionPerformed(ActionEvent ae) {
		if ("About".equals(ae.getActionCommand())) {

		}
	}
}