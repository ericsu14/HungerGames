package tk.shanebee.hg.game;

import org.bukkit.Location;
import tk.shanebee.hg.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Data class for holding a {@link Game Game's} general arena data
 */
public class GameArenaData extends Data {

    final String name;
    final Bound bound;
    final int timer;
    final int minPlayers;
    final int maxPlayers;
    private final int roamTime;
    int cost;
    final List<Location> spawns;
    Location exit;
    Status status;
    int chestRefillTime = 0;

    public GameArenaData(Game game, String name, Bound bound, int timer, int minPlayers, int maxPlayers, int roamTime, int cost) {
        super(game);
        this.name = name;
        this.bound = bound;
        this.timer = timer;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.roamTime = roamTime;
        this.cost = cost;
        this.spawns = new ArrayList<>();
    }

    /**
     * Get the bounding box of this game
     *
     * @return Bound of this game
     */
    public Bound getBound() {
        return this.bound;
    }

    /**
     * Get the name of this game
     *
     * @return Name of this game
     */
    public String getName() {
        return this.name;
    }

    /**
     * Check if a location is within the games arena
     *
     * @param location Location to be checked
     * @return True if location is within the arena bounds
     */
    public boolean isInRegion(Location location) {
        return bound.isInRegion(location);
    }

    /**
     * Get the roam time of the game
     *
     * @return The roam time
     */
    public int getRoamTime() {
        return this.roamTime;
    }

    /**
     * Get max players for this game
     *
     * @return Max amount of players for this game
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Get min players for this game
     *
     * @return Min amount of players for this game
     */
    public int getMinPlayers() {
        return minPlayers;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Get a list of all spawn locations
     *
     * @return All spawn locations
     */
    public List<Location> getSpawns() {
        return spawns;
    }

    /**
     * Add a spawn location to the game
     *
     * @param location The location to add
     */
    public void addSpawn(Location location) {
        this.spawns.add(location);
    }

    /**
     * Set the status of the game
     *
     * @param status Status to set
     */
    public void setStatus(Status status) {
        this.status = status;
        game.gameBlockData.updateLobbyBlock();
    }

    /**
     * Get the status of the game
     *
     * @return Status of the game
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * Get the exit location associated with this game
     *
     * @return Exit location
     */
    public Location getExit() {
        return this.exit;
    }

    /**
     * Set exit location for this game
     *
     * @param location Location where players will exit
     */
    public void setExit(Location location) {
        this.exit = location;
    }

    /**
     * Set the chest refill time for this game
     *
     * @param refill Remaining time in game (seconds : 30 second intervals)
     */
    @SuppressWarnings("unused")
    public void setChestRefill(int refill) {
        this.chestRefillTime = refill;
    }



    /**
     * Set the chest refill time
     *
     * @param time The remaining time in the game for the chests to refill
     */
    public void setChestRefillTime(int time) {
        this.chestRefillTime = time;
    }

    /**
     * Get the chest refill time
     *
     * @return The remaining time in the game which the chests will refill
     */
    public int getChestRefillTime() {
        return this.chestRefillTime;
    }

}