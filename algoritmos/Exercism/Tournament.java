import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Tournament {

    private HashMap<String, TeamStatus> teamsStatistics = new HashMap<>();

    class TeamStatus {

        private String nameTeam;
        private int games = 0;
        private int winners = 0;
        private int draws = 0;
        private int losses = 0;
        private int points = 0;

        public TeamStatus(String nameTeam) {
            this.nameTeam = nameTeam;
        }

        public int getGames() {
            return games;
        }

        public void setGames(int games) {
            this.games = games;
        }

        public int getWinners() {
            return winners;
        }

        public void setWinners(int winners) {
            this.winners = winners;
        }

        public int getDraws() {
            return draws;
        }

        public void setDraws(int draws) {
            this.draws = draws;
        }

        public int getLosses() {
            return losses;
        }

        public void setLosses(int losses) {
            this.losses = losses;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }
    }

    String printTable() {

        List<TeamStatus> teams = new ArrayList<>(teamsStatistics.values());

        teams.sort((team1, team2) -> {
            if (team1.points != team2.points) {
                return Integer.compare(team2.points, team1.points);
            }

            return team1.nameTeam.compareTo(team2.nameTeam);
        });

        StringBuilder table = new StringBuilder();

        table.append(String.format(
                "%-30s | %2s | %2s | %2s | %2s | %2s%n",
                "Team", "MP", "W", "D", "L", "P"
        ));

        for (TeamStatus team : teams) {
            table.append(String.format(
                    "%-30s | %2d | %2d | %2d | %2d | %2d%n",
                    team.nameTeam,
                    team.games,
                    team.winners,
                    team.draws,
                    team.losses,
                    team.points
            ));
        }

        return table.toString();
    }

    void applyResults(String resultString) {

        String[] matches = resultString.split("\n");

        for (int i = 0; i < matches.length; i++) {

            String[] stringSplitter = matches[i].split(";");

            TeamStatus teamStatus = teamsStatistics.get(stringSplitter[0]);

            if (teamStatus == null) {
                teamStatus = new TeamStatus(stringSplitter[0]);
                teamsStatistics.put(stringSplitter[0], teamStatus);
            }

            TeamStatus teamStatus1 = teamsStatistics.get(stringSplitter[1]);

            if (teamStatus1 == null) {
                teamStatus1 = new TeamStatus(stringSplitter[1]);
                teamsStatistics.put(stringSplitter[1], teamStatus1);
            }

            teamStatus.setGames(teamStatus.getGames() + 1);
            teamStatus1.setGames(teamStatus1.getGames() + 1);

            if (stringSplitter[2].equals("win")) {

                teamStatus.setWinners(teamStatus.getWinners() + 1);
                teamStatus1.setLosses(teamStatus1.getLosses() + 1);

                teamStatus.setPoints(teamStatus.getPoints() + 3);

            } else if (stringSplitter[2].equals("loss")) {

                teamStatus1.setWinners(teamStatus1.getWinners() + 1);
                teamStatus.setLosses(teamStatus.getLosses() + 1);

                teamStatus1.setPoints(teamStatus1.getPoints() + 3);

            } else if (stringSplitter[2].equals("draw")) {

                teamStatus.setDraws(teamStatus.getDraws() + 1);
                teamStatus1.setDraws(teamStatus1.getDraws() + 1);

                teamStatus.setPoints(teamStatus.getPoints() + 1);
                teamStatus1.setPoints(teamStatus1.getPoints() + 1);
            }
        }
    }
}
/*
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Tournament {

    private final Map<String, TeamStats> teams = new HashMap<>();

    void applyResults(String resultString) {

        for (String match : resultString.split("\n")) {

            String[] data = match.split(";");

            TeamStats home = getOrCreate(data[0]);
            TeamStats away = getOrCreate(data[1]);

            home.played();
            away.played();

            switch (data[2]) {
                case "win" -> {
                    home.win();
                    away.loss();
                }
                case "loss" -> {
                    home.loss();
                    away.win();
                }
                case "draw" -> {
                    home.draw();
                    away.draw();
                }
            }
        }
    }

    String printTable() {

        List<TeamStats> orderedTeams = new ArrayList<>(teams.values());

        orderedTeams.sort(
                Comparator
                        .comparingInt(TeamStats::points).reversed()
                        .thenComparing(TeamStats::name)
        );

        StringBuilder result = new StringBuilder();

        result.append(
                String.format(
                        "%-30s | %2s | %2s | %2s | %2s | %2s%n",
                        "Team", "MP", "W", "D", "L", "P"
                )
        );

        for (TeamStats team : orderedTeams) {
            result.append(
                    String.format(
                            "%-30s | %2d | %2d | %2d | %2d | %2d%n",
                            team.name(),
                            team.played(),
                            team.wins(),
                            team.draws(),
                            team.losses(),
                            team.points()
                    )
            );
        }

        return result.toString();
    }

    private TeamStats getOrCreate(String name) {
        return teams.computeIfAbsent(name, TeamStats::new);
    }

    static class TeamStats {

        private final String name;
        private int played;
        private int wins;
        private int draws;
        private int losses;
        private int points;

        TeamStats(String name) {
            this.name = name;
        }

        void played() {
            played++;
        }

        void win() {
            wins++;
            points += 3;
        }

        void draw() {
            draws++;
            points++;
        }

        void loss() {
            losses++;
        }

        String name() {
            return name;
        }

        int played() {
            return played;
        }

        int wins() {
            return wins;
        }

        int draws() {
            return draws;
        }

        int losses() {
            return losses;
        }

        int points() {
            return points;
        }
    }
}
*/
