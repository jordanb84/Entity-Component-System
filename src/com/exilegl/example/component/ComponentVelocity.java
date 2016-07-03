package com.exilegl.example.component;

import com.exilegl.ecs.entity.EntityDirection;
import com.exilegl.ecs.entity.component.ComponentAttribute;
import com.exilegl.ecs.entity.component.EntityComponent;

import java.util.List;

/**
 * Stores the velocity for each direction of an entity
 *
 * For demonstration
 */
public class ComponentVelocity extends EntityComponent {

    public ComponentVelocity(List<ComponentAttribute> attributes){
        super(attributes);
    }

    /**
     * Sets the velocity of the provided direction
     */
    public void setVelocity(float velocity, EntityDirection direction){
        this.setAttribute(direction.name(), "" + velocity);
    }

    /**
     * @return The velocity for the provided direction
     */
    public float getVelocity(EntityDirection direction){
        try {
            return Float.parseFloat(this.getAttribute(direction.name()).getValue());
        }catch(NullPointerException attributeNotSet){
            return 0;
        }
    }

}
