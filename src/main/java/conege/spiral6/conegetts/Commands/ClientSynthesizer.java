package conege.spiral6.conegetts.Commands;

import java.util.Locale;

import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;



public class ClientSynthesizer extends Thread{
	static Synthesizer synthesizer;
	static String dialogue;
	
	public static void speak(){
		try
		{
			synthesizer.allocate();
			synthesizer.resume();
			synthesizer.speakPlainText(dialogue, null);
			synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run(){
		speak();
	}
	
	public ClientSynthesizer(String s) throws EngineException{
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
		synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
		dialogue = s;
	}

}
