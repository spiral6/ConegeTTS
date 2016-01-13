package conege.spiral6.conegetts.Commands;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.speech.EngineException;

import conege.spiral6.conegetts.Base;
import conege.spiral6.conegetts.Events.TTSPacketClient;
import conege.spiral6.conegetts.Events.TTSPacketServer;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.CommandEvent;

public class TTSCommand implements ICommand{
		
		private List aliases;
		private ClientSynthesizer cs;
	
		public TTSCommand() throws EngineException{
			this.aliases = new ArrayList();
			this.aliases.add("ctts");
			this.aliases.add("conegetts");
		}

		@Override
		public int compareTo(Object arg0) {
			return 0;
		}

		@Override
		public String getCommandName() {
			return "conegetts";
		}

		@Override
		public String getCommandUsage(ICommandSender i) {
			return "conegetts <text>";
		}

		@Override
		public List getCommandAliases() {
			return this.aliases;
		}

		@Override
		public void processCommand(ICommandSender i, String[] arr) {
			EntityPlayer player;
			
			if(i instanceof EntityPlayer){
				player = (EntityPlayer)i;
			}
			else{
				i.addChatMessage(new CustomChatComponent("Player only command."));
			}
			
			if(arr.length == 0){
				i.addChatMessage(new CustomChatComponent("Invalid arguments."));
				i.addChatMessage(new CustomChatComponent(this.getCommandUsage(i)));
				return;
			}
			
			String dialogue = "";
			
			for(String s: arr){
				dialogue+=s + " ";
			}
			
			//i.addChatMessage(new CustomChatComponent(i.getCommandSenderName() + " said this: " +  dialogue));
			//cs.speak(dialogue);
			Base.network.sendToServer(new TTSPacketServer(dialogue));
			
			
			
			
			
			
		}

		@Override
		public boolean canCommandSenderUseCommand(ICommandSender i) {
			return true;
		}

		@Override
		public List addTabCompletionOptions(ICommandSender i, String[] arr) {
			return null;
		}

		@Override
		public boolean isUsernameIndex(String[] arr, int integer) {
			return false;
		}
		
		
		


}
