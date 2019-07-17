package com.ParserJson.Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ParserJson.Parser.Launch;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;

public class GuiMain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File file;
	private JFrame frmParserJson;
	/**
	 * @wbp.nonvisual location=454,189
	 */
	private final JFileChooser fileChooser = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain window = new GuiMain();
					window.frmParserJson.setVisible(true);
				} catch (
						Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmParserJson = new JFrame();
		frmParserJson.getContentPane().setBackground(SystemColor.scrollbar);
		frmParserJson.getContentPane().setLayout(null);
		
		fileChooser.setFileFilter(new FileNameExtensionFilter("File Json", "json"));
		
		
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
		button.setBounds(122, 83, 89, 29);
		frmParserJson.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("Файл JSON");
		btnNewButton.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
				
				int g = JFileChooser.APPROVE_OPTION;
				if(g == fileChooser.showDialog(null, "Open JSON")) {
					file = fileChooser.getSelectedFile();
				}
				
			}
		});
		btnNewButton.setBounds(93, 11, 157, 45);
		frmParserJson.getContentPane().add(btnNewButton);
		frmParserJson.setTitle("Parser Json");
		frmParserJson.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\n.varentsov\\eclipse-workspace\\Parser\\src\\seo_prodvijenie_saitov.png"));
		frmParserJson.setBounds(100, 100, 341, 178);
		frmParserJson.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
