
import java.util.*; 
import java.lang.*;
/**
 * This abstract data type represents the backend for a streaming radio service.
 * It stores the songs, stations, and users in the system, as well as the
 * ratings that users assign to songs.
 */ 
public interface StreamingRadio {

    /**
     * The abstract methods below are declared as void methods with no
     * parameters. You need to expand each declaration to specify a return type
     * and parameters, as necessary. You also need to include a detailed comment
     * for each abstract method describing its effect, its return value, any
     * corner cases that the client may need to consider, any exceptions the
     * method may throw (including a description of the circumstances under
     * which this will happen), and so on. You should include enough details
     * that a client could use this data structure without ever being surprised
     * or not knowing what will happen, even though they haven't read the
     * implementation.
     */

    /**
     *	This methods adds a song to the streaming service system and returns a boolean value. 
	 *	If any of the parameters below are null then the method throws a NullPointerException. 
	 *	The method returns true if none of the parameters are null and the song has been added 
	 *	to the system. However, the method does nothing and returns false if the song trying to 
	 *	be added is already in the system. This is since it will not re-add a song to the system 
	 *	that already is present in that system. If currentSong is not an actual song found in 
	 *	the radio system, then the method will throw an IllegalArgumentException. NOTE: this is 
	 *	a dynamic-capacity list of songs and so there should never be an issue with the system 
	 *	running out of space to add more songs.
	 *
	 *	@param currentUser the specific User to whose system we must add a Song
	 *	@param currentSong the specific Song that will be added to this User's system
	 *	@throws NullPointerException when at least one parameter is null
	 *	@throws IllegalArgumentException when currentSong is not an actual song in our system
	 *	@return True if song has been added, false if song was already in the system
     */	
    public boolean addSong(User currentUser, Song currentSong) throws NullPointerException, IllegalArgumentException;

    /**
     * 	This method removes a Song from the user's system, assuming the song is already present in the system, 
	 *	and returns a boolean value. If any of the parameters below are null then the  
	 *	method throws a NullPointerException. If currentSong is not an actual song in our database of all songs, 
	 *	the method will throw an IllegalArgumentException. The method returns true if it removes
	 *	a song from the user's system. The method returns false when the currentSong is in our database	 
	 *	of all songs but was never in the user's system and so cannot be removed.  
	 *
	 *	@param currentUser the specific User to whose system we must remove a Song
	 *	@param currentSong the specific Song that will be removed from this User's system
	 *	@throws NullPointerException when at least one parameter is null
	 *	@throws IllegalArgumentException when currentSong is not a song that is in our database of all songs
	 *	@return True if song was removed, false if song wasn't in the user's system
     */
    public boolean removeSong(User currentUser, Song currentSong) throws NullPointerException, IllegalArgumentException;

    /**
     * 	This methods adds a song to a specific user's chosen station and returns a boolean value. 
	 *	If any of the three parameters below are null then the method throws a NullPointerException. 
	 *	The method throws an IllegalArgumentException if currentSong is not one of the songs in our database.
	 *	The method throws a NoSuchElementException if chosenStation is not one of the stations that our system has.
	 *	The method returns true if none of the parameters are null, no Exception's are thrown, and it adds the song
	 *	to the user's chosen station.  However, the method does nothing and returns false if the song trying to be 
	 *	added is already in that specific user's station. This is since it will not re-add a song to the station 
	 *	that already is present in that station.
	 *
	 *	@param currentUser the specific User to whose Station we must add a Song
	 *	@param currentSong the specific Song that will be added to this User's specified Station
	 *	@param chosenStation the specific Station to which the Song will be added for this User
	 *	@throws NullPointerException when at least one parameter is null
	 *	@throws IllegalArgumentException when currentSong is not a song in the radio's database of all songs.
	 *	@throws NoSuchElementException when chosenStation is not an actual station that this service supports.
	 *	@return True if song has been added to user's specified station, false if song was already in the station for this user
     */
    public boolean addToStation(User currentUser, Song currentSong, Station chosenStation) throws NullPointerException, IllegalArgumentException, NoSuchElementException;

