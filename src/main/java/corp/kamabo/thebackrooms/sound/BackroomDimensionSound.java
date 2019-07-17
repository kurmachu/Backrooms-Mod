package corp.kamabo.thebackrooms.sound;

import corp.kamabo.thebackrooms.world.BackroomGeneration;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;

public class BackroomDimensionSound extends LoopingSound {

    private EntityPlayer p;

    public BackroomDimensionSound(SoundEvent sound, BlockPos pos, float volume, EntityPlayer player) {
        super(sound, pos, volume);
        p = player;
    }

    @Override
    public void update() {
        this.xPosF = p.getPosition().getX();
        this.xPosF = p.getPosition().getY();
        this.xPosF = p.getPosition().getZ();
        if(p.getEntityWorld().provider.getDimension()!=BackroomGeneration.BACKROOM_WORLD_ID){
            die();
        }
    }
}
