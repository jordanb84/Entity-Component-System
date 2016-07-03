package com.exilegl.ecs.entity.component;

import java.util.List;

/**
 * Components are represented by only data. Entities are composed of such components, and
 * systems are able to perform logic on entities based on which components they have. If an entity has the
 * proper components required by a system, the system can modify the entity by modifying and accessing data in the entity's components.
 *
 * Components usually provide functions to set their attributes in a non generic way.
 */
public class EntityComponent {

    /** The attributes of the component **/
    private List<ComponentAttribute> attributes;

    /** The Id of the entity which the component is assigned to **/
    private int assignedEntityId;

    public EntityComponent(List<ComponentAttribute> attributes){
        this.attributes = attributes;
    }

    /**
     * Sets an attribute of the component matching the provided name if such an attribute exists
     */
    public void setAttribute(String attributeName, String value){
        ComponentAttribute matchingAttribute = this.getAttribute(attributeName);

        if(matchingAttribute == null){
            this.attributes.add(new ComponentAttribute(attributeName, value));
        }else{
            matchingAttribute.setValue(value);
        }
    }

    /**
     * @return An attribute by the provided name. Null if such an attribute does not exist.
     */
    public ComponentAttribute getAttribute(String attributeName){
        for(ComponentAttribute attribute : this.attributes){
            if(attribute.identifier == attributeName){
                return attribute;
            }
        }

        return null;
    }

    /**
     * @return {@link EntityComponent#attributes}
     */
    public List<ComponentAttribute> getAttributes(){
        return this.attributes;
    }

    /**
     * @return {@link EntityComponent#assignedEntityId}
     */
    public int getAssignedEntityId(){
        return this.assignedEntityId;
    }

    /** Sets {@link EntityComponent#assignedEntityId} **/
    public void setAssignedEntityId(int entityId){
        this.assignedEntityId = entityId;
    }

}
