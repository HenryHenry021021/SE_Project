import java.util.Arrays;

public class Player {
	private String playerName;
	private double property;
	private int locationIndex;
	private int jailRestirction;
	private int index;
	
	public Player(String playerName,int locationIndex) {
		this.playerName = playerName;
		this.locationIndex=locationIndex;
		this.property=1500;
		this.jailRestirction = 0;
	}
	public Player(int index,String playerName,double property,int locationIndex,int jailRestirction) {
		this.playerName = playerName;
		this.locationIndex=locationIndex;
		this.property=property;
		this.jailRestirction = jailRestirction;
		this.index = index;
	}
	public int getIndex() {
		return index;
	}
	public int getJailRestirction() {
		return jailRestirction;
	}

	public void setjailRestirction(int jailRestirction) {
		this.jailRestirction = jailRestirction;
	}

	public void subJailRestriction(){
		jailRestirction--;
	}

	public void zeroJailRestriction(){
		jailRestirction=0;
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
       return playerName+", Property: "+ property +", Location Num: "+(locationIndex+1);
    }
	
	
}
