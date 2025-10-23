import java.util.Map;
import java.util.HashMap;

public class DialingCodes {

    private Map<Integer, String> dialingCodes;

    public DialingCodes() {
        this.dialingCodes = new HashMap<>();
    }

    public Map<Integer, String> getCodes() {
        return this.dialingCodes;
    }

    public void setDialingCode(Integer code, String country) {
        this.dialingCodes.put(code, country);
    }

    public String getCountry(Integer code) {
        return this.dialingCodes.get(code);
    }

    /**
     * CORREÇÃO: Este método agora só adiciona um novo código se a chave
     * (o código) ainda não existir no mapa.
     */
     public void addNewDialingCode(Integer code, String country) {
        // A condição verifica se a chave NÃO existe E se o valor NÃO existe.
        if (!this.dialingCodes.containsKey(code) && !this.dialingCodes.containsValue(country)) {
            this.dialingCodes.put(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        // Itera sobre cada par chave-valor no mapa.
        for (Map.Entry<Integer, String> entry : this.dialingCodes.entrySet()) {
            // Verifica se o valor da entrada (o país) corresponde ao alvo.
            if (entry.getValue().equals(country)) {
                // Se corresponder, retorna a chave (o código de discagem).
                return entry.getKey();
            }
        }
        // Se o loop terminar sem encontrar uma correspondência, retorna null.
        return null;
    }

    public void updateCountryDialingCode(Integer newCode, String country) {
        // Primeiro, encontra o código de discagem antigo para o país.
        Integer oldCode = findDialingCode(country);

        // Prossegue apenas se o país foi realmente encontrado.
        if (oldCode != null) {
            // Remove a entrada antiga e adiciona a nova.
            this.dialingCodes.remove(oldCode);
            this.dialingCodes.put(newCode, country);
        }
    }
}