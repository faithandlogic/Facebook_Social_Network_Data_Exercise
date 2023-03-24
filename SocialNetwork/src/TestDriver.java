public class TestDriver {
    static social_network facebook = new social_network();

    public static void main(String[] args) {
        // join network

        System.out.println("Test Joining network...");

        Profile Fatih = new Profile("Fatih");
        Profile Selma = new Profile("Selma");
        Profile Ismail = new Profile("Ismail");
        Profile Mehmet = new Profile("Mehmet");
        Profile Ali = new Profile("Ali");
        Profile Veli = new Profile("Veli");
        Profile Ayse = new Profile("Ayse");
        Profile Fatma = new Profile("Fatma");

        facebook.joinNetwork(Fatih);
        facebook.joinNetwork(Selma);
        facebook.joinNetwork(Ismail);
        facebook.joinNetwork(Mehmet);
        facebook.joinNetwork(Ali);
        facebook.joinNetwork(Veli);
        facebook.joinNetwork(Ayse);
        facebook.joinNetwork(Fatma);

        System.out.println("Test Search network...");

        // search profile
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Selma").printProfile();

        System.out.println("Test Adding friends...");

        // add friend
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Fatih").addFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Selma"));
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Fatih").addFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ismail"));
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Fatih").addFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Mehmet"));

        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Selma").addFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Fatih"));
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Selma").addFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ismail"));

        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ismail").addFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Fatih"));
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ismail").addFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Selma"));

        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Mehmet").addFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Fatih"));
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Mehmet").addFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ali"));

        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ali").addFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Mehmet"));
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ali").addFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Veli"));

        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Veli").addFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ali"));
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Veli").addFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ayse"));

        // print profiles
        System.out.println();
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Fatih").printProfile();
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Selma").printProfile();
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ismail").printProfile();
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Mehmet").printProfile();
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ali").printProfile();
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Veli").printProfile();
        System.out.println();

        // remove friend
        System.out.println("Test Removing friends...");
        System.out.println();
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Fatih").removeFriend(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Selma"));
        // print fatih profile
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Fatih").printProfile();
        System.out.println("Test Setting status...");

        // set status

        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Fatih").setStatus("I am Busy");
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Selma").setStatus("Online");
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ismail").setStatus("Online");
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Mehmet").setStatus("Offline");

        System.out.println("Test leaving network...");

        // leave network

        facebook.leaveNetwork(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Fatih"));
        facebook.leaveNetwork(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Selma"));

        System.out.println("Test Search network after leaving...");

        // search profile

        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Fatih").printProfile();
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Selma").printProfile();
        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ismail").printProfile();

        System.out.println("Test Printing friends...");

        // print friends

        facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ismail").printFriends();

        System.out.println("Test Printing status...");
        // print status

        System.out.println(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ismail").getStatus());
        System.out.println(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Mehmet").getStatus());
        System.out.println(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ali").getStatus());
        System.out.println(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Veli").getStatus());
        System.out.println(facebook.searchProfile(GlobalVariables.Facebook_Core_Node,
        "Ayse").getStatus());
    }
}
