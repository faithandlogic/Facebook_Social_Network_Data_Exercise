/*
 * Name: Fatih Sen
 * Date: 2/25/2023
 * Course: CIS 22C
 * Description: This program implements a social network using a dictionary and a list.
 * Professor: Mirsaeid Abolghasemi
 * 
 */

import graphs.*;
import lists.*;
import java.util.Arrays;
import java.util.Scanner;

public class social_network {
    // public dictionary that will hold the social network as profiles
    public static UndirectedGraph<Profile> Profile_Web;

    // constructor
    public social_network() {
        Profile_Web = new UndirectedGraph<>();
        Profile_Web.addVertex(GlobalVariables.Facebook_Core_Node);
    }
    // end constructor

    // mutator method to add a profile to the social network
    public void joinNetwork(Profile new_profile) {
        Profile_Web.addVertex(new_profile);
        Profile_Web.addEdge(GlobalVariables.Facebook_Core_Node, new_profile);
    }

    // mutator method to remove a profile from the social network
    public void leaveNetwork(Profile profile) {
        Profile_Web.removeVertex(profile);
    }

    // mutator method to add a friend to a profile
    public void addFriend(Profile profile, Profile friend) {
        if (profile.equals(friend)) {
            System.out.println("you can't add yourself as a friend!");
            return;
        } else if (profile.getFriends().contains(friend)) {
            System.out.println(" you are already friends with " + friend.getName() + "!");
            return;
        } else if (profile.getName().equals(GlobalVariables.Facebook_Core_Node.getName())) {
            System.out.println("Your Name was not found in the network!");
            return;
        } else if (friend.getName().equals(GlobalVariables.Facebook_Core_Node.getName())) {
            System.out.println("Your Friend's Name was not found in the network!");
            return;
        } else {
            Profile_Web.addEdge(profile, friend);
            profile.addFriend(friend);
            System.out.println(" you added" + friend.getName() + "as a friend successfully!");
        }

    }

    // mutator method to remove a friend from a profile
    public void removeFriend(Profile profile, Profile friend) {
        if (profile.equals(friend)) {
            System.out.println("you can't remove yourself as a friend!");
            return;
        } else if (profile.getName().equals(GlobalVariables.Facebook_Core_Node.getName())) {
            System.out.println("Your Name was not found in the network!");
            return;
        } else if (friend.getName().equals(GlobalVariables.Facebook_Core_Node.getName())) {
            System.out.println("Your Friend's Name was not found in the network!");
            return;
        } else if (!profile.getFriends().contains(friend)) {
            System.out.println(" you are not friends with " + friend.getName() + "!");
            return;
        } else {
            Profile_Web.removeEdge(profile, friend);
            profile.removeFriend(friend);
            System.out.println(" you removed" + friend.getName() + "from your friends successfully!");
        }
    }

    // accessor method to search for a profile in the social network
    public Profile searchProfile(Profile startPosition, String name) {
        QueueInterface<Profile> queue = Profile_Web.getBreadthFirstTraversal(startPosition);// BFT utilize queue date
                                                                                            // strcture
        Profile result = GlobalVariables.Facebook_Core_Node;
        while (!queue.isEmpty()) {
            Profile currentProfile = queue.dequeue();
            if (currentProfile.getName().equals(name)) {
                result = currentProfile;
                break;
            }
        }
        return result;
    }

    // Add a feature to enable people to see a list of their friends’ friends.
    // accessor method to display the friends of a profile
    public void displayFriends(Profile profile) {
        System.out.println("Friends of " + profile.getName() + ":");
        AList<Profile> friends = profile.getFriends();
        for (int i = 1; i <= friends.getLength(); i++) {
            System.out.println(friends.getEntry(i).getName());
        }
    }

}
