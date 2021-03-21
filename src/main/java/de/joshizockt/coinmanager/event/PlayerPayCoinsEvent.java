package de.joshizockt.coinmanager.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class PlayerPayCoinsEvent extends Event implements Cancellable {

    private static final HandlerList handlerList = new HandlerList();

    private final UUID sender;
    private final UUID receiver;
    private final int coins;
    private boolean cancelled;

    public PlayerPayCoinsEvent(UUID sender, UUID receiver, int coins) {
        this.sender = sender;
        this.receiver = receiver;
        this.coins = coins;
        this.cancelled = false;
    }

    public int getCoins() {
        return coins;
    }

    public UUID getReceiver() {
        return receiver;
    }

    public UUID getSender() {
        return sender;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

}
