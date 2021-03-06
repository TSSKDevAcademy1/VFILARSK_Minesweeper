package minesweeper;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;



/**
 * Player times.
 */
public class BestTimes implements Iterable<BestTimes.PlayerTime> {
    /** List of best player times. */
	public static final String URL = "jdbc:mysql://localhost/minesweeper";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	public static final String QUERYINSERT = "INSERT INTO bestTimes (name, time) VALUES (?, ?)";
	public static final String QUERYSELECT = "SELECT name, time FROM bestTimes";
	public static final String QUERYDELETE = "DELETE FROM bestTimes";
    private List<PlayerTime> playerTimes = new ArrayList<PlayerTime>();
    
    
    public BestTimes(){
    	
    }
    /**
     * Returns an iterator over a set of  best times.
     * @return an iterator
     */
    public Iterator<PlayerTime> iterator() {
        return playerTimes.iterator();
    }

    /**
     * Adds player time to best times.
     * @param name name ot the player
     * @param time player time in seconds
     */
    public void addPlayerTime(String name, long time) {
     //   playerTimes.add(playerTimes.size(), new PlayerTime(name,time));
     //   Collections.sort(playerTimes);
    	try {
			try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
				try (Statement stmt = con.createStatement()) {
					stmt.executeUpdate(QUERYDELETE);
				}

				try (PreparedStatement stmt = con.prepareStatement(QUERYINSERT)) {
					Iterator<PlayerTime> fIterator = playerTimes.iterator();
					while(fIterator.hasNext()){
						PlayerTime bestTime = fIterator.next();
						stmt.setString(1, bestTime.getName());
						stmt.setLong(2, bestTime.getTime());
						stmt.executeUpdate();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object
     */
    
    private void load(){
    	try {
			try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(QUERYSELECT);) {

				

				while (rs.next()) {
					playerTimes.add(new PlayerTime(rs.getString(1),rs.getLong(2)));
				}

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    }
    
    
    public String toString() {
    	
    	  Formatter f = new Formatter();
          Iterator<PlayerTime> fIterator = playerTimes.iterator();
          int j = 1;
          while(fIterator.hasNext()){
          	f.format(fIterator.next().toString());
          	j++;
          }
          return f.toString();
        
    }

    /**
     * Player time.
     */
    public static class PlayerTime implements Comparable<PlayerTime>{
        /** Player name. */
        private final String name;

        /** Playing time in seconds. */
        private final long time;

        /**
         * Constructor.
         * @param name player name
         * @param time playing game time in seconds
         */
        public PlayerTime(String name, long time) {
            this.name = name;
            this.time = time;
        }
        
        public String getName(){
        	return this.name;
        }
        
        public long getTime(){
        	return this.time;
        }

		@Override
		public int compareTo(PlayerTime o) {
			if(this.time == o.time){
				return 0;
			} else if(this.time > o.getTime()){
				return -1;
			} else {
				return 1;
			}
			
		}
		public String toString(){
			String string = this.name + " " + this.time + "\n";
			return string;
		}
    }
}