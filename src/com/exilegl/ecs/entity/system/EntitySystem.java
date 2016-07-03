package com.exilegl.ecs.entity.system;

import com.exilegl.ecs.entity.EntityManager;
import com.exilegl.ecs.entity.component.EntityComponent;

/**
 * The job of the entity systems is to perform their logic on entities which have the components the system
 * requires to operate on the entity. For example, a Render system would render entities which have both the Sprite
 * and Position components.
 */
public abstract class EntitySystem {

    /** Used to fetch entities by their ID from their parent manager **/
    private final EntityManager entityManager;

    /**
     * Initiates the system with the provided manager
     */
    public EntitySystem(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    /**
     * Performs the system's logic on the provided entity
     */
    public abstract void perform(int entityId);

    /**
     * Performs the system's rendering on the provided entity
     */
    public abstract void render(int entityId);

    /**
     * @return Whether the provided entity has the components required for the system to perform
     * @param entityId The ID of the entity which is being checked
     */
    public abstract boolean isCompatible(int entityId);

    /**
     * @return Whether the provided entity has a component of the provided type
     */
    public boolean entityHasComponent(int entityId, Class<?extends EntityComponent> componentType){
        for(EntityComponent component : this.getEntityManager().getEntity(entityId)){
            if(component.getClass() == componentType){
                return true;
            }
        }

        return false;
    }

    /**
     * @return {@link EntitySystem#entityManager}
     */
    public EntityManager getEntityManager(){
        return this.entityManager;
    }

    /**
     * @return Component of the provided type from the provided entity
     * @throws IndexOutOfBoundsException Invalid entity
     */
    public EntityComponent getComponentFromEntity(int entityId, Class<?extends EntityComponent> componentType) throws IndexOutOfBoundsException {
        for (EntityComponent component : this.getEntityManager().getEntities().get(entityId)) {
            if (component.getAssignedEntityId() == entityId && component.getClass() == componentType) {
                return component;
            }
        }
        return null;
    }

}
