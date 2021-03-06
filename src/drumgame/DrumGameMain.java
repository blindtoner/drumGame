package drumgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
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

	public DrumGameMain() {
		super("Drum Game");
		myLayout();
	}
	
	private void myLayout() {
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		pickTextField.setBackground(Color.blue);
		topPanel.add(new JLabel("Enter b h s c e for (Bass Drum, High Hat, Snare, Hand Clap ,Exit)"));
		topPanel.add(pickTextField);
		add(topPanel, BorderLayout.NORTH);

		pickTextField.addActionListener(this);

		setSize(725, 475);
//		ImageIcon icon = new ImageIcon("src/drumgame/808.jpg");
		ImageIcon icon = new ImageIcon(DrumGameMain.class.getResource("808.jpg"));

		bgImage = new JLabel(icon);
		bgImage.setBounds(0, 0, 500, 500);
		topPanel.add(bgImage);

		pickTextField.addKeyListener(this);
		setVisible(true);
		System.out.println(DrumGameMain.class.getResource("808.jpg").toString());

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
