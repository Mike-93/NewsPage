package NewsPageApp.models;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String shortDesc;
    private String fullDesc;
    @OneToOne
    private NewsType type;
}
