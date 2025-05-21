package model;

public class TarotCard {
    private final String name;
    private final String uprightMeaning;
    private final String reversedMeaning;
    private final String imagePath;
    private boolean isReversed;

    public TarotCard(String name, String uprightMeaning, String reversedMeaning, String imagePath) {
        this.name = name;
        this.uprightMeaning = uprightMeaning;
        this.reversedMeaning = reversedMeaning;
        this.imagePath = imagePath;
        this.isReversed = false; // Default: card starts upright
    }

    // Getters and setters
    public String getName() { return name; }
    public String getMeaning() { return isReversed ? reversedMeaning : uprightMeaning; }
    public String getImagePath() { return imagePath; }
    public boolean isReversed() { return isReversed; }
    public void setReversed(boolean reversed) { isReversed = reversed; }
}