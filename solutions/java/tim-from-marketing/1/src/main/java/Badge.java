class Badge {
    public String print(Integer id, String name, String department) {
          String departmentLabel = (department == null) ? "OWNER" : department.toUpperCase();

        // Determina a parte do ID e do nome.
        // Se o ID for nulo, a etiqueta começa apenas com o nome.
        // Caso contrário, inclui o ID formatado.
        String idAndNameLabel;
        if (id == null) {
            idAndNameLabel = name;
        } else {
            idAndNameLabel = "[" + id + "] - " + name;
        }

        // Combina as duas partes para formar a etiqueta final.
        return idAndNameLabel + " - " + departmentLabel;
    }
}
