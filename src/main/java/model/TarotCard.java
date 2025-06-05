package model;

public class TarotCard {
    public String name;
    public String description;
    public String description_reversed;
    public String image;
    public boolean isReversed;

    public TarotCard() {isReversed = false;}

    // Getters and setters
    public String getName() { return name; }
    public String getMeaning() {return isReversed ? description_reversed : description; }
    public String getImagePath() { return image; }

    public boolean getReversed(){
        return isReversed;
    }

    public void setReserved(boolean reversed) {
        isReversed = reversed;
    }
}