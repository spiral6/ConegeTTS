package conege.spiral6.conegetts.Events;

import javax.speech.EngineException;

import conege.spiral6.conegetts.Base;
import conege.spiral6.conegetts.Commands.ClientSynthesizer;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class TTSPacketClient implements IMessage {

	String dialogue;
	
	public TTSPacketClient(){
		//needs to have this default constructor, otherwise error.
		//Better safe than sorry, I guess.
	}
	
	public TTSPacketClient(String s) {
		dialogue = s;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		dialogue = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		ByteBufUtils.writeUTF8String(buf, dialogue);
	}
	
	



	public static class Handler implements IMessageHandler<TTSPacketClient, IMessage> {

		@Override
		public IMessage onMessage(TTSPacketClient message, MessageContext ctx) {
			System.out.println("Server message received:" + message.dialogue);
			if(ctx.side.isClient()){
				try {
					new ClientSynthesizer(message.dialogue).start();
				} catch (EngineException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null; // no response in this case
		}

	}

	
	
	
	
	
	
	
	
	
	

}
