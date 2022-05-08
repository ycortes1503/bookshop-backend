package dto;

import lombok.Data;

@Data
public class BookDTO {
    private long id;
    private String code;
    private String title;
    private String author;
    private String overview;
    private double price;
}
