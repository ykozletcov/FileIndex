package com.company;

import DataTypes.Valuable.IntegerDT;
import DataTypes.Valuable.VarCharDT;
import supply.ValueLimits;

public class Main {

    public static void main(String[] args) {
        VarCharDT vch = new VarCharDT();
        try
        {
            vch.SetValue("hello world!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(vch.GetValue());
        IntegerDT integerDT = new IntegerDT();
        try
        {
            integerDT.SetValue(-262138);
            System.out.println(integerDT.GetValue());
        }
        catch (Exception e) {
            e.printStackTrace();
        }







}
}
