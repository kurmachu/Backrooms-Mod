package corp.kamabo.thebackrooms.sound;

import corp.kamabo.thebackrooms.BackroomMod;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.audio.MovingSoundMinecart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=BackroomMod.MODID)
public class BackroomSounds {

    public static SoundEvent buzz;

    public static void init() {
        ResourceLocation sound0 = new ResourceLocation("thebackrooms", "hum-buzz");

        buzz = new SoundEvent(sound0).setRegistryName(sound0);
    }
    @SubscribeEvent
    public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
		ResourceLocation sound0 = new ResourceLocation("thebackrooms", "hum-buzz");
//		event.getRegistry().register(new net.minecraft.util.SoundEvent(sound0).setRegistryName(sound0));
    }
}
