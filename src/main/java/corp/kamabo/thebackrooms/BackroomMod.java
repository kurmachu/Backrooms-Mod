package corp.kamabo.thebackrooms;

import corp.kamabo.thebackrooms.block.BackroomBlocks;
import corp.kamabo.thebackrooms.block.tile.TileEntityBuzz;
import corp.kamabo.thebackrooms.command.ListTilesCommand;
import corp.kamabo.thebackrooms.command.PlaySoundsCommand;
import corp.kamabo.thebackrooms.command.ToBackroomCommand;
import corp.kamabo.thebackrooms.item.BackroomItems;
import corp.kamabo.thebackrooms.sound.BackroomSounds;
import corp.kamabo.thebackrooms.tabs.TabBackrooms;
import corp.kamabo.thebackrooms.tabs.TabBackroomsNightly;
import corp.kamabo.thebackrooms.world.BackroomGeneration;
import corp.kamabo.thebackrooms.world.BackroomWorldProvider;
import corp.kamabo.thebackrooms.world.BackroomWorldRespawn;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = BackroomMod.MODID,name=BackroomMod.NAME,version = BackroomMod.VERSION)
public class BackroomMod {
    public static final String MODID = "thebackrooms";
    public static final String NAME = "The Backrooms";
    public static final String VERSION = "2.6";

    private static Logger logger;

    public static CreativeTabs creativeTab = new TabBackrooms();
    public static CreativeTabs creativeTabNightly = new TabBackroomsNightly();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        BackroomSounds.init();

        GameRegistry.registerTileEntity(TileEntityBuzz.class,new ResourceLocation("thebackrooms","tileentitybuzz"));

        BackroomBlocks.init();
        BackroomItems.init();

        BackroomGeneration.init();



        FMLCommonHandler.instance().bus().register(new BackroomWorldRespawn());

        GameRegistry.addSmelting(BackroomItems.itemNail, new ItemStack(Items.IRON_NUGGET), 0.0F);
        GameRegistry.addSmelting(BackroomItems.itemGlassBundle, new ItemStack(Blocks.GLASS_PANE), 0.0F);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void serverStart(FMLServerStartingEvent event){
        event.registerServerCommand(new ToBackroomCommand());
    }
}
