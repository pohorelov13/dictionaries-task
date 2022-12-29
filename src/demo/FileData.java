package demo;

import java.util.Objects;

public class FileData {
    private final String name;
    private final int size;
    private final String path;

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData data = (FileData) o;
        return size == data.size && Objects.equals(name, data.name) && Objects.equals(path, data.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, path);
    }

    public int getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    public FileData(String name, int size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    @Override
    public String toString() {
        return name;
    }
}