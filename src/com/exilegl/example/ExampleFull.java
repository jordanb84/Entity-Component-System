package com.exilegl.example;

import com.exilegl.ecs.entity.EntityDirection;
import com.exilegl.ecs.entity.EntityManager;
import com.exilegl.ecs.entity.component.ComponentAttribute;
import com.exilegl.ecs.entity.component.EntityComponent;
import com.exilegl.example.component.ComponentPosition;
import com.exilegl.example.component.ComponentVelocity;
import com.exilegl.example.system.SystemMovement;

import java.util.ArrayList;
import java.util.List;

/**
 * Full runnable example for the usage of the entity component system implementation
 */
public class ExampleFull {

    /** For all entities used in the example **/
    private static EntityManager entityManager;

    public static void main(String[] args){
        entityManager = new EntityManager();
        addEntity();
        addSystems();

        for(int framesTested = 0; framesTested < 10; framesTested++) {
            entityManager.perform();
            entityManager.render();

            printEntityData();
        }
    }

    /**
     * Demonstrates registering new systems in the entity manager so they
     * may be applied to entities
     */
    private static void addSystems(){
        entityManager.addSystem(new SystemMovement(entityManager));
    }

    /**
     * Demonstrates creating an entity and adding it to the manager
     */
    private static void addEntity(){
        List<EntityComponent> testEntity = new ArrayList<EntityComponent>();

        ComponentPosition testEntityPosition = new ComponentPosition(new ArrayList<ComponentAttribute>());
        testEntityPosition.setPosition(100, 223);
        testEntity.add(testEntityPosition);

        ComponentVelocity testEntityVelocity = new ComponentVelocity(new ArrayList<ComponentAttribute>());
        testEntityVelocity.setVelocity(3, EntityDirection.DOWN);
        testEntity.add(testEntityVelocity);

        entityManager.addEntity(testEntity);
    }

    /**
     * Prints the values of each component from each entity for demonstration
     */
    private static void printEntityData(){
        System.out.println("Printing entity data");
        for(List<EntityComponent> entity : entityManager.getEntities()){
            for(EntityComponent component : entity){
                String componentData = (component.getClass().getSimpleName() + ", from entity ID " + component.getAssignedEntityId() + ". Attributes (total: " + component.getAttributes().size() + "): ");
                for(ComponentAttribute attribute : component.getAttributes()){
                    componentData += (attribute.getIdentifier() + " " + attribute.getValue() + ", ");
                }
                System.out.println(componentData);
            }
        }
    }

}
