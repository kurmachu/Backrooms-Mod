package corp.kamabo.thebackrooms.command;

import corp.kamabo.thebackrooms.block.tile.TileEntityBuzz;
import corp.kamabo.thebackrooms.world.BackroomGeneration;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;
import scala.collection.parallel.ParIterableLike;

import java.util.Comparator;
import java.util.List;

public class ListTilesCommand extends CommandBase {
    @Override
    public String getName() {
        return "listloadedlights";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(sender instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) sender;
            if(player.getEntityWorld().isRemote){
                List<TileEntity> entities = player.getEntityWorld().loadedTileEntityList;
                entities.sort(new Comparator<TileEntity>() {
                    @Override
                    public int compare(TileEntity o1, TileEntity o2) {
                        return (int)(-100*(o1.getPos().getDistance(player.getPosition().getX(),player.getPosition().getY(),player.getPosition().getX())-o2.getPos().getDistance(player.getPosition().getX(),player.getPosition().getY(),player.getPosition().getX())));
                }
                });
                for (TileEntity t : entities){
                    if(t instanceof TileEntityBuzz){
                        if(((TileEntityBuzz)t).sound!=null){
                            if(Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(((TileEntityBuzz)t).sound)){
                                player.sendMessage(new TextComponentString("Playing:" + t.getPos().getDistance(player.getPosition().getX(),player.getPosition().getY(),player.getPosition().getX())));
                            }else {
                                player.sendMessage(new TextComponentString("Loaded:" + t.getPos().getDistance(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getX())));
                            }
                        }else {
                            player.sendMessage(new TextComponentString("Unloaded:" + t.getPos().getDistance(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getX())));
                        }
                    }
                }
            }
        }
    }
}
