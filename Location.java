import java.util.*;

public abstract class Location {
	protected String locationName;
	protected int locationIndex;

	Scanner scanner;
	ArrayList<Player> players = new ArrayList<Player>();

	public Location(String locationName, int locationIndex, Scanner scanner) {
		this.locationName = locationName;
		this.locationIndex = locationIndex;

		this.scanner = scanner;

	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public int getLocationIndex() {
		return locationIndex;
	}

	public void setLocationIndex(int locationIndex) {
		this.locationIndex = locationIndex;
	}

	
	public String toString() {
		return locationName + " " + getPlayerList();
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	// 移除一个玩家从列表
	public void removePlayer(Player player) {
		this.players.remove(player);
	}

	public String getPlayerList() {
		String playerList = "  ";
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			if (i != players.size() - 1) {
				playerList += player.getPlayerName() + ", ";
			} else {
				playerList += player.getPlayerName();

			}
		}
		// System.out.print(playerList);
		return playerList;
	}

	public abstract void locationFunction(Player player);

}