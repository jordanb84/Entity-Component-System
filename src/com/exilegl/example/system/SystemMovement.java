package com.exilegl.example.system;


import com.exilegl.ecs.entity.EntityDirection;
import com.exilegl.ecs.entity.EntityManager;
import com.exilegl.ecs.entity.system.EntitySystem;
import com.exilegl.example.component.ComponentPosition;
import com.exilegl.example.component.ComponentVelocity;

/**
 * Moves entities by their velocity if they have a position and velocity.
 *
 * For demonstration
 */
public class SystemMovement extends EntitySystem {

    public SystemMovement(EntityManager manager){
        super(manager);
    }

    @Override
    public void perform(int entityId) {
        ComponentVelocity velocityComponent = ((ComponentVelocity) this.getComponentFromEntity(entityId, ComponentVelocity.class));

        ComponentPosition positionComponent = ((ComponentPosition) this.getComponentFromEntity(entityId, ComponentPosition.class));

        positionComponent.setX(positionComponent.getX() + velocityComponent.getVelocity(EntityDirection.RIGHT));
        positionComponent.setX(positionComponent.getX() - velocityComponent.getVelocity(EntityDirection.LEFT));
        positionComponent.setY(positionComponent.getY() + velocityComponent.getVelocity(EntityDirection.DOWN));
        positionComponent.setY(positionComponent.getY() - velocityComponent.getVelocity(EntityDirection.UP));
    }

    @Override
    public void render(int entityId) {

    }

    @Override
    public boolean isCompatible(int entityId) {
        return this.entityHasComponent(entityId, ComponentPosition.class) && this.entityHasComponent(entityId, ComponentVelocity.class);
    }
}
