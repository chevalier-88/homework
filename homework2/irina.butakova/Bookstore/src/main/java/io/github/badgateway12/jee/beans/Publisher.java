package io.github.badgateway12.jee.beans;

public enum Publisher {
    PUBLISHER_A {
        @Override
        public String toString() {
            return "Publisher_A";
        }
    },
    PUBLISHER_B {
        @Override
        public String toString() {
            return "Publisher_B";
        }
    }
}
