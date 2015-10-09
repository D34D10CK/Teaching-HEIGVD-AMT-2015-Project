package modele.entities;

import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Application extends AbstractEntity<Long> {

    @Column(nullable = false, unique = true)
    private String apiKey;

    @NotNull
    @ManyToOne
    private User user;

    public Application() {
        char[] chars = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        
        for (int i = 0; i < 20; i++) {
            builder.append(chars[random.nextInt(chars.length)]);
        }       
        apiKey = builder.toString(); //FIXME: check for uniqueness
    }

    public Application(User user) {
        this.user = user;
    }
}
