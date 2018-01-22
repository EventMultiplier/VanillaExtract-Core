package io.github.vanillaextract.core.anticheat.detections;

import com.google.common.collect.ImmutableList;
import io.github.vanillaextract.core.VanillaCore;
import io.github.vanillaextract.core.anticheat.CheckType;
import io.github.vanillaextract.core.anticheat.profile.ACProfile;
import io.github.vanillaextract.core.inject.VanillaInjected;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public abstract class ACDetection extends VanillaInjected implements Listener
{
    private CheckType checkType;
    private long violationsAdded;

    private ACProfile acProfile;

    public ACDetection(VanillaCore core, CheckType checkType, long violationsAdded)
    {
        super(core);

        this.checkType = checkType;
        this.violationsAdded = violationsAdded;
    }

    protected void playerFlag(Player player)
    {
        final ImmutableList<Player> players = ImmutableList.copyOf(Bukkit.getOnlinePlayers());
        for (int i = 0; i < players.size(); i++) {
            final Player toSend = players.get(i);

            if (toSend.hasPermission("vanilla.staff") || toSend.hasPermission("vanilla.admin"))
            {
                this.getProfile(player).addViolation(this.violationsAdded);

                // Should grab the message from the config
                toSend.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Vanilla" + ChatColor.GRAY + "] > " + ChatColor.AQUA + player.getName() + ChatColor.GRAY + " failed " + ChatColor.AQUA + checkType + ChatColor.GRAY + " [VL:" + getProfile(player).getViolations() + ChatColor.GRAY + "]");
            }
        }
    }

    protected ACProfile getProfile(Player player)
    {
       return acProfile.getPlayerProfile(player);
    }
}
