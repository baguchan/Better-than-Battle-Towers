package jamdoggie.betterbattletowers.worldgen;

import jamdoggie.betterbattletowers.block.ModBlocks;
import jamdoggie.betterbattletowers.entity.EntityGolem;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockChest;
import net.minecraft.core.block.entity.TileEntityChest;
import net.minecraft.core.block.entity.TileEntityMobSpawner;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.type.WorldTypeOverworldExtended;

import java.util.Random;

public class WorldGenTower extends WorldFeature
{

	public WorldGenTower()
	{
	}

	@Override
	public boolean generate(World world, Random random, int i, int j, int k)
	{
		boolean flag = false;
		if (world.getBlockId(i, j, k) == Block.fluidWaterStill.id) {
			return false;
		}

		if (world.getBlockId(i, j, k) == 0) {
			return false;
		}

		int l = i;
		int i1 = j;
		int j1 = k;
		Biome biome = world.getBlockBiome(l, i1, j1);

		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		int k2 = i1 - 6;
		int l2 = random.nextInt(11);

		currentFloor = 1;
		field_22237_field_20341_topFloor = 0;

		int offset = 0;
		if(world.worldType instanceof WorldTypeOverworldExtended) offset = 64;
		for(; k2 < 120 + offset; k2 +=7)
		{
			if(k2 + 7 >= 120 + offset)
			{
				field_22237_field_20341_topFloor = 1;
			}
			for(int j3 = 0; j3 < 7; j3++)
			{
				if(k2 == i1 - 6 && j3 < 4)
				{
					j3 = 4;
				}

				for(int j4 = -7; j4 < 7; j4++)
				{
					for(int i5 = -7; i5 < 7; i5++)
					{
						int i6 = j4 + l;
						int k6 = j3 + k2;
						int l6 = i5 + j1;

						if(i5 == -7)
						{
							if(j4 > -5 && j4 < 4)
							{
								world.setBlock(i6, k6, l6, getRandomCobbledBlock(biome, l2, random));
							}
							continue;
						}

						if(i5 == -6 || i5 == -5)
						{
							if(j4 == -5 || j4 == 4)
							{
								world.setBlock(i6, k6, l6, getRandomCobbledBlock(biome, l2, random));
								continue;
							}

							if(i5 == -6)
							{
								if(j4 == (j3 + 1) % 7 - 3)
								{
									world.setBlock(i6, k6, l6, Block.stonePolished.id);

									if(j3 == 5)
									{
										world.setBlock(i6 - 7, k6, l6, Block.stonePolished.id);
									}

									if(j3 == 6 && field_22237_field_20341_topFloor == 1)
									{
										world.setBlock(i6, k6, l6, getRandomCobbledBlock(biome, l2, random));
									}

									continue;
								}

								if(j4 < 4 && j4 > -5)
								{
									world.setBlock(i6, k6, l6, 0);
								}

								continue;
							}

							if(i5 != -5 || j4 <= -5 || j4 >= 5)
							{
								continue;
							}

							if(j3 != 0 && j3 != 6 || j4 != -4 && j4 != 3)
							{
								if(j3 == 5 && (j4 == 3 || j4 == -4))
								{
									world.setBlock(i6, k6, l6, Block.stonePolished.id);
								}
								else
								{
									world.setBlock(i6, k6, l6, getRandomCobbledBlock(biome, l2, random));
								}
							}
							else
							{
								world.setBlock(i6, k6, l6, 0);
							}

							continue;
						}
						if(i5 == -4 || i5 == -3 || i5 == 2 || i5 == 3)
						{
							if(j4 == -6 || j4 == 5)
							{
								world.setBlock(i6, k6, l6, getRandomCobbledBlock(biome, l2, random));
								continue;
							}

							if(j4 <= -6 || j4 >= 5)
							{
								continue;
							}

							if(j3 == 5)
							{
								world.setBlock(i6, k6, l6, Block.stonePolished.id);
								continue;
							}

							if(world.getBlockId(i6, k6, l6) != 54)
							{
								//world.setBlock(i6, k6, l6, 0);
							}

							continue;
						}

						if(i5 > -3 && i5 < 2)
						{
							if(j4 == -7 || j4 == 6)
							{
								if(j3 < 0 || j3 > 3 || j4 != -7 && j4 != 6 || i5 != -1 && i5 != 0)
								{
									world.setBlock(i6, k6, l6, getRandomCobbledBlock(biome, l2, random));
								}
								else
								{
									world.setBlock(i6, k6, l6, 0);
								}

								continue;
							}

							if(j4 <= -7 || j4 >= 6)
							{
								continue;
							}

							if(j3 == 5)
							{
								world.setBlock(i6, k6, l6, Block.stonePolished.id);
							}
							else
							{
								world.setBlock(i6, k6, l6, 0);
							}

							continue;
						}

						if(i5 == 4)
						{
							if(j4 == -5 || j4 == 4)
							{
								world.setBlock(i6, k6, l6, getRandomCobbledBlock(biome, l2, random));
								continue;
							}
							if(j4 <= -5 || j4 >= 4)
							{
								continue;
							}
							if(j3 == 5)
							{
								world.setBlock(i6, k6, l6, Block.stonePolished.id);
							} else
							{
								world.setBlock(i6, k6, l6, 0);
							}
							continue;
						}

						if(i5 == 5)
						{
							if(j4 == -4 || j4 == -3 || j4 == 2 || j4 == 3)
							{
								world.setBlock(i6, k6, l6, getRandomCobbledBlock(biome, l2, random));
								continue;
							}
							if(j4 <= -3 || j4 >= 2)
							{
								continue;
							}
							if(j3 == 5)
							{
								world.setBlock(i6, k6, l6, Block.stonePolished.id);
							} else
							{
								world.setBlock(i6, k6, l6, getRandomCobbledBlock(biome, l2, random));
							}
							continue;
						}

						if(i5 != 6 || j4 <= -3 || j4 >= 2)
						{
							continue;
						}

						if(j3 < 0 || j3 > 3 || j4 != -1 && j4 != 0)
						{
							world.setBlock(i6, k6, l6, getRandomCobbledBlock(biome, l2, random));
						}
						else
						{
							world.setBlock(i6, k6, l6, getRandomCobbledBlock(biome, l2, random));
						}
					}

				}

			}

			if(currentFloor == 2)
			{
				world.setBlock(l + 3, k2, j1 - 5, getRandomCobbledBlock(biome, l2, random));
				world.setBlock(l + 3, k2 - 1, j1 - 5, getRandomCobbledBlock(biome, l2, random));
			}

			if(field_22237_field_20341_topFloor == 1)
			{
				double d = l;
				double d1 = k2 + 6;
				double d2 = (double)j1 + 0.5D;
				EntityGolem entitygolem = new EntityGolem(world, l2);
				entitygolem.spawnInit();
				entitygolem.moveTo(d, d1, d2, world.rand.nextFloat() * 360F, 0.0F);
				world.entityJoinedWorld(entitygolem);
				System.out.println("Spawned golem at " + d + ", " + d1 + ", " + d2);
			}
			else
			{
				world.setBlockWithNotify(l + 2, k2 + 6, j1 + 2, Block.mobspawner.id);
				TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getBlockTileEntity(l + 2, k2 + 6, j1 + 2);
				tileentitymobspawner.setMobId(getRandomSpawnerMob(biome, random));
				world.setBlockWithNotify(l - 3, k2 + 6, j1 + 2, Block.mobspawner.id);
				TileEntityMobSpawner tileentitymobspawner1 = (TileEntityMobSpawner)world.getBlockTileEntity(l - 3, k2 + 6, j1 + 2);
				tileentitymobspawner1.setMobId(getRandomSpawnerMob(biome, random));
			}

			world.setBlock(l, k2 + 6, j1 - 3, Block.stonePolished.id);
			world.setBlock(l - 1, k2 + 6, j1 - 3, Block.stonePolished.id);

			if(k2 + 56 >= 120 && currentFloor == 1)
			{
				currentFloor = 2;
			}

			for(int k3 = 0; k3 < 2; k3++)
			{
				world.setBlockWithNotify(l - k3, k2 + 7, j1 - 3, ModBlocks.ChestTower.id);
				((BlockChest)ModBlocks.ChestTower).setDirection(world, l - k3, k2 + 7, j1 - 3, Direction.SOUTH);
				TileEntityChest tileEntityChest = (TileEntityChest)world.getBlockTileEntity(l - k3, k2 + 7, j1 - 3);
				for(int j5 = 0; j5 < 1 + k3 + l2; j5++)
				{
					ItemStack itemstack = generateRandomChestLoot(currentFloor, random);
					if(itemstack != null)
					{
						tileEntityChest.setInventorySlotContents(random.nextInt(tileEntityChest.getSizeInventory()), itemstack);
					}
				}

			}
			((BlockChest)ModBlocks.ChestTower).setType(world, l, k2 + 7, j1 - 3, BlockChest.Type.RIGHT);
			((BlockChest)ModBlocks.ChestTower).setType(world, l - 1, k2 + 7, j1 - 3, BlockChest.Type.LEFT);

			for(int l3 = 0; l3 < (currentFloor * 4 + l2) - 8 && field_22237_field_20341_topFloor != 1; l3++)
			{
				int k4 = 5 - random.nextInt(12);
				int k5 = k2 + 5;
				int j6 = 5 - random.nextInt(10);
				if(j6 < -2 && k4 < 4 && k4 > -5 && k4 != 1 && k4 != -2)
				{
					continue;
				}
				k4 += l;
				j6 += j1;
				if(world.getBlockId(k4, k5, j6) == Block.stonePolished.id && world.getBlockId(k4, k5 + 1, j6) != Block.mobspawner.id)
				{
					world.setBlock(k4, k5, j6, 0);
				}
			}

			currentFloor++;
		}

		return true;
	}

