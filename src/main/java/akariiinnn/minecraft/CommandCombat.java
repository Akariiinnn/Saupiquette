package akariiinnn.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class CommandCombat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        if(sender instanceof Player)
        {
            try {
                Player player1 = (Player) sender;
                Player player2 = Bukkit.getPlayer(args[0]);
                player2.getName();
                Random rand = new Random();

                int number = rand.nextInt(2);

                Bukkit.broadcastMessage("■■■■■■■■■■■■■■■■■■■■■■■■■■■■[COMBAT]■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                Bukkit.broadcastMessage("\nCompétences de " + player1.getName() + ": \n");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "competence " + player1.getName());
                Bukkit.broadcastMessage("\nCompétences de " + player2.getName() + ": \n");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "competence " + player2.getName());
                new Thread(new Runnable() {
                    public void run() {
                        try{
                            for(int i = 0; i<7; i++)
                            {
                                player1.sendTitle(ChatColor.GREEN + "Vous commencez", null, 0, 25, 0);
                                player1.playSound(player1.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_HIT, 3.0F, 0.5F);
                                player2.sendTitle(ChatColor.GREEN + "L'autre commence !", null, 0, 25, 0);
                                player2.playSound(player2.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_HIT, 3.0F, 0.5F);
                                Thread.sleep(400);
                                player1.sendTitle(ChatColor.RED + "L'autre commence !", null, 0, 25, 0);
                                player1.playSound(player1.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_HIT, 3.0F, 0.5F);
                                player2.sendTitle(ChatColor.RED + "Vous commencez", null, 0, 25, 0);
                                player2.playSound(player2.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_HIT, 3.0F, 0.5F);
                                Thread.sleep(400);
                            }

                        Thread.sleep(500);
                        System.out.println(number);
                        if(number == 0)
                        {
                            player1.sendTitle(ChatColor.GREEN + "Vous commencez", null, 0, 100, 0);
                            player2.sendTitle(ChatColor.RED + "L'autre commence !", null, 0, 100, 0);
                        }else
                        {
                            player1.sendTitle(ChatColor.RED + "L'autre commence !", null, 0, 100, 25);
                            player2.sendTitle(ChatColor.GREEN + "Vous commencez", null, 0, 100, 25);
                        }
                        player1.playSound(player1.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 3.0F, 0.5F);
                        player2.playSound(player2.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 3.0F, 0.5F);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).start();

            } catch(NullPointerException e) {
                sender.sendMessage("Joueur introuvable");
            }
        }

        return true;
    }
}
