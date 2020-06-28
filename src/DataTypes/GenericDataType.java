package DataTypes;

import supply.TypeName;

import javax.swing.*;


public class GenericDataType {
    //длина, занимаемая данными
    protected byte _length;
    //числовой код типа данных
    protected byte _typeCode;
    //данные
    protected byte[] _content;


    protected GenericDataType(TypeName typeName, byte length, byte[] content)
    {
        this._typeCode = (byte)ConvertNameToCode(typeName);
        this._content = content;
        this._length = length;
    }



    private int ConvertNameToCode(TypeName typeName)
    {
        return typeName == TypeName.INTEGER ? 1 :
                        typeName == TypeName.DECIMAL ? 2 :
                                typeName == TypeName.DATETIME ? 3 :
                                        typeName == TypeName.VARIABLE_CHAR ? 4 : 0;
    }
}