	private ItemStack generateRandomChestLoot(int towerLevel, Random random)
	{
		int j = random.nextInt(4);
		if(field_22237_field_20341_topFloor == 1)
		{
			if(j == 0)
			{
				return new ItemStack(Block.meshGold, random.nextInt(2) + 1);
			}
			if(j == 1)
			{
				return new ItemStack(Item.ingotGold, random.nextInt(2) + 1);
			}
			if(j == 2)
			{
				return new ItemStack(Item.ingotIron, random.nextInt(2) + 2);
			}
			if(j == 3)
			{
				return new ItemStack(Item.diamond, random.nextInt(1) + 1);
			} else
			{
				return null;
			}
		}

		if(towerLevel == 1)
		{
			if(j == 0)
			{
				return new ItemStack(Item.stick, random.nextInt(3) + 2);
			}
			if(j == 1)
			{
				return new ItemStack(Item.seedsWheat, random.nextInt(2) + 2);
			}
			if(j == 2)
			{
				return new ItemStack(Item.ammoPebble, random.nextInt(3) + 3);
			}
			if(j == 3)
			{
				return new ItemStack(Block.sand, random.nextInt(2) + 3);
			} else
			{
				return null;
			}
		}

		if(towerLevel == 2)
		{
			if(j == 0)
			{
				return new ItemStack(Item.coal, random.nextInt(2) + 3);
			}
			if(j == 1)
			{
				return new ItemStack(Item.stick, random.nextInt(2) + 3);
			}
			if(j == 2)
			{
				return new ItemStack(Block.planksOak, random.nextInt(3) + 4);
			}
			if(j == 3)
			{
				return new ItemStack(Block.wool, random.nextInt(3) + 4);
			} else
			{
				return null;
			}
		}

		if(towerLevel == 3)
		{
			if(j == 0)
			{
				return new ItemStack(Item.featherChicken, random.nextInt(2) + 6);
			}
			if(j == 1)
			{
				return new ItemStack(Item.foodBread, random.nextInt(1) + 2);
			}
			if(j == 2)
			{
				return new ItemStack(Block.glass, random.nextInt(2) + 5);
			}
			if(j == 3)
			{
				return new ItemStack(Block.mushroomBrown, random.nextInt(3) + 3);
			} else
			{
				return null;
			}
		}

		if(towerLevel == 4)
		{
			if(j == 0)
			{
				return new ItemStack(Item.string, random.nextInt(3) + 2);
			}
			if(j == 1)
			{
				return new ItemStack(Item.ammoPebble, random.nextInt(3) + 2);
			}
			if(j == 2)
			{
				return new ItemStack(Block.torchCoal, random.nextInt(3) + 5);
			}
			if(j == 3)
			{
				return new ItemStack(Block.mushroomRed, random.nextInt(3) + 3);
			} else
			{
				return null;
			}
		}

		if(towerLevel == 5)
		{
			if(j == 0)
			{
				return new ItemStack(Block.stairsPlanksOak, random.nextInt(2) + 3);
			}
			if(j == 1)
			{
				return new ItemStack(Block.brickClay, random.nextInt(3) + 5);
			}
			if(j == 2)
			{
				return new ItemStack(Item.ingotIron, random.nextInt(2) + 1);
			}
			if(j == 3)
			{
				return new ItemStack(Item.rope, random.nextInt(2) + 3);
			} else
			{
				return null;
			}
		}

		if(towerLevel == 6)
		{
			if(j == 0)
			{
				return new ItemStack(Block.ladderOak, random.nextInt(3) + 5);
			}
			if(j == 1)
			{
				return new ItemStack(Item.flint, random.nextInt(3) + 2);
			}
			if(j == 2)
			{
				return new ItemStack(Item.dustRedstone, random.nextInt(1) + 2);
			}
			if(j == 3)
			{
				return new ItemStack(Item.ingotGold, random.nextInt(1) + 1);
			} else
			{
				return null;
			}
		}

		if(towerLevel == 7)
		{
			if(j == 0)
			{
				return new ItemStack(Block.pumpkinCarvedActive, random.nextInt(3) + 4);
			}
			if(j == 1)
			{
				return new ItemStack(Block.rail, random.nextInt(5) + 6);
			}
			if(j == 2)
			{
				return new ItemStack(Item.oreRawIron, random.nextInt(2) + 2);
			}
			if(j == 3)
			{
				return new ItemStack(Item.bucketLava, 1);
			} else
			{
				return null;
			}
		}

		if(towerLevel == 8)
		{
			if(j == 0)
			{
				return new ItemStack(Block.tnt, random.nextInt(2) + 3);
			}
			if(j == 1)
			{
				return new ItemStack(Block.slate, random.nextInt(3) + 5);
			}
			if(j == 2)
			{
				return new ItemStack(Item.oreRawGold, random.nextInt(1) + 2);
			}
			if(j == 3)
			{
				return new ItemStack(Item.chainlink, random.nextInt(3) + 5);
			} else
			{
				return null;
			}
		}

		if(random.nextInt(4) == 0)
		{
			return new ItemStack(Item.quartz, random.nextInt(2) + 3);
		}

		if(random.nextInt(4) == 1)
		{
			return new ItemStack(Item.olivine, random.nextInt(3) + 3);
		}

		if(random.nextInt(4) == 2)
		{
			return new ItemStack(Item.dustRedstone, random.nextInt(2) + 2);
		}

		if(random.nextInt(4) == 3)
		{
			return new ItemStack(Block.mesh, random.nextInt(1) + 2);
		}
		else
		{
			return null;
		}
	}

