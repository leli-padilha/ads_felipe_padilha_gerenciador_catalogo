package br.upf.ads_felipe_padilha_gerenciador_catalogo.view;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Prancha;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class CatalogoBean implements Serializable {

    private List<Prancha> pranchas = new ArrayList<>();
    private Prancha selecionada;

    @PostConstruct
    public void iniciar() {
        pranchas = List.of(
                new Prancha(1L, "Nalu Fish", "Maré", "Fish", "fish",
                        "5'6\"", 32.4, "Twin", "Intermediário",
                        new BigDecimal("3290.00"),
                        "Cauda larga e outline curto, estável na espuma e solta na transição."),
                new Prancha(2L, "Swell Box", "Swell Co.", "Shortboard", "shortboard",
                        "5'11\"", 28.6, "Thruster", "Avançado",
                        new BigDecimal("3890.00"),
                        "Shortboard com rocker médio para ondas de 1 a 2 metros."),
                new Prancha(3L, "Costa Long", "Prainha", "Longboard", "longboard",
                        "9'2\"", 68.0, "Single", "Iniciante",
                        new BigDecimal("4450.00"),
                        "Longboard clássico, com bastante volume para remar e dropar cedo."),
                new Prancha(4L, "Areia Fun", "Dorsal", "Funboard", "funboard",
                        "7'6\"", 48.5, "Thruster", "Iniciante",
                        new BigDecimal("2690.00"),
                        "Funboard intermediário entre a longboard e a shortboard, fácil de remar."),
                new Prancha(5L, "Linha Gun", "Rio Surfboards", "Gun", "gun",
                        "6'8\"", 30.2, "Quad", "Avançado",
                        new BigDecimal("4150.00"),
                        "Bico estreito e cauda pin, pensada para paredes mais rápidas."),
                new Prancha(6L, "Twin Pin", "Nalu", "Fish", "fish",
                        "5'4\"", 31.1, "Twin", "Intermediário",
                        new BigDecimal("3540.00"),
                        "Twin com pin tail, boa velocidade em ondas pequenas e cheias.")
        );
    }

    public void selecionar(Long id) {
        this.selecionada = pranchas.stream()
                .filter(prancha -> prancha.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public String severidade(String nivel) {
        return switch (nivel) {
            case "Iniciante" -> "success";
            case "Intermediário" -> "info";
            default -> "warning";
        };
    }

    public List<Prancha> getPranchas() {
        return pranchas;
    }

    public Prancha getSelecionada() {
        return selecionada;
    }
}
