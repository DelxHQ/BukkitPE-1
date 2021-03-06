package net.BukkitPE.level.format;

/**

 * BukkitPE Project
 */
public interface Chunk extends FullChunk {
    byte SECTION_COUNT = 8;

    boolean isSectionEmpty(float fY);

    ChunkSection getSection(float fY);

    boolean setSection(float fY, ChunkSection section);

    ChunkSection[] getSections();

    class Entry {
        public int chunkX, chunkZ;

        public Entry(int chunkX, int chunkZ) {
            this.chunkX = chunkX;
            this.chunkZ = chunkZ;
        }
    }
}
