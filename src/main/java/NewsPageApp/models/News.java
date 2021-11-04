package NewsPageApp.models;

import lombok.Data;


@Data
public class News {

    private int id;
    private String shortDesc;
    private String fullDesc;
    private NewsType type;
}
