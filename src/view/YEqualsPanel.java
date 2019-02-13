package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import controller.InputFormatter;
import model.EquationSolver;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

/**
 * Creates the YEqualsPanel. The YEqualsPanel contains a displayPanel and a buttonPanel. 
 * The displayPanel contains 2 JPanels, one for Y1 and one for Y2. Each of these JPanels contains a JLabel and a JTextField for displaying the input. 
 * The buttonPanel contains the buttons used to modify the equation String and the display text fields.
 * 
 * @author jeremyjacobson
 *
 */
@SuppressWarnings("serial")
public class YEqualsPanel extends JPanel {

	private JTextField y1DisplayTextField;
	private JTextField y2DisplayTextField;
	private StringBuilder y1toInput = new StringBuilder();
	private StringBuilder y2toInput = new StringBuilder();
	private StringBuilder y1Text = new StringBuilder();
	private StringBuilder y2Text = new StringBuilder();
	private boolean y1Selected;
	private boolean y2Selected;
	InputFormatter inputFormatter = new InputFormatter();
	EquationSolver equationSolver = new EquationSolver();
	GraphPanel graphPanel;

	/**
	 * Creates the YEqualsPanel
	 * 
	 */
	public YEqualsPanel(GraphPanel graphPanel) {
		this.graphPanel = graphPanel;
		
		setLayout(new BorderLayout(0, 0));		
		
		JPanel displayPanel = createDisplayPanel();
		add(displayPanel, BorderLayout.NORTH);
		
		JPanel buttonPanel = createButtonPanel();
		add(buttonPanel, BorderLayout.CENTER);
	}

	private JPanel createDisplayPanel() {
		JPanel displayPanel = new JPanel();
		displayPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		displayPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel y1 = createY1();
		displayPanel.add(y1);
		
		JPanel y2 = createY2();
		displayPanel.add(y2);
		
		return displayPanel;
	}

	private JPanel createY1() {
		JPanel y1 = new JPanel();
		
		JLabel lblY1 = createLblY1();
		y1.add(lblY1);
		
		y1DisplayTextField = createY1InputTextField();
		y1.add(y1DisplayTextField);
		
		return y1;
	}
	
	private JPanel createY2() {
		JPanel y2 = new JPanel();
		
		JLabel lblY2 = createLblY2();
		y2.add(lblY2);
		
		y2DisplayTextField = createY2InputTextField();
		y2.add(y2DisplayTextField);
		
		return y2;
	}

	private JTextField createY1InputTextField() {
		JTextField y1InputTextField = new JTextField();
		y1InputTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		y1Selected = true;
		y1InputTextField.setColumns(18);
		y1InputTextField.setEditable(false);
		return y1InputTextField;
	}

	private JTextField createY2InputTextField() {
		JTextField y2InputTextField = new JTextField();
		y2InputTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		y2InputTextField.setBackground(Color.LIGHT_GRAY);
		y2Selected = false;
		y2InputTextField.setColumns(18);
		y2InputTextField.setEditable(false);
		return y2InputTextField;
	}
	
	private JLabel createLblY1() {
		JLabel lblY = new JLabel("Y1 =");
		lblY.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		return lblY;
	}

	private JLabel createLblY2() {
		JLabel lblY = new JLabel("Y2 =");
		lblY.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		return lblY;
	}

	private void addY1Text(String addedText) {
		if (addedText.equalsIgnoreCase("_")) {
			y1Text.append("-");
			y1toInput.append("_");
			y1DisplayTextField.setText(y1Text.toString());
		} else {
			y1Text.append(addedText);
			y1toInput.append(addedText);
			y1DisplayTextField.setText(y1Text.toString());
		}
	}
	
	private void addY2Text(String addedText) {
		if (addedText.equalsIgnoreCase("_")) {
			y2Text.append("-");
			y2toInput.append("_");
			y2DisplayTextField.setText(y2Text.toString());
		} else {
			y2Text.append(addedText);
			y2toInput.append(addedText);
			y2DisplayTextField.setText(y2Text.toString());
		}
	}

	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		buttonPanel.setLayout(new GridLayout(6, 5, 0, 0));
		
