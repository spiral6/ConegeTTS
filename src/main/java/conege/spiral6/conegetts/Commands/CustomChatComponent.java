package conege.spiral6.conegetts.Commands;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class CustomChatComponent extends ChatComponentText{

	public CustomChatComponent(String s) {
		super(s);
		this.setChatStyle(new ChatStyle().setColor(EnumChatFormatting.YELLOW));
	}
	
}
