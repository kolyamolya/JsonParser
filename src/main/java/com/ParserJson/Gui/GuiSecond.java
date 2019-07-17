package com.ParserJson.Gui;


import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ParserJson.Parser.Launch;

import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GuiSecond {
	
	String login = "n.varentsov";
	String password = "2ctVa0Vz6Vl5zGTwxnNk";
	File file;
	
	private JFrame frmParserJson;
	/**
	 * @wbp.nonvisual location=524,189
	 */
	private final JFileChooser fileChooser = new JFileChooser();
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public GuiSecond() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		fileChooser.setFileFilter(new FileNameExtensionFilter("File Json", "json"));
		
		frmParserJson = new JFrame();
		frmParserJson.setTitle("Parser Json");
		frmParserJson.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\n.varentsov\\eclipse-workspace\\Parser\\src\\seo_prodvijenie_saitov.png"));
		frmParserJson.setBounds(100, 100, 436, 214);
		frmParserJson.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmParserJson.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 401, 156);
		frmParserJson.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		tabbedPane.addTab("Файл", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Файл JSON");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int g = JFileChooser.APPROVE_OPTION;
				if(g == fileChooser.showDialog(null, "Open JSON")) {
					file = fileChooser.getSelectedFile();
				}
				
			}
		});
		btnNewButton.setBounds(123, 11, 140, 52);
		panel.add(btnNewButton);
		
		JButton button = new JButton("Запуск");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Launch launch = new Launch(file);
				try {
					launch.start();
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(141, 87, 104, 30);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Ссылка", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Введите ID рассылки");
		lblNewLabel.setBounds(23, 11, 133, 31);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(157, 16, 96, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton button_1 = new JButton("Запуск");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(!textField.getText().isEmpty()) {
					if(isNumeric(textField.getText())) {
						
						Authenticator.setDefault(new Authenticator() {

						    @Override
						    protected PasswordAuthentication getPasswordAuthentication() {          
						        return new PasswordAuthentication(login, password.toCharArray());
						    }
						});
						
						String loginPassword = login+ ":" + password;
						
						
						
						
						
						
					} else {
						JOptionPane.showMessageDialog(null, "В поле есть буквы");
					}					
				} else {
					JOptionPane.showMessageDialog(null, "Введите ID рассылки");
				} 			
				
			}
		});
		button_1.setBounds(149, 68, 104, 30);
		panel_1.add(button_1);
	}
	
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
	
}
