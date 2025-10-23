import java.util.List;
import java.util.Set;
import java.util.HashSet;

class GottaSnatchEmAll {

     public static Set<String> newCollection(List<String> cards) {
        // O construtor do HashSet aceita uma coleção e automaticamente
        // lida com a remoção de elementos duplicados.
        return new HashSet<>(cards);
    }

    /**
     * Adiciona uma carta a uma coleção existente.
     *
     * @param card       A nova carta a ser adicionada.
     * @param collection A coleção de cartas existente.
     * @return true se a carta foi adicionada (não estava presente), false caso contrário.
     */
    public static boolean addCard(String card, Set<String> collection) {
        // O método add() da interface Set já retorna um booleano
        // indicando se o conjunto foi modificado como resultado da chamada.
        return collection.add(card);
    }

    public static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        // A forma mais eficiente de verificar isso é ver se um conjunto NÃO é um subconjunto do outro.

        // Condição 1: Eu tenho uma carta que eles não têm?
        // Isso é verdade se a coleção deles NÃO contém todas as minhas cartas.
        boolean iHaveUniqueCard = !theirCollection.containsAll(myCollection);

        // Condição 2: Eles têm uma carta que eu não tenho?
        // Isso é verdade se a minha coleção NÃO contém todas as cartas deles.
        boolean theyHaveUniqueCard = !myCollection.containsAll(theirCollection);

        // A troca só pode acontecer se AMBAS as condições forem verdadeiras.
        return iHaveUniqueCard && theyHaveUniqueCard;
    }

    /**
     * Encontra as cartas que são comuns a todas as coleções fornecidas.
     *
     * @param collections Uma lista de coleções de cartas.
     * @return Um conjunto contendo apenas as cartas presentes em todas as coleções.
     */
    public static Set<String> commonCards(List<Set<String>> collections) {
        // Se a lista de coleções estiver vazia, não há cartas comuns.
        if (collections == null || collections.isEmpty()) {
            return new HashSet<>();
        }

        // Começamos com uma cópia da primeira coleção como nosso conjunto de candidatos.
        // É importante criar uma cópia para não modificar a coleção original.
        Set<String> commonCards = new HashSet<>(collections.get(0));

        // Iteramos sobre o resto das coleções.
        for (int i = 1; i < collections.size(); i++) {
            // O método retainAll() modifica o conjunto 'commonCards' para que ele
            // contenha apenas os elementos que também estão na coleção atual.
            // Isso efetivamente calcula a interseção.
            commonCards.retainAll(collections.get(i));
        }

        return commonCards;
    }

    /**
     * Reúne todas as cartas distintas de uma lista de coleções em um único conjunto.
     *
     * @param collections Uma lista de coleções de cartas.
     * @return Um conjunto contendo todas as cartas únicas de todas as coleções combinadas.
     */
    public static Set<String> allCards(List<Set<String>> collections) {
        // Cria um novo HashSet que irá armazenar todas as cartas únicas.
        Set<String> allCards = new HashSet<>();

        // Itera sobre cada coleção na lista de coleções.
        for (Set<String> collection : collections) {
            // O método addAll() adiciona todos os elementos da coleção atual
            // ao conjunto 'allCards'. Como é um Set, duplicatas são ignoradas automaticamente.
            allCards.addAll(collection);
        }

        return allCards;
    }
}
