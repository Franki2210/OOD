package com.company;

import java.util.List;
import java.util.Vector;

public class BigNumber {
    private List<Integer> value;
    private boolean isNegative;

    public BigNumber(String value) {
        this.value = new Vector<>();
        setValue(value);
    }

    public BigNumber(List<Integer> value, boolean isNegative) {
        this.value = value;
        this.isNegative = isNegative;
    }
    public BigNumber(List<Integer> value) {
        this.value = value;
        this.isNegative = false;
    }
    public BigNumber(int value) {
        String valueString = Integer.toString(value);
        this.value = new Vector<>();
        int i = 0;

        if (valueString.charAt(0) == '-') {
            this.isNegative = true;
            ++i;
        }
        else this.isNegative = false;

        for (; i < valueString.length(); ++i) {
            this.value.add((int)(valueString.charAt(i) - 48));
        }
    }

    public void addDigit(int digit) {
        value.add(digit);
    }

    public int getDigit(int index) {
        return value.get(index);
    }

    public BigNumber() {
        this.value = new Vector<>();
        this.isNegative = false;
    }

    public void setValue(String value) {
        if (value.charAt(0) == '-') {
            isNegative = true;
            value = value.substring(1);
        }
        this.value = stringToVectorInt(value);
    }

    public List<Integer> get() {
        return value;
    }

    public String getAsString() {
        String result = "";
        if (isNegative) result += "-";
        for (int digit :
                value) {
            result += digit;
        }
        return result;
    }

    public int getAmount() {
        return value.size();
    }

    public boolean isNegative() {
        return isNegative;
    }

    public void setNegative(boolean negative) {
        isNegative = negative;
    }

    private Vector<Integer> stringToVectorInt(String value) {
        Vector<Integer> result = new Vector<>();
        for (int i = 0; i < value.length(); ++i) {
            int digit = Character.getNumericValue(value.charAt(i));
            result.add(digit);
        }
        return result;
    }


}
