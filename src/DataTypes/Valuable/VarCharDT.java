package DataTypes.Valuable;

import DataTypes.GenericDataType;
import supply.TypeName;
import supply.ValueLimits;

import java.util.Date;

public class VarCharDT extends GenericDataType {
    public VarCharDT()
    {
        super(TypeName.VARIABLE_CHAR, (byte)1, new byte[1]);
    }

    public VarCharDT(String value) throws Exception {
        super(TypeName.VARIABLE_CHAR, (byte)1, new byte[1]);
        this.SetValue(value);
    }

    public String GetValue()
    {
        StringBuilder sb = new StringBuilder();
        for (short b: this._content) {
            sb.append((char)b);
        }
        return sb.toString();
    }

    public void SetValue(String value) throws Exception {
        int newLen = value.length();
        if (newLen > 127)
            throw new Exception("VarCharDT_overflow: value's length must be less then " + ValueLimits.MAX_BYTE_VALUE);
        //на данный момент русский не поддерживается
        this._length = (byte)newLen;
        this._content = new byte[this._length];

        for (int i = 0; i < newLen; i++)
            this._content[i] = (byte)value.charAt(i);
    }
}
