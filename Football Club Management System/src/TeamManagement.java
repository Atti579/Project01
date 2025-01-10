import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class TeamManagement {
    protected Map<String, ArrayList<Players>> teams;

    public TeamManagement() {
        teams = new HashMap<>();
        initializeTeams();
    }


    protected abstract void initializeTeams();

    public ArrayList<Players> login(String username, String password) {
        if (isValidLogin(username, password)) {
            return teams.get(username);
        } else {
            System.out.println("Invalid credentials.");
            return null;
        }
    }

    private boolean isValidLogin(String username, String password) {
        Map<String, String> teamCredentials = Map.of(
                "Barcelona", "admin",
                "Real Madrid", "admin",
                "Chelsea", "admin"
        );
        return teamCredentials.containsKey(username) && teamCredentials.get(username).equals(password);
    }

    public void displaySquad(String team) {
        ArrayList<Players> squad = teams.get(team);
        if (squad != null) {
            System.out.println(team + " Squad:");
            for (Players player : squad) {
                System.out.println(player.getName() + " - " + player.getPosition());
            }
        } else {
            System.out.println("Team not found.");
        }
    }
}