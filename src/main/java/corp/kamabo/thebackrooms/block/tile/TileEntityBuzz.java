package corp.kamabo.thebackrooms.block.tile;

import corp.kamabo.thebackrooms.BackroomMod;
import corp.kamabo.thebackrooms.sound.BackroomSounds;
import corp.kamabo.thebackrooms.sound.LoopingSound;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.collection.parallel.ParIterableLike;

public class TileEntityBuzz extends TileEntity {
    public LoopingSound sound;

    public TileEntityBuzz(){
//        MinecraftForge.EVENT_BUS.register(this);
    }

//    @SideOnly(Side.CLIENT)
//    @Override
//    public void onChunkUnload() {
//        super.onChunkUnload();
//        if(sound!=null){
//            sound.die();
//            sound = null;
//        }
//    }
    @Override
    public void invalidate() {
        super.invalidate();
        if (getWorld().isRemote) {
            System.out.println("Mesothelioma invalidate.");
            if (sound != null) {
                sound.die();
                sound = null;
            }
        }
    }
//    @SideOnly(Side.CLIENT)
//    @Override
//    public void validate() {
//        super.validate();
//        System.out.println("Mesothelioma");
//        if(sound==null){
//            sound = new LoopingSound(BackroomSounds.buzz,pos, 0.1f);
//            Minecraft.getMinecraft().getSoundHandler().playSound(sound);
//        }
//    }
    @Override
    public void onLoad() {
        super.onLoad();
        if (getWorld().isRemote) {
            if (sound == null) {
                sound = new LoopingSound(BackroomSounds.buzz, pos, 0.1f);
                Minecraft.getMinecraft().getSoundHandler().playSound(sound);
            }
        }
    }
    public void AttemptSucc(){
        if (getWorld().isRemote) {
//            if (sound != null) {
//                sound.die();
//                sound = null;
//            }
//            System.out.println("Mesothelioma succ.");
            if (sound == null) {
                sound = new LoopingSound(BackroomSounds.buzz, pos, 0.1f);
                Minecraft.getMinecraft().getSoundHandler().playSound(sound);
                if(Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(sound)){
                    System.out.println("oh hey it worked");
                }else{
                    System.out.println("fuck");
                }
            }else if(!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(sound)){
                sound = new LoopingSound(BackroomSounds.buzz, pos, 0.1f);
                Minecraft.getMinecraft().getSoundHandler().playSound(sound);
                if(Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(sound)){
                    System.out.println("oh hey it worked");
                }else{
                    System.out.println("fuck");
                }
            }
        }
    }
    public void cease(){
        if (sound != null) {
                sound.die();
                sound = null;
            }
    }

//    @Override
//    public void update() {
//        if (getWorld().isRemote) {
//            if (sound == null) {
//                System.out.println("Mesothelioma load tick.");
//                sound = new LoopingSound(BackroomSounds.buzz, pos, 0.1f);
//                Minecraft.getMinecraft().getSoundHandler().playSound(sound);
//            }
//        }
//    }


//    @SubscribeEvent
//    public void onBreakEvent(BlockEvent.BreakEvent event) {
//        if(event.getPos().equals(getPos())){
//
//        }
//    }


}
