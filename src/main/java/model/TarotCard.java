package model;

public class TarotCard {
    public String name;
    public String description;
    public String description_reversed;
    public String image;
    public boolean isReversed;

    /**
     * Stellt eine Tarotkarte mit ihren Eigenschaften dar, einschließlich Name, Beschreibungen, Bildpfad und Umkehrstatus.
     */
    public TarotCard() {isReversed = false;}

    // Getters and setters
    public String getName() { return name; }
    public String getMeaning() {return isReversed ? description_reversed : description; }
    public String getImagePath() { return image; }

    /**
     * checkt ob die Karte umgekehrt ist
     * @return gibt den Status der Karte zurück
     */
    public boolean getReversed(){
        return isReversed;
    }

    /**
     * setzt den Status der Karte auf umgekehrt oder nicht umgekehrt
     */
    public void setReserved(boolean reversed) {
        isReversed = reversed;
    }
}