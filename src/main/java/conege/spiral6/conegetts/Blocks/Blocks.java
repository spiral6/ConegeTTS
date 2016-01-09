package conege.spiral6.conegetts.Blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Blocks {
	public static Block ExampleBlock;
	
	public static final void init(){
		GameRegistry.registerBlock(ExampleBlock = new ExampleBlock(Material.iron), "Cancer 2.0");
	}
}
