package com.company.Shape;

import com.company.BigNumber;

public class Point {
    private BigNumber x;
    private BigNumber y;

    public Point(BigNumber x, BigNumber y) {
        this.x = x;
        this.y = y;
    }

    BigNumber getX() {
        return x;
    }

    public void setX(BigNumber x) {
        this.x = x;
    }

    BigNumber getY() {
        return y;
    }

    public void setY(BigNumber y) {
        this.y = y;
    }
}
