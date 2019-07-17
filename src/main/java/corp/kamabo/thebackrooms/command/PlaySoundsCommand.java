package corp.kamabo.thebackrooms.command;

import corp.kamabo.thebackrooms.block.tile.TileEntityBuzz;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.TextComponentString;

import java.util.Comparator;
import java.util.List;

public class PlaySoundsCommand extends CommandBase {
    @Override
    public String getName() {
        return "playloadedsounds";
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
//                List<TileEntity> entities = player.getEntityWorld().loadedTileEntityList;
//                entities.sort(new Comparator<TileEntity>() {
//                    @Override
//                    public int compare(TileEntity o1, TileEntity o2) {
//                        return (int)(100*(o1.getPos().getDistance(player.getPosition().getX(),player.getPosition().getY(),player.getPosition().getX())-o2.getPos().getDistance(player.getPosition().getX(),player.getPosition().getY(),player.getPosition().getX())));
//                    }
//                });
//                int yegg = 10;
                for (TileEntity t : player.getEntityWorld().loadedTileEntityList){
                    if(t instanceof TileEntityBuzz){
                        ((TileEntityBuzz) t).AttemptSucc();
//                        yegg--;
//                        if(yegg<=0){
//                            break;
//                        }
                    }
                }
            }}
    }
}
