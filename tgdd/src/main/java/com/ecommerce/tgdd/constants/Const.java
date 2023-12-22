package com.ecommerce.tgdd.constants;

import lombok.Getter;

public class Const {
    public enum SEX {
        MALE(1, "Nam"),
        FEMALE(2, "Nữ");
        @Getter
        private int type;
        @Getter
        private String value;
        SEX(int type, String value){
            this.type = type;
            this.value = value;
        }
        public static String findValue(int type){
            for (SEX item : SEX.values()) {
                if (item.type == type) return item.value;
            }
            return "Không rõ giới tính";
        }
    }
}
