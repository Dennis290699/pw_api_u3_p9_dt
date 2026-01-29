package uce.edu.web.api.matricula.aplication.representation;

public class LinkDto {
    public String rel; // Poner nombre a la URL
    public String href;

    public LinkDto() {
    }

    public LinkDto(String rel, String href) {
        this.rel = rel;
        this.href = href;
    }
}
