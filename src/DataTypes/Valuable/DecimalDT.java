package DataTypes.Valuable;

import DataTypes.GenericDataType;
import supply.TypeName;

public class DecimalDT extends GenericDataType {

    public DecimalDT()
    {
        super(TypeName.DECIMAL, (byte)1, new byte[]{0});
    }

    public DecimalDT(double value)
    {
        super(TypeName.DECIMAL, (byte)1, new byte[]{0});
        this.SetValue(value);
    }


    public int GetValue()
    {
        return 0;
    }

    public void SetValue(double value)
    {

    }
}
