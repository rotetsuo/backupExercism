public class Twofer {
    public String twofer(String name) {
        if(!(name == null || name.isEmpty() || name.trim().isEmpty())){
            return "One for " + name + ", one for me.";
        }
        return "One for you, one for me.";
    }
}
