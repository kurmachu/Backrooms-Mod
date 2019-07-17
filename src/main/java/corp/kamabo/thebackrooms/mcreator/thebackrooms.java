package corp.kamabo.thebackrooms.mcreator;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;

import java.util.function.Supplier;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

//@Mod(modid = thebackrooms.MODID, version = thebackrooms.VERSION, dependencies = "required-after:forge@[14.23.5.2768]")
public class thebackrooms implements IFuelHandler, IWorldGenerator {

	public static final String MODID = "thebackrooms";
	public static final String VERSION = "1.0.0";
//	@SidedProxy(clientSide = "ClientProxythebackrooms", serverSide = "CommonProxythebackrooms")
	//public static CommonProxythebackrooms proxy;
//	@Instance(MODID)
	public static thebackrooms instance;
	public final List<ModElement> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<Biome>> biomes = new ArrayList<>();
	public final List<Supplier<EntityEntry>> entities = new ArrayList<>();

	public thebackrooms() {
//		FluidRegistry.enableUniversalBucket();
//		elements.add(new mcreator_chair(this));
//		elements.add(new mcreator_pipesStraight(this));
//		elements.add(new mcreator_wall(this));
//		elements.add(new mcreator_wallwithbaseboard(this));
//		elements.add(new mcreator_wallwithbaseboardandpowerplugs(this));
//		elements.add(new mcreator_yellowmoistcarpet(this));
//		elements.add(new mcreator_pipesStraightLampOff(this));
//		elements.add(new mcreator_pipesStraightLampOffRedstoneOff(this));
//		elements.add(new mcreator_hummbuzzmakerRedstoneOn(this));
//		elements.add(new mcreator_hummbuzzmaker(this));
//		elements.add(new mcreator_pipesValve(this));
//		elements.add(new mcreator_moldWallWithBaseboard(this));
//		elements.add(new mcreator_moldCarpetNorth(this));
//		elements.add(new mcreator_moldCarpetEast(this));
//		elements.add(new mcreator_moldCarpetSouth(this));
//		elements.add(new mcreator_moldCarpetWest(this));
	}

	@Override
	public int getBurnTime(ItemStack fuel) {
//		for (ModElement element : elements) {
//			int ret = element.addFuel(fuel);
//			if (ret != 0)
//				return ret;
//		}
		return 0;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator cg, IChunkProvider cp) {
//		elements.forEach(element -> element.generateWorld(random, chunkX * 16, chunkZ * 16, world, world.provider.getDimension(), cg, cp));
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
//		event.getRegistry().registerAll(blocks.stream().map(Supplier::get).toArray(Block[]::new));
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
//		event.getRegistry().registerAll(items.stream().map(Supplier::get).toArray(Item[]::new));
	}

	@SubscribeEvent
	public void registerBiomes(RegistryEvent.Register<Biome> event) {
//		event.getRegistry().registerAll(biomes.stream().map(Supplier::get).toArray(Biome[]::new));
	}

	@SubscribeEvent
	public void registerEntities(RegistryEvent.Register<EntityEntry> event) {
//		event.getRegistry().registerAll(entities.stream().map(Supplier::get).toArray(EntityEntry[]::new));
	}

	@SubscribeEvent
	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
//		ResourceLocation sound0 = new ResourceLocation("thebackrooms", "hum-buzz");
//		event.getRegistry().register(new net.minecraft.util.SoundEvent(sound0).setRegistryName(sound0));
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
//		elements.forEach(element -> element.registerModels(event));
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
//		MinecraftForge.EVENT_BUS.register(this);
//		GameRegistry.registerFuelHandler(this);
//		GameRegistry.registerWorldGenerator(this, 5);
//		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
//		elements.forEach(element -> element.preInit(event));
//		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
//		elements.forEach(element -> element.init(event));
//		proxy.init(event);
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
//		elements.forEach(element -> element.serverLoad(event));
	}

	public static class GuiHandler implements IGuiHandler {

		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			return null;
		}
	}

	public static class ModElement {

		public static thebackrooms instance;

		public ModElement(thebackrooms instance) {
			this.instance = instance;
		}

		public void init(FMLInitializationEvent event) {
		}

		public void preInit(FMLPreInitializationEvent event) {
		}

		public void generateWorld(Random random, int posX, int posZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		public void registerModels(ModelRegistryEvent event) {
		}

		public int addFuel(ItemStack fuel) {
			return 0;
		}
	}
}
