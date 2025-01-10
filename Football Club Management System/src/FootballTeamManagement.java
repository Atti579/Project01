import java.util.ArrayList;

public class FootballTeamManagement extends TeamManagement{
    @Override
    protected void initializeTeams() {
        ArrayList<Players> barcelonaSquad = new ArrayList<>();
        barcelonaSquad.add(new Players("Marc-André ter Stegen", 32, "Germany", 1, 60.0, 90, 88));
        barcelonaSquad.add(new Players("Jules Koundé", 25, "France", 23, 50.0, 85, 84));
        barcelonaSquad.add(new Players("Ronald Araújo", 25, "Uruguay", 4, 55.0, 88, 85));
        barcelonaSquad.add(new Players("Andreas Christensen", 28, "Denmark", 15, 40.0, 82, 83));
        barcelonaSquad.add(new Players("Alejandro Balde", 20, "Spain", 12, 45.0, 83, 86));
        barcelonaSquad.add(new Players("Frenkie de Jong", 27, "Netherlands", 21, 70.0, 88, 87));
        barcelonaSquad.add(new Players("Pedri", 21, "Spain", 8, 90.0, 90, 88));
        barcelonaSquad.add(new Players("Gavi", 20, "Spain", 6, 80.0, 89, 87));
        barcelonaSquad.add(new Players("Raphinha", 28, "Brazil", 11, 55.0, 86, 85));
        barcelonaSquad.add(new Players("Robert Lewandowski", 36, "Poland", 9, 45.0, 87, 86));
        barcelonaSquad.add(new Players("Ferran Torres", 24, "Spain", 7, 40.0, 84, 83));

        ArrayList<Players> realMadridSquad = new ArrayList<>();
        realMadridSquad.add(new Players("Thibaut Courtois", 32, "Belgium", 1, 60.0, 90, 87));
        realMadridSquad.add(new Players("Dani Carvajal", 31, "Spain", 2, 45.0, 85, 84));
        realMadridSquad.add(new Players("David Alaba", 31, "Austria", 4, 55.0, 88, 82));
        realMadridSquad.add(new Players("Antonio Rudiger", 31, "Germany", 22, 50.0, 87, 81));
        realMadridSquad.add(new Players("Ferland Mendy", 29, "France", 23, 40.0, 80, 83));
        realMadridSquad.add(new Players("Luka Modric", 38, "Croatia", 10, 30.0, 84, 86));
        realMadridSquad.add(new Players("Toni Kroos", 34, "Germany", 8, 35.0, 85, 85));
        realMadridSquad.add(new Players("Federico Valverde", 25, "Uruguay", 15, 75.0, 88, 89));
        realMadridSquad.add(new Players("Vinicius Jr.", 24, "Brazil", 7, 120.0, 90, 92));
        realMadridSquad.add(new Players("Rodrygo", 23, "Brazil", 11, 80.0, 87, 88));
        realMadridSquad.add(new Players("Joselu", 34, "Spain", 14, 20.0, 75, 80));

        ArrayList<Players> chelseaSquad = new ArrayList<>();
        chelseaSquad.add(new Players("Kepa Arrizabalaga", 29, "Spain", 1, 55.0, 85, 90));
        chelseaSquad.add(new Players("Ben Chilwell", 27, "England", 21, 45.0, 80, 85));
        chelseaSquad.add(new Players("Thiago Silva", 39, "Brazil", 6, 50.0, 88, 75));
        chelseaSquad.add(new Players("Reece James", 24, "England", 24, 70.0, 83, 88));
        chelseaSquad.add(new Players("Enzo Fernandez", 23, "Argentina", 5, 65.0, 84, 90));
        chelseaSquad.add(new Players("Raheem Sterling", 29, "England", 17, 60.0, 81, 86));
        chelseaSquad.add(new Players("Noni Madueke", 22, "England", 11, 40.0, 75, 80));
        chelseaSquad.add(new Players("Nicolas Jackson", 23, "Senegal", 15, 50.0, 79, 85));
        chelseaSquad.add(new Players("Moises Caicedo", 22, "Ecuador", 25, 65.0, 82, 88));
        chelseaSquad.add(new Players("Armando Broja", 22, "Albania", 19, 55.0, 78, 82));
        chelseaSquad.add(new Players("Mykhailo Mudryk", 23, "Ukraine", 10, 60.0, 77, 83));


        teams.put("Barcelona", barcelonaSquad);
        teams.put("Real Madrid", realMadridSquad);
        teams.put("Chelsea", chelseaSquad);
    }
}