    /**
     * 	This method removes a song from a user's chosen station and returns a boolean value. If any of the three   
	 *	parameters below are null then the method throws a NullPointerException. The method throws an 
	 *	IllegalArgumentException if currentSong is not one of the songs found in our database. The method throws 
	 *	a NoSuchElementException if chosenStation is not one of the stations that our system has.
	 *	The method returns true if it is able to remove the given song from a user's given station. The method 
	 *	will return false if the valid song was never added in the user's chosen station and so cannot be removed.
	 *
	 *	@param currentUser the specific User to whose Station we must remove a Song
	 *	@param currentSong the specific Song that will be removed from this User's specified Station
	 *	@param chosenStation the specific Station from which we remove the Song for this User
	 *	@throws NullPointerException when at least one parameter is null
	 *	@throws IllegalArgumentException when currentSong is not a song in the database of all songs for this service.
	 *	@throws NoSuchElementException when chosenStation is not a station that this service supports.
	 *	@return true if song is removed, false if song was never added in the first place to user's chosen station
     */
    public boolean removeFromStation(User currentUser, Song currentSong, Station chosenStation) throws NullPointerException, IllegalArgumentException, NoSuchElementException;

    /** 
	 *	This method rates a song in the service with a rating from 1 to 5 stars and returns a boolean value.
	 *	The method will return true if the song is valid, the rating is between 1 and 5, and the song has 
     *	has been rated. The method will return false if the song is valid, the rating is between 1 and 5, the  
     *	song has been rated, but this new rating overwrites a previous rating of the song done by the current user.
	 *	The method throws an IllegalArgumentException if currentSong is not a song found in our database of songs.
	 *	The method throws a NoSuchElementException if the rating is a number that is not between 1 and 5, inclusive.
	 *	The method throws a NullPointerException if either the currentSong, currentUser, or the rating are null. 
	 *
	 *	@param currentUser the specific User to whose Station we must add a Song
	 *	@param currentSong the specific Song that will be added to this User's specified Station
	 *	@param rating the rating, from 0 to 5, that a User assigns to a specific Song
	 *	@throws NullPointerException if any of the parameters are null
	 *	@throws IllegalArgumentException if variables passed in violate header, the passed in variables do not exist, the rating passed in is not between 0 and 5
	 *	@throws NoSuchElementException if rating is a number not between 1 and 5, inclusive.
	 *	@return true if song has been rated, false if song has been rated but new rating overwrites an old rating made by that same user 
     */
    public boolean rateSong(User currentUser, Song currentSong, int rating) throws IllegalArgumentException, NullPointerException, NoSuchElementException;

    /**
     * 	Clears a user's rating on a song. If this user has rated this song and
     * 	the rating has not already been cleared, then the rating is cleared and
     * 	the state will appear as if the rating was never made. If there is no
     * 	such rating on record (either because this user has not rated this song,
     * 	or because the rating has already been cleared), then this method will
     * 	throw an IllegalArgumentException.
     *
     * @param currentUser user whose rating should be cleared
     * @param currentSong song from which the user's rating should be cleared
     * @throws IllegalArgumentException if the user does not currently have a
     * rating on record for the song
     * @throws NullPointerException if either the user or the song is null
     */
    public void clearRating(User currentUser, Song currentSong)
    throws IllegalArgumentException, NullPointerException;

    /**
	 *	Predicts the rating a user will assign to a video that they have not yet
     * 	rated, as an integer number of stars from 1 to 5. It will give a value of 0 to new users who have just 
	 *	started using the system and so the service doesn't know much about their music taste.
	 *	The method throws NullPointerException if either the currentUser or currentSong passed in are null. 
	 *	The method throws an IllegalArgumentException if the song passed in does not exist in the database 
	 *	of songs that this service has. 
	 *
	 *	@param currentUser user who we must return a rating to for the song passed in
	 *	@param currentSong song whose rating we must predict and return to user
	 *	@throws NullPointerException if either of the variables passed in to the method are null
	 *	@throws IllegalArgumentException if song passed in is not in database of songs 
	 *	@return int which is the rating the method predicts the user would give the passed in song
     */
    public int predictRating(User currentUser, Song currentSong) throws NullPointerException, IllegalArgumentException;

    /**
     *	NOTE: this method does not necessarily suggest songs that have never been listened to before or rated by the user.
	 *	Suggests and returns a Song that the user would most likely enjoy. 
	 *	The method throws a NullPointerException if either of the parameters passed in are null. 
	 *	The method throws an IllegalArgumentException if the user is very new to the service and 
	 *	the method doesn't have enough information about the user and their musical taste to make
	 *	an informed decision about a song the user would enjoy listening to. 
	 *	
	 *	@param currentUser the user who the method must suggest a song for
	 *	@throws NullPointerException if parameter passed in is null
	 *	@throws IllegalArgumentException if user is new to service and there is not enough information about their musical taste
	 *	@return Song the musical piece that the user would most likely enjoy listening to given their taste. 
	 */
    public Song suggestSong(User currentUser) throws NullPointerException, IllegalArgumentException;

}

