package ddr;

import java.util.ArrayList;
import java.util.List;

import model.DataPacket;

public class DDRMemory {

    private List<DataPacket> storage;

    public DDRMemory() {
        this.storage = new ArrayList<>();
    }

    public void store(DataPacket packet) {
        storage.add(packet);
    }

    public List<DataPacket> getAllPackets() {
        return storage;
    }

    public int size() {
        return storage.size();
    }
}