package de.joshizockt.coinmanager.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class PlayerCoinsAddEvent extends Event implements Cancellable {

    private final UUID player;
    private final int oldCoins;
    private final int newCoins;
    private final int difference;
    private boolean cancelled;
    private static final HandlerList handlerList = new HandlerList();

    public PlayerCoinsAddEvent(UUID player, int oldCoins, int newCoins) {
        this.player = player;
        this.oldCoins = oldCoins;
        this.newCoins = newCoins;
        this.difference = oldCoins + newCoins;
        this.cancelled = false;
    }

    public UUID getPlayer() {
        return player;
    }

    public int getOldCoins() {
        return oldCoins;
    }

    public int getNewCoins() {
        return newCoins;
    }

    public int getDifference() {
        return difference;
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