package corp.kamabo.thebackrooms.world;

import corp.kamabo.thebackrooms.block.tile.TileEntityBuzz;
import ibxm.Player;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Comparator;
import java.util.List;

public class BackroomWorldRespawn {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void playerRespawn(PlayerEvent.PlayerRespawnEvent event){
        if(event.player.dimension==BackroomGeneration.BACKROOM_WORLD_ID){
            if(event.player.bedLocation==null){
                ZoinkPlayer(event.player,event.player.world);
            }
        }
    }

    private void ZoinkPlayer(EntityPlayer player, World world){
        BlockPos ret = world.getSpawnPoint();

        int spawnFuzz = world instanceof WorldServer ? BackroomGeneration.BACKROOM_WOLRD_TYPE.getSpawnFuzz((WorldServer)world, world.getMinecraftServer()) : 1;
        while(true){
            ret = new BlockPos((-spawnFuzz+world.rand.nextInt(spawnFuzz*2)),1, (-spawnFuzz+world.rand.nextInt(spawnFuzz*2)));
            IBlockState block = world.getBlockState(ret);
            if (block.getMaterial() == Material.AIR){
                break;
            }
        }
        //event.player.attemptTeleport(ret.getX(),ret.getY(),ret.getZ());
//                System.out.println(ret.getX()+":"+ret.getY()+":"+ret.getZ());
//                event.player.posX = ret.getX();
//                event.player.posY = ret.getY();
//                event.player.posZ = ret.getZ();
        player.setPositionAndUpdate(ret.getX(),ret.getY(),ret.getZ());
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void playerMove(LivingEvent.LivingUpdateEvent event){
        if((event.getEntity() instanceof EntityPlayer)&&event.getEntity().dimension==BackroomGeneration.BACKROOM_WORLD_ID){
            if(event.getEntity().posY>4){
                if(event.getEntity() instanceof EntityPlayer){
                    if(((EntityPlayer)event.getEntity()).isCreative()){
                        return;
                    }
                }
                ZoinkPlayer(((EntityPlayer) event.getEntity()),event.getEntity().getEntityWorld());
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void playerChunk(EntityEvent.EnteringChunk event) {
        if((event.getEntity() instanceof EntityPlayer)&&event.getEntity().dimension==BackroomGeneration.BACKROOM_WORLD_ID){
            EntityPlayer player = (EntityPlayer)event.getEntity();
            if(player.getEntityWorld().isRemote){
                List<TileEntity> entities = player.getEntityWorld().loadedTileEntityList;
                entities.sort(new Comparator<TileEntity>() {
                    @Override
                    public int compare(TileEntity o1, TileEntity o2) {
                        return (int)(100*(o1.getPos().getDistance(player.getPosition().getX(),player.getPosition().getY(),player.getPosition().getX())-o2.getPos().getDistance(player.getPosition().getX(),player.getPosition().getY(),player.getPosition().getX())));
                    }
                });
                for (TileEntity t : entities){
                    if(t instanceof TileEntityBuzz){
                        ((TileEntityBuzz) t).cease();
                    }
                }
                int yegg = 10;
                for (TileEntity t : entities){
                    if(t instanceof TileEntityBuzz){
                        ((TileEntityBuzz) t).AttemptSucc();
                        yegg--;
                        if(yegg<=0){
                            break;
                        }
                    }
                }
            }
        }
    }
}
