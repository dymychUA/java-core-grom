package lesson19.hw;

import java.util.Arrays;

public class Controller {
    public void put(Storage storage, File file) throws Exception {
        if (!storage.checkFileFormat(file.getFormat())) {
            throw new Exception("File format not supported! The Storage id = '" + storage.getId() + "'; File id = '" + file.getId() + "'");
        }

        if (storage.getFileById(file.getId()) != null) {
            throw new Exception("File with id = '" + file.getId() + "' is already present in the Storage id = '" + storage.getId() + "'");
        }

        long emptySpace = storage.getStorageSize() - getStorageUsedSize(storage);
        if (emptySpace < file.getSize()) {
            throw new Exception("There is no empty space (" + emptySpace + " KB.) in the Storage id = '" + storage.getId() + "'; File id = '" + file.getId() + "'; file size = '" + file.getSize() + "' KB.");
        }

        File[] files = storage.getFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = file;
                System.out.println("File id = '" + file.getId() + "' was added to the Storage id = '" + storage.getId() + "'");
                return;
            }
        }

        throw new Exception("File id = '" + file.getId() + "' was not added to the Storage id = '" + storage.getId() + "'. No free space.");
    }

    public void delete(Storage storage, File file) throws Exception {

        int fileIndex = findFileInStorage(storage, file);

        if (fileIndex == -1) {
            throw new Exception("File id = '" + file.getId() + "' was not found in the Storage id = '" + storage.getId() + "'");
        }

        storage.getFiles()[fileIndex] = null;
        System.out.println("File id = '" + file.getId() + "' was deleted from the Storage id = '" + storage.getId() + "'");
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        try {
            for (File storageFile : storageFrom.getFiles()) {
                transferFile(storageFrom, storageTo, storageFile.getId());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

        File file = storageFrom.getFileById(id);

        if (file == null) {
            throw new Exception("File id = '" + id + "' was not found in the Storage id = '" + storageFrom.getId() + "'");
        }

        try {
            put(storageTo, file);
            delete(storageFrom, file);
        } catch (Exception e) {
            throw new Exception("File with id '" + id + "' can not be transfered from Storage id '" + storageFrom.getId() + "' to Storage id '" + storageTo.getId() + "'");
        }
    }

    private int findFileInStorage(Storage storage, File file) {
        int i = 0;
        for (File storageFile : storage.getFiles()) {
            if (file.equals(storageFile)) {
                return i;
            }
            i++;
        }

        return -1;
    }

    private long getStorageUsedSize(Storage storage) {

        long size = 0;

        for (File storageFile : storage.getFiles()) {
            if (storageFile != null)
                size += storageFile.getSize();
        }

        return size;
    }
}
