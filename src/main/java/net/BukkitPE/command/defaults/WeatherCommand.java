package net.BukkitPE.command.defaults;

import net.BukkitPE.Player;
import net.BukkitPE.command.Command;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.event.TranslationContainer;
import net.BukkitPE.level.Level;

/**
 * author: Angelic47
 * BukkitPE Project
 */
public class WeatherCommand extends VanillaCommand {

    private java.util.Random rand = new java.util.Random();

    public WeatherCommand(String name) {
        super(name, "%BukkitPE.command.weather.description", "%commands.weather.usage");
        this.setPermission("BukkitPE.command.weather");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }
        if (args.length == 0 || args.length > 2) {
            sender.sendMessage(new TranslationContainer("commands.weather.usage", this.usageMessage));
            return false;
        }

        String weather = args[0];
        Level level;
        int seconds;
        if (args.length > 1) {
            try {
                seconds = Integer.parseInt(args[1]);
            } catch (Exception e) {
                sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
                return true;
            }
        } else {
            seconds = 600 * 20;
        }

        if (sender instanceof Player) {
            level = ((Player) sender).getLevel();
        } else {
            level = sender.getServer().getDefaultLevel();
        }

        switch (weather) {
            case "clear":
                level.setRaining(false);
                level.setThundering(false);
                level.setRainTime(seconds * 20);
                level.setThunderTime(seconds * 20);
                Command.broadcastCommandMessage(sender,
                        new TranslationContainer("commands.weather.clear"));
                return true;
            case "rain":
                level.setRaining(true);
                level.setRainTime(seconds * 20);
                Command.broadcastCommandMessage(sender,
                        new TranslationContainer("commands.weather.rain"));
                return true;
            case "thunder":
                level.setThundering(true);
                level.setRainTime(seconds * 20);
                level.setThunderTime(seconds * 20);
                Command.broadcastCommandMessage(sender,
                        new TranslationContainer("commands.weather.thunder"));
                return true;
            default:
                sender.sendMessage(new TranslationContainer("commands.weather.usage", this.usageMessage));
                return false;
        }

    }
}
