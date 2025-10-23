public class GameMaster {

    // TODO: define a 'describe' method that returns a description of a Character
    public String describe(Character character){
        return "You're a level " + character.getLevel() + " " + character.getCharacterClass() + " with " + character.getHitPoints() + " hit points.";
    }

    // TODO: define a 'describe' method that returns a description of a Destination
    public String describe(Destination destination){
        return "You've arrived at " + destination.getName() + ", which has " + destination.getInhabitants() + " inhabitants.";
    }
    
    // TODO: define a 'describe' method that returns a description of a TravelMethod
    public String describe(TravelMethod travelMethod) {
        switch (travelMethod) {
            case WALKING:
                return "You're traveling to your destination by walking.";
            case HORSEBACK:
                return "You're traveling to your destination on horseback.";
            default:
                // Este caso não deve acontecer com um enum, mas é uma boa prática.
                return "Unknown travel method.";
        }
    }
    // TODO: define a 'describe' method that returns a description of a Character, Destination and TravelMethod
    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        String characterDescription = describe(character);
        String travelDescription = describe(travelMethod);
        String destinationDescription = describe(destination);

        return characterDescription + " " + travelDescription + " " + destinationDescription;
    }
 

    // TODO: define a 'describe' method that returns a description of a Character and Destination
    public String describe(Character character, Destination destination) {
        String characterDescription = describe(character);
        String travelDescription = describe(TravelMethod.WALKING);
        String destinationDescription = describe(destination);

        return characterDescription + " " + travelDescription + " " + destinationDescription;
    }
}
