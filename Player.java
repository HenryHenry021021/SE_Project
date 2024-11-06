import java.util.Arrays;

public class Player {
	private String playerName;
	private double property;
	private int locationIndex;
	
	
	public Player(String playerName,int locationIndex) {
		this.playerName = playerName;
		this.locationIndex=locationIndex;
		this.property=1420;
	}
	
	
	public int getLocationIndex() {
		return locationIndex;
	}

	public void setlocationIndex(int location) {
		this.locationIndex = location;
	}

	

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(int playerIndex) {
		this.playerName = "Player " + playerName;
	}

	public double getProperty() {
		return property;
	}

	public void setProperty(double property) {
		this.property = property;
	}
	
	public void addProperty(double property) {
		this.property+=property;
	}
	
	public void subProperty(double property) {
		this.property-=property;
	}

	 @Override
    public String toString() {
       return playerName+" "+ property +" "+locationIndex;
    }
	
	
}
