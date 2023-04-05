package mc.akariiinnn.saupiquette;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        PlayerStats.createStats(event.getPlayer());
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        Player p = event.getEntity();
        Player k = null;
        try{
            k = event.getEntity().getKiller();
        } catch(NullPointerException e)
        {
            System.out.println("No killer");
        }
        if(k != null)
        {
            p.sendMessage("You are killed by " + k.getName());
            PlayerStats.updateKills(k);
            PlayerStats.updateDeaths(p);
            System.out.println(p.getName() + "Est mort lol");
        }
    }
}
