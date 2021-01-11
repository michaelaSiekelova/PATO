package cz.upol.pato.ejb.utils;

public class Enums {

    public enum Priority {
        Low;

    }

    public enum MetaAttrType{
        STRING,
        NUMBER,
        LONG_NUMBER,
        ENUM,
        NUMBER_WITH_DECIMAL;

        public static MetaAttrType getMetaAttributeType(String type){
            for (MetaAttrType enumType: MetaAttrType.values()
                 ) {
                if (enumType.equals(type)) return enumType;
            }
            return null;
        }
    }
}
