package corp.kamabo.thebackrooms.command;

import corp.kamabo.thebackrooms.BackroomMod;
import corp.kamabo.thebackrooms.world.BackroomGeneration;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;

public class ToBackroomCommand extends CommandBase {
    @Override
    public String getName() {
        return "tobackrooms";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(sender instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) sender;
            if(player.isCreative()){
                player.changeDimension(BackroomGeneration.BACKROOM_WORLD_ID, new ITeleporter() {
                    @Override
                    public void placeEntity(World world, Entity entity, float yaw)
                    {
                        entity.moveToBlockPosAndAngles(new BlockPos(0,6,0), yaw, entity.rotationPitch);
                    }
                });
            }else{
                player.sendMessage(new TextComponentString("You must be in creative to use this debug command."));
            }
        }
    }
}
