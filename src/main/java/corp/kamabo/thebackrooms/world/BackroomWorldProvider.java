package corp.kamabo.thebackrooms.world;

import corp.kamabo.thebackrooms.BackroomMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.*;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import javax.annotation.Nullable;

public class BackroomWorldProvider extends WorldProvider {

    @Override
    public DimensionType getDimensionType() {
        return BackroomGeneration.BACKROOM_DIM_TYPE;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public boolean shouldMapSpin(String entity, double x, double z, double rotation) {
        return true;
    }

    @Nullable
    @Override
    public IRenderHandler getSkyRenderer() {
        return null;
    }

    @Override
    public boolean canSnowAt(BlockPos pos, boolean checkLight) {
        return false;
    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk) {
        return false;
    }

    @Override
    public BlockPos getRandomizedSpawnPoint() {
        BlockPos ret = this.world.getSpawnPoint();

        int spawnFuzz = this.world instanceof WorldServer ? BackroomGeneration.BACKROOM_WOLRD_TYPE.getSpawnFuzz((WorldServer)this.world, this.world.getMinecraftServer()) : 1;
        while(true){
            ret = new BlockPos((world.rand.nextInt(spawnFuzz*2)-spawnFuzz),1,(world.rand.nextInt(spawnFuzz*2)-spawnFuzz));
            IBlockState block = world.getBlockState(ret);
            if (block.getMaterial() == Material.AIR){
                break;
            }
        }
        return ret;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new BackroomChunkGenerator(world);
    }

}
