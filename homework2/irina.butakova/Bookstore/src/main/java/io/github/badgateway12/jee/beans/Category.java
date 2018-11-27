package io.github.badgateway12.jee.beans;

public enum Category {
    Fantasy {
        @Override
        public String toString() {
            return "fantasy";
        }
    },
    Programming {
        @Override
        public String toString() {
            return "programming";
        }
    },
    Tales {
        @Override
        public String toString() {
            return "tales";
        }
    },
    Unknown {
        @Override
        public String toString() {
            return "unknown";
        }
    }
}

