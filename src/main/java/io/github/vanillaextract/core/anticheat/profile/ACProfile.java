package io.github.vanillaextract.core.anticheat.profile;


import java.util.*;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ACProfile
{
    private static Map<UUID, ACProfile> playerData;
    public long useTime = 1, armTime = 1;

    private Map<UUID, Long> violation = new WeakHashMap<>();

    public boolean alertsToggled = false;

    static
    {
        ACProfile.playerData = new WeakHashMap<>();
    }

    public ACProfile getPlayerProfile(final Player player)
    {
        final UUID uuid = player.getUniqueId();

        if (ACProfile.playerData.containsKey(uuid))
        {
            return ACProfile.playerData.get(uuid);
        }
        final ACProfile data = new ACProfile(player);
        ACProfile.playerData.put(uuid, data);

        return data;
    }
    private final Player player;

    private ACProfile(final Player player)
    {
        this.player = player;
    }

    public Player getPlayer()
    {
        return this.player;
    }

    public long getViolations()
    {
        if (!violation.containsKey(player.getUniqueId()))
        {
            return 0;
        } else
            return violation.get(player.getUniqueId());
    }

    public void addViolation(long violationsAdded)
    {
        violation.put(player.getUniqueId(), violation.getOrDefault(player.getUniqueId(), 0L) + violationsAdded);
    }
}
