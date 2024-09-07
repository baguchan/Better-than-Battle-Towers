package jamdoggie.betterbattletowers.block;

import jamdoggie.betterbattletowers.IDUtils;
import jamdoggie.betterbattletowers.BetterBattleTowers;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockChest;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;

public class ModBlocks {
	//chest_tower
	public static final Block chest_tower = new BlockBuilder(BetterBattleTowers.MOD_ID)
		.setResistance(1200.0f)
		.setHardness(2.0f)
		.setBlockSound(BlockSounds.WOOD)
		.setTags(BlockTags.MINEABLE_BY_PICKAXE)
		.setTextures("betterbattletowers:block/chest_tower")
		.build(new BlockChest("chest_tower", IDUtils.getCurrBlockId(), Material.stone));
}
