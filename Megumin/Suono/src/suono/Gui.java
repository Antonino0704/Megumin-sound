package suono;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui {
	private JFrame win;
	private JButton megumin;
	private Image img, img2;
	private ImageIcon icon, icon2;
	private boolean verify;
	private Play play;
	
	public Gui() {
		play = new Play();
		verify = false;
		win = new JFrame("megumin");
		
		megumin = new JButton();
		
		icon = new ImageIcon("icon/megumin_button.jpg");
		img = icon.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		megumin.setIcon(new ImageIcon(img));
		
		icon2 = new ImageIcon("icon/megumin_button2.jpg");
		img2 = icon2.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		
		win.setIconImage(new ImageIcon("icon/megumin_icon.jpg").getImage());
		win.setSize(600, 600);
		win.setLocationRelativeTo(null);
		win.setResizable(false);
		win.setVisible(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setButton() {
		megumin.setFocusable(false);
		megumin.setBorder(null);
		megumin.setBorderPainted(false);
		
		win.add(megumin);
	}
	
	public void actionButton() {
		megumin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (verify == false) {
					songStart();
				}
				else {
					songStop();
				}
			}
		});
	}
	
	public void songStart() {
		play.Start();
		megumin.setIcon(new ImageIcon(img2));
		verify = true;
	}
	
	public void songStop() {
		ImageIcon optionIcon = new ImageIcon("icon/dist.png");
		Image optionImage = optionIcon.getImage().getScaledInstance(100, 100, JOptionPane.DEFAULT_OPTION);
		UIManager.put("OptionPane.okButtonText", "Restart");
		int scelta = JOptionPane.showConfirmDialog(null, "Quante volte vuoi distruggere il mondo", "Mondo Distrutto", JOptionPane.DEFAULT_OPTION,
				0, new ImageIcon(optionImage));
		if (scelta == 0) {
			restart();
		}
	}
	
	public void restart() {
		Gui gui = new Gui();
		gui.setButton();
		gui.actionButton();
		play.close();
		win.dispose();
	}
}
