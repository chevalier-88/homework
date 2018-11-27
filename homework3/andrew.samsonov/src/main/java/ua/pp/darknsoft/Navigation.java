package ua.pp.darknsoft;

import ua.pp.darknsoft.anotation.Localize;

import java.util.Objects;

public class Navigation {
    @Localize(key = "navigation.item.string001")
    private String string01;
    @Localize(key = "navigation.item.string002")
    private String string02;
    @Localize(key = "navigation.item.string003")
    private String string03;
    @Localize(key = "navigation.item.string004")
    private String string04;
    @Localize(key = "navigation.item.string005")
    private String string05;

    public String getString01() {
        return string01;
    }

    public void setString01(String string01) {
        this.string01 = string01;
    }

    public String getString02() {
        return string02;
    }

    public void setString02(String string02) {
        this.string02 = string02;
    }

    public String getString03() {
        return string03;
    }

    public void setString03(String string03) {
        this.string03 = string03;
    }

    public String getString04() {
        return string04;
    }

    public void setString04(String string04) {
        this.string04 = string04;
    }

    public String getString05() {
        return string05;
    }

    public void setString05(String string05) {
        this.string05 = string05;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Navigation)) return false;
        Navigation that = (Navigation) o;
        return Objects.equals(string01, that.string01) &&
                Objects.equals(string02, that.string02) &&
                Objects.equals(string03, that.string03) &&
                Objects.equals(string04, that.string04) &&
                Objects.equals(string05, that.string05);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string01, string02, string03, string04, string05);
    }

    @Override
    public String toString() {
        return "Navigation{" +
                "string01='" + string01 + '\'' +
                ", string02='" + string02 + '\'' +
                ", string03='" + string03 + '\'' +
                ", string04='" + string04 + '\'' +
                ", string05='" + string05 + '\'' +
                '}';
    }
}
