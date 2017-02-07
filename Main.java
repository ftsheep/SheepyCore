import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by fts on 2/5/2017.
 */
public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("[Sheepy Core] Loaded.");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        System.out.println("[Sheepy Core] Disabled.");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        event.setJoinMessage("");
        if (!event.getPlayer().hasPlayedBefore()) {
            event.getPlayer().sendMessage(ChatColor.AQUA + "[PowerTrip]" + ChatColor.DARK_AQUA + " Welcome to PowerTrip! Please run /FAQ for an answer to common questions!");
            {
            }
        } else {
            event.getPlayer().sendMessage(ChatColor.AQUA + "[PowerTrip]" + ChatColor.DARK_AQUA + " Welcome back!");
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        event.setQuitMessage("");
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("FAQ") && sender instanceof Player) {

            Player player = (Player) sender;
            if (player.hasPermission("sheepy.faq")) {
                player.sendMessage(ChatColor.AQUA + "Q: How do I make an island?");
                player.sendMessage(ChatColor.DARK_AQUA + "A: Run /is and then select an island type!");
                player.sendMessage(ChatColor.AQUA + "Q: How do I sell items?");
                player.sendMessage(ChatColor.DARK_AQUA + "A: /ah is a great place to sell items to other players!");
                player.sendMessage(ChatColor.AQUA + "Q: How can I get super cool rewards for playing?");
                player.sendMessage(ChatColor.DARK_AQUA + "A: Voting for the server will get you some fancy goodies! Also, if you donate, not only do you get goodies, but a snazzy prefix!!");
                player.sendMessage(ChatColor.AQUA + "Q: If I need more help, what should I do?");
                player.sendMessage(ChatColor.DARK_AQUA + "A: Our staff team is here to help you! Feel free to ask them any questions!");
                player.sendMessage(ChatColor.AQUA + "Q: How can I add / remove people from my island?");
                player.sendMessage(ChatColor.DARK_AQUA + "A: Do add people to your island temporarily do /is coop <name>, to add people permanently do /is invite <name>. For removing players from your island team do /is remoove. ");
                player.sendMessage(ChatColor.AQUA + "Q: How can I vew my island control panel?");
                player.sendMessage(ChatColor.DARK_AQUA + "A: You can view your control panel at /is cp.");
                player.sendMessage(ChatColor.AQUA + "Q: Where can I find the website?");
                player.sendMessage(ChatColor.DARK_AQUA + "A: You can find our lovely website at: http://www2.powertrip.net/index.php. ");
            } else {
                player.sendMessage(ChatColor.RED + "You do not have access to this command.");
            }
        }
        //START NEXT COMMAND HERE
        return false;
    }
}