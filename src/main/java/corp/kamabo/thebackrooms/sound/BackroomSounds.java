package corp.kamabo.thebackrooms.sound;

import corp.kamabo.thebackrooms.BackroomMod;
import corp.kamabo.thebackrooms.world.BackroomGeneration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.audio.MovingSoundMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid=BackroomMod.MODID)
public class BackroomSounds {

    public static SoundEvent buzz;
    public static BackroomDimensionSound dimensionSound;

    public static void init() {
        ResourceLocation sound0 = new ResourceLocation("thebackrooms", "hum-buzz");

        buzz = new SoundEvent(sound0).setRegistryName(sound0);
    }
    @SubscribeEvent
    public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
		ResourceLocation sound0 = new ResourceLocation("thebackrooms", "hum-buzz");
//		event.getRegistry().register(new net.minecraft.util.SoundEvent(sound0).setRegistryName(sound0));
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void playerMove(LivingEvent.LivingUpdateEvent event){
        if((event.getEntity() instanceof EntityPlayer)&&event.getEntity().dimension==BackroomGeneration.BACKROOM_WORLD_ID){
            if(!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(dimensionSound)){
                dimensionSound = null;
            }
            if(dimensionSound==null){
                System.out.println("zoinking egg");
                EntityPlayer p = (EntityPlayer)event.getEntity();
                dimensionSound= new BackroomDimensionSound(buzz,p.getPosition(),0.1f,p);
                Minecraft.getMinecraft().getSoundHandler().playSound(dimensionSound);
            }
        }
    }
}
