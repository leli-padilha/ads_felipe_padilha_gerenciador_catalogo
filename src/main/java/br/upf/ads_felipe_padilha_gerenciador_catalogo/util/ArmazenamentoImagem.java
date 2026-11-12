package br.upf.ads_felipe_padilha_gerenciador_catalogo.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.primefaces.model.file.UploadedFile;

public final class ArmazenamentoImagem {

    private ArmazenamentoImagem() {
    }

    public static Path pasta() {
        return Path.of(System.getProperty("user.home"), "catalogo-imagens");
    }

    public static String salvar(UploadedFile file) throws IOException {
        String original = file.getFileName() == null ? "imagem" : Path.of(file.getFileName()).getFileName().toString();
        String limpo = original.replaceAll("[^a-zA-Z0-9._-]", "_");
        if (limpo.isBlank() || ".".equals(limpo) || "..".equals(limpo)) {
            limpo = "imagem";
        }
        String nome = System.currentTimeMillis() + "_" + limpo;
        Files.createDirectories(pasta());
        try (InputStream in = file.getInputStream()) {
            Files.copy(in, pasta().resolve(nome), StandardCopyOption.REPLACE_EXISTING);
        }
        return nome;
    }
}
