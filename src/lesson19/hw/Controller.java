package lesson19.hw;

import java.util.Arrays;

public class Controller {
    public File put(Storage storage, File file) throws Exception {
        if (!checkFileFormat(storage, file)) {
            throw new Exception("File format not supported! The Storage id = '" + storage.getId() + "'; File id = '" + file.getId() + "'");
        }

        if (checkIfExists(storage, file)) {
            throw new Exception("File with id = '" + file.getId() + "' is already present in the Storage id = '" + storage.getId() + "'");
        }

        if (!checkFreeSpase(storage, new File[] {file})) {
            throw new Exception("There is no empty space in the Storage id = '" + storage.getId() + "'; File id = '" + file.getId() + "'; file size = '" + file.getSize() + "'");
        }

        File[] files = storage.getFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = file;
                //System.out.println("File id = '" + file.getId() + "' was added to the Storage id = '" + storage.getId() + "'");
                return file;
            }
        }

        throw new Exception("File id = '" + file.getId() + "' was not added to the Storage id = '" + storage.getId() + "'. No free space in the storage.");
    }

    public void delete(Storage storage, File file) throws Exception {

        if (!checkIfExists(storage, file)) {
            throw new Exception("File id = '" + file.getId() + "' was not found in the Storage id = '" + storage.getId() + "'");
        }

        File[] files = storage.getFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i] != null && files[i].equals(file)) {
                files[i] = null;
                //System.out.println("File id = '" + file.getId() + "' was deleted from the Storage id = '" + storage.getId() + "'");
                return;
            }
        }

        throw new Exception("File id = '" + file.getId() + "' was not found in the Storage id = '" + storage.getId() + "'");
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {

        if (!checkFreeSpase(storageTo, storageFrom.getFiles()))
            throw new Exception("Storage id '" + storageFrom.getId() + "' can not be transfered to Storage id '" + storageTo.getId() + "'");

        for (File storageFile : storageFrom.getFiles()) {
            if (!canBeDeleted(storageFrom, storageFile) || !canBePutted(storageTo, storageFile))
                throw new Exception("Storage id '" + storageFrom.getId() + "' can not be transfered to Storage id '" + storageTo.getId() + "'");
        }

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

        if (!canBeDeleted(storageFrom, file) || !canBePutted(storageTo, file) || !checkFreeSpase(storageTo, new File[] {file})) {
            throw new Exception("File with id '" + id + "' can not be transfered from Storage id '" + storageFrom.getId() + "' to Storage id '" + storageTo.getId() + "'");
        }

        try {
            put(storageTo, file);
            delete(storageFrom, file);
        } catch (Exception e) {
            throw new Exception("File with id '" + id + "' can not be transfered from Storage id '" + storageFrom.getId() + "' to Storage id '" + storageTo.getId() + "'");
        }
    }

    private boolean checkFreeSpase(Storage storage, File[] files) {
        int filesCount = 0;
        long fileSize = 0;

        for (File file : files) {
            if (file != null)
                fileSize += file.getSize();
                filesCount++;
        }

        return ((storage.getStorageSize() - getStorageUsedSize(storage)) >= fileSize && filesCount <= getStorageFreeCells(storage));
    }

    private boolean checkIfExists(Storage storage, File file) {
        return storage.getFileById(file.getId()) != null;
    }

    private boolean checkFileFormat(Storage storage, File file) {

        String format = file.getFormat();

        for (String fileFormat : storage.getFormatsSupported()) {
            if (fileFormat.equals(format))
                return true;
        }

        return false;
    }

    private boolean canBePutted(Storage storage, File file) {
        return checkFileFormat(storage, file) && !checkIfExists(storage, file);
    }

    private boolean canBeDeleted(Storage storage, File file) {
        for (File storageFile : storage.getFiles()) {
            if (storageFile != null && storageFile.equals(file))
                return true;
        }

        return false;
    }

    private long getStorageUsedSize(Storage storage) {

        long size = 0;

        for (File storageFile : storage.getFiles()) {
            if (storageFile != null)
                size += storageFile.getSize();
        }

        return size;
    }

    private int getStorageFreeCells(Storage storage) {
        int freeCells = 0;

        for (File file : storage.getFiles()) {
            if (file == null)
                freeCells++;
        }

        return freeCells;
    }
}
