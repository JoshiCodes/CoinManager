package de.joshizockt.coinmanager.storage;

public enum StorageType {

    FILE(new FileHandler()), MYSQL(new SQLHandler());

    StorageHandler handler;
    StorageType(StorageHandler handler) {
        this.handler = handler;
    }

}
