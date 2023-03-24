import graphs.*;
import lists.*;
import java.util.Arrays;

public class Profile {
    // name of the profile
    private String name;
    // profile's status
    private String status;
    // profile's friends
    private AList<Profile> friends;

    // constructor
    public Profile(String name) {
        this.name = name;
        status = "No status";
        friends = new AList<>();
    }
    // end constructor

    // ***** GETTERS ******

    // get the name of the profile
    public String getName() {
        return name;
    }

    // get the status of the profile
    public String getStatus() {
        return status;
    }

    // get the friends of the profile
    public AList<Profile> getFriends() {
        return friends;
    }

    // ***** SETTERS ******

    // set the status of the profile
    public void setStatus(String status) {
        this.status = status;
    }
        
    // add a friend to the profile
    public void addFriend(Profile friend) {
        friends.add(friend);
    }

    // remove a friend from the profile's friends array
    public void removeFriend(Profile friend) {

        // get the index of the friend
        int index = -1;
        for (int i = 0; i < friends.getLength(); i++) {
            if (friends.getEntry(i + 1).getName().equals(friend.getName())) {
                index = i;
                break;
            }
        }

        // remove the friend
        if (index != -1) {
            friends.remove(index + 1);
        }

    }

    // print friends list
    public void printFriends() {
        System.out.print(this.getName() + "'s friends are: ");
        for (int i = 0; i < friends.getLength(); i++) {
            System.out.print(friends.getEntry(i + 1).getName() + " ");
        }
        System.out.println();
    }

    // print the profile
    public void printProfile() {
        System.out.println("Name: " + name);
        System.out.println("Status: " + status);
        System.out.print("Friends: ");
        for (int i = 0; i < friends.getLength(); i++) {
            System.out.print(friends.getEntry(i + 1).getName() + " ");
        }
        System.out.println();
    }

} // end Profile class