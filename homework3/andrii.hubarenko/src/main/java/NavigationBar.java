import java.util.Objects;

public class NavigationBar {

    @LocalizedString(key = "navigationBar.item.file")
    private String file;

    @LocalizedString(key = "navigationBar.item.edit")
    private String edit;

    @LocalizedString(key = "navigationBar.item.view")
    private String view;

    @LocalizedString(key = "navigationBar.item.navigate")
    private String navigate;

    @LocalizedString(key = "navigationBar.item.code")
    private String code;

    @LocalizedString(key = "navigationBar.item.analyze")
    private String analyze;

    public String getFile() {
        return file;
    }

    public String getEdit() {
        return edit;
    }

    public String getView() {
        return view;
    }

    public String getNavigate() {
        return navigate;
    }

    public String getCode() {
        return code;
    }

    public String getAnalyze() {
        return analyze;
    }

    @Override
    public String toString() {
        return "NavigationBar{" +
                "file='" + file + '\'' +
                ", edit='" + edit + '\'' +
                ", view='" + view + '\'' +
                ", navigate='" + navigate + '\'' +
                ", code='" + code + '\'' +
                ", analyze='" + analyze + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NavigationBar that = (NavigationBar) o;
        return Objects.equals(file, that.file) &&
                Objects.equals(edit, that.edit) &&
                Objects.equals(view, that.view) &&
                Objects.equals(navigate, that.navigate) &&
                Objects.equals(code, that.code) &&
                Objects.equals(analyze, that.analyze);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, edit, view, navigate, code, analyze);
    }
}
