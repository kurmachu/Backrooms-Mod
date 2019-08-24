package corp.kamabo.thebackrooms.item;

import corp.kamabo.thebackrooms.BackroomMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=BackroomMod.MODID)
public class BackroomItems {

    public static final Item.ToolMaterial GLASSSHARD = EnumHelper.addToolMaterial("GLASSSHARD", 0,6,8.0f,5,0);

    public static Item itemBaseboard;
    public static Item itemPencil;
    public static Item itemGlassShard;
    public static Item itemNail;
    public static Item itemRubberBand;
    public static Item itemGlassBundle;

    public static void init(){
        itemBaseboard = new ItemBaseboard();
        itemPencil = new ItemPencil();
        itemGlassShard = new ItemGlassShard();
        itemNail = new ItemNail();
        itemRubberBand = new ItemRubberBand();
        itemGlassBundle = new ItemGlassBundle();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(itemBaseboard);
        event.getRegistry().registerAll(itemPencil);
        event.getRegistry().registerAll(itemGlassShard);
        event.getRegistry().registerAll(itemNail);
        event.getRegistry().registerAll(itemRubberBand);
        event.getRegistry().registerAll(itemGlassBundle);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(itemBaseboard);
        registerRender(itemPencil);
        registerRender(itemGlassShard);
        registerRender(itemNail);
        registerRender(itemRubberBand);
        registerRender(itemGlassBundle);
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
    }
}
