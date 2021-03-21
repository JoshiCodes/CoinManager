# CoinManager

## Download
<br>
You can download the Spigot Plugin here: (SOON)
<br><br><br>

## Commands
<br>
The CoinManager have currently 1 Command: <br>

###### balance
This Command shows the current Player balance. You can also add a Player as argument to view their Balance.

<br><br><br>

## API
<br>
The CoinManager have 4 Events you can listen to: <br>
- PlayerCoinsAddEvent (When Coins for a Player are added) <br>
- PlayerCoinsRemoveEvent (When Coins for a Player are removed) <br>
- PlayerCoinsSetEvent (When Coins for a Player are set) <br>
- PlayerPayCoinsEvent (When someone pays Coins to another Player) <br>

<br><br><br>
You can give a Player Coins with this Code:
```java
CoinManager.getStorageMananager().addCoins(UUID, COINS);
```

You can remove Coins from a Player with this code:
```java
CoinManager.getStorageMananager().removeCoins(UUID, COINS);
```

You can also set the Coins for a Player:
```java
CoinManager.getStorageMananager().setCoins(UUID, COINS);
```

And of course you can get the Coins of a Player:
```java
CoinManager.getStorageMananager().getCoins(UUID);
```

