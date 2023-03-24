import java.util.Scanner;

public class Driver {
    static social_network facebook = new social_network();

    public static void main(String[] args) {

        // Facebook Core Node , also a dummy node for missing profiles
        facebook.joinNetwork(GlobalVariables.Facebook_Core_Node);

        System.out.println("Welcome to Facebook. What would you like to do?");
        System.out.println("1 Join the Facebook network.");
        System.out.println("2 Add friends to my account.");
        System.out.println("3 Delete friends from my account.");
        System.out.println("4 Update my account status.");
        System.out.println("5 See my friends' friends.");
        System.out.println("6 Search for a friend's profile.");
        System.out.println("7 Delete my account. (Leave the network)");
        System.out.println("8 Logout.");
        System.out.println("Please enter your choice:");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        while (choice != 7) {
            switch (choice) {
                case 1:
                    System.out.println("Please enter your name.");
                    String name = input.next();
                    Profile newProfile = new Profile(name);
                    facebook.joinNetwork(newProfile);

                    System.out.println("-------------------------------");
                    System.out.println("Congratulations " + newProfile.getName() + " Your account has been created!");
                    System.out.println("-------------------------------");

                    break;
                case 2:
                    System.out.println("Please enter your name.");
                    String name1 = input.next();
                    Profile profile1 = facebook.searchProfile(GlobalVariables.Facebook_Core_Node, name1);
                    System.out.println("Please enter the name of the friend you would like to add.");
                    String name2 = input.next();
                    Profile profile2 = facebook.searchProfile(GlobalVariables.Facebook_Core_Node, name2);

                    System.out.println("-------------------------------");
                    facebook.addFriend(profile1, profile2);
                    System.out.println("-------------------------------");

                    break;
                case 3:
                    System.out.println("Please enter your name.");
                    String name3 = input.next();
                    Profile profile3 = facebook.searchProfile(GlobalVariables.Facebook_Core_Node, name3);
                    System.out.println("Please enter the name of the friend you would like to remove.");
                    String name4 = input.next();
                    Profile profile4 = facebook.searchProfile(GlobalVariables.Facebook_Core_Node, name4);

                    System.out.println("-------------------------------");
                    facebook.removeFriend(profile3, profile4);
                    System.out.println("-------------------------------");

                    break;
                case 4:
                    System.out.println("Please enter your name.");
                    String name5 = input.next();
                    Profile profile5 = facebook.searchProfile(GlobalVariables.Facebook_Core_Node, name5);
                    System.out.println("Please enter your status.");
                    String status = input.next();
                    profile5.setStatus(status);
                    break;
                case 5:
                    System.out.println("Who's friends would you like to see?");
                    String friends_name = input.next();
                    Profile friends_profile = facebook.searchProfile(GlobalVariables.Facebook_Core_Node, friends_name);
                    friends_profile.printFriends();
                case 6:
                    System.out.println("Please enter the name of the friend you would like to search for.");
                    String name6 = input.next();
                    Profile profile6 = facebook.searchProfile(GlobalVariables.Facebook_Core_Node, name6);
                    profile6.printProfile();
                    break;
                case 7:
                    System.out.println("Please enter your name.");
                    String name7 = input.next();
                    Profile profile7 = facebook.searchProfile(GlobalVariables.Facebook_Core_Node, name7);
                    facebook.leaveNetwork(profile7);
                    System.out.println("Your account has been deleted.");
                    break;
                default:
                    System.out.println("Please enter a valid number.");
                    break;
            }
            System.out.println("Welcome to Facebook. What would you like to do?");
            System.out.println("1 Create an account.");
            System.out.println("2 Add friends.");
            System.out.println("3 Delete Friends.");
            System.out.println("4 Update Status.");
            System.out.println("5 See my friends' friends.");
            System.out.println("6 Search for a friend's profile.");
            System.out.println("7 Delete my account.");
            System.out.println("8 Logout.");
            System.out.println("Please enter your choice:");
            while (!input.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                input.next();
            }
            choice = input.nextInt();
        }
        System.out.println("Thank you for using Facebook.");

    }

} // end social_network class
