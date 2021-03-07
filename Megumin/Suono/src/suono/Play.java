package suono;

import javax.sound.sampled.*;
import java.io.*;

public class Play {
	private Clip clip;
	private AudioInputStream sound;
	private File fp;
	
	public Play() {
		try {
			fp = new File("sound/Megumin.wav");
			clip = AudioSystem.getClip();
			sound = AudioSystem.getAudioInputStream(fp);
			clip.open(sound);
		}
		catch(Exception e) {
			return;
		}
	}
	
	public void Start() {
		clip.start();
	}
	
	public void close() {
		clip.close();
	}
}
