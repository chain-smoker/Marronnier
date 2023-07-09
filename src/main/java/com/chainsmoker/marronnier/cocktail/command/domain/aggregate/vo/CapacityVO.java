package com.chainsmoker.marronnier.cocktail.command.domain.aggregate.vo;

public class CapacityVO {

    private String capacity;
    public CapacityVO() {}

    public CapacityVO(String capacity) {
        // 구현 온즈로 입력받았을 때 ml로 변환하여 출력
        this.capacity = capacity+"ml";
    }
    public String getCapacity() {
        return capacity;
    }
}
