package DataTypes.Valuable;

import DataTypes.GenericDataType;
import supply.TypeName;
import supply.ValueLimits;


public class IntegerDT extends GenericDataType {

    public IntegerDT()
    {
        super(TypeName.INTEGER, (byte)2, new byte[]{0, 0});
    }

    public IntegerDT(int value) throws Exception {
        super(TypeName.INTEGER, (byte)2, new byte[]{0, 0});
        this.SetValue(value);
    }

    public int GetValue()
    {
        int retValue = 127;
        boolean isNegative = this._content[0] < 0;
        int halfLen = this._content.length/2;
        int startIndex = halfLen - 1;
        //на каждом шаге: берем частное, умножаем на основание (127), прибавляем остаток
        for (int i = startIndex; i>=0; i--) {
            int v1 = this._content[i];
            int v2 = this._content[i+halfLen];
            retValue = retValue*v1 + v2;
        }
        return retValue;
    }

    public void SetValue(int value) throws Exception {

        int absValue = Math.abs(value);
        if (absValue > ValueLimits.MAX_IntegerDT_VALUE)
            throw new Exception("IntegerDT_overflow: value must be between -" + ValueLimits.MAX_IntegerDT_VALUE + " and "+ ValueLimits.MAX_IntegerDT_VALUE);
        boolean isNegative = value < 0;

        if ((value > 0 && value < ValueLimits.MAX_BYTE_VALUE) || (value < 0 && absValue <= ValueLimits.MAX_BYTE_VALUE + 1))
        {
            this._content[0] = (byte)value;
        }
        else if (absValue > ValueLimits.MAX_BYTE_VALUE)
        {
            int div_val = 0;
            byte len = 0;
            byte[] tmpDivs = new byte[4];
            byte[] tmpMods = new byte[4];
            //считаем на каждом шаге частное и остаток от деления на основание 127
            while (true)
            {
                div_val = absValue / ValueLimits.MAX_BYTE_VALUE;
                tmpMods[len] = (byte)(absValue - div_val* ValueLimits.MAX_BYTE_VALUE);
                if (div_val > ValueLimits.MAX_BYTE_VALUE)
                {
                    tmpDivs[len++] = ValueLimits.MAX_BYTE_VALUE;
                    absValue = div_val;
                }
                else
                {
                    tmpDivs[len++] = (byte)div_val;
                    break;
                }
            }
            //в первой половине _content лежат частные, во второй половине - остатки
            this._length = (byte)(len*2);
            this._content = new byte[this._length];
            for (int i=0; i< len; i++)
            {
                this._content[i] = tmpDivs[i];
                this._content[i+len] = tmpMods[i];
            }
            //для обратного преобразования: для отрицательного значения 1-е частное и 1-й остаток отрицательны
            if (isNegative)
            {
                this._content[0] = (byte)(this._content[0] * (-1));
                this._content[len] = (byte)(this._content[len] * (-1));
            }
        }
    }
}
