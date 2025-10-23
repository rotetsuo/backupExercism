import java.util.*;

class RelativeDistance {

    // Um grafo (usando uma lista de adjacência) para armazenar as conexões.
    // A chave é o nome de uma pessoa, e o valor é uma lista de suas conexões diretas.
    private final Map<String, List<String>> graph = new HashMap<>();

    /**
     * O construtor recebe a árvore genealógica e a transforma em um grafo bidirecional
     * para facilitar a busca pela distância.
     * @param familyTree Um mapa onde a chave é um pai/mãe e o valor é uma lista de seus filhos.
     */
    RelativeDistance(Map<String, List<String>> familyTree) {
        for (Map.Entry<String, List<String>> entry : familyTree.entrySet()) {
            String parent = entry.getKey();
            List<String> children = entry.getValue();

            // Adiciona a conexão nos dois sentidos (pai -> filho e filho -> pai)
            for (String child : children) {
                graph.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
                graph.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
            }

            // Adiciona conexões diretas entre irmãos
            if (children.size() > 1) {
                for (int i = 0; i < children.size(); i++) {
                    for (int j = i + 1; j < children.size(); j++) {
                        String sibling1 = children.get(i);
                        String sibling2 = children.get(j);
                        graph.computeIfAbsent(sibling1, k -> new ArrayList<>()).add(sibling2);
                        graph.computeIfAbsent(sibling2, k -> new ArrayList<>()).add(sibling1);
                    }
                }
            }
        }
    }

    /**
     * Calcula o grau de separação entre duas pessoas usando Busca em Largura (BFS).
     * @param personA O nome da primeira pessoa.
     * @param personB O nome da segunda pessoa.
     * @return O menor número de conexões entre as duas pessoas, ou -1 se não houver conexão.
     */
    int degreeOfSeparation(String personA, String personB) {
        // Verifica se as pessoas existem no nosso grafo.
        if (!graph.containsKey(personA) || !graph.containsKey(personB)) {
            return -1; // Representa "nenhuma relação conhecida".
        }

        // O grau de separação de uma pessoa para ela mesma é 0.
        if (personA.equals(personB)) {
            return 0;
        }

        // Fila para o algoritmo BFS, armazena as pessoas a serem visitadas.
        Queue<String> queue = new LinkedList<>();
        // Mapa para armazenar a distância da pessoa inicial até cada pessoa visitada.
        Map<String, Integer> distances = new HashMap<>();

        // Inicia o BFS a partir da primeira pessoa.
        queue.add(personA);
        distances.put(personA, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentDistance = distances.get(current);

            // Se encontrarmos a segunda pessoa, retornamos sua distância.
            if (current.equals(personB)) {
                return currentDistance;
            }

            // Itera sobre todos os vizinhos (conexões diretas) da pessoa atual.
            List<String> neighbors = graph.getOrDefault(current, Collections.emptyList());
            for (String neighbor : neighbors) {
                // Se o vizinho ainda não foi visitado (não está no mapa de distâncias)...
                if (!distances.containsKey(neighbor)) {
                    // ...adiciona à fila para visitar e registra sua distância.
                    queue.add(neighbor);
                    distances.put(neighbor, currentDistance + 1);
                }
            }
        }

        // Se a fila esvaziar e não encontrarmos a pessoa, não há conexão.
        return -1;
    }
}