		JButton btnAc = createBtnClear();
		buttonPanel.add(btnAc);
		
		JButton btnOpenBracket = createBtnOpenBracket();
		buttonPanel.add(btnOpenBracket);
		
		JButton btnClosedBracket = createBtnClosedBracket();
		buttonPanel.add(btnClosedBracket);
		
		JButton btnLeftArrow = createBtnBackspace();
		buttonPanel.add(btnLeftArrow);
		
		JButton btnRightArrow = createBtnSwitch();
		buttonPanel.add(btnRightArrow);
		
		JButton btnSqrt = createBtnSqrt();
		buttonPanel.add(btnSqrt);
		
		JButton btnSin = createBtnSin();
		buttonPanel.add(btnSin);
		
		JButton btnCos = createBtnCos();
		buttonPanel.add(btnCos);
		
		JButton btnTan = createBtnTan();
		buttonPanel.add(btnTan);
		
		JButton btnDivide = createBtnDivide();
		buttonPanel.add(btnDivide);
		
		JButton btnPower = createBtnPower();
		buttonPanel.add(btnPower);
		
		JButton btn7 = createBtn7();
		buttonPanel.add(btn7);
		
		JButton btn8 = createBtn8();
		buttonPanel.add(btn8);
		
		JButton btn9 = createBtn9();
		buttonPanel.add(btn9);
		
		JButton btnMultiply = createBtnMultiply();
		buttonPanel.add(btnMultiply);
		
		JButton btnLn = createBtnNaturalLog();
		buttonPanel.add(btnLn);
		
		JButton btn4 = createBtn4();
		buttonPanel.add(btn4);
		
		JButton btn5 = createBtn5();
		buttonPanel.add(btn5);
		
		JButton btn6 = createBtn6();
		buttonPanel.add(btn6);
		
		JButton btnSubtract = createBtnSubtract();
		buttonPanel.add(btnSubtract);
		
		JButton btnLog = createBtnLog();
		buttonPanel.add(btnLog);
		
		JButton btn1 = createBtn1();
		buttonPanel.add(btn1);
		
		JButton btn2 = createBtn2();
		buttonPanel.add(btn2);
		
		JButton btn3 = createBtn3();
		buttonPanel.add(btn3);
		
		JButton btnAdd = createBtnAdd();
		buttonPanel.add(btnAdd);
		
		JButton btnx = createBtnX();
		buttonPanel.add(btnx);
		
		JButton btn0 = createBtn0();
		buttonPanel.add(btn0);
		
		JButton btnDecimal = createBtnDecimal();
		buttonPanel.add(btnDecimal);
		
		JButton btnNegative = createBtnNegative();
		buttonPanel.add(btnNegative);
		
		JButton btnEnter = createBtnEnter();
		buttonPanel.add(btnEnter);
		
