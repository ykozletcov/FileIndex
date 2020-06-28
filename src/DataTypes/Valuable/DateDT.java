package DataTypes.Valuable;

import DataTypes.GenericDataType;
import supply.TypeName;

import java.util.Date;

public class DateDT extends GenericDataType {
    public DateDT()
    {
        super(TypeName.DATETIME, (byte)8, new byte[8]);
    }

    public DateDT(Date value)
    {
        super(TypeName.DATETIME, (byte)8, new byte[8]);
        this.SetValue(value);
    }

    public int GetValue()
    {
        return 0;
    }

    public void SetValue(Date value)
    {

    }
}
