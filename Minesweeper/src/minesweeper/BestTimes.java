package minesweeper;

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
    private List<PlayerTime> playerTimes = new ArrayList<PlayerTime>();
    
    public BestTimes(){
    	playerTimes.add(new PlayerTime("Vlado",4));
    	playerTimes.add(new PlayerTime("Peter",5));
    	playerTimes.add(new PlayerTime("Jano",3));
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
    public void addPlayerTime(String name, int time) {
        playerTimes.add(playerTimes.size(), new PlayerTime(name,time));
        Collections.sort(playerTimes);
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object
     */
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
        private final int time;

        /**
         * Constructor.
         * @param name player name
         * @param time playing game time in seconds
         */
        public PlayerTime(String name, int time) {
            this.name = name;
            this.time = time;
        }
        
        public String getName(){
        	return this.name;
        }
        
        public int getTime(){
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
    }
}