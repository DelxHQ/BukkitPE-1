package net.BukkitPE.network.protocol;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ContainerSetDataPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.CONTAINER_SET_DATA_PACKET;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    public byte windowid;
    public int property;
    public int value;

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putByte(this.windowid);
        this.putShort(this.property);
        this.putShort(this.value);
    }
}