		return buttonPanel;
	}

	private JButton createBtnEnter() {
		JButton btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					try {
						graphPanel.drawFunction(equationSolver.createXYPointsList(inputFormatter.formatString(y1toInput.toString()), 1000), Color.RED);
					} catch (Exception er) {
						y1DisplayTextField.setText("Invalid Input");
						er.printStackTrace();
					}	
				} else if (y2Selected == true) {
					try {
						graphPanel.drawFunction(equationSolver.createXYPointsList(inputFormatter.formatString(y2toInput.toString()), 1000), Color.BLUE);
					} catch (Exception er) {
						y1DisplayTextField.setText("Invalid Input");
						er.printStackTrace();
					}
				}
			}
		});
		return btnEnter;
	}

	private JButton createBtnNegative() {
		JButton btnNegative = new JButton("(-)");
		btnNegative.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnNegative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("-");
				} else if (y2Selected == true) {
					addY2Text("-");
				}
			}
		});
		return btnNegative;
	}

	private JButton createBtnDecimal() {
		JButton btnDecimal = new JButton(".");
		btnDecimal.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text(".");
				} else if (y2Selected == true) {
					addY2Text(".");
				}
			}
		});
		return btnDecimal;
	}

	private JButton createBtn0() {
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("0");
				} else if (y2Selected == true) {
					addY2Text("0");
				}
			}
		});
		return btn0;
	}

	private JButton createBtnX() {
		JButton btnx = new JButton("X");
		btnx.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("X");
				} else if (y2Selected == true) {
					addY2Text("X");
				}
			}
		});
		return btnx;
	}

	private JButton createBtnAdd() {
		JButton btnAdd = new JButton("+");
		btnAdd.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("+");
				} else if (y2Selected == true) {
					addY2Text("+");
				}
			}
		});
		return btnAdd;
	}

	private JButton createBtn3() {
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("3");
				} else if (y2Selected == true) {
					addY2Text("3");
				}
			}
		});
		return btn3;
	}

	private JButton createBtn2() {
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("2");
				} else if (y2Selected == true) {
					addY2Text("2");
				}
			}
		});
		return btn2;
	}

	private JButton createBtn1() {
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("1");
				} else if (y2Selected == true) {
					addY2Text("1");
				}
			}
		});
		return btn1;
	}

	private JButton createBtnLog() {
		JButton btnLog = new JButton("log");
		btnLog.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("log(");
				} else if (y2Selected == true) {
					addY2Text("log(");
				}
			}
		});
		return btnLog;
	}

	private JButton createBtnSubtract() {
		JButton btnSubtract = new JButton("-");
		btnSubtract.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("_");
				} else if (y2Selected == true) {
					addY2Text("_");
				}
			}
		});
		return btnSubtract;
	}

	private JButton createBtn6() {
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("6");
				} else if (y2Selected == true) {
					addY2Text("6");
				}
			}
		});
		return btn6;
	}

	private JButton createBtn5() {
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("5");
				} else if (y2Selected == true) {
					addY2Text("5");
				}
			}
		});
		return btn5;
	}

	private JButton createBtn4() {
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("4");
				} else if (y2Selected == true) {
					addY2Text("4");
				}
			}
		});
		return btn4;
	}

	private JButton createBtnNaturalLog() {
		JButton btnLn = new JButton("ln");
		btnLn.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("ln(");
				} else if (y2Selected == true) {
					addY2Text("ln(");
				}
			}
		});
		return btnLn;
	}

	private JButton createBtnMultiply() {
		JButton btnMultiply = new JButton("*");
		btnMultiply.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("*");
				} else if (y2Selected == true) {
					addY2Text("*");
				}
			}
		});
		return btnMultiply;
	}

	private JButton createBtn9() {
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("9");
				} else if (y2Selected == true) {
					addY2Text("9");
				}
			}
		});
		return btn9;
	}

	private JButton createBtn8() {
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("8");
				} else if (y2Selected == true) {
					addY2Text("8");
				}
			}
		});
		return btn8;
	}

	private JButton createBtn7() {
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("7");
				} else if (y2Selected == true) {
					addY2Text("7");
				}
			}
		});
		return btn7;
	}

	private JButton createBtnPower() {
		JButton btnPower = new JButton("^");
		btnPower.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("^(");
				} else if (y2Selected == true) {
					addY2Text("^(");
				}
			}
		});
		return btnPower;
	}

	private JButton createBtnDivide() {
		JButton btnDivide = new JButton("/");
		btnDivide.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("/");
				} else if (y2Selected == true) {
					addY2Text("/");
				}
			}
		});
		return btnDivide;
	}

	private JButton createBtnTan() {
		JButton btnTan = new JButton("tan");
		btnTan.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("tan(");
				} else if (y2Selected == true) {
					addY2Text("tan(");
				}
			}
		});
		return btnTan;
	}

	private JButton createBtnCos() {
		JButton btnCos = new JButton("cos");
		btnCos.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("cos(");
				} else if (y2Selected == true) {
					addY2Text("cos(");
				}
			}
		});
		return btnCos;
	}

	private JButton createBtnSin() {
		JButton btnSin = new JButton("sin");
		btnSin.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("sin(");
				} else if (y2Selected == true) {
					addY2Text("sin(");
				}
			}
		});
		return btnSin;
	}

	private JButton createBtnSqrt() {
		JButton btnSqrt = new JButton("√");
		btnSqrt.setFont(new Font("Arial", Font.BOLD, 25));
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("√(");
				} else if (y2Selected == true) {
					addY2Text("√(");
				}
			}
		});
		return btnSqrt;
	}

	private JButton createBtnSwitch() {
		JButton btnSwitch = new JButton("Y2");
		btnSwitch.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					btnSwitch.setText("Y1");
					y1DisplayTextField.setBackground(Color.LIGHT_GRAY);
					y2DisplayTextField.setBackground(Color.WHITE);
					y1Selected = false;
					y2Selected = true;
				} else if (y2Selected == true) {
					btnSwitch.setText("Y2");
					y1DisplayTextField.setBackground(Color.WHITE);
					y2DisplayTextField.setBackground(Color.LIGHT_GRAY);
					y1Selected = true;
					y2Selected = false;
				}
			}
		});
		return btnSwitch;
	}

	private JButton createBtnBackspace() {
		JButton btnBackspace = new JButton("DEL");
		btnBackspace.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					graphPanel.clearGraph();
					if (y2toInput.length() != 0) {
						graphPanel.drawFunction(equationSolver.createXYPointsList(inputFormatter.formatString(y2toInput.toString()), 1000), Color.BLUE);
					}
					y1Text.deleteCharAt(y1Text.length()-1);
					y1toInput.deleteCharAt(y1toInput.length()-1);
					y1DisplayTextField.setText(y1Text.toString());
				} else if (y2Selected == true) {
					graphPanel.clearGraph();
					if (y1toInput.length() != 0) {
						graphPanel.drawFunction(equationSolver.createXYPointsList(inputFormatter.formatString(y1toInput.toString()), 1000), Color.RED);
					}
					y2Text.deleteCharAt(y2Text.length()-1);
					y2toInput.deleteCharAt(y2toInput.length()-1);
					y2DisplayTextField.setText(y2Text.toString());
				}
			}
		});
		return btnBackspace;
	}

	private JButton createBtnClosedBracket() {
		JButton btnClosedBracket = new JButton(")");
		btnClosedBracket.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnClosedBracket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text(")");
				} else if (y2Selected == true) {
					addY2Text(")");
				}
			}
		});
		return btnClosedBracket;
	}

	private JButton createBtnOpenBracket() {
		JButton btnOpenBracket = new JButton("(");
		btnOpenBracket.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnOpenBracket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					addY1Text("(");
				} else if (y2Selected == true) {
					addY2Text("(");
				}
			}
		});
		return btnOpenBracket;
	}

	private JButton createBtnClear() {
		JButton btnAc = new JButton("AC");
		btnAc.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y1Selected == true) {
					graphPanel.clearGraph();
					if (y2toInput.length() != 0) {
						graphPanel.drawFunction(equationSolver.createXYPointsList(inputFormatter.formatString(y2toInput.toString()), 1000), Color.BLUE);
					}
					y1Text.setLength(0);
					y1toInput.setLength(0);
					y1DisplayTextField.setText("");
				} else if (y2Selected == true) {
					graphPanel.clearGraph();
					if (y1toInput.length() != 0) {
						graphPanel.drawFunction(equationSolver.createXYPointsList(inputFormatter.formatString(y1toInput.toString()), 1000), Color.RED);
					}
					y2Text.setLength(0);
					y2toInput.setLength(0);
					y2DisplayTextField.setText("");
				}
			}
		});
		return btnAc;
	}
}
