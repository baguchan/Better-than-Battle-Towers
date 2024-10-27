package jamdoggie.betterbattletowers.block;

import jamdoggie.betterbattletowers.BetterBattleTowers;
import jamdoggie.betterbattletowers.IDUtils;
import net.minecraft.client.render.block.model.BlockModelChest;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockChest;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;

public class ModBlocks {
	//ChestTower
	public static final Block ChestTower = new BlockBuilder(BetterBattleTowers.MOD_ID)
		.setResistance(1200.0f)
		.setHardness(2.0f)
		.setBlockSound(BlockSounds.STONE)
		.setTags(BlockTags.FENCES_CONNECT, BlockTags.MINEABLE_BY_PICKAXE)
		.setBlockModel(block -> new BlockModelChest<>(block, "betterbattletowers:block/chest_tower").withTextures("betterbattletowers:block/chest_tower_top"))
		.setTextures("betterbattletowers:block/chest_tower")
		.build(new BlockChest("chest.tower", IDUtils.getCurrBlockId(), Material.stone).withDisabledNeighborNotifyOnMetadataChange().withImmovableFlagSet());

	public static void createBlocks() {

	}
}
