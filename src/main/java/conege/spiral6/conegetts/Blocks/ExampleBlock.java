package conege.spiral6.conegetts.Blocks;

import conege.spiral6.conegetts.Base;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ExampleBlock extends Block {

	protected ExampleBlock(Material material) {
		super(material);
		this.setBlockName("Cancer 2.0");
		this.setBlockTextureName(Base.MODID + ":" + "Cancer 2.0");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(2.0F);
		this.setResistance(6.0F);
		this.setLightLevel(1.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypeMetal);
	}

}
