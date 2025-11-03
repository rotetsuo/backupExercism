public class Twofer {
    public String twofer(String name) {
        boolean someCondition = (name == null || name.isEmpty() || name.trim().isEmpty());
        String result = someCondition ? "One for you, one for me." : "One for " + name + ", one for me.";
        return result;
    }
}
