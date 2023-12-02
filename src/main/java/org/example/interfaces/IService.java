package org.example.interfaces;

import java.util.ArrayList;

public interface IService<Entity> {
   boolean save(Entity entity);
   ArrayList<Entity> find();
   Entity findById(int id);
   boolean delete(int id);
   boolean update(Entity old, Entity update);
}
