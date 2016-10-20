package drumgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DrumGameMain extends JFrame implements ActionListener, KeyListener{
	private ImageIcon bg;
	private JLabel bgImage;
	private JTextField pickTextField = new JTextField(10);
	AudioInputStream audioInputStream;
	ArrayList<String> mySounds;
	MySoundPlayer msp = new MySoundPlayer(mySounds, false);

	public void playSound(String fileName) {
		try {

			audioInputStream = AudioSystem.getAudioInputStream(new File(fileName));

			Clip clip = AudioSystem.getClip();

			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound." + ex);
			ex.printStackTrace();
		}
	}
	
	
	public DrumGameMain() {
		super("Drum Game");
		myLayout();
	}
	
	public void playSoundList(String s) {
		ArrayList<String> mySounds = new ArrayList();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {

			case 'b': {

				mySounds.add("bd.wav");
				break;
			}
			case 'h': {
				mySounds.add("hh.wav");
				break;
			}
			case 'c': {
				mySounds.add("cp.wav");
				break;
			}
			case 's': {
				mySounds.add("sd.wav");
				break;
			}
			case 'z': {
				mySounds.add("siren.wav");
				break;
			}
			}
		} // end of for loop
		MySoundPlayer msp = new MySoundPlayer(mySounds, false);
	}

	private void myLayout() {
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		pickTextField.setBackground(Color.blue);
//		topPanel.add(new JLabel(myGamePlayer.getPlayerName()));
		topPanel.add(new JLabel("Enter b h s c e for (Bass Drum, High Hat, Snare, Hand Clap ,Exit)"));
		topPanel.add(pickTextField);
//		topPanel.add(guessTextField);
		add(topPanel, BorderLayout.NORTH);

//		resultsTextArea.setBackground(Color.lightGray);
//		resultsTextArea.setEditable(false);

//		add(resultsTextArea, BorderLayout.SOUTH);
		pickTextField.addActionListener(this);
//		guessTextField.addActionListener(this);
//		addWindowListener(new Termination());

		setSize(725, 475);
		ImageIcon icon = new ImageIcon("808.jpg");

		bgImage = new JLabel(icon);
		bgImage.setBounds(0, 0, 500, 500);
		topPanel.add(bgImage);

		pickTextField.addKeyListener(this);
//		guessTextField.addKeyListener(this);
		setVisible(true);

	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyChar()) {

		case 'b': {
			msp.playSound("bd.wav");
			break;
		}
		case 'h': {
			msp.playSound("hh.wav");
			break;
		}
		case 'c': {
			msp.playSound("cp.wav");
			break;
		}
		case 's': {
			msp.playSound("sd.wav");
			break;
		}
		case 'z': {
			msp.playSound("siren.wav");
			break;
		}
		case 'e': {
			System.exit(0);
			return;
		}
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
