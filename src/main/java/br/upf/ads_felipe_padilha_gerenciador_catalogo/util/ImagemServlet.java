package br.upf.ads_felipe_padilha_gerenciador_catalogo.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet("/imagens/*")
public class ImagemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getPathInfo();
        if (info == null || info.length() < 2) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        String nome = info.substring(1);
        if (nome.contains("..") || nome.contains("/") || nome.contains("\\")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Path arquivo = ArmazenamentoImagem.pasta().resolve(nome).normalize();
        if (!arquivo.startsWith(ArmazenamentoImagem.pasta()) || !Files.isRegularFile(arquivo)) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        String tipo = URLConnection.guessContentTypeFromName(nome);
        resp.setContentType(tipo == null ? "application/octet-stream" : tipo);
        Files.copy(arquivo, resp.getOutputStream());
    }
}
