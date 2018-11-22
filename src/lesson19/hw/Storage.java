package lesson19.hw;

import java.util.Arrays;

public class Storage {
    private long id;
    private File[] files = new File[3];
    private String[] formatsSupported;
    private String storageCountry;
    private long storageSize;

    public Storage() {}

    public Storage(long id, String[] formatsSupported, String storageCountry, long storageSize) {
        this.id = id;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public Storage(long id, File[] files, String[] formatsSupported, String storageCountry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }

    public File getFileById(long id) {
        for (File file : files) {
            if (file != null && file.getId() == id)
                return file;
        }

        return null;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "files=" + Arrays.toString(files) +
                ", storageSize=" + storageSize +
                '}';
    }
}
