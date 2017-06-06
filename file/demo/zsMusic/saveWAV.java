package zsMusic;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class saveWAV {

	public static void main(String zs[]) throws IOException, UnsupportedAudioFileException{
		double sampleRate = 44100.0;
	    double frequency = 440;
	    double frequency2 = 90;
	    double amplitude = 1.0;
	    double seconds = 2.0;
	    double twoPiF = 2 * Math.PI * frequency;
	    double piF = Math.PI * frequency2;
	    float[] buffer = new float[(int) (seconds * sampleRate)];
	    for (int sample = 0; sample < buffer.length; sample++) 
	    {
	        double time = sample / sampleRate;
	        buffer[sample] = (float) (amplitude * Math.cos((double)piF *time)* Math.sin(twoPiF * time));
	    }
	    final byte[] byteBuffer = new byte[buffer.length * 2];
	    int bufferIndex = 0;
	    for (int i = 0; i < byteBuffer.length; i++) {
	    final int x = (int) (buffer[bufferIndex++] * 32767.0);
	    byteBuffer[i] = (byte) x;
	    i++;
	    byteBuffer[i] = (byte) (x >>> 8);
	    }
	    File out = new File("/Users/llmzs/Desktop/test1.wav");
	    boolean bigEndian = false;
	    boolean signed = true;
	    int bits = 16;
	    int channels = 1;
	    AudioFormat format;
	    format = new AudioFormat((float)sampleRate, bits, channels, signed, bigEndian);
	    ByteArrayInputStream bais = new ByteArrayInputStream(byteBuffer);
	    AudioInputStream audioInputStream;
	    
		URL url = new URL("file:/Users/llmzs/Desktop/4659.wav");
		//AudioStream mus = new AudioStream(url.openStream());
	    audioInputStream =AudioSystem.getAudioInputStream(url);
	    //audioInputStream = new AudioInputStream(bais, format,buffer.length);
	    AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, out);
	    audioInputStream.close();
	}
	
}
