package io.github.vanillaextract.core.anticheat.detections.example;

import io.github.vanillaextract.core.VanillaCore;
import io.github.vanillaextract.core.anticheat.CheckType;
import io.github.vanillaextract.core.anticheat.detections.ACDetection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class ExampleDetection extends ACDetection
{
    public ExampleDetection(VanillaCore core)
    {
        super(core, CheckType.GENERAL, 1L);
    }

    @EventHandler
    public void onMove(PlayerInteractAtEntityEvent event)
    {
        Player player = event.getPlayer();

        player.sendMessage("Works!");
    }
}
