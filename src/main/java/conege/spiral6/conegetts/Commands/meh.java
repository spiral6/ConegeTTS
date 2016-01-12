package conege.spiral6.conegetts.Commands;

import java.util.Locale;

import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;



public class meh {
	static Synthesizer synthesizer;
	public meh(String s){
		try
		{
			synthesizer.allocate();
			synthesizer.resume();
			synthesizer.speakPlainText(s, null);
			synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
			synthesizer.deallocate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void speak(String s){
		try
		{
			synthesizer.allocate();
			synthesizer.resume();
			synthesizer.speakPlainText(s, null);
			synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public meh() throws EngineException{
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

		Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
		synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
	}

	public static void main(String[] args) throws EngineException{
		
	}
}