	private String getRandomSpawnerMob(Biome biome, Random random)
	{
		int i = random.nextInt(5);

		if(i == 0)
		{
			return "Skeleton";
		}
		if(i == 1)
		{
			return "Zombie";
		}
		if(i == 2)
		{
			return "Spider";
		}
		if(i == 3)
		{
			return "Spider";
		}
		if(i == 4)
		{
			return "Zombie";
		} else
		{
			return "Scorpion";
		}
	}

	private int getRandomCobbledBlock(Biome biome, int i, Random random)
	{
		if (biome.hasSurfaceSnow()) {
			if (i % 2 == 0) {
				return Block.brickPermafrost.id;
			} else {
				return Block.cobblePermafrost.id;
			}
		}

		if (biome == Biomes.OVERWORLD_DESERT) {
			if (i % 2 == 0) {
				return Block.brickSandstone.id;
			} else {
				return Block.sandstone.id;
			}
		}

		if (biome == Biomes.OVERWORLD_BIRCH_FOREST) {
			if (i % 2 == 0) {
				if (random.nextInt(3) == 0) {
					return Block.brickStonePolished.id;
				} else {
					return Block.brickStonePolishedMossy.id;
				}
			}
			return Block.brickStonePolished.id;
		}
		if (biome == Biomes.OVERWORLD_FOREST) {
			if (i % 2 == 0) {
				if (random.nextInt(3) == 0) {
					return Block.cobbleStone.id;
				} else {
					return Block.cobbleStoneMossy.id;
				}
			}
			return Block.cobbleStoneMossy.id;
		}

		if(i == 0)
		{
			return Block.cobbleStone.id;
		}
		if(i == 1)
		{
			if(random.nextInt(3) == 0)
			{
				return Block.cobbleStone.id;
			} else
			{
				return Block.cobbleStoneMossy.id;
			}
		}
		if(i == 2)
		{
			return Block.brickStone.id;
		}
		if(i == 3)
		{
			return Block.brickStonePolished.id;
		}
		if(i == 4)
		{
			return Block.brickStonePolishedMossy.id;
		}
		if (i == 5)
		{
			return Block.cobbleBasalt.id;
		}
		if (i == 6)
		{
			return Block.brickBasalt.id;
		}
		if (i == 7)
		{
			return Block.cobbleLimestone.id;
		}
		if (i == 8)
		{
			return Block.brickLimestone.id;
		}
		if (i == 9)
		{
			return Block.cobbleGranite.id;
		}
		if (i == 10)
		{
			return Block.brickGranite.id;
		}

		return Block.cobbleStone.id;
	}
	private int currentFloor;
	private int field_22237_field_20341_topFloor;

}
