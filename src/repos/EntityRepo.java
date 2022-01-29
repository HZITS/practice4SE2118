package repos;

import java.util.List;

public interface EntityRepo<Entity> {
    Entity get(int id);
    List<Entity> getAll();
}
