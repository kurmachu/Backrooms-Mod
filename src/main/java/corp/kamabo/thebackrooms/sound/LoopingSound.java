package corp.kamabo.thebackrooms.sound;

import net.minecraft.client.audio.MovingSound;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;

public class LoopingSound extends MovingSound {

    private BlockPos pos;
    public LoopingSound(SoundEvent sound, BlockPos pos, float volume){
        super(sound, SoundCategory.BLOCKS);
        this.repeat = true;
        this.repeatDelay = 0;
        this.xPosF = pos.getX();
        this.yPosF = pos.getY();
        this.zPosF = pos.getZ();
        this.volume = volume;
    }
    @Override
    public void update() {

    }
    public void die(){
        this.donePlaying = true;
        this.repeat = false;
    }
}
