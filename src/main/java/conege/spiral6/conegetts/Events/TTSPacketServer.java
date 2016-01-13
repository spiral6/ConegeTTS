package conege.spiral6.conegetts.Events;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import conege.spiral6.conegetts.Base;
import conege.spiral6.conegetts.Commands.ClientSynthesizer;
import conege.spiral6.conegetts.Commands.CustomChatComponent;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class TTSPacketServer implements IMessage {

	String dialogue;
	
	public TTSPacketServer(){
		//needs to have this default constructor, otherwise error.
		//Better safe than sorry, I guess.
	}
	
	public TTSPacketServer(String s) {
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
	
	



	public static class Handler implements IMessageHandler<TTSPacketServer, IMessage> {

		@Override
		public IMessage onMessage(TTSPacketServer message, MessageContext ctx) {
			if(ctx.side.isServer()){
				System.out.println("Client message recieved" + ": " + message.dialogue);
				Base.network.sendToAll(new TTSPacketClient(message.dialogue));
				
				
				String playerName = ctx.getServerHandler().playerEntity.getDisplayName();
				MinecraftServer.getServer().getConfigurationManager().sendChatMsg(
						new CustomChatComponent("[ConegeTTS] " + playerName + " said: " + "§4" + "\"" + message.dialogue.substring(0, message.dialogue.length()-1) + "\"§e."));
			}
			return null; // no response in this case
		}

	}

	
	
	
	
	
	
	
	
	
	

}
