import java.util.Objects;

public class NotebookSshop {
    private int id;
    private int RAM;
    private int HDDSize;
    private String OS;
    private String color;

    public NotebookSshop(int id, int RAM, int HDDSize, String OS, String color) {
        this.id = id;
        this.RAM = RAM;
        this.HDDSize = HDDSize;
        this.OS = OS;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public int getRAM() {
        return RAM;
    }

    public int getHDDSize() {
        return HDDSize;
    }

    public String getOS() {
        return OS;
    }

    public String getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setHDDSize(int HDDSize) {
        this.HDDSize = HDDSize;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NotebookSshop notebook = (NotebookSshop) obj;
        return id == notebook.id &&
                RAM == notebook.RAM &&
                HDDSize == notebook.HDDSize &&
                OS.equals(notebook.OS) &&
                color.equals(notebook.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, RAM, HDDSize, OS, color);
    }

}
