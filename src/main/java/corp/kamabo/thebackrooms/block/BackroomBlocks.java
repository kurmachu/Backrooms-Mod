package corp.kamabo.thebackrooms.block;

import corp.kamabo.thebackrooms.BackroomMod;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=BackroomMod.MODID)
public class BackroomBlocks {
    public static Block blockChair;
    public static Block blockWallpaperWall;
    public static Block blockWallpaperWallBaseboard;
    public static Block blockWallpaperWallBaseboardBroken;
    public static Block blockYellowCarpet;
    public static Block blockYellowCarpetMoldSide;
    public static Block blockCeiling;
    public static Block blockLight;
    public static Block blockLightBroken;
    public static Block blockPebble;

    public static Block blockPipeStright;
    public static Block blockPipeValve;
    public static Block blockWallMold;//m o i d e r

    public static void init() {
        blockChair = new BlockChair();
        blockWallpaperWall = new BlockWallpaperWall();
        blockWallpaperWallBaseboard = new BlockWallpaperWallBaseboard();
        blockWallpaperWallBaseboardBroken = new BlockWallpaperWallBaseboardBroken();
        blockYellowCarpet = new BlockYellowCarpet();
        blockYellowCarpetMoldSide = new BlockMoldSideCarpet();
        blockCeiling = new BlockCeiling();
        blockLight = new BlockLight();
        blockLightBroken = new BlockLightSmashed();
        blockPebble = new BlockPebble();

        blockPipeStright = new BlockPipeStright();
        blockPipeValve = new BlockPipeValve();
        blockWallMold = new BlockWallMoldBaseboard();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                blockChair,
                blockWallpaperWall,
                blockWallpaperWallBaseboard,
                blockWallpaperWallBaseboardBroken,
                blockYellowCarpet,
                blockYellowCarpetMoldSide,
                blockCeiling,
                blockLight,
                blockLightBroken,
                blockPebble,
                blockPipeStright,
                blockPipeValve,
                blockWallMold);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new ItemBlock(blockChair).setRegistryName(blockChair.getRegistryName()),
                new ItemBlock(blockWallpaperWall).setRegistryName(blockWallpaperWall.getRegistryName()),
                new ItemBlock(blockWallpaperWallBaseboard).setRegistryName(blockWallpaperWallBaseboard.getRegistryName()),
                new ItemBlock(blockWallpaperWallBaseboardBroken).setRegistryName(blockWallpaperWallBaseboardBroken.getRegistryName()),
                new ItemBlock(blockYellowCarpet).setRegistryName(blockYellowCarpet.getRegistryName()),
                new ItemBlock(blockYellowCarpetMoldSide).setRegistryName(blockYellowCarpetMoldSide.getRegistryName()),
                new ItemBlock(blockCeiling).setRegistryName(blockCeiling.getRegistryName()),
                new ItemBlock(blockLight).setRegistryName(blockLight.getRegistryName()),
                new ItemBlock(blockLightBroken).setRegistryName(blockLightBroken.getRegistryName()),
                new ItemBlock(blockPebble).setRegistryName(blockPebble.getRegistryName()),
                new ItemBlock(blockPipeStright).setRegistryName(blockPipeStright.getRegistryName()),
                new ItemBlock(blockPipeValve).setRegistryName(blockPipeValve.getRegistryName()),
                new ItemBlock(blockWallMold).setRegistryName(blockWallMold.getRegistryName())
                );
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(Item.getItemFromBlock(blockChair));
        registerRender(Item.getItemFromBlock(blockWallpaperWall));
        registerRender(Item.getItemFromBlock(blockWallpaperWallBaseboard));
        registerRender(Item.getItemFromBlock(blockWallpaperWallBaseboardBroken));
        registerRender(Item.getItemFromBlock(blockYellowCarpet));
        registerRender(Item.getItemFromBlock(blockYellowCarpetMoldSide));
        registerRender(Item.getItemFromBlock(blockCeiling));
        registerRender(Item.getItemFromBlock(blockLight));
        registerRender(Item.getItemFromBlock(blockLightBroken));
        registerRender(Item.getItemFromBlock(blockPebble));
        registerRender(Item.getItemFromBlock(blockPipeStright));
        registerRender(Item.getItemFromBlock(blockPipeValve));
        registerRender(Item.getItemFromBlock(blockWallMold));
    }

    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
    }

}
