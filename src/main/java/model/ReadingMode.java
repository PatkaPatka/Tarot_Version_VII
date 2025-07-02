package model;


/**
 * Enum, die die verschiedenen in der Anwendung verfügbaren Lesemodi/Spreads darstellt.
 * Jeder Modus definiert drei Positionen mit den entsprechenden Beschriftungen.
 */
public enum ReadingMode {
    past_present_future("Past", "Present", "Future"),
    you_them_relationship("You", "Them", "Relationship"),
    situation_obstacle_solution("Situation", "Obstacle", "Solution"),
    mind_body_spirit("Mind", "Body", "Spirit"),
    pathI_pathII_pathIII("Path I", "Path II", "Path III"),
    accept_embrase_let_go("Accept", "Embrace", "Let Go");

    private final String position1;
    private final String position2;
    private final String position3;

    /**
     * Konstruktor für die Enum, der die Positionen für jeden Lesemodus festlegt.
     *
     * @param position1 Bezeichnung der ersten Position
     * @param position2 Bezeichnung der zweiten Position
     * @param position3 Bezeichnung der dritten Position
     */
    ReadingMode(String position1, String position2, String position3) {
        this.position1 = position1;
        this.position2 = position2;
        this.position3 = position3;
    }

    /**
     * Gibt die Bezeichnungen der Positionen für den Lesemodus zurück.
     *
     * @return Array mit den Bezeichnungen der Positionen
     */
    public String[] getPositions() {
        return new String[]{position1, position2, position3};
    }
}
