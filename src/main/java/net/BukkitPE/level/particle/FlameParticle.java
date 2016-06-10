package net.BukkitPE.level.particle;

import net.BukkitPE.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package net.BukkitPE.level.particle in project BukkitPE .
 */
public class FlameParticle extends GenericParticle {
    public FlameParticle(Vector3 pos) {
        super(pos, Particle.TYPE_FLAME);
    }
}