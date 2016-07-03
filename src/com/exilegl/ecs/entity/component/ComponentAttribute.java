package com.exilegl.ecs.entity.component;

/**
 * An attribute of an entity component. Attributes have a name and a value,
 * making it easy to set or get a an attribute of a component by name.
 */
public class ComponentAttribute {

    /** The identifier is used to represent the attribute so it's value may be easily set or acquired **/
    private final String identifier;

    /** The attribute's value is stored as a String for compatibility with all data that may be stored **/
    private String value;

    /**
     * @param identifier {@link ComponentAttribute#identifier}
     * @param value {@link ComponentAttribute#value}
     */
    public ComponentAttribute(String identifier, String value){
        this.identifier = identifier;
        this.value = value;
    }

    /**
     * @return {@link ComponentAttribute#identifier}
     */
    public String getIdentifier(){
        return this.identifier;
    }

    /**
     * @return {@link ComponentAttribute#value}
     */
    public String getValue(){
        return this.value;
    }

    /**
     * @param value {@link ComponentAttribute#value}
     */
    public void setValue(String value){
        this.value = value;
    }

}
