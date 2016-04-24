package net.BukkitPE.level.generator.task;

import net.BukkitPE.block.Block;
import net.BukkitPE.level.Level;
import net.BukkitPE.level.SimpleChunkManager;
import net.BukkitPE.level.generator.Generator;
import net.BukkitPE.level.generator.biome.Biome;
import net.BukkitPE.math.NukkitRandom;
import net.BukkitPE.scheduler.AsyncTask;

import java.util.Map;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class GeneratorRegisterTask extends AsyncTask {

    public Class<? extends Generator> generator;
    public Map<String, Object> settings;
    public long seed;
    public int levelId;

    public GeneratorRegisterTask(Level level, Generator generator) {
        this.generator = generator.getClass();
        this.settings = generator.getSettings();
        this.seed = level.getSeed();
        this.levelId = level.getId();
    }

    @Override
    public void onRun() {
        Block.init();
        Biome.init();
        SimpleChunkManager manager = new SimpleChunkManager(this.seed);
        try {
            Generator generator = this.generator.getConstructor(Map.class).newInstance(this.settings);
            generator.init(manager, new NukkitRandom(manager.getSeed()));
            GeneratorPool.put(this.levelId, generator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
