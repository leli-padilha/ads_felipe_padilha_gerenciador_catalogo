package br.upf.ads_felipe_padilha_gerenciador_catalogo.view;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class GuestPreferences implements Serializable {

    private String layoutMode = "layout-slim";
    private String menuColor = "light";
    private String inputStyle = "outlined";
    private String theme = "cyan-deeporange";
    private final List<Theme> themes;

    public GuestPreferences() {
        themes = new ArrayList<>();
        themes.add(new Theme("Blue Grey", "blue-grey", "#607D8B"));
        themes.add(new Theme("Blue Orange", "blue-orange", "#1976D2"));
        themes.add(new Theme("Cyan Deep Orange", "cyan-deeporange", "#00ACC1"));
        themes.add(new Theme("Dark Pink Cyan", "darkpink-cyan", "#AD1457"));
        themes.add(new Theme("Deep Purple Teal", "deeppurple-teal", "#5E35B1"));
        themes.add(new Theme("Green Orange", "green-orange", "#43A047"));
        themes.add(new Theme("Green Pink", "green-pink", "#7CB342"));
        themes.add(new Theme("Green Purple", "green-purple", "#2E7D32"));
        themes.add(new Theme("Indigo Purple", "indigo-purple", "#3949AB"));
        themes.add(new Theme("Indigo Yellow", "indigo-yellow", "#303F9F"));
        themes.add(new Theme("Orange Cyan", "orange-cyan", "#FB8C00"));
        themes.add(new Theme("Orange Indigo", "orange-indigo", "#F57C00"));
        themes.add(new Theme("Pink Cyan", "pink-cyan", "#D81B60"));
        themes.add(new Theme("Pink Teal", "pink-teal", "#EC407A"));
        themes.add(new Theme("Teal Yellow", "teal-yellow", "#00897B"));
    }

    public String getLayoutMode() {
        return layoutMode;
    }

    public void setLayoutMode(String layoutMode) {
        this.layoutMode = layoutMode;
    }

    public String getMenuColor() {
        return menuColor;
    }

    public void setMenuColor(String menuColor) {
        this.menuColor = menuColor;
    }

    public String getInputStyle() {
        return inputStyle;
    }

    public void setInputStyle(String inputStyle) {
        this.inputStyle = inputStyle;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public static class Theme implements Serializable {

        private final String name;
        private final String file;
        private final String color;

        public Theme(String name, String file, String color) {
            this.name = name;
            this.file = file;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public String getFile() {
            return file;
        }

        public String getColor() {
            return color;
        }
    }
}
