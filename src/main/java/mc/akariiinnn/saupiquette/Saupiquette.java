package mc.akariiinnn.saupiquette;

import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;
public final class Saupiquette extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new EventListener(), this);
        try {
            this.getCommand("admin").setExecutor(new CommandAdmin());
            this.getCommand("roll").setExecutor(new CommandRoll());
            this.getCommand("competence").setExecutor(new CommandCompetences());
            this.getCommand("combat").setExecutor(new CommandCombat());
            this.getCommand("sethome").setExecutor(new CommandSetHome());
            this.getCommand("home").setExecutor(new CommandHome());
            this.getCommand("winrate").setExecutor(new CommandWinrate());
            this.getCommand("craft").setExecutor(new CommandCraft());
            this.getCommand("money").setExecutor(new CommandMoney());
        } catch(NullPointerException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("loaded");
    }


    @Override
    public void onDisable() {

    }
}
