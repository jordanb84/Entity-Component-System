package com.exilegl.example.component;


import com.exilegl.ecs.entity.component.ComponentAttribute;
import com.exilegl.ecs.entity.component.EntityComponent;

import java.util.List;

/**
 * Stores a position for an entity
 *
 * For demonstration
 */
public class ComponentPosition extends EntityComponent{

    public ComponentPosition(List<ComponentAttribute> attributes){
        super(attributes);
    }

    /**
     * @return The y position of the component
     */
    public float getY(){
        try {
            return Float.parseFloat(this.getAttribute("Y").getValue());
        }catch(NullPointerException attributeNotSet){
            return 0;
        }
    }

    /**
     * @return The x position of the component
     */
    public float getX(){
        try {
            return Float.parseFloat(this.getAttribute("X").getValue());
        }catch(NullPointerException attributeNotSet){
            return 0;
        }
    }

    /**
     * Sets the X position of the component
     */
    public void setX(float x){
        this.setAttribute("X", Float.toString(x));
    }

    /**
     * Sets the Y position of the component
     */
    public void setY(float y){
        this.setAttribute("Y", Float.toString(y));
    }

    /**
     * Sets the position for the component
     */
    public void setPosition(float x, float y){
        this.setAttribute("X", Float.toString(x));
        this.setAttribute("Y", Float.toString(y));
    }

}
