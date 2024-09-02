package jamdoggie.betterbattletowers;

import jamdoggie.betterbattletowers.entity.EntityGolem;
import jamdoggie.betterbattletowers.entity.render.RenderGolem;
import jamdoggie.betterbattletowers.worldgen.WorldGenTower;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.guidebook.mobs.MobInfoRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.world.type.WorldTypeOverworldExtended;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.SoundHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;
import java.util.Random;


public class BetterBattleTowers implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint, ClientModInitializer, ClientStartEntrypoint
{
    public static final String MOD_ID = "betterbattletowers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ConfigHandler config;

	static {
		Properties prop = new Properties();
		prop.setProperty("towercount", "200");
		prop.setProperty("rarity", "3");
		prop.setProperty("starting_entity_id", "101");
		config = new ConfigHandler(BetterBattleTowers.MOD_ID, prop);
		entityID = config.getInt("starting_entity_id");
		towercount = config.getInt("towercount");
		rarity = config.getInt("rarity");
		config.updateConfig();
	}
	public static BetterBattleTowers instance;

	public static int towercount;
	public static int rarity;
	private final int DEFAULT_RARITY = 3;

	public BetterBattleTowers()
	{
		instance = this;
	}

	public static int entityID;

	@Override
    public void onInitialize() {
        LOGGER.info("Better than Battle Towers initialized.");

		EntityHelper.createEntity(EntityGolem.class, entityID, "TowerGolem", RenderGolem::new);


    }

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void beforeClientStart() {

	}

	@Override
	public void afterClientStart() {
	}

	@Override
	public void afterGameStart() {
		MobInfoRegistry.register(EntityGolem.class, "betterbattletowers.golem.name", "betterbattletowers.golem.desc", 300, 10000,
			new MobInfoRegistry.MobDrop[]{
				new MobInfoRegistry.MobDrop(new ItemStack(Block.slabStonePolished), 1.0f, 9 ,12),
				new MobInfoRegistry.MobDrop(new ItemStack(Item.diamond), 1.0f, 1 ,6)
			});
	}

	@Override
	public void onRecipesReady() {
	}

	@Override
	public void initNamespaces() {

	}

	@Override
	public void onInitializeClient()
	{
		SoundHelper.addSound(BetterBattleTowers.MOD_ID, "golem1.ogg");
		SoundHelper.addSound(BetterBattleTowers.MOD_ID, "golem3.ogg");
		SoundHelper.addSound(BetterBattleTowers.MOD_ID, "golemawaken.ogg");
		SoundHelper.addSound(BetterBattleTowers.MOD_ID, "golemdeath.ogg");
		SoundHelper.addSound(BetterBattleTowers.MOD_ID, "golemhurt2.ogg");
		SoundHelper.addSound(BetterBattleTowers.MOD_ID, "golemhurt3.ogg");
		SoundHelper.addSound(BetterBattleTowers.MOD_ID, "golemspecial1.ogg");
		SoundHelper.addSound(BetterBattleTowers.MOD_ID, "golemspecial2.ogg");
	}

	public void GenerateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		if(towercount >= rarity * 100)
		{
			if(random.nextInt(2) == 0)
			{
				int k = chunkX + random.nextInt(16) + 8;
				int l = random.nextInt(1) + 64;
				if(world.worldType instanceof WorldTypeOverworldExtended){
					l += 64;
				}
				int i1 = chunkZ + random.nextInt(16) + 8;

				if((new WorldGenTower()).generate(world, random, k, l, i1))
				{
					towercount = 0;
				}
			}
		}
		else
		{
			towercount++;
		}
	}
}
