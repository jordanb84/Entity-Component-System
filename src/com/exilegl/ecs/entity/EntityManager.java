package com.exilegl.ecs.entity;

import com.exilegl.ecs.entity.component.EntityComponent;
import com.exilegl.ecs.entity.system.EntitySystem;
import com.exilegl.example.system.SystemMovement;
import com.sun.xml.internal.stream.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to manage a set of entities. Entities are represented as a list of components, and
 * all entities are stored in the manager so they can easily be fetched.
 *
 * The manager applies all applicable systems to the entities, and stores a list of systems which should
 * be applied to compatible entities.
 */
public class EntityManager {

    /** The list of systems which will be applied to compatible entities in the manager **/
    private List<EntitySystem> entitySystems = new ArrayList<EntitySystem>();

    /** The list of all entities in the map. Each item represents an entity, which is a list of components **/
    private List<List<EntityComponent>> entities = new ArrayList<List<EntityComponent>>();

    /**
     * Performs logic of all applicable systems to all entities
     */
    public void perform(){
        for(EntitySystem system : this.entitySystems){
            for(int entityIndex = 0; entityIndex < this.entities.size(); entityIndex++){
                if(system.isCompatible(entityIndex)){
                    system.perform(entityIndex);
                }
            }
        }
    }

    /**
     * Performs render logic of all applicable systems to all entities
     */
    public void render(){
        for(EntitySystem system : this.entitySystems){
            for(int entityIndex = 0; entityIndex < this.entities.size(); entityIndex++){
                if(system.isCompatible(entityIndex)){
                    system.render(entityIndex);
                }
            }
        }
    }

    /**
     * @return The entity represented by the provided ID. Will be null if there is no entity with that ID
     */
    public List<EntityComponent> getEntity(int entityId){
        return this.entities.get(entityId);
    }

    /**
     * Creates a new entity in the manager based on the provided components by assigning
     * an ID for the entity to each of the components then adding the list of components as a new entity in the manager
     */
    public void addEntity(List<EntityComponent> entityComponents) {
        int entityId = this.nextId();

        for (EntityComponent unassignedComponent : entityComponents) {
            unassignedComponent.setAssignedEntityId(entityId);
        }

        this.entities.add(entityComponents);
    }

    /**
     * @return The next available entity ID
     */
    public int nextId(){
        return this.entities.size();
    }

    /**
     * @return {@link EntityManager#entities}
     */
    public List<List<EntityComponent>> getEntities(){
        return this.entities;
    }

    /**
     * Adds a new {@link EntitySystem} to the manager so it may be
     * applied to all entities in the manager
     */
    public void addSystem(EntitySystem system){
        this.entitySystems.add(system);
    }

}
